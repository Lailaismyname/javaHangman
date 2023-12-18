import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner((System.in));
    String userChoice = getChoice();
    void displayMenu(){
        if(userChoice.equals("S")){
            Hangman newGame = new Hangman();
            newGame.playGame();
        } else if (userChoice.equals("A")){
            WordManager wordmanager = new WordManager();
            wordmanager.addWordToList();
        } else if (userChoice.equals("Q")){
            System.out.println("Thanks for playing, have a nice Day!");
            System.exit(0);
        } else{
            System.out.println("Something went wrong, shutting down program");
            System.exit(1);
        }
    }
    public String getChoice(){
        // display menu
        System.out.println("To Play the Game press S");
        System.out.println("To Add words to list press A");
        System.out.println("To Quit the game press Q");
        System.out.println("Your Choice: ");
        // get user input and check if choice is valid
        userChoice = sc.nextLine().toUpperCase();
        while(!userChoice.equals("S") && !userChoice.equals("A") && !userChoice.equals("Q")){
            System.out.println("user choice: " + userChoice);
            System.out.println(userChoice.equals("S"));
            System.out.println("Invalid input, try again.");
            userChoice = sc.nextLine().toUpperCase();
        }
        // if valid return choice
        return userChoice;
    }
}


