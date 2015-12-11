// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPCallbackErrorException;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.api.TokenManagement;
import com.amazon.mShop.net.CallObserver;
import com.amazon.mShop.net.CookieBridge;
import com.amazon.mShop.net.ServiceCallIdentifier;
import com.amazon.mShop.util.Util;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.amazon.mShop.sso:
//            SSOUtil, CookieHelper

public class MAPCookiesFetcher
{

    private static final String TAG = com/amazon/mShop/sso/MAPCookiesFetcher.getSimpleName();
    private final String mAccount;
    private final Context mApplicationContext;
    private final boolean mForceSync;
    private final AccountCookiesSyncManager.UserSubscriberCallback mUserSubscriberCallback;
    private boolean mXCookieOnly;

    public MAPCookiesFetcher(AccountCookiesSyncManager.UserSubscriberCallback usersubscribercallback, Context context, boolean flag, String s, boolean flag1)
    {
        mUserSubscriberCallback = usersubscribercallback;
        mApplicationContext = context;
        mForceSync = flag;
        mAccount = s;
        mXCookieOnly = flag1;
        if (SSOUtil.DEBUG)
        {
            Log.v(TAG, "new MAPCookiesFetcher");
            Log.v(TAG, (new StringBuilder()).append("mAccount ").append(mAccount).append(" mXCookieOnly ").append(mXCookieOnly).toString());
        }
    }

    public MAPCookiesFetcher(String s, Context context)
    {
        mUserSubscriberCallback = null;
        mAccount = s;
        mApplicationContext = context;
        mForceSync = false;
    }

    private void failure(Bundle bundle)
    {
        Object obj = null;
        if (bundle != null)
        {
            int i = bundle.getInt("com.amazon.dcp.sso.ErrorCode", -1);
            obj = bundle.getString("com.amazon.dcp.sso.ErrorMessage");
            StringBuilder stringbuilder = (new StringBuilder()).append("Cookie Fetch Fail. Code: ").append(i).append("; errorMsg: ");
            bundle = ((Bundle) (obj));
            if (Util.isEmpty(((String) (obj))))
            {
                bundle = "";
            }
            bundle = stringbuilder.append(bundle).toString();
            obj = bundle;
            if (SSOUtil.DEBUG)
            {
                Log.e(TAG, bundle);
                obj = bundle;
            }
        }
        if (mUserSubscriberCallback != null)
        {
            mUserSubscriberCallback.onFailed(((String) (obj)));
        }
    }

    public void getCookies()
    {
        TokenManagement tokenmanagement = new TokenManagement(mApplicationContext);
        Bundle bundle = null;
        if (mForceSync)
        {
            bundle = new Bundle();
            bundle.putBoolean("com.amazon.identity.auth.device.api.cookiekeys.options.forcerefresh", mForceSync);
        }
        final Object callObserver;
        final String cookieDomain;
        if (!Util.isEmpty(mAccount))
        {
            callObserver = "getAuthCookie";
        } else
        {
            callObserver = "getNonAuthCookie";
        }
        callObserver = CallObserver.start(new ServiceCallIdentifier("MobileAuthenticationPlatform", ((String) (callObserver))));
        cookieDomain = CookieBridge.getCookieDomain(mApplicationContext, true);
        tokenmanagement.getCookies(mAccount, String.format("www%s", new Object[] {
            cookieDomain
        }), bundle, new Callback() {

            final MAPCookiesFetcher this$0;
            final CallObserver val$callObserver;
            final String val$cookieDomain;

            public void onError(Bundle bundle1)
            {
                CallObserver callobserver = callObserver;
                String s;
                if (bundle1 != null)
                {
                    s = bundle1.toString();
                } else
                {
                    s = null;
                }
                callobserver.onFailed(s);
                failure(bundle1);
            }

            public void onSuccess(Bundle bundle1)
            {
                String as[] = bundle1.getStringArray("com.amazon.identity.auth.device.api.cookiekeys.all");
                String s = CookieBridge.getCookieDomain(mApplicationContext, true);
                if (Util.isEmpty(as) || !s.equals(cookieDomain))
                {
                    if (SSOUtil.DEBUG)
                    {
                        Log.v(MAPCookiesFetcher.TAG, (new StringBuilder()).append("current CookieDomain is ").append(s).append(" \n new cookies: ").append(Arrays.toString(as)).toString());
                    }
                    onError(bundle1);
                } else
                {
                    callObserver.onComplete();
                    if (SSOUtil.DEBUG)
                    {
                        Log.v(MAPCookiesFetcher.TAG, (new StringBuilder()).append("new cookies: ").append(Arrays.toString(as)).toString());
                        Log.v(MAPCookiesFetcher.TAG, (new StringBuilder()).append("mAccount ").append(mAccount).append(" mXCookieOnly ").append(mXCookieOnly).toString());
                    }
                    if (Util.isEmpty(mAccount) || !mXCookieOnly)
                    {
                        CookieHelper.setCookies(mApplicationContext, as);
                    } else
                    {
                        CookieHelper.setXCookie(mApplicationContext, as);
                    }
                    if (mUserSubscriberCallback != null)
                    {
                        mUserSubscriberCallback.identityCookiesSuccessfullyFetched();
                        return;
                    }
                }
            }

            
            {
                this$0 = MAPCookiesFetcher.this;
                cookieDomain = s;
                callObserver = callobserver;
                super();
            }
        });
    }

    public boolean peekXCookie()
    {
        Object obj;
        boolean flag;
        flag = false;
        obj = new TokenManagement(mApplicationContext);
        String s = CookieBridge.getCookieDomain(mApplicationContext, true);
        obj = ((TokenManagement) (obj)).peekCookies(mAccount, String.format("www%s", new Object[] {
            s
        }), null);
        boolean flag1;
        String as[] = ((Bundle)((MAPFuture) (obj)).get()).getStringArray("com.amazon.identity.auth.device.api.cookiekeys.all");
        flag1 = CookieHelper.setXCookie(mApplicationContext, as);
        flag = flag1;
_L2:
        return flag;
        Object obj1;
        obj1;
        if (SSOUtil.DEBUG)
        {
            Log.d("Amazon.SSOUtil", (new StringBuilder()).append("peekXCookie: ").append(((MAPCallbackErrorException) (obj1)).getMessage()).toString());
            return false;
        }
        continue; /* Loop/switch isn't completed */
        obj1;
        if (SSOUtil.DEBUG)
        {
            Log.d("Amazon.SSOUtil", (new StringBuilder()).append("peekXCookie: ").append(((InterruptedException) (obj1)).getMessage()).toString());
            return false;
        }
        continue; /* Loop/switch isn't completed */
        obj1;
        if (SSOUtil.DEBUG)
        {
            Log.d("Amazon.SSOUtil", (new StringBuilder()).append("peekXCookie: ").append(((ExecutionException) (obj1)).getMessage()).toString());
            return false;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }







}
