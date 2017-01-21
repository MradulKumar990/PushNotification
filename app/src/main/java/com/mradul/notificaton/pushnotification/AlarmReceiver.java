package com.mradul.notificaton.pushnotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by shekhar on 1/18/17.
 */

public class AlarmReceiver extends BroadcastReceiver {


  @Override
  public void onReceive(Context context, Intent dataIntent) {
    String message = "Alarm Triggered and broadcast received";

    Log.e(">>" + getClass().getSimpleName(), message);
    Toast.makeText(context, message, Toast.LENGTH_LONG).show();

    Intent intent = new Intent(context, MainActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


    PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent,
        PendingIntent.FLAG_CANCEL_CURRENT);

    Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
    NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
        .setSmallIcon(R.mipmap.ic_launcher)
        .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
        .setContentTitle("Title")
        .setContentText("Random message will be shown here")
        .setAutoCancel(true)
        .setSound(defaultSoundUri)
        .setPriority(android.app.Notification.PRIORITY_MAX)
        .setContentIntent(pendingIntent);


    NotificationManager notificationManager =
        (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

    Calendar idCal = Calendar.getInstance();

    notificationManager.notify((int) idCal.getTimeInMillis()/* ID of notification */, notificationBuilder.build());

    Long timeStamp = context.getSharedPreferences("MyPreference", Context.MODE_PRIVATE).getLong("TIME", -1);
    if (timeStamp > 1111) {
      Calendar calendar = Calendar.getInstance();
      calendar.setTimeInMillis(timeStamp);
      calendar.add(Calendar.SECOND, MainActivity.DIFFERENCE);
      MainActivity.scheduleAlarm(context, calendar);
    }
  }

}
