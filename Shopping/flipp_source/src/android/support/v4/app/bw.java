// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Notification;

// Referenced classes of package android.support.v4.app:
//            bv, bq, cj

final class bw extends bv
{

    bw()
    {
    }

    public final Notification a(bq bq1)
    {
        Notification notification = bq1.B;
        notification.setLatestEventInfo(bq1.a, bq1.b, bq1.c, bq1.d);
        notification = cj.a(notification, bq1.a, bq1.b, bq1.c, bq1.d, bq1.e);
        if (bq1.j > 0)
        {
            notification.flags = notification.flags | 0x80;
        }
        return notification;
    }
}
