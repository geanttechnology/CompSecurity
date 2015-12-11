// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a;

import b.a.a.a.e;
import b.a.a.b.t;
import b.a.a.d.aa;
import b.a.a.d.d;
import b.a.a.d.x;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package b.a.a:
//            aa, m, f, a, 
//            i, c, d, l

public final class r extends e
    implements b.a.a.aa, Serializable
{

    private static final Set b;
    final long a;
    private final a c;
    private volatile transient int d;

    public r()
    {
        this(f.a(), ((a) (t.M())));
    }

    public r(long l1, a a1)
    {
        a a2 = f.a(a1);
        i k = a2.a();
        i j = i.a;
        a1 = j;
        if (j == null)
        {
            a1 = i.a();
        }
        if (a1 != k)
        {
            l1 = a1.a(k.d(l1), l1);
        }
        a1 = a2.b();
        a = a1.u().d(l1);
        c = a1;
    }

    public final int a(int j)
    {
        switch (j)
        {
        default:
            throw new IndexOutOfBoundsException((new StringBuilder("Invalid index: ")).append(j).toString());

        case 0: // '\0'
            return c.E().a(a);

        case 1: // '\001'
            return c.C().a(a);

        case 2: // '\002'
            return c.u().a(a);
        }
    }

    public final int a(b.a.a.aa aa1)
    {
        if (this == aa1)
        {
            return 0;
        }
        if (aa1 instanceof r)
        {
            r r1 = (r)aa1;
            if (c.equals(r1.c))
            {
                if (a < r1.a)
                {
                    return -1;
                }
                return a != r1.a ? 1 : 0;
            }
        }
        return super.a(aa1);
    }

    public final int a(b.a.a.d d1)
    {
        if (d1 == null)
        {
            throw new IllegalArgumentException("The DateTimeFieldType must not be null");
        }
        if (!b(d1))
        {
            throw new IllegalArgumentException((new StringBuilder("Field '")).append(d1).append("' is not supported").toString());
        } else
        {
            return d1.a(c).a(a);
        }
    }

    public final a a()
    {
        return c;
    }

    protected final c a(int j, a a1)
    {
        switch (j)
        {
        default:
            throw new IndexOutOfBoundsException((new StringBuilder("Invalid index: ")).append(j).toString());

        case 0: // '\0'
            return a1.E();

        case 1: // '\001'
            return a1.C();

        case 2: // '\002'
            return a1.u();
        }
    }

    public final boolean b(b.a.a.d d1)
    {
        m m1;
        if (d1 != null)
        {
            if (b.contains(m1 = d1.()) || m1.a(c).d() >= c.s().d())
            {
                return d1.a(c).c();
            }
        }
        return false;
    }

    public final int compareTo(Object obj)
    {
        return a((b.a.a.aa)obj);
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj instanceof r)
        {
            r r1 = (r)obj;
            if (c.equals(r1.c))
            {
                return a == r1.a;
            }
        }
        return super.equals(obj);
    }

    public final int hashCode()
    {
        int k = d;
        int j = k;
        if (k == 0)
        {
            j = super.hashCode();
            d = j;
        }
        return j;
    }

    public final String toString()
    {
        d d1 = aa.d();
        StringBuffer stringbuffer = new StringBuffer(d1.a().a());
        x x1 = d1.a();
        if (this == null)
        {
            throw new IllegalArgumentException("The partial must not be null");
        } else
        {
            x1.a(stringbuffer, this, d1.c);
            return stringbuffer.toString();
        }
    }

    static 
    {
        HashSet hashset = new HashSet();
        b = hashset;
        hashset.add(m.f());
        b.add(m.g());
        b.add(m.i());
        b.add(m.h());
        b.add(m.j());
        b.add(m.k());
        b.add(m.l());
    }
}
