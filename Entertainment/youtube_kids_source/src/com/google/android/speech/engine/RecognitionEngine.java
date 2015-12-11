// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.engine;

import com.google.android.speech.audio.AudioInputStreamFactory;
import com.google.android.speech.callback.RecognitionEngineCallback;
import com.google.android.speech.params.SessionParams;

public interface RecognitionEngine
{

    public abstract void close();

    public abstract void startRecognition(AudioInputStreamFactory audioinputstreamfactory, RecognitionEngineCallback recognitionenginecallback, SessionParams sessionparams);
}
