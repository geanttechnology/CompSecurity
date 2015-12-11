// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.Context;
import com.amazon.device.ads.identity.AdsIdentity;
import com.amazon.identity.platform.util.PlatformUtils;

public class AdsIdentityHelper
{

    public AdsIdentityHelper()
    {
    }

    public void initializeMobileAds(Context context)
    {
        if (!PlatformUtils.isAmazonDevice(context))
        {
            AdsIdentity.initialize(context);
        }
    }
}
