import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Main {
    public static String ReadFile(String path) { // Function to read file
        String line = "";
        String data = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while (line != null) {
                if (line == null) break;
                data += line.trim();
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

        return out.trim().replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>","")
                .replace(".","").replace(";","")
                .replace("<id>","").replace("</id>",".")
                .replace("<row>","")
                .replace("<root>","").replace("</root>","")
                .replace("<CourseName>","").replace("</CourseName>",",")
                .replace("<Instructor>","").replace("</Instructor>",",")
                .replace("<CourseDuration>","").replace("</CourseDuration>",",")
                .replace("<CourseTime>","").replace("</CourseTime>",",")
                .replace("<Location>","").replace("</Location>","")
                .replace("</row>","\n");
    }
    public static void main(String[] args) {
     System.out.println (formate(ReadFile("coursedata_G.xml")));

    }
}