package Castady;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller_ReadFile implements ReadFIle {
    final int getGroup1 = 1;
    final int getGroup2 = 2;
    final int getGroup3 = 3;

    String fomatKhuVuc;
    String fomatGia;
    String fomatDienTic;

    HashMap<String,String> hashMap = new HashMap<>();


    public void addFomat(String fomatKhuVuc, String fomatGia, String fomatDienTic) {
        this.fomatKhuVuc = fomatKhuVuc;
        this.fomatGia = fomatGia;
        this.fomatDienTic = fomatDienTic;
    }


    public void wiretFile(Controller_ReadFile controller, ArrayList listLink, String linkCon, String tenFile) throws IOException {

        File file = new File(tenFile);
        FileWriter fileOutput = new FileWriter(file);

        for (int f = 0; f < 3; f++) {
            ArrayList listPrice;
            ArrayList listKhuVuc;
            ArrayList listArea;
            ArrayList listThanhPho;

            String string = linkCon;
            string += (String) listLink.get(f);
            URL urlcon = new URL(string);

            listKhuVuc = controller.readFile(urlcon, fomatKhuVuc, getGroup2);
            listArea = controller.readFile(urlcon, fomatDienTic, getGroup1);
            listPrice = controller.readFile(urlcon, fomatGia, getGroup1);
            listThanhPho = controller.readFile(urlcon, fomatKhuVuc, getGroup3);

            controller.write_InFile(fileOutput,listKhuVuc,listThanhPho,listArea,listPrice);
        }
        fileOutput.close();
    }

    public void write_InFile(FileWriter fileOutput, ArrayList listKhuVuc, ArrayList listThanhPho, ArrayList listArea, ArrayList listPrice) throws IOException {

        for (int j = 0; j < listKhuVuc.size(); j++) {
            String plusStr = null;
            String plusStr2 = "";
            plusStr = listKhuVuc.get(j).toString() + listThanhPho.get(j).toString();
            fileOutput.write(listKhuVuc.get(j).toString());
            fileOutput.write(listThanhPho.get(j).toString());
            for (int i = 0; i < listArea.size(); i++) {
                plusStr2 +="\n" + listArea.get(i) + " = " + listPrice.get(i)+"\n-----------------\n";
                fileOutput.write("\n" + listArea.get(i) + " = " + listPrice.get(i));
                fileOutput.write("\n-----------------\n");
            }
            hashMap.put(plusStr,plusStr2);
        }
    }


    @Override
    public ArrayList readFile(URL url, String fomat, int code) {
        try {
            ArrayList listLink = new ArrayList();
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            // remove all new line
            content = content.replaceAll("\\n", "");
            // regex
            Pattern p = Pattern.compile(fomat);
            Matcher m = p.matcher(content);
            if (code == 1) {
                while (m.find()) {
                    listLink.add(m.group(1));
                }
            }
            if (code == 2) {
                while (m.find()) {
                    listLink.add(m.group(2));
                }
            } else {
                while (m.find()) {
                    listLink.add(m.group(3));
                }
            }
            return listLink;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
