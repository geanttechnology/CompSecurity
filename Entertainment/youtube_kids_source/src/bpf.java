// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bpf extends bxi
{

    private final bxs a;
    private String b;
    private String c;
    private dkv d;
    private String e;

    bpf(bxm bxm, cpj cpj1, bxs bxs1)
    {
        super(bxm, cpj1.b, bxj.b);
        b = "";
        c = "";
        e = "";
        a = (bxs)b.a(bxs1);
        d = new dkv();
        a(bqd.a);
    }

    public final bpf a(brj brj1)
    {
        c = b(brj1.a);
        a(brj1.b);
        return this;
    }

    public final bpf a(String s)
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
        return "search";
    }

    public final String c()
    {
        cne cne1 = i();
        cne1.a("query", b);
        cne1.a("params", e);
        cne1.a("continuation", c);
        cne1.a("filterOptions", eun.a(d));
        return cne1.a();
    }

    public final eun d()
    {
        dwm dwm1 = new dwm();
        dwm1.a = h();
        dwm1.b = b;
        dwm1.c = e;
        dwm1.e = d;
        dwm1.d = c;
        dwm1.f = a.a();
        return dwm1;
    }
}
