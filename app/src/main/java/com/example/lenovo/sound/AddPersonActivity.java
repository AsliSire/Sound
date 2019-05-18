package com.example.lenovo.sound;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class AddPersonActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);


        ImageView Back = (ImageView)findViewById(R.id.BtnBack);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddPersonActivity.this, "GERİ", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView Next = (ImageView)findViewById(R.id.BtnNext);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddPersonActivity.this, "İLERİ", Toast.LENGTH_SHORT).show();
            }
        });

        Button Duzenle = (Button)findViewById(R.id.btnDüzenle);
        Duzenle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.add_person_layout, new MenuFragment())
                        .commit();
            }
        });

    }
}
