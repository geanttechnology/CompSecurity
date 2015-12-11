// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.startup;

import com.groupon.service.core.CoreService;
import com.groupon.service.core.listener.CoreServiceInitializerListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class CoreServicesInitializerEventSource
{

    private LinkedHashSet coreServicesInitializerListenerList;

    public CoreServicesInitializerEventSource()
    {
        coreServicesInitializerListenerList = new LinkedHashSet();
    }

    public void addCoreServicesInitializerListener(CoreServiceInitializerListener coreserviceinitializerlistener)
    {
        synchronized (coreServicesInitializerListenerList)
        {
            coreServicesInitializerListenerList.add(coreserviceinitializerlistener);
        }
        return;
        coreserviceinitializerlistener;
        linkedhashset;
        JVM INSTR monitorexit ;
        throw coreserviceinitializerlistener;
    }

    public void fireOnCoreServicesRefreshStarted(CoreService coreservice)
    {
        LinkedHashSet linkedhashset = coreServicesInitializerListenerList;
        linkedhashset;
        JVM INSTR monitorenter ;
        for (Iterator iterator = coreServicesInitializerListenerList.iterator(); iterator.hasNext(); ((CoreServiceInitializerListener)iterator.next()).onServiceRefreshStarted(coreservice)) { }
        break MISSING_BLOCK_LABEL_47;
        coreservice;
        linkedhashset;
        JVM INSTR monitorexit ;
        throw coreservice;
        linkedhashset;
        JVM INSTR monitorexit ;
    }

    public void fireOnCoreServicesRefreshSuccessfully()
    {
        LinkedHashSet linkedhashset = coreServicesInitializerListenerList;
        linkedhashset;
        JVM INSTR monitorenter ;
        for (Iterator iterator = coreServicesInitializerListenerList.iterator(); iterator.hasNext(); iterator.remove())
        {
            ((CoreServiceInitializerListener)iterator.next()).onAllServicesRefreshCompletedSuccessfully();
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

    public void fireOnCoreServicesRefreshWithError(Collection collection)
    {
        LinkedHashSet linkedhashset = coreServicesInitializerListenerList;
        linkedhashset;
        JVM INSTR monitorenter ;
        for (Iterator iterator = coreServicesInitializerListenerList.iterator(); iterator.hasNext(); iterator.remove())
        {
            ((CoreServiceInitializerListener)iterator.next()).onAllServicesRefreshCompletedWithError(collection);
        }

        break MISSING_BLOCK_LABEL_53;
        collection;
        linkedhashset;
        JVM INSTR monitorexit ;
        throw collection;
        linkedhashset;
        JVM INSTR monitorexit ;
    }

    public void removeCoreServicesInitializerListener(CoreServiceInitializerListener coreserviceinitializerlistener)
    {
        synchronized (coreServicesInitializerListenerList)
        {
            coreServicesInitializerListenerList.remove(coreserviceinitializerlistener);
        }
        return;
        coreserviceinitializerlistener;
        linkedhashset;
        JVM INSTR monitorexit ;
        throw coreserviceinitializerlistener;
    }
}
