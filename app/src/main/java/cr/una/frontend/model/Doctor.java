package cr.una.frontend.model;

public class Doctor {

    private int id;
    private String name;
    private String lastName;
    private String type_id;
    private boolean premium;

    /**
     * Default constructor
     */
    public Doctor() {}


    /**
     *
     * @param id
     * @param name
     * @param lastName
     * @param type_id
     * @param premium
     */
    public Doctor(int id, String name, String lastName, String type_id, boolean premium) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.type_id = type_id;
        this.premium = premium;
    }


    /**
     * Getter
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter
     * @param lastName last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter
     * @return type
     */
    public String getType() {
        return type_id;
    }

    /**
     * Setter
     * @param type_id type
     */
    public void setType(String type_id) {
        this.type_id = type_id;
    }


    /**
     * Getter
     * @return premium
     */
    public boolean isPremium() {
        return premium;
    }

    /**
     * Setter
     * @param premium premium
     */
    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    /**
     * toString
     * @return the attributes of entity Doctor
     */
    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", type='" + type_id + '\'' +
                ", premium=" + premium +
                '}';
    }
}
