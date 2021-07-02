package com.example.bmicalculatorjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

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
                double bmiResult = calculateBmi();

                String ageText = ageEditText.getText().toString();
                int age = Integer.parseInt(ageText);

                if (age >= 18) {
                    displayResult(bmiResult);
                } else {
                    displayGuidance(bmiResult);
                }

            }

        });
    }



    private double calculateBmi() {

        String inchesText = ageEditText.getText().toString();
        String feetText = ageEditText.getText().toString();
        String weightText = ageEditText.getText().toString();


        // Converting the number 'Strings' into 'Int' Variables
        // parseInt = Inspecting/Checking
        int inches = Integer.parseInt(inchesText);
        int feet = Integer.parseInt(feetText);
        int weight = Integer.parseInt(weightText);

        // Doing the calculation

        int totalInches = (feet * 12) + inches;

        // We need a double because we have decimals
        double heightInMeters = totalInches * 0.0254;

        // BMI Formula
        return weight / (heightInMeters * heightInMeters);

    }

    private void displayResult(double bmi) {
        // Add only two decimals
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);

        String fullResultString;

        if (bmi < 18.5) {
            // Display Underweight
            fullResultString = bmiTextResult + " - You're underweight, you can eat some tacos";
        } else if (bmi > 25) {
            // Display Overweight
            fullResultString = bmiTextResult + " - You've to stop eating, before you look like homer";
        } else {
            // Display healthy
            fullResultString = bmiTextResult + " - You're healthy, why? I don't know";
        }


        resultTextView.setText(fullResultString);
    }

    private void displayGuidance(double bmi) {


        // Add only two decimals
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);

        String fullResultString;
        if(maleButton.isChecked()) {

            // Display boy guidance
            fullResultString = bmiTextResult + " - We can't help you! You're to young, please ask your doctor.";
        } else if (femaleButton.isChecked()) {
            // Display female guidance
            fullResultString = bmiTextResult + " - We can't help you! You're to young, please ask your doctor.";
        } else {
            // Display general guidance
            fullResultString = bmiTextResult + " - You're healthy. How? I don't know!";
        }

    }
}