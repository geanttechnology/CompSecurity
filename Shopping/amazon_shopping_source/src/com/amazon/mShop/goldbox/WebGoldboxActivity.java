// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.goldbox;

import com.amazon.mShop.web.MShopWebActivity;
import com.amazon.mShop.web.MShopWebViewContainer;

public class WebGoldboxActivity extends MShopWebActivity
{

    public WebGoldboxActivity()
    {
    }

    protected void initWebView()
    {
        super.initWebView();
        getWebViewContainer().setProgressHideSpinner(99);
    }
}
