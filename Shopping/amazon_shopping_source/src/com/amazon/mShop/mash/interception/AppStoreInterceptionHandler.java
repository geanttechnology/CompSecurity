// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.interception;

import android.content.Context;
import android.net.Uri;
import com.amazon.mShop.details.web.WebProductDetailsActivity;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.Util;
import com.amazon.mobile.mash.interception.UrlIntercepterConfigEntry;
import com.amazon.mobile.mash.interception.UrlInterceptionHandler;
import java.util.HashSet;

public class AppStoreInterceptionHandler extends UrlInterceptionHandler
{

    public AppStoreInterceptionHandler(Context context, Uri uri, UrlIntercepterConfigEntry urlintercepterconfigentry)
    {
        super(context, uri, urlintercepterconfigentry);
    }

    public boolean handle()
    {
        String s = getUri().getQueryParameter("asin");
        if (Util.isEmpty(s))
        {
            return false;
        }
        Context context = getContext();
        if (ActivityUtils.ASIN_AMAZON_COINS.contains(s))
        {
            ActivityUtils.startAppstoreActivityToBuyCoins(getContext(), s);
        } else
        {
            ActivityUtils.startAppstoreActivityWithAsin(context, s, getRefmarker(), null, null);
        }
        if (context instanceof WebProductDetailsActivity)
        {
            ((WebProductDetailsActivity)context).finishIfAlreadyRedirectToAppStore(s);
        }
        return true;
    }
}
