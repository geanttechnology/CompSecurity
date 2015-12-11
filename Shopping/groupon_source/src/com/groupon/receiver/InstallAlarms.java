// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.receiver:
//            DailySyncReceiver

public class InstallAlarms extends BroadcastReceiver
{

    private static int INSTALL_ALARMS_REQUEST_CODE = 0;
    private static int INSTALL_EXCEPTION_ALARMS_REQUEST_CODE = 0;
    private static final int ONE_DAY_IN_MS = 0x5265c00;
    private static final int RETRIES_ON_EXCEPTIONS = 10;

    public InstallAlarms()
    {
    }

    public static int getRetryCount(Intent intent)
    {
        return intent.getIntExtra("request_retries", 10);
    }

    public static void install(Context context)
    {
        if (!isAlarmSet(context))
        {
            AlarmManager alarmmanager = (AlarmManager)context.getSystemService("alarm");
            Random random = new Random();
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, random.nextInt(4) + 2);
            calendar.set(12, random.nextInt(60));
            if (calendar.getTime().before(new Date()))
            {
                calendar.add(7, 1);
            }
            Ln.i("Will schedule %s for %s", new Object[] {
                com/groupon/receiver/DailySyncReceiver.getSimpleName(), calendar.getTime()
            });
            alarmmanager.setRepeating(0, calendar.getTimeInMillis(), 0x5265c00L, PendingIntent.getBroadcast(context, INSTALL_ALARMS_REQUEST_CODE, new Intent(context, com/groupon/receiver/DailySyncReceiver), 0x8000000));
        }
    }

    public static boolean installWhenException(Context context, Intent intent)
    {
        int i = intent.getIntExtra("request_retries", 10) - 1;
        if (i >= 0)
        {
            intent = Calendar.getInstance();
            intent.add(11, 1);
            ((AlarmManager)context.getSystemService("alarm")).set(0, intent.getTimeInMillis(), PendingIntent.getBroadcast(context, INSTALL_EXCEPTION_ALARMS_REQUEST_CODE, (new Intent(context, com/groupon/receiver/DailySyncReceiver)).putExtra("request_retries", i), 0x8000000));
            return true;
        } else
        {
            return false;
        }
    }

    public static boolean isAlarmSet(Context context)
    {
        Intent intent = new Intent(context, com/groupon/receiver/DailySyncReceiver);
        return PendingIntent.getBroadcast(context, INSTALL_ALARMS_REQUEST_CODE, intent, 0x20000000) != null;
    }

    public static boolean isRetryIntent(Intent intent)
    {
        return intent.hasExtra("request_retries");
    }

    public void onReceive(Context context, Intent intent)
    {
        install(context);
    }

    static 
    {
        INSTALL_ALARMS_REQUEST_CODE = 200;
        INSTALL_EXCEPTION_ALARMS_REQUEST_CODE = 201;
    }
}
