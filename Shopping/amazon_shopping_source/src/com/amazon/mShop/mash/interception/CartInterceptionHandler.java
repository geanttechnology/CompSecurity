// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.interception;

import android.content.Context;
import android.net.Uri;
import com.amazon.mShop.cart.web.WebCartActivity;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.Maps;
import com.amazon.mobile.mash.interception.UrlIntercepterConfigEntry;
import com.amazon.mobile.mash.interception.UrlInterceptionHandler;

public class CartInterceptionHandler extends UrlInterceptionHandler
{

    public CartInterceptionHandler(Context context, Uri uri, UrlIntercepterConfigEntry urlintercepterconfigentry)
    {
        super(context, uri, urlintercepterconfigentry);
    }

    public boolean handle()
    {
        if (getContext() instanceof WebCartActivity)
        {
            return false;
        } else
        {
            return ActivityUtils.startCartActivity(getContext(), Maps.of("ref", getRefmarker()), -1);
        }
    }
}
