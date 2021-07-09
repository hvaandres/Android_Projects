package com.example.saludyfigura;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class StarterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);

        ListView startersList = findViewById(R.id.list_view_starters);

        String[] company = {
                "Website",
                "Whatsap",
                "Slack",
                "Appointments",
        };

        ArrayAdapter<String> companyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, company);

        startersList.setAdapter(companyAdapter);





    }
}