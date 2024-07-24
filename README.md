# Email Administration

This application automates the creation of unique email accounts for company employees. It generates secure passwords and manages email account information, while providing persistent storage for company data.

## Project Structure

- **EmailAccount**: Manages individual email accounts, including email address and password creation, and displays account information.
- **Company**: Manages the company’s email accounts, domain, and UUIDs.
- **ReadCompany**: Handles loading (deserialization) of the company data from a binary file.
- **WriteCompany**: Handles saving (serialization) of the company data to a binary file.