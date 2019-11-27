package com.example.to626hwk4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextbird, editTextzipcode, editTextperson;
    Button buttonsubmit, buttonSearchPage;

    private FirebaseAuth mAuth;
    //private Object View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextbird = findViewById(R.id.editTextbird);
        editTextzipcode = findViewById(R.id.editTextzipcode);
        editTextperson = findViewById(R.id.editTextperson);
        buttonsubmit = findViewById(R.id.buttonsubmit);
        buttonSearchPage = findViewById(R.id.buttonReportPage);

        buttonsubmit.setOnClickListener(this);
        buttonSearchPage.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View view) {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Bird");

        if (view == buttonsubmit) {
            String createBird = editTextbird.getText().toString();
            String createPerson = editTextperson.getText().toString();
            String createZipcode = editTextzipcode.getText().toString();

            Bird createnewBird = new Bird(createBird, createPerson, createZipcode);
            //now that the Bird has been created, we need to push it into firebase

            myRef.push().setValue(createnewBird);

        } else if (view == buttonSearchPage) {
            Intent searchbirdIntent = new Intent(this, SearchBird.class);
            startActivity(searchbirdIntent);
        }
    }

}







