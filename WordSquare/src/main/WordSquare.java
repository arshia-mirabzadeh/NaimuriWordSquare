package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordSquare {

    public static void main(String[] args) throws IOException {

        List<List<String>> answers = solveChallenge(args);
        for (List<String> entry : answers) {
            for (String w : entry) {
                System.out.println(w);
            }
            System.out.println();
        }
    }

    public static List<List<String>> solveChallenge(String[] args) throws IOException {
        // validate program inputs
        if (args.length != 2) {
            throw new IllegalArgumentException("Please provide 2 arguments in the format 'WordSquare n x' where n is the size of the square and x is a string containing the letters to be used e.g WordSquare 4 eeeeddoonnnsssrv");
        }

        //validate and initialise square size
        int squareSize = Integer.parseInt(args[0]);

        //validate and initialise the valid letters
        String validLetters = args[1].toLowerCase();
        if (!validLetters.matches("[a-z]+")) {
            throw new IllegalArgumentException("Letters to be used must be standard english character from uppercase/lowercase A to Z");
        }

        //initialise dictionary only containing words equal in length to the square size
        Dictionary dictionary = new Dictionary(squareSize);

        //get list of potential words that can be made using the provided letters
        String[] potentialWords = dictionary.getPotentialWords(validLetters);

        WordSquareGenerator generator = new WordSquareGenerator(potentialWords);

        //get all word squares possible from list of potential words
        List<List<String>> potentialAnswers = generator.getWordSquares();

        //get all the valid word squares that can be made using the letters provided
        List<List<String>> validAnswers = generator.getValidWordSquares(potentialAnswers, validLetters);

        return validAnswers;
    }
}