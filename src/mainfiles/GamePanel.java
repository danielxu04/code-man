package mainfiles;

import figures.Character;
import gametiles.GameTileController;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D; // child of graphics

public class GamePanel extends JPanel implements Runnable{
    

	/*************** SCREEN SETTINGS *****************/ 

    // tile size (px)
    public final int tileDimension = 48;

    // grid 21 x 15 (tile)
    public final int colTiles = 21;
    public final int rowTiles = 15;

    // dimensions of screen (px)
    public final int screenX = tileDimension*colTiles;
    public final int screenY = tileDimension*rowTiles;


    /*************** GAME LOOP VARIABLES *****************/ 

    int nsFactor = 1000000000; // 1s = 10^9ns
    int fpsCap = 60; // cap our fps at 60

    double timeSpan = nsFactor/fpsCap; // # of time required for each frame
    long lastTime;
    long curTime;
    long timePassed;
    double delta = 0;
    
    /*************** World *****************/ 

    public int worldCols = 70; // 70 tile columns
    public int worldRows = 60; // 60 tile rows
    public int worldPixelHor = worldCols * tileDimension; // convert horizontal tile size to px
    public int worldPixelVert = worldRows * tileDimension; // convert vertical tile size to px

    /*************** Instantiations *****************/ 

    Thread thread;  // executed by a thread - start-stop functionality 
    KeyboardInput keyIn = new KeyboardInput(); // keyboard input object
    public Character mainCharacter = new Character(this, keyIn); // instantiate Character, parameters are this gamePanel object and keyIn KeyboardInput object
    GameTileController controller = new GameTileController(this); // instantiate GameTileController, parameter is this gamePanel object - will draw the gameTiles



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

    	// call movement method to maincharacter and update player movement
        mainCharacter.movement();

    }
    
    public void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        // change graphics to a Graphics2D object - "upgrades functionality" for geometry, transformation, colors, text layout
        Graphics2D graphics2d = (Graphics2D)graphics;
        
        // draw tiles before player so that tiles are underneath player
        controller.display(graphics2d);
        
        // call the display method of mainCharacter - draws main character
        mainCharacter.display(graphics2d);


        graphics2d.dispose(); // release system resources being used
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
