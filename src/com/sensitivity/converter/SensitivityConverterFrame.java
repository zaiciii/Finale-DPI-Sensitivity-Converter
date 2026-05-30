package com.sensitivity.converter;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class SensitivityConverterFrame extends JFrame {
    private JPanel jFrameMain;
    private JLabel jLabelTitle;
    private JLabel jLabelSourceGame;
    private JLabel jLabelTargetGame;
    private JLabel jLabelSourceSensitivity;
    private JLabel jLabelTargetSensitivity;
    private JLabel jLabelDPI;
    private JLabel jLabelTargetDPI;
    private JLabel jLabelResult;
    private JLabel jLabelResultValue;
    
    private JTextField jTextFieldSensitivity;
    private JTextField jTextFieldDPI;
    private JTextField jTextFieldTargetDPI;
    
    private GameButton[] jGameButtons;
    private GameButton jGameButtonSelected;
    private GameButton jGameButtonTargetSelected;
    
    private JButton jButtonConvert;
    private JButton jButtonReset;
    
    private Game selectedSourceGame;
    private Game selectedTargetGame;
    
    private static final Color DARK_BG = new Color(30, 32, 44);
    private static final Color PANEL_BG = new Color(45, 48, 62);
    private static final Color ACCENT_COLOR = new Color(100, 200, 255);
    private static final Color TEXT_COLOR = new Color(220, 220, 220);

    public SensitivityConverterFrame() {
        setTitle("🎮 Sensitivity DPI Converter - Gaming Sensitivity Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 750);
        setResizable(false);
        setLocationRelativeTo(null);
        
        initializeComponents();
        setupLayout();
        setupListeners();
    }

    private void initializeComponents() {
        jFrameMain = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(DARK_BG);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        jFrameMain.setLayout(null);
        jFrameMain.setOpaque(false);
        add(jFrameMain);

        // Title Label
        jLabelTitle = createStyledLabel("🎮 Sensitivity DPI Converter", 24, Font.BOLD);
        jLabelTitle.setBounds(50, 20, 900, 40);

        // Source Game Section
        jLabelSourceGame = createStyledLabel("SELECT SOURCE GAME", 14, Font.BOLD);
        jLabelSourceGame.setForeground(ACCENT_COLOR);
        jLabelSourceGame.setBounds(50, 70, 300, 25);

        // Game Buttons (Source)
        jGameButtons = new GameButton[Game.values().length];
        int xPos = 50;
        int yPos = 105;
        for (int i = 0; i < Game.values().length; i++) {
            jGameButtons[i] = new GameButton(Game.values()[i].getDisplayName());
            jGameButtons[i].setBounds(xPos, yPos, 120, 50);
            final int index = i;
            jGameButtons[i].addActionListener(e -> selectSourceGame(index));
            jFrameMain.add(jGameButtons[i]);
            xPos += 130;
            if (xPos > 800) {
                xPos = 50;
                yPos += 65;
            }
        }

        // Input Section
        int inputY = 240;
        jLabelSourceSensitivity = createStyledLabel("Source Sensitivity:", 12, Font.PLAIN);
        jLabelSourceSensitivity.setBounds(50, inputY, 150, 25);
        
        jTextFieldSensitivity = createStyledTextField();
        jTextFieldSensitivity.setBounds(220, inputY, 150, 35);

        jLabelDPI = createStyledLabel("Source DPI:", 12, Font.PLAIN);
        jLabelDPI.setBounds(50, inputY + 50, 150, 25);
        
        jTextFieldDPI = createStyledTextField();
        jTextFieldDPI.setText("400");
        jTextFieldDPI.setBounds(220, inputY + 50, 150, 35);

        jLabelTargetDPI = createStyledLabel("Target DPI:", 12, Font.PLAIN);
        jLabelTargetDPI.setBounds(450, inputY, 150, 25);
        
        jTextFieldTargetDPI = createStyledTextField();
        jTextFieldTargetDPI.setText("400");
        jTextFieldTargetDPI.setBounds(620, inputY, 150, 35);

        // Target Game Section
        jLabelTargetGame = createStyledLabel("SELECT TARGET GAME", 14, Font.BOLD);
        jLabelTargetGame.setForeground(ACCENT_COLOR);
        jLabelTargetGame.setBounds(50, 340, 300, 25);

        // Game Buttons (Target)
        xPos = 50;
        yPos = 375;
        GameButton[] targetGameButtons = new GameButton[Game.values().length];
        for (int i = 0; i < Game.values().length; i++) {
            targetGameButtons[i] = new GameButton(Game.values()[i].getDisplayName());
            targetGameButtons[i].setBounds(xPos, yPos, 120, 50);
            final int index = i;
            targetGameButtons[i].addActionListener(e -> selectTargetGame(index));
            jFrameMain.add(targetGameButtons[i]);
            xPos += 130;
            if (xPos > 800) {
                xPos = 50;
                yPos += 65;
            }
        }

        // Result Section
        jLabelTargetSensitivity = createStyledLabel("Converted Sensitivity:", 12, Font.PLAIN);
        jLabelTargetSensitivity.setBounds(50, 550, 200, 25);
        
        jLabelResultValue = createStyledLabel("0.00", 20, Font.BOLD);
        jLabelResultValue.setForeground(ACCENT_COLOR);
        jLabelResultValue.setBounds(270, 545, 200, 35);

        // Buttons
        jButtonConvert = createStyledButton("CONVERT", 450, 550);
        jButtonConvert.addActionListener(e -> performConversion());
        
        jButtonReset = createStyledButton("RESET", 600, 550);
        jButtonReset.addActionListener(e -> resetForm());

        // Add all components
        jFrameMain.add(jLabelTitle);
        jFrameMain.add(jLabelSourceGame);
        jFrameMain.add(jLabelSourceSensitivity);
        jFrameMain.add(jTextFieldSensitivity);
        jFrameMain.add(jLabelDPI);
        jFrameMain.add(jTextFieldDPI);
        jFrameMain.add(jLabelTargetDPI);
        jFrameMain.add(jTextFieldTargetDPI);
        jFrameMain.add(jLabelTargetGame);
        jFrameMain.add(jLabelTargetSensitivity);
        jFrameMain.add(jLabelResultValue);
        jFrameMain.add(jButtonConvert);
        jFrameMain.add(jButtonReset);

        // Add real-time conversion listener
        DocumentListener listener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { performConversion(); }
            @Override
            public void removeUpdate(DocumentEvent e) { performConversion(); }
            @Override
            public void changedUpdate(DocumentEvent e) { performConversion(); }
        };
        jTextFieldSensitivity.getDocument().addDocumentListener(listener);
        jTextFieldDPI.getDocument().addDocumentListener(listener);
        jTextFieldTargetDPI.getDocument().addDocumentListener(listener);
    }

    private void setupLayout() {
        setBackground(DARK_BG);
    }

    private void setupListeners() {
        // Listeners are set up in initializeComponents
    }

    private void selectSourceGame(int index) {
        if (jGameButtonSelected != null) {
            jGameButtonSelected.setSelected(false);
        }
        selectedSourceGame = Game.values()[index];
        jGameButtons[index].setSelected(true);
        jGameButtonSelected = jGameButtons[index];
        performConversion();
    }

    private void selectTargetGame(int index) {
        // Find and update target game button
        Game[] games = Game.values();
        for (int i = 0; i < games.length; i++) {
            if (i == index) {
                selectedTargetGame = games[i];
                // You might want to add visual feedback for target game selection
                break;
            }
        }
        performConversion();
    }

    private void performConversion() {
        if (selectedSourceGame == null || selectedTargetGame == null) {
            return;
        }

        try {
            double sensitivity = Double.parseDouble(jTextFieldSensitivity.getText());
            double sourceDPI = Double.parseDouble(jTextFieldDPI.getText());
            double targetDPI = Double.parseDouble(jTextFieldTargetDPI.getText());

            double result = SensitivityConverter.convertSensitivity(
                sensitivity, sourceDPI, selectedSourceGame, selectedTargetGame, targetDPI
            );

            jLabelResultValue.setText(String.format("%.2f", result));
        } catch (NumberFormatException e) {
            jLabelResultValue.setText("0.00");
        }
    }

    private void resetForm() {
        jTextFieldSensitivity.setText("");
        jTextFieldDPI.setText("400");
        jTextFieldTargetDPI.setText("400");
        jLabelResultValue.setText("0.00");
        selectedSourceGame = null;
        selectedTargetGame = null;
        if (jGameButtonSelected != null) {
            jGameButtonSelected.setSelected(false);
        }
    }

    private JLabel createStyledLabel(String text, int size, int style) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", style, size));
        label.setForeground(TEXT_COLOR);
        return label;
    }

    private JTextField createStyledTextField() {
        JTextField field = new JTextField();
        field.setBackground(new Color(55, 58, 72));
        field.setForeground(Color.WHITE);
        field.setCaretColor(ACCENT_COLOR);
        field.setBorder(BorderFactory.createLineBorder(ACCENT_COLOR, 2));
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        return field;
    }

    private JButton createStyledButton(String text, int x, int y) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(ACCENT_COLOR);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                g2d.setColor(Color.WHITE);
                g2d.setFont(getFont());
                FontMetrics fm = g2d.getFontMetrics();
                int textX = (getWidth() - fm.stringWidth(getText())) / 2;
                int textY = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
                g2d.drawString(getText(), textX, textY);
            }
        };
        button.setBounds(x, y, 120, 45);
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }
}
