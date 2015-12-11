// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash;

import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mobile.mash.MASHApplication;

public class MShopMASHApplication
    implements MASHApplication
{

    public MShopMASHApplication()
    {
    }

    public String getAppCustomUserAgent()
    {
        return AndroidPlatform.getInstance().getUserAgent();
    }

    public boolean isDebugEnabled()
    {
        return DebugSettings.isDebugEnabled();
    }

    public boolean shouldInterceptUrls()
    {
        return true;
    }
}
