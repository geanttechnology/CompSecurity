// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.dispatcher;

import a;
import android.util.Log;
import android.util.Pair;
import com.google.android.speech.EngineSelector;
import com.google.android.speech.SpeechLibFactory;
import com.google.android.speech.audio.AudioInputStreamFactory;
import com.google.android.speech.callback.RecognitionEngineCallback;
import com.google.android.speech.engine.RecognitionEngine;
import com.google.android.speech.params.SessionParams;
import daz;
import dba;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class RecognitionDispatcher
{

    private static final boolean DBG = false;
    private static final String TAG = "RecognitionDispatcher";
    private final ExecutorService mExecutor;
    private Collection mRecognitionEngines;
    private ResultsMerger mResultsMerger;
    private final SpeechLibFactory mSpeechLibFactory;
    private final daz mState;

    public RecognitionDispatcher(ExecutorService executorservice, SpeechLibFactory speechlibfactory)
    {
        dba dba1 = daz.a("RecognitionDispatcher", State.IDLE).a(State.IDLE, State.RUNNING).a(State.RUNNING, State.IDLE);
        dba1.b = true;
        dba1.a = true;
        mState = dba1.a();
        mExecutor = executorservice;
        mSpeechLibFactory = speechlibfactory;
    }

    private void stop()
    {
        mState.d(State.RUNNING);
        mState.a(State.IDLE);
        mResultsMerger.invalidate();
        mResultsMerger = null;
        for (Iterator iterator = mRecognitionEngines.iterator(); iterator.hasNext(); ((RecognitionEngine)((Pair)iterator.next()).second).close()) { }
        mRecognitionEngines = null;
    }

    private static final Object threadChange(Executor executor, Object obj)
    {
        return a.a(executor, obj);
    }

    public void cancel()
    {
        if (mState.b(State.RUNNING))
        {
            stop();
        }
    }

    ResultsMerger getResultsMerger()
    {
        return mResultsMerger;
    }

    boolean isRunning()
    {
        return mState.b(State.RUNNING);
    }

    public void startRecognition(Collection collection, AudioInputStreamFactory audioinputstreamfactory, SessionParams sessionparams, EngineSelector engineselector, RecognitionEngineCallback recognitionenginecallback)
    {
        if (mState.b(State.RUNNING))
        {
            Log.w("RecognitionDispatcher", "Multiple recognitions in progress, the first will be cancelled.");
            stop();
        }
        mState.a(State.RUNNING);
        mRecognitionEngines = collection;
        mResultsMerger = mSpeechLibFactory.buildResultsMerger(sessionparams, this, engineselector, recognitionenginecallback, mExecutor);
        collection = (RecognitionEngineCallback)threadChange(mExecutor, mResultsMerger);
        for (engineselector = mRecognitionEngines.iterator(); engineselector.hasNext(); ((RecognitionEngine)((Pair)engineselector.next()).second).startRecognition(audioinputstreamfactory, collection, sessionparams)) { }
    }

    public void stopEngine(int i)
    {
        if (mState.b(State.RUNNING))
        {
            Iterator iterator = mRecognitionEngines.iterator();
            boolean flag = false;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Pair pair = (Pair)iterator.next();
                if (i == ((Integer)pair.first).intValue())
                {
                    ((RecognitionEngine)pair.second).close();
                    iterator.remove();
                    flag = true;
                }
            } while (true);
            if (!flag)
            {
                Log.w("RecognitionDispatcher", (new StringBuilder("Could not stop engine ")).append(i).toString());
            }
            if (mRecognitionEngines.isEmpty())
            {
                stop();
            }
        }
    }

    private class State extends Enum
    {

        private static final State $VALUES[];
        public static final State IDLE;
        public static final State RUNNING;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/google/android/speech/dispatcher/RecognitionDispatcher$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            IDLE = new State("IDLE", 0);
            RUNNING = new State("RUNNING", 1);
            $VALUES = (new State[] {
                IDLE, RUNNING
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    private class ResultsMerger
        implements RecognitionEngineCallback
    {

        public abstract void invalidate();
    }

}
