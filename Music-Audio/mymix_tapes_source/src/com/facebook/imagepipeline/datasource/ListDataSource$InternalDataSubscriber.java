// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.datasource;

import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;

// Referenced classes of package com.facebook.imagepipeline.datasource:
//            ListDataSource

private class <init>
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
        ListDataSource.access$200(ListDataSource.this);
    }

    public void onFailure(DataSource datasource)
    {
        ListDataSource.access$100(ListDataSource.this, datasource);
    }

    public void onNewResult(DataSource datasource)
    {
        if (datasource.isFinished() && tryFinish())
        {
            ListDataSource.access$300(ListDataSource.this);
        }
    }

    public void onProgressUpdate(DataSource datasource)
    {
        ListDataSource.access$400(ListDataSource.this);
    }

    private Q()
    {
        this$0 = ListDataSource.this;
        super();
        mFinished = false;
    }

    mFinished(mFinished mfinished)
    {
        this();
    }
}
