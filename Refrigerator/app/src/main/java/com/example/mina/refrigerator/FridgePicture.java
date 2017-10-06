package com.example.mina.refrigerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FridgePicture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fridge_picture);
    }

    public void OnClickButton(View v){
        finish();
    }
}
