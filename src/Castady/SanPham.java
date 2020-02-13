package Castady;

public class SanPham {
    private String name;
    private String place;
    private String area;
    private String price;

    public SanPham(String name, String place, String area, String price) {
        this.name = name;
        this.place = place;
        this.area = area;
        this.price = price;
    }

    public SanPham() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "- "+name +"\n" + place  +"\n" + area +"\n" + price+ "\n" ;
    }
}
