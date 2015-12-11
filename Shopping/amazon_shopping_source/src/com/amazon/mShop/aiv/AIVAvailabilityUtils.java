// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.aiv;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import com.amazon.mShop.feature.Features;
import com.amazon.mShop.util.ConcurrentUtils;
import com.amazon.mShop.util.ConfigUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.mShop.aiv:
//            AmazonInstantVideoProxy

public final class AIVAvailabilityUtils
{

    private static final Intent AIV_COMPANION_APP_INTENT = makeAIVCompanionAppIntent();
    private static final String AIV_COMPANION_APP_PACKAGE = "com.amazon.avod.thirdpartyclient";
    private static final Intent AIV_COMPANION_SETTINGS_INTENT = makeAIVCompanionSettingsIntent();
    private static final int MIN_SDK = 15;
    private static final CountDownLatch sInitializationLatch = new CountDownLatch(1);
    private static boolean sIsAIVInitializedSuccessful = false;

    public AIVAvailabilityUtils()
    {
    }

    static Intent getSettingsIntent()
    {
        return AIV_COMPANION_SETTINGS_INTENT;
    }

    public static boolean isAIVAvailable()
    {
        waitForAIVInitialize();
        return ConfigUtils.isEnabled(com.amazon.mShop.android.lib.R.string.config_hasAIV) && isAIVTurnedOnByWeblabAndBuild() && sIsAIVInitializedSuccessful && AmazonInstantVideoProxy.getInstance().isSupported();
    }

    public static boolean isAIVCompanionAppInstalled(Context context)
    {
        boolean flag = false;
        if (context == null)
        {
            throw new IllegalArgumentException("Context cannot be null.");
        }
        if (context.getPackageManager().resolveActivity(AIV_COMPANION_APP_INTENT, 0) != null)
        {
            flag = true;
        }
        return flag;
    }

    public static boolean isAIVSupportedByDevice()
    {
        boolean flag;
        boolean flag1;
        if (android.os.Build.VERSION.SDK_INT >= 15)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = Build.CPU_ABI.toLowerCase().contains("arm");
        return flag && flag1;
    }

    public static boolean isAIVTurnedOnByWeblabAndBuild()
    {
        return !Features.getInstance().isFeatureActivated("Android_ShopAppAIV");
    }

    public static boolean isCompanionSettingsPageAvailable(Context context)
    {
        while (!isAIVCompanionAppInstalled(context) || context.getPackageManager().resolveActivity(AIV_COMPANION_SETTINGS_INTENT, 0) == null) 
        {
            return false;
        }
        return true;
    }

    private static Intent makeAIVCompanionAppIntent()
    {
        ComponentName componentname = new ComponentName("com.amazon.avod.thirdpartyclient", "com.amazon.avod.thirdpartyclient.LauncherActivity");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setComponent(componentname);
        return intent;
    }

    private static Intent makeAIVCompanionSettingsIntent()
    {
        ComponentName componentname = new ComponentName("com.amazon.avod.thirdpartyclient", "com.amazon.avod.thirdpartyclient.SettingsActivity");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setComponent(componentname);
        return intent;
    }

    public static void setIsAIVInitialized(boolean flag)
    {
        sIsAIVInitializedSuccessful = flag;
        sInitializationLatch.countDown();
    }

    public static void waitForAIVInitialize()
    {
        if (ConfigUtils.isEnabled(com.amazon.mShop.android.lib.R.string.config_hasAIV) && isAIVSupportedByDevice())
        {
            ConcurrentUtils.waitLatchWithTimeOut(sInitializationLatch, 10L, TimeUnit.SECONDS);
        }
    }

}
