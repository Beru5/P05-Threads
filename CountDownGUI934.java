import javax.swing.*;
import java.awt.*;

public class CountDownGUI934 extends JFrame {
    JLabel label;

    CountDownGUI934(String title) {
        super(title);
        label = new JLabel("Starting to count..");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new Panel(), BorderLayout.WEST);
        getContentPane().add(label);
        setSize(300,300);
        setVisible(true);
    }

    void startCount() {
        try {
        for (int i = 10; i > 0; i--) {
        Thread.sleep(1000);
        label.setText(i + "");
        }
        Thread.sleep(1000);
        
        label.setText("Count down completed..");
        
        Thread.sleep(1000);
    
    } 
    catch (InterruptedException ie) {
    }
    label.setText(Thread.currentThread().toString());
    }

    public static void main(String args[]) {
        CountDownGUI934 cdg = new CountDownGUI934("Count down GUI");
        cdg.startCount();
    }
}