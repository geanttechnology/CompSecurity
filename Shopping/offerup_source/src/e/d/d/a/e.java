// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.d.a;

import sun.misc.Unsafe;

// Referenced classes of package e.d.d.a:
//            g, x

abstract class e extends g
{

    private static final long e = x.a(e/d/d/a/e, "consumerIndex");
    private volatile long consumerIndex;

    public e(int i)
    {
        super(i);
    }

    protected final long a()
    {
        return consumerIndex;
    }

    protected final boolean a(long l, long l1)
    {
        return x.a.compareAndSwapLong(this, e, l, l1);
    }

}
