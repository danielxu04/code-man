package item;

public class BlueGem extends Item {
    
    public BlueGem(){
        itemName = "Blue Gem";
        itemImg = imageReader("/objects/BlueGem.png");
        isCollision = false;
    }
}
