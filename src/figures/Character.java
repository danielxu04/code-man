package figures;

import mainfiles.GamePanel;
import mainfiles.KeyboardInput;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;


// class for the main character
public class Character extends Figure{
    
    GamePanel gamePanel;
    KeyboardInput keyIn;

	// x and y positions of the player 
	// this will differ from the screen dimensions because our camera centers the player in the middle of the screen
	public int playerPosX;
	public int playerPosY;

    // constructor for character
    public Character(GamePanel g, KeyboardInput k){
        this.gamePanel = g;
        this.keyIn = k;
        this.movementDirection = 'd';
        this.xPt = 480;
        this.yPt = 144;
        this.sp = 4;
		// solid region for main character
		// cant be full tilesize or else it would be painful to navigate through tight spaces
		this.solidRegion = new Rectangle(9, 18, 30, 30);
		// mutable solid region coordindate variables
		this.solidX = solidRegion.x;
		this.solidY = solidRegion.y;

		// display player in center of the screen
		this.playerPosX = gamePanel.screenX / 2 - gamePanel.tileDimension/2;
		this.playerPosY = gamePanel.screenY / 2 - gamePanel.tileDimension/2;
        getCharacterImg();
    }
    
    
    public void getCharacterImg(){
    	
    	try {
    		
    		// load all the images with ImageIO
        	f1 = ImageIO.read(getClass().getResourceAsStream("/character/codeman_f1.png"));
        	f2 = ImageIO.read(getClass().getResourceAsStream("/character/codeman_f2.png"));
        	l1 = ImageIO.read(getClass().getResourceAsStream("/character/codeman_l1.png"));
        	l2 = ImageIO.read(getClass().getResourceAsStream("/character/codeman_l2.png"));
        	b1 = ImageIO.read(getClass().getResourceAsStream("/character/codeman_b1.png"));
        	b2 = ImageIO.read(getClass().getResourceAsStream("/character/codeman_b2.png"));
        	r1 = ImageIO.read(getClass().getResourceAsStream("/character/codeman_r1.png"));
        	r2 = ImageIO.read(getClass().getResourceAsStream("/character/codeman_r2.png"));   		
    		
        // catch IOException
    	}catch(IOException e) {
    		e.printStackTrace();
    	}

    	
    }

    // a player method for movement 
    public void movement(){

		// increment spriteLooper
		spriteLooper++;

		// if wasd is pressed - this solves issue of automatically moving character
		if(keyIn.up || keyIn.left || keyIn.down || keyIn.right){

			// detects direction from keyboard input
			// updates movementDirection of character
			if(keyIn.up == true){
				movementDirection = 'u';
			}
			else if(keyIn.left == true){
				movementDirection = 'l';
			}
			else if(keyIn.down == true){
				movementDirection = 'd';
			}
			else if(keyIn.right == true){
				movementDirection = 'r';
			}
		
			isCollision = false; 
			gamePanel.collisionChecker.CollisionChecker(this); // pass this main character class into the collision checker method
	
			// if no collision, allow character to move
			// passes through updated movementDirection variable from direction detector above
			if(isCollision == false){

				switch(movementDirection){
					case 'u':
						yPt -= sp;
						break;
					case 'l':
						xPt -= sp;
						break;
					case 'd':
						yPt += sp;
						break;
					case 'r':
						xPt += sp;
						break;
				}
			}

		}
		
        // if movement is called more than 12 times, change true -> false OR false -> true
		if(spriteLooper > 12) {
			if(spriteDisplay) {
				spriteDisplay = false;
			}
			else {
				spriteDisplay = true;
			}
				
			// reset the counter
			spriteLooper = 0;
		}
    }

    
    // draws our character 
    public void display(Graphics2D g2D){

    	BufferedImage characterImg = null;
    	
    	// display a certain sprite image depending on key pressed/movement direction
    	
    	// if boolean variable spriteDisplay is true, display first sprite image; if false, display second sprite image (this will loop)
    	switch(movementDirection) {
    	case 'u':
    		if(spriteDisplay) {
    			characterImg = b1;
    		}
    		else {
    			characterImg = b2;
    		}
    		break;
    	case 'l':
    		if(spriteDisplay) {
    			characterImg = l1;
    		}
    		else {
    			characterImg = l2;
    		}
    		break;
    	case 'd':
    		if(spriteDisplay) {
    			characterImg = f1;
    		}
    		else {
    			characterImg = f2;
    		}
    		break;
    	case 'r':
    		if(spriteDisplay) {
        		characterImg = r1;
    		}
    		else {
        		characterImg = r2;
    		}

    		break;
    	}
    	
    	// draw image with respect to x, y values and gamePanel
    	g2D.drawImage(characterImg, playerPosX, playerPosY, gamePanel.tileDimension, gamePanel.tileDimension, null);
    }
}
