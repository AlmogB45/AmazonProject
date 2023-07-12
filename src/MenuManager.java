import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.exit;

public class MenuManager {
    static String cyan = "\u001b[36m";
    static String red = "\u001B[31m";
    static String green = "\u001b[32m";
    static String white = "\u001b[0m";
    private static Scanner scanner;


    public void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(green + option);
        }
        System.out.print(white+"Choose your option : ");
    }

    void Menu() {
        int option = 1; // think why initialized with "1"
        System.out.println(white+"\n|---Welcome to Amazon!---|\n");
        String[] options = {"I - Search for a book",
                "II - View user details",
                "III - Purchase a book",
                "IV - Logout \n"
        };
        scanner = new Scanner(System.in);

        while (option != 4) {
            this.printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        // Add new submenu
                        System.out.println(green+"How do you want to search for your book?");
                        System.out.println(white+ "1. By Name");
                        System.out.println(white+ "2. By ISBN");
                        int subOption = scanner.nextInt();
                        if (subOption == 1) {
                            searchBook();
                        } else if (subOption == 2) {
                            searchISBN();
                        }
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
                System.out.println(red + "Please enter an integer value between 1 and " + options.length);
                scanner.next();
            }
        }
    }

    // Options
    private void searchBook() throws IOException {
        System.out.print(white+ "Enter book name: ");
        String input = scanner.next();
        List<String> matches = FileHandler.searchFile(input);

        System.out.println("\nFound " + matches.size() + " results matching: '" +input+"'");
        for (String match : matches) {
            System.out.println(cyan+ "\n" +match + "\n");
        }
    }

    private static void searchISBN() throws IOException {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.next();

        if (!isbn.matches("[0-9]+")) {
            System.out.println("ISBN must only contain numbers.");
            return;
        }

        if (isbn.length() < 13) {
            System.out.println("ISBN must be 13 digits long or more.");
            return;
        }
        ArrayList<Book> booklist = FileHandler.readBooksFromFile(Main.FILE_PATH);
        boolean bookFound = false;
        for (int i = 0; i < booklist.size(); i++) {
            Book book = booklist.get(i);
            if (book.getIsbn().equals(isbn)) {
                System.out.println("Book found:");
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println("Price: " + book.getPrice());
                bookFound = true;
                break;
            }
        }
        if (!bookFound) {
            System.out.println("No book found with ISBN: " + isbn);
}

    }


    private static void option2() {
        ArrayList<User> users = FileHandler.readUsersFromFile(Main.USER_PATH);
        String username = LoginManager.user;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(username)) {
                System.out.println("\nName : " +users.get(i).getName() +"\nEmail : "+ users.get(i).getEmail() + "\nAddress : " +users.get(i).getAdress()+"\nPassword : "+users.get(i).getPassword()+"\n");
            }
    }
}

    private static void option3() {

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





