package gametiles;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import mainfiles.GamePanel;

public class GameTileController {
	
	// instantiate GamePanel
	GamePanel gamePanel;
	
	// create an arraylist to store tiles 
	// require resizable array - not sure how many tiles will be used
	ArrayList<GameTile> tileList = new ArrayList<GameTile>();
	
	// to store max size of gamePanel
	int screenCol;
	int screenRow;
	int tileSize;

	// to store max size of world
	int worldCol;
	int worldRow;
	
	// map variables
	int mapMatrix[][];
	
	
	// gameTileController constructor
	public GameTileController(GamePanel gamePanel) {
		
		this.gamePanel = gamePanel;

		// resize map matrix to size of the world map
		this.mapMatrix = new int[gamePanel.worldCols][gamePanel.worldRows];

		// size of screen
		this.screenCol = gamePanel.colTiles;
		this.screenRow = gamePanel.rowTiles;

		// size of world
		this.worldCol = gamePanel.worldCols;
		this.worldRow = gamePanel.worldRows;

		// tile size
		this.tileSize = gamePanel.tileDimension;

		getTileImg();
		
		mapLoader();
		
	}
	
	// create GameTile objects and modify their tileImage attribute, pushback in ArrayList
	public void getTileImg() {
		
		try {
			// add all GameTile objects to ArrayList
			tileList.add(new GameTile());
			tileList.add(new GameTile());
			tileList.add(new GameTile());
			tileList.add(new GameTile());
			tileList.add(new GameTile());
			tileList.add(new GameTile());
			
			
			// FLOOR TILE			
			tileList.get(0).tileImage = ImageIO.read(getClass().getResourceAsStream("/world/Floor.png"));
			tileList.get(0).tileCollision = false;
			
			// CHEMICAL LIQUID TILE
			tileList.get(1).tileImage = ImageIO.read(getClass().getResourceAsStream("/world/Chemical.png"));
			tileList.get(1).tileCollision = false;
			
			// WALL-1 (RED) TILE
			tileList.get(2).tileImage = ImageIO.read(getClass().getResourceAsStream("/world/Wall-1.png"));
			tileList.get(2).tileCollision = true;
			
			// WALL-2 (PURPLE) TILE
			tileList.get(3).tileImage = ImageIO.read(getClass().getResourceAsStream("/world/Wall-2.png"));
			tileList.get(3).tileCollision = true;
			
			// TREE TILE
			tileList.get(4).tileImage = ImageIO.read(getClass().getResourceAsStream("/world/Tree.png"));
			tileList.get(4).tileCollision = true;
			
			// BUSH TILE
			tileList.get(5).tileImage = ImageIO.read(getClass().getResourceAsStream("/world/Bush.png"));
			tileList.get(5).tileCollision = false;
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// function to load the map
	public void mapLoader() {
		try {
			// import text file
			InputStream is = getClass().getResourceAsStream("/map/worldmap.txt");
			// read text file
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			//System.out.println("loading");
			
			// loop until we have reached max rows
			for(int r = 0, c = 0; r < worldRow;) {
				// render the entire row
				String rowRender = br.readLine();
				
				// for the row, iterate through each column, store each tile index into the matrix
				for(; c < worldCol; c++) {
					
					String tileIndex[] = rowRender.split(" ");
					
					int currTile = Integer.parseInt(tileIndex[c]);
					
					mapMatrix[c][r] = currTile;
				}
				// if column counter is larger or equal to the max columns, reset column to 0 and increment row counter
				if(c >= worldCol) {
					c = 0;
					r++;
				}
			} 
			
			//System.out.println("loaded: " + mapMatrix[69][59]);
			
		}catch(Exception e){
			
		}
	}
	// display tile
	public void display(Graphics2D g2D) {
		
		int col = 0, row = 0;
		
		// while map isnt fully drawn
		while(col < worldCol && row < worldRow) {
			
			//System.out.println("Displaying");
			
			// access current tile index
			int currTile = mapMatrix[col][row];

			// CAMERA VARIABLES
			// xy measurement by pixel
			int mapX = col * tileSize;
			int mapY = row * tileSize;
			
			// constantly changing map draw position, taking into account the player's position and offsetting the differences
			int drawX = mapX - gamePanel.mainCharacter.xPt + gamePanel.mainCharacter.playerPosX;
			int drawY = mapY - gamePanel.mainCharacter.yPt + gamePanel.mainCharacter.playerPosY;
			
			//System.out.println(tileList.get(currTile));
			
			// draw the tileImage of the current tile at its position
			g2D.drawImage(tileList.get(currTile).tileImage, drawX, drawY, tileSize, tileSize, null);
			// move to next column
			col++;			

			// if we have reached the rightmost side of the map
			if(col == worldCol) {
				// reset our col index value
				col = 0;
				// increment our row index value
				row++;	
			}
		}
	}
	
	
}
