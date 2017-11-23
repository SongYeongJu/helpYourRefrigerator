package com.example.mina.refrigerator.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mina.refrigerator.Client.Client;
import com.example.mina.refrigerator.R;

public class ChangeMode extends AppCompatActivity {

    private Client client;

    public static final int cosT=1111;
    public static final int drinkT=2222;
    public static final int iceT=3333;
    public static final int dietT=4444;

    private Button cos;
    private Button diet;
    private Button drink;
    private Button ice;
    private static TextView modeText;

    public static void setModeText(int mode){
        switch (mode) {
            case cosT:
                modeText.setText("화장품 모드 사용중..");
                break;
            case dietT:
                modeText.setText("다이어트 모드 사용중..");
                break;
            case drinkT:
                modeText.setText("음료 모드 사용중..");
                break;
            case iceT:
                modeText.setText("냉동 모드 사용중..");
                break;
            default:
                modeText.setText("모드를 선택해 주세요.");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        client.sendToServer("getMode");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_mode);

        client=Client.getInstance();

        modeText=(TextView)findViewById(R.id.modeText);

        cos=(Button)findViewById(R.id.cos_mode);
        diet=(Button)findViewById(R.id.diet_mode);
        drink=(Button)findViewById(R.id.drink_mode);
        ice=(Button)findViewById(R.id.freeze_mode);

        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client.sendToServer("changeMode%"+cosT);
                setModeText(cosT);
            }
        });
        diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client.sendToServer("changeMode%"+dietT);
                setModeText(dietT);
            }
        });
        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client.sendToServer("changeMode%"+drinkT);
                setModeText(drinkT);
            }
        });
        ice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client.sendToServer("changeMode%"+iceT);
                setModeText(iceT);
            }
        });
    }
}
