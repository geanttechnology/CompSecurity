// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.d.a;

import sun.misc.Unsafe;

// Referenced classes of package e.d.d.a:
//            l, x

abstract class j extends l
{

    private static long d = x.a(e/d/d/a/j, "consumerIndex");
    private volatile long consumerIndex;

    public j(int i)
    {
        super(i);
    }

    protected final long a()
    {
        return consumerIndex;
    }

    protected final boolean a(long l1, long l2)
    {
        return x.a.compareAndSwapLong(this, d, l1, l2);
    }

}
