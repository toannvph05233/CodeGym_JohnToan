package Castady;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Thread_ReadFile_123ND extends Thread {
    final int getGroup1 = 1;
    final int getGroup2 = 2;
    final int getGroup3 = 3;

    @Override
    public void run() {
        Controller_ReadFile controller_readFile = new Controller_ReadFile();

        ReadFile_123ND readFile_123ND = null;

        try {
            readFile_123ND = new ReadFile_123ND();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        String fomatKhuVuc = readFile_123ND.fomatKhuVuc;
        String fomatGia = readFile_123ND.fomatGia;
        String fomatDienTic = readFile_123ND.fomatDienTic;
        ArrayList listLink = readFile_123ND.listLink;
        String linkcon = readFile_123ND.linkcon;


        try {
            this.wiretFile(controller_readFile, listLink, linkcon, "DuLieu.txt", fomatKhuVuc, fomatGia, fomatDienTic);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void wiretFile(Controller_ReadFile controller, ArrayList listLink, String linkCon, String tenFile, String fomatKhuVuc,
                          String fomatDienTic, String fomatGia) throws IOException {

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

            controller.write_InFile(fileOutput, listKhuVuc, listThanhPho, listArea, listPrice);
        }
        fileOutput.close();
    }
}
