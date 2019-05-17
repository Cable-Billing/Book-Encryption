import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EncryptMenu {
    private JPanel encryptPanel;
    private JTextArea unencryptedMessageArea;
    private JButton encryptButton;
    private JLabel encryptedMessage;
    private boolean panelExists;

    public EncryptMenu() {
        panelExists = false;

        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!unencryptedMessageArea.getText().isEmpty()) {
                    try {
                        encryptedMessage.setText(ENCRYPT(unencryptedMessageArea.getText()));
                    } catch (FileNotFoundException ex) {
                        encryptedMessage.setText("Was unable to find book.txt");
                    }
                } else {
                    encryptedMessage.setText("There is no message to encrypt");
                }
            }
        });
    }

    // Sets up the panel
    public void createEncryptPanel() {
        // Checks to see if the window already exists
        if (!panelExists) {
            JFrame frame = new JFrame("Encrypt Menu");

            // Custom windowClosing function
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    removePanel();
                }
            });

            frame.setContentPane(new EncryptMenu().encryptPanel);
            frame.pack();
            frame.setVisible(true);
            panelExists = true;
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        }
    }

    // Remove the panel
    private void removePanel() {
        panelExists = false;
    }

    // Encrypts the message
    private String ENCRYPT(String messageToEncrypt) throws FileNotFoundException {
        // Create the string to build
        StringBuilder encryptedMessage = new StringBuilder();
        // The array containing the users input
        String[] wordArray = messageToEncrypt.split("\\s+");
        // Encrypt a line number and word number to each word
        int lineCount, wordCount;
        for (String word : wordArray) {
            // The text file to search through
            // A new scanner must be create every time to start from the start of the file again.
            Scanner reader = new Scanner(new File("../resources/book.txt"));
            // Search through the file line by line
            lineCount = 0;
            readLine:
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                // Increment line count
                lineCount += 1;
                // The array containing the lines words
                String[] lineWordArray = line.replaceAll("\\p{P}", "").split("\\s+");
                wordCount = 0;
                // Search through the line
                for (String lineWord : lineWordArray) {
                    // Increment word count
                    wordCount += 1;
                    // Check if the word matches
                    if (word.equalsIgnoreCase(lineWord)) {
                        // Append the string to the encryptedMessage
                        // Example: 38,8;
                        encryptedMessage.append(lineCount).append(",").append(wordCount).append(";");
                        break readLine;
                    }
                }
            }
        }
        // String should look similar to this: 38,8;563,54;11,9;
        return encryptedMessage.toString();
    }
}
