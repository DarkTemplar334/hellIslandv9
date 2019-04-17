package gr.gcc.hellIsland.Parser;

import gr.gcc.hellIsland.Command.Direction;
import gr.gcc.hellIsland.Domain.Player;
import gr.gcc.hellIsland.Domain.Room;
import gr.gcc.hellIsland.Invetory.Inventory;
import gr.gcc.hellIsland.Invetory.Weapon;
import gr.gcc.hellIsland.UI.DisplayMenu;
import gr.gcc.hellIsland.UI.MainMenu;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class Parser{

    private Player player;
    private DisplayMenu displayMenu = new DisplayMenu();
    private Inventory inventory;
    private String possibleError=null;
    private MainMenu mainMenu = new MainMenu();
    private String[] availableCommands =new String[]{"right","left","up","down","help","pick","drop","use","move","game",null,"save","load","sword"};
    private List<String> ListOfAvailableCommands = Arrays.asList(availableCommands);
    private Room currentRoom;




    public void commandToDo(String[] token){

        if(ListOfAvailableCommands.contains(token[0]) && ListOfAvailableCommands.contains(token[1]) ) {
            switch (token[0]) {
                case "move":
                    possibleError = player.move(Direction.valueOf(token[1]));
                    displayMenu.showOutput(possibleError);
                    break;
                case "pick":
                    displayMenu.showPickedItem(token[1]);
                    break;
                case "drop":
                    displayMenu.showDropedItem(token[1]);
                    break;
                case "use":
                    displayMenu.showUsedItem(token[1]);
                    break;
                case "help":
                    displayMenu.showAavailableCmds(player);
                    break;
                case "save":
                    mainMenu.saveGame(player,player.getCurrentRoom());
                    break;
                case "load":
                    currentRoom=mainMenu.loadGame();
                    player.setStartingRoom(currentRoom);
                    break;
                default:
                    displayMenu.showOutput(token[0] + " " + token[1]);
            }
        }else
        {
            displayMenu.showOutput("Command Does not exist!");
        }
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }

    public String showPlayerLoc(){
        return player.nameOfCurrentRoom();
    }



}
