import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class WordleSolver {
    private static ArrayList<String> wordList;
    private static Scanner keyboard;

    private static void removeUnusableWords() {
        System.out.println("Enter all letters that are unusable.");
        System.out.print(">");
        String letters = keyboard.nextLine();
        char[] letterArr = letters.toCharArray();

        for(int i = 0; i < letterArr.length; i++) {
            for(int j = 0; j < wordList.size(); j++) {
                if(wordList.get(j).contains(Character.toString(letterArr[i]))) {
                    wordList.remove(j);
                    j--;
                }
            }
        }

    }

    private static void removeWordsWithout() {
        System.out.println("Enter all the yellow characters.");
        System.out.print(">");
        String letters = keyboard.nextLine();
        char[] letterArr = letters.toCharArray();

        for(int i = 0; i < letterArr.length; i++) {
            for(int j = 0; j < wordList.size(); j++) {
                if(!wordList.get(j).contains(Character.toString(letterArr[i]))) {
                    wordList.remove(j);
                    j--;
                }
            }
        }
    }
    private static void removeWordsWithoutGreen() {
        System.out.println("How many green characters are there?");
        System.out.print(">");
        int numOfGreen = keyboard.nextInt();

        for(int i = 0; i < numOfGreen; i++) {
            System.out.println("Enter a green character.");
            System.out.print(">");
            String letters = keyboard.next();
            char currChar = letters.charAt(0);
            if(!Character.isLetter(currChar)) {
                System.out.println("Enter a letter first!");
                System.exit(1);
            }

            System.out.println("Enter its index.");
            System.out.print(">");
            int charIndex = keyboard.nextInt();
            for(int j = 0; j < wordList.size(); j++) {
                if(wordList.get(j).charAt(charIndex) != currChar) {
                    wordList.remove(j);
                    j--;
                }
            }
        }
        keyboard.close();
    }
    public static void main(String[] args) throws Exception {
        wordList = new ArrayList<String>();
        keyboard = new Scanner(System.in);

        BufferedReader words;
        try {
            words = new BufferedReader(new FileReader("./fiveLetterWords.txt"));
            String word = words.readLine();
            while(word != null) {
                wordList.add(word);
                word = words.readLine();
            } 
        } catch (IOException e) {
                System.out.println("Error making word list");
        }
        
        removeUnusableWords();
        removeWordsWithout();
        removeWordsWithoutGreen();
        keyboard.close();
        System.out.println(wordList);
    }
}
