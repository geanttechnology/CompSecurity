// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class o
    implements Runnable
{

    private final ah a;
    private final bg b;
    private final g c;

    o(ah ah1, bg bg1, g g1)
    {
        a = ah1;
        b = bg1;
        c = g1;
    }

    public final void run()
    {
        bc.a("Running metrics flusher to remove stale metrics from memory.");
        if (b.a() || c.c())
        {
            c.d();
            a.a();
        }
    }
}
