// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class rq
    implements Runnable
{

    private rp a;

    rq(rp rp1, rl rl)
    {
        a = rp1;
        super();
    }

    public final void run()
    {
        rp.a(a);
    }
}
