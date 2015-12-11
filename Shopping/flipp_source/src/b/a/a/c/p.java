// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.c;

import b.a.a.l;
import b.a.a.m;

// Referenced classes of package b.a.a.c:
//            e, c

public final class p extends e
{

    private final int b = 100;

    public p(l l1, m m)
    {
        super(l1, m);
    }

    public final long a(long l1, int i)
    {
        long l2 = i;
        long l3 = b;
        return super.a.a(l1, l2 * l3);
    }

    public final long a(long l1, long l2)
    {
        int i;
        long l3;
        i = b;
        l3 = l2;
        i;
        JVM INSTR tableswitch -1 1: default 36
    //                   -1 88
    //                   0 145
    //                   1 134;
           goto _L1 _L2 _L3 _L4
_L4:
        break; /* Loop/switch isn't completed */
_L1:
        l3 = (long)i * l2;
        if (l3 / (long)i != l2)
        {
            throw new ArithmeticException((new StringBuilder("Multiplication overflows a long: ")).append(l2).append(" * ").append(i).toString());
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (l2 == 0x8000000000000000L)
        {
            throw new ArithmeticException((new StringBuilder("Multiplication overflows a long: ")).append(l2).append(" * ").append(i).toString());
        }
        l3 = -l2;
_L6:
        return super.a.a(l1, l3);
_L3:
        l3 = 0L;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final int b(long l1, long l2)
    {
        return super.a.b(l1, l2) / b;
    }

    public final long c(long l1, long l2)
    {
        return super.a.c(l1, l2) / (long)b;
    }

    public final long d()
    {
        return super.a.d() * (long)b;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj instanceof p)
            {
                if (!super.a.equals(((e) (obj = (p)obj)).a) || super.d != ((c) (obj)).d || b != ((p) (obj)).b)
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
        long l1 = b;
        return (int)(l1 ^ l1 >>> 32) + super.d.hashCode() + super.a.hashCode();
    }
}
