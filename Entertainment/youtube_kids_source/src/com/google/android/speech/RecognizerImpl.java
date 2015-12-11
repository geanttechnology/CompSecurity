// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech;

import a;
import android.util.Log;
import com.google.android.speech.audio.AudioController;
import com.google.android.speech.audio.AudioInputStreamFactory;
import com.google.android.speech.audio.AudioRecorder;
import com.google.android.speech.audio.AudioStore;
import com.google.android.speech.audio.MicrophoneInputStreamFactory;
import com.google.android.speech.dispatcher.RecognitionDispatcher;
import com.google.android.speech.listeners.RecognitionEventListener;
import com.google.android.speech.logger.SpeechLibLogger;
import com.google.android.speech.params.AudioInputParams;
import com.google.android.speech.params.SessionParams;
import dak;
import daz;
import dba;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.google.android.speech:
//            Recognizer, SpeechLibFactory, ResponseProcessor, EngineSelector, 
//            RecognitionEngineStore

public class RecognizerImpl
    implements Recognizer
{

    private static final boolean DBG = false;
    private static final String TAG = "RecognizerImpl";
    private final AudioController mAudioController;
    private final AudioRecorder mAudioRecorder;
    private final RecognitionEngineStore mEngineStore;
    private final daz mListeningState;
    private final RecognitionDispatcher mRecognitionDispatcher;
    private RecognitionEventListener mRecognitionListener;
    private ResponseProcessor mResponseProcessor;
    private final SpeechLibFactory mSpeechLibFactory;
    private final SpeechLibLogger mSpeechLibLogger;

    public RecognizerImpl(AudioController audiocontroller, AudioRecorder audiorecorder, RecognitionDispatcher recognitiondispatcher, RecognitionEngineStore recognitionenginestore, SpeechLibFactory speechlibfactory)
    {
        dba dba1 = daz.a("RecognizerImpl", State.IDLE).a(State.IDLE, State.LISTENING).a(State.LISTENING, State.IDLE).a(State.LISTENING, State.LISTENING).a(State.LISTENING, State.STOPPED).a(State.STOPPED, State.IDLE);
        dba1.b = true;
        dba1.a = true;
        mListeningState = dba1.a();
        mAudioController = audiocontroller;
        mAudioRecorder = audiorecorder;
        mRecognitionDispatcher = recognitiondispatcher;
        mEngineStore = recognitionenginestore;
        mSpeechLibFactory = speechlibfactory;
        mSpeechLibLogger = speechlibfactory.buildSpeechLibLogger();
    }

    public static Recognizer create(ExecutorService executorservice, AudioController audiocontroller, SpeechLibFactory speechlibfactory)
    {
        return (Recognizer)threadChange(executorservice, new RecognizerImpl(audiocontroller, new AudioRecorder(), new RecognitionDispatcher(executorservice, speechlibfactory), speechlibfactory.buildRecognitionEngineStore(), speechlibfactory));
    }

    private void internalShutdownAudio()
    {
        mListeningState.a(State.IDLE);
        mResponseProcessor.invalidate();
        mResponseProcessor = null;
        mRecognitionListener = null;
        mAudioController.shutdown();
        mAudioRecorder.waitForRecording();
        mRecognitionDispatcher.cancel();
    }

    private void internalShutdownAudio(RecognitionEventListener recognitioneventlistener)
    {
        if (!isListenerStillCurrent(recognitioneventlistener))
        {
            return;
        } else
        {
            internalShutdownAudio();
            return;
        }
    }

    private void internalStopAudio()
    {
        if (mListeningState.b(State.LISTENING))
        {
            mListeningState.a(State.STOPPED);
            mAudioController.stopListening();
            mAudioRecorder.waitForRecording();
        }
    }

    private void internalStopAudio(RecognitionEventListener recognitioneventlistener)
    {
        if (!isListenerStillCurrent(recognitioneventlistener))
        {
            return;
        } else
        {
            internalStopAudio();
            return;
        }
    }

    private boolean isListenerStillCurrent(RecognitionEventListener recognitioneventlistener)
    {
        if (recognitioneventlistener == null || recognitioneventlistener != mRecognitionListener)
        {
            (new StringBuilder("Supplied listener [")).append(recognitioneventlistener).append("] is not the one that is currently active [").append(mRecognitionListener).append("]");
            return false;
        } else
        {
            return true;
        }
    }

    private void recordStartRecognitionEvent(SessionParams sessionparams)
    {
        if (sessionparams.getMode() != 6)
        {
            mSpeechLibLogger.recordSpeechEvent(3, sessionparams.getRequestId());
        }
        switch (sessionparams.getMode())
        {
        case 6: // '\006'
        default:
            mSpeechLibLogger.recordSpeechEvent(8);
            return;

        case 7: // '\007'
            mSpeechLibLogger.recordSpeechEvent(10);
            return;

        case 8: // '\b'
            mSpeechLibLogger.recordSpeechEvent(15);
            return;

        case 5: // '\005'
            mSpeechLibLogger.recordSpeechEvent(12);
            return;

        case 4: // '\004'
            mSpeechLibLogger.recordSpeechEvent(11);
            return;
        }
    }

    private static final Object threadChange(Executor executor, Class class1, Object obj)
    {
        return a.a(executor, class1, obj);
    }

    private static final Object threadChange(Executor executor, Object obj)
    {
        return a.a(executor, obj);
    }

    public void cancel(RecognitionEventListener recognitioneventlistener)
    {
        if (!mListeningState.c(State.IDLE) || !isListenerStillCurrent(recognitioneventlistener))
        {
            return;
        } else
        {
            mResponseProcessor.onRecognitionCancelled();
            internalShutdownAudio(recognitioneventlistener);
            return;
        }
    }

    ResponseProcessor.AudioCallback getAudioCallback(final RecognitionEventListener listener)
    {
        return new _cls1();
    }

    void setResponseProcessor(ResponseProcessor responseprocessor)
    {
        mResponseProcessor = responseprocessor;
    }

    public void startListening(SessionParams sessionparams, RecognitionEventListener recognitioneventlistener, Executor executor, AudioStore audiostore)
    {
        AudioInputParams audioinputparams = sessionparams.getAudioInputParams();
        if (!mListeningState.c(State.IDLE)) goto _L2; else goto _L1
_L1:
        if (!audioinputparams.hasStreamRewindTime()) goto _L4; else goto _L3
_L3:
        boolean flag;
        mRecognitionDispatcher.cancel();
        mResponseProcessor.invalidate();
        mResponseProcessor = null;
        flag = true;
_L6:
        EngineSelector engineselector;
        List list;
        mRecognitionListener = recognitioneventlistener;
        executor = (RecognitionEventListener)threadChange(executor, com/google/android/speech/listeners/RecognitionEventListener, recognitioneventlistener);
        recordStartRecognitionEvent(sessionparams);
        engineselector = mSpeechLibFactory.buildEngineSelector(sessionparams);
        mResponseProcessor = mSpeechLibFactory.buildResponseProcessor(getAudioCallback(mRecognitionListener), executor, sessionparams, mSpeechLibLogger);
        list = engineselector.getEngineList();
        if (list.isEmpty())
        {
            executor.onError(new dak());
            return;
        }
        break; /* Loop/switch isn't completed */
_L4:
        Log.w("RecognizerImpl", "Multiple recognitions in progress, the first will be cancelled.");
        internalShutdownAudio();
        mListeningState.d(State.IDLE);
_L2:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
        if (flag)
        {
            recognitioneventlistener = mAudioController.rewindInputStreamFactory(audioinputparams.getStreamRewindTime());
        } else
        {
            recognitioneventlistener = mAudioController.createInputStreamFactory(audioinputparams);
        }
        if (audiostore != null)
        {
            try
            {
                int i = audioinputparams.getSamplingRate();
                mAudioRecorder.startRecording(recognitioneventlistener.createInputStream(), i, MicrophoneInputStreamFactory.getMicrophoneReadSize(i), audiostore, sessionparams.getRequestId());
            }
            // Misplaced declaration of an exception variable
            catch (SessionParams sessionparams)
            {
                executor.onError(new dak("Unable to start the audio recording", sessionparams));
                return;
            }
        }
        mListeningState.a(State.LISTENING);
        mAudioController.startListening(audioinputparams.shouldRequestAudioFocus(), executor);
        mRecognitionDispatcher.startRecognition(mEngineStore.getEngines(list), recognitioneventlistener, sessionparams, engineselector, mResponseProcessor);
        return;
    }

    public void startRecordedAudioRecognition(SessionParams sessionparams, final byte audio[], RecognitionEventListener recognitioneventlistener, Executor executor)
    {
        if (mListeningState.c(State.IDLE))
        {
            Log.w("RecognizerImpl", "Multiple recognitions in progress, the first will be cancelled.");
            internalShutdownAudio();
        }
        mRecognitionListener = recognitioneventlistener;
        recognitioneventlistener = (RecognitionEventListener)threadChange(executor, com/google/android/speech/listeners/RecognitionEventListener, recognitioneventlistener);
        mListeningState.d(State.IDLE);
        recordStartRecognitionEvent(sessionparams);
        audio = new _cls2();
        mListeningState.a(State.LISTENING);
        executor = mSpeechLibFactory.buildEngineSelector(sessionparams);
        mResponseProcessor = mSpeechLibFactory.buildResponseProcessor(getAudioCallback(mRecognitionListener), recognitioneventlistener, sessionparams, mSpeechLibLogger);
        mRecognitionDispatcher.startRecognition(mEngineStore.getEngines(executor.getEngineList()), audio, sessionparams, executor, mResponseProcessor);
    }

    public void stopListening(RecognitionEventListener recognitioneventlistener)
    {
        if (mListeningState.b(State.LISTENING))
        {
            internalStopAudio(recognitioneventlistener);
        }
    }





    private class State extends Enum
    {

        private static final State $VALUES[];
        public static final State IDLE;
        public static final State LISTENING;
        public static final State STOPPED;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/google/android/speech/RecognizerImpl$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            IDLE = new State("IDLE", 0);
            LISTENING = new State("LISTENING", 1);
            STOPPED = new State("STOPPED", 2);
            $VALUES = (new State[] {
                IDLE, LISTENING, STOPPED
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    private class _cls1
        implements ResponseProcessor.AudioCallback
    {

        final RecognizerImpl this$0;
        final RecognitionEventListener val$listener;

        public void recordingStarted(long l)
        {
            if (mAudioRecorder.isRecording())
            {
                mAudioRecorder.setRecordingStartTime(l);
            }
        }

        public void shutdownAudio()
        {
            if (mListeningState.c(State.IDLE))
            {
                internalShutdownAudio(listener);
            }
        }

        public void stopAudio()
        {
            if (mListeningState.b(State.LISTENING))
            {
                internalStopAudio(listener);
            }
        }

        _cls1()
        {
            this$0 = RecognizerImpl.this;
            listener = recognitioneventlistener;
            super();
        }
    }


    private class _cls2
        implements AudioInputStreamFactory
    {

        final RecognizerImpl this$0;
        final byte val$audio[];

        public InputStream createInputStream()
        {
            return new ByteArrayInputStream(audio);
        }

        _cls2()
        {
            this$0 = RecognizerImpl.this;
            audio = abyte0;
            super();
        }
    }

}
