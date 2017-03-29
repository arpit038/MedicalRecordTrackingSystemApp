package sample.com.medicalrecordtrackingsystem.rest;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import sample.com.medicalrecordtrackingsystem.models.Department;
import sample.com.medicalrecordtrackingsystem.models.Doctor;
import sample.com.medicalrecordtrackingsystem.models.Hospital;

/**
 * Created by ayush on 27/3/17
 */
public interface ApiInterface {

    @GET("hospitals")
    Call<List<Hospital>> getHospitals();

    @GET("doctors")
    Call<List<Doctor>> getDoctors();

    @GET("doctors/departments")
    Call<List<Department>> getDepartments();

    @GET("doctors")
    Call<List<Doctor>> getDoctorBasedOnHospitalorDept(@QueryMap Map<String, String> params);
}
