// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Notification;

// Referenced classes of package android.support.v4.app:
//            bp, bl, bm

final class bt extends bp
{

    bt()
    {
    }

    public final Notification a(bl bl1, bm bm)
    {
        boolean flag1 = true;
        Object obj1 = bl1.a;
        bm = bl1.q;
        Object obj = bl1.b;
        CharSequence charsequence = bl1.c;
        android.app.PendingIntent pendingintent = bl1.d;
        bl1 = bl1.e;
        obj1 = (new android.app.Notification.Builder(((android.content.Context) (obj1)))).setWhen(((Notification) (bm)).when).setSmallIcon(((Notification) (bm)).icon, ((Notification) (bm)).iconLevel).setContent(((Notification) (bm)).contentView).setTicker(((Notification) (bm)).tickerText, null).setSound(((Notification) (bm)).sound, ((Notification) (bm)).audioStreamType).setVibrate(((Notification) (bm)).vibrate).setLights(((Notification) (bm)).ledARGB, ((Notification) (bm)).ledOnMS, ((Notification) (bm)).ledOffMS);
        boolean flag;
        if ((((Notification) (bm)).flags & 2) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj1 = ((android.app.Notification.Builder) (obj1)).setOngoing(flag);
        if ((((Notification) (bm)).flags & 8) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj1 = ((android.app.Notification.Builder) (obj1)).setOnlyAlertOnce(flag);
        if ((((Notification) (bm)).flags & 0x10) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = ((android.app.Notification.Builder) (obj1)).setAutoCancel(flag).setDefaults(((Notification) (bm)).defaults).setContentTitle(((CharSequence) (obj))).setContentText(charsequence).setContentInfo(null).setContentIntent(pendingintent).setDeleteIntent(((Notification) (bm)).deleteIntent);
        if ((((Notification) (bm)).flags & 0x80) != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        return ((android.app.Notification.Builder) (obj)).setFullScreenIntent(null, flag).setLargeIcon(bl1).setNumber(0).getNotification();
    }
}
