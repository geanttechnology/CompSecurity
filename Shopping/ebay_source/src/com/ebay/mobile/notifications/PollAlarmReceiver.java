// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.kernel.util.FwLog;

// Referenced classes of package com.ebay.mobile.notifications:
//            DevLog, SharedWakeLock, PollService

public class PollAlarmReceiver extends BroadcastReceiver
{

    public PollAlarmReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if (!MyApp.getPrefs().isSignedIn())
        {
            if (DevLog.logNotifications.isLoggable)
            {
                FwLog.println(DevLog.logNotifications, "PollAlarmReceiver onReceive, no authenticated user, returning");
            }
            return;
        }
        SharedWakeLock.acquireLock(context);
        if (DevLog.logNotifications.isLoggable)
        {
            FwLog.println(DevLog.logNotifications, "PollAlarmReceiver onReceive, starting PollService");
        }
        Intent intent1 = new Intent(context, com/ebay/mobile/notifications/PollService);
        intent = intent.getAction();
        if (DevLog.logNotifications.isLoggable)
        {
            FwLog.println(DevLog.logNotifications, (new StringBuilder()).append("PollAlarmReceiver onReceive, action = ").append(intent).toString());
        }
        intent1.setAction(intent);
        context.startService(intent1);
    }
}
