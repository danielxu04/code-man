import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D; // child of graphics

public class GamePanel extends JPanel implements Runnable{
    
    /*************** SCREEN SETTINGS *****************/ 

    // tile size (px)
    final int tileDimension = 48;

    // grid 21 x 15 (tile)
    final int colTiles = 21;
    final int rowTiles = 15;

    // dimensions of screen (px)
    final int screenX = tileDimension*colTiles;
    final int screenY = tileDimension*rowTiles;
    

    /*************** Instantiate *****************/ 

    Thread thread;  // executed by a thread - start-stop functionality 



    /*************** GAME PANEL CONSTRUCTOR *****************/ 

    public GamePanel(){
        
        this.setPreferredSize(new Dimension(screenX, screenY)); // set screen dimensions
        this.setBackground(Color.black); // set background color to black

    }


    // start the thread - automatically calls run method which will contain game loop
    public void threadStart() {
        thread = new Thread(this);
        thread.start();
    }


    // update and draw - game loop essentials
    public void screenUpdate(){

    }
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        // change graphics to a Graphics2D object - "upgrades functionality" for geometry, transformation, colors, text layout
        Graphics2D testObj = (Graphics2D)graphics;

        // create a tester polygon

        testObj.setPaint(Color.pink);
        
        int[] xPts = {100, 120, 140};
        int[] yPts = {200, 170, 200};

        testObj.fillPolygon(xPts, yPts, 3);

        testObj.dispose(); // release system resources being used
    }



    // GAME LOOP
    public void run() {
        while(thread != null){
            // System.out.println("WORKING!");

            screenUpdate();

            repaint(); // calls paintComponent method
        }
    }


}
