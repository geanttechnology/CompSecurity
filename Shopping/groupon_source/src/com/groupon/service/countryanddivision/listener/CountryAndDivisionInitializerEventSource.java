// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.countryanddivision.listener;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

// Referenced classes of package com.groupon.service.countryanddivision.listener:
//            CountryAndDivisionInitializerListener

public class CountryAndDivisionInitializerEventSource
{

    public List listenerList;

    public CountryAndDivisionInitializerEventSource()
    {
        listenerList = new Vector();
    }

    public void addCountryAndDivisionInitializerListener(CountryAndDivisionInitializerListener countryanddivisioninitializerlistener)
    {
        listenerList.add(countryanddivisioninitializerlistener);
    }

    public void fireOnCountryAndDivisionSet()
    {
        List list = listenerList;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listenerList.iterator(); iterator.hasNext(); ((CountryAndDivisionInitializerListener)iterator.next()).onCountryAndDivisionSet()) { }
        break MISSING_BLOCK_LABEL_48;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    public void fireOnException(Exception exception)
    {
        List list = listenerList;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listenerList.iterator(); iterator.hasNext(); ((CountryAndDivisionInitializerListener)iterator.next()).onException(exception)) { }
        break MISSING_BLOCK_LABEL_49;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    public void fireOnManualCountrySelectionNeeded()
    {
        List list = listenerList;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listenerList.iterator(); iterator.hasNext(); ((CountryAndDivisionInitializerListener)iterator.next()).onManualCountrySelectionNeeded()) { }
        break MISSING_BLOCK_LABEL_48;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    public void fireOnManualDivisionSelectionNeeded()
    {
        List list = listenerList;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listenerList.iterator(); iterator.hasNext(); ((CountryAndDivisionInitializerListener)iterator.next()).onManualDivisionSelectionNeeded()) { }
        break MISSING_BLOCK_LABEL_48;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    public void removeCountryAndDivisionInitializerListener(CountryAndDivisionInitializerListener countryanddivisioninitializerlistener)
    {
        listenerList.remove(countryanddivisioninitializerlistener);
    }
}
