// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.amazon.insights.core.util.StringUtil;

public class InsightsProcessingService extends IntentService
{

    public InsightsProcessingService()
    {
        super("AvailabilityServiceWorker");
    }

    public static void cancelPendingIntent(Context context, String s)
    {
        if (context != null)
        {
            s = getPendingIntent(context, s, null);
            context = (AlarmManager)context.getSystemService("alarm");
            if (context != null && s != null)
            {
                context.cancel(s);
            }
        }
    }

    private static PendingIntent getPendingIntent(Context context, String s, Bundle bundle)
    {
        if (context == null)
        {
            return null;
        }
        if (StringUtil.isNullOrEmpty(s))
        {
            throw new RuntimeException("'intentAction' cannot be null");
        }
        s = new Intent(s);
        s.setClass(context.getApplicationContext(), com/amazon/insights/InsightsProcessingService);
        if (bundle != null)
        {
            s.putExtras(bundle);
        }
        return PendingIntent.getService(context.getApplicationContext(), 0, s, 0);
    }

    public void onCreate()
    {
        super.onCreate();
    }

    protected void onHandleIntent(Intent intent)
    {
        cancelPendingIntent(getApplicationContext(), "SubmitMeasurements");
        cancelPendingIntent(getApplicationContext(), "SyncConfiguration");
    }
}
