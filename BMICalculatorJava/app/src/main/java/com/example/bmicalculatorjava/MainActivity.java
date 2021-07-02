package com.example.bmicalculatorjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Class variable fields
    private TextView resultTextView;
    private Button calculateButton;
    private RadioButton maleButton;
    private RadioButton femaleButton;
    private EditText ageEditText;
    private EditText feetEditText;
    private EditText inchesEditText;
    private EditText weightEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonClickListener();


    }

    private void findViews() {
        maleButton = findViewById(R.id.radio_button_male);
        femaleButton = findViewById(R.id.radio_button_female);
        ageEditText = findViewById(R.id.edi_text_age);
        feetEditText = findViewById(R.id.edit_text_feet);
        inchesEditText = findViewById(R.id.edit_text_inches);
        weightEditText = findViewById(R.id.edit_text_weight);
        calculateButton = findViewById(R.id.button_calculate);
        resultTextView = findViewById(R.id.text_view_result);
    }

    private void setupButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBmi();
            }


        });
    }

    private void calculateBmi() {
        String ageText = ageEditText.getText().toString();
        String inchesText = ageEditText.getText().toString();
        String feetText = ageEditText.getText().toString();
        String weightText = ageEditText.getText().toString();


        // Converting the number 'Strings' into 'Int' Variables
        // parseInt = Inspecting/Checking
        int age = Integer.parseInt(ageText);
        int inches = Integer.parseInt(inchesText);
        int feet = Integer.parseInt(feetText);
        int weight = Integer.parseInt(weightText);

        // Doing the calculation

        int totalInches = (feet * 12) + inches;

        // We need a double because we have decimals
        double heightInMeters = totalInches * 0.0254;

        // BMI Formula
        double bmi = weight / (heightInMeters * heightInMeters);

       String bmiTextResult =  String.valueOf(bmi);

       resultTextView.setText(bmiTextResult);
    }
}