// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.au.e.b;

import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.shazam.android.au.e.b:
//            b

public final class c
{

    public final b a;
    public long b;
    private long c;

    public c(b b1)
    {
        a = b1;
        b = b1.b.get();
        c = b1.d;
    }

    public final void a()
    {
        a(a.a - 1);
    }

    public final void a(long l)
    {
        b = Math.max(0L, a.b.get() - l);
        c = a.d;
    }

    public final Object b()
    {
        if (a.d != c)
        {
            throw new InterruptedException();
        } else
        {
            Object obj = a.a(b);
            b = b + 1L;
            return obj;
        }
    }
}
