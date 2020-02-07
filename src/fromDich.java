import tuDien2.Controller_TD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

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
        setSize(600, 600);
        setTitle("JohnToan");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Tạo đối tượng Controller:
        Controller_TD controller = new Controller_TD();
        //Tạo ra hashMap;
        HashMap<String, String> hashMapEnglist = controller.readFile();
        
        
        
        // Các Sự Kiện Kích Chuột:
        TiengVietButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String english = txtDich.getText();

                if (controller.seachEnglist_D(hashMapEnglist, english) == null) {
                    if (controller.seachEnglist_GD(hashMapEnglist, english) == null) {
                        txtPDich.setText("Chưa có từ này");
                    } else {
                        txtPDich.setText(controller.seachEnglist_GD(hashMapEnglist, english));
                    }
                } else {
                    txtPDich.setText(controller.seachEnglist_D(hashMapEnglist, english));
                }
            }
        });
        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = txtDich.getText();
                String value = txtPDich.getText();
                boolean ischeck_Key = controller.isCheck_Key(hashMapEnglist, key);
                if (ischeck_Key == true) {
                    controller.addEnglist(hashMapEnglist, key, value);
                    try {
                        controller.writeFile_GhiDe(hashMapEnglist);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    txtDich.setText("");
                    txtPDich.setText("Thêm thành công");
                } else {
                    txtDich.setText("");
                    txtPDich.setText("Key đã có trong File.");
                }
            }
        });
        EditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = txtDich.getText();
                String value = txtPDich.getText();
                boolean ischeck_Key = controller.isCheck_Key(hashMapEnglist, key);
                if (ischeck_Key == false) {
                    controller.edit(hashMapEnglist, value, key);
                    try {
                        controller.writeFile_GhiDe(hashMapEnglist);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    txtDich.setText("");
                    txtPDich.setText("sửa thành công");
                } else {
                    txtDich.setText("");
                    txtPDich.setText("Key chưa có trong File.");
                }
            }
        });
        DeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = txtDich.getText();
                boolean ischeck_Key = controller.isCheck_Key(hashMapEnglist, key);
                if (ischeck_Key == false) {
                    controller.delete(hashMapEnglist, key);
                    try {
                        controller.writeFile_GhiDe(hashMapEnglist);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    txtDich.setText("");
                    txtPDich.setText("xóa thành công");
                } else {
                    txtDich.setText("");
                    txtPDich.setText("Key chưa có trong File.");
                }
            }
        });
        ClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDich.setText("");
                txtPDich.setText("");
            }
        });
    }

    
    
    public static void main(String[] args) {
        fromDich myFrom = new fromDich();
        myFrom.setVisible(true);
    }

}
