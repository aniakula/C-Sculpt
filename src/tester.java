
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class tester {

    public static void main(String[] args) {
        JFrame testFrame = new JFrame("ramka testowa");
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel picture = new JLabel(new ImageIcon(
                new BufferedImage(370, 1200, BufferedImage.TYPE_INT_RGB)));
        JScrollPane scrollPane = new JScrollPane(picture);

        JPanel insidePanel = new JPanel(new BorderLayout());
        insidePanel.add(scrollPane);
        testFrame.add(insidePanel, BorderLayout.CENTER);

        insidePanel.add(new JLabel("Stay"), BorderLayout.LINE_START);
        insidePanel.add(new JLabel("Stay"), BorderLayout.LINE_END);
        insidePanel.add(new JLabel("Stay"), BorderLayout.PAGE_START);
        insidePanel.add(new JLabel("Stay"), BorderLayout.PAGE_END);

        testFrame.pack();

        testFrame.setSize(400, 400);
        // failing to do this will end the main & the app.
        // doing it will cause the EDT to start.
        testFrame.setVisible(true);
    }
}