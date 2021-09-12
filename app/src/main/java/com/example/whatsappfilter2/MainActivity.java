package com.example.whatsappfilter2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    static List<String> names_list;
    private myBroadcastReceiver br;
    String names="See messages from: ";
    String receivedNotificationCode = "";
    String receivedNotificationCode1= "";
    String newText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.editText);
        tv.setMovementMethod(new ScrollingMovementMethod());

        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            names  += extras.getString("names");
            names_list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(extras.getString("names"),",");
            while (st.hasMoreTokens()) {
                String temp = st.nextToken();
                names_list.add(temp);
            }
        }

        tv.setText(names+"\n"+"---------------"+"\n");

        br = new myBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("whatsappfilter");
        registerReceiver(br,intentFilter);
    }

    public class myBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            receivedNotificationCode = "";
            receivedNotificationCode1= "";
            newText = "";
            receivedNotificationCode = intent.getStringExtra("Time+Ticker");
            receivedNotificationCode1 = intent.getStringExtra("Text");
            CharSequence[] receivedNotificationCode2 = intent.getCharSequenceArrayExtra("StackedText");
            newText = receivedNotificationCode+receivedNotificationCode1+ "\n ***"
                    + stackedText(receivedNotificationCode2)+ "\n";
            tv.append(newText);
        }
    }

    public String stackedText(CharSequence[] stackedtext){
        String text="";
        if(stackedtext!=null) {
            for (CharSequence cs : stackedtext) {
                for(String str: names_list){
                    if(cs.toString().contains(str)){
                        text += "\n" + cs.toString() + "\n ***";
                    }
                }
            }
        }

        return text;
    }
}
