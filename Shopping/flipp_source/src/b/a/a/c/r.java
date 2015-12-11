// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.c;

import b.a.a.l;
import b.a.a.m;
import java.io.Serializable;
import java.util.HashMap;

public final class r extends l
    implements Serializable
{

    private static HashMap a;
    private final m b;

    private r(m m1)
    {
        b = m1;
    }

    public static r a(m m1)
    {
        b/a/a/c/r;
        JVM INSTR monitorenter ;
        if (a != null) goto _L2; else goto _L1
_L1:
        a = new HashMap(7);
        r r1 = null;
_L4:
        r r2;
        r2 = r1;
        if (r1 != null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        r2 = new r(m1);
        a.put(m1, r2);
        b/a/a/c/r;
        JVM INSTR monitorexit ;
        return r2;
_L2:
        r1 = (r)a.get(m1);
        if (true) goto _L4; else goto _L3
_L3:
        m1;
        throw m1;
    }

    private UnsupportedOperationException e()
    {
        return new UnsupportedOperationException((new StringBuilder()).append(b).append(" field is unsupported").toString());
    }

    public final long a(long l1, int i)
    {
        throw e();
    }

    public final long a(long l1, long l2)
    {
        throw e();
    }

    public final m a()
    {
        return b;
    }

    public final int b(long l1, long l2)
    {
        throw e();
    }

    public final boolean b()
    {
        return false;
    }

    public final long c(long l1, long l2)
    {
        throw e();
    }

    public final boolean c()
    {
        return true;
    }

    public final volatile int compareTo(Object obj)
    {
        return 0;
    }

    public final long d()
    {
        return 0L;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj instanceof r)
            {
                obj = (r)obj;
                if (((r) (obj)).b.m == null)
                {
                    if (b.m != null)
                    {
                        return false;
                    }
                } else
                {
                    return ((r) (obj)).b.m.equals(b.m);
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return b.m.hashCode();
    }

    public final String toString()
    {
        return (new StringBuilder("UnsupportedDurationField[")).append(b.m).append(']').toString();
    }
}
