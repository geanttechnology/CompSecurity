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

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        setResult(0);
        if (DistributedSSOLogoutActivity.access$100(_fld0) != null)
        {
            DistributedSSOLogoutActivity.access$100(_fld0).dismiss();
        }
    }

    l.deregisterDeviceTotal()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/sso/DistributedSSOLogoutActivity$3

/* anonymous class */
    class DistributedSSOLogoutActivity._cls3
        implements Callback
    {

        final DistributedSSOLogoutActivity this$0;
        final CallObserver val$deregisterDeviceCall;
        final CallObserver val$deregisterDeviceTotal;
        final boolean val$isPrimaryAccount;

        public void onError(Bundle bundle)
        {
            Object obj = null;
            CallObserver callobserver = deregisterDeviceCall;
            String s;
            if (bundle != null)
            {
                s = bundle.toString();
            } else
            {
                s = null;
            }
            callobserver.onFailed(s);
            callobserver = deregisterDeviceTotal;
            s = obj;
            if (bundle != null)
            {
                s = bundle.toString();
            }
            callobserver.onFailed(s);
            SSOUtil.setLogoutTriggeredFromApplication(false);
            runOnUiThread(new DistributedSSOLogoutActivity._cls3._cls2());
        }

        public void onSuccess(Bundle bundle)
        {
            deregisterDeviceCall.onComplete();
            SSOUtil.clearMapSSOUserDataInAllLocales(getApplicationContext());
            if (!isPrimaryAccount)
            {
                bundle = SSOUtil.getAuthPoolForCurrentLocale();
                com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putBoolean("ignoreOptOutFirstLaunch", false, bundle);
            }
            AccountCookiesSyncManager.fetchNonAuthCookies(getApplicationContext());
            AppUtils.clearUserCoinBalance();
            KiangController.getInstance().kiangUpdate(getApplicationContext());
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new DistributedSSOLogoutActivity._cls3._cls1());
            deregisterDeviceTotal.onComplete();
        }

            
            {
                this$0 = final_distributedssologoutactivity;
                deregisterDeviceCall = callobserver;
                isPrimaryAccount = flag;
                deregisterDeviceTotal = CallObserver.this;
                super();
            }

        // Unreferenced inner class com/amazon/mShop/sso/DistributedSSOLogoutActivity$3$1

/* anonymous class */
        class DistributedSSOLogoutActivity._cls3._cls1
            implements Runnable
        {

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
        }

    }

}
