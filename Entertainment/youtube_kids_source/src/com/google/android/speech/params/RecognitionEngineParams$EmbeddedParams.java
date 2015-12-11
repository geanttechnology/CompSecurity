// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.params;

import com.google.android.speech.SpeechSettings;
import com.google.android.speech.embedded.Greco3CallbackFactory;
import com.google.android.speech.embedded.Greco3EngineManager;
import com.google.android.speech.embedded.Greco3ModeSelector;
import dax;

public class mSamplingRate
{

    private final int mBytesPerSample;
    private final Greco3CallbackFactory mCallbackFactory;
    private final Greco3EngineManager mGreco3EngineManager;
    private final Greco3ModeSelector mModeSelector;
    private final int mSamplingRate;
    private final dax mSpeechLevelSource;
    private final SpeechSettings mSpeechSettings;

    public int getBytesPerSample()
    {
        return mBytesPerSample;
    }

    public Greco3CallbackFactory getCallbackFactory()
    {
        return mCallbackFactory;
    }

    public Greco3EngineManager getGreco3EngineManager()
    {
        return mGreco3EngineManager;
    }

    public Greco3ModeSelector getModeSelector()
    {
        return mModeSelector;
    }

    public int getSamplingRate()
    {
        return mSamplingRate;
    }

    public dax getSpeechLevelSource()
    {
        return mSpeechLevelSource;
    }

    public SpeechSettings getSpeechSettings()
    {
        return mSpeechSettings;
    }

    public (Greco3CallbackFactory greco3callbackfactory, Greco3EngineManager greco3enginemanager, Greco3ModeSelector greco3modeselector, dax dax, SpeechSettings speechsettings, int i, int j)
    {
        mCallbackFactory = greco3callbackfactory;
        mGreco3EngineManager = greco3enginemanager;
        mModeSelector = greco3modeselector;
        mSpeechLevelSource = dax;
        mSpeechSettings = speechsettings;
        mBytesPerSample = i;
        mSamplingRate = j;
    }
}
