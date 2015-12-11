// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.google.common.util.concurrent:
//            Service, AbstractService, MoreExecutors

public abstract class AbstractIdleService
    implements Service
{
    private final class DelegateService extends AbstractService
    {

        final AbstractIdleService this$0;

        protected final void doStart()
        {
            MoreExecutors.renamingDecorator(executor(), threadNameSupplier).execute(new Runnable() {

                final DelegateService this$1;

                public void run()
                {
                    try
                    {
                        startUp();
                        notifyStarted();
                        return;
                    }
                    catch (Throwable throwable)
                    {
                        notifyFailed(throwable);
                    }
                }

            
            {
                this$1 = DelegateService.this;
                super();
            }
            });
        }

        protected final void doStop()
        {
            MoreExecutors.renamingDecorator(executor(), threadNameSupplier).execute(new Runnable() {

                final DelegateService this$1;

                public void run()
                {
                    try
                    {
                        shutDown();
                        notifyStopped();
                        return;
                    }
                    catch (Throwable throwable)
                    {
                        notifyFailed(throwable);
                    }
                }

            
            {
                this$1 = DelegateService.this;
                super();
            }
            });
        }

        public String toString()
        {
            return AbstractIdleService.this.toString();
        }

        private DelegateService()
        {
            this$0 = AbstractIdleService.this;
            super();
        }

    }

    private final class ThreadNameSupplier
        implements Supplier
    {

        final AbstractIdleService this$0;

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

        private ThreadNameSupplier()
        {
            this$0 = AbstractIdleService.this;
            super();
        }

    }


    private final Service _flddelegate = new DelegateService();
    private final Supplier threadNameSupplier = new ThreadNameSupplier();

    protected AbstractIdleService()
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

            final AbstractIdleService this$0;

            public void execute(Runnable runnable)
            {
                MoreExecutors.newThread((String)threadNameSupplier.get(), runnable).start();
            }

            
            {
                this$0 = AbstractIdleService.this;
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

    protected String serviceName()
    {
        return getClass().getSimpleName();
    }

    protected abstract void shutDown()
        throws Exception;

    public final Service startAsync()
    {
        _flddelegate.startAsync();
        return this;
    }

    protected abstract void startUp()
        throws Exception;

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
