package gametiles;

import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import mainfiles.GamePanel;

public class GameTileController {
	
	// instantiate GamePanel
	GamePanel gamePanel;
	
	// create an arraylist to store tiles 
	// require resizable array - not sure how many tiles will be used
	ArrayList<GameTile> tileList = new ArrayList<GameTile>();
	
	
	public GameTileController(GamePanel gamePanel) {
		
		this.gamePanel = gamePanel;
		
		getTileImg();
		
	}
	
	public void getTileImg() {
		
		try {
			
			// create GameTile objects and modify their tileImage attribute, pushback in ArrayList
			
			// FLOOR TILE
			tileList.set(0, new GameTile());
			tileList.get(0).tileImage = ImageIO.read(getClass().getResourceAsStream("/world/Floor.png"));
			
			// CHEMICAL LIQUID TILE
			tileList.set(1, new GameTile());
			tileList.get(1).tileImage = ImageIO.read(getClass().getResourceAsStream("/world/Chemical.png"));
			
			// WALL-1 (RED) TILE
			tileList.set(2, new GameTile());
			tileList.get(2).tileImage = ImageIO.read(getClass().getResourceAsStream("/world/Wall-1.png"));
			
			// WALL-2 (PURPLE) TILE
			tileList.set(3, new GameTile());
			tileList.get(3).tileImage = ImageIO.read(getClass().getResourceAsStream("/world/Wall-2.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
