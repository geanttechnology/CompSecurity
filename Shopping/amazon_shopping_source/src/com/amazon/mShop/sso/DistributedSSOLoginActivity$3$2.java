// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.webkit.CookieSyncManager;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.mShop.kiang.KiangController;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.net.CallObserver;
import com.amazon.mShop.net.CookieBridge;
import com.amazon.mShop.net.ServiceCallIdentifier;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.AppUtils;
import com.amazon.mShop.util.Util;
import java.util.concurrent.Executor;

// Referenced classes of package com.amazon.mShop.sso:
//            DistributedSSOLoginActivity, SSOUtil, AccountCookiesSyncManager, MShopCheckLogin

class this._cls1
    implements this._cls1
{

    final pplicationContext this$1;

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

    l.prevAtMain()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/sso/DistributedSSOLoginActivity$3

/* anonymous class */
    class DistributedSSOLoginActivity._cls3
        implements Callback
    {

        final DistributedSSOLoginActivity this$0;
        final String val$nonSecureCookies;
        final String val$prevAtMain;
        final String val$secureCookies;

        public void onError(Bundle bundle)
        {
            int i = bundle.getInt("com.amazon.dcp.sso.ErrorCode");
            SSOUtil.setLoginTriggeredFromApplication(false);
            if (i == com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.ACCOUNT_ALREADY_EXISTS.value())
            {
                onSuccess(bundle);
                return;
            } else
            {
                SSOUtil.clearCurrentLocaleCookieAndCookieJar(getApplicationContext());
                CookieBridge.setCookies(getApplicationContext(), secureCookies, true);
                CookieBridge.setCookies(getApplicationContext(), nonSecureCookies, false);
                DistributedSSOLoginActivity.access$100(DistributedSSOLoginActivity.this, i);
                setResult(0);
                DistributedSSOLoginActivity.access$300(DistributedSSOLoginActivity.this);
                finish();
                return;
            }
        }

        public void onSuccess(Bundle bundle)
        {
            CallObserver callobserver = CallObserver.start(new ServiceCallIdentifier("MobileAuthenticationPlatform", "distributedSSO_signin_onSuccess"));
            final long startTime = SystemClock.elapsedRealtime();
            if (SSOUtil.DEBUG)
            {
                Log.d(DistributedSSOLoginActivity.access$400(), (new StringBuilder()).append("In onSuccess:").append(startTime).toString());
                Log.d("MAPSigninLatency", (new StringBuilder()).append("In onSuccess:").append(System.nanoTime()).toString());
            }
            final String newAccount = bundle.getString("com.amazon.dcp.sso.property.account.acctId");
            if (SSOUtil.DEBUG)
            {
                long l = SystemClock.elapsedRealtime();
                Log.d(DistributedSSOLoginActivity.access$400(), (new StringBuilder()).append("after getCurrentAccount  ").append(l - startTime).toString());
            }
            SSOUtil.setTempAccountForCurrentLocale(newAccount);
            bundle = new User("", SSOUtil.getFullNameFromCustomerAttribute(newAccount), false, false, null, Boolean.valueOf(false), null);
            User.saveUser(bundle);
            DistributedSSOLoginActivity.access$700().execute(new DistributedSSOLoginActivity._cls3._cls1());
            if (SSOUtil.DEBUG)
            {
                long l1 = SystemClock.elapsedRealtime();
                Log.d(DistributedSSOLoginActivity.access$400(), (new StringBuilder()).append("after post run accountCustomKeyMapping  ").append(l1 - startTime).toString());
            }
            CookieSyncManager.getInstance().sync();
            String s = CookieBridge.getAtMainCookie(getApplicationContext());
            if (Util.isEmpty(s) || s.equals(prevAtMain))
            {
                AccountCookiesSyncManager.syncAndWait(getApplicationContext(), true, false, newAccount);
            }
            if (SSOUtil.DEBUG)
            {
                long l2 = SystemClock.elapsedRealtime();
                Log.d(DistributedSSOLoginActivity.access$400(), (new StringBuilder()).append("after compare atMain  ").append(l2 - startTime).toString());
            }
            SSOUtil.setPreviouslySeenAmazonAccount(getApplicationContext(), newAccount);
            SSOUtil.ignoreOptOutSSOIfneeded();
            getIntent().getStringExtra("LOGIN_ORIGIN_KEY");
            newAccount = DistributedSSOLoginActivity.this;
            if (SSOUtil.DEBUG)
            {
                long l3 = SystemClock.elapsedRealtime();
                Log.d(DistributedSSOLoginActivity.access$400(), (new StringBuilder()).append("before issue async checkLogin  ").append(l3 - startTime).toString());
            }
            (new MShopCheckLogin(getApplicationContext(), DistributedSSOLoginActivity.access$800(DistributedSSOLoginActivity.this), new DistributedSSOLoginActivity._cls3._cls2(), false)).checkLogin();
            if (SSOUtil.DEBUG)
            {
                long l4 = SystemClock.elapsedRealtime();
                Log.d(DistributedSSOLoginActivity.access$400(), (new StringBuilder()).append("after issue async checkLogin  ").append(l4 - startTime).toString());
            }
            setResult(-1);
            DistributedSSOLoginActivity.access$900(DistributedSSOLoginActivity.this);
            finish();
            DistributedSSOLoginActivity.access$1000(DistributedSSOLoginActivity.this, bundle);
            callobserver.onComplete();
            if (SSOUtil.DEBUG)
            {
                long l5 = SystemClock.elapsedRealtime();
                Log.d(DistributedSSOLoginActivity.access$400(), (new StringBuilder()).append("Out of onSuccess at:").append(l5).toString());
                Log.d(DistributedSSOLoginActivity.access$400(), (new StringBuilder()).append("onSuccess duration = ").append(l5 - startTime).toString());
                Log.d("MAPSigninLatency", (new StringBuilder()).append("Out of onSuccess:").append(System.nanoTime()).toString());
            }
        }

            
            {
                this$0 = final_distributedssologinactivity;
                secureCookies = s;
                nonSecureCookies = s1;
                prevAtMain = String.this;
                super();
            }

        // Unreferenced inner class com/amazon/mShop/sso/DistributedSSOLoginActivity$3$1

/* anonymous class */
        class DistributedSSOLoginActivity._cls3._cls1
            implements Runnable
        {

            final DistributedSSOLoginActivity._cls3 this$1;
            final String val$newAccount;
            final long val$startTime;

            public void run()
            {
                if (DistributedSSOLoginActivity.access$500())
                {
                    long l = SystemClock.elapsedRealtime();
                    Log.d(DistributedSSOLoginActivity.access$400(), (new StringBuilder()).append("before addAccountCustomeKey:").append(l - startTime).toString());
                }
                SSOUtil.addAccountCustomKeyMapping(newAccount);
                if (DistributedSSOLoginActivity.access$600())
                {
                    long l1 = SystemClock.elapsedRealtime();
                    Log.d(DistributedSSOLoginActivity.access$400(), (new StringBuilder()).append("after addAccountCustomKey:").append(l1 - startTime).toString());
                }
            }

                    
                    {
                        this$1 = DistributedSSOLoginActivity._cls3.this;
                        startTime = l;
                        newAccount = s;
                        super();
                    }
        }

    }

}
