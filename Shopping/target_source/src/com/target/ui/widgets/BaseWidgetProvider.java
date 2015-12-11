// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.widgets;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.os.Bundle;
import android.widget.RemoteViews;
import com.target.ui.util.i.b;
import com.target.ui.util.i.c;
import com.target.ui.util.j;

public abstract class BaseWidgetProvider extends AppWidgetProvider
{

    public BaseWidgetProvider()
    {
    }

    private static int a(int i)
    {
        int k;
        for (k = 2; k * 70 - 30 < i; k++) { }
        return k - 1;
    }

    private b a(AppWidgetManager appwidgetmanager, int i)
    {
        boolean flag = false;
        if (!j.a())
        {
            appwidgetmanager = a();
        } else
        {
            appwidgetmanager = appwidgetmanager.getAppWidgetOptions(i);
            b b1;
            int k;
            if (appwidgetmanager != null && appwidgetmanager.containsKey("appWidgetMinWidth"))
            {
                i = appwidgetmanager.getInt("appWidgetMinWidth");
            } else
            {
                i = 0;
            }
            k = ((flag) ? 1 : 0);
            if (appwidgetmanager != null)
            {
                k = ((flag) ? 1 : 0);
                if (appwidgetmanager.containsKey("appWidgetMinHeight"))
                {
                    k = appwidgetmanager.getInt("appWidgetMinHeight");
                }
            }
            if (i == 0 || k == 0)
            {
                return a();
            }
            b1 = com.target.ui.util.i.c.a(a(k), a(i));
            appwidgetmanager = b1;
            if (b1.equals(b.UNKNOWN))
            {
                return a();
            }
        }
        return appwidgetmanager;
    }

    private void a(Context context, AppWidgetManager appwidgetmanager, int i)
    {
        appwidgetmanager.updateAppWidget(i, a(context, a(appwidgetmanager, i)));
    }

    protected abstract RemoteViews a(Context context, b b1);

    protected abstract b a();

    protected abstract void a(int ai[]);

    protected abstract void b();

    protected abstract void c();

    public final void onAppWidgetOptionsChanged(Context context, AppWidgetManager appwidgetmanager, int i, Bundle bundle)
    {
        a(context, appwidgetmanager, i);
    }

    public final void onDeleted(Context context, int ai[])
    {
        super.onDeleted(context, ai);
        a(ai);
    }

    public final void onDisabled(Context context)
    {
        super.onDisabled(context);
        c();
    }

    public final void onEnabled(Context context)
    {
        super.onEnabled(context);
        b();
    }

    public final void onRestored(Context context, int ai[], int ai1[])
    {
        super.onRestored(context, ai, ai1);
    }

    public final void onUpdate(Context context, AppWidgetManager appwidgetmanager, int ai[])
    {
        for (int i = 0; i < ai.length; i++)
        {
            a(context, appwidgetmanager, ai[i]);
        }

    }
}
