// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class bia
    implements Runnable
{

    private Runnable a;
    private bhz b;

    bia(bhz bhz1, Runnable runnable)
    {
        b = bhz1;
        a = runnable;
        super();
    }

    public final void run()
    {
        a.run();
        bhz.a(b);
        return;
        Exception exception;
        exception;
        bhz.a(b);
        throw exception;
    }
}
