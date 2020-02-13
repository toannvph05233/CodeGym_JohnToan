package Castady;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IO_File {
    public ArrayList readFile(URL url, String fomat, int code) {
        try {
            ArrayList listLink = new ArrayList();
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            // remove all new line
            //content = content.replaceAll("\\n", "");
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

    public void wiretFile(ArrayList<SanPham> arrayList, String tenFile) {
        File file = new File(tenFile);
        try {

            FileWriter fileWriter = new FileWriter(file);
            for (SanPham x : arrayList) {
                fileWriter.write(x.toString() + "\n");
            }
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
