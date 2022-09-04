package item;


public class Door extends Item{
    
    public Door(){
        itemName = "Door";
        itemImg = imageReader("/objects/Door.png");
        // set collision to true - solid object by default
        isCollision = true;
    }
}
