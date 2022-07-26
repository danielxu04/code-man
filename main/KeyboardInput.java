import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener{

    // int var to store ascii codes of pressed keys
    public int ascii;
    // booleans to verify when a key is pressed/released
    public boolean up, down, right, left;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // check to see whether wasd are pressed
    @Override
    public void keyPressed(KeyEvent e) {
        
        ascii = e.getKeyCode();

        if(ascii == KeyEvent.VK_W){
            up = true;
        }
        else if(ascii == KeyEvent.VK_A){
            left = true;
        }
        else if(ascii == KeyEvent.VK_S){
            down = true;
        }
        else if(ascii == KeyEvent.VK_D){
            right = true;
        }
    }

    
    @Override // check to see when wasd is released
    public void keyReleased(KeyEvent e) {

        if(ascii == KeyEvent.VK_W){
            up = false;
        }
        else if(ascii == KeyEvent.VK_A){
            left = false;
        }
        else if(ascii == KeyEvent.VK_S){
            down = false;
        }
        else if(ascii == KeyEvent.VK_D){
            right = false;
        }
        
    }
    
}
