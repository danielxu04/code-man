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
	int maxCol;
	int maxRow;
	int tileSize;
	
	// map variables
	int mapMatrix[][];
	
	
	// gameTileController constructor
	public GameTileController(GamePanel gamePanel) {
		
		this.gamePanel = gamePanel;
		this.mapMatrix = new int[gamePanel.colTiles][gamePanel.rowTiles];
		this.maxCol = gamePanel.colTiles;
		this.maxRow = gamePanel.rowTiles;
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
			
			// CHEMICAL LIQUID TILE
			tileList.get(1).tileImage = ImageIO.read(getClass().getResourceAsStream("/world/Chemical.png"));
			
			// WALL-1 (RED) TILE
			tileList.get(2).tileImage = ImageIO.read(getClass().getResourceAsStream("/world/Wall-1.png"));
			
			// WALL-2 (PURPLE) TILE
			tileList.get(3).tileImage = ImageIO.read(getClass().getResourceAsStream("/world/Wall-2.png"));
			
			// TREE TILE
			tileList.get(4).tileImage = ImageIO.read(getClass().getResourceAsStream("/world/Tree.png"));
			
			// BUSH TILE
			tileList.get(5).tileImage = ImageIO.read(getClass().getResourceAsStream("/world/Bush.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void mapLoader() {
		
		try {
			// import text file
			InputStream is = getClass().getResourceAsStream("/map/map1.txt");
			// read text file
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			//System.out.println("loading");
			
			
			// loop until we have reached max rows
			for(int r = 0, c = 0; r < maxRow;) {
				
				// render the entire row
				String rowRender = br.readLine();
				
				// for the row, iterate through each column, store each tile index into the matrix
				for(; c < maxCol; c++) {
					
					String tileIndex[] = rowRender.split(" ");
					
					int currTile = Integer.parseInt(tileIndex[c]);
					
					mapMatrix[c][r] = currTile;
				}
				// if column counter is larger or equal to the max columns, reset column to 0 and increment row counter
				if(c >= maxCol) {
					c = 0;
					r++;
				}
			} 
			
			
			// System.out.println("loaded: " + mapMatrix[14][13]);
		}catch(Exception e){
			
		}
	}
	// display tile
	public void display(Graphics2D g2D) {
		
		int col = 0, row = 0, x = 0, y = 0;
		
		// draw first tile in top left corner
		//g2D.drawImage(tileList.get(0).tileImage, 0, 0, tileSize, tileSize, null);	
		
		// while map isnt fully drawn
		while(col < maxCol && row < maxRow) {
			
			//System.out.println("Displaying");
			
			// access current tile index
			int currTile = mapMatrix[col][row];
			
			//System.out.println(tileList.get(currTile));
			
			// draw the tileImage of the current tile at its position
			g2D.drawImage(tileList.get(currTile).tileImage, x, y, tileSize, tileSize, null);
			// move to next column
			col++;			
			// increase x position by the size of a tile (ensures no spaces in between tiles)
			x += tileSize;

			// if we have reached the rightmost side of the map
			if(col == maxCol) {
				// increase our y value (move down) by the tilesize (48)
				y += tileSize;
				// reset our x value, our position back at leftmost side of map
				x = 0;
				// reset our col index value
				col = 0;
				// increment our row index value
				row++;	
			}
			
		}
	}
	
	
}
