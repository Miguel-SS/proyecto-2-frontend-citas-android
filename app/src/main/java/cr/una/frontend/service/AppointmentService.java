package cr.una.frontend.service;

import cr.una.frontend.model.Appointment;
import cr.una.frontend.model.TypeOfService;
import cr.una.frontend.utilities.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

public class AppointmentService {

    // Using logger for project
    private static final Logger logger = LogManager.getLogger(AppointmentService.class);

    private static final String REST_URI = Constants.WS_ENDPOINT.concat("appointments");
    private Client client = null;

    /**
     * Empty Constructor
     */
    public AppointmentService() {
        client = ClientBuilder.newClient();
    }

    /**
     * This method will load all the data from the WS
     *
     * @return the list of Students
     */
    public List<Appointment> loadAll() {
        logger.info("Obteniendo toda la lista de doctores");
        return Arrays.asList(client.target(REST_URI).request(MediaType.APPLICATION_JSON)
                .get(Appointment[].class));
    }

    public Appointment searchById(int id) {
        String url = REST_URI+"/"+id;
        return client.target(url).request(MediaType.APPLICATION_JSON).get(Appointment.class);
    }

    public Appointment save(Appointment appointment) {
        return client.target(REST_URI).request(MediaType.APPLICATION_JSON).post(Entity.entity(appointment,
                MediaType.APPLICATION_JSON), Appointment.class);
    }

    public Appointment update(Appointment appointment) {
        return client.target(REST_URI).request(MediaType.APPLICATION_JSON).put(Entity.entity(appointment,
                MediaType.APPLICATION_JSON), Appointment.class);
    }

    public void delete(Appointment appointment) {
        String url = REST_URI+"/"+appointment.getId();
        client.target(url).request(MediaType.APPLICATION_JSON).delete().close();
    }


    // ********* SERVICE TYPE **********
    /**
     * This method will load all the data from the WS
     * @return the list of services of an appointment
     */
    public List<TypeOfService> loadAllTypes() {
        logger.debug("Obteniendo toda la lista de doctores");
        String URL = REST_URI.concat("/typesOfService");
        return Arrays.asList(client.target(URL).request(MediaType.APPLICATION_JSON)
                .get(TypeOfService[].class));
    }

    /**
     * @param id id
     * @return a specific type of service of an appointment
     */
    public TypeOfService searchTypeById(String id) {
        String URL = REST_URI.concat("/typesOfService/" + id);
        return client.target(URL).request(MediaType.APPLICATION_JSON).get(TypeOfService.class);
    }
}
