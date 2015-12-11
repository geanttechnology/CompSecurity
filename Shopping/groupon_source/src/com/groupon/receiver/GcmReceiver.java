// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.receiver;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.groupon.service.GCMNotificationService;
import roboguice.util.Ln;

public class GcmReceiver extends WakefulBroadcastReceiver
{

    public GcmReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Ln.d("GCM_Notification: Received intent: %s", new Object[] {
            intent.toString()
        });
        startWakefulService(context, (new Intent(intent)).setClass(context, com/groupon/service/GCMNotificationService));
    }
}
