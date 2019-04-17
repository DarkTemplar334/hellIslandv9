package gr.gcc.hellIsland.UI;


import gr.gcc.hellIsland.Domain.Player;
import gr.gcc.hellIsland.Invetory.Inventory;

public class DisplayMenu {

    Inventory inventory;

    public void showOption(){
        System.out.print("\nOption: ");
    }

    public void newGameStarting(){
        System.out.println("New Game Starting!");
    }

    public void setInvetory(Inventory invetory){
        this.inventory = inventory;
    }

    public static void showStory(){
        String words ="||\tWhile returning home from your business trip by airplane,\t\t\t ||" +
                "\n||\ta terrible storm formed on your way and a thunderbolt hit your plane.||" +
                "\n||\tleaving you alone on a island.                                       ||" +
                "\n||                Can you escape your fate?                              ||";
        int i=0;
        System.out.println("\n\n===========================================================================");
        for(i=0;i<words.length();i++){
            System.out.print(words.charAt(i));
//            try {
//                Thread.sleep(30);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }
        System.out.println("\n===========================================================================");
    }

    public void showWrongOption(){
        System.out.println("Wrong Option, chose again!");
    }

    public void showHelp(){
        System.out.println("\n====To see a list with available commands type: help====");
    }

    public void showAavailableCmds(Player player){
        System.out.println("\n Available Commands:\n======================================");
        System.out.println("|| Move: " + player.possibleDirections());
        System.out.println("|| Inventory: ");// + inventory.getList());
        System.out.println("|| Actions: "+ "[use,inventory,pickup,search]");
        System.out.println("|| Player Stats: "+"[stats]");
        System.out.println("======================================");
        System.out.println("\n====To get to main commands at any point just leave it blank====");
        System.out.println("\n====Type the commands after :====\n");

    }

    public void showGameMenu() {
        System.out.println("\n Action Commands:\n==============");
        System.out.println("|| Save Game ||");
        System.out.println("|| Load Game||");
        System.out.println("||   Exit   ||");
        System.out.println("==============");
    }

    public void showCurrentLocation(Player player){
        System.out.println("\nYou are at: " + player.nameOfCurrentRoom());
    }

    public void showPickedItem(String item){
        System.out.println("You've picked up a " + item);
    }
    public void showDropedItem(String item){
        System.out.println("You've Droped a " + item);
    }

    public void showUsedItem(String item){
        System.out.println("You used " + item);
    }

    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }

    public void showOutput(String cmdOutput){
        System.out.println(cmdOutput);
    }


}
