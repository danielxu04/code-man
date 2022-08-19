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
	int maxCol = gamePanel.colTiles;
	int maxRow = gamePanel.rowTiles;
	int tileSize = gamePanel.tileDimension;
	
	// map
	int mapMatrix[][] = new int[maxCol][maxRow];
	
	
	// gameTileController constructor
	public GameTileController(GamePanel gamePanel) {
		
		this.gamePanel = gamePanel;
		
		getTileImg();
		
	}
	
	// create GameTile objects and modify their tileImage attribute, pushback in ArrayList
	public void getTileImg() {
		
		try {
			// add all GameTile objects to ArrayList
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
			
			/*
			int c= 0, r = 0;
			
			while(c < maxCol && r < maxRow) {
				
				String rowRender = br.readLine();
				
				for(; c < maxCol; c++) {
					
					String tileIndex[] = rowRender.split(" ");
					
					int currTile = Integer.parseInt(tileIndex[c]);
					
					mapMatrix[c][r] = currTile;
				}
				
				if(c == maxCol) {
					c = 0;
					r++;
				}
			}
			*/
			
			
			for(int r = 0, c = 0; r < maxRow;) {
				String rowRender = br.readLine();
				
				for(; c < maxCol; c++) {
					
					String tileIndex[] = rowRender.split(" ");
					
					int currTile = Integer.parseInt(tileIndex[c]);
					
					mapMatrix[c][r] = currTile;
				}
				
				if(c == maxCol) {
					c = 0;
					r++;
				}
			}
			
		}catch(Exception e){
			
		}
	}
	// display tile
	public void display(Graphics2D g2D) {
		
		// draw first tile in top left corner
		g2D.drawImage(tileList.get(0).tileImage, 0, 0, tileSize, tileSize, null);	
	}
	
	
}
