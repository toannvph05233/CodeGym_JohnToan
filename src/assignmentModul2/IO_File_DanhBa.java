package assignmentModul2;

import TestAsiggmen.SinhVien;

import java.io.*;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class IO_File_DanhBa {

    public ArrayList readFile() {
        try {
            String url = "//C:/Users/TOAN/IdeaProjects/JohnToan/contacts.csv";
            ArrayList arrayList = new ArrayList();
            File file = new File(url);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                arrayList.add(line);
            }
            return arrayList;
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void writeFile(ArrayList<Person> arrayList) throws IOException {
        File file = new File("contacts.csv");
        FileWriter fileWriter = new FileWriter(file);

        for (int i = 0; i < arrayList.size(); i++) {
            fileWriter.write(arrayList.get(i).toString() + "\n");
        }
        fileWriter.close();
    }
}


