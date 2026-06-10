/*Jaspher T. Bibanco*/
/*Gyeoul Tenebro*/
/*John Yu Miraflor*/
    
package com.sensitivity.converter;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new SensitivityConverterFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
