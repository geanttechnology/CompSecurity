// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.content.Context;
import com.amazon.client.metrics.AndroidMetricsFactoryImpl;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.sso.MShopOAuthHelper;

public class DCMInitializer
{

    public DCMInitializer()
    {
    }

    public static void initialize(Context context, String s)
    {
        AndroidMetricsFactoryImpl.setOAuthHelper(context, new MShopOAuthHelper());
        AndroidMetricsFactoryImpl.setDeviceType(context, s);
        AndroidMetricsFactoryImpl.setDeviceId(context, AndroidPlatform.getInstance().getDeviceId());
        updatePreferredMarketplace(context);
    }

    public static void updatePreferredMarketplace(Context context)
    {
        String s = AppLocale.getInstance().getCurrentLocaleName();
        s = AppLocale.getInstance().getMarketPlaceIdByLocale(s);
        if (s != null && !s.isEmpty())
        {
            AndroidMetricsFactoryImpl.setPreferredMarketplace(context, s);
        }
    }
}
