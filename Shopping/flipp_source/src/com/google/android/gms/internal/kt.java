// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;

// Referenced classes of package com.google.android.gms.internal:
//            ku, er, et, v, 
//            kr

public final class kt
{

    v a;
    boolean b;
    private final Runnable c;

    public kt(kr kr)
    {
        b = false;
        c = new ku(this, kr);
    }

    public final void a()
    {
        er.a.removeCallbacks(c);
    }

    public final void a(v v)
    {
        a(v, 60000L);
    }

    public final void a(v v, long l)
    {
        if (b)
        {
            et.d("An ad refresh is already scheduled.");
            return;
        } else
        {
            et.b((new StringBuilder("Scheduling ad refresh ")).append(l).append(" milliseconds from now.").toString());
            a = v;
            b = true;
            er.a.postDelayed(c, l);
            return;
        }
    }
}
