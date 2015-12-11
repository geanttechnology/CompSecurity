// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.taskexecutor.executor;

import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.cmasl.taskexecutor.executor:
//            TaskExecutor

public class DefaultTaskExecutor
    implements TaskExecutor
{
    private class FetchSecondLevelStaleResult
        implements Runnable
    {

        private final TaskExecutionListener executionListener;
        final DefaultTaskExecutor this$0;

        public void run()
        {
            Object obj;
            try
            {
                obj = task.getSecondLevelStaleResultIfAvailable();
            }
            catch (RuntimeException runtimeexception)
            {
                DefaultTaskExecutor.LOG.error(String.format("Caught exception while retrieving second level stale result, ignoring", new Object[0]), runtimeexception);
                runtimeexception = null;
            }
            foregroundExecutor.execute(((_cls1) (obj)). new Runnable() {

                final FetchSecondLevelStaleResult this$1;
                final Object val$finalResult;

                public void run()
                {
                    if (pendingListeners.contains(executionListener))
                    {
                        if (finalResult != null)
                        {
                            DefaultTaskExecutor.LOG.debug("Calling listener with second level stale result from {}", task);
                            executionListener.onStaleResultAvailable(finalResult);
                        } else
                        {
                            DefaultTaskExecutor.LOG.debug("Second level stale result not available from {}", task);
                        }
                        DefaultTaskExecutor.LOG.debug("Second level stale result fetch complete, fetching up to date result from {}", task);
                        executionListener.onPreAsynchronousExecute();
                        backgroundExecutor.execute(new FetchUpToDateResult(executionListener));
                    }
                }

            
            {
                this$1 = final_fetchsecondlevelstaleresult;
                finalResult = Object.this;
                super();
            }
            });
        }


        private FetchSecondLevelStaleResult(TaskExecutionListener taskexecutionlistener)
        {
            this$0 = DefaultTaskExecutor.this;
            super();
            executionListener = taskexecutionlistener;
        }

    }

    private class FetchUpToDateResult
        implements Runnable
    {

        private final TaskExecutionListener executionListener;
        final DefaultTaskExecutor this$0;

        public void run()
        {
            final RuntimeException finalCaughtException = null;
            Object obj;
            try
            {
                obj = task.execute();
            }
            // Misplaced declaration of an exception variable
            catch (final RuntimeException finalCaughtException)
            {
                DefaultTaskExecutor.LOG.error(String.format("Caught exception while executing task %s", new Object[] {
                    task
                }), finalCaughtException);
                obj = null;
            }
            foregroundExecutor.execute(((_cls1) (obj)). new Runnable() {

                final FetchUpToDateResult this$1;
                final RuntimeException val$finalCaughtException;
                final Object val$finalResult;

                public void run()
                {
label0:
                    {
                        if (pendingListeners.remove(executionListener))
                        {
                            DefaultTaskExecutor.LOG.debug("Up to date result fetch from {} completed", task);
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
                this$1 = final_fetchuptodateresult;
                finalCaughtException = runtimeexception;
                finalResult = Object.this;
                super();
            }
            });
        }


        private FetchUpToDateResult(TaskExecutionListener taskexecutionlistener)
        {
            this$0 = DefaultTaskExecutor.this;
            super();
            executionListener = taskexecutionlistener;
        }

    }


    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor);
    private final Executor backgroundExecutor;
    private final Executor foregroundExecutor;
    private final Set pendingListeners = new HashSet();
    private final Task task;

    public DefaultTaskExecutor(Task task1, Executor executor, Executor executor1)
    {
        task = task1;
        backgroundExecutor = executor;
        foregroundExecutor = executor1;
    }

    public void cancelNotificationsFor(TaskExecutionListener taskexecutionlistener)
    {
        pendingListeners.remove(taskexecutionlistener);
    }

    public TaskExecutionListener execute(TaskExecutionListener taskexecutionlistener)
    {
        Object obj = task.getCachedResultIfAvailable();
        if (obj != null)
        {
            LOG.debug("Result is cached in task {}, calling listener synchronously", task);
            taskexecutionlistener.onPostExecute(obj);
            return taskexecutionlistener;
        }
        obj = task.getStaleResultIfAvailable();
        if (obj == null)
        {
            LOG.debug("Stale result is unavailable from task {}, fetch second level stale result asynchronously", task);
            pendingListeners.add(taskexecutionlistener);
            taskexecutionlistener.onPreAsynchronousExecute();
            backgroundExecutor.execute(new FetchSecondLevelStaleResult(taskexecutionlistener));
            return taskexecutionlistener;
        } else
        {
            LOG.debug("Stale result is available from task {}, calling listener synchronously and fetching up to date result", task);
            taskexecutionlistener.onStaleResultAvailable(obj);
            pendingListeners.add(taskexecutionlistener);
            taskexecutionlistener.onPreAsynchronousExecute();
            backgroundExecutor.execute(new FetchUpToDateResult(taskexecutionlistener));
            return taskexecutionlistener;
        }
    }






}
