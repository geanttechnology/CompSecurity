// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wishlist.web;

import android.os.Bundle;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.web.MShopWebActivity;
import com.amazon.mShop.web.NativeAppNotification;

public class WebWishListActivity extends MShopWebActivity
    implements UserListener, com.amazon.mShop.web.NativeAppNotification.NativeWishListSubscriber
{

    protected boolean shouldRefeshOnceOnLogin;

    public WebWishListActivity()
    {
        shouldRefeshOnceOnLogin = false;
    }

    protected void handleForceSignIn()
    {
        if (isLaunchedFromPublicUrl())
        {
            SSOUtil.handleSigninPrompt(this);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        User.addUserListener(this);
        NativeAppNotification.addNativeWishListSubscriber(this);
    }

    protected void onDestroy()
    {
        User.removeUserListener(this);
        NativeAppNotification.removeNativeWishListSubscriber(this);
        super.onDestroy();
    }

    public void onWishListChanged()
    {
        refresh();
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
