// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.picasso;

import android.appwidget.AppWidgetManager;
import android.widget.RemoteViews;

// Referenced classes of package it.sephiroth.android.library.picasso:
//            RemoteViewsAction, Picasso, Request

static class appWidgetIds extends RemoteViewsAction
{

    private final int appWidgetIds[];

    volatile Object getTarget()
    {
        return super.getTarget();
    }

    void update()
    {
        AppWidgetManager.getInstance(picasso.context).updateAppWidget(appWidgetIds, remoteViews);
    }

    (Picasso picasso, Request request, RemoteViews remoteviews, int i, int ai[], boolean flag, int j, 
            String s, Object obj, long l)
    {
        super(picasso, request, remoteviews, i, j, flag, s, obj, l);
        appWidgetIds = ai;
    }
}
