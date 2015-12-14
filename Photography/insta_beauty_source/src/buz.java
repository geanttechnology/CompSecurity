// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.Executor;

class buz
    implements Executor
{

    private final Executor a;
    private final buy b;

    public buz(Executor executor, buy buy)
    {
        a = executor;
        b = buy;
    }

    static buy a(buz buz1)
    {
        return buz1.b;
    }

    public void execute(Runnable runnable)
    {
        a.execute(new bva(this, runnable, null));
    }
}
