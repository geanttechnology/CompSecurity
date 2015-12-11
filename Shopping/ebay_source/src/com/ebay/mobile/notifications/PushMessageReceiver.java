// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.ebay.nautilus.kernel.util.FwLog;

// Referenced classes of package com.ebay.mobile.notifications:
//            SharedWakeLock, PushService, DevLog

public class PushMessageReceiver extends BroadcastReceiver
{

    private static final String LOG_TAG = "PushMessageReceiver";

    public PushMessageReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Intent intent1;
        SharedWakeLock.acquireLock(context);
        Log.i("PushMessageReceiver", (new StringBuilder()).append("onReceive: action=").append(intent.getAction()).toString());
        intent1 = new Intent(context, com/ebay/mobile/notifications/PushService);
        if (!intent.getAction().equals("com.google.android.c2dm.intent.REGISTRATION")) goto _L2; else goto _L1
_L1:
        if (DevLog.logNotifications.isLoggable)
        {
            FwLog.println(DevLog.logNotifications, "PushMessageReceiver onReceive: C2DM Registration intent received");
        }
        intent1.putExtra("push_action", 2);
_L4:
        intent1.putExtras(intent);
        if (DevLog.logNotifications.isLoggable)
        {
            FwLog.println(DevLog.logNotifications, "PushMessageReceiver onReceive: Inbound intent data copied, starting PushService");
        }
        context.startService(intent1);
        return;
_L2:
        if (intent.getAction().equals("com.google.android.c2dm.intent.RECEIVE"))
        {
            if (DevLog.logNotifications.isLoggable)
            {
                FwLog.println(DevLog.logNotifications, "PushMessageReceiver onReceive: C2DM message received");
            }
            intent1.putExtra("push_action", 3);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
