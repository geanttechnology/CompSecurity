// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;

// Referenced classes of package android.support.v4.app:
//            bv, cg, bl, bg, 
//            bf, bm

class bw extends bv
{

    bw()
    {
    }

    public Notification a(bl bl1, bm bm)
    {
        bm = new cg(bl1.a, bl1.q, bl1.b, bl1.c, null, null, 0, bl1.d, null, bl1.e, 0, 0, false, bl1.g, false, bl1.f, bl1.i, bl1.k, bl1.r, bl1.m, null, false, null);
        bg.a(bm, bl1.j);
        bg.a(bm, bl1.h);
        return bm.b();
    }

    public final Bundle a(Notification notification)
    {
        return notification.extras;
    }
}
