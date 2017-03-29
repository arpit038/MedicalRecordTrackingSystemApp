package sample.com.medicalrecordtrackingsystem.models;

/**
 * Created by Friends on 29-03-2017.
 */

public class PatientSlot {

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getIndexOfPatient() {
        return indexOfPatient;
    }

    public void setIndexOfPatient(int indexOfPatient) {
        this.indexOfPatient = indexOfPatient;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorSlotId() {
        return doctorSlotId;
    }

    public void setDoctorSlotId(int doctorSlotId) {
        this.doctorSlotId = doctorSlotId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private int appointmentId;
    private int indexOfPatient;	//index of patient in the doctor slot
    private int patientId;
    private int doctorSlotId;
    private String status = "pending"; //"pending","accepted","rejected","completed"

}
