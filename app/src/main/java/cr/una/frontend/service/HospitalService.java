package cr.una.frontend.service;

import cr.una.frontend.model.Hospital;
import cr.una.frontend.utilities.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

public class HospitalService {

    // Using logger for project
    private static final Logger logger = LogManager.getLogger(PatientService.class);

    private static final String REST_URI2 = Constants.WS_ENDPOINT.concat("hospitals");
    private Client client = null;

    /**
     * Empty Constructor
     */
    public HospitalService() {
        client = ClientBuilder.newClient();
    }

    /**
     * This method will load all the data from the WS
     *
     * @return the list of Students
     */
    public List<Hospital> loadAllHospitals() {

        logger.debug("Obteniendo toda la lista de hospitales");

        // Library Jackson parse JSon
        List<Hospital> hospitalList = null;

        hospitalList = Arrays.asList(client.target(REST_URI2).request(MediaType.APPLICATION_JSON)
                .get(Hospital[].class));

        return hospitalList;
    }

    public Hospital searchById(int id){
        Hospital hospitalId;
        String url = REST_URI2+"/"+id;
        hospitalId = client.target(url).request(MediaType.APPLICATION_JSON).get(Hospital.class);
        return hospitalId;
    }

    public Hospital saveHospital(Hospital hospital) {
        Hospital hospitalSaved;

        hospitalSaved = client.target(REST_URI2).request(MediaType.APPLICATION_JSON).post(Entity.entity(hospital,
                MediaType.APPLICATION_JSON), Hospital.class);

        return hospitalSaved;
    }

    public Hospital update(Hospital hospital) {
        Hospital hospitalUpdated;

        hospitalUpdated = client.target(REST_URI2).request(MediaType.APPLICATION_JSON).put(Entity.entity(hospital,
                MediaType.APPLICATION_JSON), Hospital.class);

        return hospitalUpdated;
    }

    public void delete(Hospital hospital) {
        Response patientId;
        String url = REST_URI2+"/"+hospital.getId();
        client.target(url).request(MediaType.APPLICATION_JSON).delete().close();
    }
}
