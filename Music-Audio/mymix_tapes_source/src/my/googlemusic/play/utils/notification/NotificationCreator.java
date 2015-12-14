// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

public class NotificationCreator
{

    private android.support.v4.app.NotificationCompat.Builder builder;
    private int id;
    private NotificationManager notificationManager;

    NotificationCreator(Context context, int i)
    {
        id = i;
        builder = new android.support.v4.app.NotificationCompat.Builder(context);
        notificationManager = (NotificationManager)context.getSystemService("notification");
    }

    public NotificationCreator autoCancel(boolean flag)
    {
        builder.setAutoCancel(flag);
        return this;
    }

    protected void cancel()
    {
        notificationManager.cancel(id);
    }

    public NotificationCreator icon(int i)
    {
        builder.setSmallIcon(i);
        return this;
    }

    public NotificationCreator info(String s)
    {
        builder.setContentInfo(s);
        return this;
    }

    public NotificationCreator intent(PendingIntent pendingintent)
    {
        builder.setContentIntent(pendingintent);
        return this;
    }

    public NotificationCreator largeIcon(Bitmap bitmap)
    {
        builder.setLargeIcon(bitmap);
        return this;
    }

    public NotificationCreator progress(int i, int j, boolean flag)
    {
        builder.setProgress(i, j, flag);
        return this;
    }

    public void show()
    {
        notificationManager.notify(id, builder.build());
    }

    public NotificationCreator sound(Uri uri)
    {
        builder.setSound(uri);
        return this;
    }

    public NotificationCreator text(String s)
    {
        builder.setContentText(s);
        return this;
    }

    public NotificationCreator title(String s)
    {
        builder.setContentTitle(s);
        return this;
    }
}
