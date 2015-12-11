// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a;


// Referenced classes of package b.a.a:
//            d, f, a, m, 
//            c

final class e extends d
{

    private final byte b;
    private final transient m c;
    private final transient m d;

    e(String s, byte byte0, m m, m m1)
    {
        super(s);
        b = byte0;
        c = m;
        d = m1;
    }

    public final c a(a a1)
    {
        a1 = f.a(a1);
        switch (b)
        {
        default:
            throw new InternalError();

        case 1: // '\001'
            return a1.K();

        case 2: // '\002'
            return a1.F();

        case 3: // '\003'
            return a1.I();

        case 4: // '\004'
            return a1.G();

        case 5: // '\005'
            return a1.E();

        case 6: // '\006'
            return a1.v();

        case 7: // '\007'
            return a1.C();

        case 8: // '\b'
            return a1.u();

        case 9: // '\t'
            return a1.A();

        case 10: // '\n'
            return a1.z();

        case 11: // '\013'
            return a1.x();

        case 12: // '\f'
            return a1.t();

        case 13: // '\r'
            return a1.r();

        case 14: // '\016'
            return a1.p();

        case 15: // '\017'
            return a1.q();

        case 16: // '\020'
            return a1.n();

        case 17: // '\021'
            return a1.m();

        case 18: // '\022'
            return a1.k();

        case 19: // '\023'
            return a1.j();

        case 20: // '\024'
            return a1.h();

        case 21: // '\025'
            return a1.g();

        case 22: // '\026'
            return a1.e();

        case 23: // '\027'
            return a1.d();
        }
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj instanceof e)
            {
                if (b != ((e)obj).b)
                {
                    return false;
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
        return 1 << b;
    }

    public final m x()
    {
        return c;
    }

    public final m y()
    {
        return d;
    }
}
