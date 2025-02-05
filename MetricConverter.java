import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Hello, it's nice to have you in my Metric Converter!");
        System.out.println(" Please go ahead and enter your query in the format: 17 kh = lb.");
        System.out.println("For now my supported conversions: kg-lb, gram-oz, km-mi, mm-in, oz-gram, lb-kg, mi-km, in-mm");
        System.out.println("To quit type 'exit' / '-1'.");

        while (true) {
            System.out.print("Enter conversion: ");
            input = scanner.nextLine().trim().toLowerCase();
            
            if (input.equals("exit") || input.equals("-1")) {
                System.out.println("Successfully exited from the converted. I'm sad to see you go. Have a nice one!");
                break;
            }
            String[] parts = input.split(" ");
            if (parts.length != 4 || !parts[2].equals("=")) {
                System.out.println("Format's not vaild! Please enter in the format: num kg = lb");

                continue;
            }
            try {
                double value = Double.parseDouble(parts[0]);
                String from_Unit = parts[1];
                String to_unit = parts[3];
                double result = convert(value, from_Unit, to_unit);
                
                if (result == -1) {
                    System.out.println("Unsupported conversion. Try again!");
                } else {
                    System.out.printf("%.2f %s = %.2f %s\n", value, from_Unit, result, to_unit);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Try again!");
            }
        }
        
        scanner.close();
    }

    public static double convert(double value, String from, String to) {
        switch (from) {
            case "kg":
                if (to.equals("lb")) return value * 2.20462;
                break;
            case "lb":
                if (to.equals("kg")) return value * 0.453592;
                break;
            case "gram":
                if (to.equals("oz")) return value * 0.035274;
                break;
            case "oz":
                if (to.equals("gram")) return value * 28.3495;
                break;
            case "km":
                if (to.equals("mi")) return value * 0.621371;
                break;
            case "mi":
                if (to.equals("km")) return value * 1.60934;
                break;
            case "mm":
                if (to.equals("inch")) return value * 0.0393701;
                break;
            case "inch":
                if (to.equals("mm")) return value * 25.4;
                break;
        }
        return -1;
    }
}