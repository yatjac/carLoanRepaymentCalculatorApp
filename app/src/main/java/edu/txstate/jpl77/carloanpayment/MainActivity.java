package edu.txstate.jpl77.carloanpayment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText numberOfYears = findViewById(R.id.numberOfYearsTxt);
        EditText carLoanAmount = findViewById(R.id.carLoanAmountTxt);
        EditText interest = findViewById(R.id.InterestTxt);

        Button carPayment = findViewById(R.id.carPaymentBtn);
        carPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int intNumberOfYears = Integer.parseInt(numberOfYears.getText().toString());
                int intCarLoanAmount = Integer.parseInt(carLoanAmount.getText().toString());
                double dblInterestRate = Double.parseDouble(interest.getText().toString());

                //save data as preferences(cookies)
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("keyNumberOfYears", intNumberOfYears);
                editor.putInt("keyCarLoanAmount", intCarLoanAmount);
                editor.putFloat("keyInterestRate", (float) dblInterestRate);

                //make sure you commit the database change
                editor.commit();

                //switch to the second activity
                startActivity(new Intent(MainActivity.this, PaymentActivity.class));


            }
        });
    }
}