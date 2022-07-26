package figures;

import main.GamePanel;
import main.KeyboardInput;

// class for the main character
public class Character extends Figure{
    
    GamePanel gP;
    KeyboardInput keyIn;

    // constructor for character
    public Character(GamePanel g, KeyboardInput k){
        this.gP = g;
        this.keyIn = k;
    }
}
