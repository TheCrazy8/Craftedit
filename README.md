# Craftedit

A CraftTweaker editor mod for Minecraft 1.20.1 that provides a GUI-based recipe editor for creating and modifying recipes through CraftTweaker scripts.

## Features

- **GUI Recipe Editor**: Easy-to-use graphical interface for creating recipe scripts without manually writing code
- **Multiple Recipe Types Support**:
  - Crafting Table recipes
  - Brewing Stand recipes
  - Furnace recipes (Furnace, Blast Furnace, Smoker)
  - Botany Pot recipes
  - Anvil recipes
  - Smithing Table recipes
- **CraftTweaker Integration**: Generates valid CraftTweaker scripts automatically
- **EMI Integration**: View recipes in EMI (Enhanced Machine Interactions)
- **Server Compatible**: Works on both client and dedicated servers
- **Mod Integration**: Seamless integration with Botany Pots and Create mods

## Requirements

- Minecraft 1.20.1
- Minecraft Forge 47.2.0 or higher
- Java 17 or higher
- CraftTweaker (required dependency)
- Botany Pots (optional)
- Create (optional)
- EMI (optional, client-side only)

## Building the Mod

### Prerequisites

1. Install Java Development Kit (JDK) 17 or higher
   - Download from: https://adoptium.net/
2. Clone this repository:
   ```bash
   git clone https://github.com/TheCrazy8/Craftedit.git
   cd Craftedit
   ```

### Build Instructions

#### Option 1: Using Gradle Wrapper (Recommended)

The project includes Gradle wrapper files, so you don't need to install Gradle separately.

**On Linux/Mac:**
```bash
./gradlew build
```

**On Windows:**
```cmd
gradlew.bat build
```

#### Option 2: Using Local Gradle Installation

If you have Gradle 8.1.1+ installed locally:
```bash
gradle build
```

### Build Output

After a successful build, you'll find the mod JAR file in:
```
build/libs/craftedit-1.0.0.jar
```

## Running the Mod

### In Development Environment

To run the mod in a development environment:

**Run Client:**
```bash
./gradlew runClient
```

**Run Server:**
```bash
./gradlew runServer
```

**Generate Data:**
```bash
./gradlew runData
```

### In Minecraft

1. Build the mod JAR (see Building the Mod section)
2. Copy `build/libs/craftedit-1.0.0.jar` to your Minecraft `mods` folder
3. Ensure you have Forge 1.20.1 and CraftTweaker installed
4. Launch Minecraft

### Opening the Recipe Editor

Once in-game, press the **R** key to open the Craftedit Recipe Editor GUI. From there, you can:
1. Select the type of recipe you want to create
2. Configure the recipe inputs and outputs
3. Generate CraftTweaker script code
4. Save the script to your scripts folder

## Development

### Project Structure

```
Craftedit/
├── src/main/
│   ├── java/com/thecrazy8/craftedit/
│   │   ├── Craftedit.java              # Main mod class
│   │   ├── client/
│   │   │   └── KeyBindings.java        # Keybinding configuration
│   │   └── gui/
│   │       ├── RecipeEditorScreen.java # Main editor GUI
│   │       └── SpecificRecipeEditorScreen.java # Recipe type-specific editor
│   └── resources/
│       ├── META-INF/
│       │   └── mods.toml               # Mod metadata
│       └── assets/craftedit/
│           └── lang/
│               └── en_us.json          # Localization
├── build.gradle                         # Build configuration
├── gradle.properties                    # Mod properties
└── settings.gradle                      # Gradle settings
```

### IDE Setup

**IntelliJ IDEA:**
```bash
./gradlew genIntellijRuns
```
Then open the project in IntelliJ IDEA.

**Eclipse:**
```bash
./gradlew eclipse
```
Then import the project in Eclipse.

### Continuous Integration

This project includes a GitHub Actions workflow that automatically builds the mod on every push and pull request. The workflow:
- Builds the mod JAR file
- Runs tests (if present)
- Uploads artifacts for download
- Caches dependencies for faster builds

## Using the Mod

### Creating Recipes

1. Launch Minecraft with the mod installed
2. Press **R** to open the Recipe Editor
3. Select the recipe type you want to create
4. Fill in the recipe details
5. Click "Generate Script" to create CraftTweaker code
6. Click "Save Script" to save it to your scripts folder
7. Restart Minecraft or reload CraftTweaker scripts to apply changes

### Server Deployment

To use this mod on a server:
1. Install the mod JAR in the server's `mods` folder
2. Install CraftTweaker and other required dependencies
3. Create or copy CraftTweaker scripts to the `scripts` folder
4. EMI is not required on the server (client-side only)
5. Restart the server to apply the recipes

## Troubleshooting

### Build Issues

If you encounter build issues:
1. Ensure you're using Java 17 or higher: `java -version`
2. Clear the Gradle cache: `./gradlew clean`
3. Delete the `.gradle` folder and try building again
4. Check that all dependencies are accessible

### Runtime Issues

If the mod doesn't load:
1. Verify you're using Minecraft 1.20.1
2. Ensure Forge 47.2.0+ is installed
3. Check that CraftTweaker is installed
4. Review the Minecraft logs for error messages

## Contributing

Contributions are welcome! Please feel free to submit pull requests or open issues for bugs and feature requests.

## License

This project is licensed under the MIT License.

## Credits

- Built with Minecraft Forge
- Integrates with CraftTweaker, Botany Pots, Create, and EMI
- Created by TheCrazy8

