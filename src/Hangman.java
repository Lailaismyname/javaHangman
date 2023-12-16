import java.util.Arrays;
import java.util.Scanner;
public class Hangman {
    private String[] wordList = new String[] {"cookie","music","breathe","plumber","pacifier","hero"};
    private int lives = 8;
    Scanner sc = new Scanner(System.in);
    public void playGame(){
        // set the word
        String word = getWord(wordList);
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
            System.out.println(guess.length());
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
            System.out.println("Game over!");
        }else {
            System.out.println("You win!");
        }
    }
    public String getWord(String[] wordList){
        int arrayLength = wordList.length;
        int randomNr = (int) (Math.random() * arrayLength);
        return wordList[randomNr];
    }
}