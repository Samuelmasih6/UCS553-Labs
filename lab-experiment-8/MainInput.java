import java.io.*;
class MainInput {
    public static void main(String[] args) {

        try {
            FileInputStream f = new FileInputStream("input.txt");

            int x;
            while ((x = f.read()) != -1) {
                System.out.print((char)x);
            }

            f.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
