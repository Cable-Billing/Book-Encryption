import javax.swing.*;
import java.awt.*;

public class DecryptMenu {
    private JPanel decryptPanel;

    public void createDecryptPanel() {
        JFrame frame = new JFrame("Encrypt Menu");
        frame.setContentPane(new DecryptMenu().decryptPanel);
        frame.pack();
        frame.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
    }
}
