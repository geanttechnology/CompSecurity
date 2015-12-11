// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.notifications;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.poshmark.notifications.gcm_service.GcmIntentService;

public class PMGcmReciever extends BroadcastReceiver
{

    public PMGcmReciever()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Log.d("PM Intent", intent.getAction());
        if (intent.getAction().equals("android.intent.action.MY_PACKAGE_REPLACED"))
        {
            Log.d("PM Intent", "updating app");
        }
        context.startService(intent.setComponent(new ComponentName(context.getPackageName(), com/poshmark/notifications/gcm_service/GcmIntentService.getName())));
        setResultCode(-1);
    }
}
