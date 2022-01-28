import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class GenWordList {
    public static void main(String[] args) throws Exception {
        /**
         * Creating the word list from 'words' unix file
         */
        ArrayList<String> wordList = new ArrayList<String>();
        BufferedReader words;
        try {words = new BufferedReader(new FileReader("/usr/share/dict/words"));
            String word = words.readLine();
            while(word != null) {
                //Check if word is 5-letters
                if(word.length() == 5) {
                    if(!Character.isUpperCase(word.charAt(0))) {
                        wordList.add(word);
                    }
                }
                word = words.readLine();
            }
            words.close();
        } catch (IOException e) {
            System.out.println("Error finding words file.");
            System.exit(1);
        }

        /**
         * Generate new words file in this directory containning only 5 letter words
         */
        try {FileWriter newWords = new FileWriter("./fiveLetterWords.txt");
            for(int i = 0; i < wordList.size(); i++) {
                newWords.write(wordList.get(i) + "\n");
            }
            newWords.close();
        } catch (IOException e) {
            System.out.println("Error creating new words file");
        }
    }
}