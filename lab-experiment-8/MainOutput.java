import java.io.*;
class MainOutput {
    public static void main(String[] args) {
        FileInputStream fin = null;
        FileOutputStream fout = null;
        try {
            // Open the files
            fin = new FileInputStream("input.txt");
            fout = new FileOutputStream("output.txt");
            int x;
// Read from input file and write to output file
            while ((x = fin.read()) != -1) {
                fout.write(x);
            }
        }
        catch (Exception e) {
                    System.out.println(e);
        } finally {

            try {
                if (fin != null)
                    fin.close();

                if (fout != null)
                    fout.close();

            } catch (IOException e) {

                System.out.println("Error Closing File");
            }
        }
    }
}
