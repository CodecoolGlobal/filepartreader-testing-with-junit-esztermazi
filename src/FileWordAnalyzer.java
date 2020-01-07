import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {
    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public ArrayList<String> getWordsOrderedAlphabetically() throws IOException {
        ArrayList<String> fileContent = new ArrayList<>(Arrays.asList(this.filePartReader.readLines().split(",")));
        Collections.sort(fileContent, String.CASE_INSENSITIVE_ORDER);
        return fileContent;
    }

    public List<String> getWordsContainingSubstring(String subString) throws IOException {
        List<String> wordsContainingSubstring = null;
        ArrayList<String> fileContent = new ArrayList<>(Arrays.asList(this.filePartReader.readLines().split(",")));
        for (String element : fileContent) {
            if (element.contains(subString)) {
                wordsContainingSubstring.add(element);
            }
        }
        return wordsContainingSubstring;
    }

    public List<String> getStringsWhichPalindromes() throws IOException {
        List<String> wordsWhichArePalindromes = null;
        ArrayList<String> fileContent = new ArrayList<>(Arrays.asList(this.filePartReader.readLines().split(",")));
        for (String word : fileContent) {
            int i1 = 0;
            int i2 = word.length() - 1;
            while (i2 > i1) {
                if ((word.charAt(i1)) != (word.charAt(i2))) {
                    break;
                }
                ++i1;
                --i2;
            }

            wordsWhichArePalindromes.add(word);
        }
        return wordsWhichArePalindromes;
    }
}
