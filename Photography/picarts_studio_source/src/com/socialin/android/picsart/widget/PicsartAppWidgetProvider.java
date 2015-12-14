// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class PicsartAppWidgetProvider extends AppWidgetProvider
{

    public PicsartAppWidgetProvider()
    {
    }

    private static void a(Context context, RemoteViews remoteviews)
    {
        Intent intent = new Intent();
        intent.setClassName(context, "com.socialin.android.photo.picsinphoto.MainPagerActivity");
        intent.putExtra("openEdit", true);
        intent.putExtra("widget", true);
        intent.setFlags(0x4400000);
        remoteviews.setOnClickPendingIntent(0x7f100680, PendingIntent.getActivity(context, 1, intent, 0));
        intent = new Intent();
        intent.setClassName(context, "com.socialin.android.photo.picsinphoto.MainPagerActivity");
        intent.putExtra("openDraw", true);
        intent.putExtra("widget", true);
        intent.setFlags(0x4400000);
        remoteviews.setOnClickPendingIntent(0x7f100681, PendingIntent.getActivity(context, 2, intent, 0));
        intent = new Intent();
        intent.setClassName(context, "com.socialin.android.photo.picsinphoto.MainPagerActivity");
        intent.putExtra("openCamera", true);
        intent.putExtra("widget", true);
        intent.setFlags(0x4400000);
        remoteviews.setOnClickPendingIntent(0x7f100682, PendingIntent.getActivity(context, 3, intent, 0));
        intent = new Intent();
        intent.setClassName(context, "com.socialin.android.photo.picsinphoto.MainPagerActivity");
        intent.putExtra("openEffect", true);
        intent.putExtra("widget", true);
        intent.setFlags(0x4400000);
        remoteviews.setOnClickPendingIntent(0x7f100683, PendingIntent.getActivity(context, 4, intent, 0));
    }

    public void onEnabled(Context context)
    {
        super.onEnabled(context);
        for (int i = AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, com/socialin/android/picsart/widget/PicsartAppWidgetProvider)).length; i != 0; i--)
        {
            RemoteViews remoteviews = new RemoteViews(context.getPackageName(), 0x7f030136);
            a(context, remoteviews);
            AppWidgetManager.getInstance(context).updateAppWidget(new ComponentName(context, com/socialin/android/picsart/widget/PicsartAppWidgetProvider), remoteviews);
        }

    }

    public void onUpdate(Context context, AppWidgetManager appwidgetmanager, int ai[])
    {
        super.onUpdate(context, appwidgetmanager, ai);
        int j = ai.length;
        for (int i = 0; i < j; i++)
        {
            int k = ai[i];
            RemoteViews remoteviews = new RemoteViews(context.getPackageName(), 0x7f030136);
            a(context, remoteviews);
            appwidgetmanager.updateAppWidget(k, remoteviews);
        }

    }
}
