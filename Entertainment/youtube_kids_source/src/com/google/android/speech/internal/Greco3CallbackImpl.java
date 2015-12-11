// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.internal;

import com.google.android.speech.RecognitionResponseWrapper;
import com.google.android.speech.callback.RecognitionEngineCallback;
import com.google.android.speech.embedded.Greco3Callback;
import com.google.android.speech.embedded.Greco3Mode;
import daj;
import dap;
import ewf;
import ewg;
import ewk;

// Referenced classes of package com.google.android.speech.internal:
//            RecognizerEventProcessor

public class Greco3CallbackImpl
    implements Greco3Callback
{

    private final RecognitionEngineCallback mCallback;
    private final RecognizerEventProcessor mRecognitionEventProcessor;

    public Greco3CallbackImpl(Greco3Mode greco3mode, RecognitionEngineCallback recognitionenginecallback)
    {
        mRecognitionEventProcessor = new RecognizerEventProcessor(greco3mode, new RecognitionResponseWrapper(recognitionenginecallback, 1));
        mCallback = recognitionenginecallback;
    }

    public void handleAudioLevelEvent(ewf ewf)
    {
    }

    public void handleEndpointerEvent(ewg ewg)
    {
        mCallback.onResult(new daj(1, ewg));
    }

    public void handleError(dap dap)
    {
        mCallback.onError(dap);
    }

    public void handleProgressUpdate(long l)
    {
        mCallback.onProgressUpdate(1, l);
    }

    public void handleRecognitionEvent(ewk ewk)
    {
        mRecognitionEventProcessor.process(ewk);
    }
}
