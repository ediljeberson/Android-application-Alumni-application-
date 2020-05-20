package com.jeberson.affinity_allumni;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.socket.client.Url;

public class Profile extends AppCompatActivity {


    Button gallery,Contribution,feedback,joboffer,contact,logout,events,location,News_feed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        gallery = findViewById(R.id.gallery);

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent a = new Intent(Profile.this,Gallery.class);
                startActivity(a);




            }


        });



        contact = findViewById(R.id.contact);

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent b = new Intent(Profile.this,Contact.class);
                startActivity(b);




            }


        });

        logout = findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent c = new Intent(Profile.this,Home.class);
                startActivity(c);




            }


        });

        Contribution = findViewById(R.id.contrbution);

        Contribution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent d = new Intent(Profile.this,Payment.class);
                startActivity(d);




            }


        });

        events = findViewById(R.id.events);

        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent e = new Intent(Profile.this,Event.class);
                startActivity(e);




            }


        });


        joboffer = findViewById(R.id.joboffer);

        joboffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent f = new Intent(Profile.this,Job_offer.class);
                startActivity(f);


            }


        });

        location=findViewById(R.id.location);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent g = new Intent(Profile.this,Location.class);
                startActivity(g);
            }
        });


        feedback = findViewById(R.id.feedback);

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent h = new Intent(Profile.this,Feedback.class);
                startActivity(h);
            }
        });


        News_feed = findViewById(R.id.newsfeed);

        News_feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Profile.this,News_feed.class);
                startActivity(i);
            }
        });

    }
}
