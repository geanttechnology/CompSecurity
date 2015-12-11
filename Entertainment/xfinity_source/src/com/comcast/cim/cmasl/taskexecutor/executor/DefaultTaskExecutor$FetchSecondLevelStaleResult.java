// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.taskexecutor.executor;

import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import java.util.Set;
import java.util.concurrent.Executor;
import org.slf4j.Logger;

// Referenced classes of package com.comcast.cim.cmasl.taskexecutor.executor:
//            DefaultTaskExecutor

private class <init>
    implements Runnable
{

    private final TaskExecutionListener executionListener;
    final DefaultTaskExecutor this$0;

    public void run()
    {
        final Object finalResult;
        try
        {
            finalResult = DefaultTaskExecutor.access$200(DefaultTaskExecutor.this).getSecondLevelStaleResultIfAvailable();
        }
        catch (RuntimeException runtimeexception)
        {
            DefaultTaskExecutor.access$300().error(String.format("Caught exception while retrieving second level stale result, ignoring", new Object[0]), runtimeexception);
            runtimeexception = null;
        }
        DefaultTaskExecutor.access$700(DefaultTaskExecutor.this).execute(new Runnable() {

            final DefaultTaskExecutor.FetchSecondLevelStaleResult this$1;
            final Object val$finalResult;

            public void run()
            {
                if (DefaultTaskExecutor.access$500(this$0).contains(executionListener))
                {
                    if (finalResult != null)
                    {
                        DefaultTaskExecutor.access$300().debug("Calling listener with second level stale result from {}", DefaultTaskExecutor.access$200(this$0));
                        executionListener.onStaleResultAvailable(finalResult);
                    } else
                    {
                        DefaultTaskExecutor.access$300().debug("Second level stale result not available from {}", DefaultTaskExecutor.access$200(this$0));
                    }
                    DefaultTaskExecutor.access$300().debug("Second level stale result fetch complete, fetching up to date result from {}", DefaultTaskExecutor.access$200(this$0));
                    executionListener.onPreAsynchronousExecute();
                    DefaultTaskExecutor.access$600(this$0).execute(new DefaultTaskExecutor.FetchUpToDateResult(this$0, executionListener, null));
                }
            }

            
            {
                this$1 = DefaultTaskExecutor.FetchSecondLevelStaleResult.this;
                finalResult = obj;
                super();
            }
        });
    }


    private _cls1.val.finalResult(TaskExecutionListener taskexecutionlistener)
    {
        this$0 = DefaultTaskExecutor.this;
        super();
        executionListener = taskexecutionlistener;
    }

    executionListener(TaskExecutionListener taskexecutionlistener, executionListener executionlistener)
    {
        this(taskexecutionlistener);
    }
}
