import java.io.*;
import java.util.Scanner;

public class FileHandler 
{
    public static void writeFile(String filename, String content) 
	{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) 
		{
            writer.write(content);
            System.out.println("Content written to file: " + filename);
        } 
		catch (IOException e) 
		{
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    public static void readFile(String filename) 
	{
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) 
		{
            String line;
            System.out.println("Reading content from file: " + filename);
            while ((line = reader.readLine()) != null) 
			{
                System.out.println(line);
            }
        } catch (IOException e) 
		{
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
    public static void modifyFile(String filename, String oldText, String newText) 
	{
        try 
		{
            StringBuilder content = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) 
			{
                String line;
                while ((line = reader.readLine()) != null) 
				{
                    content.append(line).append(System.lineSeparator());
                }
            }
            String modifiedContent = content.toString().replace(oldText, newText);

            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) 
			{
                writer.write(modifiedContent);
                System.out.println("File modified successfully.");
            }
        } 
		catch (IOException e) 
		{
            System.err.println("Error modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args)
	{
        String filename = "testfile.txt";
        
        String content = "Hello, this is a text file.\nWelcome to the world of Java I/O!";
        writeFile(filename, content);

        readFile(filename);

        modifyFile(filename, "Java", "Java Programming");

        System.out.println("\nAfter modification:");
        readFile(filename);
	}
}