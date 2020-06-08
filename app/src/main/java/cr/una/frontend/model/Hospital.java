package cr.una.frontend.model;

public class Hospital {

    private int id;

    private String name;

    private String phone;

    private String day1;

    private String day2;

    private String timeAttention;


    /**
     * @param id
     * @param name
     * @param phoneNumber
     * @param d1
     * @param d2
     * @param hour
     */
    public Hospital(int id, String name, String phoneNumber, String d1, String d2, String hour){
        this.id = id;
        name = name;
        phone = phoneNumber;
        timeAttention = hour;
        day1 = d1;
        day2 = d2;
    }

    public Hospital(){
        id = 0;
        name = " ";
        phone = " ";
        timeAttention = " ";
        day1 = " ";
        day2 = " ";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDay1() {
        return day1;
    }

    public void setDay1(String day1) {
        this.day1 = day1;
    }

    public String getDay2() {
        return day2;
    }

    public void setDay2(String day2) {
        this.day2 = day2;
    }

    public String getTimeAttention() {
        return timeAttention;
    }

    public void setTimeAttention(String timeAttention) {
        this.timeAttention = timeAttention;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", day1='" + day1 + '\'' +
                ", day2='" + day2 + '\'' +
                ", timeAttention='" + timeAttention + '\'' +
                '}';
    }
}
