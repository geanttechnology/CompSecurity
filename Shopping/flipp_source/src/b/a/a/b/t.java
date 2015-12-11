// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.b;

import b.a.a.a;
import b.a.a.c;
import b.a.a.c.f;
import b.a.a.c.o;
import b.a.a.d;
import b.a.a.i;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package b.a.a.b:
//            a, s, v, u, 
//            b

public final class t extends b.a.a.b.a
{

    private static final t l;
    private static final t m[] = new t[64];
    private static final Map n;

    private t(a a1)
    {
        super(a1, null);
    }

    public static t L()
    {
        return l;
    }

    public static t M()
    {
        return b(i.a());
    }

    public static t b(i j)
    {
        i k;
        int i1;
        k = j;
        if (j == null)
        {
            k = i.a();
        }
        i1 = System.identityHashCode(k) & 0x3f;
        j = m[i1];
        if (j != null && j.a() == k)
        {
            return j;
        }
        Map map = n;
        map;
        JVM INSTR monitorenter ;
        t t1 = (t)n.get(k);
        j = t1;
        if (t1 != null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        j = new t(b.a.a.b.v.a(l, k));
        n.put(k, j);
        map;
        JVM INSTR monitorexit ;
        m[i1] = j;
        return j;
        j;
        map;
        JVM INSTR monitorexit ;
        throw j;
    }

    public final a a(i j)
    {
        i k = j;
        if (j == null)
        {
            k = i.a();
        }
        if (k == a())
        {
            return this;
        } else
        {
            return b(k);
        }
    }

    protected final void a(b b1)
    {
        if (super.a.a() == i.a)
        {
            b1.H = new f(b.a.a.b.u.a, d.v());
            b1.G = new o((f)b1.H, d.u());
            b1.C = new o((f)b1.H, d.q());
            b1.k = b1.H.d();
        }
    }

    public final a b()
    {
        return l;
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj instanceof t)
        {
            obj = (t)obj;
            return a().equals(((t) (obj)).a());
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return "ISO".hashCode() * 11 + a().hashCode();
    }

    public final String toString()
    {
        String s1 = "ISOChronology";
        i j = a();
        if (j != null)
        {
            s1 = (new StringBuilder()).append("ISOChronology").append('[').append(j.c).append(']').toString();
        }
        return s1;
    }

    static 
    {
        n = new HashMap();
        l = new t(s.U());
        n.put(i.a, l);
    }
}
