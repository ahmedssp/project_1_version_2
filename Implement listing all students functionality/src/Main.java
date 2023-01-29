import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static String readdata(String path)  // read data from TXT file row data
    {
        StringBuilder sb = new StringBuilder();
        String strLine = "";
        String str_data = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while (strLine != null) {
                if (strLine == null) break;
                str_data += strLine;
                strLine = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
        return str_data;
    }

    public static String formate(String out) // format txt file row data into csv file
    {
        return out.replace("#", ",").replace("$", "\n");
    }

    static void Creatfile(String name) throws IOException // creat file
    {
        File x = new File(name);
        if (x.createNewFile()) {
            System.out.println("the craeted file name: "+x.getName());
        }
    }

    static void Witefile(String filename, String content) throws IOException // write formatted csv file into new file
    {
        FileWriter w = new FileWriter(filename);
        w.write(content);
        w.close();
    }

    public static void fun(String FILEPATH, int colom)  // print csv file into proper format
    {
        String line = "";
        String data = "";
        List<String> recordlist = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILEPATH));
            while (line != null) {
                if (line == null) break;
                recordlist.add(line);
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
        recordlist.remove(0);
        String[][] outputarray = new String[recordlist.size()][colom];
        String[] line_array;
//        System.out.println(recordlist.get(0));

        for (int i = 0; i < recordlist.size(); i++) {
            line_array = recordlist.get(i).split(",");
            for (int j = 0; j < line_array.length; j++) {
                if (line_array[j].length() > 3 && line_array[j].length() < 20) {
                    outputarray[i][j] = line_array[j] + "                      ";
                } else if (line_array[j].length() > 10 && line_array[j].length() < 18) {
                    outputarray[i][j] = line_array[j] + "             ";
                } else if (j > 5) {
                    outputarray[i][j] = line_array[j] + "                ";
                } else {
                    outputarray[i][j] = line_array[j];
                }

            }
        }
        System.out.println("---------------------------------------------------------------------------------------\n");
        System.out.println("                            Current Student List");
        System.out.println("---------------------------------------------------------------------------------------");

        for (int c = 0; c < outputarray.length; c++) {
            System.out.println(outputarray[c][0] + " " + outputarray[c][1] + "  " + outputarray[c][2] + "                " + outputarray[c][3] + "              " + outputarray[c][4]
                    + "                                                  " + outputarray[c][5] + "                                                         " + outputarray[c][6]);
        }


    }

    public static void main(String[] args) throws IOException {
        String rowdata_file_path="student-data_G.txt";
        String new_csv_file="file_test_csv.csv";


        String data= formate(readdata(rowdata_file_path)); //data is txt formated csv
         Creatfile(new_csv_file);
        Witefile(new_csv_file,data);

        fun(new_csv_file, 7);

    }
}
