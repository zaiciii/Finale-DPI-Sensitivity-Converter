package com.sensitivity.converter;

public class SensitivityConverter {
    
    /**
     * Convert sensitivity from source game to target game
     * Formula: (sourceSensitivity * sourceDPI * sourceMultiplier) / (targetDPI * targetMultiplier)
     */
    public static double convertSensitivity(double sourceSensitivity, double sourceDPI,
                                          Game sourceGame, Game targetGame, double targetDPI) {
        if (sourceDPI <= 0 || targetDPI <= 0 || sourceSensitivity < 0) {
            return 0;
        }

        double sourceValue = sourceSensitivity * sourceDPI * sourceGame.getSensitivityMultiplier();
        double targetValue = sourceValue / (targetDPI * targetGame.getSensitivityMultiplier());
        
        // Round to 2 decimal places
        return Math.round(targetValue * 100.0) / 100.0;
    }

    /**
     * Calculate effective sensitivity (for reference)
     */
    public static double getEffectiveSensitivity(double sensitivity, double dpi, Game game) {
        return sensitivity * dpi * game.getSensitivityMultiplier();
    }
}
