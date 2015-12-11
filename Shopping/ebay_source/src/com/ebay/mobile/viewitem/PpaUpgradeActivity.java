// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.ebay.common.UserCache;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.ShowWebViewActivity;
import com.ebay.mobile.checkout.BaseCheckoutActivity;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.AddressDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.List;

public class PpaUpgradeActivity extends ShowWebViewActivity
{
    private class AddressDataManagerObserver extends com.ebay.nautilus.domain.content.dm.AddressDataManager.SimpleObserver
    {

        final PpaUpgradeActivity this$0;

        public void onAddressesChanged(AddressDataManager addressdatamanager, Content content, boolean flag)
        {
            if (!isFinishing())
            {
                if (!content.getStatus().hasError() && flag)
                {
                    BaseCheckoutActivity.handleDefaultAddressChange(PpaUpgradeActivity.this, userContextDataManager, (List)content.getData(), true, "PPA Upgrade");
                }
                if (onDoneReached)
                {
                    finish();
                    return;
                }
            }
        }

        private AddressDataManagerObserver()
        {
            this$0 = PpaUpgradeActivity.this;
            super();
        }

    }


    private AddressDataManager addressDataManager;
    private AddressDataManagerObserver addressDmObserver;
    private boolean onDoneReached;
    private UserContextDataManager userContextDataManager;

    public PpaUpgradeActivity()
    {
        onDoneReached = false;
    }

    public static void start(Activity activity)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/viewitem/PpaUpgradeActivity);
        intent.putExtra("url", MyApp.getDeviceConfiguration().ppaUpgradeUrl());
        intent.putExtra("android.intent.extra.TITLE", activity.getString(0x7f0707aa));
        activity.startActivity(intent);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        addressDmObserver = new AddressDataManagerObserver();
        initDataManagers();
    }

    protected void onDone()
    {
        onDoneReached = true;
        super.onDone(false);
        if (-1 == getWebViewResultCode())
        {
            addressDataManager.forceReloadData();
            (new UserCache(this)).refreshUserDetails();
            return;
        } else
        {
            finish();
            return;
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        addressDataManager = (AddressDataManager)datamanagercontainer.initialize(new com.ebay.nautilus.domain.content.dm.AddressDataManager.KeyParams("Shipping"), addressDmObserver);
        addressDataManager.flush();
        userContextDataManager = (UserContextDataManager)datamanagercontainer.initialize(UserContextDataManager.KEY, null);
    }

    protected void readIntent()
    {
        super.readIntent();
        useSso = true;
    }


}
