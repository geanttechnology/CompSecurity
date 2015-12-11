// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import co.vine.android.service.ResourceService;
import co.vine.android.util.FlurryUtils;

// Referenced classes of package co.vine.android:
//            AbstractRecordingActivity

public class CameraWidgetProvider extends AppWidgetProvider
{

    public CameraWidgetProvider()
    {
    }

    public void onDeleted(Context context, int ai[])
    {
        FlurryUtils.trackCameraWidgetRemoved();
    }

    public void onUpdate(Context context, AppWidgetManager appwidgetmanager, int ai[])
    {
        RemoteViews remoteviews = new RemoteViews(context.getPackageName(), 0x7f030022);
        int j = ai.length;
        for (int i = 0; i < j; i++)
        {
            int k = ai[i];
            Intent intent = AbstractRecordingActivity.getIntentForGeneric(context, -1, "CameraWidget");
            intent.setAction("co.vine.android.RECORD");
            remoteviews.setOnClickPendingIntent(0x7f0a0076, PendingIntent.getActivity(context, 0, intent, 0));
            appwidgetmanager.updateAppWidget(k, remoteviews);
        }

        context.startService(new Intent(context, co/vine/android/service/ResourceService));
    }
}
