import java.util.ArrayList;
import java.util.Scanner;

public class LoginManager {


    public static void login() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter your email: ");
        String email = in.next();
        System.out.print("Enter your password: ");
        String password = in.next();

        validatePassword(email,password);

    }
    public static void validatePassword(String email, String password){
        String red = "\u001B[31m";
        String reset = "\u001B[0m";

        ArrayList<User> users = FileHandler.readUsersFromFile(Main.USER_PATH);

        User authenticatedUser = null;

        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                authenticatedUser = user;
                break;
            }
        }

        if (authenticatedUser == null) {
            System.out.println(red + "Invalid email or password." + reset);
            System.out.println(" ");
            login();
        }

    }

}