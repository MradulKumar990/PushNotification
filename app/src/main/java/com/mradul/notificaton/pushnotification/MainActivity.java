package com.mradul.notificaton.pushnotification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

  protected static int DIFFERENCE = 25;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.SECOND, DIFFERENCE);

    scheduleAlarm(this, calendar);

    Intent service = new Intent(getApplicationContext(), MyService.class);
    getApplicationContext().startService(service);
  }




  public static void scheduleAlarm(Context context, Calendar calendar) {


    context.getSharedPreferences("MyPreference", Context.MODE_PRIVATE).edit().putLong("TIME", calendar.getTimeInMillis()).apply();

    Intent intentAlarm = new Intent(context, AlarmReceiver.class);

    AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
        PendingIntent.getBroadcast(context, 1, intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT));

    String message = "Alarm Scheduled at " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE);
    Log.e(">>" + context.getClass().getSimpleName(), message);
    Toast.makeText(context, message, Toast.LENGTH_LONG).show();
  }

}
