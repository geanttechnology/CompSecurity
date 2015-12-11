// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a;

import b.a.a.a.f;
import b.a.a.d.ab;
import b.a.a.d.ac;

// Referenced classes of package b.a.a:
//            v, m, z

public final class ad extends f
{

    public static final ad a = new ad(0);
    public static final ad b = new ad(1);
    public static final ad c = new ad(2);
    public static final ad d = new ad(3);
    public static final ad e = new ad(0x7fffffff);
    public static final ad f = new ad(0x80000000);
    private static final ac g = ab.a().a(v.a());

    private ad(int i)
    {
        super(i);
    }

    public static ad a(z z, z z1)
    {
        int i = b.a.a.a.f.a(z, z1, m.j());
        switch (i)
        {
        default:
            return new ad(i);

        case 0: // '\0'
            return a;

        case 1: // '\001'
            return b;

        case 2: // '\002'
            return c;

        case 3: // '\003'
            return d;

        case 2147483647: 
            return e;

        case -2147483648: 
            return f;
        }
    }

    public final m a()
    {
        return m.j();
    }

    public final v b()
    {
        return v.a();
    }

    public final String toString()
    {
        return (new StringBuilder("P")).append(String.valueOf(super.p)).append("Y").toString();
    }

}
