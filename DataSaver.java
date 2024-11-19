import java.io.*;
import java.util.*;

public class DataSaver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        int idCounter = 1;

        System.out.println("Enter records (type 'done' to finish):");
        while (true) {
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            if (firstName.equalsIgnoreCase("done")) break;

            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();

            String id = String.format("%06d", idCounter++);
            System.out.print("Email: ");
            String email = scanner.nextLine();

            // Validate Year of Birth Input
            int yearOfBirth = 0;
            boolean validYear = false;
            while (!validYear) {
                System.out.print("Year of Birth: ");
                if (scanner.hasNextInt()) {
                    yearOfBirth = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    validYear = true;
                } else {
                    System.out.println("Invalid input. Please enter a 4-digit year.");
                    scanner.nextLine(); // Clear the invalid input
                }
            }

            // Save the record as a CSV line
            records.add(firstName + "," + lastName + "," + id + "," + email + "," + yearOfBirth);
        }

        // Save to file
        System.out.print("Enter output file name (e.g., data.csv): ");
        String fileName = scanner.nextLine();

        try (PrintWriter writer = new PrintWriter(new FileWriter("src/" + fileName))) {
            for (String record : records) {
                writer.println(record);
            }
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving file: " + e.getMessage());
        }
    }
}
