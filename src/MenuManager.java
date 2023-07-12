import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// HELLO
import static java.lang.System.exit;

public class MenuManager {
    private static Scanner scanner;


    public void printMenu(String[] options) {
        for (String option : options) {
            System.out.println("\u001b[32m" + option + "\u001b[0m");
        }
        System.out.print("Choose your option : ");
    }

    void Menu() {
        int option = 1; // think why initialized with "1"
        String[] options = {"I - Search for a book",
                "II - View user details",
                "III - Purchase a book",
                "IV - Logout"
        };
        scanner = new Scanner(System.in);

        while (option != 4) {
            this.printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        searchBook();
                        break;
                    case 2:
                        option2(); // rename all optionX functions to meaningful names
                        break;
                    case 3:
                        option3(); // rename all optionX functions to meaningful names
                        break;
                    case 4:
                        exit(0);
                }
            } catch (Exception ex) {
                System.out.println("\u001b[31m" + "Please enter an integer value between 1 and " + options.length + "\u001b[0m");
                scanner.next();
            }
        }
    }

    // Options
    private void searchBook() throws IOException {
        System.out.print("Enter book name: ");
        String input = scanner.next();
        List<String> matches = FileHandler.searchFile(input);

        for (String match : matches) {
            System.out.println("\u001b[36m" + match + "\u001b[0m");
        }
    }

    private static void option2() {
        System.out.println("Thanks for choosing option 2");
    }

    private static void option3() throws IOException {
        List<String> matches = new ArrayList<>();

        File file = new File(FileHandler.FILE_PATH);
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.matches("[0-9]+")) {
                matches.add(line);
            }
        }

        for (String match : matches) {
            System.out.println("\u001b[36m" + match + "\u001b[0m");
        }
        System.out.println("Please enter the ISBN of the book you wish to purchase: ");
        String isbn;
        try {
            isbn = scanner.nextLine();
        } catch (Exception ex) {
            System.out.println("Please enter a string that contains only numbers");
            return;
        }

        if (!isbn.matches("[0-9]+")) {
            System.out.println("Invalid ISBN");
            return;
        }

        // Check if the book is available for purchase
        file = new File(FileHandler.FILE_PATH);
        reader = new FileReader(file);
        bufferedReader = new BufferedReader(reader);

        while ((line = bufferedReader.readLine()) != null) {
            if (line.contains(isbn)) {
                // Book is available for purchase
                break;
            }
        }

        if (line == null) {
            // Book is not available for purchase
            System.out.println("Book is not available for purchase");
            return;
        }

        // Mark the book as purchased and add it to the user's purchase history
        // TODO: Implement this logic

        // Display a confirmation message with the details of the purchased book
        System.out.println("Book purchased successfully!");
        System.out.println("ISBN: " + isbn);
    }


    public MenuManager() {
        System.out.println("1) Login");
        System.out.println("2) Register");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                LoginManager loginManager = new LoginManager();
                loginManager.login();
                Menu();

                break;
            case 2:
                System.out.println("Hey");
        }
    }
}





