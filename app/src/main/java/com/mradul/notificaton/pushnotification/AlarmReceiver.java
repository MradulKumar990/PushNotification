package com.mradul.notificaton.pushnotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by shekhar on 1/18/17.
 */

public class AlarmReceiver extends BroadcastReceiver {


  @Override
  public void onReceive(Context context, Intent intent) {
    String message = "Alarm Triggered and broadcast received";

    Log.e(">>" + getClass().getSimpleName(), message);

    Toast.makeText(context, message, Toast.LENGTH_LONG).show();
  }

}
