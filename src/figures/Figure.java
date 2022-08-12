package figures;

import java.awt.image.BufferedImage;


// parent class for all figures
public class Figure {

	// x, y coordinates of figure, speed of figure
    public int xPt, yPt, sp;
    
    // describes images w accessible buffer of image data
    public BufferedImage f1, f2, l1, l2, b1, b2, r1, r2;
    
    public char movementDirection; // use characters 'u, l, d, r' to signify 'up, left, down, right'
}
