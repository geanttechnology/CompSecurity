// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.c;

import b.a.a.l;
import b.a.a.m;
import java.io.Serializable;

// Referenced classes of package b.a.a.c:
//            g

public abstract class c extends l
    implements Serializable
{

    final m d;

    public c(m m1)
    {
        if (m1 == null)
        {
            throw new IllegalArgumentException("The type must not be null");
        } else
        {
            d = m1;
            return;
        }
    }

    public final m a()
    {
        return d;
    }

    public int b(long l1, long l2)
    {
        return g.a(c(l1, l2));
    }

    public final boolean b()
    {
        return true;
    }

    public int compareTo(Object obj)
    {
        long l1 = ((l)obj).d();
        long l2 = d();
        if (l2 == l1)
        {
            return 0;
        }
        return l2 >= l1 ? 1 : -1;
    }

    public String toString()
    {
        return (new StringBuilder("DurationField[")).append(d.m).append(']').toString();
    }
}
