// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package commonlib.service;

import android.content.Context;
import android.os.PowerManager;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class WakeLockExecutorService
    implements ExecutorService
{
    protected class WakeLockCallable
        implements Callable
    {

        private Callable _flddelegate;
        final WakeLockExecutorService this$0;

        public Object call()
            throws Exception
        {
            Object obj = _flddelegate.call();
            releaseLock();
            return obj;
            Exception exception;
            exception;
            releaseLock();
            throw exception;
        }

        public WakeLockCallable(Callable callable)
        {
            this$0 = WakeLockExecutorService.this;
            super();
            _flddelegate = callable;
        }
    }


    private ExecutorService _flddelegate;
    private android.os.PowerManager.WakeLock wakeLock;

    public WakeLockExecutorService(Context context, ExecutorService executorservice)
    {
        _flddelegate = executorservice;
        wakeLock = ((PowerManager)context.getSystemService("power")).newWakeLock(1, getClass().getSimpleName());
    }

    protected void acquireLock()
    {
        this;
        JVM INSTR monitorenter ;
        wakeLock.acquire(30000L);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean awaitTermination(long l, TimeUnit timeunit)
        throws InterruptedException
    {
        return _flddelegate.awaitTermination(l, timeunit);
    }

    public void execute(Runnable runnable)
    {
        submit(runnable);
    }

    public List invokeAll(Collection collection)
        throws InterruptedException
    {
        throw new UnsupportedOperationException();
    }

    public List invokeAll(Collection collection, long l, TimeUnit timeunit)
        throws InterruptedException
    {
        throw new UnsupportedOperationException();
    }

    public Object invokeAny(Collection collection)
        throws InterruptedException, ExecutionException
    {
        throw new UnsupportedOperationException();
    }

    public Object invokeAny(Collection collection, long l, TimeUnit timeunit)
        throws InterruptedException, ExecutionException, TimeoutException
    {
        throw new UnsupportedOperationException();
    }

    public boolean isShutdown()
    {
        return _flddelegate.isShutdown();
    }

    public boolean isTerminated()
    {
        return _flddelegate.isTerminated();
    }

    protected void releaseLock()
    {
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        this;
        JVM INSTR monitorenter ;
        if (wakeLock.isHeld())
        {
            wakeLock.release();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void shutdown()
    {
        _flddelegate.shutdown();
    }

    public List shutdownNow()
    {
        return _flddelegate.shutdownNow();
    }

    public Future submit(Runnable runnable)
    {
        return submit(runnable, null);
    }

    public Future submit(final Runnable task, final Object result)
    {
        return submit(new Callable() {

            final WakeLockExecutorService this$0;
            final Object val$result;
            final Runnable val$task;

            public Object call()
                throws Exception
            {
                task.run();
                return result;
            }

            
            {
                this$0 = WakeLockExecutorService.this;
                task = runnable;
                result = obj;
                super();
            }
        });
    }

    public Future submit(Callable callable)
    {
        acquireLock();
        return _flddelegate.submit(new WakeLockCallable(callable));
    }
}
