package Castady;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFile_BDS {
    private int getGroup1 = 1;
    Controller_ReadFile cotroller = new Controller_ReadFile();

    HashMap<String,String> hashMap = cotroller.hashMap;

    String fomatlink = "<a href=\'(.*?)\' title";
    String fomatKhuVuc = "<b>Khu vực:</b> <a href=\"/(.*?)\">(.*?)</a> (.*?)</span>";
    String fomatGia = "<strong class=\"product-price\">(.*?)</strong>";
    String fomatDienTic = "<strong class=\"product-area\">(.*?)</strong>";

    URL url = new URL("https://batdongsan.com.vn/nha-dat-ban");

    String linkcon = "https://batdongsan.com.vn/nha-dat-ban";

    ArrayList listLink = cotroller.readFile(url, fomatlink, getGroup1);

    public ReadFile_BDS() throws MalformedURLException {

    }

}




