// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.google.common.util.concurrent:
//            ListeningExecutorService, ListeningScheduledExecutorService, ListenableFuture, ThreadFactoryBuilder, 
//            AbstractListeningExecutorService, TrustedListenableFutureTask, ListenableScheduledFuture, AbstractFuture, 
//            Callables, WrappingExecutorService, WrappingScheduledExecutorService

public final class MoreExecutors
{
    static class Application
    {

        final void addDelayedShutdownHook(final ExecutorService service, final long terminationTimeout, TimeUnit timeunit)
        {
            Preconditions.checkNotNull(service);
            Preconditions.checkNotNull(timeunit);
            String s = String.valueOf(service);
            addShutdownHook(MoreExecutors.newThread((new StringBuilder(String.valueOf(s).length() + 24)).append("DelayedShutdownHook-for-").append(s).toString(), timeunit. new Runnable() {

                final Application this$0;
                final ExecutorService val$service;
                final long val$terminationTimeout;
                final TimeUnit val$timeUnit;

                public void run()
                {
                    try
                    {
                        service.shutdown();
                        service.awaitTermination(terminationTimeout, timeUnit);
                        return;
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        return;
                    }
                }

            
            {
                this$0 = final_application;
                service = executorservice;
                terminationTimeout = l;
                timeUnit = TimeUnit.this;
                super();
            }
            }));
        }

        void addShutdownHook(Thread thread)
        {
            Runtime.getRuntime().addShutdownHook(thread);
        }

        final ExecutorService getExitingExecutorService(ThreadPoolExecutor threadpoolexecutor)
        {
            return getExitingExecutorService(threadpoolexecutor, 120L, TimeUnit.SECONDS);
        }

        final ExecutorService getExitingExecutorService(ThreadPoolExecutor threadpoolexecutor, long l, TimeUnit timeunit)
        {
            MoreExecutors.useDaemonThreadFactory(threadpoolexecutor);
            threadpoolexecutor = Executors.unconfigurableExecutorService(threadpoolexecutor);
            addDelayedShutdownHook(threadpoolexecutor, l, timeunit);
            return threadpoolexecutor;
        }

        final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledthreadpoolexecutor)
        {
            return getExitingScheduledExecutorService(scheduledthreadpoolexecutor, 120L, TimeUnit.SECONDS);
        }

