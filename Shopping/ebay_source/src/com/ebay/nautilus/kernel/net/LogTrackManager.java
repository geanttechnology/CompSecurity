// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            LogTrackSweeper, LogTrackError, LogTrackConfiguration, LogTrackPerf

public class LogTrackManager
{

    private static volatile LogTrackConfiguration config;
    private static volatile boolean crashing;
    private static final ArrayList sweepers = new ArrayList();

    private LogTrackManager()
    {
    }

    public static void addLogErrorData(LogTrackError logtrackerror)
    {
        ArrayList arraylist;
        synchronized (sweepers)
        {
            arraylist = new ArrayList(sweepers);
        }
        obj = arraylist.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            LogTrackSweeper logtracksweeper = (LogTrackSweeper)((Iterator) (obj)).next();
            if (logtrackerror != null && !logtrackerror.isIgnore() && getConfig().isAplsLogErrorMessage())
            {
                logtracksweeper.addError(logtrackerror);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_78;
        logtrackerror;
        obj;
        JVM INSTR monitorexit ;
        throw logtrackerror;
    }

    public static void addLogPerfData(LogTrackPerf logtrackperf)
    {
        ArrayList arraylist;
        synchronized (sweepers)
        {
            arraylist = new ArrayList(sweepers);
        }
        obj = arraylist.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            LogTrackSweeper logtracksweeper = (LogTrackSweeper)((Iterator) (obj)).next();
            if (logtrackperf != null && !logtrackperf.isIgnore() && getConfig().isAplsTraffic())
            {
                logtracksweeper.addPerf(logtrackperf);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_78;
        logtrackperf;
        obj;
        JVM INSTR monitorexit ;
        throw logtrackperf;
    }

    public static LogTrackConfiguration getConfig()
    {
        if (config == null)
        {
            throw new IllegalStateException("LogTrackConfiguration was never registered");
        } else
        {
            return config;
        }
    }

    public static boolean isCrashing()
    {
        return crashing;
    }

    static void register(LogTrackSweeper logtracksweeper)
    {
        getConfig();
        ArrayList arraylist = sweepers;
        arraylist;
        JVM INSTR monitorenter ;
        if (sweepers.indexOf(logtracksweeper) != -1)
        {
            throw new IllegalArgumentException("Sweeper already registered");
        }
        break MISSING_BLOCK_LABEL_36;
        logtracksweeper;
        arraylist;
        JVM INSTR monitorexit ;
        throw logtracksweeper;
        sweepers.add(logtracksweeper);
        arraylist;
        JVM INSTR monitorexit ;
    }

    public static void registerConfig(LogTrackConfiguration logtrackconfiguration)
    {
        config = logtrackconfiguration;
    }

    public static void setCrashing()
    {
        crashing = true;
    }

    static void unregister(LogTrackSweeper logtracksweeper)
    {
        synchronized (sweepers)
        {
            sweepers.remove(logtracksweeper);
        }
        return;
        logtracksweeper;
        arraylist;
        JVM INSTR monitorexit ;
        throw logtracksweeper;
    }

}
