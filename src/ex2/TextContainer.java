package ex2;

import java.io.*;
import java.io.PrintWriter;

@SaveTo
public class TextContainer {
    private String str;

    public TextContainer() {
        this.str = "Hello";
    }

    @Saver
    public void save(String path) {
        try {
            PrintWriter printWriter = new PrintWriter(path);
            printWriter.write(str);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
