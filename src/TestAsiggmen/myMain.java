package TestAsiggmen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class myMain {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Controller_Ass controller_ass = new Controller_Ass();
        IO_File io_file = new IO_File();

        ArrayList listReadFile = io_file.readFile();
        ArrayList<SinhVien> list_SV = new ArrayList();

        SinhVien sv1 = controller_ass.addInClassSV(listReadFile, 0);
        SinhVien sv2 = controller_ass.addInClassSV(listReadFile, 1);
        SinhVien sv3 = controller_ass.addInClassSV(listReadFile, 2);
        SinhVien sv4 = controller_ass.addInClassSV(listReadFile, 3);
        SinhVien sv5 = controller_ass.addInClassSV(listReadFile, 4);
        SinhVien sv6 = controller_ass.addInClassSV(listReadFile, 5);
        SinhVien sv7 = controller_ass.addInClassSV(listReadFile, 6);

        list_SV.add(sv1);
        list_SV.add(sv2);
        list_SV.add(sv3);
        list_SV.add(sv4);
        list_SV.add(sv5);
        list_SV.add(sv6);
        list_SV.add(sv7);
        System.out.println("hiển thị danh sách SV");
        controller_ass.displaySinhVien(list_SV);

        System.out.println("------------------------------------");
        System.out.println("hiển thị sv ở vị trí CGMD001124");
        System.out.println(controller_ass.checkInt_ID(list_SV, "CGMD001124").toString());

        System.out.println("------------------------------------");
        System.out.println("hiển thị sv có điểm trên 85");
        ArrayList<Integer> listIntPoint = controller_ass.getInt_Point(85, list_SV);
        controller_ass.display_SV_DK(list_SV, listIntPoint);

        System.out.println("------------------------------------");
        System.out.println("hiển thị sv có họ nguyễn");
        ArrayList<Integer> listIntName = controller_ass.getInt_Name("Nguyen", list_SV);
        controller_ass.display_SV_DK(list_SV, listIntName);

        System.out.println("------------------------------------");
        System.out.println("hiển thị sv có sai Email");
        ArrayList<Integer> listIntEmal = controller_ass.getInt_Email(list_SV, false);
        controller_ass.display_SV_DK(list_SV, listIntEmal);

        System.out.println("------------------------------------");
        System.out.println("hiển thị điểm SV tăm dần");
        controller_ass.sort_PointSV(list_SV);
        controller_ass.displaySinhVien(list_SV);
        io_file.writeFile("sapxepdiem.txt",list_SV);

        System.out.println("------------------------------------");
        System.out.println("hiển thị Name tăm dần");
        controller_ass.sort_Name(list_SV);
        controller_ass.displaySinhVien(list_SV);
        io_file.writeFile("sapxephoten.txt",list_SV);


        System.out.println("1 : thêm SV");
        System.out.println("2 : sửa SV");
        System.out.println("3 : xóa SV");
        System.out.println("4 : Show SV");
        System.out.println("5 : Exit");
        int key = scanner.nextInt();
        switch (key) {
            case 1:
                controller_ass.addNewSV(list_SV, "TNV12345", "Nguyen Van Toan", "johntoan98@gmail.com", 100);
                controller_ass.displaySinhVien(list_SV);
                break;
            case 2:
                controller_ass.editSV(list_SV.get(1), "TNV12345", "Nguyen Van Toan", "johntoan98@gmail.com", 100);
                controller_ass.displaySinhVien(list_SV);
                break;
            case 3:
                controller_ass.deleteSV(list_SV, 1);
                controller_ass.displaySinhVien(list_SV);
                break;
            case 4:
                controller_ass.displaySinhVien(list_SV);
                break;
            case 5:
                break;
        }
    }
}
