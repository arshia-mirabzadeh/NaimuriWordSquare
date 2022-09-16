package main;

import java.util.*;

public class WordSquareGenerator {

    private HashMap<String, HashSet<String>> prefixMap;
    private List<List<String>> res;
    private String[] words;

    public WordSquareGenerator(String[] words) {
        this.words = words;
        this.prefixMap = new HashMap<>();
        this.res = new ArrayList<>();
    }

    private void helper(int row, List<String> wordList) {
        if (row == words[0].length()) {
            res.add(new ArrayList<>(wordList));
        }
        else {
            String prefix = "";
            for (String word: wordList) {
                prefix += word.charAt(row);
            }

            if (!prefixMap.containsKey(prefix)) return;

            for (String prefixWord: prefixMap.get(prefix)) {
                wordList.add(prefixWord);
                helper(row + 1, wordList);
                wordList.remove(wordList.size() - 1);
            }
        }
    }

    public List<List<String>> getWordSquares() {
        for(String word: words) {
            for(int i = 0; i < word.length(); i++) {
                String prefix = word.substring(0, i);
                HashSet<String> set = prefixMap.getOrDefault(prefix, new HashSet<>());
                set.add(word);
                prefixMap.put(prefix, set);
            }
        }
        helper(0, new ArrayList<>());
        return res;
    }

    public List<List<String>> getValidWordSquares(List<List<String>> potentialWordSquares, String validLetters) {
        List<List<String>> validWordSquares = new ArrayList<>();


        for (List<String> potentialWordSquare : potentialWordSquares) {
            String stringToCheck = "";
            for (String word : potentialWordSquare) {
                stringToCheck = stringToCheck + word;
            }
            char[] array1 = stringToCheck.toCharArray();
            char[] array2 = validLetters.toCharArray();
            Arrays.sort(array1);
            Arrays.sort(array2);
            if (Arrays.equals(array1, array2)) validWordSquares.add(potentialWordSquare);
        }
        return validWordSquares;

    }
}
