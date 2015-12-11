// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import co.vine.android.Settings;
import co.vine.android.util.FlurryUtils;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.service:
//            GCMNotificationService

public class GCMBroadcastReceiver extends BroadcastReceiver
{

    private static final String TAG = "GCMBroadcastReceiver";

    public GCMBroadcastReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        SLog.dWithTag("GCMBroadcastReceiver", "Message received!");
        if (!Settings.isNotificationEnabled(context))
        {
            FlurryUtils.trackNotificationReceived(true);
            return;
        } else
        {
            FlurryUtils.trackNotificationReceived(false);
            Intent intent1 = new Intent(context, co/vine/android/service/GCMNotificationService);
            intent1.putExtras(intent.getExtras());
            intent1.setAction("co.vine.android.notifications.ACTION_SHOW_NOTIFICATION");
            context.startService(intent1);
            setResultCode(-1);
            return;
        }
    }
}
