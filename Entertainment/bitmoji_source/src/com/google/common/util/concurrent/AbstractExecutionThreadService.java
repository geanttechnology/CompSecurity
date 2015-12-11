// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.google.common.util.concurrent:
//            Service, AbstractService, MoreExecutors

public abstract class AbstractExecutionThreadService
    implements Service
{

    private static final Logger logger = Logger.getLogger(com/google/common/util/concurrent/AbstractExecutionThreadService.getName());
    private final Service _flddelegate = new AbstractService() {

        final AbstractExecutionThreadService this$0;

        protected final void doStart()
        {
            MoreExecutors.renamingDecorator(executor(), new Supplier() {

                final _cls1 this$1;

                public volatile Object get()
                {
                    return get();
                }

                public String get()
                {
                    return serviceName();
                }

            
            {
                this$1 = _cls1.this;
                super();
            }
            }).execute(new Runnable() {

                final _cls1 this$1;

                public void run()
                {
                    boolean flag;
                    startUp();
                    notifyStarted();
                    flag = isRunning();
                    if (!flag)
                    {
                        break MISSING_BLOCK_LABEL_39;
                    }
                    AbstractExecutionThreadService.this.run();
                    break MISSING_BLOCK_LABEL_39;
                    throwable;
                    shutDown();
_L1:
                    notifyFailed(throwable);
                    return;
                    Throwable throwable;
                    try
                    {
                        shutDown();
                        notifyStopped();
                        return;
                    }
                    catch (Throwable throwable1)
                    {
                        notifyFailed(throwable1);
                    }
                    return;
                    Exception exception;
                    exception;
                    AbstractExecutionThreadService.logger.log(Level.WARNING, "Error while attempting to shut down the service after failure.", exception);
                      goto _L1
                }

            
            {
                this$1 = _cls1.this;
                super();
            }
            });
        }

        protected void doStop()
        {
            triggerShutdown();
        }

        public String toString()
        {
            return AbstractExecutionThreadService.this.toString();
        }

            
            {
                this$0 = AbstractExecutionThreadService.this;
                super();
            }
    };

    protected AbstractExecutionThreadService()
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

    protected Executor executor()
    {
        return new Executor() {

            final AbstractExecutionThreadService this$0;

            public void execute(Runnable runnable)
            {
                MoreExecutors.newThread(serviceName(), runnable).start();
            }

            
            {
                this$0 = AbstractExecutionThreadService.this;
                super();
            }
        };
    }

    public final Throwable failureCause()
    {
        return _flddelegate.failureCause();
    }

    public final boolean isRunning()
    {
        return _flddelegate.isRunning();
    }

    protected abstract void run()
        throws Exception;

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

    protected void triggerShutdown()
    {
    }


}
