// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.d.a;

import sun.misc.Unsafe;

// Referenced classes of package e.d.d.a:
//            v, x

public final class q extends v
{

    public q(int i)
    {
        super(i);
    }

    private long a()
    {
        return x.a.getLongVolatile(this, d);
    }

    public final boolean offer(Object obj)
    {
        if (obj == null)
        {
            throw new NullPointerException("null elements not allowed");
        }
        Object aobj[] = c;
        long l = producerIndex;
        long l1 = a(l);
        if (b(aobj, l1) != null)
        {
            return false;
        } else
        {
            x.a.putOrderedLong(this, e, l + 1L);
            b(aobj, l1, obj);
            return true;
        }
    }

    public final Object peek()
    {
        return c(a(consumerIndex));
    }

    public final Object poll()
    {
        long l = consumerIndex;
        long l1 = a(l);
        Object aobj[] = c;
        Object obj = b(aobj, l1);
        if (obj == null)
        {
            return null;
        } else
        {
            x.a.putOrderedLong(this, d, l + 1L);
            b(aobj, l1, null);
            return obj;
        }
    }

    public final int size()
    {
        long l = a();
        do
        {
            long l2 = x.a.getLongVolatile(this, e);
            long l1 = a();
            if (l == l1)
            {
                return (int)(l2 - l1);
            }
            l = l1;
        } while (true);
    }
}
