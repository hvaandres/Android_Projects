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

        Details[] company = {

                new Details("Website", "This is the main website", "https://saludyfigura.mx"),
                new Details("Telephone Number: (33)551524512", "This is the best way to get in contact with us", "https://saludyfigura.mx/whatsup"),
                new Details("Let's chat through here", "Slack is a communication app", "https://saludyfigura.slack.com")



        };


        ArrayAdapter<Details> companyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, company);

        startersList.setAdapter(companyAdapter);


    }
}