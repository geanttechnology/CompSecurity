// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.audio;

import com.google.android.speech.listeners.OnReadyForSpeechListener;
import dax;
import f;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.google.android.speech.audio:
//            AudioInputStreamFactory, SpeechLevelGenerator, Tee, MicrophoneInputStreamFactory

public class AudioSource
    implements AudioInputStreamFactory
{

    private static final boolean DEBUG = false;
    private static final int MAX_SIBLINGS = 16;
    private static final String TAG = "AudioSource";
    private static final boolean USE_GRECO3_SPEECH_LEVELS = false;
    private CaptureThread mCaptureThread;
    private AudioInputStreamFactory mInputStreamFactory;
    private final int mMaxBuffers;
    private final int mMinBuffers;
    private final int mReadSize;
    private final int mSampleRate;
    private final SpeechLevelGenerator mSpeechLevelGenerator;
    private Tee mTee;

    public AudioSource(int i, int j, int k, int l, AudioInputStreamFactory audioinputstreamfactory, dax dax)
    {
        f.b(audioinputstreamfactory);
        mSampleRate = i;
        mReadSize = j;
        mMinBuffers = k;
        mMaxBuffers = l;
        mInputStreamFactory = audioinputstreamfactory;
        if (dax == null)
        {
            audioinputstreamfactory = null;
        } else
        {
            audioinputstreamfactory = new SpeechLevelGenerator(dax);
        }
        mSpeechLevelGenerator = audioinputstreamfactory;
    }

    public AudioSource(AudioSource audiosource)
    {
        audiosource;
        JVM INSTR monitorenter ;
        mSampleRate = audiosource.mSampleRate;
        mReadSize = audiosource.mReadSize;
        mMinBuffers = audiosource.mMinBuffers;
        mMaxBuffers = audiosource.mMaxBuffers;
        mInputStreamFactory = audiosource.mInputStreamFactory;
        mSpeechLevelGenerator = audiosource.mSpeechLevelGenerator;
        mTee = audiosource.mTee;
        mCaptureThread = audiosource.mCaptureThread;
        audiosource.mInputStreamFactory = null;
        audiosource.mTee = null;
        audiosource.mCaptureThread = null;
        audiosource;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        audiosource;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public InputStream createInputStream()
    {
        this;
        JVM INSTR monitorenter ;
        if (mInputStreamFactory == null)
        {
            throw new IOException("Stopped");
        }
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        InputStream inputstream;
        if (mTee == null)
        {
            mTee = new Tee(mInputStreamFactory.createInputStream(), mReadSize, mMinBuffers, mMaxBuffers, 16);
            if (mCaptureThread != null)
            {
                mCaptureThread.setInputStream(mTee.getLeader());
                mCaptureThread.start();
            }
        }
        inputstream = mTee.split();
        this;
        JVM INSTR monitorexit ;
        return inputstream;
    }

    public void setStartTime(long l)
    {
        f.b(mTee);
        f.b(mCaptureThread);
        f.b(mInputStreamFactory);
        l = ((long)MicrophoneInputStreamFactory.getBytesPerMsec(mSampleRate) * l) / 1000L;
        mTee.setStartAtDelegatePos(l);
    }

    public void shutdown()
    {
        this;
        JVM INSTR monitorenter ;
        stopListening();
        mInputStreamFactory = null;
        mTee = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void start(OnReadyForSpeechListener onreadyforspeechlistener)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        if (mCaptureThread == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.b(flag);
        f.b(mInputStreamFactory);
        mCaptureThread = new CaptureThread(mReadSize, mSpeechLevelGenerator, onreadyforspeechlistener);
        if (mTee != null)
        {
            mCaptureThread.setInputStream(mTee.getLeader());
            mCaptureThread.start();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        onreadyforspeechlistener;
        throw onreadyforspeechlistener;
    }

    public void stopListening()
    {
        this;
        JVM INSTR monitorenter ;
        if (mCaptureThread != null)
        {
            mCaptureThread.closeLeader();
            if (mTee != null)
            {
                mCaptureThread.interrupt();
            }
            mCaptureThread = null;
        }
        if (mTee == null)
        {
            mInputStreamFactory = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private class CaptureThread extends Thread
    {

        private InputStream mLeader;
        private final OnReadyForSpeechListener mListener;
        private final int mReadSize;
        private final SpeechLevelGenerator mSpeechLevelGenerator;

        public void closeLeader()
        {
            emp.a(mLeader);
        }

        public void run()
        {
            byte abyte0[];
            boolean flag;
            f.b(mLeader);
            abyte0 = new byte[mReadSize];
            flag = true;
_L5:
            Exception exception;
            boolean flag1;
            int i;
            try
            {
                i = mLeader.read(abyte0);
            }
            catch (IOException ioexception)
            {
                emp.a(mLeader);
                return;
            }
            finally
            {
                emp.a(mLeader);
            }
            if (i == -1) goto _L2; else goto _L1
_L1:
            if (Thread.currentThread().isInterrupted()) goto _L2; else goto _L3
_L3:
            flag1 = flag;
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            if (mListener != null)
            {
                mListener.onReadyForSpeech();
            }
            break MISSING_BLOCK_LABEL_119;
_L6:
            flag = flag1;
            if (mSpeechLevelGenerator == null) goto _L5; else goto _L4
_L4:
            mSpeechLevelGenerator.update(abyte0, 0, i);
            flag = flag1;
              goto _L5
_L2:
            emp.a(mLeader);
            return;
            throw exception;
            flag1 = false;
              goto _L6
        }

        public void setInputStream(InputStream inputstream)
        {
            mLeader = inputstream;
        }

        public CaptureThread(int i, SpeechLevelGenerator speechlevelgenerator, OnReadyForSpeechListener onreadyforspeechlistener)
        {
            super("MicrophoneReader");
            mReadSize = i;
            mSpeechLevelGenerator = speechlevelgenerator;
            mListener = onreadyforspeechlistener;
        }
    }

}
