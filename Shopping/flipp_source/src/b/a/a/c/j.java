// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.c;

import b.a.a.l;
import b.a.a.m;
import java.io.Serializable;

// Referenced classes of package b.a.a.c:
//            g

public final class j extends l
    implements Serializable
{

    public static final l a = new j();

    private j()
    {
    }

    public final long a(long l1, int i)
    {
        return g.a(l1, i);
    }

    public final long a(long l1, long l2)
    {
        return g.a(l1, l2);
    }

    public final m a()
    {
        return m.a();
    }

    public final int b(long l1, long l2)
    {
        return g.a(g.b(l1, l2));
    }

    public final boolean b()
    {
        return true;
    }

    public final long c(long l1, long l2)
    {
        return g.b(l1, l2);
    }

    public final boolean c()
    {
        return true;
    }

    public final int compareTo(Object obj)
    {
        long l1 = ((l)obj).d();
        if (1L == l1)
        {
            return 0;
        }
        return 1L >= l1 ? 1 : -1;
    }

    public final long d()
    {
        return 1L;
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof j)
        {
            flag = flag1;
            if (1L == 1L)
            {
                flag = true;
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        return 1;
    }

    public final String toString()
    {
        return "DurationField[millis]";
    }

}
