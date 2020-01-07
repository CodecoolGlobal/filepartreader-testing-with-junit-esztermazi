import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;


    public FilePartReader() {
    }

    public String getFilePath(){
        return filePath;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine) {
            throw new IllegalArgumentException("toLine is smaller than fromLine.");
        }
        if (fromLine < 1) {
            throw new IllegalArgumentException("fromLine is smaller than 1.");
        }
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public String readLines() throws IOException {
        /*
         */
        String wholeFileContent;
        wholeFileContent = read();
        String[] wholeLines = wholeFileContent.split("(?<=\n)");

        int wholeLength = wholeLines.length;
        if (wholeLength < fromLine) {
            return "";
        }
        int endLine = Math.min(toLine, wholeLength);
        final int length = endLine - fromLine + 1;

        String[] partLines = new String[length];
        System.arraycopy(wholeLines, fromLine - 1, partLines, 0, length);

        return String.join("", partLines);
    }
}
