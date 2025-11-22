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

    /**
     * Constructor that define the file to work on.
     * 
     * @param file the file to be written
     */
    public Controller(final File file) {
        this.file = file;
    }

    /**
     * Set the file as current file.
     * 
     * @param file the file to work on
     */
    void setFile(final File file) {
        this.file = file;
        this.path = file.getAbsolutePath();
    }

    /**
     * Get the current saved {@code File}.
     * 
     * @return the current file
     */
    public File getFile() {
        return file;
    }

    /**
     * Get the path of the current file. 
     * 
     * @return the {@code String} of the file's path
     */
    public String getPath() {
        return path;
    }

    /**
     * Write the text on the file.
     * 
     * @param text the text to write on the file
     * @throws IOException if the creation of the InputStream fails
     */
    public void write(final String text) throws IOException {
        try (PrintStream ps = new PrintStream(this.path, StandardCharsets.UTF_8)) {
            ps.println(text);
        } catch (final IOException e) {
            System.out.println("Error during the writing"); // NOPMD
            e.printStackTrace(); // NOPMD
        }
    }
}
