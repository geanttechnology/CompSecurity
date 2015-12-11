// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.mixerbox.mixerbox3b.MixerBox;

public class MyAppWidgetProvider extends AppWidgetProvider
{

    public MyAppWidgetProvider()
    {
    }

    public void onUpdate(Context context, AppWidgetManager appwidgetmanager, int ai[])
    {
        int j = ai.length;
        for (int i = 0; i < j; i++)
        {
            int k = ai[i];
            PendingIntent pendingintent = PendingIntent.getActivity(context, 0, new Intent(context, com/mixerbox/mixerbox3b/MixerBox), 0);
            RemoteViews remoteviews = new RemoteViews(context.getPackageName(), 0x7f03003d);
            remoteviews.setOnClickPendingIntent(0x7f07004a, pendingintent);
            appwidgetmanager.updateAppWidget(k, remoteviews);
        }

    }
}
