// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class alz
    implements bhv
{

    private alw a;
    private bhv b;
    private aly c;

    public alz(aly aly1, alw alw1, bhv bhv1)
    {
        c = aly1;
        a = alw1;
        b = bhv1;
        super();
    }

    public final void a(Object obj, Exception exception)
    {
        c.b.b("Cannot get player response, will return a default descriptor");
        aly.a(c, null, alw.f, b);
    }

    public final void a(Object obj, Object obj1)
    {
        obj = (bxb)obj1;
        aly.a(c, ((bxb) (obj)), a, b);
    }
}
