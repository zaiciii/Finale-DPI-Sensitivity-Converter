package com.sensitivity.converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AnimationUtils {
    
    /**
     * Animate color transition
     */
    public static void animateColor(JComponent component, Color startColor, Color endColor, int duration) {
        Timer timer = new Timer(16, null);
        long startTime = System.currentTimeMillis();
        
        ActionListener listener = e -> {
            long elapsed = System.currentTimeMillis() - startTime;
            float progress = Math.min(1.0f, (float) elapsed / duration);
            
            int red = (int) (startColor.getRed() + (endColor.getRed() - startColor.getRed()) * progress);
            int green = (int) (startColor.getGreen() + (endColor.getGreen() - startColor.getGreen()) * progress);
            int blue = (int) (startColor.getBlue() + (endColor.getBlue() - startColor.getBlue()) * progress);
            
            component.setBackground(new Color(red, green, blue));
            
            if (progress >= 1.0f) {
                ((Timer) e.getSource()).stop();
            }
        };
        
        timer.addActionListener(listener);
        timer.start();
    }
    
    /**
     * Animate opacity/alpha (fade effect)
     */
    public static void fadeIn(JComponent component, int duration) {
        Timer timer = new Timer(16, null);
        long startTime = System.currentTimeMillis();
        
        ActionListener listener = e -> {
            long elapsed = System.currentTimeMillis() - startTime;
            float progress = Math.min(1.0f, (float) elapsed / duration);
            component.setOpacity(progress);
            
            if (progress >= 1.0f) {
                ((Timer) e.getSource()).stop();
            }
        };
        
        timer.addActionListener(listener);
        timer.start();
    }
    
    /**
     * Smooth hover effect with scaling
     */
    public static void createHoverEffect(JComponent component, float normalScale, float hoverScale) {
        component.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                component.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                component.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }
}
