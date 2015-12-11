// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Notification;

// Referenced classes of package android.support.v4.app:
//            bs, bq

class bv
    implements bs
{

    bv()
    {
    }

    public Notification a(bq bq1)
    {
        Notification notification = bq1.B;
        notification.setLatestEventInfo(bq1.a, bq1.b, bq1.c, bq1.d);
        if (bq1.j > 0)
        {
            notification.flags = notification.flags | 0x80;
        }
        return notification;
    }
}
