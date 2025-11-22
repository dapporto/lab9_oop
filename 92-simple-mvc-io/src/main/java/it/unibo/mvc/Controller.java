package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File file; 
    private String path = System.getProperty("user.home") 
                        + File.separator
                        + "output.txt";

    public Controller(final File file, final String path) {
        this.file = file;
        this.path = path;
    }

    void setFile(final File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public String getPath() {
        return path;
    }

    public void write(final String text) throws IOException{
        try (final PrintStream ps = new PrintStream(this.path, StandardCharsets.UTF_8)) {
            ps.println(text);
        } catch (final IOException e) {
            System.out.println("Error during the writing"); // NOPMD
            e.printStackTrace();
        }
    }
}
