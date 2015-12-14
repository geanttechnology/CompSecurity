// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class lang.Object
    implements az
{

    private az a;
    private bd b;

    public final void a(Object obj)
    {
        synchronized (bd.a(b))
        {
            bd.b(b);
        }
        a.a(obj);
    }

    public final void b(Object obj)
    {
        a.b(obj);
    }

    public final void c(Object obj)
    {
        synchronized (bd.a(b))
        {
            bd.b(b);
        }
        a.c(obj);
    }

    >(bd bd1, az az1)
    {
        b = bd1;
        a = az1;
        super();
    }
}
