package components;

import javax.swing.*;
import java.awt.*;
import java.util.prefs.Preferences;

public class ThemeManager {

    private static final Preferences PREFS =
            Preferences.userRoot().node("JavaPatternGenerator");

    private static boolean darkMode =
            PREFS.getBoolean("darkMode",false);

    public static boolean isDarkMode() {
        return darkMode;
    }
    public static void setDarkMode (boolean enabled) {
        darkMode = enabled;
        PREFS.putBoolean("darkMode", enabled);
    }
    public static void applyTheme(Component component) {
        apply(component);

        if (component instanceof Window window) {
            SwingUtilities.updateComponentTreeUI(window);
        }
    }
    private static void apply(Component component) {
        if (component == null)  return;

        Color background;
        Color foreground;

        if (darkMode) {
            background = new Color(43,43,43);
            foreground = Color.WHITE;
        }
        else {
            background = UIManager.getColor("Panel.background");
            foreground = Color.BLACK;
        }
        if (component instanceof JPanel
        || component instanceof JScrollPane
        || component instanceof JMenuBar
        || component instanceof JMenu
        || component instanceof JToolBar) {

            component.setBackground(background);
            component.setForeground(foreground);
        }
        if (component instanceof JButton button) {
            button.setBackground(background);
            button.setForeground(foreground);
        }
        if (component instanceof JLabel label) {
            label.setBackground(background);
            label.setForeground(foreground);
        }
        if (component instanceof JTextArea area) {
            area.setBackground(background);
            area.setForeground(foreground);
            area.setCaretColor(foreground);
        }
        if (component instanceof JTextField field) {
            field.setBackground(background);
            field.setForeground(foreground);
            field.setCaretColor(foreground);
        }
        if (component instanceof JEditorPane pane) {
            pane.setBackground(background);
            pane.setForeground(foreground);
            pane.setCaretColor(foreground);
        }
        if (component instanceof Container container) {
            for (Component child : container.getComponents()) {
                apply(child);
            }
        }
    }
}
