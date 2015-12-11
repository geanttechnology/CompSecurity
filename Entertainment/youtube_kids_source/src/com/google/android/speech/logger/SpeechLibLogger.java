// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.logger;


public interface SpeechLibLogger
{

    public abstract void logAudioPathEstablished(LogData logdata);

    public abstract void logBug(int i);

    public abstract void logEndOfSpeech();

    public abstract void logNoSpeechDetected();

    public abstract void logS3ConnectionDone();

    public abstract void logS3ConnectionError();

    public abstract void logS3ConnectionOpen();

    public abstract void logS3ConnectionOpenLatency();

    public abstract void logS3MajelResultReceived();

    public abstract void logS3RecognitionCompleted();

    public abstract void logS3SendEndOfData();

    public abstract void logS3SoundSearchResultReceived();

    public abstract void logS3TtsReceived();

    public abstract void logUsingResultsFromEmbedded();

    public abstract void logUsingResultsFromNetwork();

    public abstract void recordBreakdownEvent(int i);

    public abstract void recordOpenMicrophoneLatencyStart();

    public abstract void recordSpeechEvent(int i);

    public abstract void recordSpeechEvent(int i, Object obj);
}
