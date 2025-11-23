package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple controller responsible of I/O access.
 */
public final class SimpleController implements Controller {

    private final List<String> printedStrings = new ArrayList<>();
    private String stringToPrint;

    /**
     * {@inheritDoc} 
     */
    @Override
    public void print() {
        if (Objects.nonNull(this.stringToPrint)) {
            System.out.println(this.stringToPrint); // NOPMD
        }
    }

    /**
     * {@inheritDoc} 
     */
    @Override
    public String getNextString() {
        if (Objects.isNull(stringToPrint)) {
            throw new IllegalStateException("The string to print is null");
        }
        return this.stringToPrint;
    }

    /**
     * {@inheritDoc} 
     */
    @Override
    public List<String> stringsHistory() {
        final List<String> result = new ArrayList<>();
        for (final String s : printedStrings) {
            result.add(s);
        }
        return result;
    }

    /**
     * {@inheritDoc} 
     */
    @Override
    public void setNextString(final String text) {
        if (Objects.nonNull(text)) {
            this.stringToPrint = text;
            this.printedStrings.add(text);
        } else {
            throw new IllegalArgumentException("The element passed is null");
        }
    }

}
