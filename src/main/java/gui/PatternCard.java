package gui;

import components.Constants;
import components.PatternInfo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PatternCard extends JPanel {
    private final PatternInfo pattern;
    private static final Color DEFAULT_BORDER = Color.LIGHT_GRAY;
    private static final Color HOVER_BORDER = new Color(100, 149, 237);
    private static final Color SELECTED_BORDER = new Color(0, 120, 215);
    private boolean selected = false;
    private final gui.PatternSelectionListener listener;


    public int getPatternNumber() {
        return pattern.getNumber();
    }

    private JLabel createImageLabel(PatternInfo pattern) {
        JLabel label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);

        java.net.URL imageURL =
                getClass().getResource(pattern.getImagePath());

        if (imageURL != null) {
            ImageIcon icon = new ImageIcon(imageURL);
            Image scaled = icon.getImage().getScaledInstance(160,120,Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(scaled));
        }
        else    label.setText("Image Not Found!");

        return label;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;

        if (selected)   setBorder(BorderFactory.createLineBorder(SELECTED_BORDER, 3));

        else setBorder(BorderFactory.createLineBorder(DEFAULT_BORDER,1));

        repaint();
    }
    public PatternCard(
            PatternInfo pattern,
            PatternSelectionListener listener) {

        this.pattern = pattern;
        this.listener = listener;

        setBackground(Color.WHITE);

        setLayout(new BorderLayout());

        setBorder(BorderFactory.createLineBorder(
                DEFAULT_BORDER,1
        ));

        setPreferredSize(new Dimension(Constants.CARD_WIDTH, Constants.CARD_HEIGHT));

        JLabel imageLabel = createImageLabel(pattern);

        JLabel title = new JLabel("<html><center><b>Pattern " + pattern.getNumber() + "</b><br>" + pattern.getName() + "</center></html>");

        title.setHorizontalAlignment(SwingConstants.CENTER);

        add(imageLabel, BorderLayout.CENTER);

        add(title, BorderLayout.SOUTH);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                listener.onPatternSelected(pattern.getNumber());
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!selected)  setBorder(BorderFactory.createLineBorder(HOVER_BORDER, 2));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!selected)  setBorder(BorderFactory.createLineBorder(DEFAULT_BORDER, 1));
            }
        });
        setToolTipText("Pattern " + pattern.getNumber() + " - " + pattern.getName());
        ToolTipManager.sharedInstance().setInitialDelay(700);
        ToolTipManager.sharedInstance().setReshowDelay(700);
    }
}
