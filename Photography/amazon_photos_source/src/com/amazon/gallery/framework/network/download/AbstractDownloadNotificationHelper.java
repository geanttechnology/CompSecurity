// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;

import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;

// Referenced classes of package com.amazon.gallery.framework.network.download:
//            DownloadStatusNotifier

public abstract class AbstractDownloadNotificationHelper
    implements DownloadStatusNotifier
{

    private final Context context;
    private android.support.v4.app.NotificationCompat.Builder downloadingStatusNotificationBuilder;
    private android.support.v4.app.NotificationCompat.Builder errorStatusNotificationBuilder;
    private final NotificationManager notificationManager;

    public AbstractDownloadNotificationHelper(Context context1)
    {
        context = context1;
        notificationManager = (NotificationManager)context1.getSystemService("notification");
    }

    private static android.support.v4.app.NotificationCompat.Builder createNotificationBuilder(Context context1, boolean flag)
    {
        if (flag)
        {
            return (new android.support.v4.app.NotificationCompat.Builder(context1)).setContentTitle(context1.getResources().getText(0x7f0e0059)).setContentText(context1.getResources().getText(0x7f0e01af)).setOngoing(false).setSmallIcon(0x7f0201f2);
        } else
        {
            return (new android.support.v4.app.NotificationCompat.Builder(context1)).setContentTitle(context1.getResources().getText(0x7f0e01b1)).setOngoing(true).setSmallIcon(0x7f0201ea);
        }
    }

    protected void clearDownloadNotification()
    {
        notificationManager.cancel(49059);
    }

    protected void showErrorNotification()
    {
        if (errorStatusNotificationBuilder == null)
        {
            errorStatusNotificationBuilder = createNotificationBuilder(context, true);
        }
        errorStatusNotificationBuilder.setWhen(System.currentTimeMillis());
        notificationManager.notify(49059, errorStatusNotificationBuilder.build());
    }

    protected void updateDownloadNotification(long l, String s, long l1)
    {
        if (downloadingStatusNotificationBuilder == null)
        {
            downloadingStatusNotificationBuilder = createNotificationBuilder(context, false);
        }
        s = String.format("(%s) %s", new Object[] {
            context.getString(0x7f0e01b0, new Object[] {
                Long.valueOf(l), Long.valueOf(l1)
            }), s
        });
        downloadingStatusNotificationBuilder.setContentText(s).setWhen(System.currentTimeMillis());
        notificationManager.notify(49059, downloadingStatusNotificationBuilder.build());
    }
}
