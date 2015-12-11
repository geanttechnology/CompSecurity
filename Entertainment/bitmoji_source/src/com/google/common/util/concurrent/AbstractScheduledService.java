// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.google.common.util.concurrent:
//            Service, AbstractService, MoreExecutors, ForwardingFuture

public abstract class AbstractScheduledService
    implements Service
{
    class _cls1ThreadFactoryImpl
        implements ThreadFactory
    {

        final AbstractScheduledService this$0;

        public Thread newThread(Runnable runnable)
        {
            return MoreExecutors.newThread(serviceName(), runnable);
        }

        _cls1ThreadFactoryImpl()
        {
            this$0 = AbstractScheduledService.this;
            super();
        }
    }

    public static abstract class CustomScheduler extends Scheduler
    {

        protected abstract Schedule getNextSchedule()
            throws Exception;

        final Future schedule(AbstractService abstractservice, ScheduledExecutorService scheduledexecutorservice, Runnable runnable)
        {
            abstractservice = new ReschedulableCallable(abstractservice, scheduledexecutorservice, runnable);
            abstractservice.reschedule();
            return abstractservice;
        }

        public CustomScheduler()
        {
        }
    }

    private class CustomScheduler.ReschedulableCallable extends ForwardingFuture
        implements Callable
    {

        private Future currentFuture;
        private final ScheduledExecutorService executor;
        private final ReentrantLock lock = new ReentrantLock();
        private final AbstractService service;
        final CustomScheduler this$0;
        private final Runnable wrappedRunnable;

        public volatile Object call()
            throws Exception
        {
            return call();
        }

        public Void call()
            throws Exception
        {
            wrappedRunnable.run();
            reschedule();
            return null;
        }

        public boolean cancel(boolean flag)
        {
            lock.lock();
            flag = currentFuture.cancel(flag);
            lock.unlock();
            return flag;
            Exception exception;
            exception;
            lock.unlock();
            throw exception;
        }

        protected volatile Object _mthdelegate()
        {
            return _mthdelegate();
        }

        protected Future _mthdelegate()
        {
            throw new UnsupportedOperationException("Only cancel and isCancelled is supported by this future");
        }

        public boolean isCancelled()
        {
            lock.lock();
            boolean flag = currentFuture.isCancelled();
            lock.unlock();
            return flag;
            Exception exception;
            exception;
            lock.unlock();
            throw exception;
        }

        public void reschedule()
        {
            Throwable throwable;
            CustomScheduler.Schedule schedule;
            try
            {
                schedule = getNextSchedule();
            }
            catch (Throwable throwable1)
            {
                service.notifyFailed(throwable1);
                return;
            }
            throwable = null;
            lock.lock();
            if (currentFuture == null || !currentFuture.isCancelled())
            {
                currentFuture = executor.schedule(this, schedule.delay, schedule.unit);
            }
            lock.unlock();
_L2:
            if (throwable != null)
            {
                service.notifyFailed(throwable);
            }
            return;
            throwable1;
            lock.unlock();
            if (true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            lock.unlock();
            throw exception;
        }

        CustomScheduler.ReschedulableCallable(AbstractService abstractservice, ScheduledExecutorService scheduledexecutorservice, Runnable runnable)
        {
            this$0 = CustomScheduler.this;
            super();
            wrappedRunnable = runnable;
            executor = scheduledexecutorservice;
            service = abstractservice;
        }
    }

    protected static final class CustomScheduler.Schedule
    {

        private final long delay;
        private final TimeUnit unit;



        public CustomScheduler.Schedule(long l, TimeUnit timeunit)
        {
            delay = l;
            unit = (TimeUnit)Preconditions.checkNotNull(timeunit);
        }
    }

    public static abstract class Scheduler
    {

        public static Scheduler newFixedDelaySchedule(long l, long l1, TimeUnit timeunit)
        {
            Preconditions.checkNotNull(timeunit);
            boolean flag;
            if (l1 > 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "delay must be > 0, found %s", new Object[] {
                Long.valueOf(l1)
            });
            return new Scheduler(l, l1, timeunit) {

                final long val$delay;
                final long val$initialDelay;
                final TimeUnit val$unit;

                public Future schedule(AbstractService abstractservice, ScheduledExecutorService scheduledexecutorservice, Runnable runnable)
                {
                    return scheduledexecutorservice.scheduleWithFixedDelay(runnable, initialDelay, delay, unit);
                }

            
            {
                initialDelay = l;
                delay = l1;
                unit = timeunit;
                super();
            }
            };
        }

        public static Scheduler newFixedRateSchedule(long l, long l1, TimeUnit timeunit)
        {
            Preconditions.checkNotNull(timeunit);
            boolean flag;
            if (l1 > 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "period must be > 0, found %s", new Object[] {
                Long.valueOf(l1)
            });
            return new Scheduler(l, l1, timeunit) {

                final long val$initialDelay;
                final long val$period;
                final TimeUnit val$unit;

                public Future schedule(AbstractService abstractservice, ScheduledExecutorService scheduledexecutorservice, Runnable runnable)
                {
                    return scheduledexecutorservice.scheduleAtFixedRate(runnable, initialDelay, period, unit);
                }

            
            {
                initialDelay = l;
                period = l1;
                unit = timeunit;
                super();
            }
            };
        }

        abstract Future schedule(AbstractService abstractservice, ScheduledExecutorService scheduledexecutorservice, Runnable runnable);

        private Scheduler()
        {
        }

    }

    private final class ServiceDelegate extends AbstractService
    {

        private volatile ScheduledExecutorService executorService;
        private final ReentrantLock lock;
        private volatile Future runningTask;
        private final Runnable task;
        final AbstractScheduledService this$0;

        protected final void doStart()
        {
            executorService = MoreExecutors.renamingDecorator(executor(), new Supplier() {

                final ServiceDelegate this$1;

                public volatile Object get()
                {
                    return get();
                }

                public String get()
                {
                    String s = serviceName();
                    String s1 = String.valueOf(state());
                    return (new StringBuilder(String.valueOf(s).length() + 1 + String.valueOf(s1).length())).append(s).append(" ").append(s1).toString();
                }

            
            {
                this$1 = ServiceDelegate.this;
                super();
            }
            });
            executorService.execute(new Runnable() {

                final ServiceDelegate this$1;

                public void run()
                {
                    lock.lock();
                    startUp();
                    runningTask = scheduler().schedule(_flddelegate, executorService, task);
                    notifyStarted();
                    lock.unlock();
                    return;
                    Object obj;
                    obj;
                    notifyFailed(((Throwable) (obj)));
                    if (runningTask != null)
                    {
                        runningTask.cancel(false);
                    }
                    lock.unlock();
                    return;
                    obj;
                    lock.unlock();
                    throw obj;
                }

            
            {
                this$1 = ServiceDelegate.this;
                super();
            }
            });
        }

        protected final void doStop()
        {
            runningTask.cancel(false);
            executorService.execute(new Runnable() {

                final ServiceDelegate this$1;

                public void run()
                {
                    lock.lock();
                    Service.State state1;
                    Service.State state2;
                    state1 = state();
                    state2 = Service.State.STOPPING;
                    if (state1 != state2)
                    {
                        try
                        {
                            lock.unlock();
                            return;
                        }
                        catch (Throwable throwable)
                        {
                            notifyFailed(throwable);
                        }
                        break MISSING_BLOCK_LABEL_75;
                    }
                    shutDown();
                    lock.unlock();
                    notifyStopped();
                    return;
                    return;
                    Exception exception;
                    exception;
                    lock.unlock();
                    throw exception;
                }

            
            {
                this$1 = ServiceDelegate.this;
                super();
            }
            });
        }

        public String toString()
        {
            return AbstractScheduledService.this.toString();
        }




/*
        static Future access$302(ServiceDelegate servicedelegate, Future future)
        {
            servicedelegate.runningTask = future;
            return future;
        }

*/



        private ServiceDelegate()
        {
            this$0 = AbstractScheduledService.this;
            super();
            lock = new ReentrantLock();
            task = new Task();
        }

    }

    class ServiceDelegate.Task
        implements Runnable
    {

        final ServiceDelegate this$1;

        public void run()
        {
            lock.lock();
            boolean flag = runningTask.isCancelled();
            if (flag)
            {
                lock.unlock();
                return;
            }
            runOneIteration();
            lock.unlock();
            return;
            Object obj;
            obj;
            shutDown();
_L1:
            notifyFailed(((Throwable) (obj)));
            runningTask.cancel(false);
            lock.unlock();
            return;
            Exception exception;
            exception;
            AbstractScheduledService.logger.log(Level.WARNING, "Error while attempting to shut down the service after failure.", exception);
              goto _L1
            obj;
            lock.unlock();
            throw obj;
        }

        ServiceDelegate.Task()
        {
            this$1 = ServiceDelegate.this;
            super();
        }
    }


    private static final Logger logger = Logger.getLogger(com/google/common/util/concurrent/AbstractScheduledService.getName());
    private final AbstractService _flddelegate = new ServiceDelegate();

    protected AbstractScheduledService()
    {
    }

    public final void addListener(Service.Listener listener, Executor executor1)
    {
        _flddelegate.addListener(listener, executor1);
    }

    public final void awaitRunning()
    {
        _flddelegate.awaitRunning();
    }

    public final void awaitRunning(long l, TimeUnit timeunit)
        throws TimeoutException
    {
        _flddelegate.awaitRunning(l, timeunit);
    }

    public final void awaitTerminated()
    {
        _flddelegate.awaitTerminated();
    }

    public final void awaitTerminated(long l, TimeUnit timeunit)
        throws TimeoutException
    {
        _flddelegate.awaitTerminated(l, timeunit);
    }

    protected ScheduledExecutorService executor()
    {
        final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(new _cls1ThreadFactoryImpl());
        addListener(new Service.Listener() {

            final AbstractScheduledService this$0;
            final ScheduledExecutorService val$executor;

            public void failed(Service.State state1, Throwable throwable)
            {
                executor.shutdown();
            }

            public void terminated(Service.State state1)
            {
                executor.shutdown();
            }

            
            {
                this$0 = AbstractScheduledService.this;
                executor = scheduledexecutorservice;
                super();
            }
        }, MoreExecutors.directExecutor());
        return executor;
    }

    public final Throwable failureCause()
    {
        return _flddelegate.failureCause();
    }

    public final boolean isRunning()
    {
        return _flddelegate.isRunning();
    }

    protected abstract void runOneIteration()
        throws Exception;

    protected abstract Scheduler scheduler();

    protected String serviceName()
    {
        return getClass().getSimpleName();
    }

    protected void shutDown()
        throws Exception
    {
    }

    public final Service startAsync()
    {
        _flddelegate.startAsync();
        return this;
    }

    protected void startUp()
        throws Exception
    {
    }

    public final Service.State state()
    {
        return _flddelegate.state();
    }

    public final Service stopAsync()
    {
        _flddelegate.stopAsync();
        return this;
    }

    public String toString()
    {
        String s = serviceName();
        String s1 = String.valueOf(state());
        return (new StringBuilder(String.valueOf(s).length() + 3 + String.valueOf(s1).length())).append(s).append(" [").append(s1).append("]").toString();
    }



}
