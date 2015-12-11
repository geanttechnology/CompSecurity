// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.blueassist;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.bestbuy.android.activities.blueassist:
//            BlueAssistReminderService

public class BlueAssistReminderBroadcast extends BroadcastReceiver
{

    public BlueAssistReminderBroadcast()
    {
    }

    private void a(Context context, Intent intent)
    {
        PendingIntent.getService(context, 0, new Intent(context, com/bestbuy/android/activities/blueassist/BlueAssistReminderService), 0x10000000);
        context = (AlarmManager)context.getApplicationContext().getSystemService("alarm");
    }

    public void onReceive(Context context, Intent intent)
    {
        a(context, intent);
    }
}
