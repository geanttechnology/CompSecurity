// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.audio;

import f;
import java.io.InputStream;
import java.util.Arrays;

// Referenced classes of package com.google.android.speech.audio:
//            AudioStore, MicrophoneInputStreamFactory

public class AudioRecorder
{

    private static final int BYTES_PER_SAMPLE = 2;
    private static final boolean DBG = false;
    private static final int MAX_FLATTENED_BUFFER_MS = 60000;
    private static final int MIN_FLATTENED_BUFFER_MS = 10000;
    private static final String TAG = "AudioRecorder";
    private AudioStore mAudioStore;
    private int mBytesPerMsec;
    private int mEndPos;
    private int mMaxFlattenedBufferSize;
    private RecordingThread mRecordingThread;
    private String mRequestId;
    private int mSampleRate;
    private int mStartPos;

    public AudioRecorder()
    {
    }

    private void doStopRecording(boolean flag)
    {
        if (mRecordingThread == null)
        {
            return;
        }
        if (flag)
        {
            mRecordingThread.requestStop();
        }
        Object obj;
        try
        {
            mRecordingThread.join();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            mAudioStore = null;
            mRequestId = null;
            return;
        }
        if (mRecordingThread.isGood())
        {
            obj = mRecordingThread.getBuffer();
            mEndPos = Math.min(mRecordingThread.getTotalLength(), mEndPos);
        } else
        if (mRecordingThread.isOverflown() && mEndPos <= mMaxFlattenedBufferSize)
        {
            obj = mRecordingThread.getBuffer();
        } else
        {
            obj = null;
        }
        if (mStartPos >= mEndPos)
        {
            obj = null;
        }
        obj = getLastValidAudioRange(((byte []) (obj)));
        if (obj != null)
        {
            obj = new AudioStore.AudioRecording(mSampleRate, ((byte []) (obj)));
        } else
        {
            obj = null;
        }
        mAudioStore.put(mRequestId, ((AudioStore.AudioRecording) (obj)));
        mAudioStore = null;
        mRequestId = null;
        mRecordingThread = null;
    }

    private byte[] getLastValidAudioRange(byte abyte0[])
    {
        if (abyte0 == null || mStartPos == 0 && mEndPos == abyte0.length)
        {
            return abyte0;
        } else
        {
            return Arrays.copyOfRange(abyte0, (mStartPos / 2) * 2, mEndPos);
        }
    }

    protected RecordingThread createRecordingThread(int i, int j, InputStream inputstream, int k)
    {
        return new ClampedLengthRecordingThread(i, j, inputstream, k);
    }

    public boolean isRecording()
    {
        return mRecordingThread != null;
    }

    public void setRecordingEndTime(long l)
    {
        boolean flag1 = true;
        boolean flag;
        if (mRecordingThread != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.b(flag);
        if (l >= 0L)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        f.a(flag);
        mEndPos = (int)(((long)mBytesPerMsec * l) / 1000L);
    }

    public void setRecordingStartTime(long l)
    {
        boolean flag1 = true;
        boolean flag;
        if (mRecordingThread != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.b(flag);
        if (l >= 0L)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        f.a(flag);
        mStartPos = (int)(((long)mBytesPerMsec * l) / 1000L);
    }

    public void startRecording(InputStream inputstream, int i, int j, AudioStore audiostore, String s)
    {
        boolean flag;
        if (mRecordingThread == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.b(flag);
        mAudioStore = audiostore;
        mSampleRate = i;
        mBytesPerMsec = MicrophoneInputStreamFactory.getBytesPerMsec(i);
        mRequestId = s;
        mStartPos = 0;
        mEndPos = 0x7fffffff;
        i = mBytesPerMsec;
        mMaxFlattenedBufferSize = 60000 * mBytesPerMsec;
        mRecordingThread = createRecordingThread(i * 10000, mMaxFlattenedBufferSize, inputstream, j);
        mRecordingThread.start();
    }

    public void stopRecording()
    {
        doStopRecording(true);
    }

    public void waitForRecording()
    {
        doStopRecording(false);
    }

    private class RecordingThread
    {

        public abstract byte[] getBuffer();

        public abstract int getTotalLength();

        public abstract boolean isGood();

        public abstract boolean isOverflown();

        public abstract void join();

        public abstract void requestStop();

        public abstract void start();
    }


    private class ClampedLengthRecordingThread extends Thread
        implements RecordingThread
    {

        private static final int ERROR = -1;
        private static final int OVERFLOW = -2;
        private static final int RUNNING = 1;
        private static final int STOPPED = 3;
        private static final int STOPPING = 2;
        private byte mBuf[];
        private final InputStream mInput;
        private final int mMaxSize;
        private final int mReadSize;
        private int mState;
        private int mTotalLength;

        public byte[] getBuffer()
        {
            return mBuf;
        }

        public int getTotalLength()
        {
            return mTotalLength;
        }

        public boolean isGood()
        {
            return mState == 3;
        }

        public boolean isOverflown()
        {
            return mState == -2;
        }

        public void requestStop()
        {
            this;
            JVM INSTR monitorenter ;
            if (mState == 1)
            {
                mState = 2;
                interrupt();
            }
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void run()
        {
            int j = 0;
            int i = 0;
_L3:
            this;
            JVM INSTR monitorenter ;
            if (j == -1)
            {
                break MISSING_BLOCK_LABEL_19;
            }
            if (mState != 2)
            {
                break MISSING_BLOCK_LABEL_39;
            }
            mTotalLength = i;
            mState = 3;
            this;
            JVM INSTR monitorexit ;
            emp.a(mInput);
            return;
            if (i + j <= mMaxSize)
            {
                break MISSING_BLOCK_LABEL_73;
            }
            mTotalLength = mMaxSize;
            mState = -2;
            this;
            JVM INSTR monitorexit ;
            emp.a(mInput);
            return;
            this;
            JVM INSTR monitorexit ;
            i = j + i;
            if (i >= mMaxSize) goto _L2; else goto _L1
_L1:
            j = Math.min(mReadSize + i, mMaxSize);
            if (j > mBuf.length)
            {
                byte abyte0[] = new byte[Math.min(j << 1, mMaxSize)];
                System.arraycopy(mBuf, 0, abyte0, 0, i);
                mBuf = abyte0;
            }
            j = mInput.read(mBuf, i, j - i);
              goto _L3
            Object obj;
            obj;
            this;
            JVM INSTR monitorexit ;
            try
            {
                throw obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
            finally
            {
                emp.a(mInput);
            }
_L4:
            this;
            JVM INSTR monitorenter ;
            mTotalLength = i;
            if (mState == 2)
            {
                i = 3;
            } else
            {
                i = -1;
            }
            mState = i;
            this;
            JVM INSTR monitorexit ;
            emp.a(mInput);
            return;
_L2:
            j = mInput.read(new byte[1]);
              goto _L3
            obj;
            this;
            JVM INSTR monitorexit ;
            throw obj;
            obj;
              goto _L4
        }

        ClampedLengthRecordingThread(int i, int j, InputStream inputstream, int k)
        {
            mMaxSize = j;
            mReadSize = k;
            mInput = inputstream;
            mBuf = new byte[i];
            mState = 1;
        }
    }

}
