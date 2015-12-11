// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.google.common.util.concurrent:
//            AbstractService, AbstractScheduledService, MoreExecutors

private final class <init> extends AbstractService
{
    class Task
        implements Runnable
    {

        final AbstractScheduledService.ServiceDelegate this$1;

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
            AbstractScheduledService.access$400().log(Level.WARNING, "Error while attempting to shut down the service after failure.", exception);
              goto _L1
            obj;
            lock.unlock();
            throw obj;
        }

        Task()
        {
            this$1 = AbstractScheduledService.ServiceDelegate.this;
            super();
        }
    }


    private volatile ScheduledExecutorService executorService;
    private final ReentrantLock lock;
    private volatile Future runningTask;
    private final Runnable task;
    final AbstractScheduledService this$0;

    protected final void doStart()
    {
        executorService = MoreExecutors.renamingDecorator(executor(), new Supplier() {

            final AbstractScheduledService.ServiceDelegate this$1;

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
                this$1 = AbstractScheduledService.ServiceDelegate.this;
                super();
            }
        });
        executorService.execute(new Runnable() {

            final AbstractScheduledService.ServiceDelegate this$1;

            public void run()
            {
                lock.lock();
                startUp();
                runningTask = scheduler().schedule(AbstractScheduledService.access$500(this$0), executorService, task);
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
                this$1 = AbstractScheduledService.ServiceDelegate.this;
                super();
            }
        });
    }

    protected final void doStop()
    {
        runningTask.cancel(false);
        executorService.execute(new Runnable() {

            final AbstractScheduledService.ServiceDelegate this$1;

            public void run()
            {
                lock.lock();
                Service.State state;
                Service.State state1;
                state = AbstractScheduledService.ServiceDelegate.this.state();
                state1 = Service.State.STOPPING;
                if (state != state1)
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
                this$1 = AbstractScheduledService.ServiceDelegate.this;
                super();
            }
        });
    }

    public String toString()
    {
        return AbstractScheduledService.this.toString();
    }




/*
    static Future access$302(Task task1, Future future)
    {
        task1.runningTask = future;
        return future;
    }

*/



    private _cls3.this._cls1()
    {
        this$0 = AbstractScheduledService.this;
        super();
        lock = new ReentrantLock();
        task = new Task();
    }

    Task(Task task1)
    {
        this();
    }
}
