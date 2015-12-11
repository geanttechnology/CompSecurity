// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.taskexecutor.executor;

import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
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
        final RuntimeException finalCaughtException = null;
        final Object finalResult;
        try
        {
            finalResult = DefaultTaskExecutor.access$200(DefaultTaskExecutor.this).execute();
        }
        // Misplaced declaration of an exception variable
        catch (final RuntimeException finalCaughtException)
        {
            DefaultTaskExecutor.access$300().error(String.format("Caught exception while executing task %s", new Object[] {
                DefaultTaskExecutor.access$200(DefaultTaskExecutor.this)
            }), finalCaughtException);
            finalResult = null;
        }
        DefaultTaskExecutor.access$700(DefaultTaskExecutor.this).execute(new Runnable() {

            final DefaultTaskExecutor.FetchUpToDateResult this$1;
            final RuntimeException val$finalCaughtException;
            final Object val$finalResult;

            public void run()
            {
label0:
                {
                    if (DefaultTaskExecutor.access$500(this$0).remove(executionListener))
                    {
                        DefaultTaskExecutor.access$300().debug("Up to date result fetch from {} completed", DefaultTaskExecutor.access$200(this$0));
                        if (finalCaughtException == null)
                        {
                            break label0;
                        }
                        TaskExecutionListener taskexecutionlistener = executionListener;
                        TaskExecutionException taskexecutionexception;
                        if (finalCaughtException instanceof TaskExecutionException)
                        {
                            taskexecutionexception = (TaskExecutionException)finalCaughtException;
                        } else
                        {
                            taskexecutionexception = new TaskExecutionException(finalCaughtException);
                        }
                        taskexecutionlistener.onError(taskexecutionexception);
                    }
                    return;
                }
                executionListener.onPostExecute(finalResult);
            }

            
            {
                this$1 = DefaultTaskExecutor.FetchUpToDateResult.this;
                finalCaughtException = runtimeexception;
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
