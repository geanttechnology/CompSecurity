// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.google.common.util.concurrent:
//            ListeningExecutorService, AbstractListeningExecutorService, ListenableFuture, ListeningScheduledExecutorService, 
//            ListenableFutureTask, ListenableScheduledFuture, AbstractFuture

public final class MoreExecutors
{
    private static class ListeningDecorator extends AbstractListeningExecutorService
    {

        private final ExecutorService _flddelegate;

        public boolean awaitTermination(long l, TimeUnit timeunit)
            throws InterruptedException
        {
            return _flddelegate.awaitTermination(l, timeunit);
        }

        public void execute(Runnable runnable)
        {
            _flddelegate.execute(runnable);
        }

        public boolean isShutdown()
        {
            return _flddelegate.isShutdown();
        }

        public boolean isTerminated()
        {
            return _flddelegate.isTerminated();
        }

        public void shutdown()
        {
            _flddelegate.shutdown();
        }

        public List shutdownNow()
        {
            return _flddelegate.shutdownNow();
        }

        ListeningDecorator(ExecutorService executorservice)
        {
            _flddelegate = (ExecutorService)Preconditions.checkNotNull(executorservice);
        }
    }

    private static class SameThreadExecutorService extends AbstractListeningExecutorService
    {

        private final Lock lock;
        private int runningTasks;
        private boolean shutdown;
        private final Condition termination;

        private void endTask()
        {
            lock.lock();
            runningTasks = runningTasks - 1;
            if (isTerminated())
            {
                termination.signalAll();
            }
            lock.unlock();
            return;
            Exception exception;
            exception;
            lock.unlock();
            throw exception;
        }

        private void startTask()
        {
            lock.lock();
            if (isShutdown())
            {
                throw new RejectedExecutionException("Executor already shutdown");
            }
            break MISSING_BLOCK_LABEL_38;
            Exception exception;
            exception;
            lock.unlock();
            throw exception;
            runningTasks = runningTasks + 1;
            lock.unlock();
            return;
        }

        public boolean awaitTermination(long l, TimeUnit timeunit)
            throws InterruptedException
        {
            l = timeunit.toNanos(l);
            lock.lock();
_L1:
            boolean flag = isTerminated();
            if (flag)
            {
                lock.unlock();
                return true;
            }
            if (l <= 0L)
            {
                lock.unlock();
                return false;
            }
            l = termination.awaitNanos(l);
              goto _L1
            timeunit;
            lock.unlock();
            throw timeunit;
        }

        public void execute(Runnable runnable)
        {
            startTask();
            runnable.run();
            endTask();
            return;
            runnable;
            endTask();
            throw runnable;
        }

        public boolean isShutdown()
        {
            lock.lock();
            boolean flag = shutdown;
            lock.unlock();
            return flag;
            Exception exception;
            exception;
            lock.unlock();
            throw exception;
        }

        public boolean isTerminated()
        {
            lock.lock();
            if (!shutdown) goto _L2; else goto _L1
_L1:
            int i = runningTasks;
            if (i != 0) goto _L2; else goto _L3
_L3:
            boolean flag = true;
_L5:
            lock.unlock();
            return flag;
_L2:
            flag = false;
            if (true) goto _L5; else goto _L4
_L4:
            Exception exception;
            exception;
            lock.unlock();
            throw exception;
        }

        public void shutdown()
        {
            lock.lock();
            shutdown = true;
            lock.unlock();
            return;
            Exception exception;
            exception;
            lock.unlock();
            throw exception;
        }

        public List shutdownNow()
        {
            shutdown();
            return Collections.emptyList();
        }

        private SameThreadExecutorService()
        {
            lock = new ReentrantLock();
            termination = lock.newCondition();
            runningTasks = 0;
            shutdown = false;
        }

    }

