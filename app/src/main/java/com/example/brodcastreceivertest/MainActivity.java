package com.example.brodcastreceivertest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver myReceiver = new MyFirsReceiver();
    private LocalBroadcastManager mLocalBRManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLocalBRManager = LocalBroadcastManager.getInstance(this);
    }

    public void sendBroadcastMessage(View view){
        Intent intent = new Intent("com.example.brodcastreceivertest.ASD");
        //intent.putExtra("name", "Allah akdlka");
        //intent.putExtra("age", 10);
        sendBroadcast(intent);
    }

    public void sendNormalBroadcast(View view){
        Intent intent = new Intent(this, MySecondReceiver.class);
        intent.putExtra("a", 10);
        intent.putExtra("b", 20);
        sendBroadcast(intent);
    }

    private BroadcastReceiver resulrReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int sum = intent.getIntExtra("sum", 0);
            Toast.makeText(context, "< Sum is >" + sum, Toast.LENGTH_SHORT).show();
        }
    };

    public static class MyThirdReceiverInner extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "< 3rd Receiver >", Toast.LENGTH_SHORT).show();
        }
    }

    public void broadcastToInnerReceiver(View view){
        Intent intent = new Intent("com.example.brodcastreceivertest.ASD_2");
        sendBroadcast(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        //filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        filter.addAction("com.example.brodcastreceivertest.ASD");
        //this.registerReceiver(br, filter);
        registerReceiver(myReceiver, filter);

        IntentFilter intentFilter = new IntentFilter("my.result.intent");
        mLocalBRManager.registerReceiver(resulrReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myReceiver);

        mLocalBRManager.unregisterReceiver(resulrReceiver);
    }
}
