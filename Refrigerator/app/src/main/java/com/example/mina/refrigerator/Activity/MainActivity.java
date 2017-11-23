package com.example.mina.refrigerator.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.mina.refrigerator.Client.Client;
import com.example.mina.refrigerator.R;

public class MainActivity extends AppCompatActivity {

    private Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        client=new Client();
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
