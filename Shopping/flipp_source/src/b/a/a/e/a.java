// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.e;

import b.a.a.i;

// Referenced classes of package b.a.a.e:
//            b

public final class a extends i
{

    private static final int d;
    private final i e;
    private final b f[];

    private a(i j)
    {
        super(j.c);
        f = new b[d + 1];
        e = j;
    }

    public static a a(i j)
    {
        if (j instanceof a)
        {
            return (a)j;
        } else
        {
            return new a(j);
        }
    }

    private b g(long l)
    {
        b b1;
label0:
        {
            int j = (int)(l >> 32);
            b ab[] = f;
            int k = j & d;
            b b2 = ab[k];
            if (b2 != null)
            {
                b1 = b2;
                if ((int)(b2.a >> 32) == j)
                {
                    break label0;
                }
            }
            long l1 = 0xffffffff00000000L & l;
            b1 = new b(e, l1);
            b2 = b1;
            l = l1;
            do
            {
                long l2 = e.e(l);
                if (l2 == l || l2 > (l1 | 0xffffffffL))
                {
                    break;
                }
                b b3 = new b(e, l2);
                b2.c = b3;
                b2 = b3;
                l = l2;
            } while (true);
            ab[k] = b1;
        }
        return b1;
    }

    public final String a(long l)
    {
        b b1 = g(l);
        do
        {
            if (b1.c == null || l < b1.c.a)
            {
                if (b1.d == null)
                {
                    b1.d = b1.b.a(b1.a);
                }
                return b1.d;
            }
            b1 = b1.c;
        } while (true);
    }

    public final int b(long l)
    {
        b b1 = g(l);
        do
        {
            if (b1.c == null || l < b1.c.a)
            {
                if (b1.e == 0x80000000)
                {
                    b1.e = b1.b.b(b1.a);
                }
                return b1.e;
            }
            b1 = b1.c;
        } while (true);
    }

    public final boolean c()
    {
        return e.c();
    }

    public final long e(long l)
    {
        return e.e(l);
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj instanceof a)
        {
            return e.equals(((a)obj).e);
        } else
        {
            return false;
        }
    }

    public final long f(long l)
    {
        return e.f(l);
    }

    public final int hashCode()
    {
        return e.hashCode();
    }

    static 
    {
        Object obj;
        int j;
        try
        {
            obj = Integer.getInteger("org.joda.time.tz.CachedDateTimeZone.size");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
        }
        if (obj == null)
        {
            j = 512;
        } else
        {
            j = ((Integer) (obj)).intValue() - 1;
            int k = 0;
            for (; j > 0; j >>= 1)
            {
                k++;
            }

            j = 1 << k;
        }
        d = j - 1;
    }
}
