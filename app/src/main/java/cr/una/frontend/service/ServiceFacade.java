package cr.una.frontend.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import cr.una.frontend.model.*;
import cr.una.frontend.utilities.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServiceFacade {

    private PatientService patientService;
    private HospitalService hospitalService;
    private DoctorService doctorService;
    private AppointmentService appointmentService;



    public ServiceFacade() throws JsonGenerationException,
            JsonMappingException, IOException {

        patientService = new PatientService();
        hospitalService = new HospitalService();
        doctorService = new DoctorService();
        appointmentService = new AppointmentService();
    }

    public void add(Object o) {
        if(o.getClass() == Patient.class) {
            patientService.save((Patient) o);
        }
        if(o.getClass() == Appointment.class) {
            appointmentService.save((Appointment) o);
        }
        if(o.getClass() == Hospital.class) {
            hospitalService.saveHospital((Hospital) o);
        }
        if (o.getClass() == Doctor.class) {
            doctorService.save((Doctor) o);
        }
    }

    public void delete(Object o) {
        if(o.getClass() == Patient.class) {
            patientService.delete((Patient) o);
        }
        if(o.getClass() == Appointment.class) {
            appointmentService.delete((Appointment) o);
        }
        if(o.getClass() == Hospital.class) {
            hospitalService.delete((Hospital) o);
        }
        if(o.getClass() == Doctor.class) {
            doctorService.delete((Doctor) o);
        }
    }

    public void update(Object o){
        if(o.getClass() == Patient.class) {
            patientService.update((Patient) o);
        }
        if(o.getClass() == Appointment.class) {
            appointmentService.update((Appointment) o);
        }
        if(o.getClass() == Hospital.class) {
            hospitalService.update((Hospital) o);
        }
        if (o.getClass() == Doctor.class) {
            doctorService.update((Doctor) o);
        }
    }

    /**
     * @param id id
     * @return
     */
    public Object searchUser(int id) {
        if (patientService.searchById(id) != null) {
            return patientService.searchById(id);
        }
        if (doctorService.searchById(id) != null) {
            return doctorService.searchById(id);
        }

        return null;
    }

    public List<Patient> getPatientList() {
        return patientService.loadAll();
    }

    public List<Hospital> getHospitalList() {
        return hospitalService.loadAllHospitals();
    }

    public List<Doctor> getDoctorList() {
        return doctorService.loadAll();
    }

    public List<DoctorType> DoctorTypeList(){
        return doctorService.loadAllTypes();
    }

    public List<TypeOfService> servicesList() {
        return appointmentService.loadAllTypes();
    }

    /**
     *
     * @param id id
     * @return a doctor type entity
     */
    public DoctorType getDoctorType(String id) {
        return doctorService.searchTypeById(id);
    }

    /**
     * @param id id
     * @return
     */
    public Appointment searchAppointment(int id) {
        return appointmentService.searchById(id);
    }


    public TypeOfService searchTypeOfService(String id) {
        return appointmentService.searchTypeById(id);
    }

    public Hospital getHospital(int id) {
        return hospitalService.searchById(id);
    }

    // Load the patients in a matrix for a table
    public Object[][] loadPatientsObjWrapper() {
        List<Patient> patients = patientService.loadAll();
        Object[][] data = null;

        if(patients != null && patients.size() > 0) {
            data = new Object[patients.size()][Constants.PATIENTS_HEADER.length];
            int i = 0;
            for(Patient patient : patients) {
                data[i][0] = checkIfNull(patient.getId());
                data[i][1] = checkIfNull(patient.getName());
                data[i][2] = checkIfNull(patient.getLastName());
                data[i][3] = checkIfNull(patient.getDisease());
                i++;
            }
        }
        return data;
    }

    // Load the appointments in a matrix for a table
    public Object[][] loadAppointmentsObjWrapper() {
        List<Appointment> appointments = appointmentService.loadAll();
        Object[][] data = null;

        if(appointments != null && appointments.size() > 0) {
            data = new Object[appointments.size()][Constants.APPOINTMENT_HEADER.length];
            String patientName;
            String date;
            int i = 0;
            for(Appointment appointment : appointments) {
                data[i][0] = checkIfNull(appointment.getId());
                patientName = appointment.getPatient().getName() + appointment.getPatient().getLastName();
                data[i][1] = checkIfNull(patientName);
                date = appointment.getDate().getDay() + "/" +
                        appointment.getDate().getMonth() + "/" +
                        appointment.getDate().getYear();
                data[i][2] = checkIfNull(date);
                data[i][3] = checkIfNull(appointment.getHour());
                data[i][4] = checkIfNull(appointment.getHospital().getName());
                data[i][5] = checkIfNull(appointment.getTotalCost());
                data[i][6] = checkIfNull(appointment.isActive());
                i++;
            }
        }
        return data;
    }

    // Load the appointments in a matrix for a table
    public Object[][] loadHospitalsObjWrapper() {
        List<Hospital> hospitals = hospitalService.loadAllHospitals();
        Object[][] data = null;

        if(hospitals != null && hospitals.size() > 0) {
            data = new Object[hospitals.size()][Constants.HOSPITAL_HEADER.length];
            int i = 0;
            for(Hospital hospital : hospitals) {
                data[i][0] = checkIfNull(hospital.getId());
                data[i][1] = checkIfNull(hospital.getName());
                data[i][2] = checkIfNull(hospital.getPhone());
                i++;
            }
        }
        return data;
    }

    // Load the patients in a matrix for a table
    public Object[][] loadDoctorsObjWrapper() {
        List<Doctor> doctors = doctorService.loadAll();
        Object[][] data = null;

        if(doctors != null && doctors.size() > 0) {
            data = new Object[doctors.size()][Constants.DOCTOR_HEADER.length];
            int i = 0;
            for(Doctor doctor : doctors) {
                data[i][0] = checkIfNull(doctor.getId());
                data[i][1] = checkIfNull(doctor.getName());
                data[i][2] = checkIfNull(doctor.getLastName());
                if (doctorService.searchTypeById(doctor.getType()) != null) {
                    data[i][3] = checkIfNull(doctorService.searchTypeById(doctor.getType()).getType());
                } else {
                    data[i][3] = checkIfNull(null);
                }
                data[i][4] = checkIfNull(doctor.isPremium());
                i++;
            }
        }
        return data;
    }

    /**
     * @param obj obj
     * @return the string of an object
     */
    private String checkIfNull(Object obj) {
        String text;
        if(obj == null) {
            text = "";
        } else {
            text = obj.toString();
        }
        return text;
    }
}
