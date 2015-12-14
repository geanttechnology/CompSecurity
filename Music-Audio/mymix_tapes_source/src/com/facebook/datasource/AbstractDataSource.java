// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.datasource;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

// Referenced classes of package com.facebook.datasource:
//            DataSource, DataSubscriber

public abstract class AbstractDataSource
    implements DataSource
{

    private DataSourceStatus mDataSourceStatus;
    private Throwable mFailureThrowable;
    private boolean mIsClosed;
    private float mProgress;
    private Object mResult;
    private final ConcurrentLinkedQueue mSubscribers = new ConcurrentLinkedQueue();

    protected AbstractDataSource()
    {
        mResult = null;
        mFailureThrowable = null;
        mProgress = 0.0F;
        mIsClosed = false;
    /* block-local class not found */
    class DataSourceStatus {}

        mDataSourceStatus = DataSourceStatus.IN_PROGRESS;
    }

    private void notifyDataSubscriber(DataSubscriber datasubscriber, Executor executor, boolean flag, boolean flag1)
    {
        executor.execute(new _cls1(flag, datasubscriber, flag1));
    }

    private void notifyDataSubscribers()
    {
        boolean flag = hasFailed();
        boolean flag1 = wasCancelled();
        Pair pair;
        for (Iterator iterator = mSubscribers.iterator(); iterator.hasNext(); notifyDataSubscriber((DataSubscriber)pair.first, (Executor)pair.second, flag, flag1))
        {
            pair = (Pair)iterator.next();
        }

    }

    private boolean setFailureInternal(Throwable throwable)
    {
        this;
        JVM INSTR monitorenter ;
        if (mIsClosed) goto _L2; else goto _L1
_L1:
        DataSourceStatus datasourcestatus;
        DataSourceStatus datasourcestatus1;
        datasourcestatus = mDataSourceStatus;
        datasourcestatus1 = DataSourceStatus.IN_PROGRESS;
        if (datasourcestatus == datasourcestatus1) goto _L3; else goto _L2
_L2:
        boolean flag = false;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L3:
        mDataSourceStatus = DataSourceStatus.FAILURE;
        mFailureThrowable = throwable;
        flag = true;
        if (true) goto _L5; else goto _L4
_L4:
        throwable;
        throw throwable;
    }

    private boolean setProgressInternal(float f)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        boolean flag = flag1;
        if (mIsClosed) goto _L2; else goto _L1
_L1:
        DataSourceStatus datasourcestatus;
        DataSourceStatus datasourcestatus1;
        datasourcestatus = mDataSourceStatus;
        datasourcestatus1 = DataSourceStatus.IN_PROGRESS;
        if (datasourcestatus == datasourcestatus1) goto _L4; else goto _L3
_L3:
        flag = flag1;
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        flag = flag1;
        if (f < mProgress)
        {
            continue; /* Loop/switch isn't completed */
        }
        mProgress = f;
        flag = true;
        if (true) goto _L2; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    private boolean setResultInternal(Object obj, boolean flag)
    {
        Object obj1;
        Object obj3;
        obj3 = null;
        obj1 = null;
        Object obj2 = null;
        this;
        JVM INSTR monitorenter ;
        obj1 = obj3;
        if (mIsClosed) goto _L2; else goto _L1
_L1:
        obj1 = obj3;
        if (mDataSourceStatus == DataSourceStatus.IN_PROGRESS) goto _L3; else goto _L2
_L2:
        boolean flag1;
        flag1 = false;
        obj1 = obj;
        this;
        JVM INSTR monitorexit ;
        flag = flag1;
        if (obj != null)
        {
            closeResult(obj);
            flag = flag1;
        }
_L5:
        return flag;
_L3:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        obj1 = obj3;
        mDataSourceStatus = DataSourceStatus.SUCCESS;
        obj1 = obj3;
        mProgress = 1.0F;
        obj1 = obj3;
        if (mResult == obj)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        obj1 = obj3;
        obj2 = mResult;
        obj1 = obj2;
        mResult = obj;
        flag = true;
        obj1 = obj2;
        this;
        JVM INSTR monitorexit ;
        if (obj2 == null) goto _L5; else goto _L4
_L4:
        closeResult(obj2);
        return true;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        if (obj1 != null)
        {
            closeResult(obj1);
        }
        throw obj;
    }

    private boolean wasCancelled()
    {
        this;
        JVM INSTR monitorenter ;
        if (!isClosed()) goto _L2; else goto _L1
_L1:
        boolean flag = isFinished();
        if (flag) goto _L2; else goto _L3
_L3:
        flag = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    public boolean close()
    {
        this;
        JVM INSTR monitorenter ;
        if (!mIsClosed)
        {
            break MISSING_BLOCK_LABEL_13;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        Object obj;
        mIsClosed = true;
        obj = mResult;
        mResult = null;
        this;
        JVM INSTR monitorexit ;
        if (obj != null)
        {
            closeResult(obj);
        }
        if (!isFinished())
        {
            notifyDataSubscribers();
        }
        this;
        JVM INSTR monitorenter ;
        mSubscribers.clear();
        this;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void closeResult(Object obj)
    {
    }

    public Throwable getFailureCause()
    {
        this;
        JVM INSTR monitorenter ;
        Throwable throwable = mFailureThrowable;
        this;
        JVM INSTR monitorexit ;
        return throwable;
        Exception exception;
        exception;
        throw exception;
    }

    public float getProgress()
    {
        this;
        JVM INSTR monitorenter ;
        float f = mProgress;
        this;
        JVM INSTR monitorexit ;
        return f;
        Exception exception;
        exception;
        throw exception;
    }

    public Object getResult()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = mResult;
        this;
        JVM INSTR monitorexit ;
        return obj;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean hasFailed()
    {
        this;
        JVM INSTR monitorenter ;
        DataSourceStatus datasourcestatus;
        DataSourceStatus datasourcestatus1;
        datasourcestatus = mDataSourceStatus;
        datasourcestatus1 = DataSourceStatus.FAILURE;
        boolean flag;
        if (datasourcestatus == datasourcestatus1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean hasResult()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = mResult;
        boolean flag;
        if (obj != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isClosed()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mIsClosed;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isFinished()
    {
        this;
        JVM INSTR monitorenter ;
        DataSourceStatus datasourcestatus;
        DataSourceStatus datasourcestatus1;
        datasourcestatus = mDataSourceStatus;
        datasourcestatus1 = DataSourceStatus.IN_PROGRESS;
        boolean flag;
        if (datasourcestatus != datasourcestatus1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    protected void notifyProgressUpdate()
    {
        Pair pair;
        DataSubscriber datasubscriber;
        for (Iterator iterator = mSubscribers.iterator(); iterator.hasNext(); ((Executor)pair.second).execute(new _cls2(datasubscriber)))
        {
            pair = (Pair)iterator.next();
            datasubscriber = (DataSubscriber)pair.first;
        }

    }

    protected boolean setFailure(Throwable throwable)
    {
        boolean flag = setFailureInternal(throwable);
        if (flag)
        {
            notifyDataSubscribers();
        }
        return flag;
    }

    protected boolean setProgress(float f)
    {
        boolean flag = setProgressInternal(f);
        if (flag)
        {
            notifyProgressUpdate();
        }
        return flag;
    }

    protected boolean setResult(Object obj, boolean flag)
    {
        flag = setResultInternal(obj, flag);
        if (flag)
        {
            notifyDataSubscribers();
        }
        return flag;
    }

    public void subscribe(DataSubscriber datasubscriber, Executor executor)
    {
        Preconditions.checkNotNull(datasubscriber);
        Preconditions.checkNotNull(executor);
        this;
        JVM INSTR monitorenter ;
        if (!mIsClosed)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (mDataSourceStatus == DataSourceStatus.IN_PROGRESS)
        {
            mSubscribers.add(Pair.create(datasubscriber, executor));
        }
        boolean flag;
        if (!hasResult() && !isFinished() && !wasCancelled())
        {
            flag = false;
        } else
        {
            flag = true;
        }
        this;
        JVM INSTR monitorexit ;
        if (flag)
        {
            notifyDataSubscriber(datasubscriber, executor, hasFailed(), wasCancelled());
            return;
        } else
        {
            return;
        }
        datasubscriber;
        this;
        JVM INSTR monitorexit ;
        throw datasubscriber;
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
