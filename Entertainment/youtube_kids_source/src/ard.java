// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ard
    implements Runnable
{

    private Exception a;
    private arc b;

    ard(arc arc1, Exception exception)
    {
        b = arc1;
        a = exception;
        super();
    }

    public final void run()
    {
        b.a.a(a);
    }
}
