// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.module;

import android.content.Context;

// Referenced classes of package com.amazon.shopapp.voice.module:
//            CustomerProvider, ExperimentProvider, FeatureConfiguration, KeyboardModeListener, 
//            KindleFamily, VoiceSearchActionListener

public class VoiceInitSettings
{

    private static final String BLUEFRONT_ACCESS_ID = "BLUEFRNTMVAY6KX4";
    private static final String BLUEFRONT_ACCESS_KEY = "3YSMFCRB7RGSWXCTT4WHOWHTQC3EMWPR";
    private String mAudioDataSolicitor;
    private String mBluefrontAccessId;
    private String mBluefrontAccessKey;
    private boolean mCircularCloseButton;
    private final Context mContext;
    private CustomerProvider mCustomerProvider;
    private boolean mDebugMode;
    private String mDeviceModel;
    private ExperimentProvider mExperimentProvider;
    private FeatureConfiguration mFeatureConfig;
    private KeyboardModeListener mKeyboardModeListener;
    private boolean mKindle;
    private KindleFamily mKindleFamily;
    private boolean mListeningSoundEnabled;
    private boolean mLoggingEnabled;
    private int mMinDialogWidth;
    private String mProgramName;
    private float mSoundClipVolume;
    private boolean mSoundEnabled;
    private String mSoundFeature;
    private boolean mUseRingAudioStream;
    private VoiceSearchActionListener mVoiceSearchListener;

    public VoiceInitSettings(Context context)
    {
        mBluefrontAccessId = "BLUEFRNTMVAY6KX4";
        mBluefrontAccessKey = "3YSMFCRB7RGSWXCTT4WHOWHTQC3EMWPR";
        mUseRingAudioStream = true;
        mMinDialogWidth = 310;
        mSoundEnabled = true;
        mListeningSoundEnabled = true;
        mSoundClipVolume = 1.0F;
        mLoggingEnabled = true;
        mContext = context;
    }

    public String getAudioDataSolicitor()
    {
        return mAudioDataSolicitor;
    }

    public String getBluefrontAccessId()
    {
        return mBluefrontAccessId;
    }

    public String getBluefrontAccessKey()
    {
        return mBluefrontAccessKey;
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

    public String getDeviceModel()
    {
        return mDeviceModel;
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

    public KindleFamily getKindleFamily()
    {
        return mKindleFamily;
    }

    public int getMinDialogWidth()
    {
        return mMinDialogWidth;
    }

    public String getProgramName()
    {
        return mProgramName;
    }

    public float getSoundClipVolume()
    {
        return mSoundClipVolume;
    }

    public String getSoundFeature()
    {
        return mSoundFeature;
    }

    public VoiceSearchActionListener getVoiceSearchListener()
    {
        return mVoiceSearchListener;
    }

    public boolean isCircularCloseButton()
    {
        return mCircularCloseButton;
    }

    public boolean isKindle()
    {
        return mKindle;
    }

    public boolean isListeningSoundEnabled()
    {
        return mListeningSoundEnabled;
    }

    public boolean isLoggingEnabled()
    {
        return mLoggingEnabled;
    }

    public boolean isSoundEnabled()
    {
        return mSoundEnabled;
    }

    public void setAudioDataSolicitor(String s)
    {
        mAudioDataSolicitor = s;
    }

    public void setBluefrontAccessId(String s)
    {
        mBluefrontAccessId = s;
    }

    public void setBluefrontAccessKey(String s)
    {
        mBluefrontAccessKey = s;
    }

    public void setCircularCloseButton(boolean flag)
    {
        mCircularCloseButton = flag;
    }

    public void setCustomerProvider(CustomerProvider customerprovider)
    {
        mCustomerProvider = customerprovider;
    }

    public void setDebugMode(boolean flag)
    {
        mDebugMode = flag;
    }

    public void setDeviceModel(String s)
    {
        mDeviceModel = s;
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

    public void setKindle(boolean flag)
    {
        mKindle = flag;
    }

    public void setKindleFamily(KindleFamily kindlefamily)
    {
        mKindleFamily = kindlefamily;
    }

    public void setListeningSoundEnabled(boolean flag)
    {
        mListeningSoundEnabled = flag;
    }

    public void setLoggingEnabled(boolean flag)
    {
        mLoggingEnabled = flag;
    }

    public void setMinDialogWidth(int i)
    {
        mMinDialogWidth = i;
    }

    public void setProgramName(String s)
    {
        mProgramName = s;
    }

    public void setSoundClipVolume(float f)
    {
        mSoundClipVolume = f;
    }

    public void setSoundEnabled(boolean flag)
    {
        mSoundEnabled = flag;
    }

    public void setSoundFeature(String s)
    {
        mSoundFeature = s;
    }

    public void setUseRingAudioStream(boolean flag)
    {
        mUseRingAudioStream = flag;
    }

    public void setVoiceSearchListener(VoiceSearchActionListener voicesearchactionlistener)
    {
        mVoiceSearchListener = voicesearchactionlistener;
    }

    public boolean useRingAudioStream()
    {
        return mUseRingAudioStream;
    }
}
