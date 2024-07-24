package ivangka.main;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // read company object from bin file
        Company company = ReadCompany.readCompany();

        if (company == null) {
            company = new Company("The Best Company in the World", "example.com", 10);
        }

        System.out.println("Existing email addresses of company employees:");
        System.out.println(company.getEmailAccounts());
        System.out.println();

        // create new email address
        new EmailAccount(company, sc);

    }

}
