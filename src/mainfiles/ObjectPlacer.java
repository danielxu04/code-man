package mainfiles;

import item.Door;
import item.Key;

public class ObjectPlacer {
    
    GamePanel gamePanel;

    int tileDimension = gamePanel.tileDimension;

    public ObjectPlacer(GamePanel gamePanel){

        this.gamePanel = gamePanel;
    }


    // function to store items inside itemsDisplayed array and place them on the map
    public void placeObject() {

        // create new key object
        gamePanel.itemsDisplayed[0] = new Key();
        gamePanel.itemsDisplayed[0].xPt = 10*tileDimension;
        gamePanel.itemsDisplayed[0].yPt = 1*tileDimension;

        // create new door object
        gamePanel.itemsDisplayed[1] = new Door();
        gamePanel.itemsDisplayed[1].xPt = 9*tileDimension;
        gamePanel.itemsDisplayed[1].yPt = 14*tileDimension;

        gamePanel.itemsDisplayed[2] = new Door();
        gamePanel.itemsDisplayed[2].xPt = 10*tileDimension;
        gamePanel.itemsDisplayed[2].yPt = 14*tileDimension;

        gamePanel.itemsDisplayed[3] = new Door();
        gamePanel.itemsDisplayed[3].xPt = 11*tileDimension;
        gamePanel.itemsDisplayed[3].yPt = 14*tileDimension;
        
    }
}
