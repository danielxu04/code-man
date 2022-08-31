package item;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Item {
	
	public BufferedImage itemImg; // stores item img
	public BufferedImage tempImage; // temporary image for imageReader method

	public String itemName;	// name of item
	
	public int xPt, yPt; // coordinates of item



	public boolean isCollision; // if sprite collides with item


	// method to read an image
	public BufferedImage imageReader(String filePath){
		try{
			tempImage = ImageIO.read(getClass().getResourceAsStream(filePath));
		}catch(IOException e){
			e.printStackTrace();
		}

		return tempImage;
	}
	
}
