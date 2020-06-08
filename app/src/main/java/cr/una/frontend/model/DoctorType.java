package cr.una.frontend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DoctorType {

    @JsonProperty("_id")
    private IdType id;
    @JsonProperty("tipo")
    private String type;
    @JsonProperty("salario")
    private double salary;
    @JsonProperty("moneda")
    private String coin;
    @JsonProperty("codigo-medico")
    private String code;

    /**
     * Default constructor
     */
    public DoctorType(){
    }

    /**
     *
     * @param id id
     * @param type type
     * @param salary salary
     * @param coin coin
     * @param code code
     */
    public DoctorType(IdType id, String type, double salary, String coin, String code){
        this.id = id;
        this.type = type;
        this.salary = salary;
        this.coin = coin;
        this.code = code;
    }


    /**
     *
     * @return id
     */
    public IdType getId() {
        return id;
    }

    /**
     *
     * @param id id
     */
    public void setId(IdType id) {
        this.id = id;
    }

    /**
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     *
     * @param salary salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     *
     * @return coin
     */
    public String getCoin() {
        return coin;
    }

    /**
     *
     * @param coin coin
     */
    public void setCoin(String coin) {
        this.coin = coin;
    }

    /**
     *
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return to string
     */
    @Override
    public String toString() {
        return "DoctorType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", salary=" + salary +
                ", coin='" + coin + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
