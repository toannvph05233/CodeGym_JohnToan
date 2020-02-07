package Castady;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFile_123ND {
    private int getGroup1 = 1;

    Controller_ReadFile cotroller = new Controller_ReadFile();

    HashMap<String,String> hashMap = cotroller.hashMap;

    String fomatlink = "<h4><a href=\"(.*?)\" title";
    String fomatKhuVuc = "<span><a href=\"(.*?)\">(.*?)</a> (.*?)</span></li>";
    String fomatGia = "<li><label>Giá:</label><span><b class=\"camcam\">(.*?)</b></span></li>";
    String fomatDienTic = "<li><label>Diện tích:</label><span><b class=\"camcam\">(.*?);</b></span></li>";

    URL url = new URL("http://123nhadat.vn/raovat-c3/ban-biet-thu-trong-du-an");

    String linkcon = "";

    ArrayList listLink = cotroller.readFile(url, fomatlink, getGroup1);

    public ReadFile_123ND() throws MalformedURLException {
    }
}