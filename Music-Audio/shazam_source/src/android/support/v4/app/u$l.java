// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Notification;

// Referenced classes of package android.support.v4.app:
//            u

static final class ilder extends ilder
{

    public final Notification a(ilder ilder, ilder ilder1)
    {
        Object obj1 = ilder.a;
        ilder1 = ilder.B;
        Object obj = ilder.b;
        CharSequence charsequence = ilder.c;
        CharSequence charsequence1 = ilder.h;
        android.widget.RemoteViews remoteviews = ilder.f;
        int i = ilder.i;
        android.app.PendingIntent pendingintent1 = ilder.d;
        android.app.PendingIntent pendingintent = ilder.e;
        ilder = ilder.g;
        obj1 = (new android.app.fication.Builder(((android.content.Context) (obj1)))).setWhen(((Notification) (ilder1)).when).setSmallIcon(((Notification) (ilder1)).icon, ((Notification) (ilder1)).iconLevel).setContent(((Notification) (ilder1)).contentView).setTicker(((Notification) (ilder1)).tickerText, remoteviews).setSound(((Notification) (ilder1)).sound, ((Notification) (ilder1)).audioStreamType).setVibrate(((Notification) (ilder1)).vibrate).setLights(((Notification) (ilder1)).ledARGB, ((Notification) (ilder1)).ledOnMS, ((Notification) (ilder1)).ledOffMS);
        boolean flag;
        if ((((Notification) (ilder1)).flags & 2) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj1 = ((android.app.fication.Builder) (obj1)).setOngoing(flag);
        if ((((Notification) (ilder1)).flags & 8) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj1 = ((android.app.fication.Builder) (obj1)).setOnlyAlertOnce(flag);
        if ((((Notification) (ilder1)).flags & 0x10) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = ((android.app.fication.Builder) (obj1)).setAutoCancel(flag).setDefaults(((Notification) (ilder1)).defaults).setContentTitle(((CharSequence) (obj))).setContentText(charsequence).setContentInfo(charsequence1).setContentIntent(pendingintent1).setDeleteIntent(((Notification) (ilder1)).deleteIntent);
        if ((((Notification) (ilder1)).flags & 0x80) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return ((android.app.fication.Builder) (obj)).setFullScreenIntent(pendingintent, flag).setLargeIcon(ilder).setNumber(i).getNotification();
    }

    ilder()
    {
    }
}
