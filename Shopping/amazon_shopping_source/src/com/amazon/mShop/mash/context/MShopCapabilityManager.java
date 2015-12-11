// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.context;

import android.content.Context;
import com.amazon.mShop.aiv.AIVAvailabilityUtils;
import com.amazon.mShop.aiv.AmazonInstantVideoProxy;
import com.amazon.mShop.appstore.AppstoreUtils;
import com.amazon.mShop.opl.AddressPickerView;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.MShopPushNotificationUtils;
import com.amazon.mobile.mash.appcontext.CapabilityManager;

public class MShopCapabilityManager extends CapabilityManager
{

    public MShopCapabilityManager(Context context)
    {
        super(context);
    }

    public boolean isAvailableAivPlayback()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (AIVAvailabilityUtils.isAIVAvailable())
        {
            AmazonInstantVideoProxy amazoninstantvideoproxy = AmazonInstantVideoProxy.getInstance();
            flag = flag1;
            if (amazoninstantvideoproxy.isSupported())
            {
                flag = amazoninstantvideoproxy.isPlaybackSustainable();
            }
        }
        return flag;
    }

    public boolean isAvailableAppNavMenu()
    {
        return true;
    }

    public boolean isAvailableAppstore()
    {
        return AppstoreUtils.isAppstoreAvailable();
    }

    public boolean isAvailableEnforceParentalControls()
    {
        return false;
    }

    public boolean isAvailableShowAdsBrowser()
    {
        return false;
    }

    public boolean isAvailableShowAmazonPoints()
    {
        return ConfigUtils.isEnabled(AndroidPlatform.getInstance().getApplicationContext(), com.amazon.mShop.android.lib.R.string.config_hasPoints);
    }

    public boolean isAvailableShowCardScannerCredit()
    {
        return android.os.Build.VERSION.SDK_INT >= 14;
    }

    public boolean isAvailableShowDeliveryDestinationPicker()
    {
        return AddressPickerView.hasCVSD(AndroidPlatform.getInstance().getApplicationContext());
    }

    public boolean isAvailableShowNotificationSettings()
    {
        return MShopPushNotificationUtils.isPushNotificationAvailable() && MShopPushNotificationUtils.isMarketplaceSupportsNotification();
    }

    public boolean isAvailableSmile()
    {
        return ActivityUtils.isSmileEnabled();
    }
}
