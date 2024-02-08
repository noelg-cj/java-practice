import java.util.*;
import java.io.*;

public class file {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintStream console = System.out;
        File f = new File("input.txt");
        try {
            /* if (f.createNewFile()) {
                console.println("New file created: " + f.getName());
            }
            else {
                console.println("File already exists!");
            }

            FileWriter fw = new FileWriter("input.txt");
            console.print("Enter the text to be written: ");
            String s = sc.nextLine();
            for (int i = 0; i < s.length(); i++) {
                fw.write(s.charAt(i));
            }
            fw.close(); */

            FileReader fr = new FileReader("input.txt");
            /* int ch;
            console.println("Text written in the file is: ");
            while ((ch = fr.read()) != -1) {
                console.print((char)ch);
            }
            fr.close(); */

            BufferedReader bfr = new BufferedReader(fr);
            String line = "";
            console.println("Using Buffered Reader:");
            int i = 1;
            while (true) {
                line = bfr.readLine();
                if (line == null) {
                    break;
                }
                console.println(i++ + ". " + line);
            }
        }
        catch (IOException e) {
            console.println(e.getMessage());
        }


    }
}