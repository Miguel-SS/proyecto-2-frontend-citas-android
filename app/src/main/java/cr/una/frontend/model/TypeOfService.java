package cr.una.frontend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TypeOfService {

    @JsonProperty("_id")
    private IdType id;
    @JsonProperty("servicio")
    private String service;
    @JsonProperty("costo-porcentual")
    private float percentageCost;
    @JsonProperty("codigo-medico")
    private String medicalCode;

    /**
     * Default constructor
     */
    public TypeOfService(){

    }

    /**
     *
     * @param id id
     * @param service service
     * @param percentageCost percentageCost
     * @param medicalCode medicalCode
     */
    public TypeOfService(IdType id, String service, float percentageCost, String medicalCode){
        this.id = id;
        this.service = service;
        this.percentageCost = percentageCost;
        this.medicalCode = medicalCode;
    }

    /**
     * getter
     * @return id
     */
    public IdType getId() {
        return id;
    }

    /**
     * setter
     * @param id id
     */
    public void setId(IdType id) {
        this.id = id;
    }

    /**
     * getter
     * @return type of service
     */
    public String getService() {
        return service;
    }

    /**
     * setter
     * @param service type of service
     */
    public void setService(String service) {
        this.service = service;
    }

    /**
     * getter
     * @return percentage Cost
     */
    public float getPercentageCost() {
        return percentageCost;
    }

    /**
     * setter
     * @param percentageCost percetage cost
     */
    public void setPercentageCost(float percentageCost) {
        this.percentageCost = percentageCost;
    }

    /**
     * getter
     * @return medical code
     */
    public String getMedicalCode() {
        return medicalCode;
    }

    /**
     * setter
     * @param medicalCode medical code
     */
    public void setMedicalCode(String medicalCode) {
        this.medicalCode = medicalCode;
    }

    /**
     * method to String
     * @return all information
     */
    @Override
    public String toString() {
        return "TypeOfService{" +
                "id=" + id +
                ", service='" + service + '\'' +
                ", percentageCost=" + percentageCost +
                ", medicalCode='" + medicalCode + '\'' +
                '}';
    }
}
