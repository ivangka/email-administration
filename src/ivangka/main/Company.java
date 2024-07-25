package ivangka.main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Company implements Serializable {

    private static final long serialVersionUID = 1L;
    private String companyName;
    private String domain;
    private int passwordLength;
    private ArrayList<EmailAccount> emailAccounts;
    private ArrayList<Long> allID;

    public Company(String companyName, String domain, int passwordLength) {

        // inits
        this.companyName = companyName;
        this.domain = domain;
        this.passwordLength = passwordLength;
        this.emailAccounts = new ArrayList<>();
        this.allID = new ArrayList<>();

    }

    public void addEmailAccount(EmailAccount emailAccount) {
        emailAccounts.add(emailAccount);
    }

    public long createNewid() {

        long id;
        Random rand = new Random(47);

        // create unique id for the account
        do {
            id = rand.nextLong((long) Math.pow(10, 10));
        } while (allID.contains(id));

        // add new id in list
        addid(id);

        return id;
    }

    public void addid(long id) {
        allID.add(id);
    }

    public String getDomain() {
        return this.domain;
    }

    public ArrayList<EmailAccount> getEmailAccounts() {
        return this.emailAccounts;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public int getPasswordLength() {
        return this.passwordLength;
    }
}
