package gui;

import components.Constants;
import components.ThemeManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WelcomeScreen extends JFrame {
    public WelcomeScreen() {
        setTitle("Welcome");

        java.net.URL iconURL =
                getClass().getResource("/pictures/icon.png");
        if (iconURL != null) {
            setIconImage(new ImageIcon(iconURL).getImage());
        }
        setSize(Constants.WELCOME_WIDTH,Constants.WELCOME_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout(15,15));

        JLabel title = new JLabel("Java Pattern Generator",
                SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 34));

        JLabel subtitle = new JLabel("Desktop Edition v1.0",
                SwingConstants.CENTER);
        subtitle.setFont(new Font("SansSerif", Font.ITALIC,18));

        JPanel header = new JPanel(new GridLayout(2,1));
        header.setBorder(BorderFactory.createEmptyBorder(15,0,10,0));

        header.add(title);
        header.add(subtitle);

        add(header,BorderLayout.NORTH);

        JEditorPane info = new JEditorPane();
        info.setContentType("text/html");
        info.setEditable(false);
        info.setOpaque(false);
        info.setText("""
        <html>
        <body style = "font-family : Sans-Serif;
                        font-size : 14px; margin:15px;">
        
        <h2>Welcome!</h2>
        
        <p>
        Thank You for using <b>Java Pattern Generator</b>.
        This desktop application helps you learn, generate, and explore
        Java pattern programs through an interactive graphical interface.
        </p>
        
        <h2>Features</h2>
        <ul>
        <li>Generate 22 Java Pattern Programs</li>
        <li>Copy Generated Output</li>
        <li>Copy Java Source Code</li>
        <li>Export generated output (.txt)</li>
        <li>Export Source Code (.java)</li>
        <li>Interactive Pattern Gallery</li>
        <li>Input Validation</li>
        <li>Status Bar Updates</li>
        </ul>
        
        <h2>Keyboard Shortcuts</h2>
        
        <table cellpaddings="5">
        <tr><td><b>Enter</b></td>-<td>Generate Pattern</td></tr>
        <tr><td><b>Ctrl + G</b></td>-<td>Generate Pattern</td></tr>
        <tr><td><b>Ctrl + S</b></td>-<td>Export Output</td></tr>
        <tr><td><b>Ctrl + Shift + S</b></td>-<td>Export Code file</td></tr>
        <tr><td><b>Ctrl + Q</b></td>-<td>Exit Application</td></tr>
        </table>
        
        <h2>Project Highlights</h2>
        <ul>
        <li>Java Swing GUI</li>
        <li>Gradle Build System</li>
        <li>Clipboard Integration</li>
        <li>Export Support</li>
        <li>Status Bar Notification</li>
        <li>Input Validation</li>
        </ul>
        
        <h2>About</h2>
        <p>
        Built using <b>Java Swing</b> and <b>Gradle</b>.<br>
        Designed to provide an easy way to learn and visualize
        common programming patterns.
        </p>
        <hr>
        <p align="center">
        <b>Developed by Aryan</b><br>
        Java &bull; Swing &bull; Gradle
        </p>
        </body>
        </html>
        """);

        ((JComponent) getContentPane()).setBorder(
                BorderFactory.createEmptyBorder(10,10,10,10)
        );
        add(new JScrollPane(info), BorderLayout.CENTER);

        JButton startButton = new JButton("Start Application");

        startButton.setFont(new Font("SansSerif", Font.BOLD,16));
        startButton.setPreferredSize(new Dimension(220,40));

        startButton.addActionListener(e -> {
            new PatternGeneratorGUI();
            dispose();
        });

        getRootPane().setDefaultButton(startButton);
        JLabel footer = new JLabel(
                "Developed by Aryan",
                SwingConstants.CENTER
        );
        footer.setFont(new Font("SansSerif",Font.PLAIN,12));

        JPanel bottom = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);

        bottom.add(buttonPanel,BorderLayout.CENTER);
        bottom.add(footer,BorderLayout.SOUTH);

        add(bottom,BorderLayout.SOUTH);

        ThemeManager.applyTheme(this);

        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitApplication();
            }
        });
    }
    private void exitApplication() {
        int option = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to exit Java Pattern Generator?",
                "Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if (option == JOptionPane.YES_OPTION) {
            dispose();
        }
    }
}
