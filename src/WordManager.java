import java.io.*;
import java.util.Scanner;
public class WordManager {
    Scanner sc = new Scanner(System.in);
    public void addWordToList() {
        String choice = "y";
        while (choice.equals("y")){
            String status;
            try {
                File file = new File("wordlist.txt");
                FileWriter fr = new FileWriter(file, true);
                System.out.print("add word: ");
                String word = sc.nextLine();
                fr.write(word + System.lineSeparator());
                fr.close();
            } catch (IOException e) {
                System.out.println("err: " + e);
            }
            System.out.print("do you want to continue? y/n ");
            choice = sc.nextLine().toLowerCase();
        }
        Menu menu = new Menu();
        menu.displayMenu();
    }
}

// TODO: als een woord geraden is moet ie uit de array gehaald worden.
// TODO: Score bijhouden
// TODO: betere comments aan code toevoegen
