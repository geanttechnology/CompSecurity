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

// Referenced classes of package com.amazon.mShop.sso:
//            CentralSSOLogoutActivity, SSOUtil, AccountCookiesSyncManager

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        setResult(0);
        if (CentralSSOLogoutActivity.access$100(_fld0) != null)
        {
            CentralSSOLogoutActivity.access$100(_fld0).dismiss();
        }
    }

    l.callObserver()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/sso/CentralSSOLogoutActivity$3

/* anonymous class */
    class CentralSSOLogoutActivity._cls3
        implements Callback
    {

        final CentralSSOLogoutActivity this$0;
        final CallObserver val$callObserver;

        public void onError(Bundle bundle)
        {
            CallObserver callobserver = callObserver;
            if (bundle != null)
            {
                bundle = bundle.toString();
            } else
            {
                bundle = null;
            }
            callobserver.onFailed(bundle);
            SSOUtil.setLogoutTriggeredFromApplication(false);
            runOnUiThread(new CentralSSOLogoutActivity._cls3._cls2());
        }

        public void onSuccess(Bundle bundle)
        {
            callObserver.onComplete();
            SSOUtil.clearMShopUserDataInWorldwideAuthPool(getApplicationContext());
            AccountCookiesSyncManager.fetchNonAuthCookies(getApplicationContext());
            AppUtils.clearUserCoinBalance();
            KiangController.getInstance().kiangUpdate(getApplicationContext());
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new CentralSSOLogoutActivity._cls3._cls1());
        }

            
            {
                this$0 = final_centralssologoutactivity;
                callObserver = CallObserver.this;
                super();
            }

        // Unreferenced inner class com/amazon/mShop/sso/CentralSSOLogoutActivity$3$1

/* anonymous class */
        class CentralSSOLogoutActivity._cls3._cls1
            implements Runnable
        {

            final CentralSSOLogoutActivity._cls3 this$1;

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
                        this$1 = CentralSSOLogoutActivity._cls3.this;
                        super();
                    }
        }

    }

}
