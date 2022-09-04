package item;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Graphics2D;
import mainfiles.GamePanel;
import java.awt.Rectangle;
import javax.imageio.ImageIO;

public class Item {
	
	public BufferedImage itemImg; // stores item img
	public BufferedImage tempImage; // temporary image for imageReader method

	public String itemName;	// name of item
	
	public int xPt, yPt; // coordinates of item


	public boolean isCollision; // if sprite collides with item

	public Rectangle solidRegion = new Rectangle(0, 0, 48, 48);
	public int objectX = solidRegion.x;
	public int objectY = solidRegion.y;
 
	// method to read an image
	public BufferedImage imageReader(String filePath){
		try{
			tempImage = ImageIO.read(getClass().getResourceAsStream(filePath));
		}catch(IOException e){
			e.printStackTrace();
		}

		return tempImage;
	}

	// method to draw items/objects onto screen
	public void drawObjects(Graphics2D g2D, GamePanel gamePanel){

		// constantly changing map draw position, taking into account the player's position and offsetting the differences
		int drawX = xPt - gamePanel.mainCharacter.xPt + gamePanel.mainCharacter.playerPosX;
		int drawY = yPt - gamePanel.mainCharacter.yPt + gamePanel.mainCharacter.playerPosY;
					
		// draw the tileImage of the current tile at its position
		g2D.drawImage(itemImg, drawX, drawY, gamePanel.tileDimension, gamePanel.tileDimension, null);

	}
}
