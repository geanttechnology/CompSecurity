// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.network.request;

import com.google.android.speech.SpeechSettings;
import eur;
import euu;
import exn;
import eyc;
import eyg;

// Referenced classes of package com.google.android.speech.network.request:
//            BaseRequestBuilderTask

public class S3RecognizerInfoBuilderTask extends BaseRequestBuilderTask
{

    private final int mMaxNbest;
    private final boolean mNeedsAlternates;
    private final boolean mNeedsCombinedNbest;
    private final boolean mNeedsPartialResults;
    private final boolean mProfanityFilterEnabled;
    private final euu mRecognitionContext;
    private final boolean mServerEndpointingEnabled;
    private final SpeechSettings mSpeechSettings;

    public S3RecognizerInfoBuilderTask(euu euu, SpeechSettings speechsettings, boolean flag, boolean flag1, boolean flag2, int i, boolean flag3, 
            boolean flag4)
    {
        super("S3RecognizerInfoBuilderTask");
        mRecognitionContext = euu;
        mSpeechSettings = speechsettings;
        mNeedsPartialResults = flag;
        mNeedsCombinedNbest = flag1;
        mNeedsAlternates = flag2;
        mMaxNbest = i;
        mServerEndpointingEnabled = flag3;
        mProfanityFilterEnabled = flag4;
    }

    static eur getAlternateParams(eyc eyc1)
    {
        return (new eur()).a(eyc1.d.a).b(eyc1.d.b).c(1);
    }

    protected exn build()
    {
        exn exn1 = new exn();
        if (mRecognitionContext != null)
        {
            exn1.a(mRecognitionContext);
        }
        exn1.a(mNeedsPartialResults);
        exn1.c(mNeedsCombinedNbest);
        if (mNeedsCombinedNbest)
        {
            exn1.a(mMaxNbest);
        }
        exn1.b(mNeedsAlternates);
        if (mNeedsAlternates)
        {
            exn1.a(getAlternateParams(mSpeechSettings.getConfiguration()));
        }
        byte byte0;
        if (mProfanityFilterEnabled)
        {
            byte0 = 2;
        } else
        {
            byte0 = 0;
        }
        exn1.b(byte0);
        exn1.d(mSpeechSettings.isPersonalizationEnabled());
        exn1.e(mServerEndpointingEnabled);
        return exn1;
    }

    protected volatile Object build()
    {
        return build();
    }
}
