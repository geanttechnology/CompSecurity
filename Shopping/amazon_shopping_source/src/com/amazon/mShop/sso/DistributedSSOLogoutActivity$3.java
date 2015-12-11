// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.app.ProgressDialog;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.mShop.kiang.KiangController;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.net.CallObserver;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.pushnotification.PushNotificationManager;
import com.amazon.mShop.util.AppUtils;
import com.amazon.mShop.util.MShopPushNotificationUtils;
import com.amazon.rio.j2me.client.persistence.DataStore;

// Referenced classes of package com.amazon.mShop.sso:
//            DistributedSSOLogoutActivity, SSOUtil, AccountCookiesSyncManager

class val.deregisterDeviceTotal
    implements Callback
{

    final DistributedSSOLogoutActivity this$0;
    final CallObserver val$deregisterDeviceCall;
    final CallObserver val$deregisterDeviceTotal;
    final boolean val$isPrimaryAccount;

    public void onError(Bundle bundle)
    {
        Object obj = null;
        CallObserver callobserver = val$deregisterDeviceCall;
        String s;
        if (bundle != null)
        {
            s = bundle.toString();
        } else
        {
            s = null;
        }
        callobserver.onFailed(s);
        callobserver = val$deregisterDeviceTotal;
        s = obj;
        if (bundle != null)
        {
            s = bundle.toString();
        }
        callobserver.onFailed(s);
        SSOUtil.setLogoutTriggeredFromApplication(false);
        runOnUiThread(new Runnable() {

            final DistributedSSOLogoutActivity._cls3 this$1;

            public void run()
            {
                setResult(0);
                if (DistributedSSOLogoutActivity.access$100(this$0) != null)
                {
                    DistributedSSOLogoutActivity.access$100(this$0).dismiss();
                }
            }

            
            {
                this$1 = DistributedSSOLogoutActivity._cls3.this;
                super();
            }
        });
    }

    public void onSuccess(Bundle bundle)
    {
        val$deregisterDeviceCall.onComplete();
        SSOUtil.clearMapSSOUserDataInAllLocales(getApplicationContext());
        if (!val$isPrimaryAccount)
        {
            bundle = SSOUtil.getAuthPoolForCurrentLocale();
            com.amazon.mShop.platform.sPrimaryAccount().getDataStore().putBoolean("ignoreOptOutFirstLaunch", false, bundle);
        }
        AccountCookiesSyncManager.fetchNonAuthCookies(getApplicationContext());
        AppUtils.clearUserCoinBalance();
        KiangController.getInstance().kiangUpdate(getApplicationContext());
        com.amazon.mShop.platform.icationContext().invokeLater(new Runnable() {

            final DistributedSSOLogoutActivity._cls3 this$1;

            public void run()
            {
                User.userSignedOut();
                setResult(-1);
                AppUtils.restartApp();
                if (MShopPushNotificationUtils.isPushNotificationAvailable())
                {
                    PushNotificationManager.getInstance().enbleNotificationForAnonymousCustomer();
                }
            }

            
            {
                this$1 = DistributedSSOLogoutActivity._cls3.this;
                super();
            }
        });
        val$deregisterDeviceTotal.onComplete();
    }

    _cls2.this._cls1()
    {
        this$0 = final_distributedssologoutactivity;
        val$deregisterDeviceCall = callobserver;
        val$isPrimaryAccount = flag;
        val$deregisterDeviceTotal = CallObserver.this;
        super();
    }
}
