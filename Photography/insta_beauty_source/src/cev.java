// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


class cev
    implements Runnable
{

    final Exception a;
    final cet b;

    cev(cet cet1, Exception exception)
    {
        b = cet1;
        a = exception;
        super();
    }

    public void run()
    {
        b.b.a(a);
    }
}
