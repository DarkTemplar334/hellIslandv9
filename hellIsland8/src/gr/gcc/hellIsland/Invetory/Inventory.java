package gr.gcc.hellIsland.Invetory;
import java.util.*;

public class Inventory {

   private List<Item> inventory = new ArrayList<>(100);
   private Item itemSlot;

    public void addToInventory(Item item) {
        inventory.add(item);
    }

    public void getList() {
        System.out.println("In invetory you have: ");
        containedItems(this.inventory);
    }

    public boolean searchList(Item item) {
            boolean found;
            found=inventory.contains(item);
            return found;
    }

    public void sizelist() {
        inventory.size();
    }

    public void dropItem(Item item){
        inventory.remove(item);
    }

    public void pickup(Item item){
        inventory.add(item);
    }

    @Override
    public String toString() {
        return "Inventory{" + inventory + '}';
    }

    public void containedItems(List<Item> inventory){
        for (int i=0;i<inventory.size();i++){
            if(inventory.get(i) instanceof Key ){
                itemSlot = inventory.get(i);
                System.out.println("A key with id: " + itemSlot.getId(itemSlot));
            }
            else if(inventory.get(i) instanceof Weapon){
                itemSlot = inventory.get(i);
                System.out.println("A: " + itemSlot.getDescription(itemSlot));
            }
        }
    }
}