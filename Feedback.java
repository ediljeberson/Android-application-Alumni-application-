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
import com.backendless.files.BackendlessFile;

public class Feedback extends AppCompatActivity {



    TextView tv1,tv2;
    Button btnsubmit;
    EditText etfb1,etfb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);


        etfb1 = findViewById(R.id.etfb1);
        etfb2 = findViewById(R.id.etfb2);


        btnsubmit = findViewById(R.id.btnsubmit);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etfb1.getText().toString().isEmpty() || etfb2.getText().toString().isEmpty() )

                {
                    Toast.makeText(Feedback.this, "Please enter the all details!!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (etfb1.getText().toString().trim().equals(etfb2.getText().toString().trim()))
                    {
                        String fb1 = etfb1.getText().toString().trim();
                        String fb2 = etfb2.getText().toString().trim();

                        BackendlessUser a = new BackendlessUser();

                        a.setEmail(fb1);
                        a.setPassword(fb2);
                        a.setProperty("Feedback 1",fb1);
                        a.setProperty("Feedback 2",fb2);



                        Backendless.UserService.register(a, new AsyncCallback<BackendlessUser>() {
                            @Override
                            public void handleResponse(BackendlessUser response) {
                                Toast.makeText(Feedback.this, "Sucessfully Submitted !!!", Toast.LENGTH_SHORT).show();


                                Feedback.this.finish();
                                Intent j = new Intent(Feedback.this,Profile.class);
                                startActivity(j);

                            }
                            @Override
                            public void handleFault(BackendlessFault fault) {

                                Toast.makeText(Feedback.this, "Error!!!" + fault.getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        });

                    }
                    else {

                        Toast.makeText(Feedback.this, "Try again!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
