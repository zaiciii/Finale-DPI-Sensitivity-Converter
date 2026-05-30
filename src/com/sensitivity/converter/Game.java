package com.sensitivity.converter;

public enum Game {
    VALORANT("Valorant", 1.0f),
    ROBLOX("Roblox", 0.8f),
    CS2("CS2", 0.95f),
    CROSSFIRE("Crossfire", 1.1f),
    OVERWATCH("Overwatch", 0.75f),
    APEX_LEGENDS("Apex Legends", 0.85f),
    FORTNITE("Fortnite", 0.9f);

    private final String displayName;
    private final float sensitivityMultiplier;

    Game(String displayName, float sensitivityMultiplier) {
        this.displayName = displayName;
        this.sensitivityMultiplier = sensitivityMultiplier;
    }

    public String getDisplayName() {
        return displayName;
    }

    public float getSensitivityMultiplier() {
        return sensitivityMultiplier;
    }
}
