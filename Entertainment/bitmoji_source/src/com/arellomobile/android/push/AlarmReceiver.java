// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.arellomobile.android.push.utils.GeneralUtils;
import java.util.Calendar;

// Referenced classes of package com.arellomobile.android.push:
//            PushAmazonIntentService, PushServiceHelper, PushGCMIntentService

public class AlarmReceiver extends BroadcastReceiver
{

    private static final int MAX_ALARMS = 10;
    private static int counter = 0;

    public AlarmReceiver()
    {
    }

    public static void clearAlarm(Context context)
    {
        for (int i = 0; i < 10; i++)
        {
            PendingIntent pendingintent = PendingIntent.getBroadcast(context, i, new Intent(context, com/arellomobile/android/push/AlarmReceiver), 0x8000000);
            ((AlarmManager)context.getSystemService("alarm")).cancel(pendingintent);
        }

    }

    public static void setAlarm(Context context, String s, Bundle bundle, int i)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(13, i);
        Intent intent = new Intent(context, com/arellomobile/android/push/AlarmReceiver);
        intent.putExtra("title", s);
        intent.putExtra("local", true);
        if (bundle != null)
        {
            intent.putExtras(bundle);
        }
        i = counter;
        counter = i + 1;
        s = PendingIntent.getBroadcast(context, i, intent, 0x8000000);
        if (counter == 10)
        {
            counter = 0;
        }
        ((AlarmManager)context.getSystemService("alarm")).set(0, calendar.getTimeInMillis(), s);
    }

    public void onReceive(Context context, Intent intent)
    {
        Intent intent1;
        if (GeneralUtils.isAmazonDevice())
        {
            intent1 = new Intent(context, com/arellomobile/android/push/PushAmazonIntentService);
            intent1.setAction("com.amazon.device.messaging.intent.RECEIVE");
        } else
        {
            try
            {
                intent1 = new Intent(context, Class.forName(PushServiceHelper.getPushServiceClassName(context)));
            }
            catch (ClassNotFoundException classnotfoundexception)
            {
                classnotfoundexception = new Intent(context, com/arellomobile/android/push/PushGCMIntentService);
            }
            intent1.setAction("com.google.android.c2dm.intent.RECEIVE");
        }
        intent1.putExtras(intent.getExtras());
        context.startService(intent1);
    }

}
