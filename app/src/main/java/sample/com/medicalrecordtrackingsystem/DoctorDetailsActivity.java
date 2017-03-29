package sample.com.medicalrecordtrackingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sample.com.medicalrecordtrackingsystem.models.Department;
import sample.com.medicalrecordtrackingsystem.rest.ApiClient;
import sample.com.medicalrecordtrackingsystem.rest.ApiInterface;
import sample.com.medicalrecordtrackingsystem.models.Doctor;
/**
 * Created by ayush on 28/3/17
 */
class DoctorDetailsActivity extends AppCompatActivity {

    private ApiInterface apiService;
    private int hospitalId;
    private String dept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        hospitalId = intent.getIntExtra("hospital_id", 0);
        dept = intent.getStringExtra("dept");
        getApiClient();
        getDoctorBasedOnHospital(hospitalId, dept);
    }

    private void getApiClient() {
        apiService = ApiClient.getCient().create(ApiInterface.class);
    }

    /**
     * Function to get doctor based on hospital selected from spinner
     *
     * @param
     */
    private void getDoctorBasedOnHospital(int hospitalId, String dept) {
        Map<String, String> params;
        Call<List<Doctor>> call = null;
        if (hospitalId != 0 && dept == null) {
            params = new HashMap<String, String>();
            params.put("hospitalId", hospitalId);
            call = apiService.getDoctorBasedOnHospitalorDept(params);
        } else if (hospitalId == 0 && dept != null) {
            params = new HashMap<String, String>();
            params.put("dept", dept);
            call = apiService.getDoctorBasedOnHospitalorDept(params);
        } else if (hospitalId != 0 && dept != null) {
            params = new HashMap<String, String>();
            params.put("hospitalId", hospitalId);
            params.put("dept", dept);
            call = apiService.getDoctorBasedOnHospitalorDept(params);
        }

        if (call != null) {
            call.enqueue(new Callback<List<Doctor>>() {
                @Override
                public void onResponse(Call<List<Doctor>> call, Response<List<Doctor>> response) {
                    if (response != null) {
                        if (response.isSuccessful() && response.body() != null) {
                            List<Doctor> doctorList = response.body();
//                            populateDoctorList(doctorList);
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<Doctor>> call, Throwable t) {

                }
            });
        } else {
            //call is null
        }
//     }
//
//
//    private void populateDoctorList(final List<Doctor> doctorList) {
//        List<String> departmentNames = new ArrayList<>();
//
//        };
    }
}