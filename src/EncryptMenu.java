import javax.swing.*;

public class EncryptMenu {
    private JPanel encryptPanel;

    public void createEncryptPanel() {
        JFrame frame = new JFrame("Encrypt Menu");
        frame.setContentPane(new EncryptMenu().encryptPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
