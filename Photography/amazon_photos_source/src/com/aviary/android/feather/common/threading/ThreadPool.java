// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.threading;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.utils.IDisposable;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.aviary.android.feather.common.threading:
//            FutureListener, Future

public class ThreadPool
    implements IDisposable
{
    public static interface CancelListener
    {

        public abstract void onCancel();
    }

    public static interface Job
    {

        public transient abstract Object run(Worker worker, Object aobj[])
            throws Exception;
    }

    class LowPriorityThreadFactory
        implements ThreadFactory
    {

        private final String mName;
        private final AtomicInteger mNumber = new AtomicInteger();
        private final int mPriority;
        final ThreadPool this$0;

        public Thread newThread(Runnable runnable)
        {
            return new Thread(runnable, (new StringBuilder()).append(mName).append('-').append(mNumber.getAndIncrement()).toString()) {

                final LowPriorityThreadFactory this$1;

                public void run()
                {
                    Process.setThreadPriority(mPriority);
                    super.run();
                }

            
            {
                this$1 = LowPriorityThreadFactory.this;
                super(runnable, s);
            }
            };
        }


        public LowPriorityThreadFactory(String s, int i)
        {
            this$0 = ThreadPool.this;
            super();
            mName = s;
            mPriority = i;
        }
    }

    public abstract class Worker
        implements Future, Runnable
    {

        CancelListener mCancelListener;
        Exception mError;
        boolean mIsCancelled;
        boolean mIsDone;
        FutureListener mListener;
        Object mResult;
        final ThreadPool this$0;

        public boolean cancel(boolean flag)
        {
            this;
            JVM INSTR monitorenter ;
            if (!mIsCancelled)
            {
                break MISSING_BLOCK_LABEL_13;
            }
            this;
            JVM INSTR monitorexit ;
            return false;
            mIsCancelled = true;
            fireOnCancelEvent();
            this;
            JVM INSTR monitorexit ;
            return false;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        protected void fireOnCancelEvent()
        {
            if (mCancelListener != null)
            {
                mListenerHandler.post(new Runnable() {

                    final Worker this$1;

                    public void run()
                    {
                        mCancelListener.onCancel();
                    }

            
            {
                this$1 = Worker.this;
                super();
            }
                });
            }
        }

        protected void fireOnDoneEvent()
        {
            if (mListener != null)
            {
                mListenerHandler.post(new Runnable() {

                    final Worker this$1;
                    final Future val$sender;

                    public void run()
                    {
                        mListener.onFutureDone(sender);
                    }

            
            {
                this$1 = final_worker;
                sender = Future.this;
                super();
            }
                });
            }
        }

        public Object get()
        {
            this;
            JVM INSTR monitorenter ;
_L1:
            boolean flag = mIsDone;
            if (flag)
            {
                break MISSING_BLOCK_LABEL_43;
            }
            wait();
              goto _L1
            Object obj;
            obj;
            ThreadPool.LOGGER.error(((Throwable) (obj)).getMessage());
            ((Throwable) (obj)).printStackTrace();
              goto _L1
            obj;
            this;
            JVM INSTR monitorexit ;
            throw obj;
            Object obj1 = mResult;
            this;
            JVM INSTR monitorexit ;
            return obj1;
        }

        public Object get(long l, TimeUnit timeunit)
            throws InterruptedException, ExecutionException, TimeoutException
        {
            throw new TimeoutException("non implemented");
        }

        public Exception getException()
        {
            waitDone();
            return mError;
        }

        public boolean hasException()
        {
            waitDone();
            return mError != null;
        }

        public boolean isCancelled()
        {
            return mIsCancelled;
        }

        public boolean isDone()
        {
            return mIsDone;
        }

        public void setCancelListener(CancelListener cancellistener)
        {
            this;
            JVM INSTR monitorenter ;
            mCancelListener = cancellistener;
            this;
            JVM INSTR monitorexit ;
            return;
            cancellistener;
            this;
            JVM INSTR monitorexit ;
            throw cancellistener;
        }

        protected void setException(Exception exception)
        {
            mError = exception;
        }

        protected void setIsDone()
        {
            mIsDone = true;
        }

        protected void setResult(Object obj)
        {
            mResult = obj;
        }

        public void waitDone()
        {
            get();
        }

        public transient Worker(Job job, FutureListener futurelistener, Object aobj[])
        {
            this$0 = ThreadPool.this;
            super();
            mListener = futurelistener;
        }
    }


    private static final int KEEP_ALIVE = 5;
    private static final com.aviary.android.feather.common.log.LoggerFactory.Logger LOGGER;
    private final ThreadPoolExecutor mExecutor;
    private final Handler mListenerHandler = new Handler(Looper.getMainLooper());

    public ThreadPool(int i, int j)
    {
        mExecutor = new ThreadPoolExecutor(i, i * 2, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new LowPriorityThreadFactory("thread-pool-service", j));
    }

    private void printStats()
    {
    }

    public void dispose()
    {
        mExecutor.shutdown();
    }

    public int getActiveCount()
    {
        return mExecutor.getActiveCount();
    }

    public long getCompletedTaskCount()
    {
        return mExecutor.getCompletedTaskCount();
    }

    public int getPoolSize()
    {
        return mExecutor.getPoolSize();
    }

    public BlockingQueue getQueue()
    {
        return mExecutor.getQueue();
    }

    public long getTaskCount()
    {
        return mExecutor.getTaskCount();
    }

    public transient Future submit(final Job final_job1, final FutureListener final_futurelistener, Object aobj[])
    {
        final_job1 = new Worker(aobj, final_job1, aobj) {

            final ThreadPool this$0;
            final Job val$job;
            final Object val$params[];

            public Object get(long l, TimeUnit timeunit)
                throws InterruptedException, ExecutionException, TimeoutException
            {
                return null;
            }

            public void run()
            {
                Exception exception;
                Object obj1;
                Object obj2;
                Object obj3;
                obj2 = null;
                obj3 = null;
                exception = obj3;
                obj1 = obj2;
                if (mIsCancelled)
                {
                    break MISSING_BLOCK_LABEL_35;
                }
                obj1 = job.run(this, params);
                exception = obj3;
_L2:
                this;
                JVM INSTR monitorenter ;
                if (exception == null)
                {
                    break MISSING_BLOCK_LABEL_46;
                }
                setException(exception);
                setResult(obj1);
                setIsDone();
                notifyAll();
                this;
                JVM INSTR monitorexit ;
                fireOnDoneEvent();
                return;
                Object obj;
                obj;
                ((Exception) (obj)).printStackTrace();
                obj = new Exception(((Throwable) (obj)));
                obj1 = obj2;
                if (true) goto _L2; else goto _L1
_L1:
                obj;
                this;
                JVM INSTR monitorexit ;
                throw obj;
            }

            transient 
            {
                this$0 = ThreadPool.this;
                job = job2;
                params = aobj1;
                super(final_job1, final_futurelistener, aobj);
            }
        };
        mExecutor.execute(final_job1);
        return final_job1;
    }

    public String toString()
    {
        return String.format(Locale.US, "ThreadPool(pool: %d, corePool: %d, largestPool: %d, maxPool: %d, tasks: %d, active: %d, completed: %d)", new Object[] {
            Integer.valueOf(mExecutor.getPoolSize()), Integer.valueOf(mExecutor.getCorePoolSize()), Integer.valueOf(mExecutor.getLargestPoolSize()), Integer.valueOf(mExecutor.getMaximumPoolSize()), Long.valueOf(mExecutor.getTaskCount()), Integer.valueOf(mExecutor.getActiveCount()), Long.valueOf(mExecutor.getCompletedTaskCount())
        });
    }

    static 
    {
        LOGGER = LoggerFactory.getLogger(com/aviary/android/feather/common/threading/ThreadPool.getSimpleName(), com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
    }


}
