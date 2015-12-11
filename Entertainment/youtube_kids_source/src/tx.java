// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class tx
    implements Runnable
{

    private Exception a;
    private tv b;

    tx(tv tv1, Exception exception)
    {
        b = tv1;
        a = exception;
        super();
    }

    public final void run()
    {
        tv.a(b, a);
    }
}
