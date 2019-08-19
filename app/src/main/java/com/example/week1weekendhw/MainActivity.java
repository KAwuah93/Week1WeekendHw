package com.example.week1weekendhw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void swap(View view){
        Intent swap;

        switch(view.getId()){
            case R.id.camBtn:
                swap = new Intent(this, camActivity.class);
                startActivity(swap);
                break;
            case R.id.emiCalc:
                swap = new Intent(this,emiCalc.class);
                startActivity(swap);
                break;
            case R.id.webView:
                swap = new Intent(this, webViewActivity.class);
                startActivity(swap);
                break;
            case R.id.musicPlayer:
                swap = new Intent(this, mediaPlayer.class);
                startActivity(swap);
                break;
        }
    }
}
