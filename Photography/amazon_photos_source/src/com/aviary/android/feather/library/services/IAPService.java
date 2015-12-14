// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services;

import android.content.Intent;
import com.aviary.android.feather.cds.IAPInstance;
import com.aviary.android.feather.cds.IAPWrapper;
import com.aviary.android.feather.cds.billing.util.IabException;
import com.aviary.android.feather.cds.billing.util.IabResult;
import com.aviary.android.feather.cds.billing.util.Inventory;
import java.util.List;

// Referenced classes of package com.aviary.android.feather.library.services:
//            BaseContextService, LocalDataService, IAviaryController

public class IAPService extends BaseContextService
    implements IAPInstance
{

    public static final int PURCHASE_FLOW_REQUEST_CODE = com/aviary/android/feather/library/services/IAPService.hashCode();
    IAPWrapper mWrapper;
    private final Object mWrapperLock = new Object();

    public IAPService(IAviaryController iaviarycontroller)
    {
        super(iaviarycontroller);
    }

    public void dispose()
    {
        synchronized (mWrapperLock)
        {
            if (mWrapper != null)
            {
                mWrapper.dispose();
            }
            mWrapper = null;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public IabResult getResult()
    {
        if (getWrapper() != null)
        {
            return getWrapper().getResult();
        } else
        {
            return null;
        }
    }

    public final IAPWrapper getWrapper()
    {
        synchronized (mWrapperLock)
        {
            if (mWrapper == null && getContext() != null)
            {
                LocalDataService localdataservice = (LocalDataService)getContext().getService(com/aviary/android/feather/library/services/LocalDataService);
                mWrapper = IAPWrapper.createNew(getContext().getBaseContext(), (String)localdataservice.getIntentExtra("extra-billing-public-key", ""));
            }
        }
        return mWrapper;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean handleActivityResult(int i, int j, Intent intent)
    {
        return getWrapper().handleActivityResult(i, j, intent);
    }

    public boolean hasPurchase(String s)
        throws IabException
    {
        return getWrapper().hasPurchase(s);
    }

    public boolean hasSubscription(String s)
        throws IabException
    {
        return getWrapper().hasSubscription(s);
    }

    public boolean isAvailable()
    {
        if (getWrapper() != null)
        {
            return getWrapper().isAvailable();
        } else
        {
            return false;
        }
    }

    public boolean isDisposed()
    {
        if (getWrapper() != null)
        {
            return getWrapper().isDisposed();
        } else
        {
            return true;
        }
    }

    public boolean isSetupDone()
    {
        if (getWrapper() != null)
        {
            return getWrapper().isSetupDone();
        } else
        {
            return false;
        }
    }

    public void launchPurchaseFlow(String s, com.aviary.android.feather.cds.billing.util.IabHelper.OnIabPurchaseFinishedListener oniabpurchasefinishedlistener, String s1)
    {
        getWrapper().launchPurchaseFlow(getContext().getBaseActivity(), s, PURCHASE_FLOW_REQUEST_CODE, oniabpurchasefinishedlistener, s1);
    }

    public Inventory queryInventory(boolean flag, List list, List list1)
        throws IabException
    {
        return getWrapper().queryInventory(flag, list, list1);
    }

    public Inventory queryPurchases()
        throws IabException
    {
        return getWrapper().queryPurchases();
    }

    public void startSetup(com.aviary.android.feather.cds.billing.util.IabHelper.OnIabSetupFinishedListener oniabsetupfinishedlistener)
    {
        getWrapper().startSetup(oniabsetupfinishedlistener);
    }

}
