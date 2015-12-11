// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.clouddrive;

import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.util.ConcurrentUtils;
import com.amazon.mShop.util.ConfigUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CloudDriveAvailability
{
    private static class Holder
    {

        public static final CloudDriveAvailability INSTANCE = new CloudDriveAvailability();


        private Holder()
        {
        }
    }


    private boolean isInitializedSuccessful;
    private final CountDownLatch mInitialLatch;

    private CloudDriveAvailability()
    {
        mInitialLatch = new CountDownLatch(1);
        isInitializedSuccessful = false;
    }


    public static CloudDriveAvailability getInstance()
    {
        return Holder.INSTANCE;
    }

    private boolean isCloudDRiveEnabledInConfig()
    {
        return ConfigUtils.isEnabledForApp(AndroidPlatform.getInstance().getApplicationContext(), com.amazon.mShop.android.lib.R.bool.config_has_cloudDrive);
    }

    public boolean isCloudDriveAvailable()
    {
        waitForInitialization();
        return isInitializedSuccessful && isCloudDRiveEnabledInConfig();
    }

    public void setCloudDriveInitialized(boolean flag)
    {
        isInitializedSuccessful = flag;
        mInitialLatch.countDown();
    }

    public void waitForInitialization()
    {
        if (isCloudDRiveEnabledInConfig())
        {
            ConcurrentUtils.waitLatchWithTimeOut(mInitialLatch, 10L, TimeUnit.SECONDS);
        }
    }
}
