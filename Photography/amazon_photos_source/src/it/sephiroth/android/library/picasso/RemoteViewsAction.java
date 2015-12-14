// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.picasso;

import android.app.Notification;
import android.app.NotificationManager;
import android.appwidget.AppWidgetManager;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

// Referenced classes of package it.sephiroth.android.library.picasso:
//            Action, Picasso, Request, Utils

abstract class RemoteViewsAction extends Action
{
    static class AppWidgetAction extends RemoteViewsAction
    {

        private final int appWidgetIds[];

        volatile Object getTarget()
        {
            return getTarget();
        }

        void update()
        {
            AppWidgetManager.getInstance(picasso.context).updateAppWidget(appWidgetIds, remoteViews);
        }

        AppWidgetAction(Picasso picasso, Request request, RemoteViews remoteviews, int i, int ai[], boolean flag, int j, 
                String s, Object obj, long l)
        {
            super(picasso, request, remoteviews, i, j, flag, s, obj, l);
            appWidgetIds = ai;
        }
    }

    static class NotificationAction extends RemoteViewsAction
    {

        private final Notification notification;
        private final int notificationId;

        volatile Object getTarget()
        {
            return getTarget();
        }

        void update()
        {
            ((NotificationManager)Utils.getService(picasso.context, "notification")).notify(notificationId, notification);
        }

        NotificationAction(Picasso picasso, Request request, RemoteViews remoteviews, int i, int j, Notification notification1, boolean flag, 
                int k, String s, Object obj, long l)
        {
            super(picasso, request, remoteviews, i, k, flag, s, obj, l);
            notificationId = j;
            notification = notification1;
        }
    }

    static class RemoteViewsTarget
    {

        final RemoteViews remoteViews;
        final int viewId;

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null || getClass() != obj.getClass())
                {
                    return false;
                }
                obj = (RemoteViewsTarget)obj;
                if (viewId != ((RemoteViewsTarget) (obj)).viewId || !remoteViews.equals(((RemoteViewsTarget) (obj)).remoteViews))
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            return remoteViews.hashCode() * 31 + viewId;
        }

        RemoteViewsTarget(RemoteViews remoteviews, int i)
        {
            remoteViews = remoteviews;
            viewId = i;
        }
    }


    final RemoteViews remoteViews;
    private RemoteViewsTarget target;
    final int viewId;

    RemoteViewsAction(Picasso picasso, Request request, RemoteViews remoteviews, int i, int j, boolean flag, String s, 
            Object obj, long l)
    {
        super(picasso, null, request, flag, l, j, null, s, obj);
        remoteViews = remoteviews;
        viewId = i;
    }

    void complete(Bitmap bitmap, Picasso.LoadedFrom loadedfrom)
    {
        remoteViews.setImageViewBitmap(viewId, bitmap);
        update();
    }

    public void error()
    {
        if (errorResId != 0)
        {
            setImageResource(errorResId);
        }
    }

    RemoteViewsTarget getTarget()
    {
        if (target == null)
        {
            target = new RemoteViewsTarget(remoteViews, viewId);
        }
        return target;
    }

    volatile Object getTarget()
    {
        return getTarget();
    }

    void setImageResource(int i)
    {
        remoteViews.setImageViewResource(viewId, i);
        update();
    }

    abstract void update();
}
