import java.util.ArrayList;

public class User {
    private String name;
    private String address;
    private String email;
    private String password;
    private static ArrayList<Book> purchasedBooks;

    public User(String name, String town, String email, String password){
        this.name = name;
        this.address = town;
        this.email = email;
        this.password = password;
        this.purchasedBooks = new ArrayList<>();
    }

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static ArrayList<Book> getPurchasedBooks() {
        return purchasedBooks;
    }

    public void purchaseBooksFromFile(String fileName, String searchParameter) {
        ArrayList<Book> books = FileHandler.readBooksFromFile(fileName);
        for (Book book : books) {
            if (book.getIsbn().equals(searchParameter) || book.getTitle().equalsIgnoreCase(searchParameter)) {
                purchasedBooks.add(book);
            }
        }
    }

    public void displayPurchasedBooks() {
        for (Book book : purchasedBooks) {
            System.out.println(book.getTitle() + " (" + book.getIsbn() + ")");
        }
    }

    public String displayUserDetails() {
        String str = "name : "+getName()+" address :"+ getAddress() +" mail : " + getEmail() + " password : " + getPassword();
        return str;
    }


}
