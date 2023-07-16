import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileHandler {
    public static ArrayList<Book> books = new ArrayList<>();

    public static ArrayList<User> readUsersFromFile(String filename){

        ArrayList<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 4 ) {
                    String name = data[0];
                    String address = data[1];
                    String email = data[2];
                    String password = data[3];

                    User user = new User(name,address,email,password);
                    users.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }

    public static void writeNewRegister(User user){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(Main.USER_PATH, true));
            writer.newLine(); // add a new line before writing the new line
            writer.write(user.getName()+","+user.getAddress()+","+user.getEmail()+","+user.getPassword());
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }


    public static ArrayList<Book> readBooksFromFile(String fileName){
        try (BufferedReader br = new BufferedReader(new FileReader(Main.FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");

                if (data.length >= 3) {
                    String title = data[0];
                    String author = data[1];
                    double price = Double.parseDouble(data[2]);
                    String ISBN = data[3];

                    Book book = new Book(title, author,price,ISBN);
                    books.add(book);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;
}

    public static List<String> searchFile(String keyword) throws IOException {
        List<String> matches = new ArrayList<>();

        File file = new File(Main.FILE_PATH);
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



