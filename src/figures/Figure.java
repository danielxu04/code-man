package figures;

import java.awt.image.BufferedImage;
import java.awt.Rectangle;


// parent class for all figures
public class Figure {

	// x, y coordinates of figure, speed of figure
    public int xPt, yPt, sp;
    
    // implement a looper counter to regulate how often the character sprite will change
    public int spriteLooper = 0;
    
    // boolean variable will decide which player sprite is displayed (two sprites for each direction, hence use true/false)
    public boolean spriteDisplay = true; 
    
    
    // describes images w accessible buffer of image data
    public BufferedImage f1;
    public BufferedImage f2;
    public BufferedImage l1;
    public BufferedImage l2;
    public BufferedImage b1;
    public BufferedImage b2;
    public BufferedImage r1;
    public BufferedImage r2;
    
    public char movementDirection; // use characters 'u, l, d, r' to signify 'up, left, down, right'

    // the solid region of figure sprite - we dont want the entire tile to be solid
    public Rectangle solidRegion;

    public int solidX;
    public int solidY;

    // boolean storing if a collision has occured
    public boolean isCollision;
}
