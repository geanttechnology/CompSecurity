// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.d.a;

import sun.misc.Unsafe;

// Referenced classes of package e.d.d.a:
//            k, x

abstract class o extends k
{

    private static long d = x.a(e/d/d/a/o, "producerIndex");
    private volatile long producerIndex;

    public o(int i)
    {
        super(i);
    }

    protected final long b()
    {
        return producerIndex;
    }

    protected final void d(long l)
    {
        x.a.putOrderedLong(this, d, l);
    }

}
