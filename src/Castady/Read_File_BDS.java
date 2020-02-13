package Castady;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Read_File_BDS {
    final int getGroup1 = 1;
    final int getGroup2 = 2;

    public ArrayList<SanPham> runProgram() throws MalformedURLException {

        String fomatlink = "<a href=\'(.*?)\' title";
        String fomatKhuVuc = "<b>Khu vực:</b> <a href=\"/(.*?)\">(.*?)</a> (.*?)</span>";
        String fomatGia = "<strong class=\"product-price\">(.*?)</strong>";
        String fomatDienTic = "<strong class=\"product-area\">(.*?)</strong>";

        URL url = new URL("https://batdongsan.com.vn/nha-dat-ban");

        String linkcon = "https://batdongsan.com.vn/nha-dat-ban";

        IO_File io_file = new IO_File();
        Controller_ReadFile controller_readFile = new Controller_ReadFile();

        ArrayList listLink = io_file.readFile(url, fomatlink, getGroup1);
        ArrayList<SanPham> arraySP = new ArrayList<>();

        controller_readFile.star(linkcon, listLink, io_file, getGroup2,
                controller_readFile, arraySP,
                fomatKhuVuc, fomatDienTic, fomatGia, "Batdongsan.txt");

        return arraySP;
    }
}
