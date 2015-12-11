// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.phone;

import android.util.Log;
import com.amazon.shopapp.voice.module.VoiceInitSettings;
import com.amazon.shopapp.voice.module.VoiceModule;
import java.util.concurrent.atomic.AtomicBoolean;

public class PhoneVoiceModule extends VoiceModule
{

    private static final String PHONE_AUDIO_DATA_SOLICITOR = "MSHOP_ANDROID_PHONE_PROD_APP";
    private static final String PHONE_PROGRAM_NAME = "MShopAndroidPhoneApp";
    private static final String TAG = com/amazon/shopapp/voice/phone/PhoneVoiceModule.getSimpleName();
    private static PhoneVoiceModule sInstance;
    private AtomicBoolean mPackageLoaded;

    public PhoneVoiceModule()
    {
        mPackageLoaded = new AtomicBoolean(false);
    }

    public static PhoneVoiceModule getInstance()
    {
        com/amazon/shopapp/voice/phone/PhoneVoiceModule;
        JVM INSTR monitorenter ;
        PhoneVoiceModule phonevoicemodule;
        if (sInstance == null)
        {
            sInstance = new PhoneVoiceModule();
        }
        phonevoicemodule = sInstance;
        com/amazon/shopapp/voice/phone/PhoneVoiceModule;
        JVM INSTR monitorexit ;
        return phonevoicemodule;
        Exception exception;
        exception;
        throw exception;
    }

    public static void initializeApp(VoiceInitSettings voiceinitsettings)
    {
        try
        {
            if (voiceinitsettings.getProgramName() == null)
            {
                voiceinitsettings.setProgramName("MShopAndroidPhoneApp");
            }
            if (voiceinitsettings.getAudioDataSolicitor() == null)
            {
                voiceinitsettings.setAudioDataSolicitor("MSHOP_ANDROID_PHONE_PROD_APP");
            }
            voiceinitsettings.setSoundFeature("SX_mShop_Android_Voice_Search_Notification_Sound");
            PhoneVoiceModule phonevoicemodule = getInstance();
            VoiceModule.setInstance(phonevoicemodule);
            phonevoicemodule.initialize(voiceinitsettings);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (VoiceInitSettings voiceinitsettings)
        {
            Log.e(TAG, "Error", voiceinitsettings);
        }
    }

    private boolean voiceSupported()
    {
        return mPackageLoaded.get() && checkDeviceSupport();
    }

    public boolean barcodeSearchEnabled()
    {
        return !voiceSearchInNavEnabled() || isFeatureActive("SX_mShop_Android_Voice_Search_Barcode");
    }

    public String flowButtonTreatment()
    {
        return getExperimentTreatment("SX_mShop_Android_Voice_Search_Scan_Flow");
    }

    public void setPackageLoaded(boolean flag)
    {
        mPackageLoaded.set(flag);
    }

    public boolean shopByDepartmentEnabled()
    {
        return !voiceSearchInNavEnabled() || !isFeatureActive("SX_mShop_Android_Voice_Search_Shop_By_Department");
    }

    public boolean voiceSearchInNavEnabled()
    {
        return voiceSupported() && isExperimentActive("SX_mShop_Android_Voice_Search_Nav");
    }

    public boolean voiceSearchInResultEnabled()
    {
        return voiceSupported() && (isFeatureActive("SX_mShop_Android_Voice_Search_Result_Nav") || voiceSearchInNavEnabled());
    }

    public boolean voiceSearchInSuggestionsEnabled()
    {
        return voiceSupported() && isFeatureActive("SX_mShop_Android_Voice_Search_Access");
    }

}
