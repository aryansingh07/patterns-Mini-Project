package gui;

import javax.swing.*;
import java.awt.*;

public class AboutDialog extends JDialog {
    public AboutDialog (JFrame parent, int patternCount) {
        super(parent, "About", true);

        setLayout(new BorderLayout(15,15));

        JPanel content = new JPanel(new BorderLayout(15,15));
        content.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JLabel iconLabel = new JLabel();

        java.net.URL iconURL = getClass().getResource("/pictures/icon.png");

        if(iconURL != null ) {
            ImageIcon icon = new ImageIcon(iconURL);

            Image scaled = icon.getImage().getScaledInstance(
                    80,
                    80,
                    Image.SCALE_SMOOTH
            );
            iconLabel.setIcon(new ImageIcon(scaled));
        }
        content.add(iconLabel, BorderLayout.WEST);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("" +
                "<html><span style='font-size:22pt;" +
                "font-family:Segoe UI'>" +
                "<b>Java Pattern Generator</b>" +
                "</span></html>"
        );
        JLabel version = new JLabel("Version 1.0");
        JLabel
    }
}
