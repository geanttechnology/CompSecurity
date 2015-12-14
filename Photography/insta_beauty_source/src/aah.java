// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


class aah
    implements Runnable
{

    final Runnable a;
    final aag b;

    aah(aag aag1, Runnable runnable)
    {
        b = aag1;
        a = runnable;
        super();
    }

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
}
