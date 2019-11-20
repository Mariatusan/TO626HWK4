package com.example.to626hwk4;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextbird, editTextzipcode, editTextperson;
    Button buttonsubmit, buttonSearchPage;


    private FirebaseAuth mAuth;
    private Object View;

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

    public void submitbirdsiting(String toString, Editable text, String toString1) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Submitted!");

        Toast.makeText(this, "Submitted!", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View view) {
        if (View == buttonsubmit) {
            new SearchBird(editTextzipcode.getText().toString());
            Intent searchbirdIntent = new Intent(this, SearchBird.class);
            startActivity(searchbirdIntent);
        } else if (View == buttonSearchPage) {
            Intent searchbirdIntent = new Intent(this, SearchBird.class);
            startActivity(searchbirdIntent);
        }
    }
}







