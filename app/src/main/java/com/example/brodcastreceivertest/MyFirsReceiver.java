package com.example.brodcastreceivertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.widget.Toast;

public class MyFirsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //String name = intent.getStringExtra("name");
        //int age = intent.getIntExtra("age", 0);

        //Toast.makeText(context, "< 1st Receiver >", Toast.LENGTH_SHORT).show();

        if(intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            Toast.makeText(context, "< Receiver AIRPLANE >", Toast.LENGTH_SHORT).show();
        }

        if(intent.getAction().equals("com.example.brodcastreceivertest.ASD")) {
            Toast.makeText(context, "< Receiver MY RECEIVER >", Toast.LENGTH_SHORT).show();
        }

        if(intent.getAction() == WifiManager.WIFI_STATE_CHANGED_ACTION) {
            Toast.makeText(context, "< Receiver WIFI >", Toast.LENGTH_SHORT).show();
        }
    }

}
