// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


class aic
    implements Runnable
{

    final aib a;
    private Runnable b;
    private aib c;

    public aic(aib aib1, Runnable runnable, aib aib2)
    {
        a = aib1;
        super();
        b = runnable;
        c = aib2;
    }

    public void run()
    {
        b.run();
        c.b(b);
    }
}
