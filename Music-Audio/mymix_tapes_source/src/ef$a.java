// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public static final class e
{

    private int a;
    private String b;
    private String c;
    private ef d;
    private boolean e;

    static void a(String s, String s1)
    {
        if (s.c.equals("INTERNAL_ERROR"))
        {
            s.c = s1;
        } else
        {
            s.c = (new StringBuilder()).append(s.c).append(":").append(s1).toString();
        }
        ef.a(s.d, s);
    }

    protected final int a()
    {
        return a;
    }

    protected final void a(a a1)
    {
        if (c.equals("INTERNAL_ERROR"))
        {
            c = a1.toString();
        } else
        {
            c = (new StringBuilder()).append(c).append(":").append(a1.toString()).toString();
        }
        ef.a(d, this);
    }

    protected final void a(String s)
    {
        b = s;
    }

    protected final String b()
    {
        return b;
    }

    protected final String c()
    {
        return c;
    }

    protected final void d()
    {
        e = true;
    }

    protected final boolean e()
    {
        return e;
    }

    protected >(int i, ef ef1)
    {
        a = i;
        if (ef.e(ef1).f() != null)
        {
            b = dm.a(ef.e(ef1).f());
        } else
        {
            b = "";
        }
        c = "INTERNAL_ERROR";
        d = ef1;
        e = false;
    }
}
