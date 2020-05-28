package com.example.detectcall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

class OutgoingCallReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        String phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);

        Log.d(OutgoingCallReceiver.class.getSimpleName(), intent.toString());
        Toast.makeText(context, "Outgoing call catched!", Toast.LENGTH_LONG).show();
    }
}