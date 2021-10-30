package com.example.adhar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText ADR,PH,ADDRESS_01,ADDRESS_02,EMAIL_ID;
    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ADR = findViewById(R.id.ADR_NO);
        PH = findViewById(R.id.PH_NO);
        next = findViewById(R.id.next_button);
        ADDRESS_01 = findViewById(R.id.editTextTextPostalAddress2);
        ADDRESS_02 = findViewById(R.id.editTextTextPostalAddress_1);
        EMAIL_ID = findViewById(R.id.editTextTextEmailAddress);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String adhar_number = ADR.getText().toString();
                String phone_number = PH.getText().toString();
                String address_1 = ADDRESS_01.getText().toString();
                String address_2 = ADDRESS_02.getText().toString();
                String email_id = EMAIL_ID.getText().toString();
                if (adhar_number.length() == 12){
                    if(phone_number.length() == 10) {
                        if(!address_1.isEmpty()) {
                            if(!address_2.isEmpty()) {
                                if(!email_id.isEmpty()) {
                                    Intent intent = new Intent(MainActivity.this, ADHAR_001.class);
                                    intent.putExtra("key_dhr", adhar_number);
                                    intent.putExtra("key_ph", phone_number);
                                    intent.putExtra("key_add_01", address_1);
                                    intent.putExtra("key_add_02", address_2);
                                    intent.putExtra("key_e_i", email_id);
                                    startActivity(intent);
                                }
                                else {
                                    Toast.makeText(getApplicationContext(),"enter email address",Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"enter district and state",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"enter address",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"enter phone number",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"enter adhar number",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}