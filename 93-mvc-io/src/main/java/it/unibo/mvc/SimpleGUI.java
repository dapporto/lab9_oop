package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {
    private static final int PROPORTION = 5;
    private final SimpleController controller = new SimpleController();
    private final JFrame frame = new JFrame();

    /**
     * It creates a simple gui. 
     */
    public SimpleGUI() {
        final JPanel panel = new JPanel(new BorderLayout());
        final JPanel innerPanel = new JPanel(new BorderLayout());
        final JTextField textField = new JTextField();
        final JTextArea textArea = new JTextArea();
        final JButton print = new JButton("Print");
        final JButton showHistory = new JButton("Show history");
        panel.add(innerPanel, BorderLayout.SOUTH);
        innerPanel.add(print, BorderLayout.LINE_START);
        innerPanel.add(showHistory, BorderLayout.LINE_END);
        panel.add(textField, BorderLayout.NORTH);
        panel.add(textArea, BorderLayout.CENTER);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.setNextString(textField.getText());
                controller.print();
            }
        });

        showHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                for (final String s : controller.stringsHistory()) {
                    textArea.append(s + "");
                }
            }
        });
    }

    /**
     * It gives dimension to the GUI. 
     */
    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = (int) screen.getWidth();
        final int height = (int) screen.getHeight();
        frame.setSize(width / PROPORTION, height / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Launches the application.
     * 
     * @param args ignored 
     */
    public static void main(final String... args) {
        new SimpleGUI().display();
    } 

}
