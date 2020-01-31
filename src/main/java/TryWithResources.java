import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TryWithResources {

    public static void main(String[] args) {
        String s1 = "hello world";
        String s2 = "Eyooooooo!";
        String s3 = "No problemo";

        String s = String.join("\n", s1, s2, s3);

        try (PrintWriter writer = new PrintWriter(new File("test.txt"))) {
            writer.print(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (Scanner scanner = new Scanner(new File("test.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }

        s = s.substring(0, s.length() - 1);
        System.out.println("substring s: \n" + s);
    }
}


