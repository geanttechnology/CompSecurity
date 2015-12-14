// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class fh
    implements fd
{

    private String a;
    private long b;
    private long c;
    private double d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;

    private fh(String s, long l, long l1, double d1, 
            boolean flag)
    {
        e = true;
        f = false;
        g = false;
        h = false;
        a = s;
        b = l;
        c = l1;
        d = d1;
        e = flag;
        int i;
        if (a.indexOf("\\*no-space-before") != -1)
        {
            g = true;
            i = a.indexOf("\\*no-space-before");
            if (i + 17 == a.length())
            {
                a = a.substring(0, i);
            } else
            {
                a = (new StringBuilder()).append(a.substring(0, i)).append(a.substring(i + 17)).toString();
            }
        }
        if (a.indexOf("\\*no-space-after") != -1)
        {
            h = true;
            i = a.indexOf("\\*no-space-after");
            if (i + 16 == a.length())
            {
                a = a.substring(0, i);
            } else
            {
                a = (new StringBuilder()).append(a.substring(0, i)).append(a.substring(i + 16)).toString();
            }
        }
        if (a.length() != 0 && fr.a(a).length() == 0)
        {
            f = true;
        }
    }

    public fh(String s, long l, long l1, double d1, 
            boolean flag, byte byte0)
    {
        fd.a a1 = fd.a.a;
        this(s, l, l1, d1, flag);
    }

    public final double a()
    {
        return d;
    }

    public final void a(String s)
    {
        a = s;
    }

    public final String b()
    {
        return a;
    }

    public final long c()
    {
        return b;
    }

    public final long d()
    {
        return c;
    }

    public final boolean e()
    {
        return e;
    }

    public final boolean f()
    {
        return f;
    }

    public final boolean g()
    {
        return g;
    }

    public final boolean h()
    {
        return h;
    }

    public final String toString()
    {
        return a;
    }
}
