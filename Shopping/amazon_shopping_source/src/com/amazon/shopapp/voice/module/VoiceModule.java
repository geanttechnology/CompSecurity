// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.module;

import android.content.Context;

// Referenced classes of package com.amazon.shopapp.voice.module:
//            VoiceInitSettings, ExperimentProvider, FeatureConfiguration

public abstract class VoiceModule
{

    private static VoiceModule sInstance;
    private VoiceInitSettings mInitSettings;

    public VoiceModule()
    {
    }

    public static VoiceModule getInstance()
    {
        return sInstance;
    }

    protected static void setInstance(VoiceModule voicemodule)
    {
        sInstance = voicemodule;
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

    public boolean isDebugEnabled()
    {
        return mInitSettings.getDebugMode();
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
