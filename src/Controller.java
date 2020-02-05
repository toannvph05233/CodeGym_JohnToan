import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    public ArrayList readFile() {
        ArrayList array = new ArrayList();
        try {
            String inputString;
            Scanner scanner = new Scanner(Paths.get("C:\\Users\\TOAN\\IdeaProjects\\JohnToan\\anhviet109K.txt"), "UTF-8");
            while (scanner.hasNextLine()) {
                inputString = scanner.nextLine();
                array.add(inputString);
            }
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    public int seachInt(ArrayList arr, String english) {
        Pattern pattern = Pattern.compile(english);
        for (int i = 0; i < arr.size(); i++) {
            String str = (String) arr.get(i);
            Matcher matcher = pattern.matcher((String) arr.get(i));
            if (matcher.find()) {
                return i;
            }
        }
        return -1;
    }

    public int seachIntEnd(ArrayList arr, int index) {
        if (index >= 0) {
            Pattern pattern = Pattern.compile("@+\\w");
            String str;
            for (int i = index + 1; i < arr.size(); i++) {
                str = (String) arr.get(i);
                Matcher matcher = pattern.matcher((String) arr.get(i));
                if (matcher.find()) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int seachIntStar(ArrayList arr, int index) {
        if (index >= 0) {
            Pattern pattern = Pattern.compile("@+\\w");
            String str;
            for (int i = index ; i >0; i--) {
                str = (String) arr.get(i);
                Matcher matcher = pattern.matcher((String) arr.get(i));
                if (matcher.find()) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void display(int num1,int num2,ArrayList arr){
        for (int i = num1;i<num2;i++){
            System.out.println(arr.get(i));
        }
    }


}
