# Email Administration

This application automates the creation of unique email accounts for company employees. It generates secure passwords and manages email account information, while providing persistent storage for company data.

## Project Structure

- **`EmailAccount` class:** Manages individual email accounts, including email address and password creation, and displays account information.
- **`Company` class:** Manages the company’s email accounts, domain, and ids.
- **`ReadCompany` class:** Handles loading (deserialization) of the company data from a binary file.
- **`WriteCompany` class:** Handles saving (serialization) of the company data to a binary file.
- **`App` class:** The main entry point of the application.

## Installation

To use this project, you need to have the Java Development Kit (JDK) installed. You can compile and run the program using the following commands:

```bash
# Compile the program
javac -d bin src/ivangka/main/*.java

# Run the program
java -cp bin ivangka.main.App
```
