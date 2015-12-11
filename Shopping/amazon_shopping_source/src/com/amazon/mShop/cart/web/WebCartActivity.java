// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.cart.web;

import android.os.Bundle;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;
import com.amazon.mShop.net.CookieBridge;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.AmazonErrorUtils;
import com.amazon.mShop.util.Util;
import com.amazon.mShop.web.MShopWebActivity;
import com.amazon.mShop.web.MShopWebFragment;
import com.amazon.mShop.web.NativeAppNotification;

public class WebCartActivity extends MShopWebActivity
    implements UserListener, com.amazon.mShop.web.NativeAppNotification.NativeCartSubscriber
{

    private boolean mCartUpdatedMashEventRegistered;
    protected boolean shouldRefeshOnceOnLogin;

    public WebCartActivity()
    {
        shouldRefeshOnceOnLogin = false;
    }

    private void handleEmptySession()
    {
        mWebFragment.initWebViewContainer(this);
        initLayout();
        AmazonErrorUtils.reportMShopServerError(this, new com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener() {

            final WebCartActivity this$0;

            public void onActionButtonClick(int i)
            {
                ActivityUtils.startHomeActivity(WebCartActivity.this);
                clearErrorOnView(
// JavaClassFileOutputException: get_constant: invalid tag

            
            {
                this$0 = WebCartActivity.this;
                super();
            }
        }, getWebViewContainer(), null, getString(com.amazon.mShop.android.lib.R.string.ok));
    }

    protected void handleForceSignIn()
    {
        if (isLaunchedFromPublicUrl())
        {
            SSOUtil.handleSigninPrompt(this);
        }
    }

    protected void initWebView()
    {
        if (!Util.isEmpty(CookieBridge.getCurrentSessionId()))
        {
            initWebView();
            return;
        } else
        {
            handleEmptySession();
            return;
        }
    }

    public boolean isCartUpdatedMashEventRegistered()
    {
        return mCartUpdatedMashEventRegistered;
    }

    public void onCartChanged()
    {
        if (!isCartUpdatedMashEventRegistered())
        {
            refresh();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        onCreate(bundle);
        User.addUserListener(this);
        NativeAppNotification.addNativeCartSubscriber(this);
    }

    protected void onDestroy()
    {
        User.removeUserListener(this);
        NativeAppNotification.removeNativeCartSubscriber(this);
        onDestroy();
    }

    public void userSignedIn(User user)
    {
        if (!shouldRefeshOnceOnLogin)
        {
            refresh();
            shouldRefeshOnceOnLogin = true;
        }
    }

    public void userSignedOut()
    {
        shouldRefeshOnceOnLogin = false;
    }

    public void userUpdated(User user)
    {
    }

}
