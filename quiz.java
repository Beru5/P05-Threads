import javax.swing.*;
import java.awt.*;

public class quiz extends JFrame {
    private String text = "Bernardo x Keqing";
    private int xPosition = 0;

    public quiz() {
        setTitle("Moving Banner");
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        BannerPanel bannerPanel = new BannerPanel();

        setLayout(new BorderLayout());
        add(bannerPanel, BorderLayout.CENTER);

        setVisible(true);

        
        new Thread(() -> moveText(bannerPanel)).start();
    }

    private void moveText(JPanel panel) {
        while (true) {
            xPosition += 5;
            if (xPosition > panel.getWidth()) {
                xPosition = -panel.getFontMetrics(panel.getFont()).stringWidth(text);
            }
            panel.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class BannerPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setFont(new Font("SansSerif", Font.BOLD, 24));
            setBackground(Color.orange);
            g.drawString(text, xPosition, getHeight() / 2);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(quiz::new);
    }
}
