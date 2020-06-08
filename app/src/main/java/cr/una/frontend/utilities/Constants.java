package cr.una.frontend.utilities;

public class Constants {

    /**
     *
     */
    public static final Object[] PATIENTS_HEADER = {"Id", "Nombre", "Apellido", "Padecimiento"};

    /**
     *
     */
    public static final Object[] APPOINTMENT_HEADER = {"Id", "Paciente", "Fecha", "Hora", "Consultorio", "Precio", "Activo"};

    /**
     *
     */
    public static final Object[] HOSPITAL_HEADER = {"Id", "Nombre", "Phone"};

    /**
     *
     */
    public static final Object[] DOCTOR_HEADER = {"Id", "Nombre", "Apellido", "Tipo", "Premium"};

    /**
     *
     */
    public static final Object[] PATIENT_APPOINTMENTS_HEADER = {"Id", "Fecha", "Hora", "Consultorio"};

    /**
     *
     */
    public static final String WS_ENDPOINT = "http://localhost:8083/api/";
}
