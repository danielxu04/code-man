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


    /*************** PLAYER SETTINGS *****************/ 

    int x = 80;
    int y = 80;

    int speed = 5;
    

    /*************** GAME LOOP *****************/ 

    int nsFactor = 1000000000; // 1s = 10^9ns
    int fpsCap = 60; // cap our fps at 60

    double timeSpan = nsFactor/fpsCap; // # of time required for each frame
    long lastTime;
    long curTime;
    long timePassed;
    double delta = 0;
    


    /*************** Instantiate *****************/ 

    Thread thread;  // executed by a thread - start-stop functionality 
    KeyboardInput keyIn = new KeyboardInput(); // keyboard input object



    /*************** GAME PANEL CONSTRUCTOR *****************/ 

    public GamePanel(){
        
        this.setPreferredSize(new Dimension(screenX, screenY)); // set screen dimensions
        this.setBackground(Color.black); // set background color to black
        this.addKeyListener(keyIn); // add our key listener object to game panel
        this.setFocusable(true); // game panel focused to receive key input

        this.setDoubleBuffered(true); // improves rendering performance

    }


    // start the thread - automatically calls run method which will contain game loop
    public void threadStart() {
        thread = new Thread(this);
        thread.start();
    }


    // update and draw - game loop essentials
    public void screenUpdate(){

        if(keyIn.up == true){
            y -= speed;
        }
        else if(keyIn.left == true){
            x -= speed;
        }
        else if(keyIn.down == true){
            y += speed;
        }
        else if(keyIn.right == true){
            x += speed;
        }
    }
    public void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        // change graphics to a Graphics2D object - "upgrades functionality" for geometry, transformation, colors, text layout
        Graphics2D testObj = (Graphics2D)graphics;

        // create a tester rectangle

        testObj.setPaint(Color.pink);
        
        testObj.fillRect(x, y, tileDimension, tileDimension*2);

        testObj.dispose(); // release system resources being used
    }



    // GAME LOOP
    public void run() {
        while(thread != null){
            // System.out.println("WORKING!");
        
            curTime = System.nanoTime(); // express current time in nanoseconds
            
            timePassed = curTime - lastTime; // difference between current time and last updated time = time passed

            delta += (timePassed / timeSpan); // add timePassed divided by time interval to delta (most times time passed will be less than time interval allotted)

            lastTime = curTime; // update lastTime with the current time

            // once delta reaches 1, in other words, when timePassed is equal to timeSpan (time interval)
            // update the screen, paint the screen
            if(delta >= 1){
                screenUpdate();
                repaint(); // calls paintComponent method
                delta = 0; // set delta back to 0 so we can repeat this process
            }
            
        }
    }


}
