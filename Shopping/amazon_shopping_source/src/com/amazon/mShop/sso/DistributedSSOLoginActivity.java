// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.webkit.CookieSyncManager;
import android.widget.Toast;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.api.SigninOption;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.kiang.KiangController;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.net.CallObserver;
import com.amazon.mShop.net.CookieBridge;
import com.amazon.mShop.net.ServiceCallIdentifier;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.AppUtils;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.Util;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Referenced classes of package com.amazon.mShop.sso:
//            SSOUtil, AccountCookiesSyncManager, MShopCheckLogin

public class DistributedSSOLoginActivity extends AmazonActivity
{

    private static final String TAG = com/amazon/mShop/sso/DistributedSSOLoginActivity.getSimpleName();
    private static final Executor sExecutor = Executors.newFixedThreadPool(1);
    private boolean mIsCreateNewAccount;
    private boolean mUserInitiatedLogin;

    public DistributedSSOLoginActivity()
    {
        mIsCreateNewAccount = false;
        mUserInitiatedLogin = false;
    }

    private static Bundle buildBundleParams(Context context)
    {
        Bundle bundle = new Bundle();
        bundle.putString("com.amazon.identity.ap.domain", CookieBridge.getCookieDomain(context, true).substring(1));
        String s = ConfigUtils.getString(context, com.amazon.mShop.android.lib.R.string.config_map_auth_portal_associate_handle);
        if (s != null)
        {
            bundle.putString("com.amazon.identity.ap.assoc_handle", s);
        }
        context = ConfigUtils.getString(context, com.amazon.mShop.android.lib.R.string.config_map_auth_portal_pageid);
        if (!Util.isEmpty(context))
        {
            bundle.putString("com.amazon.identity.ap.pageid", context);
        }
        bundle.putSerializable("progressbar_state", com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ProgressBarState.SPINNER_MEDIUM);
        bundle.putSerializable("progressbar_position", com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ScreenPosition.CENTER_CENTER);
        return bundle;
    }

    private void confirmCredentials(String s)
    {
        MAPAccountManager mapaccountmanager = SSOUtil.getMAPAccountManager(getApplicationContext());
        Bundle bundle = buildBundleParams(getApplicationContext());
        setKeepTopActivityFlag();
        mapaccountmanager.confirmCredential(this, s, bundle, new Callback() {

            final DistributedSSOLoginActivity this$0;
            final String val$account;
            final String val$prevAtMain;

            public void onError(Bundle bundle1)
            {
                int i = bundle1.getInt("com.amazon.dcp.sso.ErrorCode");
                DistributedSSOLoginActivity.showErrorToast(DistributedSSOLoginActivity.this, i);
                setResult(0);
                clearKeepTopActivityFlag();
                finish();
            }

            public void onSuccess(Bundle bundle1)
            {
                CookieSyncManager.getInstance().sync();
                bundle1 = CookieBridge.getAtMainCookie(getApplicationContext());
                if (Util.isEmpty(bundle1) || bundle1.equals(prevAtMain))
                {
                    AccountCookiesSyncManager.syncAndWait(getApplicationContext(), true, false, account);
                }
                (new MShopCheckLogin(getApplicationContext(), false, null, false)).checkLogin();
                setResult(-1);
                clearKeepTopActivityFlag();
                finish();
            }

            
            {
                this$0 = DistributedSSOLoginActivity.this;
                prevAtMain = s;
                account = s1;
                super();
            }
        });
    }

