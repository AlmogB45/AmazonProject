import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        MenuManager menu = new MenuManager();
        menu.Menu();
    }

    static final String FILE_PATH = "src/resources/books.txt"; // populate this in Menu()
    static final String USER_PATH = "src/resources/users.txt";

    public static List<String> searchFile(String keyword) throws IOException {
        List<String> matches = new ArrayList<>();

        File file = new File(FILE_PATH);
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String lowerCaseLine = line.toLowerCase();
            Pattern pattern = Pattern.compile(keyword.toLowerCase());
            Matcher matcher = pattern.matcher(lowerCaseLine);
            if (matcher.find()) {
                matches.add(line);
            }
        }

        return matches;
    }


}