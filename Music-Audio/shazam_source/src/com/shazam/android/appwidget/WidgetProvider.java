// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.appwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.shazam.android.analytics.TaggingOrigin;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.factory.WidgetEventFactory;
import com.shazam.i.b.g.b.a;

public class WidgetProvider extends AppWidgetProvider
{

    public WidgetProvider()
    {
    }

    public void onDisabled(Context context)
    {
        a.a().logEvent(WidgetEventFactory.createWidgetEvent(com.shazam.android.analytics.event.factory.WidgetEventFactory.WidgetEventAction.REMOVED));
    }

    public void onEnabled(Context context)
    {
        a.a().logEvent(WidgetEventFactory.createWidgetEvent(com.shazam.android.analytics.event.factory.WidgetEventFactory.WidgetEventAction.ADDED));
    }

    public void onUpdate(Context context, AppWidgetManager appwidgetmanager, int ai[])
    {
        int j = ai.length;
        for (int i = 0; i < j; i++)
        {
            int k = ai[i];
            Object obj = com.shazam.android.activities.b.a.b(context, TaggingOrigin.WIDGET);
            ((Intent) (obj)).addCategory("com.shazam.intent.category.WIDGET");
            ((Intent) (obj)).putExtra("SEND_WIDGET_PRESSED_BEACON", true);
            obj = PendingIntent.getActivity(context, 0, ((Intent) (obj)), 0x8000000);
            RemoteViews remoteviews = new RemoteViews(context.getPackageName(), 0x7f0300bf);
            remoteviews.setOnClickPendingIntent(0x7f110287, ((PendingIntent) (obj)));
            appwidgetmanager.updateAppWidget(k, remoteviews);
        }

    }
}
