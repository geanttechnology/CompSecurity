// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.google.analytics.tracking.android:
//            v, z, m, an

final class aa extends TimerTask
{

    final v a;

    private aa(v v1)
    {
        a = v1;
        super();
    }

    aa(v v1, byte byte0)
    {
        this(v1);
    }

    public final void run()
    {
        if (a.b == z.b && a.c.isEmpty() && a.a + a.f < a.e.a())
        {
            an.c("Disconnecting due to inactivity");
            a.i();
            return;
        } else
        {
            a.d.schedule(new aa(a), a.f);
            return;
        }
    }
}
