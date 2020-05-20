package com.jeberson.affinity_allumni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Gallery extends AppCompatActivity {

    ImageButton library;
    ImageButton logo;
    ImageButton apj;
    ImageButton entrance;
    ImageButton corres;
    ImageButton library1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        library = (ImageButton) findViewById(R.id.btnvission2);
        logo = (ImageButton) findViewById(R.id.imageButton2);
        entrance = (ImageButton) findViewById(R.id.imageButton3);
        apj = (ImageButton) findViewById(R.id.img1);
        corres = (ImageButton) findViewById(R.id.btncorep);
        library1 = (ImageButton) findViewById(R.id.btnvission1);


        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Gallery.this, img1.class);
                startActivity(a);
            }
        });
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(Gallery.this, img2.class);
                startActivity(b);
            }
        });
        entrance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(Gallery.this, img3.class);
                startActivity(c);
            }
        });
        apj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(Gallery.this, img4.class);
                startActivity(d);
            }
        });
        corres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(Gallery.this, img5.class);
                startActivity(e);
            }
        });
        library1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent f = new Intent(Gallery.this, img6.class);
                startActivity(f);
            }
        });

    }
}