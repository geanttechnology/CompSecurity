// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.mShop.kiang.KiangController;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.net.CallObserver;
import com.amazon.mShop.net.ServiceCallIdentifier;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.AppUtils;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.sso:
//            CentralSSOLoginActivity, SSOUtil, AccountCookiesSyncManager, MShopCheckLogin

class this._cls0
    implements Callback
{

    final CentralSSOLoginActivity this$0;

    public void onError(Bundle bundle)
    {
        int i = bundle.getInt("com.amazon.dcp.sso.ErrorCode");
        if (i == com.amazon.identity.auth.device.api.tionError.REGISTER_FAILED.value() && bundle.getInt("errorCode") == 4)
        {
            if (Util.isEmpty(SSOUtil.getCurrentAccount(getApplicationContext())))
            {
                SSOUtil.setLoginTriggeredFromApplication(false);
                setResult(0);
                CentralSSOLoginActivity.access$300(CentralSSOLoginActivity.this);
                finish();
                return;
            } else
            {
                onSuccess(bundle);
                return;
            }
        }
        if (i == com.amazon.identity.auth.device.api.tionError.ACCOUNT_ALREADY_EXISTS.value())
        {
            onSuccess(bundle);
            return;
        } else
        {
            SSOUtil.setLoginTriggeredFromApplication(false);
            CentralSSOLoginActivity.access$100(CentralSSOLoginActivity.this, i);
            setResult(0);
            CentralSSOLoginActivity.access$400(CentralSSOLoginActivity.this);
            finish();
            return;
        }
    }

    public void onSuccess(Bundle bundle)
    {
        CallObserver callobserver = CallObserver.start(new ServiceCallIdentifier("MobileAuthenticationPlatform", "centralSSO_signin_onSuccess"));
        long l = SystemClock.elapsedRealtime();
        if (SSOUtil.DEBUG)
        {
            Log.i(CentralSSOLoginActivity.access$500(), bundle.toString());
            Log.d(CentralSSOLoginActivity.access$500(), (new StringBuilder()).append("In onSuccess:").append(l).toString());
        }
        Object obj = SSOUtil.getCurrentAccount(getApplicationContext());
        bundle = new User("", SSOUtil.getFullNameFromCustomerAttribute(((String) (obj))), false, false, null, Boolean.valueOf(false), null);
        User.saveUser(bundle);
        SSOUtil.setPreviouslySeenAmazonAccount(getApplicationContext(), ((String) (obj)));
        AccountCookiesSyncManager.syncAndWait(getApplicationContext(), true, false, ((String) (obj)));
        SSOUtil.ignoreOptOutSSOIfneeded();
        getIntent().getStringExtra("LOGIN_ORIGIN_KEY");
        obj = CentralSSOLoginActivity.this;
        (new MShopCheckLogin(getApplicationContext(), CentralSSOLoginActivity.access$600(CentralSSOLoginActivity.this), new MShopCheckLogin.Subscriber() {

            final CentralSSOLoginActivity._cls3 this$1;

            public void onCancelled()
            {
            }

            public void onComplete()
            {
                ActivityUtils.notifyUserSignedin();
                AppUtils.sendRequestCoinBalanceBroadcast(getApplicationContext());
                KiangController.getInstance().kiangUpdate(getApplicationContext());
            }

            public void onError()
            {
            }

            
            {
                this$1 = CentralSSOLoginActivity._cls3.this;
                super();
            }
        }, false)).checkLogin();
        setResult(-1);
        CentralSSOLoginActivity.access$700(CentralSSOLoginActivity.this);
        finish();
        CentralSSOLoginActivity.access$800(CentralSSOLoginActivity.this, bundle);
        callobserver.onComplete();
        if (SSOUtil.DEBUG)
        {
            long l1 = SystemClock.elapsedRealtime();
            Log.d(CentralSSOLoginActivity.access$500(), (new StringBuilder()).append("Out of onSuccess at:").append(l1).toString());
            Log.d(CentralSSOLoginActivity.access$500(), (new StringBuilder()).append("onSuccess duration = ").append(l1 - l).toString());
        }
    }

    _cls1.this._cls1()
    {
        this$0 = CentralSSOLoginActivity.this;
        super();
    }
}
