import java.io.*;
import java.util.Scanner;
public class WordManager {
    Scanner sc = new Scanner(System.in);
    public String addWordToList(){
        String status;
        try{
            File file = new File("wordlist.csv");
            FileWriter fr = new FileWriter(file, true);
            System.out.print("add word: ");
            String word = sc.nextLine();
            fr.write(word+",");
            fr.close();
            status = "Succes";
        } catch(IOException e){
            status = "failure";
        }
        return status;
    }
}
