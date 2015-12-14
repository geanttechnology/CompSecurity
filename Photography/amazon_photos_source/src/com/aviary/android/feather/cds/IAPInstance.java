// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import com.aviary.android.feather.cds.billing.util.IabException;
import com.aviary.android.feather.cds.billing.util.IabResult;
import com.aviary.android.feather.cds.billing.util.Inventory;
import com.aviary.android.feather.common.utils.IDisposable;
import java.util.List;

public interface IAPInstance
    extends IDisposable
{

    public abstract IabResult getResult();

    public abstract boolean hasPurchase(String s)
        throws IabException;

    public abstract boolean hasSubscription(String s)
        throws IabException;

    public abstract boolean isAvailable();

    public abstract boolean isDisposed();

    public abstract boolean isSetupDone();

    public abstract Inventory queryInventory(boolean flag, List list, List list1)
        throws IabException;

    public abstract Inventory queryPurchases()
        throws IabException;

    public abstract void startSetup(com.aviary.android.feather.cds.billing.util.IabHelper.OnIabSetupFinishedListener oniabsetupfinishedlistener);
}
