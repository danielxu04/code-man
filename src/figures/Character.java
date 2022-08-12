package figures;

import mainfiles.GamePanel;
import mainfiles.KeyboardInput;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


// class for the main character
public class Character extends Figure{
    
    GamePanel gamePanel;
    KeyboardInput keyIn;

    // constructor for character
    public Character(GamePanel g, KeyboardInput k){
        this.gamePanel = g;
        this.keyIn = k;
        this.movementDirection = 'u';
        this.xPt = 150;
        this.yPt = 150;
        this.sp = 5;
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

    // a player method for movement - alters xy position of character
    // updates movementDirection of character
    public void movement(){
    	

        if(keyIn.up == true){
        	movementDirection = 'u';
            yPt -= sp;
        }
        else if(keyIn.left == true){
        	movementDirection = 'l';
            xPt -= sp;
        }
        else if(keyIn.down == true){
        	movementDirection = 'd';
            yPt += sp;
        }
        else if(keyIn.right == true){
        	movementDirection = 'r';
            xPt += sp;
        }
    }

    
    // draws our character 
    public void display(Graphics2D g2D){

    	BufferedImage characterImg = null;
    	
    	// display a certain sprite image depending on key pressed/movement direction
    	switch(movementDirection) {
    	case 'u':
    		characterImg = b1;
    		break;
    	case 'l':
    		characterImg = l1;
    		break;
    	case 'd':
    		characterImg = f1;
    		break;
    	case 'r':
    		characterImg = r1;
    		break;
    	}
    	
    	// draw image with respect to x, y values and gamePanel
    	g2D.drawImage(characterImg, xPt, yPt, gamePanel.tileDimension, gamePanel.tileDimension, null);
    }
}
