// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.core;

import com.groupon.service.core.listener.CoreServiceListener;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import roboguice.util.Ln;

public abstract class CoreService
{

    private static final int DEFAULT_RETRY_COUNT = 3;
    private List listenerList;

    public CoreService()
    {
        listenerList = new Vector();
    }

    public void addListener(CoreServiceListener coreservicelistener)
    {
        listenerList.add(coreservicelistener);
    }

    public final void doRefresh()
    {
        this;
        JVM INSTR monitorenter ;
        if (!isUpToDate()) goto _L2; else goto _L1
_L1:
        Ln.d("Startup Service %s is up to date.", new Object[] {
            getClass().getName()
        });
        fireOnRefreshSuccess();
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        int i;
        Ln.d("Startup service %s needs refresh.", new Object[] {
            getClass().getName()
        });
        i = getRetryCount();
        Exception exception;
        boolean flag;
        flag = false;
        exception = null;
_L4:
        Ln.d("Startup service %s refreshing.", new Object[] {
            getClass().getName()
        });
        fireOnRefreshStarted();
        refresh();
        Exception exception2;
        boolean flag1;
        int j;
        flag1 = true;
        j = i;
        exception2 = exception;
_L6:
        if (flag1)
        {
            break; /* Loop/switch isn't completed */
        }
        exception = exception2;
        flag = flag1;
        i = j;
        if (j > 0) goto _L4; else goto _L3
_L3:
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        fireOnRefreshSuccess();
          goto _L5
        Exception exception1;
        exception1;
        throw exception1;
        exception2;
        j = i - 1;
        flag1 = flag;
          goto _L6
        fireOnRefreshError(exception2);
          goto _L5
    }

    public void fireOnRefreshError(Exception exception)
    {
        List list = listenerList;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listenerList.iterator(); iterator.hasNext(); ((CoreServiceListener)iterator.next()).onRefreshError(this, exception)) { }
        break MISSING_BLOCK_LABEL_50;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    public void fireOnRefreshStarted()
    {
        List list = listenerList;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listenerList.iterator(); iterator.hasNext(); ((CoreServiceListener)iterator.next()).onRefreshStarted(this)) { }
        break MISSING_BLOCK_LABEL_49;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    public void fireOnRefreshSuccess()
    {
        List list = listenerList;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listenerList.iterator(); iterator.hasNext(); ((CoreServiceListener)iterator.next()).onRefreshSuccess(this)) { }
        break MISSING_BLOCK_LABEL_49;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    public int getRetryCount()
    {
        return 3;
    }

    public abstract boolean isDownloadingDataFromNetwork();

    protected abstract boolean isUpToDate();

    protected abstract void refresh()
        throws Exception;

    public void removeListener(CoreServiceListener coreservicelistener)
    {
        listenerList.remove(coreservicelistener);
    }

    public abstract void resetToNotUpToDate();
}
