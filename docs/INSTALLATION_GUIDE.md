# Installation & Setup Guide

## System Requirements

### Minimum Requirements
- **Operating System**: Windows, macOS, or Linux
- **Java Version**: Java 25 or later
- **RAM**: 512 MB minimum
- **Disk Space**: 100 MB for installation

### Recommended Requirements
- **Java Version**: Java 25 (latest stable)
- **RAM**: 2 GB or more
- **Disk Space**: 500 MB available
- **Monitor**: 1920x1080 or higher resolution

## Installation Steps

### Step 1: Install Java 25

#### Windows
1. Download Java 25 from [Oracle JDK](https://www.oracle.com/java/technologies/downloads/)
2. Run the installer (.exe file)
3. Follow the installation wizard
4. Set environment variables:
   - Open `System Properties` → `Environment Variables`
   - Add `JAVA_HOME` pointing to Java 25 installation directory
   - Add Java `bin` folder to `PATH`

#### macOS
```bash
# Using Homebrew (recommended)
brew install java@25

# Or download from Oracle JDK and run installer
```

#### Linux (Ubuntu/Debian)
```bash
# Update package manager
sudo apt update

# Install Java 25
sudo apt install openjdk-25-jdk

# Verify installation
java -version
```

### Step 2: Install Maven

#### Windows
1. Download Maven from [Apache Maven](https://maven.apache.org/download.cgi)
2. Extract to a directory (e.g., `C:\Program Files\apache-maven-3.9.x`)
3. Add Maven `bin` folder to `PATH` environment variable
4. Verify: Open Command Prompt and run `mvn -version`

#### macOS
```bash
# Using Homebrew
brew install maven

# Verify installation
mvn -version
```

#### Linux (Ubuntu/Debian)
```bash
# Install Maven
sudo apt install maven

# Verify installation
mvn -version
```

### Step 3: Verify Installation

Open terminal/command prompt and run:

```bash
# Check Java version
java -version
# Expected output: Java 25 or later

# Check Maven version
mvn -version
# Expected output: Maven 3.8.1 or later
```

## Project Setup

### Step 1: Clone Repository

```bash
# Clone the repository
git clone https://github.com/zaiciii/Finale-DPI-Sensitivity-Converter.git

# Navigate to project directory
cd Finale-DPI-Sensitivity-Converter
```

### Step 2: Build the Project

```bash
# Clean and build with Maven
mvn clean package

# Expected output:
# [INFO] BUILD SUCCESS
# [INFO] Total time: XX.XXX s
```

### Step 3: Verify Build

Check that the following files were created:
- `target/SensitivityConverter.jar` - Executable JAR file
- `target/SensitivityConverter-all.jar` - Alternative format

## Running the Application

### Option 1: Using Executable JAR (Recommended)

```bash
# Navigate to project directory
cd Finale-DPI-Sensitivity-Converter

# Run the JAR file
java -jar target/SensitivityConverter.jar
```

### Option 2: Using Maven Exec Plugin

```bash
# Run directly from Maven
mvn exec:java -Dexec.mainClass="com.sensitivity.converter.Main"
```

### Option 3: Compile and Run from Source

```bash
# Compile the project
mvn compile

# Run using Maven
mvn exec:java -Dexec.mainClass="com.sensitivity.converter.Main"
```

## Troubleshooting

### Problem: "Java: command not found"
**Solution**:
- Ensure Java 25 is installed
- Check `JAVA_HOME` environment variable is set correctly
- Restart terminal/command prompt after setting environment variables

### Problem: "mvn: command not found"
**Solution**:
- Ensure Maven is installed
- Check Maven `bin` folder is in `PATH`
- Restart terminal/command prompt after setting PATH

### Problem: "Could not find or load main class"
**Solution**:
- Ensure project is built: `mvn clean package`
- Run from project root directory
- Check that `target/SensitivityConverter.jar` exists

### Problem: Application window doesn't appear
**Solution**:
- Ensure Java 25 is compatible with your OS
- Try running with verbose output: `java -Xvfb:on -jar target/SensitivityConverter.jar`
- Check console for error messages

### Problem: Build fails with compilation error
**Solution**:
- Verify Java version: `java -version`
- Update Maven: `mvn --version`
- Clean project: `mvn clean`
- Clear Maven cache: `rm -rf ~/.m2/repository` (Linux/macOS) or delete `%USERPROFILE%\.m2` (Windows)
- Rebuild: `mvn clean package`

### Problem: OutOfMemoryError
**Solution**:
```bash
# Increase heap size when running
java -Xmx1024m -jar target/SensitivityConverter.jar
```

## Development Setup

### IDEs Recommended
- **IntelliJ IDEA** (Community or Ultimate)
- **Eclipse IDE**
- **VS Code** with Java extensions

### Setting up with IntelliJ IDEA
1. Open IntelliJ IDEA
2. File → Open → Select project directory
3. IntelliJ will automatically detect `pom.xml`
4. Right-click `Main.java` → Run

### Setting up with VS Code
1. Install Java Extension Pack
2. Open project folder
3. Maven should auto-detect `pom.xml`
4. Run from command palette: Java: Run Main

## Environment Variables

### Linux/macOS
```bash
# Add to ~/.bashrc or ~/.zshrc
export JAVA_HOME=/path/to/java25
export PATH=$JAVA_HOME/bin:$PATH
export M2_HOME=/path/to/maven
export PATH=$M2_HOME/bin:$PATH
```

### Windows
```batch
# Set in System Properties > Environment Variables
JAVA_HOME=C:\Program Files\Java\jdk-25
MAVEN_HOME=C:\Program Files\apache-maven-3.9.x
PATH=%JAVA_HOME%\bin;%MAVEN_HOME%\bin;%PATH%
```

## Testing the Installation

### Quick Test
```bash
# Create a simple test
cd Finale-DPI-Sensitivity-Converter
mvn test

# Run the application
java -jar target/SensitivityConverter.jar
```

### Expected Behavior
- Application window opens
- Dark theme with blue accents
- 7 game buttons visible
- Input fields for sensitivity and DPI
- Convert and Reset buttons functional

## Uninstallation

### Remove Application Files
```bash
# Remove cloned repository
rm -rf Finale-DPI-Sensitivity-Converter
```

### Remove Build Artifacts
```bash
# Inside project directory
mvn clean
```

### Java & Maven (Optional)
- **Windows**: Use Control Panel → Programs and Features
- **macOS with Homebrew**: `brew uninstall java@25 maven`
- **Linux**: `sudo apt remove openjdk-25-jdk maven`

## Next Steps

After successful installation:
1. Review the [README.md](../README.md)
2. Read the [ARCHITECTURE.md](ARCHITECTURE.md) to understand code structure
3. Check [API_DOCUMENTATION.md](API_DOCUMENTATION.md) for usage examples
4. Start using the application!
