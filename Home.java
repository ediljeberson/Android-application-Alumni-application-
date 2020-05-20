package com.jeberson.affinity_allumni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {
    Button btnLogin;
    Button btnregister;
    Button btnvission;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Home.this,Login.class);
                startActivity(i);


            }
        });

        Button btn2 = (Button) findViewById(R.id.btnregister);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j =new Intent(Home.this,Registration.class);
                startActivity(j);
            }
        });

        Button btn3 = (Button) findViewById(R.id.btnvission);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k =new Intent(Home.this,Vision_and_Mission.class);
                startActivity(k);
            }
        });
    }
}

