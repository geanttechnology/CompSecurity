// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.engine;

import com.google.android.speech.logger.SpeechLibLogger;
import czq;
import f;

public final class LoggingEventListener
    implements czq
{

    private static LoggingEventListener mInstance = null;
    private final SpeechLibLogger mSpeechLibLogger;

    private LoggingEventListener(SpeechLibLogger speechliblogger)
    {
        mSpeechLibLogger = (SpeechLibLogger)f.b(speechliblogger);
    }

    public static LoggingEventListener getInstance(SpeechLibLogger speechliblogger)
    {
        if (mInstance == null)
        {
            mInstance = new LoggingEventListener(speechliblogger);
        }
        return mInstance;
    }

    public final void onConnectionFinished()
    {
        mSpeechLibLogger.logS3ConnectionOpenLatency();
    }

    public final void onConnectionStarted()
    {
        mSpeechLibLogger.logS3ConnectionOpen();
    }

    public final void onDataComplete()
    {
        mSpeechLibLogger.logS3SendEndOfData();
    }

    public final void onDataReceived()
    {
    }

    public final void onDataSent()
    {
        mSpeechLibLogger.recordSpeechEvent(4);
    }

    public final void onError()
    {
    }

}
