package figures;

import mainfiles.GamePanel;
import mainfiles.KeyboardInput;

import java.awt.Graphics2D;
import java.awt.Color;

// class for the main character
public class Character extends Figure{
    
    GamePanel gamePanel;
    KeyboardInput keyIn;

    // constructor for character
    public Character(GamePanel g, KeyboardInput k){
        this.gamePanel = g;
        this.keyIn = k;
        this.xPt = 150;
        this.yPt = 150;
        this.sp = 5;
    }

    public void movement(){

        if(keyIn.up == true){
            yPt -= sp;
        }
        else if(keyIn.left == true){
            xPt -= sp;
        }
        else if(keyIn.down == true){
            yPt += sp;
        }
        else if(keyIn.right == true){
            xPt += sp;
        }
    }


    public void draw(Graphics2D g2D){

        // create a tester rectangle

        g2D.setPaint(Color.pink);
        
        g2D.fillRect(xPt, yPt, gamePanel.tileDimension, gamePanel.tileDimension*2);
    }
}
