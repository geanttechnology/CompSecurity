// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class um
    implements Runnable
{

    private Exception a;
    private uk b;

    um(uk uk1, Exception exception)
    {
        b = uk1;
        a = exception;
        super();
    }

    public final void run()
    {
        if (b.a)
        {
            return;
        } else
        {
            b.c.a(new cse(csf.d, true, b.c.e.a(a), a));
            return;
        }
    }
}
