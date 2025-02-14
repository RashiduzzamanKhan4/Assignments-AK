import java.util.Scanner;

public class Reverse_String {
    public static String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to see a magic(^-1)");
        String user_Input = scanner.nextLine();
        System.out.println("The magic: " + reverse(user_Input));
        scanner.close();
        
        

        // } else {
        //     System.out.println("I need you to give me a string");
        // }
    }
}
