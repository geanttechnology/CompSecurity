// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.webkit.WebView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewClient

class val.webView
    implements com.amazon.mShop.model.auth.ck
{

    final MShopWebViewClient this$0;
    final AmazonActivity val$amazonActivity;
    final String val$urlAfterSuccessfulLogin;
    final WebView val$webView;

    public void userCancelledSignIn()
    {
        val$amazonActivity.popView();
    }

    public void userSuccessfullySignedIn()
    {
        if (!Util.isEmpty(val$urlAfterSuccessfulLogin))
        {
            val$webView.clearView();
            val$webView.loadUrl(val$urlAfterSuccessfulLogin);
        }
    }

    .Callback()
    {
        this$0 = final_mshopwebviewclient;
        val$amazonActivity = amazonactivity;
        val$urlAfterSuccessfulLogin = s;
        val$webView = WebView.this;
        super();
    }
}
