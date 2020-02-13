package Castady;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller_ReadFile {
    final int getGroup1 = 1;
    final int getGroup2 = 2;
    final int getGroup3 = 3;


    public String convertArr_String(ArrayList arrayList) {
        String str = "";
        for (int i = 0; i < arrayList.size(); i++) {
            str += arrayList.get(i) + " ---";
        }
        return str;
    }

    public SanPham convertSanPham(String name, String place, String area, String price) {
        SanPham sanPham = new SanPham(name, place, area, price);
        return sanPham;
    }

    public ArrayList<SanPham> star(String linkcon, ArrayList listLink, IO_File io_file, int getGroup,
                                   Controller_ReadFile controller_readFile, ArrayList<SanPham> arraySP,
                                   String fomatKhuVuc, String fomatDienTic, String fomatGia, String nameFile) {

        for (int f = 0; f < 5; f++) {
            String string = linkcon;
            string += (String) listLink.get(f);
            URL urlcon = null;
            try {
                urlcon = new URL(string);
                this.createArray(io_file, controller_readFile, getGroup, arraySP,
                        fomatKhuVuc, fomatDienTic, fomatGia, urlcon);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        io_file.wiretFile(arraySP, nameFile);

        return arraySP;

    }

    public void createArray(IO_File io_file, Controller_ReadFile controller_readFile, int getGroup,
                            ArrayList<SanPham> arraySP, String fomatKhuVuc, String fomatDienTic,
                            String fomatGia, URL urlcon) {

        ArrayList listKhuVuc = io_file.readFile(urlcon, fomatKhuVuc, getGroup);
        ArrayList listArea = io_file.readFile(urlcon, fomatDienTic, getGroup1);
        ArrayList listPrice = io_file.readFile(urlcon, fomatGia, getGroup1);
        ArrayList listThanhPho = io_file.readFile(urlcon, fomatKhuVuc, getGroup3);

        String name = controller_readFile.convertArr_String(listKhuVuc);
        String place = controller_readFile.convertArr_String(listThanhPho);
        String area = controller_readFile.convertArr_String(listArea);
        String price = controller_readFile.convertArr_String(listPrice);

        arraySP.add(controller_readFile.convertSanPham(name, place, area, price));

    }


    public String display_Array(ArrayList<SanPham> arrayList) {
        String str = "";
        for (SanPham x : arrayList) {
            str += x + "\n";
        }
        return str;
    }

    public SanPham search_Name(ArrayList<SanPham> arrayList, String city) {
        Pattern pattern = Pattern.compile(city);
        for (int i = 0; i < arrayList.size(); i++) {
            Matcher matcher = pattern.matcher(arrayList.get(i).getName());
            if (matcher.find()) {
                return arrayList.get(i);
            }
        }
        return null;
    }


    public SanPham search_Plance(ArrayList<SanPham> arrayList, String plance) {
        Pattern pattern = Pattern.compile(plance);
        for (int i = 0; i < arrayList.size(); i++) {
            Matcher matcher = pattern.matcher(arrayList.get(i).getPlace());
            if (matcher.find()) {
                return arrayList.get(i);
            }
        }
        return null;
    }
}

