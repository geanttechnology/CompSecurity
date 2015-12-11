// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bos extends bxi
{

    public String a;
    public String b;
    public String c;

    public bos(bxm bxm, cpj cpj)
    {
        super(bxm, cpj);
        a(bqd.a);
    }

    protected final void a()
    {
        b.a(a);
        b.a(b);
        b.a(c);
    }

    public final String b()
    {
        return "player/heartbeat";
    }

    public final eun d()
    {
        dlu dlu1 = new dlu();
        dlu1.a = h();
        if (dlu1.a.a == null)
        {
            dlu1.a.a = new dhf();
        }
        dlu1.a.a.k = a;
        dlu1.b = b;
        dlu1.c = c;
        return dlu1;
    }
}
