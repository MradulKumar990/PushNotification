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

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    scheduleAlarm();
  }

  public void scheduleAlarm() {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.MINUTE, 1);

    Intent intentAlarm = new Intent(this, AlarmReceiver.class);

    AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), PendingIntent.getBroadcast(this, 1, intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT));

    String message = "Alarm Scheduled at " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE);
    Log.e(">>" + getClass().getSimpleName(), message);
    Toast.makeText(this, message, Toast.LENGTH_LONG).show();
  }

}
