// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech;

import com.google.android.speech.callback.RecognitionEngineCallback;
import com.google.android.speech.dispatcher.RecognitionDispatcher;
import com.google.android.speech.listeners.RecognitionEventListener;
import com.google.android.speech.logger.SpeechLibLogger;
import com.google.android.speech.params.SessionParams;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.google.android.speech:
//            EngineSelector, RecognitionEngineStore, ResponseProcessor

public interface SpeechLibFactory
{

    public abstract EngineSelector buildEngineSelector(SessionParams sessionparams);

    public abstract RecognitionEngineStore buildRecognitionEngineStore();

    public abstract ResponseProcessor buildResponseProcessor(ResponseProcessor.AudioCallback audiocallback, RecognitionEventListener recognitioneventlistener, SessionParams sessionparams, SpeechLibLogger speechliblogger);

    public abstract com.google.android.speech.dispatcher.RecognitionDispatcher.ResultsMerger buildResultsMerger(SessionParams sessionparams, RecognitionDispatcher recognitiondispatcher, EngineSelector engineselector, RecognitionEngineCallback recognitionenginecallback, ExecutorService executorservice);

    public abstract SpeechLibLogger buildSpeechLibLogger();
}
