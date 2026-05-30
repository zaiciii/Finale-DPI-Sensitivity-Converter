package com.sensitivity.converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;

public class GameButton extends JButton {
    private boolean isSelected = false;
    private Color baseColor;
    private Color hoverColor;
    private Color selectedColor;
    private float cornerRadius = 15f;
    private boolean isHovered = false;
    private ImageIcon gameIcon;
    private String iconPath;

    public GameButton(String text, String gameName) {
        super(text);
        this.baseColor = new Color(60, 63, 81);
        this.hoverColor = new Color(80, 85, 105);
        this.selectedColor = new Color(100, 200, 255);
        
        // Try to load game icon from resources/images folder
        loadGameIcon(gameName);
        
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setFont(new Font("Segoe UI", Font.BOLD, 13));
        setForeground(Color.WHITE);
        setPreferredSize(new Dimension(120, 50));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isHovered = true;
                repaint();
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                isHovered = false;
                repaint();
            }
        });
    }

    private void loadGameIcon(String gameName) {
        try {
            // Try to load from resources/images directory
            String[] possiblePaths = {
                "src/resources/images/" + gameName.toLowerCase().replace(" ", "_") + ".png",
                "resources/images/" + gameName.toLowerCase().replace(" ", "_") + ".png",
                "images/" + gameName.toLowerCase().replace(" ", "_") + ".png"
            };
            
            for (String path : possiblePaths) {
                File iconFile = new File(path);
                if (iconFile.exists()) {
                    ImageIcon icon = new ImageIcon(path);
                    // Scale icon to fit button
                    Image scaledImage = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
                    this.gameIcon = new ImageIcon(scaledImage);
                    this.iconPath = path;
                    break;
                }
            }
        } catch (Exception e) {
            // Icon not found, will display text only
            this.gameIcon = null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Determine color based on state
        Color currentColor;
        if (isSelected) {
            currentColor = selectedColor;
        } else if (isHovered) {
            currentColor = hoverColor;
        } else {
            currentColor = baseColor;
        }
        
        // Draw rounded background
        RoundRectangle2D roundedRect = new RoundRectangle2D.Float(
            0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius
        );
        g2d.setColor(currentColor);
        g2d.fill(roundedRect);
        
        // Draw border
        g2d.setColor(isSelected ? new Color(120, 220, 255) : new Color(100, 100, 120));
        g2d.setStroke(new BasicStroke(2f));
        g2d.draw(roundedRect);
        
        // Draw icon if available
        if (gameIcon != null) {
            int iconX = 10;
            int iconY = (getHeight() - 30) / 2;
            gameIcon.paintIcon(this, g2d, iconX, iconY);
        }
        
        // Draw text
        g2d.setColor(Color.WHITE);
        g2d.setFont(getFont());
        FontMetrics fm = g2d.getFontMetrics();
        int textX = gameIcon != null ? 45 : (getWidth() - fm.stringWidth(getText())) / 2;
        int textY = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
        g2d.drawString(getText(), textX, textY);
    }

    public void setSelected(boolean selected) {
        if (this.isSelected != selected) {
            this.isSelected = selected;
            repaint();
        }
    }

    public boolean isGameSelected() {
        return isSelected;
    }

    public void setColors(Color base, Color hover, Color selected) {
        this.baseColor = base;
        this.hoverColor = hover;
        this.selectedColor = selected;
        repaint();
    }
}
