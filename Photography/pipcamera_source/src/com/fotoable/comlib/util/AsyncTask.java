// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.comlib.util;

import android.os.Message;
import android.os.Process;
import android.util.Log;
import fe;
import ff;
import fg;
import fh;
import gb;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AsyncTask
{

    private static final int CORE_POOL_SIZE = 5;
    public static final Executor DUAL_THREAD_EXECUTOR;
    private static final int KEEP_ALIVE = 1;
    private static final String LOG_TAG = "AsyncTask";
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    public static final Executor SERIAL_EXECUTOR;
    public static final Executor THREAD_POOL_EXECUTOR;
    private static volatile Executor sDefaultExecutor;
    private static final ff sHandler = new ff();
    private static final BlockingQueue sPoolWorkQueue;
    private static final ThreadFactory sThreadFactory;
    private final AtomicBoolean mCancelled = new AtomicBoolean();
    private final FutureTask mFuture;
    private volatile Status mStatus;
    private final AtomicBoolean mTaskInvoked = new AtomicBoolean();
    private final fh mWorker = new fh() {

        final AsyncTask a;

        public Object call()
        {
            a.mTaskInvoked.set(true);
            Process.setThreadPriority(10);
            return a.postResult(a.doInBackground(b));
        }

            
            {
                a = AsyncTask.this;
                super();
            }
    };

    public AsyncTask()
    {
        mStatus = Status.PENDING;
        mFuture = new FutureTask(mWorker) {

            final AsyncTask a;

            protected void done()
            {
                try
                {
                    a.postResultIfNotInvoked(get());
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
                    a.postResultIfNotInvoked(null);
                }
            }

            
            {
                a = AsyncTask.this;
                super(callable);
            }
        };
    }

    public static void execute(Runnable runnable)
    {
        sDefaultExecutor.execute(runnable);
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

    public static void init()
    {
        sHandler.getLooper();
    }

    private Object postResult(Object obj)
    {
        sHandler.obtainMessage(1, new fe(this, new Object[] {
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

    public static void setDefaultExecutor(Executor executor)
    {
        sDefaultExecutor = executor;
    }

    public final boolean cancel(boolean flag)
    {
        mCancelled.set(true);
        return mFuture.cancel(flag);
    }

    public transient abstract Object doInBackground(Object aobj[]);

    public final transient AsyncTask execute(Object aobj[])
    {
        return executeOnExecutor(sDefaultExecutor, aobj);
    }

    public final transient AsyncTask executeOnExecutor(Executor executor, Object aobj[])
    {
        if (mStatus == Status.PENDING) goto _L2; else goto _L1
_L1:
        class _cls4
        {

            static final int a[];

            static 
            {
                a = new int[Status.values().length];
                try
                {
                    a[Status.RUNNING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[Status.FINISHED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls4.a[mStatus.ordinal()];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 75
    //                   2 85;
           goto _L2 _L3 _L4
_L2:
        mStatus = Status.RUNNING;
        onPreExecute();
        mWorker.b = aobj;
        executor.execute(mFuture);
        return this;
_L3:
        throw new IllegalStateException("Cannot execute task: the task is already running.");
_L4:
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }

    public final Object get()
    {
        return mFuture.get();
    }

    public final Object get(long l, TimeUnit timeunit)
    {
        return mFuture.get(l, timeunit);
    }

    public final Status getStatus()
    {
        return mStatus;
    }

    public final boolean isCancelled()
    {
        return mCancelled.get();
    }

    public void onCancelled()
    {
    }

    protected void onCancelled(Object obj)
    {
        onCancelled();
    }

    public void onPostExecute(Object obj)
    {
    }

    public void onPreExecute()
    {
    }

    public transient void onProgressUpdate(Object aobj[])
    {
    }

    public final transient void publishProgress(Object aobj[])
    {
        if (!isCancelled())
        {
            sHandler.obtainMessage(2, new fe(this, aobj)).sendToTarget();
        }
    }

    static 
    {
        sThreadFactory = new ThreadFactory() {

            private final AtomicInteger a = new AtomicInteger(1);

            public Thread newThread(Runnable runnable)
            {
                return new Thread(runnable, (new StringBuilder()).append("AsyncTask #").append(a.getAndIncrement()).toString());
            }

        };
        sPoolWorkQueue = new LinkedBlockingQueue(10);
        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory, new java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy());
        Object obj;
        if (gb.c())
        {
            obj = new fg();
        } else
        {
            obj = Executors.newSingleThreadExecutor(sThreadFactory);
        }
        SERIAL_EXECUTOR = ((Executor) (obj));
        DUAL_THREAD_EXECUTOR = Executors.newFixedThreadPool(2, sThreadFactory);
        sDefaultExecutor = THREAD_POOL_EXECUTOR;
    }





    private class Status extends Enum
    {

        private static final Status $VALUES[];
        public static final Status FINISHED;
        public static final Status PENDING;
        public static final Status RUNNING;

        public static Status valueOf(String s)
        {
            return (Status)Enum.valueOf(com/fotoable/comlib/util/AsyncTask$Status, s);
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

}
