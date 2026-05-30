# Sensitivity DPI Converter for Games 🎮

A premium Java Swing application with smooth animations and a sleek UI for converting mouse sensitivity across competitive games.

## Supported Games
- **Valorant** 🏹
- **Roblox** 🏗️
- **CS2** (Counter-Strike 2) 🔫
- **Crossfire** ⚡
- **Overwatch** 🎪
- **Apex Legends** 🏃
- **Fortnite** 🏁

## Features

✨ **Smooth Animations** - Fade-ins, transitions, and hover effects  
🎨 **Modern Dark Theme** - Clean, professional interface  
⚡ **Real-time Conversion** - Instant sensitivity calculations  
🎮 **Clickable Game Selection** - Smooth toggle buttons  
🎯 **Precision Calculations** - Accurate DPI conversions  
⭐ **Professional Polish** - Butter-smooth interactions  

## How to Use

1. Launch the application
2. Click on your **source game** (it will highlight)
3. Enter your **sensitivity value** and **DPI**
4. Click on your **target game**
5. View the **converted sensitivity** in real-time

## Project Structure

```
src/
├── com/sensitivity/converter/
│   ├── Main.java
│   ├── SensitivityConverterFrame.java
│   ├── GameButton.java
│   ├── SensitivityConverter.java
│   ├── Game.java
│   └── AnimationUtils.java
```

## Technologies Used

- **Java Swing** (Custom Components)
- **Timer-based Animations**
- **Modern UI Design Patterns**
- **Real-time Event Listeners**
- **Custom Graphics Rendering**

## Build & Run

### Using Command Line:
```bash
javac -d bin src/com/sensitivity/converter/*.java
java -cp bin com.sensitivity.converter.Main
```

### Using IDE (IntelliJ IDEA / Eclipse):
1. Import project as Java project
2. Mark `src` as Source Root
3. Run `Main.java`

## Requirements
- Java 8 or higher
- No external dependencies (uses only standard Java Swing)

## Features Breakdown

### Custom GameButton Component
- Rounded corners with anti-aliasing
- Smooth hover effects
- Selection highlighting
- Custom color schemes

### Real-time Conversion
- Automatic calculation as you type
- Support for custom DPI values
- Precision to 2 decimal places

### Conversion Formula
```
Target Sensitivity = (Source Sensitivity × Source DPI × Source Multiplier) 
                    / (Target DPI × Target Multiplier)
```

Each game has its own sensitivity multiplier based on actual in-game calibration data.

## Color Scheme
- **Dark Background**: #1E202C
- **Panel Background**: #2D303E
- **Accent Color**: #64C8FF (Cyan)
- **Text Color**: #DCDCDC (Light Gray)

## Author
Created by Jaspher Bibanco, John Yu Miraflor, Gyeoul Tenebro - Final Project BSCS-1C ITEC 50

## License
MIT License - Feel free to use and modify!
