package gui;

import src.PatternInfo;
import src.Patterns;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class PatternGeneratorGUI extends JFrame {

    private final List<PatternInfo> patterns = List.of(
            new PatternInfo(1,
                    "Square",
                    "/pictures/P1.png",
                    Patterns::pattern1),
            new PatternInfo(2,
                    "Right Triangle",
                    "/pictures/P2.png",
                    Patterns::pattern2),
            new PatternInfo(3,
                    "Number Triangle",
                    "/pictures/P3.png",
                    Patterns::pattern3),
            new PatternInfo(4,
                    "Repeated Number Triangle",
                    "/pictures/P4.png",
                    Patterns::pattern4),
            new PatternInfo(5,
                    "Inverted Star Triangle",
                    "/pictures/P5.png",
                    Patterns::pattern5),
            new PatternInfo(6,
                    "Reverse Number Triangle",
                    "/pictures/P6.png",
                    Patterns::pattern6),
            new PatternInfo(7,
                    "Star Pyramid",
                    "/pictures/P7.png",
                    Patterns::pattern7),
            new PatternInfo(8,
                    "Inverted Star Pyramid",
                    "/pictures/P8.png",
                    Patterns::pattern8),
            new PatternInfo(9,
                    "Diamond",
                    "/pictures/P9.png",
                    Patterns::pattern9),
            new PatternInfo(10,
                    "Half Diamond",
                    "/pictures/P10.png",
                    Patterns::pattern10),
            new PatternInfo(11,
                    "Binary Triangle",
                    "/pictures/P11.png",
                    Patterns::pattern11),
            new PatternInfo(12,
                    "Number Crown",
                    "/pictures/P12.png",
                    Patterns::pattern12),
            new PatternInfo(13,
                    "Increasing Number Triangle",
                    "/pictures/P13.png",
                    Patterns::pattern13),
            new PatternInfo(14,
                    "Alphabet Triangle",
                    "/pictures/P14.png",
                    Patterns::pattern14),
            new PatternInfo(15,
                    "Reverse Alphabet Triangle",
                    "/pictures/P15.png",
                    Patterns::pattern15),
            new PatternInfo(16,
                    "Repeated Alphabet Triangle",
                    "/pictures/P16.png",
                    Patterns::pattern16),
            new PatternInfo(17,
                    "Alphabet Pyramid",
                    "/pictures/P17.png",
                    Patterns::pattern17),
            new PatternInfo(18,
                    "Reverse Alphabet Triangle",
                    "/pictures/P18.png",
                    Patterns::pattern18),
            new PatternInfo(19,
                    "Symmetric Butterfly",
                    "/pictures/P19.png",
                    Patterns::pattern19),
            new PatternInfo(20,
                    "Butterfly",
                    "/pictures/P20.png",
                    Patterns::pattern20),
            new PatternInfo(21,
                    "Hollow Square",
                    "/pictures/P21.png",
                    Patterns::pattern21),
            new PatternInfo(22,
                    "Concentric Rectangle",
                    "/pictures/P22.png",
                    Patterns::pattern22)
    );
    private JPanel bottomPanel;
    private JLabel statusBar;
    private int selectedPattern = -1;
    private final List<PatternCard> patternCards = new ArrayList<>();
    private JLabel selectedLabel;
    private JTextField rowsField;
    private JButton generateButton;
    private JButton copyButton;
    private JButton clearButton;
    private JPanel galleryPanel;
    private JPanel controlPanel;
    private JTextArea outputArea;

    private void createStatusBar() {
        statusBar = new JLabel("✓ Ready");

        statusBar.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));

        statusBar.setOpaque(true);

        statusBar.setBackground(new Color(240,240,240));

        bottomPanel.add(statusBar,BorderLayout.SOUTH);
    }

    private void addWindowCloseListener() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitApplication();
            }
        });
    }
    private void exitApplication() {
        int option = JOptionPane.showConfirmDialog(
                PatternGeneratorGUI.this,
                "Are you sure you want to exit Java Pattern Generator?",
                "Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if (option == JOptionPane.YES_OPTION)   dispose();
    }
    public PatternGeneratorGUI() {
        setTitle("Java Pattern Generator");

        java.net.URL iconURL =
                getClass().getResource("/pictures/icon.png");

        if (iconURL != null)    setIconImage(new ImageIcon(iconURL).getImage());
        else    System.out.println("Icon Not Found!");

        setSize(1200, 800);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        setLayout(new java.awt.BorderLayout(10, 10));

        createGallery();

        createControls();

        createOutputArea();

        createStatusBar();

        createMenuBar();

        addWindowCloseListener();

        setVisible(true);
    }
    private void showAboutDialog() {

        JPanel panel = new JPanel(new BorderLayout(15,15));
        panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        JLabel iconLabel = new JLabel();

        java.net.URL iconURL = getClass().getResource("/pictures/icon.png");

        if (iconURL != null) {
            ImageIcon icon = new ImageIcon(iconURL);

            Image scaled = icon.getImage().getScaledInstance(
                    64,
                    64,
                    Image.SCALE_SMOOTH
            );
        }
        panel.add(iconLabel, BorderLayout.WEST);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("" +
                "<html><span style='font-size:18pt'>" +
                "<b>Java Pattern Generator</b>" +
                "</span></html>");

        JLabel version = new JLabel("Version 1.0");

        JLabel developer = new JLabel("Developer: Aryan");

        JLabel javaVersion = new JLabel(
                "Java Version: " +
                        System.getProperty("java.version")
        );
        JLabel patternCount = new JLabel(
                "Patterns: " + patterns.size()
        );
        JLabel swing = new JLabel("Built using Java Swing");
        JLabel copyright = new JLabel("© 2026 Aryan");

        infoPanel.add(title);
        infoPanel.add(Box.createVerticalStrut(8));
        infoPanel.add(version);
        infoPanel.add(developer);
        infoPanel.add(javaVersion);
        infoPanel.add(patternCount);
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(swing);
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(copyright);

        panel.add(infoPanel, BorderLayout.CENTER);

        JOptionPane.showMessageDialog(
                this,
                panel,
                "About",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    private void createGallery() {
        galleryPanel = new JPanel();

        galleryPanel.setLayout(new GridLayout(0,4,10,10));

        galleryPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        for (PatternInfo pattern : patterns) {

            PatternCard card = new PatternCard(
                    pattern,
                    this::selectPattern
            );

            patternCards.add(card);
            galleryPanel.add(card);
        }

        JScrollPane scrollPane = new JScrollPane(galleryPanel);

        add(scrollPane, BorderLayout.CENTER);
    }
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem aboutItem = new JMenuItem("About");

        exitItem.setToolTipText("Close the application");
        aboutItem.setToolTipText("Information about this application");
        ToolTipManager.sharedInstance().setInitialDelay(700);
        ToolTipManager.sharedInstance().setReshowDelay(700);

        exitItem.addActionListener(e -> exitApplication());

        exitItem.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_Q,
                        InputEvent.CTRL_DOWN_MASK
                )
        );

        aboutItem.addActionListener(e -> showAboutDialog());

        fileMenu.add(exitItem);

        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);
    }
    private void createControls() {
        controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));

        selectedLabel = new JLabel("Selected Pattern : None");

        JLabel rowsLabel = new JLabel("Rows:");

        rowsField = new JTextField(5);

        generateButton = new JButton("Generate");
        copyButton = new JButton("Copy Output");
        clearButton = new JButton("Clear");

        generateButton.setToolTipText("Generate the selected pattern");
        copyButton.setToolTipText("Copy the generated pattern to the clipboard");
        clearButton.setToolTipText("Clear the current selection and output");
        rowsField.setToolTipText("Enter the number of rows");
        ToolTipManager.sharedInstance().setInitialDelay(700);
        ToolTipManager.sharedInstance().setReshowDelay(700);

        generateButton.addActionListener(e -> generatePattern());

        rowsField.addActionListener(e -> generatePattern());

        controlPanel.add(selectedLabel);
        controlPanel.add(rowsLabel);
        controlPanel.add(rowsField);
        controlPanel.add(generateButton);
        controlPanel.add(copyButton);
        controlPanel.add(clearButton);

        add(controlPanel, BorderLayout.NORTH);

        copyButton.setEnabled(false);

        clearButton.addActionListener(e -> {
            rowsField.setText("");
            outputArea.setText("Output will appear here...");
            selectedPattern = -1;
            selectedLabel.setText("Selected Pattern : None");

            for (PatternCard card : patternCards)   card.setSelected(false);

            copyButton.setEnabled(false);

            updateStatus("Application reset.");
        });

        copyButton.addActionListener(e -> {

            if (outputArea.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "Generate a pattern first.");
                return;
            }

            StringSelection selection = new StringSelection(outputArea.getText());

            Toolkit.getDefaultToolkit()
                    .getSystemClipboard()
                    .setContents(selection, null);

            updateStatus("Output copied to clipboard!");
        });
    }
    private void createOutputArea() {
        outputArea = new JTextArea();

        outputArea.setText("Output will appear here...");

        outputArea.setEditable(false);

        outputArea.setLineWrap(false);

        outputArea.setWrapStyleWord(false);

        outputArea.setCaretPosition(0);

        outputArea.setCaretColor(Color.WHITE);

        outputArea.setSelectionColor(new Color(33,66,131));

        outputArea.setMargin(new Insets(15,15,15,15));

        outputArea.setBackground(new Color(30,31,34));
        outputArea.setForeground(new Color(220,220,220));

        outputArea.setFont(new Font("Consolas", Font.PLAIN, 18));

        JScrollPane scroll = new JScrollPane(outputArea);

        scroll.getVerticalScrollBar().setUnitIncrement(16);

        scroll.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10,10,10,10),
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(new Color(80,80,80)),
                        "Generated Pattern"
                )
        ));

        scroll.setPreferredSize(new Dimension(1200, 300));

        bottomPanel = new JPanel(new BorderLayout());

        bottomPanel.add(scroll, BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);
    }
    private void selectPattern(int patternNumber) {
        selectedPattern = patternNumber;

        selectedLabel.setText("<html><b>Pattern " + patternNumber + "</b><br>" + patterns.get(selectedPattern -1).getName() + "</html>");

        updateStatus("Selected Pattern " + patternNumber + " - " + patterns.get(selectedPattern -1).getName());

        for (PatternCard card : patternCards)   card.setSelected(card.getPatternNumber() == patternNumber);
    }
    private void updateStatus(String message) {
        statusBar.setText("✓ " + message);
    }
    private void generatePattern() {
        if (selectedPattern == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please select a pattern.",
                    "No Pattern Selected",
                    JOptionPane.WARNING_MESSAGE
            );
            updateStatus("Please select a pattern.");
            return;
        }
        String text = rowsField.getText().trim();

        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter number of rows.",
                    "Missing Input",
                    JOptionPane.WARNING_MESSAGE
            );
            updateStatus("Rows must be greater than zero.");
            return;
        }

        int rows;
        try {
            rows = Integer.parseInt(text);
            if (rows <= 0)  throw new IllegalArgumentException();
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Rows must be a valid integer.",
                    "Invalid Input",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Rows must be greater than zero.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();

        java.io.PrintStream ps = new java.io.PrintStream(baos);

        java.io.PrintStream old = System.out;

        System.setOut(ps);

        patterns.get(selectedPattern -1).getGenerator().generate(rows);

        System.out.flush();

        System.setOut(old);

        outputArea.setText(baos.toString());

        outputArea.setCaretPosition(0);

        copyButton.setEnabled(true);

        updateStatus("Generated Pattern " + selectedPattern + ".");
    }
}
