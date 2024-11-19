import javax.swing.*;
import java.io.*;
import java.nio.file.*;

public class FileInspector {
    public static void main(String[] args) {
        try {
            // Open JFileChooser in the src directory
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("src"));
            int result = chooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();

                // Initialize variables for counting
                int lineCount = 0, wordCount = 0, charCount = 0;

                // Read the file line by line
                BufferedReader reader = Files.newBufferedReader(selectedFile.toPath());
                String line;
                while ((line = reader.readLine()) != null) {
                    lineCount++;
                    wordCount += line.split("\\s+").length; // Split by whitespace for word count
                    charCount += line.length(); // Add line length to char count
                    System.out.println(line); // Echo line to the console
                }

                // Display file summary
                System.out.println("\nFile Summary:");
                System.out.println("File Name: " + selectedFile.getName());
                System.out.println("Number of Lines: " + lineCount);
                System.out.println("Number of Words: " + wordCount);
                System.out.println("Number of Characters: " + charCount);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
