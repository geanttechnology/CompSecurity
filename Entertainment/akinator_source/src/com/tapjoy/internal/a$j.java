// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.app.Notification;

// Referenced classes of package com.tapjoy.internal:
//            a

static final class 
    implements 
{

    public final Notification a( )
    {
        android.content.Context context = .a;
        Notification notification = .r;
        CharSequence charsequence = .b;
        CharSequence charsequence1 = .c;
        CharSequence charsequence2 = .h;
        android.widget.RemoteViews remoteviews = .f;
        int i = .i;
        android.app.PendingIntent pendingintent1 = .d;
        android.app.PendingIntent pendingintent = .e;
        android.graphics.Bitmap bitmap = .g;
        int k = .n;
        int l = .o;
        boolean flag1 = .p;
         = (new android.app.fication.Builder(context)).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteviews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        boolean flag;
        if ((notification.flags & 2) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
         = .setOngoing(flag);
        if ((notification.flags & 8) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
         = .setOnlyAlertOnce(flag);
        if ((notification.flags & 0x10) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
         = .setAutoCancel(flag).setDefaults(notification.defaults).setContentTitle(charsequence).setContentText(charsequence1).setContentInfo(charsequence2).setContentIntent(pendingintent1).setDeleteIntent(notification.deleteIntent);
        if ((notification.flags & 0x80) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return .setFullScreenIntent(pendingintent, flag).setLargeIcon(bitmap).setNumber(i).setProgress(k, l, flag1).getNotification();
    }

    ()
    {
    }
}
