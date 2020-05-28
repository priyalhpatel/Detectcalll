package com.example.detectcall;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class Missedcall extends BroadcastReceiver
{
    static boolean ring=false;
    static boolean callReceived=false;

    @Override
    public void onReceive(Context mContext, Intent intent) {

        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

        if (state == null)
            return;

        String callerPhoneNumber ;
        if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            ring = true;
            // Get the Caller's Phone Number
            Bundle bundle = intent.getExtras();
            callerPhoneNumber = bundle.getString("incoming_number");
        }

        if (state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {

            callReceived = true;

        }

        if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
            if (ring == true && callReceived == false) {
                Toast.makeText(mContext, "It was A MISSED CALL : " ,Toast.LENGTH_LONG).show();
            }
        }

    }}