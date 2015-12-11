// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a;

import b.a.a.a.f;
import b.a.a.d.ab;

// Referenced classes of package b.a.a:
//            v, m, z

public final class ac extends f
{

    public static final ac a = new ac(0);
    public static final ac b = new ac(1);
    public static final ac c = new ac(2);
    public static final ac d = new ac(3);
    public static final ac e = new ac(0x7fffffff);
    public static final ac f = new ac(0x80000000);
    private static final b.a.a.d.ac g = ab.a().a(v.c());

    private ac(int i)
    {
        super(i);
    }

    public static ac a(z z, z z1)
    {
        int i = b.a.a.a.f.a(z, z1, m.g());
        switch (i)
        {
        default:
            return new ac(i);

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
        return m.g();
    }

    public final v b()
    {
        return v.c();
    }

    public final String toString()
    {
        return (new StringBuilder("P")).append(String.valueOf(super.p)).append("W").toString();
    }

}
