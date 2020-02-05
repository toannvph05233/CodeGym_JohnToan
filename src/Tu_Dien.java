
import java.util.ArrayList;
import java.util.Scanner;

public class Tu_Dien {
    public static void main(String[] args) {
        String str = null;
        ArrayList array = new ArrayList();
        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);

        System.out.println("nhập từ muốn tìm :");
        String english ="@";

        english += scanner.nextLine()+"*";

    // array chứa toàn bộ dữ kiệu trong file
        array = controller.readFile();

    //num1: index vitri của English - num2 : index khi tìm thay @:
        int num1 = controller.seachInt(array,english);
        int num2 = controller.seachIntEnd(array,controller.seachInt(array,english));

    //hiển thị:
        controller.display(num1,num2,array);

    for (int i =0;i<10000;i++){
        str += array.get(i);
    }
        System.out.println(str);
    }
}
