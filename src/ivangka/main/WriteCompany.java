package ivangka.main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteCompany {

    public static void writeCompany(Company company) {

        try {
            FileOutputStream fos = new FileOutputStream("company.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(company);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
