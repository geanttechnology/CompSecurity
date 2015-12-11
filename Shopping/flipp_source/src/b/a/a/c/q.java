// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.c;

import b.a.a.aa;
import b.a.a.c;
import b.a.a.d;
import b.a.a.l;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;

public final class q extends c
    implements Serializable
{

    private static HashMap a;
    private final d b;
    private final l c;

    private q(d d1, l l1)
    {
        if (d1 == null || l1 == null)
        {
            throw new IllegalArgumentException();
        } else
        {
            b = d1;
            c = l1;
            return;
        }
    }

    public static q a(d d1, l l1)
    {
        b/a/a/c/q;
        JVM INSTR monitorenter ;
        if (a != null) goto _L2; else goto _L1
_L1:
        a = new HashMap(7);
        q q1 = null;
_L4:
        q q2;
        q2 = q1;
        if (q1 != null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        q2 = new q(d1, l1);
        a.put(d1, q2);
        b/a/a/c/q;
        JVM INSTR monitorexit ;
        return q2;
_L2:
        q2 = (q)a.get(d1);
        q1 = q2;
        if (q2 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        l l2 = q2.c;
        q1 = q2;
        if (l2 != l1)
        {
            q1 = null;
        }
        if (true) goto _L4; else goto _L3
_L3:
        d1;
        throw d1;
    }

    private UnsupportedOperationException i()
    {
        return new UnsupportedOperationException((new StringBuilder()).append(b).append(" field is unsupported").toString());
    }

    public final int a(long l1)
    {
        throw i();
    }

    public final int a(Locale locale)
    {
        throw i();
    }

    public final long a(long l1, int j)
    {
        return c.a(l1, j);
    }

    public final long a(long l1, long l2)
    {
        return c.a(l1, l2);
    }

    public final long a(long l1, String s, Locale locale)
    {
        throw i();
    }

    public final d a()
    {
        return b;
    }

    public final String a(int j, Locale locale)
    {
        throw i();
    }

    public final String a(long l1, Locale locale)
    {
        throw i();
    }

    public final String a(aa aa, Locale locale)
    {
        throw i();
    }

    public final int b(long l1, long l2)
    {
        return c.b(l1, l2);
    }

    public final long b(long l1, int j)
    {
        throw i();
    }

    public final String b()
    {
        return b.a;
    }

    public final String b(int j, Locale locale)
    {
        throw i();
    }

    public final String b(long l1, Locale locale)
    {
        throw i();
    }

    public final String b(aa aa, Locale locale)
    {
        throw i();
    }

    public final boolean b(long l1)
    {
        throw i();
    }

    public final int c(long l1)
    {
        throw i();
    }

    public final long c(long l1, long l2)
    {
        return c.c(l1, l2);
    }

    public final boolean c()
    {
        return false;
    }

    public final long d(long l1)
    {
        throw i();
    }

    public final l d()
    {
        return c;
    }

    public final long e(long l1)
    {
        throw i();
    }

    public final l e()
    {
        return null;
    }

    public final long f(long l1)
    {
        throw i();
    }

    public final l f()
    {
        return null;
    }

    public final int g()
    {
        throw i();
    }

    public final long g(long l1)
    {
        throw i();
    }

    public final int h()
    {
        throw i();
    }

    public final long h(long l1)
    {
        throw i();
    }

    public final long i(long l1)
    {
        throw i();
    }

    public final String toString()
    {
        return "UnsupportedDateTimeField";
    }
}
