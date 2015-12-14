// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.threading;

import android.os.Handler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.aviary.android.feather.common.threading:
//            Future, ThreadPool, FutureListener

public abstract class mListener
    implements Future, Runnable
{

    istener mCancelListener;
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
            ThreadPool.access$000(ThreadPool.this).post(new Runnable() {

                final ThreadPool.Worker this$1;

                public void run()
                {
                    mCancelListener.onCancel();
                }

            
            {
                this$1 = ThreadPool.Worker.this;
                super();
            }
            });
        }
    }

    protected void fireOnDoneEvent()
    {
        if (mListener != null)
        {
            ThreadPool.access$000(ThreadPool.this).post(new Runnable() {

                final ThreadPool.Worker this$1;
                final Future val$sender;

                public void run()
                {
                    mListener.onFutureDone(sender);
                }

            
            {
                this$1 = ThreadPool.Worker.this;
                sender = future;
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
        ThreadPool.access$100().error(((Throwable) (obj)).getMessage());
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

    public void setCancelListener(istener istener)
    {
        this;
        JVM INSTR monitorenter ;
        mCancelListener = istener;
        this;
        JVM INSTR monitorexit ;
        return;
        istener;
        this;
        JVM INSTR monitorexit ;
        throw istener;
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

    public transient _cls2.val.sender(_cls2.val.sender sender, FutureListener futurelistener, Object aobj[])
    {
        this$0 = ThreadPool.this;
        super();
        mListener = futurelistener;
    }
}
