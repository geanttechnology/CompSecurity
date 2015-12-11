// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.mshop;

import android.content.Context;
import android.content.pm.PackageManager;
import com.amazon.shopapp.voice.module.VoiceInitSettings;
import com.amazon.shopapp.voice.module.VoiceModule;
import java.util.concurrent.atomic.AtomicBoolean;

public class MShopVoiceModule extends VoiceModule
{

    private static MShopVoiceModule sInstance;
    private AtomicBoolean mIsVoicePackageLoaded;

    public MShopVoiceModule()
    {
        mIsVoicePackageLoaded = new AtomicBoolean(false);
    }

    public static MShopVoiceModule getInstance()
    {
        com/amazon/shopapp/voice/mshop/MShopVoiceModule;
        JVM INSTR monitorenter ;
        MShopVoiceModule mshopvoicemodule;
        if (sInstance == null)
        {
            sInstance = new MShopVoiceModule();
        }
        mshopvoicemodule = sInstance;
        com/amazon/shopapp/voice/mshop/MShopVoiceModule;
        JVM INSTR monitorexit ;
        return mshopvoicemodule;
        Exception exception;
        exception;
        throw exception;
    }

    public static void initializeApp(VoiceInitSettings voiceinitsettings)
    {
        MShopVoiceModule mshopvoicemodule = getInstance();
        VoiceModule.setInstance(mshopvoicemodule);
        mshopvoicemodule.initialize(voiceinitsettings);
    }

    public boolean barcodeSearchEnabled()
    {
        return !voiceSearchInNavEnabled() || isFeatureActive("SX_mShop_Android_Voice_Search_Barcode");
    }

    public String flowButtonTreatment()
    {
        return getExperimentTreatment("SX_mShop_Android_Voice_Search_Scan_Flow");
    }

    public boolean isVoiceSearchSupportedOnDevice()
    {
        if (!mIsVoicePackageLoaded.get() || android.os.Build.VERSION.SDK_INT < 11)
        {
            return false;
        } else
        {
            return getContext().getPackageManager().hasSystemFeature("android.hardware.microphone");
        }
    }

    public void setIsVoicePackageLoaded(boolean flag)
    {
        mIsVoicePackageLoaded.set(flag);
    }

    public boolean shopByDepartmentEnabled()
    {
        return !voiceSearchInNavEnabled() || !isFeatureActive("SX_mShop_Android_Voice_Search_Shop_By_Department");
    }

    public boolean voiceSearchInNavEnabled()
    {
        return isVoiceSearchSupportedOnDevice() && isExperimentActive("SX_mShop_Android_Voice_Search_Nav");
    }

    public boolean voiceSearchInResultEnabled()
    {
        return isVoiceSearchSupportedOnDevice() && (isFeatureActive("SX_mShop_Android_Voice_Search_Result_Nav") || voiceSearchInNavEnabled());
    }

    public boolean voiceSearchInSuggestionsEnabled()
    {
        return isVoiceSearchSupportedOnDevice() && isFeatureActive("SX_mShop_Android_Voice_Search_Access");
    }
}
