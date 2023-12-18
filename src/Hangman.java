import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.util.List;
public class Hangman {
    private ArrayList<String> words = getWordList();
    private int lives = 8;
    Scanner sc = new Scanner(System.in);
    public void playGame(){
        // set lives;
        this.lives = 8;
        // set the word
        String word = getWord(words);
        int wordLength = word.length();
        String[] userGuessed = new String[wordLength];
        for(int i=0; i < wordLength;i++){
            userGuessed[i] = "_";
        }
        // boolean to check if word is guessed or not
        boolean isGuessed = false;
        while(!isGuessed) {
            // if no lives are left, end the game
            if(lives == 0){
                break;
            }
            //ask user for input
            System.out.print("Guess a letter: ");
            String guess = sc.nextLine();
            while(guess.length() > 1 || !guess.matches("[a-zA-Z]")){
                System.out.println("Invalid input, try again");
                System.out.print("Guess a letter: ");
                guess = sc.nextLine();
            }
            //get first location of letter
            int location = word.indexOf(guess);
            if(location == -1){
                //remove a life
                this.lives--;
                System.out.println("lives left: " + this.lives);
            }
                while(location != -1){
                    // save the letter at right location in the userGuessed array
                    userGuessed[location] = guess;
                    // check the letter again
                    location = word.indexOf(guess, (location + 1));
                }
            System.out.println(Arrays.toString(userGuessed));
            // if the word is guessed set guessed to true
            isGuessed = !Arrays.asList(userGuessed).contains("_");
        }
        if(lives == 0){
            System.out.println("The word was " + word);
            System.out.println("Game over!");
        }else {
            System.out.println("You win!");
        }
        System.out.println("Do you want to continue? y/n");
        String proceed = sc.nextLine().toLowerCase();
        while(!proceed.equals("n") && !proceed.equals("y")){
            proceed = sc.nextLine().toLowerCase();
        }
        if(proceed.equals("y")){
            playGame();
        }
    }
    public String getWord(ArrayList<String> wordList){
        int arrayLength = wordList.size();
        int randomNr = (int) (Math.random() * arrayLength);
        return wordList.get(randomNr);
    }
    private ArrayList<String> getWordList(){
        //get the words from the csv file
        try{
            // get the file
            String file = "wordList.txt";
            BufferedReader reader = new BufferedReader(new FileReader(file));
            // copy words to array
            ArrayList<String> wordsFromFile = new ArrayList<>();
            // loop through
            String line;
            while((line = reader.readLine()) != null){
                wordsFromFile.add(line);
            }

            //close reader
            reader.close();
            return wordsFromFile;
        } catch (IOException e){
            System.out.println("err: " + e);
            ArrayList<String> err = new ArrayList<String>();
            err.add("err: " + e);
            return err;
        }
    }
}