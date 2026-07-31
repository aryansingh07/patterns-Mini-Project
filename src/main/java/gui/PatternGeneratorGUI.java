package gui;

import components.*;

import java.awt.event.*;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.util.Locale;


public class PatternGeneratorGUI extends JFrame {

    private final List<PatternInfo> patterns = List.of(
            new PatternInfo(1,
                    "Square",
                    "/pictures/P1.png",
                    Patterns::pattern1,
                    PatternSource.PATTERN1),
            new PatternInfo(2,
                    "Right Triangle",
                    "/pictures/P2.png",
                    Patterns::pattern2,
                    PatternSource.PATTERN2),
            new PatternInfo(3,
                    "Number Triangle",
                    "/pictures/P3.png",
                    Patterns::pattern3,
                    PatternSource.PATTERN3),
            new PatternInfo(4,
                    "Repeated Number Triangle",
                    "/pictures/P4.png",
                    Patterns::pattern4,
                    PatternSource.PATTERN4),
            new PatternInfo(5,
                    "Inverted Star Triangle",
                    "/pictures/P5.png",
                    Patterns::pattern5,
                    PatternSource.PATTERN5),
            new PatternInfo(6,
                    "Reverse Number Triangle",
                    "/pictures/P6.png",
                    Patterns::pattern6,
                    PatternSource.PATTERN6),
            new PatternInfo(7,
                    "Star Pyramid",
                    "/pictures/P7.png",
                    Patterns::pattern7,
                    PatternSource.PATTERN7),
            new PatternInfo(8,
                    "Inverted Star Pyramid",
                    "/pictures/P8.png",
                    Patterns::pattern8,
                    PatternSource.PATTERN8),
            new PatternInfo(9,
                    "Diamond",
                    "/pictures/P9.png",
                    Patterns::pattern9,
                    PatternSource.PATTERN9),
            new PatternInfo(10,
                    "Half Diamond",
                    "/pictures/P10.png",
                    Patterns::pattern10,
                    PatternSource.PATTERN10),
            new PatternInfo(11,
                    "Binary Triangle",
                    "/pictures/P11.png",
                    Patterns::pattern11,
                    PatternSource.PATTERN11),
            new PatternInfo(12,
                    "Number Crown",
                    "/pictures/P12.png",
                    Patterns::pattern12,
                    PatternSource.PATTERN12),
            new PatternInfo(13,
                    "Increasing Number Triangle",
                    "/pictures/P13.png",
                    Patterns::pattern13,
                    PatternSource.PATTERN13),
            new PatternInfo(14,
                    "Alphabet Triangle",
                    "/pictures/P14.png",
                    Patterns::pattern14,
                    PatternSource.PATTERN14),
            new PatternInfo(15,
                    "Reverse Alphabet Triangle",
                    "/pictures/P15.png",
                    Patterns::pattern15,
                    PatternSource.PATTERN15),
            new PatternInfo(16,
                    "Repeated Alphabet Triangle",
                    "/pictures/P16.png",
                    Patterns::pattern16,
                    PatternSource.PATTERN16),
            new PatternInfo(17,
                    "Alphabet Pyramid",
                    "/pictures/P17.png",
                    Patterns::pattern17,
                    PatternSource.PATTERN17),
            new PatternInfo(18,
                    "Reverse Alphabet Triangle",
                    "/pictures/P18.png",
                    Patterns::pattern18,
                    PatternSource.PATTERN18),
            new PatternInfo(19,
                    "Symmetric Butterfly",
                    "/pictures/P19.png",
                    Patterns::pattern19,
                    PatternSource.PATTERN19),
            new PatternInfo(20,
                    "Butterfly",
                    "/pictures/P20.png",
                    Patterns::pattern20,
                    PatternSource.PATTERN20),
            new PatternInfo(21,
                    "Hollow Square",
                    "/pictures/P21.png",
                    Patterns::pattern21,
                    PatternSource.PATTERN21),
            new PatternInfo(22,
                    "Concentric Rectangle",
                    "/pictures/P22.png",
                    Patterns::pattern22,
                    PatternSource.PATTERN22)
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
    private JMenuItem exportItem;
    private JMenuItem exportCodeItem;
    private JCheckBoxMenuItem darkModeItem;
    private JButton copyCodeButton;

    private void copyOutput() {
        if (outputArea.getText().trim().isEmpty()
        || outputArea.getText().equals(
                "Output will appear here..."
        )) {
            JOptionPane.showMessageDialog(
                    this,
                    "Generate a pattern before copying.",
                    "No Output",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        StringSelection selection =
                new StringSelection(outputArea.getText());

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
                selection,null
        );
        updateStatus("Output copied to clipboard!");

        JOptionPane.showMessageDialog(
                this,
                "Pattern copied to clipboard!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    private void createStatusBar() {
        statusBar = new JLabel("✓ Ready");

        statusBar.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));

        statusBar.setOpaque(true);

        statusBar.setBackground(new Color(240,240,240));

        bottomPanel.add(statusBar,BorderLayout.SOUTH);
    }
    private void setOutputControlsEnabled(boolean enabled) {
        clearButton.setEnabled(enabled);
        copyButton.setEnabled(enabled);
        copyCodeButton.setEnabled(enabled);

        if (exportItem != null) exportItem.setEnabled(enabled);
        if (exportCodeItem != null) exportCodeItem.setEnabled(enabled);
    }
    private void copyCode() {
        if (selectedPattern == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Generate a pattern first",
                    "No Code",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        String code =
                patterns.get(selectedPattern -1).getSourceCode();

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
                new StringSelection(code),null
        );
        updateStatus("Pattern source code copied.");

        JOptionPane.showMessageDialog(
                this,
                "Pattern source code copied!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );
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
        setTitle(Constants.APP_TITLE);

        java.net.URL iconURL =
                getClass().getResource("/pictures/icon.png");

        if (iconURL != null)    setIconImage(new ImageIcon(iconURL).getImage());
        else    System.out.println("Icon Not Found!");

        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        setLayout(new java.awt.BorderLayout(10, 10));

        createGallery();

        createMenuBar();

        createControls();

        createOutputArea();

        createStatusBar();

        addWindowCloseListener();

        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK),
                        "exportOutput");

        getRootPane().getActionMap().put("exportOutput", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                exportOutput();
            }
        });

        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                        .put(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK),
                                "generate");

        getRootPane().getActionMap().put("generate", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generatePattern();
            }
        });

        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                                InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK),
                        "exportCode");

        getRootPane().getActionMap().put("exportCode", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportCode();
            }
        });

        ThemeManager.applyTheme(this);

        setVisible(true);
    }
    private void showAboutDialog() {

        AboutDialog dialog =
                new AboutDialog(
                        this,
                        patterns.size()
                );
        dialog.setVisible(true);
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
    private void exportCode() {
        if (selectedPattern == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Select a pattern first.",
                    "No Pattern",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        String code = patterns.get(selectedPattern -1).getSourceCode();

        if (code == null || code.trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "No source code available.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Export Source Code");

        int result = chooser.showSaveDialog(this);

        if (result != JFileChooser.APPROVE_OPTION)  return;

        File file = chooser.getSelectedFile();

        if (file.exists()) {
            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "This file already exists.\nDo you want to replace it?",
                    "Confirm overwrite",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );
            if (choice != JOptionPane.YES_OPTION)   return;
        }
        if (!file.getName().toLowerCase(Locale.ROOT).endsWith(".java")) {
            file = new File(file.getAbsolutePath() + ".java");
        }
        try {
            java.nio.file.Files.writeString(
                    file.toPath(),
                    code
            );
            updateStatus("Source code exported successfully.");

            JOptionPane.showMessageDialog(
                    this,
                    "Source code exported successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Unable to save the file.\n" + ex.getMessage(),
                    "Export Failed",
                    JOptionPane.ERROR_MESSAGE
            );
            updateStatus("Source code export failed.");
        }
    }
    private void exportOutput() {
        JOptionPane.showMessageDialog(this, "Export clicked!");

        if (outputArea.getText().trim().isEmpty()
        || outputArea.getText().equals("Output will appear here...")
        ) {
            JOptionPane.showMessageDialog(
                    this,
                    "Generate a pattern before exporting!",
                    "No Output",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Export Pattern");
        int result = chooser.showSaveDialog(this);
        if (result != JFileChooser.APPROVE_OPTION)  return;

        File file = chooser.getSelectedFile();

        if (!file.getName().toLowerCase(Locale.ROOT).endsWith(".txt")) {
            file = new File(file.getAbsolutePath() + ".txt");
        }
        if (file.exists()) {
            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "This file already exists.\nDo you want to replace it?",
                    "Confirm Overwrite",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );
            if (choice != JOptionPane.YES_OPTION) return;
        }
        try {
            java.nio.file.Files.writeString(
                    file.toPath(),
                    outputArea.getText()
            );
            updateStatus("Pattern exported successfully.");

            JOptionPane.showMessageDialog(
                    this,
                    "Pattern exported successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Unable to save the file.\n" + ex.getMessage(),
                    "Export Failed",
                    JOptionPane.ERROR_MESSAGE
            );
            updateStatus("Export failed.");
        }
    }
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        exportItem = new JMenuItem("Export Output...");
        exportCodeItem = new JMenuItem("Export Code...");
        JMenu helpMenu = new JMenu("Help");
        JMenu viewMenu = new JMenu("View");

        darkModeItem = new JCheckBoxMenuItem(
                "Dark Mode",
                ThemeManager.isDarkMode());

        viewMenu.add(darkModeItem);

        menuBar.add(viewMenu);

        darkModeItem.setSelected(
                ThemeManager.isDarkMode()
        );

        darkModeItem.addActionListener(e -> {
            ThemeManager.setDarkMode(darkModeItem.isSelected());
            ThemeManager.applyTheme(this);
        });

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
        exportItem.addActionListener(e -> exportOutput());
        exportCodeItem.addActionListener(e -> exportCode());

        aboutItem.addActionListener(e ->showAboutDialog());

        fileMenu.add(exportItem);
        fileMenu.add(exportCodeItem);
        fileMenu.addSeparator();
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

        rowsField = new JTextField(String.valueOf(Constants.DEFAULT_ROWS));

        generateButton = new JButton("Generate");
        generateButton.setMnemonic(KeyEvent.VK_G);
        copyButton = new JButton("Copy Output");
        copyCodeButton = new JButton("Copy Code");
        clearButton = new JButton("Clear");

        generateButton.setToolTipText("Generate the selected pattern");
        copyButton.setToolTipText("Copy the generated pattern to the clipboard");
        copyCodeButton.setToolTipText("Copy the source code of selected pattern to the clipboard");
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
        controlPanel.add(copyCodeButton);
        controlPanel.add(clearButton);

        add(controlPanel, BorderLayout.NORTH);

        setOutputControlsEnabled(false);

        clearButton.addActionListener(e -> {
            rowsField.setText("");
            outputArea.setText("Output will appear here...");
            selectedPattern = -1;
            selectedLabel.setText("Selected Pattern : None");

            for (PatternCard card : patternCards)   card.setSelected(false);

            setOutputControlsEnabled(false);

            updateStatus("Application reset.");
        });

        copyButton.addActionListener(e -> copyOutput());

        copyCodeButton.addActionListener(e -> copyCode());
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

        setOutputControlsEnabled(true);

        updateStatus("Generated Pattern " + selectedPattern + ".");
    }
}
