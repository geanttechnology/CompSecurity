// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.engine;

import a;
import android.util.Log;
import com.google.android.speech.audio.AudioInputStreamFactory;
import com.google.android.speech.callback.Callback;
import com.google.android.speech.callback.RecognitionEngineCallback;
import com.google.android.speech.logger.SpeechLibLogger;
import com.google.android.speech.network.producers.RequestProducerFactory;
import com.google.android.speech.params.SessionParams;
import czr;
import dab;
import dak;
import dap;
import dat;
import f;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

// Referenced classes of package com.google.android.speech.engine:
//            RecognitionEngine, RetryPolicy, LoggingEventListener, RetryCallback

public class NetworkRecognitionEngine
    implements RecognitionEngine, RetryCallback.Retrier
{

    private static final boolean DEBUG = false;
    private static final String TAG = "NetworkRecognitionEngine";
    private final ExecutorService mExecutorService;
    private final dab mFallback;
    private AudioInputStreamFactory mInputFactory;
    private Callback mOriginalCallback;
    private final dab mPrimary;
    private final RequestProducerFactory mRequestProducerFactory;
    private RetryCallback mRetryCallback;
    private Future mRetryFuture;
    private final Object mRetryLock = new Object();
    private final RetryPolicy mRetryPolicy;
    private czr mRunner;
    private final dat mSameThread = a.H();
    private final SpeechLibLogger mSpeechLibLogger;

    public NetworkRecognitionEngine(dab dab, dab dab1, RetryPolicy retrypolicy, ExecutorService executorservice, RequestProducerFactory requestproducerfactory, SpeechLibLogger speechliblogger)
    {
        mPrimary = dab;
        mFallback = dab1;
        mRetryPolicy = retrypolicy;
        mExecutorService = (ExecutorService)f.b(executorservice);
        mRequestProducerFactory = requestproducerfactory;
        mSpeechLibLogger = speechliblogger;
    }

    private void maybeRefreshRequestProduceFactory(dap dap1)
    {
        if (mRetryPolicy.isAuthException(dap1))
        {
            mRequestProducerFactory.refresh();
        }
    }

    public void close()
    {
        dat dat = mSameThread;
        mRetryCallback = null;
        mOriginalCallback = null;
        mInputFactory = null;
        if (mRunner != null)
        {
            mRunner.close();
            mRunner = null;
        }
        synchronized (mRetryLock)
        {
            if (mRetryFuture != null)
            {
                mRetryFuture.cancel(false);
                mRetryFuture = null;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void createAndStartRecognitionRunner(dab dab)
    {
        java.io.InputStream inputstream;
        boolean flag;
        try
        {
            inputstream = mInputFactory.createInputStream();
        }
        // Misplaced declaration of an exception variable
        catch (dab dab)
        {
            mRetryCallback.onError(new dak("Unable to create stream", dab));
            return;
        }
        f.b(inputstream);
        mRunner = new czr(mRetryCallback, LoggingEventListener.getInstance(mSpeechLibLogger), dab, mRequestProducerFactory.newRequestProducer(inputstream));
        dab = mRunner;
        if (((czr) (dab)).b == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.b(flag, "Duplicate call to start.");
        dab.b = ((czr) (dab)).a.submit(((czr) (dab)).c);
    }

    void retry(dap dap1)
    {
        if (mRetryCallback == null)
        {
            return;
        }
        mRetryCallback = new RetryCallback(mOriginalCallback, mRetryPolicy, this);
        maybeRefreshRequestProduceFactory(dap1);
        mRunner.close();
        if (mFallback != null)
        {
            dap1 = mFallback;
        } else
        {
            dap1 = mPrimary;
        }
        createAndStartRecognitionRunner(dap1);
        synchronized (mRetryLock)
        {
            mRetryCallback = null;
        }
        return;
        exception;
        dap1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void scheduleRetry(final dap e)
    {
        Object obj = mRetryLock;
        obj;
        JVM INSTR monitorenter ;
        if (mRetryFuture != null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        mRetryFuture = mExecutorService.submit(new _cls1());
_L2:
        return;
        Log.w("NetworkRecognitionEngine", (new StringBuilder("Discarding retry request (already active) for: ")).append(e.getMessage()).toString());
        if (true) goto _L2; else goto _L1
_L1:
        e;
        obj;
        JVM INSTR monitorexit ;
        throw e;
    }

    public void startRecognition(AudioInputStreamFactory audioinputstreamfactory, RecognitionEngineCallback recognitionenginecallback, SessionParams sessionparams)
    {
        dat dat = mSameThread;
        boolean flag;
        if (mRetryCallback == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.b(flag);
        mRetryPolicy.reset();
        mOriginalCallback = recognitionenginecallback;
        mRetryCallback = new RetryCallback(recognitionenginecallback, mRetryPolicy, this);
        mInputFactory = audioinputstreamfactory;
        mRequestProducerFactory.init(sessionparams);
        createAndStartRecognitionRunner(mPrimary);
    }

    private class _cls1
        implements Runnable
    {

        final NetworkRecognitionEngine this$0;
        final dap val$e;

        public void run()
        {
            retry(e);
        }

        _cls1()
        {
            this$0 = NetworkRecognitionEngine.this;
            e = dap1;
            super();
        }
    }

}
