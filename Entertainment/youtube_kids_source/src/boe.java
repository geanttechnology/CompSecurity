// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class boe
    implements mj
{

    private bxi a;
    private mj b;
    private bod c;

    boe(bod bod1, bxi bxi, mj mj1)
    {
        c = bod1;
        a = bxi;
        b = mj1;
        super();
    }

    public final void a(Object obj)
    {
        obj = (eun)obj;
        obj = c.a(((eun) (obj)));
        c.a(a, obj);
        b.a(obj);
    }

    public final void a(mp mp)
    {
        Object obj = c;
        obj = a;
        b.a(mp);
    }
}
