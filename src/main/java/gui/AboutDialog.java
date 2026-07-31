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
        JLabel developer =
                new JLabel("Developer: Aryan");

        JLabel javaVersion =
                new JLabel(
                        "Java Version: "
                                + System.getProperty("java.version")
                );

        JLabel patterns =
                new JLabel(
                        "Patterns: "
                                + patternCount
                );

        JLabel swing =
                new JLabel("Built using Java Swing");

        JLabel copyright =
                new JLabel("© 2026 Aryan");

        infoPanel.add(title);
        infoPanel.add(Box.createVerticalStrut(8));
        infoPanel.add(version);
        infoPanel.add(developer);
        infoPanel.add(javaVersion);
        infoPanel.add(patterns);
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(swing);
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(copyright);

        content.add(infoPanel, BorderLayout.CENTER);

        add(content, BorderLayout.CENTER);

        // ---------- Close Button ----------
        JButton closeButton = new JButton("Close");

        closeButton.addActionListener(e -> dispose());

        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(new JSeparator(), BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);

        southPanel.add(buttonPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        add(buttonPanel, BorderLayout.SOUTH);

        pack();

        setResizable(false);

        setLocationRelativeTo(parent);

        JLabel subtitle =
                new JLabel("Learn • Visualize • Practice");
        subtitle.setForeground(Color.GRAY);

        infoPanel.add(title);
        infoPanel.add(subtitle);
        infoPanel.add(Box.createVerticalStrut(8));
    }
}