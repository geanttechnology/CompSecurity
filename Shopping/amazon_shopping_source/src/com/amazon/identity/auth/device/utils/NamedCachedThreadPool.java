// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import com.amazon.identity.auth.device.framework.UnitTestSafeExecutorService;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            NamedThreadFactory

public class NamedCachedThreadPool
    implements Executor
{

    private final Executor mInnerExecutor;

    public NamedCachedThreadPool(String s)
    {
        mInnerExecutor = new UnitTestSafeExecutorService(Executors.newCachedThreadPool(new NamedThreadFactory(s)));
    }

    public void execute(Runnable runnable)
    {
        mInnerExecutor.execute(runnable);
    }
}
