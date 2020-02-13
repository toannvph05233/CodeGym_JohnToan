package assignmentModul2;

import assignmentModul2.Controller_DanhBa;
import assignmentModul2.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class Model {

    public void displayDanhBa(ArrayList<Person> arrayList) {
        System.out.println("name            " + "phone          " + "address            " + "email              " + "group          " + "gender         " + "brithday");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i).toString());
        }
    }

    public void inputThongTin(Scanner scanner, Controller_DanhBa controller_danhBa, ArrayList<Person> arrayList) {
        System.out.println("Nhập tên : ");
        String name = scanner.nextLine();

        System.out.println("Nhập số điện thoại : ");

        String phone = scanner.nextLine();
        if (controller_danhBa.isCheck_Phone(phone) == false) {
            System.out.println("Bạn đã nhập sai số điện thoại");
            return;
        }

        System.out.println("Nhập địa chỉ : ");
        String address = scanner.nextLine();

        System.out.println("Nhập email : ");
        String email = scanner.nextLine();
        if (controller_danhBa.isCheck_Email(email) == false) {
            System.out.println("bạn đã nhập sai định dạng email :");
            return;
        }

        System.out.println("Nhập nhóm : ");
        String group = scanner.nextLine();

        System.out.println("Nhập giới tính : ");
        String gender = scanner.nextLine();

        System.out.println("Nhập năm sinh : ");
        String brithday = scanner.nextLine();

        controller_danhBa.addNewDanhBa(arrayList, name, phone, address, email, group, gender, brithday);
    }


    public void editThongTin(Scanner scanner, Controller_DanhBa controller_danhBa, ArrayList<Person> arrayList) {
        System.out.println("bạn muốn sửa người nào ? hãy nhập số điện thoại :");
        String phone_Edit = scanner.nextLine();
        if (controller_danhBa.check_Int_Phone_D(arrayList, phone_Edit) != null) {

            System.out.println("Nhập tên : ");
            String name = scanner.nextLine();

            System.out.println("Nhập số điện thoại : ");

            String phone = scanner.nextLine();
            if (controller_danhBa.isCheck_Phone(phone) == false) {
                System.out.println("Bạn đã nhập sai số điện thoại");
                return;
            }

            System.out.println("Nhập địa chỉ : ");
            String address = scanner.nextLine();

            System.out.println("Nhập email : ");
            String email = scanner.nextLine();
            if (controller_danhBa.isCheck_Email(email) == false) {
                System.out.println("bạn đã nhập sai định dạng email :");
                return;
            }

            System.out.println("Nhập nhóm : ");
            String group = scanner.nextLine();

            System.out.println("Nhập giới tính : ");
            String gender = scanner.nextLine();

            System.out.println("Nhập năm sinh : ");
            String brithday = scanner.nextLine();

            controller_danhBa.editDanhBa(controller_danhBa.check_Int_Phone_D(arrayList, phone_Edit), name, phone, address, email, group, gender, brithday);
        }else {
            System.out.println("số không có trong danh sách");
        }
    }
    public void delete_Danhsach(Scanner scanner, Controller_DanhBa controller_danhBa, ArrayList<Person> arrayList){
        System.out.println("bạn muốn xóa người nào? Nhập số điện thoại :");
        String phone_Edit = scanner.nextLine();
        if (controller_danhBa.getInt_Phone(arrayList, phone_Edit) != -1) {
            controller_danhBa.deleteDanhBa(arrayList,controller_danhBa.getInt_Phone(arrayList, phone_Edit));
            System.out.println("xóa thành công");
        }
    }


    public void seachPhone(Scanner scanner, Controller_DanhBa controller_danhBa, ArrayList<Person> arrayList){
        System.out.println("Bạn muốn tìm số điện thoại nào :");
        String phone_Edit = scanner.nextLine();
            controller_danhBa.display_DanhBa(arrayList,controller_danhBa.getInt_Phone(arrayList, phone_Edit));
            System.out.println("xóa thành công");
        }

}
