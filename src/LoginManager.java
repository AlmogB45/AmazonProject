import java.util.ArrayList;
import java.util.Scanner;

public class LoginManager {

    private static User authenticatedUser = null;
    public static String user = "";

    public static void login() {
        // Prompt the user to enter their email
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your email: ");
        // Prompt the user to enter their password
        String email = in.next();
        user = email;
        System.out.print("Enter your password: ");
        String password = in.next();
        // Call the validatePassword method with the entered email and password
        validatePassword(email,password);

    }

    public static User validatePassword(String email, String password){
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
        return authenticatedUser;
    }

    public static User getAuthenticatedUser() {
        return authenticatedUser;
    }

}