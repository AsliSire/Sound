package com.example.lenovo.sound;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity /*implements DatePickerDialog.OnDateSetListener*/{

    private static final String TAG = "SignupActivity";
    private Button kayit;

/*
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        kayit=(Button)findViewById(R.id.kayit);
        kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignupActivity.this, "deneme", Toast.LENGTH_SHORT).show();
            }
        });

        EditText Name =(EditText)findViewById(R.id.NameTxt);

/*
        mDisplayDate = (TextView)findViewById(R.id.DateTxt);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getSupportFragmentManager(), "datePicker");

            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        mDisplayDate.setText(String.valueOf(dayOfMonth + " " + month + " " + year));*/
   }
}
