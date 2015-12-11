// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.g.a;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

// Referenced classes of package com.google.a.g.a:
//            j, e

public final class k extends FutureTask
    implements j
{

    private final e a;

    private k(Runnable runnable, Object obj)
    {
        super(runnable, obj);
        a = new e();
    }

    private k(Callable callable)
    {
        super(callable);
        a = new e();
    }

    public static k a(Runnable runnable, Object obj)
    {
        return new k(runnable, obj);
    }

    public static k a(Callable callable)
    {
        return new k(callable);
    }

    public final void a(Runnable runnable, Executor executor)
    {
        a.a(runnable, executor);
    }

    protected final void done()
    {
        a.a();
    }
}
