package Castady;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class form_ComparingPrice extends JFrame {
    private JPanel panel1;
    private JTextArea txtBDS;
    private JTextArea txt123ND;
    private JButton soSánhButton;
    private JButton cậpNhậtButton;
    private JTextArea txtBDS_SS;
    private JTextArea txt123ND_SS;
    private JTextArea txtInputCity;

    public form_ComparingPrice() throws MalformedURLException {
        add(panel1);
        setSize(1400, 600);
        setTitle("JohnToan");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Tạo đối tượng
        Read_File_BDS read_file_bds = new Read_File_BDS();
        Read_File_KenhBDS Read_File_KenhBDS = new Read_File_KenhBDS();
        Controller_ReadFile controller_readFile = new Controller_ReadFile();

        //Tạo 2 ArrayList
        ArrayList<SanPham> listSP_BDS = read_file_bds.runProgram();
        ArrayList<SanPham> read_File_KenhBDS = Read_File_KenhBDS.runProgram();

        // hiển thị hai bên.
        txtBDS.setText(controller_readFile.display_Array(listSP_BDS));
        txt123ND.setText(controller_readFile.display_Array(read_File_KenhBDS));


        // các sự kiện nút
        soSánhButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String city = txtInputCity.getText();

                SanPham sanPham_123ND_1 =controller_readFile.search_Name(read_File_KenhBDS,city);
                if (sanPham_123ND_1 != null){
                    String totring = sanPham_123ND_1.toString();
                    txt123ND_SS.setText(totring);
                }else {
                    SanPham sanPham_123ND_2 =controller_readFile.search_Plance(read_File_KenhBDS,city);
                    if (sanPham_123ND_2 != null){
                        String totring = sanPham_123ND_2.toString();
                        txt123ND_SS.setText(totring);
                    }else {
                        txt123ND_SS.setText("ko có dữ liệu");
                    }
                }

                SanPham sanPham_BDS_1 = controller_readFile.search_Name(listSP_BDS,city);
                if (sanPham_BDS_1 != null){
                    String totring = sanPham_BDS_1.toString();
                    txtBDS_SS.setText(totring);
                }else {
                    SanPham sanPham_BDS_2 =controller_readFile.search_Plance(listSP_BDS,city);
                    if (sanPham_BDS_2 != null){
                        String totring = sanPham_BDS_2.toString();
                        txtBDS_SS.setText(totring);
                    }else {
                        txtBDS_SS.setText("ko có dữ liệu");
                    }
                }
            }
        });



        cậpNhậtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    ArrayList<SanPham> listSP_BDS = read_file_bds.runProgram();
                    ArrayList<SanPham> read_File_KenhBDS = Read_File_KenhBDS.runProgram();

                    txtBDS.setText(controller_readFile.display_Array(listSP_BDS));
                    txt123ND.setText(controller_readFile.display_Array(read_File_KenhBDS));

                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) throws MalformedURLException {
        form_ComparingPrice myFrom = new form_ComparingPrice();
        myFrom.setVisible(true);
    }
}
