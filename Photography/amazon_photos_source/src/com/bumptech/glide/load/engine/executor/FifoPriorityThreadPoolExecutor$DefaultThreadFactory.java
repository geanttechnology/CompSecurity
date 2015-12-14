// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

// Referenced classes of package com.bumptech.glide.load.engine.executor:
//            FifoPriorityThreadPoolExecutor

public static class threadNum
    implements ThreadFactory
{

    int threadNum;

    public Thread newThread(Runnable runnable)
    {
        runnable = new Thread(runnable, (new StringBuilder()).append("fifo-pool-thread-").append(threadNum).toString()) {

            final FifoPriorityThreadPoolExecutor.DefaultThreadFactory this$0;

            public void run()
            {
                Process.setThreadPriority(10);
                super.run();
            }

            
            {
                this$0 = FifoPriorityThreadPoolExecutor.DefaultThreadFactory.this;
                super(runnable, s);
            }
        };
        threadNum = threadNum + 1;
        return runnable;
    }

    public _cls1.this._cls0()
    {
        threadNum = 0;
    }
}
