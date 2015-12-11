// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a;

import b.a.a.a.f;
import b.a.a.d.ab;
import b.a.a.d.ac;

// Referenced classes of package b.a.a:
//            v, r, aa, f, 
//            a, l, m

public final class k extends f
{

    public static final k a = new k(0);
    public static final k b = new k(1);
    public static final k c = new k(2);
    public static final k d = new k(3);
    public static final k e = new k(4);
    public static final k f = new k(5);
    public static final k g = new k(6);
    public static final k h = new k(7);
    public static final k i = new k(0x7fffffff);
    public static final k j = new k(0x80000000);
    private static final ac k = ab.a().a(v.d());

    private k(int i1)
    {
        super(i1);
    }

    private static k a(int i1)
    {
        switch (i1)
        {
        default:
            return new k(i1);

        case 0: // '\0'
            return a;

        case 1: // '\001'
            return b;

        case 2: // '\002'
            return c;

        case 3: // '\003'
            return d;

        case 4: // '\004'
            return e;

        case 5: // '\005'
            return f;

        case 6: // '\006'
            return g;

        case 7: // '\007'
            return h;

        case 2147483647: 
            return i;

        case -2147483648: 
            return j;
        }
    }

    public static k a(aa aa1, aa aa2)
    {
        if ((aa1 instanceof r) && (aa2 instanceof r))
        {
            return a(b.a.a.f.a(aa1.a()).s().b(((r)aa2).a, ((r)aa1).a));
        }
        k k1 = a;
        if (aa1 == null || aa2 == null)
        {
            throw new IllegalArgumentException("ReadablePartial objects must not be null");
        }
        for (int i1 = 0; i1 < 3; i1++)
        {
            if (aa1.b(i1) != aa2.b(i1))
            {
                throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
            }
        }

        if (!b.a.a.f.a(aa1))
        {
            throw new IllegalArgumentException("ReadablePartial objects must be contiguous");
        } else
        {
            a a1 = b.a.a.f.a(aa1.a()).b();
            return a(a1.a(k1, a1.a(aa1, 0xeaf625800L), a1.a(aa2, 0xeaf625800L))[0]);
        }
    }

    public final m a()
    {
        return b.a.a.m.f();
    }

    public final v b()
    {
        return v.d();
    }

    public final String toString()
    {
        return (new StringBuilder("P")).append(String.valueOf(super.p)).append("D").toString();
    }

}
