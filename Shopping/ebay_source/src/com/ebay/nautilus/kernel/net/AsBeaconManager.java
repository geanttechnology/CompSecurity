// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import java.util.List;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            AsBeacon, LogTrackPerf, LogTrackManager, AsMark

public abstract class AsBeaconManager
{

    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo(com/ebay/nautilus/kernel/net/AsBeaconManager.getSimpleName(), 3, "debug logger for AsBeaconManager");
    private volatile AsBeacon current;
    protected volatile int id;

    public AsBeaconManager()
    {
    }

    public void addMark(AsBeacon asbeacon, AsMark asmark)
    {
        if (asbeacon == null)
        {
            if (logger.isLoggable)
            {
                logger.log("can't add mark, null beacon");
            }
            return;
        }
        if (logger.isLoggable)
        {
            logger.log((new StringBuilder()).append("adding mark ").append(asmark).append(" to beacon ").append(asbeacon).toString());
        }
        asbeacon.addMark(asmark);
        asbeacon = asbeacon.clone();
        asbeacon.clearAndSetMark(asmark);
        LogTrackManager.addLogPerfData(new LogTrackPerf(asbeacon));
    }

    public AsBeacon createCurrentBeacon(String s, String s1, List list, long l)
    {
        this;
        JVM INSTR monitorenter ;
        current = new AsBeacon(nextIdentifier(), s, s1, list, l);
        if (logger.isLoggable)
        {
            logger.log((new StringBuilder()).append("create beacon ").append(current).toString());
        }
        s = current;
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public AsBeacon currentBeacon()
    {
        this;
        JVM INSTR monitorenter ;
        AsBeacon asbeacon;
        if (logger.isLoggable)
        {
            logger.log((new StringBuilder()).append("retrieve current beacon ").append(current).toString());
        }
        asbeacon = current;
        this;
        JVM INSTR monitorexit ;
        return asbeacon;
        Exception exception;
        exception;
        throw exception;
    }

    protected int nextIdentifier()
    {
        int i = id + 1;
        id = i;
        return i;
    }

    public void retireBeacon(AsBeacon asbeacon)
    {
        this;
        JVM INSTR monitorenter ;
        if (asbeacon != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (logger.isLoggable)
        {
            logger.log((new StringBuilder()).append("retiring beacon ").append(asbeacon.activityName).append(" id=").append(asbeacon.id).toString());
        }
        if (asbeacon != current) goto _L4; else goto _L3
_L3:
        if (logger.isLoggable)
        {
            logger.log("beacon retired");
        }
        current = null;
          goto _L1
        asbeacon;
        throw asbeacon;
_L4:
        if (!logger.isLoggable) goto _L1; else goto _L5
_L5:
        logger.log("beacon isn't current");
          goto _L1
    }

}
