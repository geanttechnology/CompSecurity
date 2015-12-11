// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bom extends bxi
{

    private final bxs a;
    private String b;
    private String c;
    private String d;

    bom(bxm bxm, cpj cpj1, bxs bxs1)
    {
        super(bxm, cpj1.b, bxj.b);
        b = "";
        c = "";
        d = "";
        a = (bxs)b.a(bxs1);
    }

    public final bom a(brj brj1)
    {
        c = b(brj1.a);
        a(brj1.b);
        return this;
    }

    public final bom a(String s)
    {
        b = b(s);
        return this;
    }

    protected final void a()
    {
        a(new String[] {
            b, c
        });
    }

    public final String b()
    {
        return "browse";
    }

    public final String c()
    {
        cne cne1 = i();
        cne1.a("browseId", b);
        cne1.a("continuation", c);
        cne1.a("params", d);
        return cne1.a();
    }

    public final eun d()
    {
        dfw dfw1 = new dfw();
        dfw1.a = h();
        dfw1.b = b;
        dfw1.d = c;
        dfw1.c = d;
        dfw1.e = a.a();
        return dfw1;
    }
}
