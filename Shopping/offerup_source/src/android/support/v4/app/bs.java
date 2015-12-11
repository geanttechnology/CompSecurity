// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Notification;

// Referenced classes of package android.support.v4.app:
//            bp, bl, bm

final class bs extends bp
{

    bs()
    {
    }

    public final Notification a(bl bl1, bm bm)
    {
        bm = bl1.q;
        bm.setLatestEventInfo(bl1.a, bl1.b, bl1.c, bl1.d);
        bm.setLatestEventInfo(bl1.a, bl1.b, bl1.c, bl1.d);
        bm.fullScreenIntent = null;
        if (bl1.f > 0)
        {
            bm.flags = ((Notification) (bm)).flags | 0x80;
        }
        return bm;
    }
}
