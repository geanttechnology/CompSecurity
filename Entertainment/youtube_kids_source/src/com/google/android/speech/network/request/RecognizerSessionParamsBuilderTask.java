// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.network.request;

import com.google.android.speech.SpeechSettings;
import ewo;

// Referenced classes of package com.google.android.speech.network.request:
//            BaseRequestBuilderTask, S3RecognizerInfoBuilderTask

public class RecognizerSessionParamsBuilderTask extends BaseRequestBuilderTask
{

    private final boolean mEnableAlternates;
    private final boolean mEnablePartials;
    private final boolean mProfanityFilterEnabled;
    private final int mSampleRate;
    private final SpeechSettings mSpeechSettings;

    public RecognizerSessionParamsBuilderTask(SpeechSettings speechsettings, int i, boolean flag, boolean flag1, boolean flag2)
    {
        super("RecognizerSessionParamsBuilderTask");
        mSpeechSettings = speechsettings;
        mSampleRate = i;
        mEnablePartials = flag;
        mEnableAlternates = flag1;
        mProfanityFilterEnabled = flag2;
    }

    protected ewo build()
    {
        ewo ewo1 = new ewo();
        ewo1.a(0);
        ewo1.a(mProfanityFilterEnabled);
        ewo1.a(mSampleRate);
        if (mEnablePartials)
        {
            ewo1.c(true);
        }
        if (mEnableAlternates)
        {
            eyc eyc = mSpeechSettings.getConfiguration();
            ewo1.b(true);
            ewo1.a(S3RecognizerInfoBuilderTask.getAlternateParams(eyc));
        }
        return ewo1;
    }

    protected volatile Object build()
    {
        return build();
    }
}
