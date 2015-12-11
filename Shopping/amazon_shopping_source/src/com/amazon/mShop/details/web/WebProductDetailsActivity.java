// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details.web;

import android.content.Intent;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.web.MShopWebActivity;

public class WebProductDetailsActivity extends MShopWebActivity
{

    public WebProductDetailsActivity()
    {
    }

    public void finishIfAlreadyRedirectToAppStore(String s)
    {
        Intent intent = getIntent();
        if (intent.getBooleanExtra("isFromDetailInterception", false) && s.equalsIgnoreCase(intent.getStringExtra("interceptedAsin")))
        {
            finish();
        }
    }

    protected void handleForceSignIn()
    {
        if (isLaunchedFromPublicUrl())
        {
            SSOUtil.handleSigninPrompt(this);
        }
    }

    public void userSuccessfullySignedIn()
    {
        refresh();
        super.userSuccessfullySignedIn();
    }
}
