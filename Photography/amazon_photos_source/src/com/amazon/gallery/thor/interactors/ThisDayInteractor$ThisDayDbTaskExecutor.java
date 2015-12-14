// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.interactors;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.thread.NamedThreadFactory;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.gallery.thor.interactors:
//            ThisDayInteractor

private static class LE
{

    private byte activeTasksMask;
    private final ThreadPoolExecutor delegateExecutor;
    private Map pendingTasksQueueMap;

    private boolean isTaskTypeActive(LE le)
    {
        return (activeTasksMask >> le.activeTasksMask() & 1) != 0;
    }

    private void scheduleNextTaskFromQueue(activeTasksMask activetasksmask)
    {
        this;
        JVM INSTR monitorenter ;
        Runnable runnable = (Runnable)((Queue)pendingTasksQueueMap.get(activetasksmask)).poll();
        if (runnable == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        delegateExecutor.execute(runnable);
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        activetasksmask;
        GLogger.d(ThisDayInteractor.access$600(), "Task not run since ThisDayActivity has been destroyed", new Object[0]);
          goto _L1
        activetasksmask;
        throw activetasksmask;
        setTaskTypeStatus(activetasksmask, false);
          goto _L1
    }

    private boolean setTaskTypeActive(setTaskTypeStatus settasktypestatus)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        if (isTaskTypeActive(settasktypestatus))
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        setTaskTypeStatus(settasktypestatus, true);
        this;
        JVM INSTR monitorexit ;
        return flag;
        settasktypestatus;
        throw settasktypestatus;
    }

    private void setTaskTypeStatus(setTaskTypeStatus settasktypestatus, boolean flag)
    {
        if (flag)
        {
            activeTasksMask = (byte)(activeTasksMask | 1 << settasktypestatus.activeTasksMask());
            return;
        } else
        {
            activeTasksMask = (byte)(activeTasksMask & ~(1 << settasktypestatus.activeTasksMask()));
            return;
        }
    }

    public void execute(activeTasksMask activetasksmask)
    {
        activeTasksMask activetasksmask1 = activetasksmask.getTaskType();
        if (setTaskTypeActive(activetasksmask1))
        {
            try
            {
                delegateExecutor.execute(activetasksmask);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (activeTasksMask activetasksmask)
            {
                GLogger.d(ThisDayInteractor.access$600(), "Task not run since ThisDayActivity has been destroyed", new Object[0]);
            }
            return;
        } else
        {
            ((Queue)pendingTasksQueueMap.get(activetasksmask1)).add(activetasksmask);
            return;
        }
    }

    public void shutdown()
    {
        delegateExecutor.shutdownNow();
    }


    _cls1.this._cls0()
    {
        activeTasksMask = 0;
        delegateExecutor = new ThreadPoolExecutor(3, 4, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new NamedThreadFactory(com/amazon/gallery/thor/interactors/ThisDayInteractor$ThisDayDbTaskExecutor.getSimpleName())) {

            final ThisDayInteractor.ThisDayDbTaskExecutor this$0;

            protected void afterExecute(Runnable runnable, Throwable throwable)
            {
                super.afterExecute(runnable, throwable);
                runnable = ((ThisDayInteractor.ThisDayDataLoaderTask)runnable).getTaskType();
                scheduleNextTaskFromQueue(runnable);
            }

            
            {
                this$0 = ThisDayInteractor.ThisDayDbTaskExecutor.this;
                super(i, j, l, timeunit, blockingqueue, threadfactory);
            }
        };
        pendingTasksQueueMap = new HashMap();
        pendingTasksQueueMap.put(AY, new ArrayDeque());
        pendingTasksQueueMap.put(EEK, new ArrayDeque());
        pendingTasksQueueMap.put(E, new ArrayDeque());
        pendingTasksQueueMap.put(LE, new ArrayDeque());
    }
}
