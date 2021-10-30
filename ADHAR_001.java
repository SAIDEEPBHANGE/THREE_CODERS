package com.example.adhar;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ADHAR_001 extends AppCompatActivity {
        private TextView number,ph,a_01,a_02,email;
        private Button submit;
        FirebaseDatabase db;
        DatabaseReference root;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_adhar001);
            number = findViewById(R.id.textView3);
            ph = findViewById(R.id.textView4);
            a_01 = findViewById(R.id.textView11);
            a_02 = findViewById(R.id.textView12);
            email = findViewById(R.id.textView5);
            String user_dhr = getIntent().getStringExtra("key_dhr");
            String user_ph = getIntent().getStringExtra("key_ph");
            String user_a_01 = getIntent().getStringExtra("key_add_01");
            String user_a_02 = getIntent().getStringExtra("key_add_02");
            String user_email = getIntent().getStringExtra("key_e_i");
            number.setText("AADHAAR CARD NUMBER : " + user_dhr);
            ph.setText("PHONE NUMBER : " + user_ph);
            a_01.setText("UPDATED ADDRESS : " + user_a_01);
            a_02.setText("UPDATED STATE AND DISTRICT : " + user_a_02);
            email.setText("EMAIL ID : " + user_email);
            submit = findViewById(R.id.next_2);
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db = FirebaseDatabase.getInstance();
                    root = db.getReference("user");
                    String user_dhr = getIntent().getStringExtra("key_dhr");
                    String user_ph = getIntent().getStringExtra("key_ph");
                    String user_a_01 = getIntent().getStringExtra("key_add_01");
                    String user_a_02 = getIntent().getStringExtra("key_add_02");
                    String user_email = getIntent().getStringExtra("key_e_i");
                    UserHelpClass helpClass = new UserHelpClass(user_dhr,user_ph,user_email,user_a_01,user_a_02);
                    root.child(user_ph).setValue(helpClass);
                    Intent i = new Intent(ADHAR_001.this,MainActivity.class);
                    Toast.makeText(getApplicationContext(),"Successfully Submitted ! After Few Days We Will Inform You",Toast.LENGTH_LONG).show();
                    startActivity(i);
                    finish();
                }
            });
        }
    }