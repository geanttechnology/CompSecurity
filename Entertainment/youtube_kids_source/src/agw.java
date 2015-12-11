// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.speech.EngineSelector;
import com.google.android.speech.RecognitionEngineStore;
import com.google.android.speech.ResponseProcessor;
import com.google.android.speech.SpeechLibFactory;
import com.google.android.speech.SpeechSettings;
import com.google.android.speech.callback.RecognitionEngineCallback;
import com.google.android.speech.dispatcher.RecognitionDispatcher;
import com.google.android.speech.listeners.RecognitionEventListener;
import com.google.android.speech.logger.SpeechLibLogger;
import com.google.android.speech.params.RecognitionEngineParams;
import com.google.android.speech.params.SessionParams;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class agw
    implements SpeechLibFactory
{

    private static final String c = agw.getSimpleName();
    final ExecutorService a = Executors.newSingleThreadExecutor();
    public boolean b;
    private final SpeechSettings d;
    private final RecognitionEngineParams e;

    public agw(RecognitionEngineParams recognitionengineparams, SpeechSettings speechsettings)
    {
        b = false;
        e = recognitionengineparams;
        d = speechsettings;
        Executors.newSingleThreadExecutor();
    }

    static RecognitionEngineParams a(agw agw1)
    {
        return agw1.e;
    }

    static String a()
    {
        return c;
    }

    static boolean b(agw agw1)
    {
        return agw1.b;
    }

    public EngineSelector buildEngineSelector(SessionParams sessionparams)
    {
        return new agy(this);
    }

    public RecognitionEngineStore buildRecognitionEngineStore()
    {
        return new agz(this);
    }

    public ResponseProcessor buildResponseProcessor(com.google.android.speech.ResponseProcessor.AudioCallback audiocallback, RecognitionEventListener recognitioneventlistener, SessionParams sessionparams, SpeechLibLogger speechliblogger)
    {
        return new agx(this, audiocallback, recognitioneventlistener, sessionparams.stopOnEndOfSpeech(), sessionparams.getEndpointerParams(d), new ahr(), speechliblogger);
    }

    public com.google.android.speech.dispatcher.RecognitionDispatcher.ResultsMerger buildResultsMerger(SessionParams sessionparams, RecognitionDispatcher recognitiondispatcher, EngineSelector engineselector, RecognitionEngineCallback recognitionenginecallback, ExecutorService executorservice)
    {
        return new agv(recognitiondispatcher, recognitionenginecallback);
    }

    public SpeechLibLogger buildSpeechLibLogger()
    {
        return new ahc();
    }

}
