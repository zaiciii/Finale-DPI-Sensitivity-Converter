# API Documentation

## Core Classes

### Game Enum

```java
public enum Game {
    VALORANT("Valorant", 1.0f),
    ROBLOX("Roblox", 0.8f),
    CS2("CS2", 0.95f),
    CROSSFIRE("Crossfire", 1.1f),
    OVERWATCH("Overwatch", 0.75f),
    APEX_LEGENDS("Apex Legends", 0.85f),
    FORTNITE("Fortnite", 0.9f);
}
```

#### Methods

##### `getDisplayName(): String`
- **Description**: Returns the display name of the game
- **Returns**: String representation of game name
- **Example**: `Game.VALORANT.getDisplayName()` → `"Valorant"`

##### `getSensitivityMultiplier(): float`
- **Description**: Returns the sensitivity multiplier for the game
- **Returns**: Float value between 0.75 and 1.1
- **Example**: `Game.VALORANT.getSensitivityMultiplier()` → `1.0f`

---

### SensitivityConverter Class

```java
public class SensitivityConverter {
    public static double convertSensitivity(double sourceSensitivity, double sourceDPI,
                                          Game sourceGame, Game targetGame, double targetDPI);
    
    public static double getEffectiveSensitivity(double sensitivity, double dpi, Game game);
}
```

#### Methods

##### `convertSensitivity(double, double, Game, Game, double): double`
- **Description**: Converts sensitivity from one game to another
- **Parameters**:
  - `sourceSensitivity`: Player's current sensitivity value
  - `sourceDPI`: Player's current mouse DPI
  - `sourceGame`: Current game (from)
  - `targetGame`: Target game (to)
  - `targetDPI`: Target mouse DPI
- **Returns**: Converted sensitivity value rounded to 2 decimal places
- **Throws**: None (validates inputs internally)
- **Example**:
  ```java
  double result = SensitivityConverter.convertSensitivity(
      1.0,           // Source sensitivity
      400,           // Source DPI
      Game.VALORANT, // From game
      Game.CS2,      // To game
      400            // Target DPI
  );
  // Result: 1.05
  ```

##### `getEffectiveSensitivity(double, double, Game): double`
- **Description**: Calculates the effective sensitivity (for reference)
- **Parameters**:
  - `sensitivity`: Base sensitivity value
  - `dpi`: Mouse DPI
  - `game`: Game to calculate for
- **Returns**: Effective sensitivity value
- **Example**:
  ```java
  double effective = SensitivityConverter.getEffectiveSensitivity(
      1.0,
      400,
      Game.VALORANT
  );
  // Result: 400.0
  ```

---

### GameButton Class

```java
public class GameButton extends JButton {
    public GameButton(String text, String gameName);
    public void setSelected(boolean selected);
    public boolean isGameSelected();
    public void setColors(Color base, Color hover, Color selected);
}
```

#### Constructor

##### `GameButton(String text, String gameName)`
- **Description**: Creates a custom styled game button
- **Parameters**:
  - `text`: Display text on button
  - `gameName`: Game name for icon loading
- **Example**:
  ```java
  GameButton btn = new GameButton("Valorant", "Valorant");
  ```

#### Methods

##### `setSelected(boolean selected): void`
- **Description**: Sets the selection state of the button
- **Parameters**:
  - `selected`: true to select, false to deselect
- **Example**:
  ```java
  gameButton.setSelected(true);
  ```

##### `isGameSelected(): boolean`
- **Description**: Returns if the button is currently selected
- **Returns**: true if selected, false otherwise

##### `setColors(Color base, Color hover, Color selected): void`
- **Description**: Customizes button colors
- **Parameters**:
  - `base`: Base/default color
  - `hover`: Hover state color
  - `selected`: Selected state color

---

### SensitivityConverterFrame Class

```java
public class SensitivityConverterFrame extends JFrame {
    public SensitivityConverterFrame();
}
```

#### Constructor

##### `SensitivityConverterFrame()`
- **Description**: Creates and initializes the main application window
- **UI Components**:
  - Title label with emoji
  - Game selection buttons (7 games)
  - Input fields for sensitivity, source DPI, target DPI
  - Result display label
  - Convert and Reset buttons
- **Size**: 1000x750 pixels
- **Theme**: Dark mode with accent colors
- **Example**:
  ```java
  SensitivityConverterFrame frame = new SensitivityConverterFrame();
  frame.setVisible(true);
  ```

---

## Constants

### Color Scheme (SensitivityConverterFrame)

```java
DARK_BG = Color(30, 32, 44)           // Dark background
PANEL_BG = Color(45, 48, 62)          // Panel background
ACCENT_COLOR = Color(100, 200, 255)   // Accent blue
TEXT_COLOR = Color(220, 220, 220)     // Light text
```

### Game Multipliers

| Game | Multiplier | Use Case |
|------|-----------|----------|
| Valorant | 1.0 | Reference game |
| Roblox | 0.8 | Lower sensitivity |
| CS2 | 0.95 | Slightly lower |
| Crossfire | 1.1 | Higher sensitivity |
| Overwatch | 0.75 | Significantly lower |
| Apex Legends | 0.85 | Lower sensitivity |
| Fortnite | 0.9 | Moderately lower |

---

## Usage Examples

### Example 1: Basic Conversion
```java
// Convert from Valorant to CS2
double result = SensitivityConverter.convertSensitivity(
    1.5,           // My Valorant sensitivity
    800,           // My mouse DPI
    Game.VALORANT,
    Game.CS2,
    800
);
System.out.println("New CS2 sensitivity: " + result);
```

### Example 2: Using the GUI
```java
public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        JFrame frame = new SensitivityConverterFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    });
}
```

### Example 3: Custom Colors
```java
GameButton btn = new GameButton("Custom Game", "custom");
btn.setColors(
    new Color(50, 50, 50),      // base
    new Color(100, 100, 100),   // hover
    new Color(150, 200, 255)    // selected
);
```

---

## Error Handling

The conversion function includes input validation:

```java
if (sourceDPI <= 0 || targetDPI <= 0 || sourceSensitivity < 0) {
    return 0;  // Invalid input
}
```

**Returns 0 for**:
- Negative or zero DPI values
- Negative sensitivity values

---

## Conversion Algorithm

```
Step 1: Calculate source effective sensitivity
  sourceEffective = sourceSensitivity × sourceDPI × sourceGame.multiplier

Step 2: Normalize to target game
  normalized = sourceEffective / (targetDPI × targetGame.multiplier)

Step 3: Round to 2 decimal places
  result = Math.round(normalized × 100.0) / 100.0
```
