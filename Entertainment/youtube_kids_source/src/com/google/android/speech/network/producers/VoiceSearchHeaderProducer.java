// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.network.producers;

import com.google.android.speech.SpeechSettings;
import com.google.android.speech.logger.SpeechLibLogger;
import dae;
import dai;
import eqr;
import ewq;
import eww;
import exa;
import exe;
import exi;
import exm;
import exn;
import java.util.concurrent.Future;

public class VoiceSearchHeaderProducer extends dae
{

    private final Future mPinholeParamsFuture;
    private final Future mRecognizerVocabularyContextFuture;
    private final exn mS3RecognizerInfo;
    private final String mService;
    private final SpeechLibLogger mSpeechLibLogger;
    private final SpeechSettings mSpeechSettings;

    public VoiceSearchHeaderProducer(Future future, Future future1, Future future2, Future future3, Future future4, ewq ewq, exn exn, 
            String s, String s1, SpeechLibLogger speechliblogger, SpeechSettings speechsettings)
    {
        super(future1, future2, future3, ewq, s, s1);
        mPinholeParamsFuture = future;
        mRecognizerVocabularyContextFuture = future4;
        mS3RecognizerInfo = exn;
        mSpeechLibLogger = speechliblogger;
        mSpeechSettings = speechsettings;
        mService = s1;
    }

    private void maybeCopyUserAgentToMajelExtension(exe exe1)
    {
        if ("voicesearch".equals(mService) && exe1.b.a)
        {
            exe1.a((new exi()).a((new eqr()).a(exe1.b.b)));
        }
    }

    public exe produceRequest()
    {
        mSpeechLibLogger.recordSpeechEvent(6);
        exe exe1 = super.produceRequest();
        if (mPinholeParamsFuture != null)
        {
            exe1.a((eww)mTimeoutEnforcer.a(mPinholeParamsFuture));
        }
        maybeCopyUserAgentToMajelExtension(exe1);
        exe1.a((exm)mTimeoutEnforcer.a(mRecognizerVocabularyContextFuture));
        if (mS3RecognizerInfo != null)
        {
            exe1.a(mS3RecognizerInfo);
        }
        exe1.b(mSpeechSettings.isS3DebugLoggingEnabled());
        mSpeechLibLogger.recordSpeechEvent(7);
        return exe1;
    }
}