        final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledthreadpoolexecutor, long l, TimeUnit timeunit)
        {
            MoreExecutors.useDaemonThreadFactory(scheduledthreadpoolexecutor);
            scheduledthreadpoolexecutor = Executors.unconfigurableScheduledExecutorService(scheduledthreadpoolexecutor);
            addDelayedShutdownHook(scheduledthreadpoolexecutor, l, timeunit);
            return scheduledthreadpoolexecutor;
        }

        Application()
        {
        }
    }

    private static final class DirectExecutor extends Enum
        implements Executor
    {

        private static final DirectExecutor $VALUES[];
        public static final DirectExecutor INSTANCE;

        public static DirectExecutor valueOf(String s)
        {
            return (DirectExecutor)Enum.valueOf(com/google/common/util/concurrent/MoreExecutors$DirectExecutor, s);
        }

        public static DirectExecutor[] values()
        {
            return (DirectExecutor[])$VALUES.clone();
        }

        public void execute(Runnable runnable)
        {
            runnable.run();
        }

        public String toString()
        {
            return "MoreExecutors.directExecutor()";
        }

        static 
        {
            INSTANCE = new DirectExecutor("INSTANCE", 0);
            $VALUES = (new DirectExecutor[] {
                INSTANCE
            });
        }

        private DirectExecutor(String s, int i)
        {
            super(s, i);
        }
    }

    private static final class DirectExecutorService extends AbstractListeningExecutorService
    {

        private final Object lock;
        private int runningTasks;
        private boolean shutdown;

        private void endTask()
        {
            Object obj = lock;
            obj;
            JVM INSTR monitorenter ;
            int i;
            i = runningTasks - 1;
            runningTasks = i;
            if (i != 0)
            {
                break MISSING_BLOCK_LABEL_30;
            }
            lock.notifyAll();
            obj;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private void startTask()
        {
            Object obj = lock;
            obj;
            JVM INSTR monitorenter ;
            if (shutdown)
            {
                throw new RejectedExecutionException("Executor already shutdown");
            }
            break MISSING_BLOCK_LABEL_29;
            Exception exception;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
            runningTasks = runningTasks + 1;
            obj;
            JVM INSTR monitorexit ;
        }

        public boolean awaitTermination(long l, TimeUnit timeunit)
            throws InterruptedException
        {
            l = timeunit.toNanos(l);
            timeunit = ((TimeUnit) (lock));
            timeunit;
            JVM INSTR monitorenter ;
_L2:
            if (shutdown && runningTasks == 0)
            {
                return true;
            }
            if (l > 0L)
            {
                break MISSING_BLOCK_LABEL_48;
            }
            timeunit;
            JVM INSTR monitorexit ;
            return false;
            Exception exception;
            exception;
            timeunit;
            JVM INSTR monitorexit ;
            throw exception;
            long l1;
            long l2;
            l1 = System.nanoTime();
            TimeUnit.NANOSECONDS.timedWait(lock, l);
            l2 = System.nanoTime();
            l -= l2 - l1;
            if (true) goto _L2; else goto _L1
_L1:
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
            boolean flag;
            synchronized (lock)
            {
                flag = shutdown;
            }
            return flag;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public boolean isTerminated()
        {
            Object obj = lock;
            obj;
            JVM INSTR monitorenter ;
            Exception exception;
            boolean flag;
            if (shutdown && runningTasks == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj;
            JVM INSTR monitorexit ;
            return flag;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void shutdown()
        {
            synchronized (lock)
            {
                shutdown = true;
                if (runningTasks == 0)
                {
                    lock.notifyAll();
                }
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public List shutdownNow()
        {
            shutdown();
            return Collections.emptyList();
        }

        private DirectExecutorService()
        {
            lock = new Object();
            runningTasks = 0;
            shutdown = false;
        }

    }

    private static class ListeningDecorator extends AbstractListeningExecutorService
    {

        private final ExecutorService _flddelegate;

        public final boolean awaitTermination(long l, TimeUnit timeunit)
            throws InterruptedException
        {
            return _flddelegate.awaitTermination(l, timeunit);
        }

        public final void execute(Runnable runnable)
        {
            _flddelegate.execute(runnable);
        }

        public final boolean isShutdown()
        {
            return _flddelegate.isShutdown();
        }

        public final boolean isTerminated()
        {
            return _flddelegate.isTerminated();
        }

        public final void shutdown()
        {
            _flddelegate.shutdown();
        }

        public final List shutdownNow()
        {
            return _flddelegate.shutdownNow();
        }

        ListeningDecorator(ExecutorService executorservice)
        {
            _flddelegate = (ExecutorService)Preconditions.checkNotNull(executorservice);
        }
    }

    private static final class ScheduledListeningDecorator extends ListeningDecorator
        implements ListeningScheduledExecutorService
    {

        final ScheduledExecutorService _flddelegate;

        public ListenableScheduledFuture schedule(Runnable runnable, long l, TimeUnit timeunit)
        {
            runnable = TrustedListenableFutureTask.create(runnable, null);
            return new ListenableScheduledTask(runnable, _flddelegate.schedule(runnable, l, timeunit));
        }

        public ListenableScheduledFuture schedule(Callable callable, long l, TimeUnit timeunit)
        {
            callable = TrustedListenableFutureTask.create(callable);
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

    public static void addDelayedShutdownHook(ExecutorService executorservice, long l, TimeUnit timeunit)
    {
        (new Application()).addDelayedShutdownHook(executorservice, l, timeunit);
    }

    public static Executor directExecutor()
    {
        return DirectExecutor.INSTANCE;
    }

    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor threadpoolexecutor)
    {
        return (new Application()).getExitingExecutorService(threadpoolexecutor);
    }

    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor threadpoolexecutor, long l, TimeUnit timeunit)
    {
        return (new Application()).getExitingExecutorService(threadpoolexecutor, l, timeunit);
    }

    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledthreadpoolexecutor)
    {
        return (new Application()).getExitingScheduledExecutorService(scheduledthreadpoolexecutor);
    }

    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledthreadpoolexecutor, long l, TimeUnit timeunit)
    {
        return (new Application()).getExitingScheduledExecutorService(scheduledthreadpoolexecutor, l, timeunit);
    }

    static Object invokeAnyImpl(ListeningExecutorService listeningexecutorservice, Collection collection, boolean flag, long l)
        throws InterruptedException, ExecutionException, TimeoutException
    {
        Future future;
        java.util.ArrayList arraylist;
        java.util.concurrent.LinkedBlockingQueue linkedblockingqueue;
        int i;
        int j;
        int k;
        int i1;
        long l1;
        long l2;
        long l3;
        Preconditions.checkNotNull(listeningexecutorservice);
        i = collection.size();
        Future future1;
        Iterator iterator;
        boolean flag1;
        if (i > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Preconditions.checkArgument(flag1);
        arraylist = Lists.newArrayListWithCapacity(i);
        linkedblockingqueue = Queues.newLinkedBlockingQueue();
        if (!flag) goto _L2; else goto _L1
_L1:
        l1 = System.nanoTime();
_L9:
        iterator = collection.iterator();
        arraylist.add(submitAndAddQueueListener(listeningexecutorservice, (Callable)iterator.next(), linkedblockingqueue));
        i1 = i - 1;
        i = 1;
        collection = null;
_L16:
        future1 = (Future)linkedblockingqueue.poll();
        j = i;
        future = future1;
        l2 = l1;
        k = i1;
        l3 = l;
        if (future1 != null) goto _L4; else goto _L3
_L3:
        if (i1 <= 0) goto _L6; else goto _L5
_L5:
        k = i1 - 1;
        arraylist.add(submitAndAddQueueListener(listeningexecutorservice, (Callable)iterator.next(), linkedblockingqueue));
        j = i + 1;
        l3 = l;
        l2 = l1;
        future = future1;
_L4:
        if (future == null) goto _L8; else goto _L7
_L7:
        i = j - 1;
        collection = ((Collection) (future.get()));
        break MISSING_BLOCK_LABEL_197;
_L2:
        l1 = 0L;
          goto _L9
_L6:
        if (i != 0) goto _L11; else goto _L10
_L10:
        if (collection != null) goto _L13; else goto _L12
_L12:
        listeningexecutorservice = new ExecutionException(null);
_L15:
        throw listeningexecutorservice;
        listeningexecutorservice;
          goto _L14
_L11:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_360;
        }
        future = (Future)linkedblockingqueue.poll(l, TimeUnit.NANOSECONDS);
        if (future != null)
        {
            break MISSING_BLOCK_LABEL_335;
        }
        throw new TimeoutException();
        l2 = System.nanoTime();
        l3 = l - (l2 - l1);
        j = i;
        k = i1;
          goto _L4
        future = (Future)linkedblockingqueue.take();
        j = i;
        l2 = l1;
        k = i1;
        l3 = l;
          goto _L4
        collection;
        collection = new ExecutionException(collection);
        break MISSING_BLOCK_LABEL_424;
_L14:
        for (collection = arraylist.iterator(); collection.hasNext(); ((Future)collection.next()).cancel(true)) { }
        throw listeningexecutorservice;
        for (listeningexecutorservice = arraylist.iterator(); listeningexecutorservice.hasNext(); ((Future)listeningexecutorservice.next()).cancel(true)) { }
        return collection;
_L13:
        listeningexecutorservice = collection;
          goto _L15
_L8:
        i = j;
        break MISSING_BLOCK_LABEL_424;
        listeningexecutorservice;
          goto _L14
        collection;
        l1 = l2;
        i1 = k;
        l = l3;
          goto _L16
    }

    private static boolean isAppEngine()
    {
        if (System.getProperty("com.google.appengine.runtime.environment") != null)
        {
            Object obj;
            try
            {
                obj = Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", new Class[0]).invoke(null, new Object[0]);
            }
            catch (ClassNotFoundException classnotfoundexception)
            {
                return false;
            }
            catch (InvocationTargetException invocationtargetexception)
            {
                return false;
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                return false;
            }
            catch (NoSuchMethodException nosuchmethodexception)
            {
                return false;
            }
            if (obj != null)
            {
                return true;
            }
        }
        return false;
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

    public static ListeningScheduledExecutorService listeningDecorator(ScheduledExecutorService scheduledexecutorservice)
    {
        if (scheduledexecutorservice instanceof ListeningScheduledExecutorService)
        {
            return (ListeningScheduledExecutorService)scheduledexecutorservice;
        } else
        {
            return new ScheduledListeningDecorator(scheduledexecutorservice);
        }
    }

    public static ListeningExecutorService newDirectExecutorService()
    {
        return new DirectExecutorService();
    }

    static Thread newThread(String s, Runnable runnable)
    {
        Preconditions.checkNotNull(s);
        Preconditions.checkNotNull(runnable);
        runnable = platformThreadFactory().newThread(runnable);
        try
        {
            runnable.setName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return runnable;
        }
        return runnable;
    }

    public static ThreadFactory platformThreadFactory()
    {
        if (!isAppEngine())
        {
            return Executors.defaultThreadFactory();
        }
        ThreadFactory threadfactory;
        try
        {
            threadfactory = (ThreadFactory)Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", new Class[0]).invoke(null, new Object[0]);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", illegalaccessexception);
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", classnotfoundexception);
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", nosuchmethodexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw Throwables.propagate(invocationtargetexception.getCause());
        }
        return threadfactory;
    }

    static Executor renamingDecorator(Executor executor, Supplier supplier)
    {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(supplier);
        if (isAppEngine())
        {
            return executor;
        } else
        {
            return new Executor(executor, supplier) {

                final Executor val$executor;
                final Supplier val$nameSupplier;

                public void execute(Runnable runnable)
                {
                    executor.execute(Callables.threadRenaming(runnable, nameSupplier));
                }

            
            {
                executor = executor1;
                nameSupplier = supplier;
                super();
            }
            };
        }
    }

    static ExecutorService renamingDecorator(ExecutorService executorservice, Supplier supplier)
    {
        Preconditions.checkNotNull(executorservice);
        Preconditions.checkNotNull(supplier);
        if (isAppEngine())
        {
            return executorservice;
        } else
        {
            return new WrappingExecutorService(executorservice, supplier) {

                final Supplier val$nameSupplier;

                protected Runnable wrapTask(Runnable runnable)
                {
                    return Callables.threadRenaming(runnable, nameSupplier);
                }

                protected Callable wrapTask(Callable callable)
                {
                    return Callables.threadRenaming(callable, nameSupplier);
                }

            
            {
                nameSupplier = supplier;
                super(executorservice);
            }
            };
        }
    }

    static ScheduledExecutorService renamingDecorator(ScheduledExecutorService scheduledexecutorservice, Supplier supplier)
    {
        Preconditions.checkNotNull(scheduledexecutorservice);
        Preconditions.checkNotNull(supplier);
        if (isAppEngine())
        {
            return scheduledexecutorservice;
        } else
        {
            return new WrappingScheduledExecutorService(scheduledexecutorservice, supplier) {

                final Supplier val$nameSupplier;

                protected Runnable wrapTask(Runnable runnable)
                {
                    return Callables.threadRenaming(runnable, nameSupplier);
                }

                protected Callable wrapTask(Callable callable)
                {
                    return Callables.threadRenaming(callable, nameSupplier);
                }

            
            {
                nameSupplier = supplier;
                super(scheduledexecutorservice);
            }
            };
        }
    }

    public static ListeningExecutorService sameThreadExecutor()
    {
        return new DirectExecutorService();
    }

    public static boolean shutdownAndAwaitTermination(ExecutorService executorservice, long l, TimeUnit timeunit)
    {
        Preconditions.checkNotNull(timeunit);
        executorservice.shutdown();
        try
        {
            l = TimeUnit.NANOSECONDS.convert(l, timeunit) / 2L;
            if (!executorservice.awaitTermination(l, TimeUnit.NANOSECONDS))
            {
                executorservice.shutdownNow();
                executorservice.awaitTermination(l, TimeUnit.NANOSECONDS);
            }
        }
        // Misplaced declaration of an exception variable
        catch (TimeUnit timeunit)
        {
            Thread.currentThread().interrupt();
            executorservice.shutdownNow();
        }
        return executorservice.isTerminated();
    }

    private static ListenableFuture submitAndAddQueueListener(ListeningExecutorService listeningexecutorservice, Callable callable, BlockingQueue blockingqueue)
    {
        listeningexecutorservice = listeningexecutorservice.submit(callable);
        listeningexecutorservice.addListener(new Runnable(blockingqueue, listeningexecutorservice) {

            final ListenableFuture val$future;
            final BlockingQueue val$queue;

            public void run()
            {
                queue.add(future);
            }

            
            {
                queue = blockingqueue;
                future = listenablefuture;
                super();
            }
        }, directExecutor());
        return listeningexecutorservice;
    }

    private static void useDaemonThreadFactory(ThreadPoolExecutor threadpoolexecutor)
    {
        threadpoolexecutor.setThreadFactory((new ThreadFactoryBuilder()).setDaemon(true).setThreadFactory(threadpoolexecutor.getThreadFactory()).build());
    }

}
