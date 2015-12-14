// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


class ang.Object
    implements Runnable
{

    final Runnable a;
    final abm b;

    public void run()
    {
        a.run();
        b.a();
        return;
        Exception exception;
        exception;
        b.a();
        throw exception;
    }

    (abm abm1, Runnable runnable)
    {
        b = abm1;
        a = runnable;
        super();
    }
}
