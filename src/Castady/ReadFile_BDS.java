package Castady;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFile_BDS {
    public static void main(String[] args) throws IOException {
        ArrayList listLink = new ArrayList();
        Controller_ReadFile cotroller = new Controller_ReadFile();

        String fomatlink = "<a href=\'(.*?)\' title";
        String fomatKhuVuc = "<b>Khu vực:</b> <a href=\"/(.*?)\">(.*?)</a> (.*?)</span>";
        String fomatGia = "<strong class=\"product-price\">(.*?)</strong>";
        String fomatDienTic = "<strong class=\"product-area\">(.*?)</strong>";

        cotroller.addFomat(fomatKhuVuc, fomatGia, fomatDienTic);

        URL url = new URL("https://batdongsan.com.vn/nha-dat-ban");

        String linkcon = "https://batdongsan.com.vn/nha-dat-ban";

        listLink = cotroller.readFile(url, fomatlink, 1);

        cotroller.wiretFile(cotroller, listLink, linkcon, "DuLieu.txt");

    }

}


