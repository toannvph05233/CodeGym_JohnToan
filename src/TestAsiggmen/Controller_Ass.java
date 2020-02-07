package TestAsiggmen;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller_Ass {

    public SinhVien addInClassSV(ArrayList arrayList, int index) {
        String str = (String) arrayList.get(index);
        String[] str2 = str.split(";");
        int num = Integer.parseInt(str2[3]);
        SinhVien sv = new SinhVien(str2[0], str2[1], str2[2], num);
        return sv;
    }


    public void displaySinhVien(ArrayList<SinhVien> arrayList) {
        System.out.println("Mã SV          Tên SV          Email          Điểm");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i).toString());
        }
    }

    public SinhVien checkInt_ID(ArrayList<SinhVien> arrayList, String ID) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getID_SV().equals(ID)) {
                return arrayList.get(i);
            }
        }
        return null;
    }

    public ArrayList<Integer> getInt_Point(int point, ArrayList<SinhVien> arrayList) {
        ArrayList<Integer> listInt = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getPoint() > point) {
                listInt.add(i);
            }
        }
        return listInt;
    }

    public void display_SV_DK(ArrayList<SinhVien> arrayList, ArrayList<Integer> listInt) {
        if (listInt.size() != 0) {
            for (int i = 0; i < listInt.size(); i++) {
                System.out.println(arrayList.get(listInt.get(i)).toString());
            }
        } else {
            System.out.println("Không có SV nào");
        }
    }

    public ArrayList<Integer> getInt_Name(String name, ArrayList<SinhVien> arrayList) {
        ArrayList<Integer> listInt = new ArrayList<>();
        Pattern p = Pattern.compile(name);
        for (int i = 0; i < arrayList.size(); i++) {
            Matcher m = p.matcher(arrayList.get(i).getName_SV());
            if (m.find()) {
                listInt.add(i);
            }
        }
        return listInt;
    }


    public ArrayList<Integer> getInt_Email(ArrayList<SinhVien> arrayList, boolean isEmail) {
        ArrayList<Integer> listInt = new ArrayList<>();

        Pattern p = Pattern.compile("[a-zA-Z0-9]*@[a-zA-Z]*.com");
        for (int i = 0; i < arrayList.size(); i++) {
            Matcher m = p.matcher(arrayList.get(i).getEmail());
            if (m.find() == isEmail) {
                listInt.add(i);
            }
        }
        return listInt;
    }

    public void sort_PointSV(ArrayList<SinhVien> arrayList) {
        Collections.sort(arrayList, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien sv1, SinhVien sv2) {
                if (sv1.getPoint() > sv2.getPoint()) {
                    return 1;
                } else {
                    if (sv1.getPoint() == sv2.getPoint()) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        });
    }

    public void sort_Name(ArrayList<SinhVien> arrayList){
        Collections.sort(arrayList, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien sv1, SinhVien sv2) {
                return (sv1.getName_SV().compareTo(sv2.getName_SV()));
            }
        });
    }

    //////////////////////////////////////////////////////////////

    public void addNewSV(ArrayList<SinhVien> arrayList, String ID_SV, String Name_SV, String Email, int Point) {
        SinhVien sinhVien = new SinhVien(ID_SV, Name_SV, Email, Point);
        arrayList.add(sinhVien);
    }

    public void editSV(SinhVien sv,String ID_SV, String Name_SV, String Email, int Point){
        sv.setID_SV(ID_SV);
        sv.setName_SV(Name_SV);
        sv.setEmail(Email);
        sv.setPoint(Point);
    }

    public void deleteSV(ArrayList<SinhVien> arrayList,int index){
        arrayList.remove(index);
    }

}

