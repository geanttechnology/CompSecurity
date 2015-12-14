// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import com.amazon.identity.auth.device.utils.UnitTestUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class UnitTestSafeExecutorService
    implements Executor
{

    private final ExecutorService mExecutorService;

    public UnitTestSafeExecutorService(ExecutorService executorservice)
    {
        mExecutorService = executorservice;
    }

    public void execute(Runnable runnable)
    {
        if (UnitTestUtils.isRunningInUnitTest())
        {
            runnable.run();
            return;
        } else
        {
            mExecutorService.execute(runnable);
            return;
        }
    }
}
