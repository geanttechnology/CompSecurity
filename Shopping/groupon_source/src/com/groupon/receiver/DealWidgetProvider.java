// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.groupon.service.WidgetDealIntentService;
import roboguice.util.Ln;

public class DealWidgetProvider extends AppWidgetProvider
{

    private static final int DELAY_BOOT_BY_MS = 40000;

    public DealWidgetProvider()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        super.onReceive(context, intent);
        intent = WidgetDealIntentService.newIntent(context, intent, intent.getAction());
        long l = SystemClock.uptimeMillis();
        Ln.d("SystemClock: %s", new Object[] {
            Long.valueOf(l)
        });
        if (l > 40000L)
        {
            Ln.d("Sending intent now: %s", new Object[] {
                intent
            });
            context.startService(intent);
            return;
        } else
        {
            Ln.d("Postponing intent by %s ms: %s", new Object[] {
                Integer.valueOf(40000), intent
            });
            ((AlarmManager)context.getSystemService("alarm")).set(0, System.currentTimeMillis() + 40000L, PendingIntent.getService(context, 0, intent, 0));
            return;
        }
    }
}
