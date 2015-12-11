// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.taskexecutor.executor;

import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.taskexecutor.task.Tuple3Task;
import com.comcast.cim.cmasl.taskexecutor.task.Tuple4Task;
import com.comcast.cim.cmasl.taskexecutor.task.TupleTask;
import com.comcast.cim.cmasl.utils.executor.ExecutorFactory;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.cmasl.taskexecutor.executor:
//            DefaultTaskExecutor, TaskExecutor

public class TaskExecutorFactory
{

    private final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory);
    private final ExecutorFactory backgroundExecutorFactory;
    private final Executor foregroundExecutor;

    public TaskExecutorFactory(ExecutorFactory executorfactory, Executor executor)
    {
        backgroundExecutorFactory = executorfactory;
        foregroundExecutor = executor;
    }

    public TaskExecutor create(Task task)
    {
        return new DefaultTaskExecutor(task, backgroundExecutorFactory.create(), foregroundExecutor);
    }

    public TaskExecutor create(Task task, Task task1)
    {
        Executor executor = backgroundExecutorFactory.create();
        return new DefaultTaskExecutor(new TupleTask(task, task1), executor, foregroundExecutor);
    }

    public TaskExecutor create(Task task, Task task1, Task task2)
    {
        Executor executor = backgroundExecutorFactory.create();
        return new DefaultTaskExecutor(new Tuple3Task(task, task1, task2), executor, foregroundExecutor);
    }

    public TaskExecutor create(Task task, Task task1, Task task2, Task task3)
    {
        Executor executor = backgroundExecutorFactory.create();
        return new DefaultTaskExecutor(new Tuple4Task(task, task1, task2, task3), executor, foregroundExecutor);
    }
}
