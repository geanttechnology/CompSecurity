// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class qy
    implements Runnable
{

    private Runnable a;
    private qx b;

    qy(qx qx1, Runnable runnable)
    {
        b = qx1;
        a = runnable;
        super();
    }

    public final void run()
    {
        a.run();
        qx.a(b);
        return;
        Exception exception;
        exception;
        qx.a(b);
        throw exception;
    }
}
