import java.util.ArrayList;

public class User {
    private String name;
    private String adress;
    private String email;
    private String password;
    private ArrayList <Book> purchasedBooks;

    public User(String name, String town, String email, String password){
        this.name = name;
        this.adress = town;
        this.email = email;
        this.password = password;
    }

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Book> getPurchasedBooks() {
        return purchasedBooks;
    }

    public String displayUserDetails() {
        String str = "name : "+getName()+" address :"+ getAdress() +" mail : " + getEmail() + " password : " + getPassword();
        return str;
    }


}
