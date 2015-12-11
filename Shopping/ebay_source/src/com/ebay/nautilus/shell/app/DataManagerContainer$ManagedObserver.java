// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import com.ebay.nautilus.domain.content.DataManager;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            DataManagerContainer

private static final class dataManager
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

    public (DataManager datamanager)
    {
        dataManager = datamanager;
    }
}
