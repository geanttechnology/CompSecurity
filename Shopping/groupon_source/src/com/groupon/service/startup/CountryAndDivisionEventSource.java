// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.startup;

import com.groupon.service.countryanddivision.listener.CountryAndDivisionInitializerListener;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class CountryAndDivisionEventSource
{

    private LinkedHashSet countryAndDivisionInitializerListenerList;

    public CountryAndDivisionEventSource()
    {
        countryAndDivisionInitializerListenerList = new LinkedHashSet();
    }

    public void addCountryAndDivisionInitializerListener(CountryAndDivisionInitializerListener countryanddivisioninitializerlistener)
    {
        synchronized (countryAndDivisionInitializerListenerList)
        {
            countryAndDivisionInitializerListenerList.add(countryanddivisioninitializerlistener);
        }
        return;
        countryanddivisioninitializerlistener;
        linkedhashset;
        JVM INSTR monitorexit ;
        throw countryanddivisioninitializerlistener;
    }

    public void fireOnCountryAndDivisionException(Exception exception)
    {
        LinkedHashSet linkedhashset = countryAndDivisionInitializerListenerList;
        linkedhashset;
        JVM INSTR monitorenter ;
        for (Iterator iterator = countryAndDivisionInitializerListenerList.iterator(); iterator.hasNext(); iterator.remove())
        {
            ((CountryAndDivisionInitializerListener)iterator.next()).onException(exception);
        }

        break MISSING_BLOCK_LABEL_53;
        exception;
        linkedhashset;
        JVM INSTR monitorexit ;
        throw exception;
        linkedhashset;
        JVM INSTR monitorexit ;
    }

    public void fireOnCountryAndDivisionSet()
    {
        LinkedHashSet linkedhashset = countryAndDivisionInitializerListenerList;
        linkedhashset;
        JVM INSTR monitorenter ;
        for (Iterator iterator = countryAndDivisionInitializerListenerList.iterator(); iterator.hasNext(); iterator.remove())
        {
            ((CountryAndDivisionInitializerListener)iterator.next()).onCountryAndDivisionSet();
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

    public void fireOnManualCountrySelectionNeeded()
    {
        LinkedHashSet linkedhashset = countryAndDivisionInitializerListenerList;
        linkedhashset;
        JVM INSTR monitorenter ;
        for (Iterator iterator = countryAndDivisionInitializerListenerList.iterator(); iterator.hasNext(); iterator.remove())
        {
            ((CountryAndDivisionInitializerListener)iterator.next()).onManualCountrySelectionNeeded();
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

    public void fireOnManualDivisionSelectionNeeded()
    {
        LinkedHashSet linkedhashset = countryAndDivisionInitializerListenerList;
        linkedhashset;
        JVM INSTR monitorenter ;
        for (Iterator iterator = countryAndDivisionInitializerListenerList.iterator(); iterator.hasNext(); iterator.remove())
        {
            ((CountryAndDivisionInitializerListener)iterator.next()).onManualDivisionSelectionNeeded();
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

    public void removeCountryAndDivisionInitializerListener(CountryAndDivisionInitializerListener countryanddivisioninitializerlistener)
    {
        synchronized (countryAndDivisionInitializerListenerList)
        {
            countryAndDivisionInitializerListenerList.remove(countryanddivisioninitializerlistener);
        }
        return;
        countryanddivisioninitializerlistener;
        linkedhashset;
        JVM INSTR monitorexit ;
        throw countryanddivisioninitializerlistener;
    }
}
