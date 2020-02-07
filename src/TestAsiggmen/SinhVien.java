package TestAsiggmen;

import java.util.Comparator;

public class SinhVien {
    private String ID_SV;
    private String Name_SV;
    private String Email;
    private int Point;

    public SinhVien() {
    }

    public SinhVien(String ID_SV, String name_SV, String email, int point) {
        this.ID_SV = ID_SV;
        Name_SV = name_SV;
        Email = email;
        Point = point;
    }

    public String getID_SV() {
        return ID_SV;
    }

    public void setID_SV(String ID_SV) {
        this.ID_SV = ID_SV;
    }

    public String getName_SV() {
        return Name_SV;
    }

    public void setName_SV(String name_SV) {
        Name_SV = name_SV;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getPoint() {
        return Point;
    }

    public void setPoint(int point) {
        Point = point;
    }

    @Override
    public String toString() {
        return ID_SV + "          " + Name_SV + "          " + Email + "          " + Point;
    }
}
