/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangame;

import javax.swing.JOptionPane;

/**
 *
 * @author Marcus Wood
 */
public class Hangman {

    /*
     * ATTRIBUTES
     */
    private String secretWord;
    private String disguisedWord;
    private String userGuess;
    private int guessCount;
    private int incorrectGuesses;
    private int position;
    private int parsing;
    private int valid;


    /*
     * CONSTRUCTOR
     */
    public Hangman() {
        secretWord = generateWord();
        disguisedWord = createDisguisedWord(secretWord);
        guessCount = 0;
        incorrectGuesses = 0;

    }


    /*
     * MY METHODS
     */
    public static String generateWord() {

        String word = "acclimation";
        return word;
    }

    public static String createDisguisedWord(String secretWord) {
        int wordLength = secretWord.length();
        String disguised = "";
        int i;
        for (i = 0; i < wordLength; i++) {
            disguised = disguised + "?";
        }
        return disguised;
    }

    public void playGame() {
        System.out.println(secretWord + "  " + disguisedWord);
        while (wordFound() != true) {
            userGuess = getUserGuess();
            makeGuess(userGuess);

        }


    }

    public boolean wordFound() {
        if (secretWord.equalsIgnoreCase(disguisedWord)) {
            showResult();
            return true;
        } else {
            return false;
        }
    }

    private String getUserGuess() {

        String inputGuess = JOptionPane.showInputDialog("The disguised word is " + disguisedWord
                + "\nGuess Count = " + guessCount
                + "\nIncorrect Guesses = " + incorrectGuesses
                + "\nGuess a letter (a-z), number (0-9), space or dash(-):");


        if (inputGuess.isEmpty()) {
            System.exit(0);
        }
//        while (inputGuess.length() != 1) {
//            inputGuess = JOptionPane.showInputDialog("Incorrect entry. The disguised word is " + disguisedWord
//                    + "\nGuess Count = " + guessCount
//                    + "\nIncorrect Guesses = " + incorrectGuesses
//                    + "\nGuess a letter (a-z), number (0-9), space or dash(-):");
//
//            if (inputGuess.isEmpty()) {
//                System.exit(0);
//            } // end if validation loop
//        } // end while loop
        return inputGuess;

    } // end get user guess method

    private void showResult() {
        JOptionPane.showMessageDialog(null, "Congratulations, you found the secret word: " + secretWord
                + "\nGuess Count = " + guessCount
                + "\nIncorrect Guesses = " + incorrectGuesses);
    } // end show result method

    //Phil is working on makeguess
    public void makeGuess(String guess) {
        parsing = 1;
        position = 0;
        valid = 0;
        //guessCount++;
        while (parsing == 1) {
            position = secretWord.indexOf(guess, position);
            if (position != -1) {
                valid = 1;
                updateDisguisedWord(position);
                position++;
            } else {
                parsing = 0;
            }
        }
        if (valid == 0) {
            incorrectGuesses++;
        }

    }

    // Markus is working on This
    public void updateDisguisedWord(int position) {

        String updatedDisguisedWord = "";
        for (int i = 0; i < secretWord.length(); i++) {

            if (userGuess.charAt(0) == (secretWord.charAt(i)) && userGuess.length() == 1) {
                updatedDisguisedWord = updatedDisguisedWord + secretWord.charAt(i);
                guessCount++;//something wrong it want to count it want to douuble it
                System.out.print(guessCount);
            }//end of if charAt equal charAt
            else {
                updatedDisguisedWord = updatedDisguisedWord + disguisedWord.charAt(i);
            }//end of else
        }

        //System.out.println("Position: " + position + "  Guesses: " + guessCount + "  Incorrect: " + incorrectGuesses); //debugging code


        if (userGuess.equals(secretWord)) {
            updatedDisguisedWord = secretWord;
        }


        disguisedWord = updatedDisguisedWord;
    }
    /*
     * WEB METHODS
     */
}// end of class

