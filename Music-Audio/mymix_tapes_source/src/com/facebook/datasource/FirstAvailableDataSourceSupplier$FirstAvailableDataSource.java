// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Supplier;
import java.util.List;

// Referenced classes of package com.facebook.datasource:
//            AbstractDataSource, FirstAvailableDataSourceSupplier, DataSource

private class setFailure extends AbstractDataSource
{

    private DataSource mCurrentDataSource;
    private DataSource mDataSourceWithResult;
    private int mIndex;
    final FirstAvailableDataSourceSupplier this$0;

    private boolean clearCurrentDataSource(DataSource datasource)
    {
        this;
        JVM INSTR monitorenter ;
        if (isClosed()) goto _L2; else goto _L1
_L1:
        DataSource datasource1 = mCurrentDataSource;
        if (datasource == datasource1) goto _L3; else goto _L2
_L2:
        boolean flag = false;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L3:
        mCurrentDataSource = null;
        flag = true;
        if (true) goto _L5; else goto _L4
_L4:
        datasource;
        throw datasource;
    }

    private void closeSafely(DataSource datasource)
    {
        if (datasource != null)
        {
            datasource.close();
        }
    }

    private DataSource getDataSourceWithResult()
    {
        this;
        JVM INSTR monitorenter ;
        DataSource datasource = mDataSourceWithResult;
        this;
        JVM INSTR monitorexit ;
        return datasource;
        Exception exception;
        exception;
        throw exception;
    }

    private Supplier getNextSupplier()
    {
        this;
        JVM INSTR monitorenter ;
        if (isClosed() || mIndex >= FirstAvailableDataSourceSupplier.access$100(FirstAvailableDataSourceSupplier.this).size()) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = FirstAvailableDataSourceSupplier.access$100(FirstAvailableDataSourceSupplier.this);
        int i = mIndex;
        mIndex = i + 1;
        obj = (Supplier)((List) (obj)).get(i);
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((Supplier) (obj));
_L2:
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private void maybeSetDataSourceWithResult(DataSource datasource, boolean flag)
    {
        DataSource datasource1 = null;
        this;
        JVM INSTR monitorenter ;
        if (datasource == mCurrentDataSource && datasource != mDataSourceWithResult)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (mDataSourceWithResult != null && !flag)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        datasource1 = mDataSourceWithResult;
        mDataSourceWithResult = datasource;
        this;
        JVM INSTR monitorexit ;
        closeSafely(datasource1);
        return;
        datasource;
        this;
        JVM INSTR monitorexit ;
        throw datasource;
    }

    private void onDataSourceFailed(DataSource datasource)
    {
        if (clearCurrentDataSource(datasource))
        {
            if (datasource != getDataSourceWithResult())
            {
                closeSafely(datasource);
            }
            if (!startNextDataSource())
            {
                setFailure(datasource.getFailureCause());
                return;
            }
        }
    }

    private void onDataSourceNewResult(DataSource datasource)
    {
        maybeSetDataSourceWithResult(datasource, datasource.isFinished());
        if (datasource == getDataSourceWithResult())
        {
            setResult(null, datasource.isFinished());
        }
    }

    private boolean setCurrentDataSource(DataSource datasource)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = isClosed();
        if (!flag) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        mCurrentDataSource = datasource;
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
        datasource;
        throw datasource;
    }

    private boolean startNextDataSource()
    {
        Object obj = getNextSupplier();
        if (obj != null)
        {
            obj = (DataSource)((Supplier) (obj)).get();
        } else
        {
            obj = null;
        }
        if (setCurrentDataSource(((DataSource) (obj))) && obj != null)
        {
    /* block-local class not found */
    class InternalDataSubscriber {}

            ((DataSource) (obj)).subscribe(new InternalDataSubscriber(null), CallerThreadExecutor.getInstance());
            return true;
        } else
        {
            closeSafely(((DataSource) (obj)));
            return false;
        }
    }

    public boolean close()
    {
        this;
        JVM INSTR monitorenter ;
        if (super.close())
        {
            break MISSING_BLOCK_LABEL_13;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        DataSource datasource;
        DataSource datasource1;
        datasource = mCurrentDataSource;
        mCurrentDataSource = null;
        datasource1 = mDataSourceWithResult;
        mDataSourceWithResult = null;
        this;
        JVM INSTR monitorexit ;
        closeSafely(datasource1);
        closeSafely(datasource);
        return true;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Object getResult()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = getDataSourceWithResult();
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = ((DataSource) (obj)).getResult();
_L4:
        this;
        JVM INSTR monitorexit ;
        return obj;
_L2:
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public boolean hasResult()
    {
        this;
        JVM INSTR monitorenter ;
        DataSource datasource = getDataSourceWithResult();
        if (datasource == null) goto _L2; else goto _L1
_L1:
        boolean flag = datasource.hasResult();
        if (!flag) goto _L2; else goto _L3
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



    public InternalDataSubscriber()
    {
        this$0 = FirstAvailableDataSourceSupplier.this;
        super();
        mIndex = 0;
        mCurrentDataSource = null;
        mDataSourceWithResult = null;
        if (!startNextDataSource())
        {
            setFailure(new RuntimeException("No data source supplier or supplier returned null."));
        }
    }
}
