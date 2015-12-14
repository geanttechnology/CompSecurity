// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.snds.api;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

// Referenced classes of package com.amazon.identity.snds.api:
//            UnitTestSafeExecutorService

public class NamedCachedThreadPool
    implements Executor
{

    private final Executor mInnerExecutor;
    private int mThreadNum;

    public NamedCachedThreadPool(final String name)
    {
        mInnerExecutor = new UnitTestSafeExecutorService(Executors.newCachedThreadPool(new ThreadFactory() {

            final NamedCachedThreadPool this$0;
            final String val$name;

            public Thread newThread(Runnable runnable)
            {
                return new Thread(runnable, String.format("%s#%d", new Object[] {
                    name, Integer.valueOf(int i = 
// JavaClassFileOutputException: get_constant: invalid tag

            
            {
                this$0 = NamedCachedThreadPool.this;
                name = s;
                super();
            }
        }));
    }

    public void execute(Runnable runnable)
    {
        mInnerExecutor.execute(runnable);
    }


/*
    static int access$004(NamedCachedThreadPool namedcachedthreadpool)
    {
        int i = namedcachedthreadpool.mThreadNum + 1;
        namedcachedthreadpool.mThreadNum = i;
        return i;
    }

*/
}
