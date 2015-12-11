// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.taskexecutor.listener;

import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;

// Referenced classes of package com.comcast.cim.cmasl.taskexecutor.listener:
//            DeferringTaskExecutionListener, TaskExecutionListener

class val.exception
    implements Runnable
{

    final DeferringTaskExecutionListener this$0;
    final TaskExecutionException val$exception;

    public void run()
    {
        DeferringTaskExecutionListener.access$000(DeferringTaskExecutionListener.this).onError(val$exception);
    }

    ()
    {
        this$0 = final_deferringtaskexecutionlistener;
        val$exception = TaskExecutionException.this;
        super();
    }
}
