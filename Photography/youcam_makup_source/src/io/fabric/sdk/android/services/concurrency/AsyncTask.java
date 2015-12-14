// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.fabric.sdk.android.services.concurrency;

import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AsyncTask
{

    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    private static final int KEEP_ALIVE = 1;
    private static final String LOG_TAG = "AsyncTask";
    private static final int MAXIMUM_POOL_SIZE;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    public static final Executor SERIAL_EXECUTOR;
    public static final Executor THREAD_POOL_EXECUTOR;
    private static volatile Executor defaultExecutor;
    private static final InternalHandler handler = new InternalHandler();
    private static final BlockingQueue poolWorkQueue;
    private static final ThreadFactory threadFactory;
    private final AtomicBoolean cancelled = new AtomicBoolean();
    private final FutureTask future;
    private volatile Status status;
    private final AtomicBoolean taskInvoked = new AtomicBoolean();
    private final WorkerRunnable worker = new WorkerRunnable() {
            private class WorkerRunnable
                implements Callable
            {

                Object params[];

                private WorkerRunnable()
                {
                }

            }


        final AsyncTask this$0;

        public Object call()
        {
            taskInvoked.set(true);
            Process.setThreadPriority(10);
            return postResult(doInBackground(params));
        }

            
            {
                this$0 = AsyncTask.this;
                super();
            }
    };

    public AsyncTask()
    {
        status = Status.PENDING;
        future = new FutureTask(worker) {

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
        defaultExecutor.execute(runnable);
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
        status = Status.FINISHED;
    }

    public static void init()
    {
        handler.getLooper();
    }

    private Object postResult(Object obj)
    {
        handler.obtainMessage(1, new AsyncTaskResult(new Object[] {
            obj
        })).sendToTarget();
        return obj;
    }

    private void postResultIfNotInvoked(Object obj)
    {
        if (!taskInvoked.get())
        {
            postResult(obj);
        }
    }

    public static void setDefaultExecutor(Executor executor)
    {
        defaultExecutor = executor;
    }

    public final boolean cancel(boolean flag)
    {
        cancelled.set(true);
        return future.cancel(flag);
    }

    protected transient abstract Object doInBackground(Object aobj[]);

    public final transient AsyncTask execute(Object aobj[])
    {
        return executeOnExecutor(defaultExecutor, aobj);
    }

    public final transient AsyncTask executeOnExecutor(Executor executor, Object aobj[])
    {
        if (status == Status.PENDING) goto _L2; else goto _L1
_L1:
        class _cls4
        {

            static final int $SwitchMap$io$fabric$sdk$android$services$concurrency$AsyncTask$Status[];

            static 
            {
                $SwitchMap$io$fabric$sdk$android$services$concurrency$AsyncTask$Status = new int[Status.values().length];
                try
                {
                    $SwitchMap$io$fabric$sdk$android$services$concurrency$AsyncTask$Status[Status.RUNNING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$io$fabric$sdk$android$services$concurrency$AsyncTask$Status[Status.FINISHED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls4..SwitchMap.io.fabric.sdk.android.services.concurrency.AsyncTask.Status[status.ordinal()];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 75
    //                   2 85;
           goto _L2 _L3 _L4
_L2:
        status = Status.RUNNING;
        onPreExecute();
        worker.params = aobj;
        executor.execute(future);
        return this;
_L3:
        throw new IllegalStateException("Cannot execute task: the task is already running.");
_L4:
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }

    public final Object get()
    {
        return future.get();
    }

    public final Object get(long l, TimeUnit timeunit)
    {
        return future.get(l, timeunit);
    }

    public final Status getStatus()
    {
        return status;
    }

    public final boolean isCancelled()
    {
        return cancelled.get();
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
            handler.obtainMessage(2, new AsyncTaskResult(aobj)).sendToTarget();
        }
    }

    static 
    {
        CPU_COUNT = Runtime.getRuntime().availableProcessors();
        CORE_POOL_SIZE = CPU_COUNT + 1;
        MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
        threadFactory = new ThreadFactory() {

            private final AtomicInteger count = new AtomicInteger(1);

            public Thread newThread(Runnable runnable)
            {
                return new Thread(runnable, (new StringBuilder()).append("AsyncTask #").append(count.getAndIncrement()).toString());
            }

        };
        poolWorkQueue = new LinkedBlockingQueue(128);
        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 1L, TimeUnit.SECONDS, poolWorkQueue, threadFactory);
        SERIAL_EXECUTOR = new SerialExecutor();
        defaultExecutor = SERIAL_EXECUTOR;
    }





    private class Status extends Enum
    {

        private static final Status $VALUES[];
        public static final Status FINISHED;
        public static final Status PENDING;
        public static final Status RUNNING;

        public static Status valueOf(String s)
        {
            return (Status)Enum.valueOf(io/fabric/sdk/android/services/concurrency/AsyncTask$Status, s);
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


    private class InternalHandler extends Handler
    {

        public void handleMessage(Message message)
        {
            AsyncTaskResult asynctaskresult = (AsyncTaskResult)message.obj;
            switch (message.what)
            {
            default:
                return;

            case 1: // '\001'
                asynctaskresult.task.finish(asynctaskresult.data[0]);
                return;

            case 2: // '\002'
                asynctaskresult.task.onProgressUpdate(asynctaskresult.data);
                break;
            }
        }

        public InternalHandler()
        {
            super(Looper.getMainLooper());
        }
    }


    private class AsyncTaskResult
    {

        final Object data[];
        final AsyncTask task;

        transient AsyncTaskResult(Object aobj[])
        {
            task = AsyncTask.this;
            data = aobj;
        }
    }


    private class SerialExecutor
        implements Executor
    {

        Runnable active;
        final LinkedList tasks;

        public void execute(final Runnable r)
        {
            this;
            JVM INSTR monitorenter ;
            tasks.offer(new Runnable() {

                final SerialExecutor this$0;
                final Runnable val$r;

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
                    this$0 = SerialExecutor.this;
                    r = runnable;
                    super();
                }
            });
            if (active == null)
            {
                scheduleNext();
            }
            this;
            JVM INSTR monitorexit ;
            return;
            r;
            throw r;
        }

        protected void scheduleNext()
        {
            this;
            JVM INSTR monitorenter ;
            Runnable runnable;
            runnable = (Runnable)tasks.poll();
            active = runnable;
            if (runnable == null)
            {
                break MISSING_BLOCK_LABEL_34;
            }
            AsyncTask.THREAD_POOL_EXECUTOR.execute(active);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        private SerialExecutor()
        {
            tasks = new LinkedList();
        }

    }

}
