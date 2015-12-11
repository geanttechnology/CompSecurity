// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Notification;

final class ba extends aw
{

    ba()
    {
    }

    public final Notification a(au au1)
    {
        boolean flag1 = true;
        Object obj = au1.a;
        Notification notification = au1.i;
        au1 = au1.b;
        obj = (new android.app.Notification.Builder(((android.content.Context) (obj)))).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        boolean flag;
        if ((notification.flags & 2) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = ((android.app.Notification.Builder) (obj)).setOngoing(flag);
        if ((notification.flags & 8) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = ((android.app.Notification.Builder) (obj)).setOnlyAlertOnce(flag);
        if ((notification.flags & 0x10) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        au1 = ((android.app.Notification.Builder) (obj)).setAutoCancel(flag).setDefaults(notification.defaults).setContentTitle(null).setContentText(null).setContentInfo(null).setContentIntent(au1).setDeleteIntent(notification.deleteIntent);
        if ((notification.flags & 0x80) != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        return au1.setFullScreenIntent(null, flag).setLargeIcon(null).setNumber(0).getNotification();
    }
}
