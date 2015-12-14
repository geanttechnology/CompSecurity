// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.aviary.android.feather.cds.billing.util.IabException;
import com.aviary.android.feather.cds.billing.util.IabHelper;
import com.aviary.android.feather.cds.billing.util.IabResult;
import com.aviary.android.feather.cds.billing.util.Inventory;
import com.aviary.android.feather.cds.billing.util.Purchase;
import com.aviary.android.feather.common.log.LoggerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.aviary.android.feather.cds:
//            IAPInstance

public class IAPWrapper
    implements IAPInstance
{

    private final IabHelper helper;
    com.aviary.android.feather.common.log.LoggerFactory.Logger logger;
    private IabResult mResult;

    IAPWrapper(Context context, String s)
    {
        logger = LoggerFactory.getLogger(com/aviary/android/feather/cds/IAPWrapper.getSimpleName(), com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
        logger.info("IAPWrapper::ctor");
        if (TextUtils.isEmpty(s))
        {
            logger.error("EMPTY publicKey");
        }
        helper = new IabHelper(context, s);
        helper.enableDebugLogging(false);
    }

    public static IAPWrapper createNew(Context context, String s)
    {
        return new IAPWrapper(context, s);
    }

    public static boolean verifyDeveloperPayload(Purchase purchase)
    {
        purchase.getDeveloperPayload();
        return true;
    }

    public void dispose()
    {
        logger.info("dispose");
        helper.dispose();
    }

    public void enableDebugLogging(boolean flag)
    {
        helper.enableDebugLogging(flag);
    }

    public List getPurchasedItems(List list)
        throws IabException, IllegalStateException
    {
        logger.info("getRestoreListFromInventory: %s", new Object[] {
            list
        });
        Object obj = new ArrayList();
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ((List) (obj)).add(((PacksColumns.PackCursorWrapper)iterator.next()).getIdentifier())) { }
        obj = queryInventory(false, null, null);
        if (obj != null)
        {
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                PacksColumns.PackCursorWrapper packcursorwrapper = (PacksColumns.PackCursorWrapper)list.next();
                if (((Inventory) (obj)).hasPurchase(packcursorwrapper.getIdentifier()))
                {
                    arraylist.add(packcursorwrapper);
                }
            } while (true);
        }
        return arraylist;
    }

    public IabResult getResult()
    {
        return mResult;
    }

    public boolean handleActivityResult(int i, int j, Intent intent)
    {
        return helper.handleActivityResult(i, j, intent);
    }

    public boolean hasPurchase(String s)
        throws IabException
    {
        logger.info("hasPurchase: %s", new Object[] {
            s
        });
        ArrayList arraylist = new ArrayList();
        arraylist.add(s);
        return queryInventory(false, arraylist).hasPurchase(s);
    }

    public boolean hasSubscription(String s)
        throws IabException
    {
        logger.info("hasPurchase: %s", new Object[] {
            s
        });
        ArrayList arraylist = new ArrayList();
        arraylist.add(s);
        return queryInventory(false, null, arraylist).hasPurchase(s);
    }

    public boolean isAvailable()
    {
        return helper.isAvailable();
    }

    public boolean isDisposed()
    {
        return helper.isDisposed();
    }

    public boolean isSetupDone()
    {
        return helper.isSetupDone();
    }

    public void launchPurchaseFlow(Activity activity, String s, int i, com.aviary.android.feather.cds.billing.util.IabHelper.OnIabPurchaseFinishedListener oniabpurchasefinishedlistener, String s1)
    {
        helper.launchPurchaseFlow(activity, s, i, oniabpurchasefinishedlistener, s1);
    }

    public void launchSubscriptionPurchaseFlow(Activity activity, String s, int i, com.aviary.android.feather.cds.billing.util.IabHelper.OnIabPurchaseFinishedListener oniabpurchasefinishedlistener, String s1)
    {
        helper.launchSubscriptionPurchaseFlow(activity, s, i, oniabpurchasefinishedlistener, s1);
    }

    public Inventory queryInventory(boolean flag, List list)
        throws IabException
    {
        logger.info("queryInventory: %b, %s", new Object[] {
            Boolean.valueOf(flag), list
        });
        return queryInventory(flag, list, null);
    }

    public Inventory queryInventory(boolean flag, List list, List list1)
        throws IabException
    {
        logger.info("queryInventory: %b, %s, %s", new Object[] {
            Boolean.valueOf(flag), list, list1
        });
        return helper.queryInventory(flag, list, list1);
    }

    public void queryInventoryAsync(com.aviary.android.feather.cds.billing.util.IabHelper.QueryInventoryFinishedListener queryinventoryfinishedlistener, ArrayList arraylist)
    {
        helper.queryInventoryAsync(queryinventoryfinishedlistener);
    }

    public void queryInventoryAsync(boolean flag, com.aviary.android.feather.cds.billing.util.IabHelper.QueryInventoryFinishedListener queryinventoryfinishedlistener)
    {
        helper.queryInventoryAsync(flag, queryinventoryfinishedlistener);
    }

    public void queryInventoryAsync(boolean flag, List list, com.aviary.android.feather.cds.billing.util.IabHelper.QueryInventoryFinishedListener queryinventoryfinishedlistener)
    {
        queryInventoryAsync(flag, list, null, queryinventoryfinishedlistener);
    }

    public void queryInventoryAsync(boolean flag, List list, List list1, com.aviary.android.feather.cds.billing.util.IabHelper.QueryInventoryFinishedListener queryinventoryfinishedlistener)
    {
        helper.queryInventoryAsync(flag, list, list1, queryinventoryfinishedlistener);
    }

    public Inventory queryPurchases()
        throws IabException
    {
        logger.info("queryPurchases");
        return queryInventory(false, null, null);
    }

    public void startSetup(final com.aviary.android.feather.cds.billing.util.IabHelper.OnIabSetupFinishedListener listener)
    {
        logger.info("startSetup");
        if (helper.isSetupDone())
        {
            if (listener != null)
            {
                listener.onIabSetupFinished(mResult);
            }
            return;
        } else
        {
            listener = new com.aviary.android.feather.cds.billing.util.IabHelper.OnIabSetupFinishedListener() {

                final IAPWrapper this$0;
                final com.aviary.android.feather.cds.billing.util.IabHelper.OnIabSetupFinishedListener val$listener;

                public void onIabSetupFinished(IabResult iabresult)
                {
                    logger.info("onIabSetupFinished: %s", new Object[] {
                        iabresult
                    });
                    mResult = iabresult;
                    if (listener != null)
                    {
                        listener.onIabSetupFinished(iabresult);
                    }
                }

            
            {
                this$0 = IAPWrapper.this;
                listener = oniabsetupfinishedlistener;
                super();
            }
            };
            helper.startSetup(listener);
            return;
        }
    }


/*
    static IabResult access$002(IAPWrapper iapwrapper, IabResult iabresult)
    {
        iapwrapper.mResult = iabresult;
        return iabresult;
    }

*/
}
