import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    private JPanel choicePanel;
    private JButton encryptButton;
    private JButton decryptButton;
    private static EncryptMenu encrypt;
    private static DecryptMenu decrypt;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Main Menu");
        frame.setContentPane(new MainMenu().choicePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        encrypt = new EncryptMenu();
        decrypt = new DecryptMenu();
    }

    public MainMenu() {
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encrypt.createEncryptPanel();
            }
        });

        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decrypt.createDecryptPanel();
            }
        });
    }
}
