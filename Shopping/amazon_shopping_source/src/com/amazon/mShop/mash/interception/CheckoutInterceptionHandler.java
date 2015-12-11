// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.interception;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.amazon.mShop.cart.web.WebCartActivity;
import com.amazon.mShop.opl.web.WebPurchaseActivity;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mobile.mash.interception.UrlIntercepterConfigEntry;
import com.amazon.mobile.mash.interception.UrlInterceptionHandler;

public class CheckoutInterceptionHandler extends UrlInterceptionHandler
{

    public CheckoutInterceptionHandler(Context context, Uri uri, UrlIntercepterConfigEntry urlintercepterconfigentry)
    {
        super(context, uri, urlintercepterconfigentry);
    }

    public boolean handle()
    {
        if (getContext() instanceof WebPurchaseActivity)
        {
            return false;
        } else
        {
            Intent intent = ActivityUtils.getStartWebActivityIntent(getContext(), com/amazon/mShop/opl/web/WebPurchaseActivity, getUri().toString(), -1);
            intent.putExtra("isCartPurchase", getContext() instanceof WebCartActivity);
            getContext().startActivity(intent);
            return true;
        }
    }
}
