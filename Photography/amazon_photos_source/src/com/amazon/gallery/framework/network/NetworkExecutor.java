// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network;

import android.os.SystemClock;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.network.cds.DownloadMediaItemOperation;
import com.amazon.gallery.framework.network.exceptions.AcceptableTerminalException;
import com.amazon.gallery.framework.network.exceptions.InvalidAuthTokenException;
import com.amazon.gallery.framework.network.exceptions.RetryLimitExceededException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.framework.network.throttle.NetworkThrottle;
import com.amazon.gallery.framework.network.util.ExponentialBackoff;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class NetworkExecutor
{
    public static class NetworkFutureTask extends FutureTask
        implements NetworkTask
    {

        private final ResultHandler callback;
        private final NetworkOperation operation;
        private final long startTime = SystemClock.uptimeMillis();

        protected void done()
        {
            if (isCancelled())
            {
                break MISSING_BLOCK_LABEL_176;
            }
            if (callback != null)
            {
                callback.onSuccess(get());
            }
_L2:
            return;
            Object obj;
            obj;
            callback.onFailure(new TerminalException(((Throwable) (obj))));
            return;
            obj;
            Throwable throwable = ((ExecutionException) (obj)).getCause();
            if (throwable instanceof AcceptableTerminalException)
            {
                GLogger.i(NetworkExecutor.TAG, "Unable to complete network operation: %s", new Object[] {
                    throwable.getMessage()
                });
            } else
            {
                GLogger.w(NetworkExecutor.TAG, throwable.getMessage(), new Object[0]);
            }
            if (throwable instanceof TerminalException)
            {
                callback.onFailure((TerminalException)throwable);
                return;
            } else
            {
                callback.onFailure(new TerminalException(throwable));
                return;
            }
            throwable;
            GLogger.exf(NetworkExecutor.TAG, throwable, throwable.getMessage(), new Object[0]);
            if (callback == null) goto _L2; else goto _L1
_L1:
            callback.onFailure(new TerminalException(throwable));
            return;
            GLogger.d(NetworkExecutor.TAG, "Network operation cancelled before completing", new Object[0]);
            if (callback != null)
            {
                callback.onFailure(new TerminalException("request cancelled"));
                return;
            }
              goto _L2
        }

        public NetworkOperation getOperation()
        {
            return operation;
        }

        public void run()
        {
            GLogger.t(NetworkExecutor.TAG, startTime, "Started network task %s after waiting: ", new Object[] {
                operation.toString()
            });
            super.run();
        }

        public void setException(Throwable throwable)
        {
            super.setException(throwable);
        }

        public String toString()
        {
            return operation.toString();
        }

        public NetworkFutureTask(NetworkOperation networkoperation, ResultHandler resulthandler, ExponentialBackoff exponentialbackoff)
        {
            super(new RetryingNetworkOperationExecutor(networkoperation, exponentialbackoff));
            operation = networkoperation;
            callback = resulthandler;
        }
    }

    public static interface NetworkOperation
    {

        public abstract Object get()
            throws TerminalException, TransientException;
    }

    public static interface NetworkTask
        extends Runnable
    {

        public abstract boolean cancel(boolean flag);

        public abstract NetworkOperation getOperation();
    }

    private class NetworkThreadPoolExecutor extends ThreadPoolExecutor
    {

        final NetworkExecutor this$0;

        protected void afterExecute(Runnable runnable, Throwable throwable)
        {
            runnable = (NetworkTask)runnable;
            NetworkExecutor.this.afterExecute(this, runnable);
        }

        protected void beforeExecute(Thread thread, Runnable runnable)
        {
            thread = (NetworkTask)runnable;
            GLogger.d(NetworkExecutor.TAG, "Executing %s %s", new Object[] {
                thread.getOperation(), thread
            });
            NetworkExecutor.this.beforeExecute(this, thread);
        }

        public List shutdownNow2()
        {
            return super.shutdownNow();
        }

        protected void terminated()
        {
            super.terminated();
        }

        public NetworkThreadPoolExecutor(int i, int j, long l, TimeUnit timeunit, BlockingQueue blockingqueue, 
                ThreadFactory threadfactory)
        {
            this$0 = NetworkExecutor.this;
            super(i, j, l, timeunit, blockingqueue, threadfactory);
        }
    }

    public static interface ResultHandler
    {

        public abstract void onFailure(TerminalException terminalexception);

        public abstract void onSuccess(Object obj);
    }

    public static class RetryingNetworkOperationExecutor
        implements Callable
    {

        private static ThreadLocal threadRetryAttempt = new ThreadLocal() {

            protected Integer initialValue()
            {
                return Integer.valueOf(0);
            }

            protected volatile Object initialValue()
            {
                return initialValue();
            }

        };
        private final ExponentialBackoff backoff;
        private final NetworkOperation callable;
        private int localRetryAttempt;

        private Object retry(TransientException transientexception)
            throws TerminalException
        {
            GLogger.v(NetworkExecutor.TAG, "Current attempt: %d - Current thread: %d", new Object[] {
                Integer.valueOf(localRetryAttempt), Long.valueOf(Thread.currentThread().getId())
            });
            if ((transientexception instanceof InvalidAuthTokenException) || transientexception.getStatusCode() >= 500 && transientexception.getStatusCode() < 600 || transientexception.getStatusCode() == 429)
            {
                long l = backoff.get(((Integer)threadRetryAttempt.get()).intValue());
                GLogger.d(NetworkExecutor.TAG, "Backing off for %d ms", new Object[] {
                    Long.valueOf(l)
                });
                SystemClock.sleep(l);
            }
            if (localRetryAttempt < backoff.getRetryLimit())
            {
                GLogger.i(NetworkExecutor.TAG, "Retry limit not reached, retrying again.", new Object[0]);
                threadRetryAttempt.set(Integer.valueOf(((Integer)threadRetryAttempt.get()).intValue() + 1));
                localRetryAttempt = localRetryAttempt + 1;
                return call();
            } else
            {
                throw new RetryLimitExceededException(transientexception);
            }
        }

        public Object call()
            throws TerminalException
        {
            Object obj;
            long l;
            try
            {
                l = NetworkThrottle.getNetworkDelay();
            }
            catch (TransientException transientexception)
            {
                GLogger.w(NetworkExecutor.TAG, "TransientException while executing operation, retrying: %s", new Object[] {
                    transientexception.getMessage()
                });
                return retry(transientexception);
            }
            catch (AcceptableTerminalException acceptableterminalexception)
            {
                GLogger.w(NetworkExecutor.TAG, "AcceptableTerminalException while executing operation: %s", new Object[] {
                    acceptableterminalexception.getMessage()
                });
                throw acceptableterminalexception;
            }
            catch (TerminalException terminalexception)
            {
                GLogger.w(NetworkExecutor.TAG, "TerminalException while executing operation: %s", new Object[] {
                    terminalexception.getMessage()
                });
                throw terminalexception;
            }
            if (l <= 0L)
            {
                break MISSING_BLOCK_LABEL_46;
            }
            GLogger.v(NetworkExecutor.TAG, "Applying network throttle to request %s, sleeping for %dms", new Object[] {
                callable.getClass().getName(), Long.valueOf(l)
            });
            SystemClock.sleep(l);
            obj = callable.get();
            threadRetryAttempt.set(Integer.valueOf(0));
            return obj;
        }

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null || getClass() != obj.getClass())
                {
                    return false;
                }
                obj = (RetryingNetworkOperationExecutor)obj;
                if (!callable.equals(((RetryingNetworkOperationExecutor) (obj)).callable))
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            return callable.hashCode();
        }


        public RetryingNetworkOperationExecutor(NetworkOperation networkoperation, ExponentialBackoff exponentialbackoff)
        {
            localRetryAttempt = 0;
            callable = networkoperation;
            backoff = exponentialbackoff;
        }
    }


    private static final ExponentialBackoff BACKGROUND_BACKOFF = new ExponentialBackoff(1000, 4);
    private static final ExponentialBackoff FOREGROUND_BACKOFF = new ExponentialBackoff(1000, 2);
    private static final ExponentialBackoff NO_RETRY_BACKOFF = new ExponentialBackoff(0, 0);
    private static final String TAG = com/amazon/gallery/framework/network/NetworkExecutor.getName();
    private static final NetworkExecutor instance = new NetworkExecutor();
    private NetworkThreadPoolExecutor backgroundExecutor;
    private final BlockingQueue backgroundQ = new LinkedBlockingDeque();
    private NetworkThreadPoolExecutor foregroundExecutor;
    private final BlockingQueue foregroundQ = new LinkedBlockingDeque();
    private final ConcurrentHashMap inProgressSet = new ConcurrentHashMap();

    private NetworkExecutor()
    {
        foregroundExecutor = null;
        backgroundExecutor = initializeBackgroundExecutor();
    }

    private void afterExecute(NetworkThreadPoolExecutor networkthreadpoolexecutor, NetworkTask networktask)
    {
        inProgressSet.remove(networktask);
    }

    private void beforeExecute(NetworkThreadPoolExecutor networkthreadpoolexecutor, NetworkTask networktask)
    {
        GLogger.v(TAG, "Executing: %s; FG Queue size: %s; BG Queue size: %s", new Object[] {
            networktask.toString(), Integer.valueOf(foregroundQ.size()), Integer.valueOf(backgroundQ.size())
        });
        inProgressSet.put(networktask, Boolean.valueOf(true));
    }

    private static ExponentialBackoff getBackoff(boolean flag, NetworkOperation networkoperation)
    {
        if (networkoperation instanceof DownloadMediaItemOperation)
        {
            return NO_RETRY_BACKOFF;
        }
        if (flag)
        {
            return FOREGROUND_BACKOFF;
        } else
        {
            return BACKGROUND_BACKOFF;
        }
    }

    public static NetworkExecutor getInstance()
    {
        return instance;
    }

    private NetworkThreadPoolExecutor initializeBackgroundExecutor()
    {
        return new NetworkThreadPoolExecutor(3, 3, 5L, TimeUnit.SECONDS, backgroundQ, new ThreadFactory() {

            private final AtomicInteger count = new AtomicInteger(1);
            final NetworkExecutor this$0;

            public Thread newThread(Runnable runnable)
            {
                runnable = new Thread(runnable, (new StringBuilder()).append("NetworkExecutor BGThread#").append(count.getAndIncrement()).toString());
                runnable.setPriority(2);
                return runnable;
            }

            
            {
                this$0 = NetworkExecutor.this;
                super();
            }
        });
    }

    private NetworkThreadPoolExecutor initializeForegroundExecutor()
    {
        NetworkThreadPoolExecutor networkthreadpoolexecutor;
label0:
        {
            NetworkThreadPoolExecutor networkthreadpoolexecutor1 = foregroundExecutor;
            if (networkthreadpoolexecutor1 != null)
            {
                networkthreadpoolexecutor = networkthreadpoolexecutor1;
                if (!networkthreadpoolexecutor1.isShutdown())
                {
                    break label0;
                }
            }
            networkthreadpoolexecutor = new NetworkThreadPoolExecutor(5, 5, 5L, TimeUnit.SECONDS, foregroundQ, new ThreadFactory() {

                private final AtomicInteger count = new AtomicInteger(1);
                final NetworkExecutor this$0;

                public Thread newThread(Runnable runnable)
                {
                    runnable = new Thread(runnable, (new StringBuilder()).append("NetworkExecutor FGThread#").append(count.getAndIncrement()).toString());
                    runnable.setPriority(3);
                    return runnable;
                }

            
            {
                this$0 = NetworkExecutor.this;
                super();
            }
            });
            foregroundExecutor = networkthreadpoolexecutor;
        }
        return networkthreadpoolexecutor;
    }

    private void shutDownNowWithTimeOut(NetworkThreadPoolExecutor networkthreadpoolexecutor, long l, TimeUnit timeunit)
        throws InterruptedException
    {
        if (networkthreadpoolexecutor != null)
        {
            networkthreadpoolexecutor.shutdown();
            if (!networkthreadpoolexecutor.awaitTermination(l, timeunit))
            {
                for (networkthreadpoolexecutor = networkthreadpoolexecutor.shutdownNow2().iterator(); networkthreadpoolexecutor.hasNext(); ((NetworkTask)networkthreadpoolexecutor.next()).cancel(true)) { }
            }
        }
    }

    private void shutdownBackgroundExecutor()
    {
        backgroundExecutor.shutdown();
    }

    private void shutdownForegroundExecutor()
    {
        if (foregroundExecutor != null)
        {
            GLogger.d(TAG, "Shutting down Foreground Executor.", new Object[0]);
            foregroundExecutor.shutdown();
            foregroundExecutor = null;
        }
    }

    public Object execute(NetworkOperation networkoperation)
        throws TerminalException
    {
        return (new RetryingNetworkOperationExecutor(networkoperation, getBackoff(true, networkoperation))).call();
    }

    public Future executeBackground(NetworkOperation networkoperation, ResultHandler resulthandler)
    {
        networkoperation = new NetworkFutureTask(networkoperation, resulthandler, getBackoff(false, networkoperation));
        try
        {
            backgroundExecutor.execute(networkoperation);
        }
        // Misplaced declaration of an exception variable
        catch (ResultHandler resulthandler)
        {
            networkoperation.setException(new ExecutionException(resulthandler));
            return networkoperation;
        }
        return networkoperation;
    }

    public Future executeForeground(NetworkOperation networkoperation, ResultHandler resulthandler)
    {
        foregroundExecutor = initializeForegroundExecutor();
        networkoperation = new NetworkFutureTask(networkoperation, resulthandler, getBackoff(true, networkoperation));
        try
        {
            foregroundExecutor.execute(networkoperation);
        }
        // Misplaced declaration of an exception variable
        catch (ResultHandler resulthandler)
        {
            networkoperation.setException(new ExecutionException(resulthandler));
            return networkoperation;
        }
        return networkoperation;
    }

    protected void finalize()
        throws Throwable
    {
        super.finalize();
        shutdownBackgroundExecutor();
        shutdownForegroundExecutor();
    }

    public void reset()
    {
        shutdownBackgroundExecutor();
        shutdownForegroundExecutor();
        backgroundExecutor = initializeBackgroundExecutor();
    }

    public void resetWithInterrupt()
    {
        try
        {
            shutDownNowWithTimeOut(backgroundExecutor, 1L, TimeUnit.SECONDS);
            shutDownNowWithTimeOut(foregroundExecutor, 1L, TimeUnit.SECONDS);
            foregroundExecutor = null;
            backgroundExecutor = initializeBackgroundExecutor();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            GLogger.exf(TAG, interruptedexception, interruptedexception.getMessage(), new Object[0]);
        }
    }




}
