// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Context;
import com.amazon.identity.auth.device.utils.CentralApkUtils;
import com.amazon.identity.auth.device.utils.PackageUtils;
import com.amazon.identity.platform.util.PlatformUtils;

public class PlatformWrapper
{

    private final Context mContext;

    public PlatformWrapper(Context context)
    {
        mContext = context;
    }

    public boolean doesPlatformSupportsMultipleProfiles()
    {
        return PlatformUtils.doesPlatformSupportsMultipleProfiles(mContext);
    }

    public boolean hasCentralApk()
    {
        return CentralApkUtils.hasCentralAPK(mContext);
    }

    public boolean isAmazonDevice()
    {
        return PlatformUtils.isAmazonDevice(mContext);
    }

    public boolean isBackedByAccountManager()
    {
        return PlatformUtils.isBackedByAccountManager(mContext);
    }

    public boolean isCanaryInstalled()
    {
        return PackageUtils.hasPackage("com.amazon.canary", mContext) && PlatformUtils.isAmazonAuthenticatorPresent(mContext);
    }

    public boolean isFullMAPR5()
    {
        return PlatformUtils.isFullMAPR5(mContext);
    }

    public boolean isGroverInstalled()
    {
        return PackageUtils.hasPackage("com.amazon.fv", mContext) && PlatformUtils.isAmazonAuthenticatorPresent(mContext);
    }

    public boolean isNewIdentiyMobilePlatformSSO()
    {
        return PlatformUtils.isPostMergeDevice(mContext);
    }

    public boolean isOtter()
    {
        return PlatformUtils.isOtter(mContext);
    }

    public boolean isPostMergeDevice()
    {
        return PlatformUtils.isPostMergeDevice(mContext);
    }

    public boolean isPreMergeDevice()
    {
        return PlatformUtils.isPreMergeDevice(mContext);
    }

    public boolean isRunningInCentralApk()
    {
        return CentralApkUtils.isRunningInCentralAPK(mContext);
    }

    public boolean isThirdPartyDevice()
    {
        return PlatformUtils.isThirdPartyDevice(mContext);
    }

    public boolean shouldUseProfiles()
    {
        return PlatformUtils.shouldUseProfiles(mContext);
    }

    public boolean unSecureCheckHasServiceWithAction(String s)
    {
        return PlatformUtils.unSecureCheckHasServiceWithAction(mContext, s);
    }
}
