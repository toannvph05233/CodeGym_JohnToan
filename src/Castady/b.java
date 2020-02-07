package Castady;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b {
//    add(panel1);
//    setSize(600, 900);
//    setTitle("JohnToan");
//        this.setLocationRelativeTo(null);
//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//    // tạo 2 trang;
//    ReadFile_BDS readFile_bds = new ReadFile_BDS();
//    ReadFile_123ND readFile_123ND = new ReadFile_123ND();
//
//    // tạo 2 hasd map chứa nội dung;
//    HashMap<String, String> hashMap_BDS = readFile_bds.startFile();
//    HashMap<String, String> hashMap_123ND = readFile_123ND.startFile();
//
//    // hiển thị 2 hasdmap ở rìa
//        this.display_HasdMap(hashMap_BDS,txtDisplay_BDS);
//        this.display_HasdMap(hashMap_123ND,txtDisplay_123ND);
//
//
//
//
//        soSánhButton.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            this.search(txtComparing, txtP_BDS, txtP_123ND, hashMap_BDS, hashMap_123ND);
//        }
//
//        public void search(JTextArea txtComparing, JTextPane txtP_BDS, JTextPane txtP_123ND, HashMap<String, String> hashMap_BDS, HashMap<String, String> hashMap_123ND) {
//            String name_TP = txtComparing.getText();
//
//            Set<String> setHasd_BDS = hashMap_BDS.keySet();
//            Set<String> setHasd_123ND = hashMap_123ND.keySet();
//
//            Pattern pattern = Pattern.compile(name_TP);
//            for (String x : setHasd_BDS) {
//                Matcher matcher = pattern.matcher(x);
//                if (matcher.find()) {
//                    txtP_BDS.setText(x + hashMap_BDS.get(x));
//                }else {
//                    txtP_BDS.setText("không tìm được");
//                }
//            }
//            for (String x : setHasd_123ND) {
//                Matcher matcher = pattern.matcher(x);
//                if (matcher.find()) {
//                    txtP_123ND.setText(x + hashMap_123ND.get(x));
//                } else {
//                    txtP_123ND.setText("không tìm được");
//                }
//            }
//        }
//    });
//        newFileButton.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//
//        }
//    });
//}
//
//
//
//
//
//    public static void main(String[] args) throws IOException {
//        FormComparingPrice myFrom = new FormComparingPrice();
//        myFrom.setVisible(true);
//
//    }
//
//    public void display_HasdMap(HashMap<String, String> hashMap,JTextArea jTextArea){
//        String str="";
//        for (HashMap.Entry<String, String> entry : hashMap.entrySet()) {
//            str +=entry + "\n";
//        }
//        jTextArea.setText(str);
//    }
}
