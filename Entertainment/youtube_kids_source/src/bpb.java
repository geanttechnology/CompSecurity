// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bpb
    implements mj
{

    private long a;
    private bxu b;
    private mj c;
    private bpa d;

    public bpb(bpa bpa1, long l, bxu bxu, mj mj1)
    {
        d = bpa1;
        a = l;
        b = bxu;
        c = mj1;
        super();
    }

    public final void a(Object obj)
    {
        obj = (duc)obj;
        obj = new bxb(((duc) (obj)), a, ((bxi) (b)).g, bxb.a(d.h, ((duc) (obj)), a));
        c.a(obj);
    }

    public final void a(mp mp)
    {
        c.a(mp);
    }
}
