package com.jeberson.affinity_allumni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class Registration extends AppCompatActivity {



    TextView etName,etDepartment,etYear,etEmail,etDOB,etMobileno,etPass,etCnfmpass;
    Button btnregister;
    EditText etname,etdep,etgraduation,etemail,etdob,etmob,etpass,etcnfmpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etName = findViewById(R.id.etName);
        etDepartment = findViewById(R.id.etDepartment);
        etYear = findViewById(R.id.etYear);
        etEmail = findViewById(R.id.etEmail);
        etDOB = findViewById(R.id.etDOB);
        etMobileno = findViewById(R.id.etMobileno);
        etPass = findViewById(R.id.etPass);
        etCnfmpass = findViewById(R.id.etCnfmpass);


        etname = findViewById(R.id.etname);
        etdep = findViewById(R.id.etdep);
        etgraduation = findViewById(R.id.etgraduation);
        etemail = findViewById(R.id.etemail);
        etdob = findViewById(R.id.etdob);
        etmob = findViewById(R.id.etmob);
        etpass = findViewById(R.id.etpass);
        etcnfmpass = findViewById(R.id.etcnfmpass);

        btnregister = findViewById(R.id.btnregister);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etname.getText().toString().isEmpty() || etemail.getText().toString().isEmpty() || etpass.getText().toString().isEmpty() ||
                        etdep.getText().toString().isEmpty() || etgraduation.getText().toString().isEmpty() || etdob.getText().toString().isEmpty() ||
                        etmob.getText().toString().isEmpty() || etcnfmpass.getText().toString().isEmpty())

                {
                    Toast.makeText(Registration.this, "Please enter the all details!!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (etpass.getText().toString().trim().equals(etcnfmpass.getText().toString().trim()))
                    {
                        String name = etname.getText().toString().trim();
                        String dep = etdep.getText().toString().trim();
                        String graduation = etgraduation.getText().toString().trim();
                        String email = etemail.getText().toString().trim();
                        String dob = etdob.getText().toString().trim();
                        String mob = etmob.getText().toString().trim();
                        String pass = etpass.getText().toString().trim();
                        String cnfmpass = etcnfmpass.getText().toString().trim();

                        BackendlessUser a = new BackendlessUser();
                        a.setEmail(email);
                        a.setPassword(pass);


                        a.setProperty("Name",name);
                        a.setProperty("Department",dep);
                        a.setProperty("DOB",dob);
                        a.setProperty("Mobile_number",mob);
                        a.setProperty("Graduation_year",graduation);
                        a.setProperty("confirm_password",cnfmpass);



                        Backendless.UserService.register(a, new AsyncCallback<BackendlessUser>() {
                            @Override
                            public void handleResponse(BackendlessUser response) {
                                Toast.makeText(Registration.this, "Sucessfully Registered !!!", Toast.LENGTH_SHORT).show();


                                Registration.this.finish();
                                Intent i = new Intent(Registration.this,Login.class);
                                startActivity(i);

                            }
                            @Override
                            public void handleFault(BackendlessFault fault) {

                                Toast.makeText(Registration.this, "Error!!!" + fault.getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        });

                    }
                    else {

                        Toast.makeText(Registration.this, "Password and Confirm Password don't match!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}