    private void forceRegistration()
    {
        MAPAccountManager mapaccountmanager = SSOUtil.getMAPAccountManager(getApplicationContext());
        SSOUtil.setLoginTriggeredFromApplication(true);
        Bundle bundle = buildBundleParams(getApplicationContext());
        bundle.putBoolean("com.amazon.dcp.sso.AddAccount.options.AddAsSecondary", true);
        final String secureCookies = CookieBridge.getCookiesOfCurrentLocale(getApplicationContext(), true);
        final String nonSecureCookies = CookieBridge.getCookiesOfCurrentLocale(getApplicationContext(), false);
        setKeepTopActivityFlag();
        final String prevAtMain = CookieBridge.getAtMainCookie(getApplicationContext());
        SigninOption signinoption;
        if (mIsCreateNewAccount)
        {
            signinoption = SigninOption.WebviewCreateAccount;
        } else
        {
            signinoption = SigninOption.WebviewSignin;
        }
        mapaccountmanager.registerAccountWithUI(this, signinoption, bundle, new Callback() {

            final DistributedSSOLoginActivity this$0;
            final String val$nonSecureCookies;
            final String val$prevAtMain;
            final String val$secureCookies;

            public void onError(Bundle bundle1)
            {
                int i = bundle1.getInt("com.amazon.dcp.sso.ErrorCode");
                SSOUtil.setLoginTriggeredFromApplication(false);
                if (i == com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.ACCOUNT_ALREADY_EXISTS.value())
                {
                    onSuccess(bundle1);
                    return;
                } else
                {
                    SSOUtil.clearCurrentLocaleCookieAndCookieJar(getApplicationContext());
                    CookieBridge.setCookies(getApplicationContext(), secureCookies, true);
                    CookieBridge.setCookies(getApplicationContext(), nonSecureCookies, false);
                    DistributedSSOLoginActivity.showErrorToast(DistributedSSOLoginActivity.this, i);
                    setResult(0);
                    clearKeepTopActivityFlag();
                    finish();
                    return;
                }
            }

            public void onSuccess(Bundle bundle1)
            {
                CallObserver callobserver = CallObserver.start(new ServiceCallIdentifier("MobileAuthenticationPlatform", "distributedSSO_signin_onSuccess"));
                final long startTime = SystemClock.elapsedRealtime();
                if (SSOUtil.DEBUG)
                {
                    Log.d(DistributedSSOLoginActivity.TAG, (new StringBuilder()).append("In onSuccess:").append(startTime).toString());
                    Log.d("MAPSigninLatency", (new StringBuilder()).append("In onSuccess:").append(System.nanoTime()).toString());
                }
                Object obj = bundle1.getString("com.amazon.dcp.sso.property.account.acctId");
                if (SSOUtil.DEBUG)
                {
                    long l = SystemClock.elapsedRealtime();
                    Log.d(DistributedSSOLoginActivity.TAG, (new StringBuilder()).append("after getCurrentAccount  ").append(l - startTime).toString());
                }
                SSOUtil.setTempAccountForCurrentLocale(((String) (obj)));
                bundle1 = new User("", SSOUtil.getFullNameFromCustomerAttribute(((String) (obj))), false, false, null, Boolean.valueOf(false), null);
                User.saveUser(bundle1);
                DistributedSSOLoginActivity.sExecutor.execute(((_cls1) (obj)). new Runnable() {

                    final _cls3 this$1;
                    final String val$newAccount;
                    final long val$startTime;

                    public void run()
                    {
                        if (SSOUtil.addAccountCustomKeyMapping)
                        {
                            long l = SystemClock.elapsedRealtime();
                            Log.d(DistributedSSOLoginActivity.TAG, (new StringBuilder()).append("before addAccountCustomeKey:").append(l - startTime).toString());
                        }
                        SSOUtil.addAccountCustomKeyMapping(newAccount);
                        if (SSOUtil.addAccountCustomKeyMapping)
                        {
                            long l1 = SystemClock.elapsedRealtime();
                            Log.d(DistributedSSOLoginActivity.TAG, (new StringBuilder()).append("after addAccountCustomKey:").append(l1 - startTime).toString());
                        }
                    }

            
            {
                this$1 = final__pcls3;
                startTime = l;
                newAccount = String.this;
                super();
            }
                });
                if (SSOUtil.DEBUG)
                {
                    long l1 = SystemClock.elapsedRealtime();
                    Log.d(DistributedSSOLoginActivity.TAG, (new StringBuilder()).append("after post run accountCustomKeyMapping  ").append(l1 - startTime).toString());
                }
                CookieSyncManager.getInstance().sync();
                String s = CookieBridge.getAtMainCookie(getApplicationContext());
                if (Util.isEmpty(s) || s.equals(prevAtMain))
                {
                    AccountCookiesSyncManager.syncAndWait(getApplicationContext(), true, false, ((String) (obj)));
                }
                if (SSOUtil.DEBUG)
                {
                    long l2 = SystemClock.elapsedRealtime();
                    Log.d(DistributedSSOLoginActivity.TAG, (new StringBuilder()).append("after compare atMain  ").append(l2 - startTime).toString());
                }
                SSOUtil.setPreviouslySeenAmazonAccount(getApplicationContext(), ((String) (obj)));
                SSOUtil.ignoreOptOutSSOIfneeded();
                getIntent().getStringExtra("LOGIN_ORIGIN_KEY");
                obj = DistributedSSOLoginActivity.this;
                if (SSOUtil.DEBUG)
                {
                    long l3 = SystemClock.elapsedRealtime();
                    Log.d(DistributedSSOLoginActivity.TAG, (new StringBuilder()).append("before issue async checkLogin  ").append(l3 - startTime).toString());
                }
                (new MShopCheckLogin(getApplicationContext(), mUserInitiatedLogin, new MShopCheckLogin.Subscriber() {

                    final _cls3 this$1;

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
                this$1 = _cls3.this;
                super();
            }
                }, false)).checkLogin();
                if (SSOUtil.DEBUG)
                {
                    long l4 = SystemClock.elapsedRealtime();
                    Log.d(DistributedSSOLoginActivity.TAG, (new StringBuilder()).append("after issue async checkLogin  ").append(l4 - startTime).toString());
                }
                setResult(-1);
                clearKeepTopActivityFlag();
                finish();
                notifyUserSignin(bundle1);
                callobserver.onComplete();
                if (SSOUtil.DEBUG)
                {
                    long l5 = SystemClock.elapsedRealtime();
                    Log.d(DistributedSSOLoginActivity.TAG, (new StringBuilder()).append("Out of onSuccess at:").append(l5).toString());
                    Log.d(DistributedSSOLoginActivity.TAG, (new StringBuilder()).append("onSuccess duration = ").append(l5 - startTime).toString());
                    Log.d("MAPSigninLatency", (new StringBuilder()).append("Out of onSuccess:").append(System.nanoTime()).toString());
                }
            }

            
            {
                this$0 = DistributedSSOLoginActivity.this;
                secureCookies = s;
                nonSecureCookies = s1;
                prevAtMain = s2;
                super();
            }
        });
    }

    private void notifyUserSignin(final User user)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final DistributedSSOLoginActivity this$0;
            final User val$user;

            public void run()
            {
                User.userSignedIn(user);
            }

            
            {
                this$0 = DistributedSSOLoginActivity.this;
                user = user1;
                super();
            }
        });
    }

    private static void showErrorToast(Context context, int i)
    {
        if (i != com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.REGISTER_FAILED.value())
        {
            int j;
            if (com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.NETWORK_FAILURE.value() == i)
            {
                j = com.amazon.mShop.android.lib.R.string.error_network_no_connection_message;
            } else
            {
                j = com.amazon.mShop.android.lib.R.string.map_auth_portal_authentication_error;
            }
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable(i, context, j) {

                final Context val$context;
                final int val$errorCode;
                final int val$errorMessageId;

                public void run()
                {
                    CallObserver.start(new ServiceCallIdentifier("MobileAuthenticationPlatform", (new StringBuilder()).append("distributedSSOError_").append(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.fromValue(errorCode).getName()).toString())).onComplete();
                    Toast.makeText(context, (new StringBuilder()).append(context.getString(errorMessageId)).append("(").append(errorCode).append(")").toString(), 1).show();
                }

            
            {
                errorCode = i;
                context = context1;
                errorMessageId = j;
                super();
            }
            });
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (100 == i && j == 0)
        {
            SSOUtil.setLoginTriggeredFromApplication(false);
            setResult(0);
            finish();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mUserInitiatedLogin = getIntent().getBooleanExtra("USER_INITIATED_LOGIN", false);
        mIsCreateNewAccount = getIntent().getBooleanExtra("CREATE_NEW_ACCOUNT", false);
        boolean flag = getIntent().getBooleanExtra("force_signin", false);
        bundle = SSOUtil.getCurrentAccount(getApplicationContext());
        if (Util.isEmpty(bundle) || flag)
        {
            forceRegistration();
            return;
        } else
        {
            confirmCredentials(bundle);
            return;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return false;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        pauseTimersIfNeeded();
    }

    protected void onPause()
    {
        super.onPause();
        resumeTimersIfNeeded();
    }

    public boolean onSearchRequested()
    {
        return false;
    }












}
