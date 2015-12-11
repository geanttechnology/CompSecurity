// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.d.a;

import java.util.Iterator;
import sun.misc.Unsafe;

// Referenced classes of package e.d.d.a:
//            b, x

public abstract class a extends b
{

    protected static final int a;
    private static final long d;
    private static final int e;
    protected final long b;
    protected final Object c[];

    public a(int i)
    {
        i = android.support.v4.e.a.b(i);
        b = i - 1;
        c = (Object[])new Object[(i << a) + 64];
    }

    protected static Object a(Object aobj[], long l)
    {
        return x.a.getObject(((Object) (aobj)), l);
    }

    protected static void a(Object aobj[], long l, Object obj)
    {
        x.a.putObject(((Object) (aobj)), l, obj);
    }

    protected static Object b(Object aobj[], long l)
    {
        return x.a.getObjectVolatile(((Object) (aobj)), l);
    }

    protected static void b(Object aobj[], long l, Object obj)
    {
        x.a.putOrderedObject(((Object) (aobj)), l, obj);
    }

    protected final long a(long l)
    {
        long l1 = b;
        long l2 = d;
        return ((l1 & l) << e) + l2;
    }

    protected final void a(long l, Object obj)
    {
        a(c, l, obj);
    }

    protected final Object b(long l)
    {
        return a(c, l);
    }

    protected final Object c(long l)
    {
        return b(c, l);
    }

    public void clear()
    {
        while (poll() != null || !isEmpty()) ;
    }

    public Iterator iterator()
    {
        throw new UnsupportedOperationException();
    }

    static 
    {
        a = Integer.getInteger("sparse.shift", 0).intValue();
        int i = x.a.arrayIndexScale([Ljava/lang/Object;);
        if (4 == i)
        {
            e = a + 2;
        } else
        if (8 == i)
        {
            e = a + 3;
        } else
        {
            throw new IllegalStateException("Unknown pointer size");
        }
        d = x.a.arrayBaseOffset([Ljava/lang/Object;) + (32 << e - a);
    }
}
