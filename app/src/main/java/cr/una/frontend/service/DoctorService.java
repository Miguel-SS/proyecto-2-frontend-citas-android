package cr.una.frontend.service;

import cr.una.frontend.model.Doctor;
import cr.una.frontend.model.DoctorType;
import cr.una.frontend.utilities.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

public class DoctorService {

    // Using logger for project
    private static final Logger logger = LogManager.getLogger(DoctorService.class);

    private static final String REST_URI = Constants.WS_ENDPOINT.concat("doctors");
    private Client client = null;

    /**
     * Empty Constructor
     */
    public DoctorService() {
        client = ClientBuilder.newClient();
    }

    /**
     * This method will load all the data from the WS
     *
     * @return the list of Students
     */
    public List<Doctor> loadAll() {

        logger.debug("Obteniendo toda la lista de doctores");

        // Library Jackson parse JSon
        List<Doctor> doctorList = null;

        doctorList = Arrays.asList(client.target(REST_URI).request(MediaType.APPLICATION_JSON)
                .get(Doctor[].class));

        return doctorList;
    }

    public Doctor searchById(int id) {
        Doctor doctorId;
        String url = REST_URI+"/"+id;
        doctorId = client.target(url).request(MediaType.APPLICATION_JSON).get(Doctor.class);
        return doctorId;
    }

    public Doctor save(Doctor doctor) {
        Doctor doctorSaved;

        doctorSaved = client.target(REST_URI).request(MediaType.APPLICATION_JSON).post(Entity.entity(doctor,
                MediaType.APPLICATION_JSON), Doctor.class);

        return doctorSaved;
    }

    public Doctor update(Doctor doctor) {
        Doctor doctorUpdated;

        doctorUpdated = client.target(REST_URI).request(MediaType.APPLICATION_JSON).put(Entity.entity(doctor,
                MediaType.APPLICATION_JSON), Doctor.class);

        return doctorUpdated;
    }

    public void delete(Doctor doctor) {
        String url = REST_URI+"/"+doctor.getId();
        client.target(url).request(MediaType.APPLICATION_JSON).delete().close();
    }


    // ********* DOCTOR TYPE **********
    /**
     * This method will load all the data from the WS
     * @return the list of Students
     */
    public List<DoctorType> loadAllTypes() {

        logger.debug("Obteniendo toda la lista de doctores");

        // Library Jackson parse JSon
        List<DoctorType> doctorTypeList;

        String URL = REST_URI.concat("/doctorTypes");

        doctorTypeList = Arrays.asList(client.target(URL).request(MediaType.APPLICATION_JSON)
                .get(DoctorType[].class));

        return doctorTypeList;
    }

    /**
     * @param id id
     * @return a specific type of doctor
     */
    public DoctorType searchTypeById(String id) {
        DoctorType doctorTypeId;
        String URL = REST_URI.concat("/doctorTypes/" + id);
        doctorTypeId = client.target(URL).request(MediaType.APPLICATION_JSON).get(DoctorType.class);
        return doctorTypeId;
    }
}
