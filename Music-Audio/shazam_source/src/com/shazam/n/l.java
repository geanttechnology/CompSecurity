// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.n;


// Referenced classes of package com.shazam.n:
//            m

public final class l
{

    public boolean a;
    private long b;
    private long c;
    private final m d;

    public l(m m1)
    {
        d = m1;
    }

    private long b()
    {
        return d.b();
    }

    public final long a()
    {
        return c - b;
    }

    public final void a(long l1)
    {
        l1 = b() + l1;
        b = l1;
        c = l1;
        a = true;
    }

    public final void b(long l1)
    {
        c = b() + l1;
        a = false;
    }
}
