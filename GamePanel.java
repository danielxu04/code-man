import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    
    /*************** SCREEN SETTINGS *****************/ 

    // tile size (px)
    final int tileDimension = 48;

    // grid 21 x 15 (tile)
    final int colTiles = 21;
    final int rowTiles = 15;

    // dimensions of screen (px)
    final int screenX = tileDimension*colTiles;
    final int screenY = tileDimension*rowTiles;



    /*************** GAME PANEL CONSTRUCTOR *****************/ 

    public GamePanel(){
        
        this.setPreferredSize(new Dimension(screenX, screenY)); // set screen dimensions
        this.setBackground(Color.black); // set background color to black

    }


}
