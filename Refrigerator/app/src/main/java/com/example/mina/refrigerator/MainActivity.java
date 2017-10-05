package com.example.mina.refrigerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClickButton(View v){
        int id=v.getId();
        Intent intent1;
        switch (id){
            case R.id.foodlist:
                intent1=new Intent(MainActivity.this, FoodList.class);
                startActivity(intent1);
                break;
            case R.id.camera:
                intent1=new Intent(MainActivity.this, FridgePicture.class);
                startActivity(intent1);
                break;
            case R.id.temperature:
                intent1=new Intent(MainActivity.this, Temperature.class);
                startActivity(intent1);
                break;
            case R.id.changemode:
                intent1=new Intent(MainActivity.this, ChangeMode.class);
                startActivity(intent1);
                break;
        }
    }
}
