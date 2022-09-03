package mainfiles;

import javax.swing.JFrame;


public class Main {
    
    public static void main(String args[]){

        // create a JFrame object
        JFrame gameWindow = new JFrame();

        // construct gamePanel object
        GamePanel gamePanel = new GamePanel();
        


        gameWindow.setTitle("Code Man!"); // set name of game
        gameWindow.setResizable(false); // restrict resizing of window
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit program when close
        gameWindow.setVisible(true); // allow us to see window

        gameWindow.add(gamePanel);

        
        // sizes frame to preferred size
        gameWindow.pack();

        gameWindow.setLocationRelativeTo(null); // center window

        gamePanel.priorToGame();

        // start the gameloop
        gamePanel.threadStart();











    }

}
