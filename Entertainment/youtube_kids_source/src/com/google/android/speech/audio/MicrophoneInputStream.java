// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.audio;

import android.media.AudioRecord;
import java.io.IOException;
import java.io.InputStream;

public class MicrophoneInputStream extends InputStream
{

    private static final int AUDIO_FORMAT = 2;
    private static final int AUDIO_SOURCE = 6;
    private static final int AUDIO_SOURCE_HOTWORD = 1999;
    private static final int CHANNEL_CONFIG = 16;
    private static final boolean DEBUG = false;
    public static final int OPEN_MICROPHONE_AUDIO_RECORD_CREATED = 3;
    public static final int OPEN_MICROPHONE_AUDIO_ROUTED = 2;
    public static final int OPEN_MICROPHONE_DONE = 4;
    public static final int OPEN_MICROPHONE_NOISE_SUPPRESSOR_CREATED = 7;
    public static final int OPEN_MICROPHONE_RECORDING_STARTED = 5;
    public static final int OPEN_MICROPHONE_RECORDING_STARTED_SYNCED = 6;
    public static final int OPEN_MICROPHONE_STARTED = 1;
    private static final String TAG = "MicrophoneInputStream";
    private static volatile int sAwaitRouteTokenCounter;
    public AudioRecord mAudioRecord;
    private boolean mAudioRecordCreated;
    private final String mAwaitRouteToken;
    private final int mBufferSize;
    public final Callbacks mCallbacks;
    private boolean mClosed;
    public final Object mLock = new Object();
    public final boolean mNoiseSuppressionEnabled;
    private final boolean mPreemptible;
    private final int mSampleRate;
    private boolean mStarted;

    public MicrophoneInputStream(int i, int j, boolean flag, Callbacks callbacks, boolean flag1)
    {
        mAudioRecordCreated = false;
        mStarted = false;
        mSampleRate = i;
        mBufferSize = Math.max(AudioRecord.getMinBufferSize(i, 16, 2), j);
        mNoiseSuppressionEnabled = flag;
        if (callbacks == null)
        {
            callbacks = new Callbacks();
        }
        mCallbacks = callbacks;
        mPreemptible = flag1;
        callbacks = new StringBuilder("MicrophoneInputStream_");
        i = sAwaitRouteTokenCounter;
        sAwaitRouteTokenCounter = i + 1;
        mAwaitRouteToken = callbacks.append(i).toString();
    }

    private AudioRecord ensureStartedLocked()
    {
        Object obj = mLock;
        if (mAudioRecordCreated && mAudioRecord == null)
        {
            throw new IOException("AudioRecord failed to initialize.");
        }
        if (mStarted)
        {
            return mAudioRecord;
        }
        mCallbacks.onEvent(1);
        mCallbacks.awaitingRouting(mAwaitRouteToken);
        mCallbacks.onEvent(2);
        if (!mAudioRecordCreated)
        {
            mAudioRecord = createAudioRecord();
            mAudioRecordCreated = true;
        }
        mCallbacks.onEvent(3);
        if (mAudioRecord == null)
        {
            throw new IOException("AudioRecord failed to initialize.");
        }
        createNoiseSuppressor();
        startRecording();
        int i = mAudioRecord.getRecordingState();
        if (i != 3)
        {
            throw new IOException((new StringBuilder("couldn't start recording, state is:")).append(i).toString());
        } else
        {
            mStarted = true;
            mCallbacks.onEvent(4);
            return mAudioRecord;
        }
    }

    public void close()
    {
        mCallbacks.cancelPendingAwaitRouting(mAwaitRouteToken);
        synchronized (mLock)
        {
            if (mAudioRecord != null && !mClosed)
            {
                mAudioRecord.stop();
                releaseNoiseSuppressor();
                mAudioRecord.release();
                mClosed = true;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected AudioRecord createAudioRecord()
    {
        char c = '\006';
        if (mPreemptible)
        {
            c = '\u07CF';
        }
        AudioRecord audiorecord1 = new AudioRecord(c, mSampleRate, 16, 2, mBufferSize);
        AudioRecord audiorecord = audiorecord1;
        if (audiorecord1.getState() != 1)
        {
            audiorecord1.release();
            audiorecord = null;
        }
        return audiorecord;
    }

    protected void createNoiseSuppressor()
    {
    }

    public int read()
    {
        throw new UnsupportedOperationException("Single-byte read not supported");
    }

    public int read(byte abyte0[])
    {
        return read(abyte0, 0, abyte0.length);
    }

    public int read(byte abyte0[], int i, int j)
    {
label0:
        {
            synchronized (mLock)
            {
                if (!mClosed)
                {
                    break label0;
                }
            }
            return -1;
        }
        AudioRecord audiorecord = ensureStartedLocked();
        obj;
        JVM INSTR monitorexit ;
        i = audiorecord.read(abyte0, i, j);
        synchronized (mLock)
        {
            if (!mClosed)
            {
                break MISSING_BLOCK_LABEL_70;
            }
        }
        return -1;
        obj;
        abyte0;
        JVM INSTR monitorexit ;
        throw obj;
        abyte0;
        obj;
        JVM INSTR monitorexit ;
        throw abyte0;
        abyte0;
        JVM INSTR monitorexit ;
        if (i < -1)
        {
            if (i == -3)
            {
                throw new IOException("not open");
            }
            if (i == -2)
            {
                throw new IOException("Bad offset/length arguments for buffer");
            } else
            {
                throw new IOException((new StringBuilder("Unexpected error code: ")).append(i).toString());
            }
        } else
        {
            return i;
        }
    }

    protected void releaseNoiseSuppressor()
    {
    }

    protected void startRecording()
    {
        mAudioRecord.startRecording();
        mCallbacks.onEvent(5);
    }

    private class Callbacks
    {

        public void awaitingRouting(String s)
        {
        }

        public void cancelPendingAwaitRouting(String s)
        {
        }

        public void onEvent(int i)
        {
        }

        public int playSpeakNowSound()
        {
            return 0;
        }

        public Callbacks()
        {
        }
    }

}
