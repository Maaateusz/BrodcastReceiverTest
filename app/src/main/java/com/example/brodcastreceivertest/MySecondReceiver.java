package com.example.brodcastreceivertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MySecondReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "< 2nd Receiver >", Toast.LENGTH_SHORT).show();

        //Local receiver
        int a = intent.getIntExtra("a", 0);
        int b = intent.getIntExtra("b", 0);
        int sum = a+b;

        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
        Intent returningIntent = new Intent("my.result.intent");
        returningIntent.putExtra("sum", sum);

        localBroadcastManager.sendBroadcast(returningIntent);


    }
}
