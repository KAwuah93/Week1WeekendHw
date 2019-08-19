package com.example.week1weekendhw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class emiCalc extends AppCompatActivity {

    //format double
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    //bind all the bars and text views
    private TextView loanLabel;
    private TextView intRateLabel;
    private TextView loanTenLabel;
    private TextView totalDueLabel;
    private TextView monthlyPaymentlabel;
    private TextView monthlyInterestPayments;

    private SeekBar loanSlider;
    private SeekBar rateSlider;
    private SeekBar tenSlider;

    //The math bodies for the calcs
    private double totalDue;
    private double totalInterest;
    private double monthlyPayments;

    private double Principle;
    private double interestRate;
    private double monthTenure;
    //privte

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emi_calc);
        //Binding for the UI elements
        loanLabel = findViewById(R.id.loanAmt);
        intRateLabel = findViewById(R.id.intRate);
        loanTenLabel = findViewById(R.id.loanTen);
        totalDueLabel = findViewById(R.id.totalAmount);
        monthlyPaymentlabel = findViewById(R.id.mPaymentsLabel);
        monthlyInterestPayments = findViewById(R.id.mInterestPaymentLabel);

        loanSlider = findViewById(R.id.loanBr);
        rateSlider = findViewById(R.id.intBar);
        tenSlider = findViewById(R.id.tenBar);





        //set up on change listener for the seekbars
        loanSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //Where we display/push the changes that we've come into

                loanLabel.setText("$"+i);
                Principle = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                //This is where the universal calc function would go, to be called with the other sliders
                calc();

            }
        });

        rateSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //Where we display/push the changes that we've come into
                intRateLabel.setText(df2.format( i )+"%" );
                interestRate = i/100.0;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                //This is where the universal calc function would go, to be called with the other sliders
                calc();

            }
        });

        tenSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //Where we display/push the changes that we've come into
                loanTenLabel.setText(i+" months");
                monthTenure = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                //This is where the universal calc function would go, to be called with the other sliders
                calc();

            }
        });


    }

    public void calc(){
        double tempInt;
        tempInt = interestRate / 12;
        monthlyPayments =(Principle * tempInt * Math.pow((1 + tempInt),(monthTenure))) / (Math.pow((1 + tempInt),monthTenure)-1);
        totalDue = monthlyPayments * monthTenure;

        totalDueLabel.setText("$"+df2.format(totalDue));
        monthlyPaymentlabel.setText("$"+df2.format(monthlyPayments));
        monthlyInterestPayments.setText(df2.format(tempInt*100));


        //set to views



//                  EMI = [P x R x (1+R)^N]/[(1+R)^N-1]
//
//                  P = Principal
//                  R = interest rate per month
//                  N = number of monthly installment

    }

}
