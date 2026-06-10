# 🎮 Sensitivity DPI Converter for Games

A premium Java Swing application with smooth animations and a sleek UI for converting mouse sensitivity across competitive games.

## 📋 Requirements

- **Java 25** (or later)
- **Maven 3.8.1** (or later)

## 🎮 Supported Games

- Valorant
- Roblox
- CS2 (Counter-Strike 2)
- Crossfire
- Overwatch
- Apex Legends
- Fortnite

## 🚀 Build Instructions

### Prerequisites
1. Install Java 25:
   - Download from [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or use [OpenJDK 25](https://jdk.java.net/25/)
   - Verify installation: `java -version`

2. Install Maven:
   - Download from [Apache Maven](https://maven.apache.org/download.cgi)
   - Verify installation: `mvn -version`

### Build the Project

```bash
# Clone the repository
git clone https://github.com/zaiciii/Finale-DPI-Sensitivity-Converter.git
cd Finale-DPI-Sensitivity-Converter

# Compile and build with Maven
mvn clean package

# This will create:
# - target/SensitivityConverter.jar (executable JAR with all dependencies)
# - target/SensitivityConverter-all.jar (alternative JAR format)
```

## ▶️ Running the Application

### Option 1: Using Maven
```bash
mvn exec:java -Dexec.mainClass="com.sensitivity.converter.Main"
```

### Option 2: Direct JAR Execution
```bash
java -jar target/SensitivityConverter.jar
```

### Option 3: Command Line (without building JAR)
```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.sensitivity.converter.Main"
```

## 📝 How to Use

1. **Select Source Game**: Click on the game you're converting FROM
2. **Enter Source Sensitivity**: Input your current sensitivity value
3. **Set Source DPI**: Enter your mouse DPI (default: 400)
4. **Select Target Game**: Click on the game you're converting TO
5. **Set Target DPI**: Enter the target DPI if different (default: 400)
6. **View Result**: The converted sensitivity appears automatically

Click **RESET** to clear all fields and start over.

## 🔧 Build Configuration

The `pom.xml` is configured with:
- **Java 25** as source and target
- **Maven Shade Plugin** for creating fat JAR
- **Maven Compiler Plugin** with full Java 25 support
- **Main class** configured for easy execution

## 📦 Project Structure

```
Finale-DPI-Sensitivity-Converter/
├── src/
│   └── com/sensitivity/converter/
│       ├── Main.java                 # Application entry point
│       ├── SensitivityConverterFrame.java  # Main UI window
│       ├── GameButton.java           # Custom styled button
│       ├── Game.java                 # Game enum with multipliers
│       └── SensitivityConverter.java  # Conversion logic
├── pom.xml                           # Maven configuration
├── README.md                         # This file
└── LICENSE                           # MIT License
```

## 💡 Features

- ✨ Smooth animations and modern UI
- 🎮 Support for 7 competitive games
- 🎯 Real-time conversion
- 🌙 Dark theme optimized for gaming
- ⚡ No external dependencies - pure Java Swing
- 🔒 MIT Licensed

## 🛠️ Troubleshooting

### "mvn: command not found"
- Ensure Maven is installed and added to your system PATH

### "Java 25 not found"
- Install Java 25 from [Oracle JDK](https://www.oracle.com/java/technologies/downloads/)
- Set `JAVA_HOME` environment variable to your Java 25 installation

### "Could not find or load main class"
- Ensure you built the project: `mvn clean package`
- Run from the project root directory

## 📄 License

MIT License - See LICENSE file for details

## 👨‍💻 Authors

- Jaspher T. Bibanco
- Gyeoul Tenebro
- John Yu Miraflor
