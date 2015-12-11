// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.b;

import b.a.a.a;
import b.a.a.c;
import b.a.a.i;
import b.a.a.l;
import java.util.HashMap;

// Referenced classes of package b.a.a.b:
//            a, w, x, b

public final class v extends b.a.a.b.a
{

    private v(a a1, i j)
    {
        super(a1, j);
    }

    public static v a(a a1, i j)
    {
        if (a1 == null)
        {
            throw new IllegalArgumentException("Must supply a chronology");
        }
        a1 = a1.b();
        if (a1 == null)
        {
            throw new IllegalArgumentException("UTC chronology must not be null");
        }
        if (j == null)
        {
            throw new IllegalArgumentException("DateTimeZone must not be null");
        } else
        {
            return new v(a1, j);
        }
    }

    private c a(c c1, HashMap hashmap)
    {
        if (c1 == null || !c1.c())
        {
            return c1;
        }
        if (hashmap.containsKey(c1))
        {
            return (c)hashmap.get(c1);
        } else
        {
            w w1 = new w(c1, (i)super.b, a(c1.d(), hashmap), a(c1.e(), hashmap), a(c1.f(), hashmap));
            hashmap.put(c1, w1);
            return w1;
        }
    }

    private l a(l l1, HashMap hashmap)
    {
        if (l1 == null || !l1.b())
        {
            return l1;
        }
        if (hashmap.containsKey(l1))
        {
            return (l)hashmap.get(l1);
        } else
        {
            x x1 = new x(l1, (i)super.b);
            hashmap.put(l1, x1);
            return x1;
        }
    }

    static boolean a(l l1)
    {
        return l1 != null && l1.d() < 0x2932e00L;
    }

    public final a a(i j)
    {
        i k = j;
        if (j == null)
        {
            k = i.a();
        }
        if (k == super.b)
        {
            return this;
        }
        if (k == i.a)
        {
            return super.a;
        } else
        {
            return new v(super.a, k);
        }
    }

    public final i a()
    {
        return (i)super.b;
    }

    protected final void a(b b1)
    {
        HashMap hashmap = new HashMap();
        b1.l = a(b1.l, hashmap);
        b1.k = a(b1.k, hashmap);
        b1.j = a(b1.j, hashmap);
        b1.i = a(b1.i, hashmap);
        b1.h = a(b1.h, hashmap);
        b1.g = a(b1.g, hashmap);
        b1.f = a(b1.f, hashmap);
        b1.e = a(b1.e, hashmap);
        b1.d = a(b1.d, hashmap);
        b1.c = a(b1.c, hashmap);
        b1.b = a(b1.b, hashmap);
        b1.a = a(b1.a, hashmap);
        b1.E = a(b1.E, hashmap);
        b1.F = a(b1.F, hashmap);
        b1.G = a(b1.G, hashmap);
        b1.H = a(b1.H, hashmap);
        b1.I = a(b1.I, hashmap);
        b1.x = a(b1.x, hashmap);
        b1.y = a(b1.y, hashmap);
        b1.z = a(b1.z, hashmap);
        b1.D = a(b1.D, hashmap);
        b1.A = a(b1.A, hashmap);
        b1.B = a(b1.B, hashmap);
        b1.C = a(b1.C, hashmap);
        b1.m = a(b1.m, hashmap);
        b1.n = a(b1.n, hashmap);
        b1.o = a(b1.o, hashmap);
        b1.p = a(b1.p, hashmap);
        b1.q = a(b1.q, hashmap);
        b1.r = a(b1.r, hashmap);
        b1.s = a(b1.s, hashmap);
        b1.u = a(b1.u, hashmap);
        b1.t = a(b1.t, hashmap);
        b1.v = a(b1.v, hashmap);
        b1.w = a(b1.w, hashmap);
    }

    public final a b()
    {
        return super.a;
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof v))
        {
            return false;
        }
        obj = (v)obj;
        return super.a.equals(((b.a.a.b.a) (obj)).a) && ((i)super.b).equals((i)((b.a.a.b.a) (obj)).b);
    }

    public final int hashCode()
    {
        return ((i)super.b).hashCode() * 11 + 0x4fba5 + super.a.hashCode() * 7;
    }

    public final String toString()
    {
        return (new StringBuilder("ZonedChronology[")).append(super.a).append(", ").append(((i)super.b).c).append(']').toString();
    }
}
