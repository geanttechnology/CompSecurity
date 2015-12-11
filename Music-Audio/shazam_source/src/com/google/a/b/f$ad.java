// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;

import java.lang.ref.ReferenceQueue;

// Referenced classes of package com.google.a.b:
//            f

static final class c extends c
{

    volatile long a;
    c b;
    c c;

    public final void b(long l)
    {
        a = l;
    }

    public final void c(a a1)
    {
        b = a1;
    }

    public final void d(b b1)
    {
        c = b1;
    }

    public final long h()
    {
        return a;
    }

    public final a i()
    {
        return b;
    }

    public final b j()
    {
        return c;
    }

    nceQueue(ReferenceQueue referencequeue, Object obj, int k, nceQueue ncequeue)
    {
        super(referencequeue, obj, k, ncequeue);
        a = 0x7fffffffffffffffL;
        b = f.k();
        c = f.k();
    }
}
