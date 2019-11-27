package com.example.to626hwk4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SearchBird extends AppCompatActivity implements View.OnClickListener {
    EditText editTextSearchZipCode;
    TextView textViewFoundName;
    Button buttonsearch, buttonReportPage;

    private FirebaseAuth mAuth;
  //  private Object View;

  //  public SearchBird(String toString) {
   // }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchbird);

        editTextSearchZipCode = findViewById(R.id.editTextSearchZipCode);
        textViewFoundName = findViewById(R.id.textViewFoundName);
        buttonsearch = findViewById(R.id.buttonsearch);
        buttonReportPage = findViewById(R.id.buttonReportPage);

        buttonsearch.setOnClickListener(this);
        buttonReportPage.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View view) {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Bird");
        if (view == buttonsearch) {
            String findBird = editTextSearchZipCode.getText().toString(); //how do we get the integer?

            myRef.orderByChild("zipcode").equalTo(findBird).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    //String findKey = dataSnapshot.getKey();
                    Bird foundBird = dataSnapshot.getValue(Bird.class);
                    String findBird = foundBird.birdname;
//I want the bird for which the zipcode matched to display in the textViewFoundName
                   // editTextSearchZipCode.setText(findBird);
                    textViewFoundName.setText(findBird);

                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        } else if (view == buttonsearch) {
            Intent searchbirdIntent = new Intent(this, SearchBird.class);
            startActivity(searchbirdIntent);
        }
    }
}






