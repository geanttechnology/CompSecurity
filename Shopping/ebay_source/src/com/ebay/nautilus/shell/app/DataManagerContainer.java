// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.io.Closeable;
import java.util.Iterator;
import java.util.LinkedList;

public final class DataManagerContainer
    implements Closeable
{
    private static final class ManagedObserver
    {

        public final DataManager dataManager;
        public Object innerObserver;

        public void register(Object obj)
        {
            if (innerObserver == obj)
            {
                return;
            }
            if (obj != null)
            {
                if (innerObserver != null)
                {
                    dataManager.swapObserver(obj, innerObserver);
                } else
                {
                    dataManager.registerObserver(obj, null);
                }
                innerObserver = obj;
                return;
            } else
            {
                unregister();
                return;
            }
        }

        public void unregister()
        {
            if (innerObserver != null)
            {
                dataManager.unregisterObserver(innerObserver);
                innerObserver = null;
            }
        }

        public ManagedObserver(DataManager datamanager)
        {
            dataManager = datamanager;
        }
    }


    private final EbayContext ebayContext;
    private final LinkedList observers = new LinkedList();

    DataManagerContainer(EbayContext ebaycontext)
    {
        ebayContext = ebaycontext;
    }

    private ManagedObserver getFromDataManager(DataManager datamanager)
    {
        for (Iterator iterator = observers.iterator(); iterator.hasNext();)
        {
            ManagedObserver managedobserver = (ManagedObserver)iterator.next();
            if (managedobserver.dataManager == datamanager)
            {
                return managedobserver;
            }
        }

        return null;
    }

    public void close()
    {
        for (Iterator iterator = observers.iterator(); iterator.hasNext(); ((ManagedObserver)iterator.next()).unregister()) { }
        observers.clear();
    }

    public void delete(com.ebay.nautilus.domain.content.DataManager.DataManagerKeyParams datamanagerkeyparams)
    {
        Iterator iterator = observers.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ManagedObserver managedobserver = (ManagedObserver)iterator.next();
            if (!managedobserver.dataManager.getParams().equals(datamanagerkeyparams))
            {
                continue;
            }
            managedobserver.unregister();
            iterator.remove();
            break;
        } while (true);
    }

    public DataManager initialize(com.ebay.nautilus.domain.content.DataManager.DataManagerKeyParams datamanagerkeyparams, Object obj)
    {
        DataManager datamanager = DataManager.get(ebayContext, datamanagerkeyparams);
        ManagedObserver managedobserver = getFromDataManager(datamanager);
        datamanagerkeyparams = managedobserver;
        if (managedobserver == null)
        {
            datamanagerkeyparams = new ManagedObserver(datamanager);
            observers.add(datamanagerkeyparams);
        }
        datamanagerkeyparams.register(obj);
        datamanager.loadData(obj);
        return datamanager;
    }
}
