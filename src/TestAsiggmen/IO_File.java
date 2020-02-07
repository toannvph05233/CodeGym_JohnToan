package TestAsiggmen;

import java.io.*;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class IO_File {
    public ArrayList readFile() {
        try {
            String url = "//C:/Users/TOAN/IdeaProjects/JohnToan/TestAss.txt";
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

    public void writeFile(String nameFile,ArrayList<SinhVien> arrayList) throws IOException {
        File file = new File(nameFile);
        FileWriter fileWriter = new FileWriter(file,true);

        for (int i =0;i<arrayList.size();i++){
            fileWriter.write(arrayList.get(i).toString() + "\n");
        }
        fileWriter.close();
    }
}
