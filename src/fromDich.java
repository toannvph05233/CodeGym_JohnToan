import tuDien2.Controller2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class fromDich extends JFrame {
    private JTextArea txtDich;
    private JTextPane txtPDich;
    private JButton TiengVietButton;
    private JButton AddButton;
    private JButton EditButton;
    private JButton DeleteButton;
    private JButton ClearButton;
    private JPanel jP_Phong;

    public fromDich() {
        add(jP_Phong);
        setSize(700,500);
        setTitle("JohnToan");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Tạo đối tượng Controller:
        Controller2 controller2 =new Controller2();
        HashMap<String, String> hashMapEnglist = new HashMap<>();

        //Tạo ra hashMap;
        hashMapEnglist = controller2.readFile();

        HashMap<String, String> finalHashMapEnglist = hashMapEnglist;

        // Các Sự Kiện Kích Chuột:
        TiengVietButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String english = txtDich.getText();

                txtPDich.setText(translate(english,controller2, finalHashMapEnglist));

            }
        });
    }

    public static void main(String[] args) {
        fromDich myFrom = new fromDich();
        myFrom.setVisible(true);
    }
    public static String translate(String keyword, Controller2 controller2,HashMap<String, String> hashMap){
        return controller2.display_SeachEnglish(hashMap,controller2.seachIntEnglist(hashMap,keyword));
    }
}