    private static class ScheduledListeningDecorator extends ListeningDecorator
        implements ListeningScheduledExecutorService
    {

        final ScheduledExecutorService _flddelegate;

        public ListenableScheduledFuture schedule(Runnable runnable, long l, TimeUnit timeunit)
        {
            runnable = ListenableFutureTask.create(runnable, null);
            return new ListenableScheduledTask(runnable, _flddelegate.schedule(runnable, l, timeunit));
        }

        public ListenableScheduledFuture schedule(Callable callable, long l, TimeUnit timeunit)
        {
            callable = ListenableFutureTask.create(callable);
            return new ListenableScheduledTask(callable, _flddelegate.schedule(callable, l, timeunit));
        }

        public volatile ScheduledFuture schedule(Runnable runnable, long l, TimeUnit timeunit)
        {
            return schedule(runnable, l, timeunit);
        }

        public volatile ScheduledFuture schedule(Callable callable, long l, TimeUnit timeunit)
        {
            return schedule(callable, l, timeunit);
        }

        public ListenableScheduledFuture scheduleAtFixedRate(Runnable runnable, long l, long l1, TimeUnit timeunit)
        {
            runnable = new NeverSuccessfulListenableFutureTask(runnable);
            return new ListenableScheduledTask(runnable, _flddelegate.scheduleAtFixedRate(runnable, l, l1, timeunit));
        }

        public volatile ScheduledFuture scheduleAtFixedRate(Runnable runnable, long l, long l1, TimeUnit timeunit)
        {
            return scheduleAtFixedRate(runnable, l, l1, timeunit);
        }

        public ListenableScheduledFuture scheduleWithFixedDelay(Runnable runnable, long l, long l1, TimeUnit timeunit)
        {
            runnable = new NeverSuccessfulListenableFutureTask(runnable);
            return new ListenableScheduledTask(runnable, _flddelegate.scheduleWithFixedDelay(runnable, l, l1, timeunit));
        }

        public volatile ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long l, long l1, TimeUnit timeunit)
        {
            return scheduleWithFixedDelay(runnable, l, l1, timeunit);
        }

        ScheduledListeningDecorator(ScheduledExecutorService scheduledexecutorservice)
        {
            super(scheduledexecutorservice);
            _flddelegate = (ScheduledExecutorService)Preconditions.checkNotNull(scheduledexecutorservice);
        }
    }

    private static final class ScheduledListeningDecorator.ListenableScheduledTask extends ForwardingListenableFuture.SimpleForwardingListenableFuture
        implements ListenableScheduledFuture
    {

        private final ScheduledFuture scheduledDelegate;

        public boolean cancel(boolean flag)
        {
            boolean flag1 = super.cancel(flag);
            if (flag1)
            {
                scheduledDelegate.cancel(flag);
            }
            return flag1;
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((Delayed)obj);
        }

        public int compareTo(Delayed delayed)
        {
            return scheduledDelegate.compareTo(delayed);
        }

        public long getDelay(TimeUnit timeunit)
        {
            return scheduledDelegate.getDelay(timeunit);
        }

        public ScheduledListeningDecorator.ListenableScheduledTask(ListenableFuture listenablefuture, ScheduledFuture scheduledfuture)
        {
            super(listenablefuture);
            scheduledDelegate = scheduledfuture;
        }
    }

    private static final class ScheduledListeningDecorator.NeverSuccessfulListenableFutureTask extends AbstractFuture
        implements Runnable
    {

        private final Runnable _flddelegate;

        public void run()
        {
            try
            {
                _flddelegate.run();
                return;
            }
            catch (Throwable throwable)
            {
                setException(throwable);
                throw Throwables.propagate(throwable);
            }
        }

        public ScheduledListeningDecorator.NeverSuccessfulListenableFutureTask(Runnable runnable)
        {
            _flddelegate = (Runnable)Preconditions.checkNotNull(runnable);
        }
    }


    private MoreExecutors()
    {
    }

    public static ListeningExecutorService listeningDecorator(ExecutorService executorservice)
    {
        if (executorservice instanceof ListeningExecutorService)
        {
            return (ListeningExecutorService)executorservice;
        }
        if (executorservice instanceof ScheduledExecutorService)
        {
            return new ScheduledListeningDecorator((ScheduledExecutorService)executorservice);
        } else
        {
            return new ListeningDecorator(executorservice);
        }
    }

    public static ListeningExecutorService sameThreadExecutor()
    {
        return new SameThreadExecutorService();
    }

    // Unreferenced inner class com/google/common/util/concurrent/MoreExecutors$1

/* anonymous class */
    static final class _cls1
        implements Runnable
    {

        final ListenableFuture val$future;
        final BlockingQueue val$queue;

        public void run()
        {
            queue.add(future);
        }
    }

}
