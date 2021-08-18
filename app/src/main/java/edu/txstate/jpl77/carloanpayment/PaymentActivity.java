package edu.txstate.jpl77.carloanpayment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class PaymentActivity extends AppCompatActivity {
    int intCarLoanAmount;
    int intNumberOfYears;
    double dblInterest;
    double dblMonthlyPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        TextView carLoanAmountDisplay = findViewById(R.id.carLoanAmountReturnTxt);
        TextView monthlyPayment = findViewById(R.id.monthlyPaymentReturnTxt);


        //Retrieve data preferences(cookies)
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(PaymentActivity.this);

        intNumberOfYears = pref.getInt("keyNumberOfYears", 0);
        intCarLoanAmount = pref.getInt("keyCarLoanAmount", 0);
        dblInterest = pref.getFloat("keyInterestRate", 0);

       dblMonthlyPayment =  (intCarLoanAmount *(1+(dblInterest * intNumberOfYears)))/(12*intNumberOfYears);
        DecimalFormat df = new DecimalFormat("$###,###.##");

        carLoanAmountDisplay.setText(df.format(intCarLoanAmount));
        monthlyPayment.setText(df.format(dblMonthlyPayment));



    }
}