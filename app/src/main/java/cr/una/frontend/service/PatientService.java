package cr.una.frontend.service;

import cr.una.frontend.model.Patient;
import cr.una.frontend.utilities.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

public class PatientService {

    // Using logger for project
    private static final Logger logger = LogManager.getLogger(PatientService.class);

    private static final String REST_URI = Constants.WS_ENDPOINT.concat("patients");
    private Client client = null;

    /**
     * Empty Constructor
     */
    public PatientService() {
        client = ClientBuilder.newClient();
    }

    /**
     * This method will load all the data from the WS
     *
     * @return the list of Students
     */
    public List<Patient> loadAll() {

        logger.debug("Obteniendo toda la lista de pacientes");

        // Library Jackson parse JSon
        List<Patient> patientList = null;

        patientList = Arrays.asList(client.target(REST_URI).request(MediaType.APPLICATION_JSON)
                .get(Patient[].class));

        return patientList;
    }





    public Patient searchById(int id){
        Patient patientId;
        String url = REST_URI+"/"+id;
        patientId = client.target(url).request(MediaType.APPLICATION_JSON).get(Patient.class);
        return patientId;
    }

    public Patient save(Patient patient) {
        Patient patientSaved;

        patientSaved = client.target(REST_URI).request(MediaType.APPLICATION_JSON).post(Entity.entity(patient,
                MediaType.APPLICATION_JSON), Patient.class);

        return patientSaved;
    }

    public Patient update(Patient patient) {
        Patient patientUpdated;

        patientUpdated = client.target(REST_URI).request(MediaType.APPLICATION_JSON).put(Entity.entity(patient,
                MediaType.APPLICATION_JSON), Patient.class);

        return patientUpdated;
    }

    public void delete(Patient patient) {
        String url = REST_URI+"/"+patient.getId();
        client.target(url).request(MediaType.APPLICATION_JSON).delete().close();
    }
}
