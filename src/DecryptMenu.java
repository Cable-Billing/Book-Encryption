import javax.swing.*;

public class DecryptMenu {
    private JPanel decryptPanel;

    public void createDecryptPanel() {
        JFrame frame = new JFrame("Encrypt Menu");
        frame.setContentPane(new DecryptMenu().decryptPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
