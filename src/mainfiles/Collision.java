package mainfiles;

import figures.Figure;

public class Collision { 

    // instantiate gamePanel
    GamePanel gamePanel;

    // instance variables
    int tileDimension;
    int leftX, rightX, topY, botY;
    int leftColumn, rightColumn, topRow, botRow;
    
    public Collision(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        this.tileDimension = gamePanel.tileDimension;
    }

    // function to divide a value by the tile dimension (used to simplify repeated tasks)
    public int divideByTileDimension(int val){
        return val/tileDimension;
    }

    // method to check collision
    public void CollisionChecker(Figure fig){
        
        // top left corner of figure + x margin of solid region - left x coordinate of the character's solid region
        leftX = fig.xPt + fig.solidRegion.x;

        // top left corner of figure + x margin of solid region + width of solid region - right x coordinate of the character's solid region
        rightX = fig.xPt + fig.solidRegion.x + fig.solidRegion.width;

        // top of figure + y margin of solid region - top y coordinate of the character's soid region
        topY = fig.yPt + fig.solidRegion.y;

        // top of figure + y margin of solid region + height of solid region - bottom y coordinate of the character's solid region
        botY = fig.yPt + fig.solidRegion.y + fig.solidRegion.height;

        // convert pixels to tiles for columns and rows
        leftColumn = divideByTileDimension(leftX);
        rightColumn = divideByTileDimension(rightX);
        topRow = divideByTileDimension(topY);
        botRow = divideByTileDimension(botY);

        int tileA, tileB;

        switch(fig.movementDirection){
            case 'u':
                // update topRow to subtract speed so that figure does not move anymore
                topRow = divideByTileDimension((topY - fig.sp));
                // check top left corner
                tileA = gamePanel.controller.mapMatrix[leftColumn][topRow];
                // check top right corner
                tileB = gamePanel.controller.mapMatrix[rightColumn][topRow];
                // if tileCollision is true for either tileA or tileB, then that means there is a collision between tiles
                if(gamePanel.controller.tileList.get(tileA).tileCollision || gamePanel.controller.tileList.get(tileB).tileCollision){
                    fig.isCollision = true;
                } // if false, we can just leave isCollision how it is - false
                break;
            case 'l':
                 // update topRow to subtract speed so that figure does not move anymore
                 leftColumn = divideByTileDimension((leftX - fig.sp));
                 // check top left corner
                 tileA = gamePanel.controller.mapMatrix[leftColumn][topRow];
                 // check bottom left corner
                 tileB = gamePanel.controller.mapMatrix[leftColumn][botRow];
                 // if tileCollision is true for either tileA or tileB, then that means there is a collision between tiles
                 if(gamePanel.controller.tileList.get(tileA).tileCollision || gamePanel.controller.tileList.get(tileB).tileCollision){
                     fig.isCollision = true;
                 } // if false, we can just leave isCollision how it is - false            
                break;
            case 'd':
                // update topRow to 'add speed' so that figure does not move anymore
                botRow = divideByTileDimension((botY + fig.sp));
                // check bottom left corner
                tileA = gamePanel.controller.mapMatrix[leftColumn][botRow];
                // check bottom right corner
                tileB = gamePanel.controller.mapMatrix[rightColumn][botRow];
                // if tileCollision is true for either tileA or tileB, then that means there is a collision between tiles
                if(gamePanel.controller.tileList.get(tileA).tileCollision || gamePanel.controller.tileList.get(tileB).tileCollision){
                    fig.isCollision = true;
                } // if false, we can just leave isCollision how it is - false       
                break;
            case 'r':
                // update topRow to 'add speed' so that figure does not move anymore
                rightColumn = divideByTileDimension((rightX + fig.sp));
                // check top right corner
                tileA = gamePanel.controller.mapMatrix[rightColumn][topRow];
                // check bottom right corner
                tileB = gamePanel.controller.mapMatrix[rightColumn][botRow];
                // if tileCollision is true for either tileA or tileB, then that means there is a collision between tiles
                if(gamePanel.controller.tileList.get(tileA).tileCollision || gamePanel.controller.tileList.get(tileB).tileCollision){
                    fig.isCollision = true;
                } // if false, we can just leave isCollision how it is - false
                break;
        }
    }
    
    
    public int objectCollisionChecker(Figure fig, boolean isPlayer){

        // loop through object/item array
        for(int i = 0; i < gamePanel.itemsDisplayed.length; i++){
            
            // check if current item in array is not null
            if(gamePanel.itemsDisplayed[i]  != null){
                // object's solid pos
                gamePanel.itemsDisplayed[i].solidRegion.x = gamePanel.itemsDisplayed[i].xPt;
                gamePanel.itemsDisplayed[i].solidRegion.y = gamePanel.itemsDisplayed[i].yPt;

                // figure solid pos
                fig.solidRegion.x += fig.xPt;
                fig.solidRegion.y += fig.yPt;

                switch(fig.movementDirection){
                    case 'u':
                        fig.solidRegion.y -= fig.sp;
                        break;

                    case 'l':
                        fig.solidRegion.x -= fig.sp;
                        break;

                    case 'd':
                        fig.solidRegion.y += fig.sp;
                        break;

                    case 'r':
                        fig.solidRegion.x += fig.sp;
                        break;
                }   

            }
            
            

        }
    }
}

