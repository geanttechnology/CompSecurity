// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.upgrade;

import com.amazon.mShop.control.BaseController;
import com.amazon.mShop.control.Cancellable;
import com.amazon.mShop.control.GenericSubscriber;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.control.TaskCallback;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.CheckUpgradeResponseListener;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.UpgradeRequest;
import com.amazon.rio.j2me.client.services.mShop.UpgradeResponse;

// Referenced classes of package com.amazon.mShop.upgrade:
//            UpgradeSubscriber

public class UpgradeController extends BaseController
    implements Cancellable, CheckUpgradeResponseListener
{

    private UpgradeSubscriber mSubscriber;

    public UpgradeController()
    {
    }

    public void checkForUpgrade(TaskCallback taskcallback)
    {
        serviceCallStarted(ServiceController.getMShopService().checkUpgrade(new UpgradeRequest(), this), taskcallback);
    }

    public void completed(UpgradeResponse upgraderesponse, ServiceCall servicecall)
    {
        if (upgraderesponse != null)
        {
            upgraderesponse = upgraderesponse.getUpgradeInfo();
            if (mSubscriber != null)
            {
                mSubscriber.onCompeleted(upgraderesponse);
            }
        }
        serviceCallCompleted();
    }

    protected volatile GenericSubscriber getSubscriber()
    {
        return getSubscriber();
    }

    protected UpgradeSubscriber getSubscriber()
    {
        return mSubscriber;
    }

    public void setSubscriber(UpgradeSubscriber upgradesubscriber)
    {
        mSubscriber = upgradesubscriber;
    }
}
