package com.jeberson.affinity_allumni;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.local.UserIdStorageFactory;



public class Login extends AppCompatActivity {
    EditText etName,etPassword;
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);



        Backendless.UserService.isValidLogin(new AsyncCallback<Boolean>() {
            @Override
            public void handleResponse(Boolean response) {

                if(response)
                {
                    String userObjectId = UserIdStorageFactory.instance().getStorage().get();
                    Backendless.Data.of(BackendlessUser.class).findById(userObjectId, new AsyncCallback<BackendlessUser>() {
                        @Override
                        public void handleResponse(BackendlessUser response) {

                            startActivity(new Intent(Login.this,Profile.class));
                            Login.this.finish();
                        }

                        @Override
                        public void handleFault(BackendlessFault fault) {

                            Toast.makeText(Login.this,"Error ; " + fault.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else
                {

                }
            }

            @Override
            public void handleFault(BackendlessFault fault) {

                Toast.makeText(Login.this,"Error ; " + fault.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etName.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty()) {


                    Toast.makeText(Login.this, "Please enter all fields !!!", Toast.LENGTH_SHORT).show();


                } else
                {
                    String mail = etName.getText().toString().trim();
                    String Password = etPassword.getText().toString().trim();

                    Backendless.UserService.login(mail, Password, new AsyncCallback<BackendlessUser>() {
                        @Override
                        public void handleResponse(BackendlessUser response) {

                            Toast.makeText(Login.this, "Sucessfully Logged in !!!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Login.this,Profile.class));
                            Login.this.finish();
                        }

                        @Override
                        public void handleFault(BackendlessFault fault) {

                            Toast.makeText(Login.this, "Error !!!" + fault.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    });



                }
            }
        });
    }
}

