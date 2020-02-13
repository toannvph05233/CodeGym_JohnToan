package Castady;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Read_File_KenhBDS {
    final int getGroup1 = 1;

    public ArrayList<SanPham> runProgram() throws MalformedURLException {

        URL url = new URL("https://kenhbds.vn/can-ban");

        String fomatlink = "<a href=\"(.*?)\" class=\"img_noi_bat\">";
        String fomatKhuVuc = "<title>(.*?) - (.*?)</title>\\n<meta name=\"description\" content=\"(.*?) -";
        String fomatGia = "<div><span>Giá: </span><b>(.*?)</b></div>";
        String fomatDienTic = "<div><span>Diện tích: </span><b>(.*?)</b></div>";

        String linkcon = "";

        IO_File io_file = new IO_File();
        Controller_ReadFile controller_readFile = new Controller_ReadFile();

        ArrayList listLink = io_file.readFile(url, fomatlink, getGroup1);
        ArrayList<SanPham> arraySP = new ArrayList<>();

        controller_readFile.star(linkcon, listLink, io_file,getGroup1,
                controller_readFile, arraySP,
                fomatKhuVuc, fomatDienTic, fomatGia, "Kenhbds.txt");

        return arraySP;
    }
}
