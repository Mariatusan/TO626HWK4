package com.example.to626hwk4;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SearchBird extends AppCompatActivity implements View.OnClickListener {
    EditText editTextzipcode;
    Button buttonsearch, buttonReportPage;
    private Object View;

    public SearchBird(String toString) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchbird);

        editTextzipcode = findViewById(R.id.editTextzipcode);
        buttonsearch = findViewById(R.id.buttonsearch);
        buttonReportPage = findViewById(R.id.buttonReportPage);
        buttonsearch.setOnClickListener(this);
        buttonReportPage.setOnClickListener(this);

    }
    
    @Override
    public void onClick(android.view.View view) {
        if (view == buttonsearch) {
            Intent mainactivityIntent = new Intent(this, MainActivity.class);
            startActivity(mainactivityIntent);
        }else if (view==buttonReportPage){
            Intent mainactivityIntent = new Intent(this, MainActivity.class);
            startActivity(mainactivityIntent);

        }
    }
}






