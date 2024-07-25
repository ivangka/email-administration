package ivangka.main;

import java.io.Serializable;
import java.util.Formatter;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class EmailAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String altEmailAddress;
    private String password;
    private Company company;
    private long id;

    public EmailAccount(Company company, Scanner sc) {

        // inits
        this.company = company;
        System.out.print("PRINT YOUR FIRST NAME: ");
        this.firstName = sc.nextLine();
        System.out.print("PRINT YOUR LAST NAME: ");
        this.lastName = sc.nextLine();
        System.out.print("PRINT YOUR ALTERNATIVE EMAIL ACCOUNT: ");
        this.altEmailAddress = sc.nextLine();
        createEmailAddress(firstName, lastName, company, sc);
        this.id = company.createNewid();
        this.password = createPassword(company.getPasswordLength());

        System.out.println("\nNew email account has been created successfully!");

        // add new email account in the company list of accounts
        company.addEmailAccount(this);

        // update bin-file with company object
        WriteCompany.writeCompany(company);

        // show info of the account
        System.out.print("\n");
        System.out.println(">>> INFORMATION ABOUT YOUR NEW EMAIL ACCOUNT <<<");
        showInfo();
        System.out.print("\n");

    }

    public void createEmailAddress(String firstName, String lastName, Company company, Scanner sc) {

        this.emailAddress = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + company.getDomain();

        if (company.getEmailAccounts().contains(this)) {
            String postscript;
            do {
                System.out.println("THERE IS ALREADY AN ACCOUNT WITH ADRESS \"" + emailAddress + "\",");
                System.out.print("PLEASE COME UP WITH A UNIQUE POSTSCRIPT FOR YOUR EMAIL ADDRESS: ");
                postscript = sc.nextLine();
                this.emailAddress = firstName.toLowerCase() + "." + lastName.toLowerCase() + "." + postscript +
                        "@" + company.getDomain();
            } while (company.getEmailAccounts().contains(this));
        }

    }

    private String createPassword(int passwordLength) {

        Random rand = new Random(47);
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZabcdefghijklmnopqrstuwxyz0123456789!@#$%";
        char[] password = new char[passwordLength];

        // create random password
        for (int i = 0; i < passwordLength; i++) {
            int ind = rand.nextInt(passwordSet.length());
            password[i] = passwordSet.charAt(ind);
        }

        return new String(password);
    }

    public long getid() {
        return this.id;
    }

    public void showInfo() {

        Formatter formatter = new Formatter(System.out);

        formatter.format("%-19s%s\n", "FIRST NAME:", this.firstName);
        formatter.format("%-19s%s\n", "LAST NAME:", this.lastName);
        formatter.format("%-19s%s\n", "EMAIL ADDRESS:", this.emailAddress);
        formatter.format("%-19s%s\n", "PASSWORD:", this.password);
        formatter.format("%-19s%s\n", "COMPANY:", this.company.getCompanyName());
        formatter.format("%-19s%s\n", "id:", this.id);
        formatter.format("%-19s%s\n", "ALT EMAIL ADDRESS:", this.altEmailAddress);

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailAccount that = (EmailAccount) o;
        return Objects.equals(emailAddress, that.emailAddress);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(emailAddress);
    }

    @Override
    public String toString() {
        return this.emailAddress;
    }

}
