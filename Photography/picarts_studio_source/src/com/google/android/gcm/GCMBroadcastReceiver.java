// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.socialin.android.photo.notifications.NotificationsService;

public class GCMBroadcastReceiver extends BroadcastReceiver
{

    public GCMBroadcastReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if ("gcm".equals(GoogleCloudMessaging.getInstance(context).getMessageType(intent)))
        {
            Intent intent1 = new Intent(context, com/socialin/android/photo/notifications/NotificationsService);
            intent1.setAction("action.gcm.message");
            intent1.putExtra("extra.message", intent.getStringExtra("data"));
            context.startService(intent1);
            (new StringBuilder("received intent:")).append(intent);
        }
        setResultCode(-1);
    }
}
