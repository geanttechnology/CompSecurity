// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a;

import b.a.a.a.f;
import b.a.a.d.ab;
import b.a.a.d.ac;

// Referenced classes of package b.a.a:
//            v, m, z

public final class s extends f
{

    public static final s a = new s(0);
    public static final s b = new s(1);
    public static final s c = new s(2);
    public static final s d = new s(3);
    public static final s e = new s(4);
    public static final s f = new s(5);
    public static final s g = new s(6);
    public static final s h = new s(7);
    public static final s i = new s(8);
    public static final s j = new s(9);
    public static final s k = new s(10);
    public static final s l = new s(11);
    public static final s m = new s(12);
    public static final s n = new s(0x7fffffff);
    public static final s o = new s(0x80000000);
    private static final ac q = ab.a().a(v.b());

    private s(int i1)
    {
        super(i1);
    }

    public static s a(z z, z z1)
    {
        int i1 = b.a.a.a.f.a(z, z1, b.a.a.m.i());
        switch (i1)
        {
        default:
            return new s(i1);

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

        case 8: // '\b'
            return i;

        case 9: // '\t'
            return j;

        case 10: // '\n'
            return k;

        case 11: // '\013'
            return l;

        case 12: // '\f'
            return m;

        case 2147483647: 
            return n;

        case -2147483648: 
            return o;
        }
    }

    public final m a()
    {
        return b.a.a.m.i();
    }

    public final v b()
    {
        return v.b();
    }

    public final String toString()
    {
        return (new StringBuilder("P")).append(String.valueOf(super.p)).append("M").toString();
    }

}
