// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.e;


public final class i extends b.a.a.i
{

    private final String d;
    private final int e;
    private final int f;

    public i(String s, String s1, int j, int k)
    {
        super(s);
        d = s1;
        e = j;
        f = k;
    }

    public final String a(long l)
    {
        return d;
    }

    public final int b(long l)
    {
        return e;
    }

    public final int c(long l)
    {
        return e;
    }

    public final boolean c()
    {
        return true;
    }

    public final long e(long l)
    {
        return l;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj instanceof i)
            {
                if (!super.c.equals(((b.a.a.i) (obj = (i)obj)).c) || f != ((i) (obj)).f || e != ((i) (obj)).e)
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

    public final long f(long l)
    {
        return l;
    }

    public final int hashCode()
    {
        return super.c.hashCode() + f * 37 + e * 31;
    }
}
