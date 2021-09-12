package com.example.whatsappfilter2;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import java.text.SimpleDateFormat;
import java.util.Date;

//the user needs to manually enable the notification permission
//Settings >  Apps & Notifications > Advanced > Special app access > Notification Access

public class NotificationListener extends NotificationListenerService{
    String message_timeticker= "";
    String message_text="";
    Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        if((intro.names!=null) && (sbn.getNotification().tickerText != null) &&
                (sbn.getNotification().extras.getCharSequence(Notification.EXTRA_TEXT).toString() != null) &&
                (sbn.getPackageName().contains("com.whatsapp"))) {
            for(int i=0;i<MainActivity.names_list.size();i++){
                if(sbn.getNotification().tickerText.toString().contains(MainActivity.names_list.get(i))){
                    String sbn_time = new SimpleDateFormat("dd.MM.yyyy-HH:mm").format(new Date());
                    message_timeticker= "";
                    message_text="";
                    message_timeticker += sbn_time +" ";
                    message_timeticker += sbn.getNotification().tickerText.toString() + "\n";
                    message_text += sbn.getNotification().extras.getCharSequence(Notification.EXTRA_TEXT).toString() + "\n" + "***" +"\n";

                    //read stacked messages
                    Bundle extras = sbn.getNotification().extras;
                    CharSequence[] lines = extras.getCharSequenceArray(Notification.EXTRA_TEXT_LINES);
                    /**
                    if(lines != null && lines.length > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (CharSequence msg : lines)
                            if (!TextUtils.isEmpty(msg)) {
                                message += sbn_time + " ";
                                sb.append(msg.toString());
                                sb.append('\n');
                                sb.append("***\n");
                            }
                            message+= sb.toString().trim();
                    }
                    */

                    Intent intent = new Intent("whatsappfilter");
                    intent.putExtra("Time+Ticker", message_timeticker);
                    intent.putExtra("Text", message_text);
                    intent.putExtra("StackedText", lines);
                    sendBroadcast(intent);
                    break;
                }
            }
        }
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn){
    }
}
