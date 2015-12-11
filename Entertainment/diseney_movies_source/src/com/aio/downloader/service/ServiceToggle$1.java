// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

// Referenced classes of package com.aio.downloader.service:
//            ServiceToggle

class this._cls0 extends BroadcastReceiver
{

    final ServiceToggle this$0;

    public void onReceive(Context context, Intent intent)
    {
        Log.e("toggletag", "toggle_on");
        if (intent.getAction().equals("toggle_on"))
        {
            ServiceToggle.access$0(ServiceToggle.this, (NotificationManager)getSystemService("notification"));
            intent = new Notification();
            intent.flags = 2;
            intent.icon = 0x7f0200eb;
            PendingIntent pendingintent = PendingIntent.getBroadcast(context, 0, new Intent("home"), 0);
            PendingIntent pendingintent1 = PendingIntent.getBroadcast(context, 0, new Intent("boost"), 0);
            PendingIntent pendingintent2 = PendingIntent.getBroadcast(context, 0, new Intent("games"), 0);
            PendingIntent pendingintent3 = PendingIntent.getBroadcast(context, 0, new Intent("camera"), 0);
            PendingIntent pendingintent4 = PendingIntent.getBroadcast(context, 0, new Intent("set"), 0);
            context = PendingIntent.getBroadcast(context, 0, new Intent("flash"), 0);
            RemoteViews remoteviews = new RemoteViews(getApplicationContext().getPackageName(), 0x7f030095);
            remoteviews.setOnClickPendingIntent(0x7f070347, pendingintent);
            remoteviews.setOnClickPendingIntent(0x7f070348, pendingintent1);
            remoteviews.setOnClickPendingIntent(0x7f070349, pendingintent2);
            remoteviews.setOnClickPendingIntent(0x7f07034a, pendingintent3);
            remoteviews.setOnClickPendingIntent(0x7f07034c, pendingintent4);
            remoteviews.setOnClickPendingIntent(0x7f07034b, context);
            intent.contentView = remoteviews;
            ServiceToggle.access$1(ServiceToggle.this).notify(1119, intent);
        } else
        if (intent.getAction().equals("toggle_off") && ServiceToggle.access$1(ServiceToggle.this) != null)
        {
            ServiceToggle.access$1(ServiceToggle.this).cancel(1119);
            return;
        }
    }

    ()
    {
        this$0 = ServiceToggle.this;
        super();
    }
}
