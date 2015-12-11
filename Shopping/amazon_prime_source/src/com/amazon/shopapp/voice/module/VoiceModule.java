// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.module;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

// Referenced classes of package com.amazon.shopapp.voice.module:
//            VoiceInitSettings, ExperimentProvider, FeatureConfiguration

public abstract class VoiceModule
{

    private static final String TAG = com/amazon/shopapp/voice/module/VoiceModule.getSimpleName();
    private static VoiceModule sInstance;
    private int mDeviceSupported;
    private VoiceInitSettings mInitSettings;

    public VoiceModule()
    {
        mDeviceSupported = -1;
    }

    public static VoiceModule getInstance()
    {
        return sInstance;
    }

    protected static void setInstance(VoiceModule voicemodule)
    {
        sInstance = voicemodule;
    }

    protected boolean checkDeviceSupport()
    {
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = getContext().getPackageManager().hasSystemFeature("android.hardware.microphone");
        }
        catch (Throwable throwable)
        {
            Log.e(TAG, "Error", throwable);
            return false;
        }
        return flag;
    }

    public boolean deviceSupported()
    {
        if (mDeviceSupported == -1)
        {
            int i;
            if (checkDeviceSupport())
            {
                i = 1;
            } else
            {
                i = 0;
            }
            mDeviceSupported = i;
        }
        return mDeviceSupported == 1;
    }

    public Context getContext()
    {
        return mInitSettings.getContext();
    }

    public String getExperimentTreatment(String s)
    {
        if (mInitSettings != null && mInitSettings.getExperimentProvider() != null)
        {
            return mInitSettings.getExperimentProvider().getTreatment(s);
        } else
        {
            return "C";
        }
    }

    public String getFeatureState(String s)
    {
        if (mInitSettings != null && mInitSettings.getFeatureConfiguration() != null)
        {
            return mInitSettings.getFeatureConfiguration().getFeatureState(s);
        } else
        {
            return null;
        }
    }

    public VoiceInitSettings getInitSettings()
    {
        return mInitSettings;
    }

    public void initialize(VoiceInitSettings voiceinitsettings)
    {
        mInitSettings = voiceinitsettings;
    }

    public boolean isExperimentActive(String s)
    {
        return mInitSettings != null && mInitSettings.getExperimentProvider() != null && !"C".equals(mInitSettings.getExperimentProvider().getTreatment(s));
    }

    public boolean isFeatureActive(String s)
    {
        return mInitSettings != null && mInitSettings.getFeatureConfiguration() != null && mInitSettings.getFeatureConfiguration().isFeatureActivated(s);
    }

}
