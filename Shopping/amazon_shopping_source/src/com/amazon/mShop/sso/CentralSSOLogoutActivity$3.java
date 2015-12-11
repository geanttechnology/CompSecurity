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

class val.callObserver
    implements Callback
{

    final CentralSSOLogoutActivity this$0;
    final CallObserver val$callObserver;

    public void onError(Bundle bundle)
    {
        CallObserver callobserver = val$callObserver;
        if (bundle != null)
        {
            bundle = bundle.toString();
        } else
        {
            bundle = null;
        }
        callobserver.onFailed(bundle);
        SSOUtil.setLogoutTriggeredFromApplication(false);
        runOnUiThread(new Runnable() {

            final CentralSSOLogoutActivity._cls3 this$1;

            public void run()
            {
                setResult(0);
                if (CentralSSOLogoutActivity.access$100(this$0) != null)
                {
                    CentralSSOLogoutActivity.access$100(this$0).dismiss();
                }
            }

            
            {
                this$1 = CentralSSOLogoutActivity._cls3.this;
                super();
            }
        });
    }

    public void onSuccess(Bundle bundle)
    {
        val$callObserver.onComplete();
        SSOUtil.clearMShopUserDataInWorldwideAuthPool(getApplicationContext());
        AccountCookiesSyncManager.fetchNonAuthCookies(getApplicationContext());
        AppUtils.clearUserCoinBalance();
        KiangController.getInstance().kiangUpdate(getApplicationContext());
        com.amazon.mShop.platform.e().invokeLater(new Runnable() {

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
        });
    }

    _cls2.this._cls1()
    {
        this$0 = final_centralssologoutactivity;
        val$callObserver = CallObserver.this;
        super();
    }
}
