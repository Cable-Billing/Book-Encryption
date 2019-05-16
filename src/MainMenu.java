import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    private JPanel choicePanel;
    private JButton encryptButton;
    private JButton decryptButton;
    private EncryptMenu encrypt;
    private DecryptMenu decrypt;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Main Menu");
        frame.setContentPane(new MainMenu().choicePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public MainMenu() {
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encrypt = new EncryptMenu();
                encrypt.createEncryptPanel();
            }
        });

        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decrypt = new DecryptMenu();
                decrypt.createDecryptPanel();
            }
        });
    }
}
