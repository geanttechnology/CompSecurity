// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package commonlib.service;

import java.util.concurrent.Callable;

// Referenced classes of package commonlib.service:
//            WakeLockExecutorService

class val.result
    implements Callable
{

    final WakeLockExecutorService this$0;
    final Object val$result;
    final Runnable val$task;

    public Object call()
        throws Exception
    {
        val$task.run();
        return val$result;
    }

    ()
    {
        this$0 = final_wakelockexecutorservice;
        val$task = runnable;
        val$result = Object.this;
        super();
    }
}
