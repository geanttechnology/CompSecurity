// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ebay.mobile.ServiceStarter;
import com.ebay.mobile.mftd.MftdService;
import com.ebay.mobile.service.GoogleNowAuthenticationService;
import com.ebay.nautilus.kernel.util.FwLog;

// Referenced classes of package com.ebay.mobile.notifications:
//            DevLog, SharedWakeLock

public class DeviceStartupReceiver extends BroadcastReceiver
{

    private static final String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
    static int cnt = 0;

    public DeviceStartupReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        intent = intent.getAction();
        if (DevLog.logNotifications.isLoggable)
        {
            FwLog.println(DevLog.logNotifications, (new StringBuilder()).append("DeviceStartupReceiver onReceive, intent action=").append(intent).toString());
        }
        int i = cnt;
        cnt = i + 1;
        if (i > 1 && intent.equals("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE"))
        {
            return;
        }
        SharedWakeLock.acquireLock(context);
        if (DevLog.logNotifications.isLoggable)
        {
            FwLog.println(DevLog.logNotifications, "starting MftdService");
        }
        intent = new Intent(context, com/ebay/mobile/mftd/MftdService);
        intent.setAction("com.ebay.mobile.service.START_MFTD");
        context.startService(intent);
        GoogleNowAuthenticationService.start(context);
        ServiceStarter.startNotificationManagerService(context, true);
    }

}
