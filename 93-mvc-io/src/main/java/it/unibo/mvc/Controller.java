package it.unibo.mvc;

import java.util.List;

/**
 * Simple controller able to print only on the stdout.
 */
public interface Controller {

    /**
     * It prints on standard output. 
     */
    void print();

    /**
     * It takes the next element to print.
     * 
     * @return the next {@code String} to print
     * @throws IllegalStateException if the {@code String} saved is inconsistent
     */
    String getNextString();

    /**
     * Show the history pf the elements printed.
     * 
     * @return the {@code List<String>} of the elements printed
     */
    List<String> stringsHistory();

    /**
     * Set the next string to print.
     * 
     * @param text the {@code String} to prepare for the printing
     * @throws IllegalArgumentException if the {@code String} passed is null
     */
    void setNextString(String text);

}
