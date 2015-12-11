// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.core;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
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
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package net.tsz.afinal.core:
//            ArrayDeque

public abstract class AsyncTask
{
    private static class AsyncTaskResult
    {

        final Object mData[];
        final AsyncTask mTask;

        transient AsyncTaskResult(AsyncTask asynctask, Object aobj[])
        {
            mTask = asynctask;
            mData = aobj;
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

        InternalHandler(InternalHandler internalhandler)
        {
            this();
        }
    }

    private static class SerialExecutor
        implements Executor
    {

        Runnable mActive;
        final ArrayDeque mTasks;

        public void execute(Runnable runnable)
        {
            this;
            JVM INSTR monitorenter ;
            mTasks.offer(runnable. new Runnable() {

                final SerialExecutor this$1;
                private final Runnable val$r;

                public void run()
                {
                    r.run();
                    scheduleNext();
                    return;
                    Exception exception;
                    exception;
                    scheduleNext();
                    throw exception;
                }

            
            {
                this$1 = final_serialexecutor;
                r = Runnable.this;
                super();
            }
            });
            if (mActive == null)
            {
                scheduleNext();
            }
            this;
            JVM INSTR monitorexit ;
            return;
            runnable;
            throw runnable;
        }

        protected void scheduleNext()
        {
            this;
            JVM INSTR monitorenter ;
            Runnable runnable;
            runnable = (Runnable)mTasks.poll();
            mActive = runnable;
            if (runnable == null)
            {
                break MISSING_BLOCK_LABEL_34;
            }
            AsyncTask.THREAD_POOL_EXECUTOR.execute(mActive);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        private SerialExecutor()
        {
            mTasks = new ArrayDeque();
        }

        SerialExecutor(SerialExecutor serialexecutor)
        {
            this();
        }
    }

    public static final class Status extends Enum
    {

        private static final Status ENUM$VALUES[];
        public static final Status FINISHED;
        public static final Status PENDING;
        public static final Status RUNNING;

        public static Status valueOf(String s)
        {
            return (Status)Enum.valueOf(net/tsz/afinal/core/AsyncTask$Status, s);
        }

        public static Status[] values()
        {
            Status astatus[] = ENUM$VALUES;
            int i = astatus.length;
            Status astatus1[] = new Status[i];
            System.arraycopy(astatus, 0, astatus1, 0, i);
            return astatus1;
        }

        static 
        {
            PENDING = new Status("PENDING", 0);
            RUNNING = new Status("RUNNING", 1);
            FINISHED = new Status("FINISHED", 2);
            ENUM$VALUES = (new Status[] {
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

        WorkerRunnable(WorkerRunnable workerrunnable)
        {
            this();
        }
    }


    private static int $SWITCH_TABLE$net$tsz$afinal$core$AsyncTask$Status[];
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
    private static final InternalHandler sHandler = new InternalHandler(null);
    private static final BlockingQueue sPoolWorkQueue;
    private static final ThreadFactory sThreadFactory;
    private final AtomicBoolean mCancelled = new AtomicBoolean();
    private final FutureTask mFuture;
    private volatile Status mStatus;
    private final AtomicBoolean mTaskInvoked = new AtomicBoolean();
    private final WorkerRunnable mWorker = new WorkerRunnable() {

        final AsyncTask this$0;

        public Object call()
            throws Exception
        {
            mTaskInvoked.set(true);
            Process.setThreadPriority(10);
            return postResult(doInBackground(mParams));
        }

            
            {
                this$0 = AsyncTask.this;
                super(null);
            }
    };

    static int[] $SWITCH_TABLE$net$tsz$afinal$core$AsyncTask$Status()
    {
        int ai[] = $SWITCH_TABLE$net$tsz$afinal$core$AsyncTask$Status;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[Status.values().length];
        try
        {
            ai[Status.FINISHED.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            ai[Status.PENDING.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[Status.RUNNING.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        $SWITCH_TABLE$net$tsz$afinal$core$AsyncTask$Status = ai;
        return ai;
    }

    public AsyncTask()
    {
        mStatus = Status.PENDING;
        mFuture = new FutureTask(mWorker) {

            final AsyncTask this$0;

            protected void done()
            {
                try
                {
                    postResultIfNotInvoked(get());
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
            }

            
            {
                this$0 = AsyncTask.this;
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

    public static void setDefaultExecutor(Executor executor)
    {
        sDefaultExecutor = executor;
    }

    public final boolean cancel(boolean flag)
    {
        mCancelled.set(true);
        return mFuture.cancel(flag);
    }

    protected transient abstract Object doInBackground(Object aobj[]);

    public final transient AsyncTask execute(Object aobj[])
    {
        return executeOnExecutor(sDefaultExecutor, aobj);
    }

    public final transient AsyncTask executeOnExecutor(Executor executor, Object aobj[])
    {
        if (mStatus == Status.PENDING) goto _L2; else goto _L1
_L1:
        $SWITCH_TABLE$net$tsz$afinal$core$AsyncTask$Status()[mStatus.ordinal()];
        JVM INSTR tableswitch 2 3: default 44
    //                   2 75
    //                   3 85;
           goto _L2 _L3 _L4
_L2:
        mStatus = Status.RUNNING;
        onPreExecute();
        mWorker.mParams = aobj;
        executor.execute(mFuture);
        return this;
_L3:
        throw new IllegalStateException("Cannot execute task: the task is already running.");
_L4:
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
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
        return mCancelled.get();
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
                runnable = new Thread(runnable, (new StringBuilder("AsyncTask #")).append(mCount.getAndIncrement()).toString());
                runnable.setPriority(4);
                return runnable;
            }

        };
        sPoolWorkQueue = new LinkedBlockingQueue(10);
        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory, new java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy());
        SERIAL_EXECUTOR = new SerialExecutor(null);
        DUAL_THREAD_EXECUTOR = Executors.newFixedThreadPool(3, sThreadFactory);
        sDefaultExecutor = SERIAL_EXECUTOR;
    }




}
