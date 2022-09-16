package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;

public class Dictionary {

        HashSet<String> dictionary;

        public Dictionary(int wordLength) throws IOException {

            String entry;
            this.dictionary = new HashSet<>();

            URL dictionaryURL = new URL("http://norvig.com/ngrams/enable1.txt");
            BufferedReader dictionaryReader = new BufferedReader(new InputStreamReader(dictionaryURL.openStream()));

            while ((entry = dictionaryReader.readLine()) != null) {
                if (entry.length() == wordLength) this.dictionary.add(entry.toLowerCase());
            }

        }

        public void PrintDictionary() {
            for (String s : this.dictionary) System.out.println(s);
        }

        public boolean ContainsWord(String word) {
            return this.dictionary.contains(word);
        }

    public String[] getPotentialWords(String validLetters) {
            ArrayList<String> listOfWords = new ArrayList<>();

            for (String s : this.dictionary) {

                int[] characterCounter = new int[26];

                for (char character : s.toCharArray()) {

                    //take 97 from ascii value of character to get index to increment
                    int indexToIncrement = (int) character - 97;

                    //increment index of array for each count of each letter found
                    characterCounter[indexToIncrement]++;
                }

                for (char character2 : validLetters.toCharArray()) {

                    int indexToDecrement = (int)character2 - 97;

                    characterCounter[indexToDecrement]--;
                }

                boolean isValid = true;
                for (int counter : characterCounter) {
                    if (counter > 0) isValid = false;
                }

                if (isValid) listOfWords.add(s);

            }

            String[] potentialWords = new String[listOfWords.size()];
            return listOfWords.toArray(potentialWords);}
}
