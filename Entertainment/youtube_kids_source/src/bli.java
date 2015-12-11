// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bli
    implements Runnable
{

    private amv a;
    private blf b;

    public bli(blf blf1, amv amv)
    {
        b = blf1;
        a = amv;
        super();
    }

    public final void run()
    {
        b.a(a);
    }
}
