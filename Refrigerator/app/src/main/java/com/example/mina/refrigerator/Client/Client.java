package com.example.mina.refrigerator.Client;

/**
 * Created by YoungJu on 2017-11-21.
 */

import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;

import com.example.mina.refrigerator.Activity.ChangeMode;
import com.example.mina.refrigerator.Activity.Temperature;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private static Client client;
    private String content;

    //  TCP연결 관련
    private Socket clientSocket;
    private BufferedReader socketIn;
    private PrintWriter socketOut;
    private int port = 7777;
    private String ip = "20.20.2.153";
    private MyHandler myHandler;
    private MyThread myThread;

    public String getContent(){ return content; }
    public static Client getInstance() { return client;}
    public Client(){
        client=this;
        connect_to_server();
    }

    public void connect_to_server(){
        // StrictMode는 개발자가 실수하는 것을 감지하고 해결할 수 있도록 돕는 일종의 개발 툴
        // - 메인 스레드에서 디스크 접근, 네트워크 접근 등 비효율적 작업을 하려는 것을 감지하여
        //   프로그램이 부드럽게 작동하도록 돕고 빠른 응답을 갖도록 함, 즉  Android Not Responding 방지에 도움
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            clientSocket = new Socket(ip, port);
            socketIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            socketOut = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        myHandler = new MyHandler();
        myThread = new MyThread();
        myThread.start();

    }

    public void sendToServer(String command) {
        socketOut.println(command);
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    // InputStream의 값을 읽어와서 data에 저장
                    String data = socketIn.readLine();
                    // Message 객체를 생성, 핸들러에 정보를 보낼 땐 이 메세지 객체를 이용
                    Message msg = myHandler.obtainMessage();
                    msg.obj = data;
                    myHandler.sendMessage(msg);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            content=msg.obj.toString();
            String[] contents=content.split("%");
            if(contents[0].equals("returnTemp")){
                Temperature.setCurTempText("현재 온도:"+contents[1]);
            }
            if(contents.equals("returnMode")) {
                ChangeMode.setModeText(Integer.parseInt(contents[1]));
            }
            //tv.setText(msg.obj.toString());
        }
    }
}