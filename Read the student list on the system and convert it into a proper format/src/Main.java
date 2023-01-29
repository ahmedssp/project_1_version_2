import java.io.*;
import java.util.Scanner;
public class Main {
    public static String ReadFile(String path) { // Function to read file
        String line = "";
        String data = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while (line != null) {
                if (line == null) break;
                data += line;
                line = br.readLine();
            }
            br.close();}
        catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
        return data;
    }
    public static String formate(String out) {  // Function to convert file to propare format
        return out.replace("#", ",").replace("$", "\n");
    }

    public static void main(String[] args) {

        System.out.println(formate(ReadFile("student-data_G.txt")));
    }
}