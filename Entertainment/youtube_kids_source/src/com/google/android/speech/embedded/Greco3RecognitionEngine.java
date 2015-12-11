// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.embedded;

import com.google.android.speech.SpeechSettings;
import com.google.android.speech.audio.AudioInputStreamFactory;
import com.google.android.speech.callback.RecognitionEngineCallback;
import com.google.android.speech.engine.RecognitionEngine;
import com.google.android.speech.logger.SpeechLibLogger;
import com.google.android.speech.network.request.RecognizerSessionParamsBuilderTask;
import com.google.android.speech.params.AudioInputParams;
import com.google.android.speech.params.SessionParams;
import dak;
import dal;
import dap;
import emp;
import ewo;
import f;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.google.android.speech.embedded:
//            Greco3Callback, Greco3EngineManager, Greco3Recognizer, Greco3ModeSelector, 
//            Greco3Mode, Greco3CallbackFactory, Greco3Grammar

public class Greco3RecognitionEngine
    implements RecognitionEngine
{

    private static final boolean DBG = false;
    private static final String TAG = "VS.Greco3RecognitionEngine";
    private final int mBytesPerSample;
    private final Greco3CallbackFactory mCallbackFactory;
    private Greco3Recognizer mCurrentRecognition;
    private Greco3EngineManager.Resources mCurrentResources;
    private final Greco3EngineManager mGreco3EngineManager;
    private final GrecoEventLogger.Factory mGrecoEventLoggerFactory;
    private InputStream mInput;
    private final Greco3ModeSelector mModeSelector;
    private final int mSamplingRate;
    private final SpeechLibLogger mSpeechLibLogger;
    private final SpeechSettings mSpeechSettings;

    public Greco3RecognitionEngine(Greco3EngineManager greco3enginemanager, int i, int j, SpeechSettings speechsettings, Greco3CallbackFactory greco3callbackfactory, Greco3ModeSelector greco3modeselector, GrecoEventLogger.Factory factory, 
            SpeechLibLogger speechliblogger)
    {
        mGreco3EngineManager = greco3enginemanager;
        mSamplingRate = i;
        mBytesPerSample = j;
        mSpeechSettings = speechsettings;
        mCallbackFactory = greco3callbackfactory;
        mModeSelector = greco3modeselector;
        mGrecoEventLoggerFactory = factory;
        mSpeechLibLogger = speechliblogger;
    }

    private void cleanupAndDispatchStartError(Greco3Callback greco3callback, dap dap)
    {
        mCurrentRecognition = null;
        mCurrentResources = null;
        greco3callback.handleError(dap);
    }

    private ewo getEmbeddedRecognizerParams(SessionParams sessionparams)
    {
        return (ewo)(new RecognizerSessionParamsBuilderTask(mSpeechSettings, sessionparams.getAudioInputParams().getSamplingRate(), sessionparams.isPartialResultsEnabled(), sessionparams.isAlternatesEnabled(), sessionparams.isProfanityFilterEnabled())).call();
    }

    public void close()
    {
        if (mCurrentRecognition != null)
        {
            mGreco3EngineManager.release(mCurrentRecognition);
            mCurrentRecognition = null;
        }
        emp.a(mInput);
        mInput = null;
    }

    Greco3Recognizer createRecognizer(Greco3EngineManager.Resources resources)
    {
        resources = Greco3Recognizer.create(resources, mSamplingRate, mBytesPerSample);
        if (resources == null)
        {
            mSpeechLibLogger.logBug(0x8a5c0e);
        }
        return resources;
    }

    Greco3Mode createRecognizerFor(String s, Greco3Mode greco3mode, Greco3Grammar greco3grammar)
    {
        mGreco3EngineManager.maybeInitialize();
        Greco3Mode greco3mode2 = mModeSelector.getMode(greco3mode, greco3grammar);
        Greco3Mode greco3mode1 = mModeSelector.getFallbackMode(greco3mode, greco3grammar);
        if (greco3mode2 == null)
        {
            return null;
        }
        Greco3EngineManager.Resources resources = mGreco3EngineManager.getResources(s, greco3mode2, greco3grammar);
        greco3mode = resources;
        if (resources == null)
        {
            greco3mode = resources;
            if (greco3mode2 == Greco3Mode.GRAMMAR)
            {
                greco3mode = resources;
                if (!"en-US".equals(s))
                {
                    greco3mode = mGreco3EngineManager.getResources("en-US", greco3mode2, greco3grammar);
                }
            }
        }
        if (greco3mode == null)
        {
            if (greco3mode1 == null)
            {
                return null;
            }
            greco3grammar = mGreco3EngineManager.getResources(s, greco3mode1, null);
            greco3mode = greco3grammar;
            s = greco3mode1;
            if (greco3grammar == null)
            {
                return null;
            }
        } else
        {
            s = greco3mode2;
        }
        mCurrentRecognition = createRecognizer(greco3mode);
        if (mCurrentRecognition == null)
        {
            mCurrentResources = null;
            return null;
        } else
        {
            mCurrentResources = greco3mode;
            return s;
        }
    }

    public void startRecognition(AudioInputStreamFactory audioinputstreamfactory, RecognitionEngineCallback recognitionenginecallback, SessionParams sessionparams)
    {
        f.b(recognitionenginecallback);
        mCurrentRecognition = null;
        mCurrentResources = null;
        Greco3Recognizer.maybeLoadSharedLibrary();
        Greco3Mode greco3mode = sessionparams.getGreco3Mode();
        Greco3Mode greco3mode1 = createRecognizerFor(sessionparams.getSpokenBcp47Locale(), greco3mode, sessionparams.getGreco3Grammar());
        recognitionenginecallback = mCallbackFactory.create(recognitionenginecallback, greco3mode1);
        if (greco3mode1 == null)
        {
            cleanupAndDispatchStartError(recognitionenginecallback, new dal());
        } else
        {
            try
            {
                mInput = audioinputstreamfactory.createInputStream();
            }
            // Misplaced declaration of an exception variable
            catch (AudioInputStreamFactory audioinputstreamfactory)
            {
                cleanupAndDispatchStartError(recognitionenginecallback, new dak("Unable to create stream", audioinputstreamfactory));
                return;
            }
            mGreco3EngineManager.startRecognition(mCurrentRecognition, mInput, recognitionenginecallback, getEmbeddedRecognizerParams(sessionparams), mGrecoEventLoggerFactory.getEventLoggerForMode(greco3mode1), mCurrentResources.languagePack);
            if (greco3mode1.isEndpointerMode() && !greco3mode.isEndpointerMode())
            {
                recognitionenginecallback.handleError(new dal());
                return;
            }
        }
    }
}
