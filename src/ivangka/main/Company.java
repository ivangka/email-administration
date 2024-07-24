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
    private ArrayList<Long> allUUID;

    public Company(String companyName, String domain, int passwordLength) {

        // inits
        this.companyName = companyName;
        this.domain = domain;
        this.passwordLength = passwordLength;
        this.emailAccounts = new ArrayList<>();
        this.allUUID = new ArrayList<>();

    }

    public void addEmailAccount(EmailAccount emailAccount) {
        emailAccounts.add(emailAccount);
    }

    public long createNewUUID() {

        long uuid;
        Random rand = new Random(47);

        // create unique UUID for the account
        do {
            uuid = rand.nextLong((long) Math.pow(10, 10));
        } while (allUUID.contains(uuid));

        // add new UUID in list
        addUUID(uuid);

        return uuid;
    }

    public void addUUID(long uuid) {
        allUUID.add(uuid);
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
