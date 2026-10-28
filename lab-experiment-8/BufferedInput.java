import java.io.*;
class BufferedInput {
    public static void main(String[] args) throws IOException {
        FileInputStream fin = new FileInputStream("input.txt");
        BufferedInputStream bin = new BufferedInputStream(fin);
        // Mark the beginning of the stream
        bin.mark(100);
        // Skip the first 5 bytes
        bin.skip(5);
        System.out.println("After skip():");
        int ch;
        while ((ch = bin.read()) != -1)
            System.out.print((char) ch);

        // Return to the marked position
        bin.reset();
        System.out.println("\n\nAfter reset():");
        while ((ch = bin.read()) != -1)
            System.out.print((char) ch);
        bin.close();
    }
}
