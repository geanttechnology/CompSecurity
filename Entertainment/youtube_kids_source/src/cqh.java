// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class cqh
    implements Runnable
{

    private Object a;
    private bhv b;
    private cqg c;

    cqh(cqg cqg1, Object obj, bhv bhv1)
    {
        c = cqg1;
        a = obj;
        b = bhv1;
        super();
    }

    public final void run()
    {
        try
        {
            c.a.a(a, b);
            return;
        }
        catch (Exception exception)
        {
            bmo.c("target requester should catch exception and pass to callback.onError");
            b.a(a, exception);
            return;
        }
    }
}
