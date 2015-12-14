// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ck extends cm
{

    protected ce a;
    private String e;
    private int f;
    private cj g;
    private String h;
    private String i;
    private int j;

    ck(cj cj1, String s)
    {
        super(s, null, null, cj1.c);
        e = null;
        f = 1;
        h = cj1.b.h;
        i = cj1.b.i;
        j = cj1.b.j;
        a = null;
        b = this;
        g = cj1;
    }

    ck(String s, String s1, String s2, int k, ch ch, String s3)
    {
        super(s3, null, null, ch);
        e = null;
        f = 1;
        h = s1;
        i = s2;
        j = k;
        a = null;
        e = s;
        b = this;
    }

    protected final cw a()
    {
        cw cw = super.a();
        a(cw, "Application", h);
        a(cw, "SchemaVersion", i);
        a(cw, "RetentionDays", new Integer(j));
        return cw;
    }

    public final String b()
    {
        return e;
    }

    protected final void c()
    {
        super.c();
        if (g != null)
        {
            e = g.b();
        }
    }

    public final int d()
    {
        int k = f;
        f = k + 1;
        return k;
    }
}
