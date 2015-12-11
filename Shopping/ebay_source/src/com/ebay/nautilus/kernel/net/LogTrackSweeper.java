// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.ArrayList;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            LogTrackManager, LogTrackError, LogTrackPerf, LogTrackConfiguration

public abstract class LogTrackSweeper
{

    protected final EbayContext ebayContext;
    protected ArrayList errList;
    private final Object errListLock = new Object();
    protected final int maxErrItems;
    protected final int maxPerfItems;
    protected ArrayList perfList;
    private final Object perfListLock = new Object();

    protected LogTrackSweeper(EbayContext ebaycontext, int i, int j)
    {
        getConfig();
        ebayContext = ebaycontext;
        maxPerfItems = i;
        maxErrItems = j;
        perfList = new ArrayList();
        errList = new ArrayList();
    }

    public void addError(LogTrackError logtrackerror)
    {
        synchronized (errListLock)
        {
            if (errList.size() < maxErrItems)
            {
                errList.add(logtrackerror);
            }
        }
        return;
        logtrackerror;
        obj;
        JVM INSTR monitorexit ;
        throw logtrackerror;
    }

    public void addPerf(LogTrackPerf logtrackperf)
    {
        synchronized (perfListLock)
        {
            if (perfList.size() < maxPerfItems)
            {
                perfList.add(logtrackperf);
            }
        }
        return;
        logtrackperf;
        obj;
        JVM INSTR monitorexit ;
        throw logtrackperf;
    }

    protected int errListSize()
    {
        int i;
        synchronized (errListLock)
        {
            i = errList.size();
        }
        return i;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected LogTrackConfiguration getConfig()
    {
        return LogTrackManager.getConfig();
    }

    protected boolean isErrorListEmpty()
    {
        boolean flag;
        synchronized (errListLock)
        {
            flag = errList.isEmpty();
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected boolean isPerfListEmpty()
    {
        boolean flag;
        synchronized (perfListLock)
        {
            flag = perfList.isEmpty();
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected int perfListSize()
    {
        int i;
        synchronized (perfListLock)
        {
            i = perfList.size();
        }
        return i;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void register()
    {
        LogTrackManager.register(this);
    }

    protected ArrayList takeErrorList()
    {
label0:
        {
            synchronized (errListLock)
            {
                if (!errList.isEmpty())
                {
                    break label0;
                }
            }
            return null;
        }
        ArrayList arraylist;
        arraylist = errList;
        errList = new ArrayList();
        obj;
        JVM INSTR monitorexit ;
        return arraylist;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected ArrayList takePerfList()
    {
label0:
        {
            synchronized (perfListLock)
            {
                if (!perfList.isEmpty())
                {
                    break label0;
                }
            }
            return null;
        }
        ArrayList arraylist;
        arraylist = perfList;
        perfList = new ArrayList();
        obj;
        JVM INSTR monitorexit ;
        return arraylist;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void unregister()
    {
        LogTrackManager.unregister(this);
    }
}
