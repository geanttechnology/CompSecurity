// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.content;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class FwAsyncTask
{
    private static class AsyncTaskResult
    {

        final Object mData[];
        final FwAsyncTask mTask;

        transient AsyncTaskResult(FwAsyncTask fwasynctask, Object aobj[])
        {
            mTask = fwasynctask;
            mData = aobj;
        }
    }

    private static class ComparableFutureTask extends FutureTask
        implements Comparable
    {

        private final int mPriority;

        public int compareTo(ComparableFutureTask comparablefuturetask)
        {
            if (mPriority == comparablefuturetask.mPriority)
            {
                return 0;
            }
            return mPriority >= comparablefuturetask.mPriority ? 1 : -1;
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((ComparableFutureTask)obj);
        }

        public ComparableFutureTask(Runnable runnable, Object obj, int i)
        {
            super(runnable, obj);
            mPriority = i;
        }

        public ComparableFutureTask(Callable callable, int i)
        {
            super(callable);
            mPriority = i;
        }
    }

    private static class InternalHandler extends Handler
    {

        public void handleMessage(Message message)
        {
            AsyncTaskResult asynctaskresult = (AsyncTaskResult)message.obj;
            switch (message.what)
            {
            default:
                return;

            case 1: // '\001'
                asynctaskresult.mTask.finish(asynctaskresult.mData[0]);
                return;

            case 2: // '\002'
                asynctaskresult.mTask.onProgressUpdate(asynctaskresult.mData);
                break;
            }
        }

        private InternalHandler()
        {
        }

    }

    public static final class Status extends Enum
    {

        private static final Status $VALUES[];
        public static final Status FINISHED;
        public static final Status PENDING;
        public static final Status RUNNING;

        public static Status valueOf(String s)
        {
            return (Status)Enum.valueOf(com/ebay/nautilus/shell/content/FwAsyncTask$Status, s);
        }

        public static Status[] values()
        {
            return (Status[])$VALUES.clone();
        }

        static 
        {
            PENDING = new Status("PENDING", 0);
            RUNNING = new Status("RUNNING", 1);
            FINISHED = new Status("FINISHED", 2);
            $VALUES = (new Status[] {
                PENDING, RUNNING, FINISHED
            });
        }

        private Status(String s, int i)
        {
            super(s, i);
        }
    }

    private static abstract class WorkerRunnable
        implements Callable
    {

        Object mParams[];

        private WorkerRunnable()
        {
        }

    }


    private static final int CORE_POOL_SIZE = 5;
    private static final int KEEP_ALIVE = 1;
    private static final String LOG_TAG = "AsyncTask";
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    public static final Executor THREAD_POOL_EXECUTOR;
    private static final InternalHandler sHandler = new InternalHandler();
    private static final BlockingQueue sPoolWorkQueue;
    private static final ThreadFactory sThreadFactory;
    private final FutureTask mFuture;
    private volatile Status mStatus;
    private final AtomicBoolean mTaskInvoked;
    private final WorkerRunnable mWorker;

    public FwAsyncTask()
    {
        this(0);
    }

    public FwAsyncTask(int i)
    {
        mStatus = Status.PENDING;
        mTaskInvoked = new AtomicBoolean();
        mWorker = new WorkerRunnable() {

            final FwAsyncTask this$0;

            public Object call()
                throws Exception
            {
                mTaskInvoked.set(true);
                Process.setThreadPriority(10);
                return postResult(doInBackground(mParams));
            }

            
            {
                this$0 = FwAsyncTask.this;
                super();
            }
        };
        mFuture = new ComparableFutureTask(mWorker, i) {

            final FwAsyncTask this$0;

            protected void done()
            {
                try
                {
                    Object obj = get();
                    postResultIfNotInvoked(obj);
                    return;
                }
                catch (InterruptedException interruptedexception)
                {
                    Log.w("AsyncTask", interruptedexception);
                    return;
                }
                catch (ExecutionException executionexception)
                {
                    throw new RuntimeException("An error occured while executing doInBackground()", executionexception.getCause());
                }
                catch (CancellationException cancellationexception)
                {
                    postResultIfNotInvoked(null);
                }
                catch (Throwable throwable)
                {
                    throw new RuntimeException("An error occured while executing doInBackground()", throwable);
                }
            }

            
            {
                this$0 = FwAsyncTask.this;
                super(callable, i);
            }
        };
    }

    public static void execute(Runnable runnable)
    {
        THREAD_POOL_EXECUTOR.execute(runnable);
    }

    private void finish(Object obj)
    {
        if (isCancelled())
        {
            onCancelled(obj);
        } else
        {
            onPostExecute(obj);
        }
        mStatus = Status.FINISHED;
    }

    private Object postResult(Object obj)
    {
        sHandler.obtainMessage(1, new AsyncTaskResult(this, new Object[] {
            obj
        })).sendToTarget();
        return obj;
    }

    private void postResultIfNotInvoked(Object obj)
    {
        if (!mTaskInvoked.get())
        {
            postResult(obj);
        }
    }

    public final boolean cancel(boolean flag)
    {
        return mFuture.cancel(flag);
    }

    protected transient abstract Object doInBackground(Object aobj[]);

    public final transient FwAsyncTask execute(Object aobj[])
    {
        return executeOnExecutor(THREAD_POOL_EXECUTOR, aobj);
    }

    public final transient FwAsyncTask executeOnExecutor(Executor executor, Object aobj[])
    {
        static class _cls4
        {

            static final int $SwitchMap$com$ebay$nautilus$shell$content$FwAsyncTask$Status[];

            static 
            {
                $SwitchMap$com$ebay$nautilus$shell$content$FwAsyncTask$Status = new int[Status.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$shell$content$FwAsyncTask$Status[Status.PENDING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$shell$content$FwAsyncTask$Status[Status.RUNNING.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$shell$content$FwAsyncTask$Status[Status.FINISHED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls4..SwitchMap.com.ebay.nautilus.shell.content.FwAsyncTask.Status[mStatus.ordinal()])
        {
        case 1: // '\001'
        default:
            mStatus = Status.RUNNING;
            onPreExecute();
            mWorker.mParams = aobj;
            executor.execute(mFuture);
            return this;

        case 2: // '\002'
            throw new IllegalStateException("Cannot execute task: the task is already running.");

        case 3: // '\003'
            throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
        }
    }

    public final Object get()
        throws InterruptedException, ExecutionException
    {
        return mFuture.get();
    }

    public final Object get(long l, TimeUnit timeunit)
        throws InterruptedException, ExecutionException, TimeoutException
    {
        return mFuture.get(l, timeunit);
    }

    public final Status getStatus()
    {
        return mStatus;
    }

    public final boolean isCancelled()
    {
        return mFuture.isCancelled();
    }

    protected void onCancelled()
    {
    }

    protected void onCancelled(Object obj)
    {
        onCancelled();
    }

    protected void onPostExecute(Object obj)
    {
    }

    protected void onPreExecute()
    {
    }

    protected transient void onProgressUpdate(Object aobj[])
    {
    }

    protected final transient void publishProgress(Object aobj[])
    {
        if (!isCancelled())
        {
            sHandler.obtainMessage(2, new AsyncTaskResult(this, aobj)).sendToTarget();
        }
    }

    static 
    {
        sThreadFactory = new ThreadFactory() {

            private final AtomicInteger mCount = new AtomicInteger(1);

            public Thread newThread(Runnable runnable)
            {
                return new Thread(runnable, (new StringBuilder()).append("FwAsyncTask #").append(mCount.getAndIncrement()).toString());
            }

        };
        sPoolWorkQueue = new PriorityBlockingQueue();
        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
    }




}
