# Contributing Guidelines

## Code Style

### Java Conventions
- Follow Oracle's Java Code Conventions
- Use CamelCase for class names: `SensitivityConverterFrame`
- Use lowercase with underscores for constants: `DARK_BG`
- Use camelCase for variable names: `jTextFieldSensitivity`

### Naming Conventions
```java
// Classes
public class SensitivityConverter { }

// Constants
private static final Color DARK_BG = new Color(30, 32, 44);

// Variables
private JButton jButtonConvert;
private Game selectedSourceGame;

// Methods
public void performConversion() { }
private void setupLayout() { }
```

### Formatting
- Use 4 spaces for indentation (no tabs)
- Keep lines under 100 characters where possible
- Add blank lines between logical sections
- Include JavaDoc comments for public methods

### JavaDoc Format
```java
/**
 * Convert sensitivity from source game to target game
 * 
 * @param sourceSensitivity The player's current sensitivity value
 * @param sourceDPI The player's current mouse DPI
 * @param sourceGame The current game
 * @param targetGame The target game
 * @param targetDPI The target mouse DPI
 * @return The converted sensitivity rounded to 2 decimal places
 * @throws IllegalArgumentException if DPI values are invalid
 */
public static double convertSensitivity(double sourceSensitivity, double sourceDPI,
                                       Game sourceGame, Game targetGame, double targetDPI) {
    // implementation
}
```

## Git Workflow

### Branch Naming
- Feature branches: `feature/description`
- Bug fixes: `fix/description`
- Documentation: `docs/description`
- Example: `feature/add-new-game-support`

### Commit Messages
```
Short summary (50 characters or less)

More detailed explanation of changes if needed.
Wrap at 72 characters.

- Use bullet points for multiple changes
- Reference issues: Fixes #123
- Reference PRs: Related to #456
```

### Pull Request Process
1. Create feature branch from `main`
2. Make changes and test thoroughly
3. Push to your fork
4. Create pull request with clear description
5. Address review comments
6. Ensure CI/CD passes

## Code Review Checklist

- [ ] Code follows style guidelines
- [ ] Comments are clear and helpful
- [ ] No unnecessary code or comments
- [ ] Proper error handling
- [ ] Tests added/updated
- [ ] Documentation updated
- [ ] No merge conflicts
- [ ] Commit messages are descriptive

## Testing

### Unit Tests
```java
public class SensitivityConverterTest {
    @Test
    public void testConvertSensitivity() {
        double result = SensitivityConverter.convertSensitivity(
            1.0, 400, Game.VALORANT, Game.CS2, 400
        );
        assertEquals(1.05, result, 0.01);
    }
}
```

### Running Tests
```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=SensitivityConverterTest

# Run specific test method
mvn test -Dtest=SensitivityConverterTest#testConvertSensitivity
```

## Adding New Features

### Adding a New Game

1. **Update Game.java**
```java
public enum Game {
    VALORANT("Valorant", 1.0f),
    // ... existing games ...
    NEW_GAME("New Game", 0.9f);  // Add new game
}
```

2. **Add Game Icon** (optional)
   - Place image in `src/resources/images/new_game.png`
   - GameButton will auto-load

3. **Update Documentation**
   - Update README.md supported games list
   - Update API_DOCUMENTATION.md

4. **Test**
   - Verify UI updates correctly
   - Test conversions work properly

### Adding a New Feature

1. Create feature branch: `git checkout -b feature/your-feature`
2. Make changes following code style guidelines
3. Add tests for new functionality
4. Update documentation
5. Submit pull request

## Common Improvements

### Performance Optimization
- Profile code before optimizing
- Use StringBuilder for string concatenation
- Cache frequently used values

### UI Enhancements
- Maintain consistency with dark theme
- Use ACCENT_COLOR for highlights
- Test on different screen resolutions

### Code Refactoring
- Identify duplicate code
- Extract common logic to utility methods
- Improve readability

## Reporting Issues

### Bug Report Template
```markdown
**Description**: Brief description of the bug

**Steps to Reproduce**:
1. Step 1
2. Step 2
3. Step 3

**Expected Behavior**: What should happen

**Actual Behavior**: What actually happened

**Environment**:
- Java Version: 25.x
- Maven Version: 3.x
- OS: Windows/macOS/Linux
```

### Feature Request Template
```markdown
**Description**: Describe the feature

**Use Case**: Why is this needed?

**Possible Implementation**: Suggest how to implement

**Alternatives**: Any alternative approaches?
```

## Documentation Standards

### README.md
- Keep it concise and clear
- Include installation steps
- Add usage examples
- Link to detailed docs

### Code Comments
```java
// Good comment: explains WHY
double targetValue = sourceValue / (targetDPI * targetGame.getSensitivityMultiplier());

// Avoid: explains WHAT (obvious from code)
// divide source value by target DPI and multiplier
```

### API Documentation
- Document public methods with JavaDoc
- Include parameter descriptions
- Document return values
- Include usage examples

## Development Environment Setup

### IntelliJ IDEA
1. File → New → Project from Version Control
2. Enter repository URL
3. Open and IntelliJ auto-configures Maven

### VS Code
1. Install extensions: Java Extension Pack, Maven for Java
2. Open project folder
3. Accept Maven configuration when prompted

### Eclipse
1. File → Import → Maven → Existing Maven Projects
2. Select project directory
3. Eclipse auto-configures

## Deployment

### Creating Release
1. Update version in `pom.xml`
2. Create GitHub release with changelog
3. Build: `mvn clean package`
4. Upload JAR to release

### Distribution
- Share executable JAR
- Include installation guide
- Provide system requirements

## Contact & Support

For questions or issues:
- Open GitHub issue
- Check existing documentation
- Review project discussions

## License

All contributions are under MIT License
