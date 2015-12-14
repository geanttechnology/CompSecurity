// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


class bub extends bts
{

    final Runnable a;
    final bua b;

    bub(bua bua, Runnable runnable)
    {
        b = bua;
        a = runnable;
        super();
    }

    public void onRun()
    {
        a.run();
    }
}
