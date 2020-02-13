package assignmentModul2;

import TestAsiggmen.SinhVien;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller_DanhBa {

    public ArrayList<Person> addInClassDB(ArrayList arrayList) {
        ArrayList<Person> listPerson = new ArrayList<>() ;
        for (int i = 0;i<arrayList.size();i++) {
            String str = (String) arrayList.get(i);
            String[] str2 = str.split(",");
            Person person = new Person(str2[0], str2[1], str2[2], str2[3], str2[4], str2[5], str2[6]);
            listPerson.add(person);
        }
        return listPerson;
    }


    public Person check_Int_Phone_D(ArrayList<Person> arrayList, String phone) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getPhone().equals(phone)) {
                return arrayList.get(i);
            }
        }
        return null;
    }

    public int getInt_Phone(ArrayList<Person> arrayList, String phone) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getPhone().equals(phone)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isCheck_Email(String emaill) {
        Pattern p = Pattern.compile("[a-zA-Z0-9]*@[a-zA-Z]*.com");
        Matcher m = p.matcher(emaill);
        if (m.find()) {
            return true;
        }
        return false;
    }

    public boolean isCheck_Phone(String phone) {
        Pattern p = Pattern.compile("^0[0-9]{9}$");
        Matcher m = p.matcher(phone);
        if (m.find()) {
            return true;
        }
        return false;
    }


    public void display_DanhBa(ArrayList<Person> arrayList, int indext) {
        if (indext != -1) {
                System.out.println(arrayList.get(indext).toString());
        } else {
            System.out.println("Không có Danh Bạ nào");
        }
    }


    //////////////////////////////////////////////////////////////

    public void addNewDanhBa(ArrayList<Person> arrayList, String name, String phone, String address, String email, String group, String gender, String brithday) {
        Person person = new Person(name, phone, address, email, group, gender, brithday);
        arrayList.add(person);
    }

    public void editDanhBa(Person person, String name, String phone, String address, String email, String group, String gender, String brithday) {
        person.setName(name);
        person.setPhone(phone);
        person.setAddress(address);
        person.setEmail(email);
        person.setGroup(group);
        person.setGender(gender);
        person.setBrithday(brithday);
    }

    public void deleteDanhBa(ArrayList<Person> arrayList, int index) {
        arrayList.remove(index);
    }

}

