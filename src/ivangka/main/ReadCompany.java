package ivangka.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadCompany {

    public static Company readCompany() {

        // check if the file is empty
        if (new File("company.bin").length() == 0) {
            return null;
        }

        try {
            FileInputStream fis = new FileInputStream("company.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Company company = (Company) ois.readObject();
            ois.close();
            return company;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
