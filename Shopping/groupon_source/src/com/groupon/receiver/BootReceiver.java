// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.receiver;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.groupon.service.GCMNotificationService;
import com.groupon.util.GoogleNowAuthAlarmUtil;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public class BootReceiver extends WakefulBroadcastReceiver
{

    public BootReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        startWakefulService(context, (new Intent(context, com/groupon/service/GCMNotificationService)).setAction("com.groupon.REGISTER"));
        ((GoogleNowAuthAlarmUtil)RoboGuice.getInjector(context).getInstance(com/groupon/util/GoogleNowAuthAlarmUtil)).setUpAlarmIfNotSet();
    }
}
