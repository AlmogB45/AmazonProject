import java.io.IOException;
import java.util.ArrayList;
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
        System.out.print(white + "Choose your option : ");
    }

    void Menu() {
        int option = 1; // think why initialized with "1"
        System.out.println(white + "\n|---Welcome to Amazon!---|\n");
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
                        System.out.println(green + "How do you want to search for your book?");
                        System.out.println(white + "1. By Name");
                        System.out.println(white + "2. By ISBN");
                        int subOption = scanner.nextInt();
                        if (subOption == 1) {
                            searchBook();
                        } else if (subOption == 2) {
                            searchISBN();
                        }
                        break;
                    case 2:
                        userDetails(); // rename all optionX functions to meaningful names
                        break;
                    case 3:
                        purchaseBook(); // rename all optionX functions to meaningful names
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
        scanner = new Scanner(System.in);
        System.out.print("Enter book name: ");
        String input = scanner.nextLine();
        ArrayList<Book> bookTitle = FileHandler.readBooksFromFile(Main.FILE_PATH);
        for (int i = 0; i < bookTitle.size(); i++) {
            if (bookTitle.get(i).getTitle().contains(input))
                System.out.println(cyan + "TITLE: " + white + bookTitle.get(i).getTitle() + cyan + " AUTHOR:" + white + bookTitle.get(i).getAuthor() + cyan + " Price: " + white + bookTitle.get(i).getPrice() + cyan + " ISBN: " + white + bookTitle.get(i).getIsbn());

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
                System.out.println(cyan + "Title: " + white + book.getTitle());
                System.out.println(cyan + "Author: " + white + book.getAuthor());
                System.out.println(cyan + "ISBN: " + white + book.getIsbn());
                System.out.println(cyan + "Price: " + white + book.getPrice());
                bookFound = true;
                break;
            }
        }
        if (!bookFound) {
            System.out.println("No book found with ISBN: " + isbn);
        }

    }


    private static void userDetails() {
        ArrayList<User> users = FileHandler.readUsersFromFile(Main.USER_PATH);
        String username = LoginManager.user;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(username)) {
                System.out.println(cyan + "Name: " + white + users.get(i).getName() + cyan + "\nEmail: " + white + users.get(i).getEmail() + cyan + "\nAddress:" + white + users.get(i).getAddress() + cyan + "\nPassword: " + white + users.get(i).getPassword());
                System.out.println(cyan + "books already purchased:" + white);
                //booksPurchase();
            }
        }
    }


    private void purchaseBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ISBN or name to purchase books: ");
        String searchParameter = scanner.nextLine();

        ArrayList<Book> books = FileHandler.readBooksFromFile("books.txt");

        ArrayList<Book> purchasedBooks = User.getPurchasedBooks(); // Access purchasedBooks directly

        for (Book book : books) {
            if (book.getIsbn().equals(searchParameter) || book.getTitle().equalsIgnoreCase(searchParameter)) {
                if (!purchasedBooks.contains(book)) {
                    purchasedBooks.add(book);
                }
            }
        }

        System.out.println("Purchased Books:");
        for (Book book : purchasedBooks) {
            System.out.println(book.getTitle() + " (" + book.getIsbn() + ")");
        }
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
                register();
                LoginManager.login();
                Menu();
                break;
        }
    }

    public static void register() {
        scanner = new Scanner(System.in);
        System.out.println("Name : ");
        String Name = scanner.nextLine();
        System.out.println("Address: ");
        String Address = scanner.nextLine();
        System.out.println("Mail: ");
        String Mail = scanner.nextLine();
        System.out.println("Password: ");
        String Password = scanner.nextLine();
        ArrayList<User> users = FileHandler.readUsersFromFile(Main.USER_PATH);
        int count = 0;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(Mail)) {
                count++;
            }
        }
        if (count > 0) {
            System.out.println("This email Address is already taken!");
        } else {
            User user = new User(Name, Address, Mail, Password);
            FileHandler.writeNewRegister(user);
            System.out.println("You have successfully registered! Welcome to Amazon!");

        }

    }
}






