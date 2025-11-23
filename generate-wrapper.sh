#!/bin/bash
# Gradle wrapper generation script
# Run this script to generate the Gradle wrapper files

echo "Generating Gradle wrapper..."

# Check if gradle is installed
if ! command -v gradle &> /dev/null
then
    echo "Gradle is not installed. Please install Gradle 8.1.1 or higher first."
    echo "Visit: https://gradle.org/install/"
    exit 1
fi

# Generate wrapper
gradle wrapper --gradle-version 8.1.1

echo "Gradle wrapper generated successfully!"
echo "You can now use ./gradlew to build the project."
