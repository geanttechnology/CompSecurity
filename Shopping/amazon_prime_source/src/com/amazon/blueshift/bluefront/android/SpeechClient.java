// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import com.amazon.blueshift.bluefront.android.audio.AudioSource;
import com.amazon.blueshift.bluefront.android.common.BluefrontCredential;
import com.amazon.blueshift.bluefront.android.request.SpeechRequest;
import com.google.common.base.Preconditions;

// Referenced classes of package com.amazon.blueshift.bluefront.android:
//            SpeechRequestTask, SpeechClientException, SpeechRequestListener

public final class SpeechClient
{
    private class LocalRequestTaskListener
        implements SpeechRequestTask.RequestTaskListener
    {

        final SpeechClient this$0;

        public void onBeginningOfSpeech()
        {
            mSpeechRequestListener.onBeginningOfSpeech();
        }

        public void onBluefrontResult(Object obj)
        {
            mSpeechRequestListener.onBluefrontResults(obj);
        }

        public void onBufferReceived(byte abyte0[])
        {
            mSpeechRequestListener.onBufferReceived(abyte0);
        }

        public void onError(SpeechClientException speechclientexception)
        {
            stopRecording();
            mSpeechRequestListener.onError(speechclientexception);
        }

        public void onMaxSpeechTimeout()
        {
            stopRecording();
            mSpeechRequestListener.onMaxSpeechTimeout();
        }

        public void onNoSpeechTimeout()
        {
            mSpeechRequestListener.onNoSpeechTimeout();
        }

        public void onReadyForSpeech()
        {
            mSpeechRequestListener.onReadyForSpeech(null);
        }

        public void onRmsChanged(float f)
        {
            mSpeechRequestListener.onRmsChanged(f);
        }

        public void onSilenceDetected()
        {
            stopRecording();
            mSpeechRequestListener.onSilenceDetected();
        }

        private LocalRequestTaskListener()
        {
            this$0 = SpeechClient.this;
            super();
        }

    }

    private static class NullSpeechRequestListener
        implements SpeechRequestListener
    {

        public void onBeginningOfSpeech()
        {
        }

        public void onBluefrontResults(Object obj)
        {
        }

        public void onBufferReceived(byte abyte0[])
        {
        }

        public void onEndOfSpeech()
        {
        }

        public void onError(int i)
        {
        }

        public void onError(SpeechClientException speechclientexception)
        {
        }

        public void onEvent(int i, Bundle bundle)
        {
        }

        public void onMaxSpeechTimeout()
        {
        }

        public void onNoSpeechTimeout()
        {
        }

        public void onPartialResults(Bundle bundle)
        {
        }

        public void onReadyForSpeech(Bundle bundle)
        {
        }

        public void onResults(Bundle bundle)
        {
        }

        public void onRmsChanged(float f)
        {
        }

        public void onSilenceDetected()
        {
        }

        private NullSpeechRequestListener()
        {
        }

    }


    private static final String TAG = com/amazon/blueshift/bluefront/android/SpeechClient.getCanonicalName();
    private final AudioSource mAudioSource;
    private final BluefrontCredential mCredentials;
    private boolean mIsListening;
    private final SpeechRequest mSpeechRequest;
    private SpeechRequestListener mSpeechRequestListener;
    private SpeechRequestTask mSpeechRequestTask;

    public SpeechClient(SpeechRequest speechrequest, AudioSource audiosource, BluefrontCredential bluefrontcredential)
    {
        mIsListening = false;
        Preconditions.checkNotNull(speechrequest, "Speech request cannot be null.");
        Preconditions.checkNotNull(audiosource, "AudioSource cannot be null");
        Preconditions.checkNotNull(bluefrontcredential, "Credentials cannot be null.");
        mSpeechRequest = speechrequest;
        mAudioSource = audiosource;
        mCredentials = bluefrontcredential;
        initializeSpeechRequestListener();
    }

    private void initializeSpeechRequestListener()
    {
        mSpeechRequestListener = new NullSpeechRequestListener();
    }

    private void stopRecording()
    {
        if (mSpeechRequestTask != null)
        {
            mSpeechRequestTask.stopRecording();
        }
        mIsListening = false;
    }

    public void cancel()
    {
        initializeSpeechRequestListener();
        if (mSpeechRequestTask != null && !mSpeechRequestTask.isCancelled())
        {
            mSpeechRequestTask.cancel(true);
            stopRecording();
        }
        mSpeechRequestTask = null;
    }

    public SpeechRequestListener getSpeechRequestListener()
    {
        return mSpeechRequestListener;
    }

    public boolean isListening()
    {
        return mIsListening;
    }

    public void setSpeechRequestListener(SpeechRequestListener speechrequestlistener)
    {
        Preconditions.checkNotNull(speechrequestlistener, "Speech request listener cannot be null.");
        mSpeechRequestListener = speechrequestlistener;
    }

    public void startListening()
    {
        if (mSpeechRequestTask == null && (mSpeechRequestListener instanceof NullSpeechRequestListener))
        {
            throw new IllegalStateException("No SpeechRequestListener set for this SpeechClient");
        }
        if (mSpeechRequestTask != null)
        {
            mSpeechRequestListener.onError(new SpeechClientException("SpeechClient is busy."));
            return;
        }
        mSpeechRequestTask = new SpeechRequestTask(mSpeechRequest, mCredentials, mAudioSource, new LocalRequestTaskListener());
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            mSpeechRequestTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else
        {
            mSpeechRequestTask.execute(new Void[0]);
        }
        mIsListening = true;
    }

    public void stopListening()
    {
        if (mIsListening)
        {
            stopRecording();
            mSpeechRequestListener.onEndOfSpeech();
            return;
        } else
        {
            Log.i(TAG, "No recognition is running");
            return;
        }
    }



}
