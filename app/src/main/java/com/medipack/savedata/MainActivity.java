package com.medipack.savedata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    private EditText Name,Email;
    private Button sign;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.editTextname);
        Email = findViewById(R.id.editTextemail);
        sign = findViewById(R.id.buttonsignup);

        // init database

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");


        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                register();

            }
        });

    }

    public void register()
    {

        String name= Name.getText().toString().trim();
        String email= Email.getText().toString().trim();

        User user = new User(name,email);

        databaseReference.setValue(user);

    }
}
