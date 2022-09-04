package item;

public class Chest extends Item{
    
    public Chest(){
        itemName = "Chest";
        itemImg = imageReader("/objects/Chest.png");
        isCollision = true;
    }
}
