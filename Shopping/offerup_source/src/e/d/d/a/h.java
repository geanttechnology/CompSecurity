// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.d.a;

import sun.misc.Unsafe;

// Referenced classes of package e.d.d.a:
//            f, x

abstract class h extends f
{

    private static final long e = x.a(e/d/d/a/h, "producerIndex");
    private volatile long producerIndex;

    public h(int i)
    {
        super(i);
    }

    protected final long b()
    {
        return producerIndex;
    }

    protected final boolean b(long l, long l1)
    {
        return x.a.compareAndSwapLong(this, e, l, l1);
    }

}
