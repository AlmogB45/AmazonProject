import java.io.*;
import java.util.Scanner;
public class login {
    public void run() throws FileNotFoundException {
        Scanner scan = new Scanner (new File("C:\\Users\\Almog-Laptop\\IdeaProjects\\AmazonProject\\src\\users.txt"));
        Scanner keyboard = new Scanner (System.in);

        String email = scan.nextLine();
        String password = scan.nextLine();

        String inputEmail = keyboard.nextLine();
        String inputPassword = keyboard.nextLine();

        if(inputEmail.equals(email) && inputPassword.equals(password)) {
            System.out.println("Welcome back to Amazon!");
        }
        else {
            System.out.println("Error, invalid username or password!");
        }
    }

    public static String displayUserDetails(String details) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Almog-Laptop\\IdeaProjects\\AmazonProject\\src\\users.txt"));
        String line;
        while((line = in.readLine()) != null) {
            System.out.println(line);
            line = details;
        }
        return details;
    }
}


