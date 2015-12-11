// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import java.util.TimerTask;

// Referenced classes of package com.google.analytics.tracking.android:
//            v, z

final class ab extends TimerTask
{

    final v a;

    private ab(v v1)
    {
        a = v1;
        super();
    }

    ab(v v1, byte byte0)
    {
        this(v1);
    }

    public final void run()
    {
        if (a.b == z.a)
        {
            a.g();
        }
    }
}
