// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class cze
    implements Runnable
{

    private int a;
    private czd b;

    cze(czd czd1, int i)
    {
        b = czd1;
        a = i;
        super();
    }

    public final void run()
    {
        b.a.c(a);
    }
}
