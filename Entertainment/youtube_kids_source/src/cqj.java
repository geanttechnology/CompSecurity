// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class cqj
    implements bhv
{

    private boolean a;
    private bhv b;
    private Object c;
    private cqi d;

    cqj(cqi cqi1, bhv bhv1, Object obj)
    {
        d = cqi1;
        b = bhv1;
        c = obj;
        super();
    }

    public final void a(Object obj, Exception exception)
    {
        b.b();
        if (!a && d.c.a(obj, exception))
        {
            a = true;
            d.b.a();
            d.a.a(obj, this);
            return;
        } else
        {
            b.a(c, exception);
            return;
        }
    }

    public final void a(Object obj, Object obj1)
    {
        b.a(c, obj1);
    }
}
