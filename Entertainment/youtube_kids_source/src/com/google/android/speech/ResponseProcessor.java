// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech;

import a;
import com.google.android.speech.callback.RecognitionEngineCallback;
import com.google.android.speech.endpointing.DefaultEndpointerEventProcessor;
import com.google.android.speech.endpointing.EndpointerEventProcessor;
import com.google.android.speech.listeners.RecognitionEventListener;
import com.google.android.speech.logger.SpeechLibLogger;
import daj;
import dap;
import dat;
import ewg;
import ewj;
import ewk;
import exf;
import exl;
import eyi;

// Referenced classes of package com.google.android.speech:
//            S3ResponseProcessor

public class ResponseProcessor
    implements RecognitionEngineCallback
{

    private static final boolean DBG = false;
    private static final String TAG = "ResponseProcessor";
    private final AudioCallback mAudioCallback;
    private final EndpointerEventProcessor mEndpointerEventProcessor;
    private final RecognitionEventListener mEventListener;
    private boolean mInvalid;
    private final SpeechLibLogger mLogger;
    private final S3ResponseProcessor mS3ResponseProcessor;
    private final dat mThreadCheck = a.H();

    public ResponseProcessor(AudioCallback audiocallback, RecognitionEventListener recognitioneventlistener, boolean flag, eyi eyi, S3ResponseProcessor s3responseprocessor, SpeechLibLogger speechliblogger)
    {
        mInvalid = false;
        mAudioCallback = audiocallback;
        mEventListener = new InternalRecognitionEventListener(recognitioneventlistener, speechliblogger, audiocallback, flag);
        mEndpointerEventProcessor = new DefaultEndpointerEventProcessor(mEventListener, eyi);
        mS3ResponseProcessor = s3responseprocessor;
        mLogger = speechliblogger;
    }

    private void handleHotwordDetectorResponse(Boolean boolean1)
    {
        if (boolean1 == Boolean.TRUE)
        {
            boolean1 = new ewk();
            ewj ewj1 = new ewj();
            ewj1.a(true);
            boolean1.a(ewj1);
            mEventListener.onRecognitionResult(boolean1);
        }
    }

    private void handleMusicDetectorResponse(Boolean boolean1)
    {
        if (boolean1 == Boolean.TRUE)
        {
            mEventListener.onMusicDetected();
        }
    }

    private void handleS3Response(exf exf1)
    {
        if (exf1.a != 1) goto _L2; else goto _L1
_L1:
        mLogger.logS3ConnectionDone();
        mAudioCallback.shutdownAudio();
_L4:
        mS3ResponseProcessor.process(exf1, mEventListener);
        return;
_L2:
        if (exf1.a == 2)
        {
            mLogger.logS3ConnectionError();
            mAudioCallback.shutdownAudio();
        } else
        if (exf1.a == 0 && exf1.b && exf1.c.a && exf1.c.b.b == 1)
        {
            mLogger.logS3RecognitionCompleted();
            mAudioCallback.stopAudio();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void invalidate()
    {
        dat dat = mThreadCheck;
        mInvalid = true;
    }

    public void onError(dap dap1)
    {
        dat dat = mThreadCheck;
        if (mInvalid)
        {
            return;
        } else
        {
            mAudioCallback.shutdownAudio();
            mEventListener.onError(dap1);
            return;
        }
    }

    public volatile void onError(Object obj)
    {
        onError((dap)obj);
    }

    public void onProgressUpdate(int i, long l)
    {
        dat dat = mThreadCheck;
        if (mInvalid)
        {
            return;
        } else
        {
            mEndpointerEventProcessor.updateProgress(i, l);
            return;
        }
    }

    public void onRecognitionCancelled()
    {
        dat dat = mThreadCheck;
        if (mInvalid)
        {
            return;
        } else
        {
            mEventListener.onRecognitionCancelled();
            return;
        }
    }

    public void onResult(daj daj1)
    {
        dat dat = mThreadCheck;
        if (mInvalid)
        {
            return;
        }
        int i = daj1.b;
        if (i == 3)
        {
            handleMusicDetectorResponse((Boolean)daj1.a(3));
            return;
        }
        if (i == 2)
        {
            daj1 = (ewg)daj1.a(2);
            mEndpointerEventProcessor.process(daj1);
            return;
        }
        if (i == 1)
        {
            handleS3Response((exf)daj1.a(1));
            return;
        }
        if (i == 4)
        {
            handleHotwordDetectorResponse((Boolean)daj1.a(4));
            return;
        } else
        {
            throw new IllegalArgumentException("Unknown response type: ");
        }
    }

    public volatile void onResult(Object obj)
    {
        onResult((daj)obj);
    }

    private class InternalRecognitionEventListener
        implements RecognitionEventListener
    {

        private final AudioCallback mAudioCallback;
        private final RecognitionEventListener mDelegate;
        private final SpeechLibLogger mLogger;
        private final boolean mStopOnEndOfSpeech;

        public final void onBeginningOfSpeech(long l)
        {
            mAudioCallback.recordingStarted(l);
            mDelegate.onBeginningOfSpeech(l);
        }

        public final void onDone()
        {
            mDelegate.onDone();
        }

        public final void onEndOfSpeech()
        {
            if (mStopOnEndOfSpeech)
            {
                mAudioCallback.stopAudio();
            }
            mLogger.logEndOfSpeech();
            mDelegate.onEndOfSpeech();
        }

        public final void onError(dap dap1)
        {
            mDelegate.onError(dap1);
        }

        public final void onMajelResult(etg etg)
        {
            mLogger.logS3MajelResultReceived();
            mDelegate.onMajelResult(etg);
        }

        public final void onMediaDataResult(byte abyte0[])
        {
            mLogger.logS3TtsReceived();
            mDelegate.onMediaDataResult(abyte0);
        }

        public final void onMusicDetected()
        {
            mDelegate.onMusicDetected();
        }

        public final void onNoSpeechDetected()
        {
            mLogger.logNoSpeechDetected();
            mDelegate.onNoSpeechDetected();
        }

        public final void onPinholeResult(ewv ewv)
        {
            mDelegate.onPinholeResult(ewv);
        }

        public final void onReadyForSpeech()
        {
            mDelegate.onReadyForSpeech();
        }

        public final void onRecognitionCancelled()
        {
            mDelegate.onRecognitionCancelled();
        }

        public final void onRecognitionResult(ewk ewk1)
        {
            mDelegate.onRecognitionResult(ewk1);
        }

        public final void onSoundSearchResult(eee eee)
        {
            mLogger.logS3SoundSearchResultReceived();
            mDelegate.onSoundSearchResult(eee);
        }

        InternalRecognitionEventListener(RecognitionEventListener recognitioneventlistener, SpeechLibLogger speechliblogger, AudioCallback audiocallback, boolean flag)
        {
            mDelegate = recognitioneventlistener;
            mLogger = speechliblogger;
            mAudioCallback = audiocallback;
            mStopOnEndOfSpeech = flag;
        }
    }


    private class AudioCallback
    {

        public abstract void recordingStarted(long l);

        public abstract void shutdownAudio();

        public abstract void stopAudio();
    }

}
