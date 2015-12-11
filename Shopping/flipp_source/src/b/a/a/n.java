// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a;


// Referenced classes of package b.a.a:
//            m, f, a, l

final class n extends m
{

    private final byte n;

    n(String s, byte byte0)
    {
        super(s);
        n = byte0;
    }

    public final l a(a a1)
    {
        a1 = f.a(a1);
        switch (n)
        {
        default:
            throw new InternalError();

        case 1: // '\001'
            return a1.J();

        case 2: // '\002'
            return a1.H();

        case 3: // '\003'
            return a1.y();

        case 4: // '\004'
            return a1.D();

        case 5: // '\005'
            return a1.B();

        case 6: // '\006'
            return a1.w();

        case 7: // '\007'
            return a1.s();

        case 8: // '\b'
            return a1.o();

        case 9: // '\t'
            return a1.l();

        case 10: // '\n'
            return a1.i();

        case 11: // '\013'
            return a1.f();

        case 12: // '\f'
            return a1.c();
        }
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj instanceof n)
            {
                if (n != ((n)obj).n)
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
        return 1 << n;
    }
}
