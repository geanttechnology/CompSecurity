// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Preconditions;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;

public class ListDataSource extends AbstractDataSource
{
    private class InternalDataSubscriber
        implements DataSubscriber
    {

        boolean mFinished;
        final ListDataSource this$0;

        private boolean tryFinish()
        {
            boolean flag = true;
            this;
            JVM INSTR monitorenter ;
            boolean flag1 = mFinished;
            if (!flag1) goto _L2; else goto _L1
_L1:
            flag = false;
_L4:
            this;
            JVM INSTR monitorexit ;
            return flag;
_L2:
            mFinished = true;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        public void onCancellation(DataSource datasource)
        {
            onDataSourceCancelled();
        }

        public void onFailure(DataSource datasource)
        {
            onDataSourceFailed(datasource);
        }

        public void onNewResult(DataSource datasource)
        {
            if (datasource.isFinished() && tryFinish())
            {
                onDataSourceFinished();
            }
        }

        public void onProgressUpdate(DataSource datasource)
        {
            onDataSourceProgress();
        }

        private InternalDataSubscriber()
        {
            this$0 = ListDataSource.this;
            super();
            mFinished = false;
        }

    }


    private final DataSource mDataSources[];
    private int mFinishedDataSources;

    protected ListDataSource(DataSource adatasource[])
    {
        mDataSources = adatasource;
        mFinishedDataSources = 0;
    }

    public static transient ListDataSource create(DataSource adatasource[])
    {
        Preconditions.checkNotNull(adatasource);
        ListDataSource listdatasource;
        int j;
        boolean flag;
        if (adatasource.length > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag);
        listdatasource = new ListDataSource(adatasource);
        j = adatasource.length;
        for (int i = 0; i < j; i++)
        {
            DataSource datasource = adatasource[i];
            listdatasource.getClass();
            datasource.subscribe(listdatasource. new InternalDataSubscriber(), CallerThreadExecutor.getInstance());
        }

        return listdatasource;
    }

    private boolean increaseAndCheckIfLast()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        int j;
        i = mFinishedDataSources + 1;
        mFinishedDataSources = i;
        j = mDataSources.length;
        boolean flag;
        if (i == j)
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

    private void onDataSourceCancelled()
    {
        setFailure(new CancellationException());
    }

    private void onDataSourceFailed(DataSource datasource)
    {
        setFailure(datasource.getFailureCause());
    }

    private void onDataSourceFinished()
    {
        if (increaseAndCheckIfLast())
        {
            setResult(null, true);
        }
    }

    private void onDataSourceProgress()
    {
        float f = 0.0F;
        DataSource adatasource[] = mDataSources;
        int j = adatasource.length;
        for (int i = 0; i < j; i++)
        {
            f += adatasource[i].getProgress();
        }

        setProgress(f / (float)mDataSources.length);
    }

    public boolean close()
    {
        if (!super.close())
        {
            return false;
        }
        DataSource adatasource[] = mDataSources;
        int j = adatasource.length;
        for (int i = 0; i < j; i++)
        {
            adatasource[i].close();
        }

        return true;
    }

    public volatile Object getResult()
    {
        return getResult();
    }

    public ArrayList getResult()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = hasResult();
        if (flag) goto _L2; else goto _L1
_L1:
        ArrayList arraylist = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return arraylist;
_L2:
        ArrayList arraylist1;
        DataSource adatasource[];
        int j;
        arraylist1 = new ArrayList(mDataSources.length);
        adatasource = mDataSources;
        j = adatasource.length;
        int i = 0;
_L5:
        arraylist = arraylist1;
        if (i >= j) goto _L4; else goto _L3
_L3:
        arraylist1.add(adatasource[i].getResult());
        i++;
          goto _L5
        Exception exception;
        exception;
        throw exception;
    }

    public boolean hasResult()
    {
        this;
        JVM INSTR monitorenter ;
        if (isClosed()) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        i = mFinishedDataSources;
        j = mDataSources.length;
        if (i != j) goto _L2; else goto _L3
_L3:
        boolean flag = true;
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




}
