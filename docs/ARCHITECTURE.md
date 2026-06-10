# Architecture & Design

## System Architecture

### Component Diagram
```
┌─────────────────────────────────────────────────┐
│         SensitivityConverterFrame               │
│              (Main UI Window)                   │
├─────────────────────────────────────────────────┤
│                                                 │
│  ┌──────────────┐      ┌──────────────┐        │
│  │  GameButton  │      │  GameButton  │  ...   │
│  │  (Source)    │      │  (Target)    │        │
│  └──────────────┘      └──────────────┘        │
│                                                 │
│  ┌──────────────────┐  ┌──────────────────┐    │
│  │   TextField      │  │   TextField      │    │
│  │  (Sensitivity)   │  │   (DPI)          │    │
│  └──────────────────┘  └──────────────────┘    │
│                                                 │
│  ┌──────────────────────────────────────────┐  │
│  │  SensitivityConverter (Logic Layer)      │  │
│  │  - convertSensitivity()                  │  │
│  │  - getEffectiveSensitivity()             │  │
│  └──────────────────────────────────────────┘  │
└─────────────────────────────────────────────────┘
         │
         ▼
┌─────────────────────────────────────────────────┐
│           Game Enum                            │
│  - VALORANT (1.0x multiplier)                  │
│  - ROBLOX (0.8x multiplier)                    │
│  - CS2 (0.95x multiplier)                      │
│  - CROSSFIRE (1.1x multiplier)                 │
│  - OVERWATCH (0.75x multiplier)                │
│  - APEX_LEGENDS (0.85x multiplier)             │
│  - FORTNITE (0.9x multiplier)                  │
└─────────────────────────────────────────────────┘
```

## Class Hierarchy

### Main.java
- **Purpose**: Application entry point
- **Responsibilities**: Initialize and launch the main window
- **Key Method**: `main(String[] args)`

### SensitivityConverterFrame.java
- **Purpose**: Main UI window and user interface
- **Responsibilities**: 
  - Component initialization
  - Event handling
  - Real-time conversion display
- **Key Methods**:
  - `initializeComponents()` - Setup all UI components
  - `setupLayout()` - Configure layout
  - `performConversion()` - Handle conversion logic
  - `resetForm()` - Clear all fields

### GameButton.java
- **Purpose**: Custom styled button for game selection
- **Responsibilities**:
  - Custom rendering with rounded corners
  - Selection state management
  - Hover effects
  - Optional icon display
- **Key Methods**:
  - `paintComponent(Graphics g)` - Custom rendering
  - `setSelected(boolean)` - Update selection state
  - `loadGameIcon(String)` - Load game icons

### Game.java
- **Purpose**: Enum representing supported games
- **Responsibilities**:
  - Store game data and sensitivity multipliers
  - Provide display names and multiplier values
- **Enum Constants**:
  - VALORANT, ROBLOX, CS2, CROSSFIRE, OVERWATCH, APEX_LEGENDS, FORTNITE

### SensitivityConverter.java
- **Purpose**: Core conversion logic
- **Responsibilities**:
  - Calculate sensitivity conversions
  - Apply sensitivity multipliers
  - Round results to 2 decimal places
- **Key Methods**:
  - `convertSensitivity()` - Main conversion formula
  - `getEffectiveSensitivity()` - Calculate effective sensitivity

## Conversion Formula

```
Formula: (sourceSensitivity × sourceDPI × sourceMultiplier) ÷ (targetDPI × targetMultiplier)

Example:
- Source: Valorant, 1.0 sensitivity, 400 DPI
- Target: CS2, 400 DPI
- Calculation: (1.0 × 400 × 1.0) ÷ (400 × 0.95) = 1.05 sensitivity
```

## Design Patterns Used

1. **Singleton Pattern**: SensitivityConverterFrame (single main window)
2. **Enum Pattern**: Game (type-safe game representation)
3. **MVC Pattern**: Separation of Model (Game, SensitivityConverter), View (Swing Components), and Controller (SensitivityConverterFrame)
4. **Observer Pattern**: DocumentListener for real-time updates
5. **Strategy Pattern**: Different rendering strategies for GameButton states

## Data Flow

```
User Input (TextField)
    │
    ▼
DocumentListener.insertUpdate()
    │
    ▼
performConversion()
    │
    ▼
SensitivityConverter.convertSensitivity()
    │
    ▼
Apply Formula
    │
    ▼
Update jLabelResultValue
    │
    ▼
Display Result
```

## Technology Stack

- **Language**: Java 25
- **UI Framework**: Swing (javax.swing)
- **Build Tool**: Maven 3.8.1+
- **Graphics**: Java 2D (Graphics2D)
- **Package Manager**: Maven Central Repository
