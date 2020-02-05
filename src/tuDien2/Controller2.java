package tuDien2;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller2 {
    final int translateEnglish = 1;
    final int translateTiengViet = 0;

    public HashMap readFile() {
        try {
            URL url = new URL("file:///C:/Users/TOAN/IdeaProjects/JohnToan/anhviet109K.txt");
            HashMap<String, String> hashMapEnglist = new HashMap<>();
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            // remove all new line
            content = content.replaceAll("\\n", ";");
            // regex
            Pattern p = Pattern.compile("@(.*?) /(.*?);;");
            Matcher m = p.matcher(content);
            while (m.find()) {
                hashMapEnglist.put(m.group(1), m.group(2));
            }
            return hashMapEnglist;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public String seachIntEnglist(HashMap<String, String> hashMap, String english) {
        Pattern pattern = Pattern.compile(english);
        Set<String> setHasdM = hashMap.keySet();
        for (String x : setHasdM) {
            Matcher matcher = pattern.matcher(x);
            if (matcher.find()) {
                return x;
            }
        }
        return null;
    }

    public String display_SeachEnglish(HashMap<String, String> hashMap, String keyWord) {
        String value = hashMap.get(keyWord);
        return keyWord + " = " + value;
    }

}



