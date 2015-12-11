// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cyt
    implements Comparable
{

    cyu a;
    public long b;
    final cys c;

    cyt(cys cys1, cyu cyu1, long l)
    {
        c = cys1;
        super();
        a = cyu1;
        b = l;
    }

    public final int a(cyt cyt1)
    {
        if (b != cyt1.b)
        {
            return b >= cyt1.b ? 1 : -1;
        }
        if (c.e != cyt1.c.e)
        {
            return cyt1.c.e - c.e;
        }
        if (a.ordinal() != cyt1.a.ordinal())
        {
            return a.ordinal() - cyt1.a.ordinal();
        } else
        {
            return c.d.compareTo(cyt1.c.d);
        }
    }

    public final int compareTo(Object obj)
    {
        return a((cyt)obj);
    }

    public final String toString()
    {
        String s = String.valueOf(a.name());
        long l = b;
        return (new StringBuilder(String.valueOf(s).length() + 21)).append(s).append("@").append(l).toString();
    }
}
