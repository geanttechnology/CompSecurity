// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.Executor;

final class bkq
    implements Runnable
{

    final bkp a;
    private Executor b;

    bkq(bkp bkp, Executor executor)
    {
        a = bkp;
        b = executor;
        super();
    }

    public final void run()
    {
        b.execute(new bkr(this));
    }
}
