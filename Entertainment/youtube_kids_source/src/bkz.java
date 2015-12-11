// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class bkz
    implements Runnable
{

    private blb a;
    private bkx b;

    bkz(bkx bkx1, blb blb)
    {
        b = bkx1;
        a = blb;
        super();
    }

    public final void run()
    {
        bkx.a(b, a);
    }
}
