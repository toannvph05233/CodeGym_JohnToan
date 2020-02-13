package assignmentModul2;

public class Person {
    private String name;
    private String phone;
    private String address;
    private String email;
    private String group;
    private String gender;
    private String brithday;

    public Person() {
    }

    public Person(String name, String phone, String address, String email, String group, String gender, String brithday) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.group = group;
        this.gender = gender;
        this.brithday = brithday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBrithday() {
        return brithday;
    }

    public void setBrithday(String brithday) {
        this.brithday = brithday;
    }

    @Override
    public String toString() {
        return name + " , " + phone + " , " + address + " , " + email + " , " + group + " , " + gender + " , " + brithday + "\n";
    }
}
