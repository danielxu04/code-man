package item;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Key extends Item{
    

    public Key(){
        // set name to Key
        itemName = "Key";
        // Read the 'Key' image
        itemImg = imageReader("/objects/Key.png");


    }
}
