// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech;

import com.google.android.speech.listeners.RecognitionEventListener;
import com.google.android.speech.logger.SpeechLibLogger;
import dap;
import eee;
import etg;
import ewk;
import ewv;

final class mStopOnEndOfSpeech
    implements RecognitionEventListener
{

    private final ult mAudioCallback;
    private final RecognitionEventListener mDelegate;
    private final SpeechLibLogger mLogger;
    private final boolean mStopOnEndOfSpeech;

    public final void onBeginningOfSpeech(long l)
    {
        mAudioCallback.mAudioCallback(l);
        mDelegate.onBeginningOfSpeech(l);
    }

    public final void onDone()
    {
        mDelegate.onDone();
    }

    public final void onEndOfSpeech()
    {
        if (mStopOnEndOfSpeech)
        {
            mAudioCallback.mAudioCallback();
        }
        mLogger.logEndOfSpeech();
        mDelegate.onEndOfSpeech();
    }

    public final void onError(dap dap)
    {
        mDelegate.onError(dap);
    }

    public final void onMajelResult(etg etg)
    {
        mLogger.logS3MajelResultReceived();
        mDelegate.onMajelResult(etg);
    }

    public final void onMediaDataResult(byte abyte0[])
    {
        mLogger.logS3TtsReceived();
        mDelegate.onMediaDataResult(abyte0);
    }

    public final void onMusicDetected()
    {
        mDelegate.onMusicDetected();
    }

    public final void onNoSpeechDetected()
    {
        mLogger.logNoSpeechDetected();
        mDelegate.onNoSpeechDetected();
    }

    public final void onPinholeResult(ewv ewv)
    {
        mDelegate.onPinholeResult(ewv);
    }

    public final void onReadyForSpeech()
    {
        mDelegate.onReadyForSpeech();
    }

    public final void onRecognitionCancelled()
    {
        mDelegate.onRecognitionCancelled();
    }

    public final void onRecognitionResult(ewk ewk)
    {
        mDelegate.onRecognitionResult(ewk);
    }

    public final void onSoundSearchResult(eee eee)
    {
        mLogger.logS3SoundSearchResultReceived();
        mDelegate.onSoundSearchResult(eee);
    }

    (RecognitionEventListener recognitioneventlistener, SpeechLibLogger speechliblogger,  , boolean flag)
    {
        mDelegate = recognitioneventlistener;
        mLogger = speechliblogger;
        mAudioCallback = ;
        mStopOnEndOfSpeech = flag;
    }
}
