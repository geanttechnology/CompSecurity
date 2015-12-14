// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Supplier;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.facebook.datasource:
//            AbstractDataSource, IncreasingQualityDataSourceSupplier, DataSource

private class InternalDataSubscriber extends AbstractDataSource
{

    private ArrayList mDataSources;
    private int mIndexOfDataSourceWithResult;
    final IncreasingQualityDataSourceSupplier this$0;

    private void closeSafely(DataSource datasource)
    {
        if (datasource != null)
        {
            datasource.close();
        }
    }

    private DataSource getAndClearDataSource(int i)
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        DataSource datasource = obj;
        if (mDataSources == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        datasource = obj;
        if (i < mDataSources.size())
        {
            datasource = (DataSource)mDataSources.set(i, null);
        }
        this;
        JVM INSTR monitorexit ;
        return datasource;
        Exception exception;
        exception;
        throw exception;
    }

    private DataSource getDataSource(int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (mDataSources == null || i >= mDataSources.size()) goto _L2; else goto _L1
_L1:
        DataSource datasource = (DataSource)mDataSources.get(i);
_L4:
        this;
        JVM INSTR monitorexit ;
        return datasource;
_L2:
        datasource = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private DataSource getDataSourceWithResult()
    {
        this;
        JVM INSTR monitorenter ;
        DataSource datasource = getDataSource(mIndexOfDataSourceWithResult);
        this;
        JVM INSTR monitorexit ;
        return datasource;
        Exception exception;
        exception;
        throw exception;
    }

    private void maybeSetIndexOfDataSourceWithResult(int i, DataSource datasource, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        int k;
        int l;
        k = mIndexOfDataSourceWithResult;
        l = mIndexOfDataSourceWithResult;
        if (datasource == getDataSource(i) && i != mIndexOfDataSourceWithResult)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (getDataSourceWithResult() == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        int j;
        j = l;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        j = l;
        if (i >= mIndexOfDataSourceWithResult)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        j = i;
        mIndexOfDataSourceWithResult = i;
        this;
        JVM INSTR monitorexit ;
        for (i = k; i > j; i--)
        {
            closeSafely(getAndClearDataSource(i));
        }

        break MISSING_BLOCK_LABEL_101;
        datasource;
        this;
        JVM INSTR monitorexit ;
        throw datasource;
    }

    private void onDataSourceFailed(int i, DataSource datasource)
    {
        closeSafely(tryGetAndClearDataSource(i, datasource));
        if (i == 0)
        {
            setFailure(datasource.getFailureCause());
        }
    }

    private void onDataSourceNewResult(int i, DataSource datasource)
    {
        maybeSetIndexOfDataSourceWithResult(i, datasource, datasource.isFinished());
        if (datasource == getDataSourceWithResult())
        {
            boolean flag;
            if (i == 0 && datasource.isFinished())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            setResult(null, flag);
        }
    }

    private DataSource tryGetAndClearDataSource(int i, DataSource datasource)
    {
        this;
        JVM INSTR monitorenter ;
        DataSource datasource1 = getDataSourceWithResult();
        if (datasource != datasource1) goto _L2; else goto _L1
_L1:
        datasource1 = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return datasource1;
_L2:
        datasource1 = datasource;
        if (datasource == getDataSource(i))
        {
            datasource1 = getAndClearDataSource(i);
        }
        if (true) goto _L4; else goto _L3
_L3:
        datasource;
        throw datasource;
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
        ArrayList arraylist;
        arraylist = mDataSources;
        mDataSources = null;
        this;
        JVM INSTR monitorexit ;
        if (arraylist != null)
        {
            for (int i = 0; i < arraylist.size(); i++)
            {
                closeSafely((DataSource)arraylist.get(i));
            }

        }
        break MISSING_BLOCK_LABEL_63;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        return true;
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
        this$0 = IncreasingQualityDataSourceSupplier.this;
        super();
        int j = IncreasingQualityDataSourceSupplier.access$000(IncreasingQualityDataSourceSupplier.this).size();
        mIndexOfDataSourceWithResult = j;
        mDataSources = new ArrayList(j);
        int i = 0;
        do
        {
label0:
            {
                if (i < j)
                {
                    DataSource datasource = (DataSource)((Supplier)IncreasingQualityDataSourceSupplier.access$000(IncreasingQualityDataSourceSupplier.this).get(i)).get();
                    mDataSources.add(datasource);
    /* block-local class not found */
    class InternalDataSubscriber {}

                    datasource.subscribe(new InternalDataSubscriber(i), CallerThreadExecutor.getInstance());
                    if (!datasource.hasResult())
                    {
                        break label0;
                    }
                }
                return;
            }
            i++;
        } while (true);
    }
}
