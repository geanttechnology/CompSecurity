// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech;

import com.google.android.speech.audio.AudioStore;
import com.google.android.speech.listeners.RecognitionEventListener;
import com.google.android.speech.params.SessionParams;
import java.util.concurrent.Executor;

public interface Recognizer
{

    public static final String LOCALE_EN_US_BCP47 = "en-US";

    public abstract void cancel(RecognitionEventListener recognitioneventlistener);

    public abstract void startListening(SessionParams sessionparams, RecognitionEventListener recognitioneventlistener, Executor executor, AudioStore audiostore);

    public abstract void startRecordedAudioRecognition(SessionParams sessionparams, byte abyte0[], RecognitionEventListener recognitioneventlistener, Executor executor);

    public abstract void stopListening(RecognitionEventListener recognitioneventlistener);
}
