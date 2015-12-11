// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.startup;

import com.groupon.service.upgrade.listener.UpgradeManagerListener;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class UpgradeEventSource
{

    private LinkedHashSet upgradeManagerListenerList;

    public UpgradeEventSource()
    {
        upgradeManagerListenerList = new LinkedHashSet();
    }

    public void addUpgradeManagerListener(UpgradeManagerListener upgrademanagerlistener)
    {
        synchronized (upgradeManagerListenerList)
        {
            upgradeManagerListenerList.add(upgrademanagerlistener);
        }
        return;
        upgrademanagerlistener;
        linkedhashset;
        JVM INSTR monitorexit ;
        throw upgrademanagerlistener;
    }

    public void fireOnUpgradeSuccess()
    {
        LinkedHashSet linkedhashset = upgradeManagerListenerList;
        linkedhashset;
        JVM INSTR monitorenter ;
        for (Iterator iterator = upgradeManagerListenerList.iterator(); iterator.hasNext(); iterator.remove())
        {
            ((UpgradeManagerListener)iterator.next()).onUpgradeSuccess();
        }

        break MISSING_BLOCK_LABEL_52;
        Exception exception;
        exception;
        linkedhashset;
        JVM INSTR monitorexit ;
        throw exception;
        linkedhashset;
        JVM INSTR monitorexit ;
    }

    public void removeUpgradeManagerListener(UpgradeManagerListener upgrademanagerlistener)
    {
        synchronized (upgradeManagerListenerList)
        {
            upgradeManagerListenerList.remove(upgrademanagerlistener);
        }
        return;
        upgrademanagerlistener;
        linkedhashset;
        JVM INSTR monitorexit ;
        throw upgrademanagerlistener;
    }
}
