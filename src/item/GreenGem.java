package item;

public class GreenGem extends Item{
    
    public GreenGem(){
        itemName = "Green Gem";
        itemImg = imageReader("/objects/GreenGem.png");
        isCollision = false;
    }
}
