package com.example.mina.refrigerator.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mina.refrigerator.Client.Client;
import com.example.mina.refrigerator.R;

public class Temperature extends AppCompatActivity {

    private int curTemp;
    private Client client;
    private static TextView curTempText;
    private TextView settingTempText;
    private EditText tempEdit;
    private Button up;
    private Button down;
    private Button enter;

    public static void setCurTempText(String text){ curTempText.setText(text);}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        client=Client.getInstance();

        settingTempText=(TextView)findViewById(R.id.settingTemp);
        curTempText=(TextView)findViewById(R.id.currentTempText);

        up=(Button)findViewById(R.id.upButton);
        down=(Button)findViewById(R.id.downButton);
        enter=(Button)findViewById(R.id.enter);

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curTemp++;
                tempEdit.setText(curTemp+"");
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curTemp--;
                tempEdit.setText(curTemp+"");
            }
        });
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client.sendToServer("changeTemp%"+curTemp);
                settingTempText.setText("현재 설정 온도: "+curTemp);
            }
        });

        client.sendToServer("getTemp");
    }

}
