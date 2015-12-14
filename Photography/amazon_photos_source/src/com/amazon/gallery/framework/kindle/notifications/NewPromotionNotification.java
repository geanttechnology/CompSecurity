// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.widget.RemoteViews;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;

public class NewPromotionNotification
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent DismissedNotification;
        public static final MetricsEvent NotificationShown;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/kindle/notifications/NewPromotionNotification$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            NotificationShown = new MetricsEvent("NotificationShown", 0);
            DismissedNotification = new MetricsEvent("DismissedNotification", 1);
            $VALUES = (new MetricsEvent[] {
                NotificationShown, DismissedNotification
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    protected final android.support.v4.app.NotificationCompat.Builder builder;
    private final Context context;
    private BroadcastReceiver notificationDismissedReceiver;
    private final NotificationManager notificationManager;
    private RemoteViews notificationView;
    private final ComponentProfiler profiler;

    public NewPromotionNotification(Context context1, Profiler profiler1)
    {
        context = context1;
        if (profiler1 == null)
        {
            profiler1 = null;
        } else
        {
            profiler1 = new ComponentProfiler(profiler1, com/amazon/gallery/framework/kindle/notifications/NewPromotionNotification);
        }
        profiler = profiler1;
        notificationManager = (NotificationManager)context1.getSystemService("notification");
        builder = (new android.support.v4.app.NotificationCompat.Builder(context1)).setSmallIcon(0x106000d);
        notificationView = new RemoteViews(context1.getPackageName(), 0x7f0300b2);
    }

    private void buildAndShowNotification(String s)
    {
        Object obj = new Intent("com.amazon.gallery.LAUNCH_NEW_PROMOTION_NOTIFICATION");
        ((Intent) (obj)).setFlags(0x24000000);
        obj = PendingIntent.getActivity(context, 0, ((Intent) (obj)), 0);
        Object obj1 = new Intent("com.amazon.photos.DISMISS_NEW_PROMOTION_NOTIFICATION");
        obj1 = PendingIntent.getBroadcast(context, 0, ((Intent) (obj1)), 0);
        notificationView.setTextViewText(0x7f0c013f, s);
        builder.setContentTitle(context.getResources().getString(0x7f0e0104)).setContentText(s).setContent(notificationView).setContentIntent(((PendingIntent) (obj))).setDeleteIntent(((PendingIntent) (obj1))).setAutoCancel(true);
        notificationManager.notify(com/amazon/gallery/framework/kindle/notifications/NewPromotionNotification.getName().hashCode(), builder.build());
    }

    public void showNotification(String s)
    {
        buildAndShowNotification(s);
        notificationDismissedReceiver = new BroadcastReceiver() {

            final NewPromotionNotification this$0;

            public void onReceive(Context context1, Intent intent)
            {
                if (profiler != null)
                {
                    profiler.trackEvent(MetricsEvent.DismissedNotification);
                }
                context1.unregisterReceiver(this);
                notificationDismissedReceiver = null;
            }

            
            {
                this$0 = NewPromotionNotification.this;
                super();
            }
        };
        context.registerReceiver(notificationDismissedReceiver, new IntentFilter("com.amazon.photos.DISMISS_NEW_PROMOTION_NOTIFICATION"));
        if (profiler != null)
        {
            profiler.trackEvent(MetricsEvent.NotificationShown);
        }
    }



/*
    static BroadcastReceiver access$102(NewPromotionNotification newpromotionnotification, BroadcastReceiver broadcastreceiver)
    {
        newpromotionnotification.notificationDismissedReceiver = broadcastreceiver;
        return broadcastreceiver;
    }

*/
}
