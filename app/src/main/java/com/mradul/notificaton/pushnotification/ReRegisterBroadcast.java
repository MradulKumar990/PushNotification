package com.mradul.notificaton.pushnotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by shekhar on 1/21/17.
 */

public class ReRegisterBroadcast extends BroadcastReceiver {
  @Override
  public void onReceive(Context context, Intent intent) {
    Log.e(">>Service Stops", "Ohhhhhhh");
    context.startService(new Intent(context, MyService.class));

    Long timeStamp = context.getSharedPreferences("MyPreference", Context.MODE_PRIVATE).getLong("TIME", -1);
    if (timeStamp > 1111) {
      Calendar calendar = Calendar.getInstance();
      calendar.setTimeInMillis(timeStamp);
      MainActivity.scheduleAlarm(context, calendar);
    }
  }
}
