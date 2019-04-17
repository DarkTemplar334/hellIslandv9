package gr.gcc.hellIsland;

        import gr.gcc.hellIsland.Command.UserInput;
        import gr.gcc.hellIsland.Domain.Door1;
        import gr.gcc.hellIsland.Domain.Player;
        import gr.gcc.hellIsland.Domain.Room;
        import gr.gcc.hellIsland.Invetory.Inventory;
        import gr.gcc.hellIsland.Invetory.Item;
        import gr.gcc.hellIsland.Invetory.Key;
        import gr.gcc.hellIsland.Invetory.Weapon;
        import gr.gcc.hellIsland.Parser.Parser;
        import gr.gcc.hellIsland.UI.DisplayMenu;
        import gr.gcc.hellIsland.UI.MainMenu;

        import java.util.List;

        import static java.lang.String.valueOf;

public class Main {


    private static MainMenu mainMenu = new MainMenu();
    private static String decision;
    private static boolean gameOver = true;
    private static DisplayMenu displayMenu = new DisplayMenu();
    private static UserInput input = new UserInput();
    private static String[] token = new String[2];
    private static List<Item> inventoryItems;
    //private static int doors;


    public static void main(String[] args){



        //Room-Door1 Creation

        Door1 door1 = new Door1(1);
        Door1 door2 = new Door1(2);
        Door1 door3 = new Door1(3);
        Door1 door4 = new Door1(4);
        Door1 door5 = new Door1(5);


        Room room1 = new Room("Mainland",door1,false);
        Room room2 = new Room("Plane",door2,false);
        Room room3 = new Room("Sea",door3,true);
        Room room4 = new Room("Forrest",door4,true);
        Room room5 = new Room("Cave",door5,true);


        //Room Connections
        room1.putLeftOf(room2);
        room2.putRightOf(room1);
        room1.putUpOf(room3);
        room3.putDownOf(room1);
        room1.putDownOf(room4);
        room4.putUpOf(room1);
        room5.putLeftOf(room4);
        room4.putRightOf(room5);


        Item sword = new Weapon("Sword",10,false);
        Item key3 = new Key(3,true);
        Item key4 = new Key(4,true);
        Item key5 = new Key(5,true);

        Inventory room1Invetory = new Inventory();
        Inventory room2Invetory = new Inventory();
        room2Invetory.addToInventory(key3);
        room2Invetory.addToInventory(key4);
        room2Invetory.addToInventory(key5);
        room2Invetory.addToInventory(sword);

        room2.setRoomInventory(room2Invetory);
        room2Invetory.getList();

        room2Invetory.dropItem(key3);
        room2Invetory.getList();

        room2Invetory.pickup(key3);
        room2Invetory.pickup(sword);

        room2Invetory.getList();


        Inventory room3Invetory = new Inventory();
        Inventory room4Invetory = new Inventory();
        Inventory room5Invetory = new Inventory();





//        //Room Connections
//        room1.putLeftOf(room2,door1);
//        room2.putRightOf(room1,door1);
//        room1.putUpOf(room3, door12);
//        room3.putDownOf(room1, door12);
//        room1.putDownOf(room4, door13);
//        room4.putUpOf(room1, door13);
//        room5.putLeftOf(room4, door14);
//        room4.putRightOf(room5, door14);


        //Player Creation
        Player player = new Player();

        //Parser Creation
        Parser parser = new Parser();



//        Item kontar = new Weapon("To magiko rabdi tou gkandalf",99999,true);
//        System.out.println("THE MIGHTY SWORD: "+ sword.pickable(sword));
//        System.out.println("Ta paparia tou gandalf: "+kontar.pickable(kontar));


        mainMenu.gameMenu();
        displayMenu.showOption();
        decision = input.getInput().toLowerCase().trim();

        while(gameOver){
            if(decision.equals("new game")){
                player.setStartingRoom(room2);
                parser.setPlayer(player);
                gameOver=false;
                displayMenu.newGameStarting();
                displayMenu.showStory();

            }
            else if(decision.equals("load game")){
                gameOver=false;
                mainMenu.loadGame();
                parser.setPlayer(player);
        }
            else if(decision.equals("exit")){
                mainMenu.exitGame();
            }
            else{
                displayMenu.showWrongOption();
                mainMenu.gameMenu();
                decision=input.getInput();
            }
        }




        //Game Loop
        while(!gameOver){
            displayMenu.showHelp();
            displayMenu.showCurrentLocation(player);
            displayMenu.showOption();
            decision=input.getInput();
            token = input.Tokenizer(decision.toLowerCase().trim());
            parser.commandToDo(token);
        }
    }
}
