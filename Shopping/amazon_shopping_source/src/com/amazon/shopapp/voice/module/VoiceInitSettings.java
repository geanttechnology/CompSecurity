// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.module;

import android.content.Context;

// Referenced classes of package com.amazon.shopapp.voice.module:
//            CustomerProvider, ExperimentProvider, FeatureConfiguration, KeyboardModeListener, 
//            VoiceSearchActionListener

public class VoiceInitSettings
{

    private final Context mContext;
    private CustomerProvider mCustomerProvider;
    private boolean mDebugMode;
    private ExperimentProvider mExperimentProvider;
    private FeatureConfiguration mFeatureConfig;
    private KeyboardModeListener mKeyboardModeListener;
    private VoiceSearchActionListener mVoiceSearchListener;

    public VoiceInitSettings(Context context)
    {
        mContext = context;
    }

    public Context getContext()
    {
        return mContext;
    }

    public CustomerProvider getCustomerProvider()
    {
        return mCustomerProvider;
    }

    public boolean getDebugMode()
    {
        return mDebugMode;
    }

    public ExperimentProvider getExperimentProvider()
    {
        return mExperimentProvider;
    }

    public FeatureConfiguration getFeatureConfiguration()
    {
        return mFeatureConfig;
    }

    public KeyboardModeListener getKeyboardModeListener()
    {
        return mKeyboardModeListener;
    }

    public VoiceSearchActionListener getVoiceSearchListener()
    {
        return mVoiceSearchListener;
    }

    public void setCustomerProvider(CustomerProvider customerprovider)
    {
        mCustomerProvider = customerprovider;
    }

    public void setDebugMode(boolean flag)
    {
        mDebugMode = flag;
    }

    public void setExperimentProvider(ExperimentProvider experimentprovider)
    {
        mExperimentProvider = experimentprovider;
    }

    public void setFeatureConfiguration(FeatureConfiguration featureconfiguration)
    {
        mFeatureConfig = featureconfiguration;
    }

    public void setKeyboardModeListener(KeyboardModeListener keyboardmodelistener)
    {
        mKeyboardModeListener = keyboardmodelistener;
    }

    public void setVoiceSearchListener(VoiceSearchActionListener voicesearchactionlistener)
    {
        mVoiceSearchListener = voicesearchactionlistener;
    }
}
