// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;

// Referenced classes of package android.support.v4.app:
//            cj

class ck extends cj
{

    ck()
    {
    }

    public final void a(NotificationManager notificationmanager, String s, int i)
    {
        notificationmanager.cancel(s, i);
    }

    public final void a(NotificationManager notificationmanager, String s, int i, Notification notification)
    {
        notificationmanager.notify(s, i, notification);
    }
}
