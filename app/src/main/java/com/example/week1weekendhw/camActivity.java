package com.example.week1weekendhw;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class camActivity extends AppCompatActivity {
    //Creating the variables for the views that we will need to use
    private ImageView imgView;
    private static final int REQUEST_IMG_CAPTURE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //binding the views
        //bound to floating action button (fab)
        imgView = findViewById(R.id.imgView);
    }

    public void takePicture(View view) {
        Log.d("PIC", "takePicture: ");
        //create new intent
        Intent takeImg = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //check to see if there is anything to help you resolve
        if(takeImg.resolveActivity(getPackageManager()) != null){
            startActivityForResult(takeImg,REQUEST_IMG_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //check if the request we are getting is OUR request
        if(requestCode == REQUEST_IMG_CAPTURE && resultCode == RESULT_OK){
            //create the bundle for the Activity results
            Bundle extras = data.getExtras();
            Bitmap imgBitMap = (Bitmap)extras.get("data");
            imgView.setImageBitmap(imgBitMap);
        }
    }
}
