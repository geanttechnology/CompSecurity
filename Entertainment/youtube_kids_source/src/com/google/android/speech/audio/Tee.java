// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.audio;

import android.util.Log;
import emm;
import f;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Tee
{

    private static final boolean DBG = false;
    private static final int LEADER_ID = 0;
    private static final int READ_POSITION_CLOSED = 0x7fffffff;
    private static final String TAG = "Tee";
    private int mBasePos;
    private final byte mBuffer[];
    private int mBufferBegin;
    private int mBufferEnd;
    private final InputStream mDelegate;
    private boolean mEof;
    private IOException mException;
    private final int mKeepSize;
    private final InputStream mLeader = new TeeLeaderInputStream();
    private final int mReadPositions[];
    private final int mReadSize;
    private int mStartMark;

    public Tee(InputStream inputstream, int i, int j, int k, int l)
    {
        boolean flag;
        if (j < k)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.a(flag);
        mDelegate = inputstream;
        mBuffer = new byte[k * i];
        mKeepSize = j * i;
        mBufferBegin = 0;
        mBufferEnd = 0;
        mEof = false;
        mReadSize = i;
        mReadPositions = new int[l];
        Arrays.fill(mReadPositions, 0x7fffffff);
        mReadPositions[0] = 0;
    }

    private void doRead(int i, byte abyte0[], int j, int k)
    {
        byte abyte1[] = mBuffer;
        int l = abyte1.length;
        if (i + k <= l)
        {
            System.arraycopy(abyte1, i, abyte0, j, k);
            return;
        }
        if (i >= abyte1.length)
        {
            System.arraycopy(abyte1, i - l, abyte0, j, k);
            return;
        } else
        {
            l -= i;
            System.arraycopy(abyte1, i, abyte0, j, l);
            System.arraycopy(abyte1, 0, abyte0, l + j, k - l);
            return;
        }
    }

    private int findSlowestReaderLocked()
    {
        boolean flag = false;
        int j = 0x7fffffff;
        for (int i = 0; i < mReadPositions.length;)
        {
            int l = mReadPositions[i];
            int k = j;
            if (l < j)
            {
                k = l;
            }
            i++;
            j = k;
        }

        if (j <= mBufferEnd)
        {
            flag = true;
        }
        f.b(flag);
        return j;
    }

    private int readFromDelegate(int i)
    {
        int j = mBuffer.length;
        boolean flag;
        if (i >= j)
        {
            i -= j;
        }
        if (j - i >= mReadSize)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.a(flag);
        i = emm.a(mDelegate, mBuffer, i, mReadSize);
        return i;
        Object obj;
        obj;
        this;
        JVM INSTR monitorenter ;
        mException = ((IOException) (obj));
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
    }

    private void rewindBuffersLocked()
    {
        boolean flag = false;
        int i;
        int k;
        int l;
        boolean flag1;
        if (mReadPositions[0] >= mKeepSize)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        f.a(flag1);
        i = mReadPositions[0];
        k = mKeepSize;
        k = Math.min(findSlowestReaderLocked(), i - k);
        l = mBuffer.length;
        if ((mBufferEnd + mReadSize) - k <= l)
        {
            if (mStartMark < k)
            {
                mStartMark = 0x7fffffff;
            }
            int j = k;
            if (k >= l)
            {
                mBasePos = mBasePos + l;
                j = ((flag) ? 1 : 0);
                if (mStartMark != 0x7fffffff)
                {
                    mStartMark = mStartMark - l;
                    j = ((flag) ? 1 : 0);
                }
                for (; j != mReadPositions.length; j++)
                {
                    if (mReadPositions[j] != 0x7fffffff)
                    {
                        int ai[] = mReadPositions;
                        ai[j] = ai[j] - l;
                    }
                }

                j = k - l;
                mBufferEnd = mBufferEnd - l;
            }
            mBufferBegin = j;
            return;
        } else
        {
            mException = new IOException("Buffer overflow, no available space.");
            throw mException;
        }
    }

    void close()
    {
        try
        {
            mDelegate.close();
        }
        catch (IOException ioexception)
        {
            Log.e("Tee", (new StringBuilder("IOException closing audio track: ")).append(ioexception).toString());
        }
        this;
        JVM INSTR monitorenter ;
        mEof = true;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public InputStream getLeader()
    {
        return mLeader;
    }

    int readLeader(byte abyte0[], int i, int j)
    {
        int i1;
        int j1;
        int l1;
        l1 = mBuffer.length;
        i1 = 0;
        j1 = 0;
        int k = -1;
_L1:
        this;
        JVM INSTR monitorenter ;
        if (mException != null)
        {
            throw mException;
        }
        break MISSING_BLOCK_LABEL_35;
        abyte0;
        this;
        JVM INSTR monitorexit ;
        throw abyte0;
        int k1 = mReadPositions[0];
        if (k1 != 0x7fffffff)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        if (k == -1)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        return j1 - i1;
        this;
        JVM INSTR monitorexit ;
        return j1;
        int l = mBufferEnd;
        if (k == -1)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        l += k;
        mBufferEnd = l;
        notifyAll();
        if (k >= mReadSize)
        {
            break MISSING_BLOCK_LABEL_297;
        }
        mEof = true;
        this;
        JVM INSTR monitorexit ;
        return j1;
_L3:
        if (i1 == 0)
        {
            break MISSING_BLOCK_LABEL_287;
        }
        i1 += k1;
        mReadPositions[0] = i1;
_L2:
        if (j1 != j)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        this;
        JVM INSTR monitorexit ;
        return j;
        if (l != i1)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        if (!mEof)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        this;
        JVM INSTR monitorexit ;
        return j1;
        if ((mReadSize + l) - mBufferBegin <= l1)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        rewindBuffersLocked();
        l = mReadPositions[0];
        i1 = l;
        this;
        JVM INSTR monitorexit ;
        if (l == i1)
        {
            k1 = readFromDelegate(l);
            k = k1;
            l += k1;
        }
        l -= i1;
        k1 = j - j1;
        if (l >= k1)
        {
            l = k1;
        }
        doRead(i1, abyte0, i + j1, l);
        j1 += l;
        i1 = l;
          goto _L1
        i1 = k1;
          goto _L2
        k = -1;
          goto _L3
    }

    int readSecondary(int i, byte abyte0[], int j, int k)
    {
        int l = 0;
        int i1 = 0;
_L3:
        this;
        JVM INSTR monitorenter ;
_L1:
        if (mException != null)
        {
            throw mException;
        }
        break MISSING_BLOCK_LABEL_25;
        abyte0;
        this;
        JVM INSTR monitorexit ;
        throw abyte0;
        int j1 = mReadPositions[i];
        if (j1 != 0x7fffffff)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        this;
        JVM INSTR monitorexit ;
        return 0;
        if (l == 0)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        j1 += l;
        mReadPositions[i] = j1;
        l = 0;
        if (i1 != k)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        this;
        JVM INSTR monitorexit ;
        return k;
        int k1 = mBufferEnd;
        if (k1 != j1)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        if (!mEof)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        this;
        JVM INSTR monitorexit ;
        return i1;
        wait();
          goto _L1
        abyte0;
        Thread.currentThread().interrupt();
        throw new IOException((new StringBuilder("Interrupted waiting for buffers: ")).append(i).toString());
        this;
        JVM INSTR monitorexit ;
        l = k1 - j1;
        k1 = k - i1;
        if (l >= k1)
        {
            l = k1;
        }
        doRead(j1, abyte0, j + i1, l);
        i1 += l;
        if (true) goto _L3; else goto _L2
_L2:
    }

    void remove(int i)
    {
        this;
        JVM INSTR monitorenter ;
        mReadPositions[i] = 0x7fffffff;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setStartAtDelegatePos(long l)
    {
        this;
        JVM INSTR monitorenter ;
        if ((long)(mBasePos + mBufferBegin) <= l) goto _L2; else goto _L1
_L1:
        mStartMark = 0x7fffffff;
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if ((long)(mBasePos + mBufferEnd) >= l)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        mStartMark = 0x7fffffff;
          goto _L3
        Exception exception;
        exception;
        throw exception;
        mStartMark = (int)(l - (long)mBasePos);
          goto _L3
    }

    public InputStream split()
    {
        this;
        JVM INSTR monitorenter ;
        if (mStartMark == 0x7fffffff)
        {
            throw new IOException("No splits possible, buffers rewound.");
        }
        break MISSING_BLOCK_LABEL_26;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        int i = 1;
        while (i != mReadPositions.length && mReadPositions[i] != 0x7fffffff) 
        {
            i++;
        }
        TeeSecondaryInputStream teesecondaryinputstream;
        if (i == mReadPositions.length)
        {
            throw new IOException("No splits possible, too many siblings.");
        }
        teesecondaryinputstream = new TeeSecondaryInputStream(i);
        mReadPositions[i] = mStartMark;
        this;
        JVM INSTR monitorexit ;
        return teesecondaryinputstream;
    }

    private class TeeLeaderInputStream extends InputStream
    {

        private final Tee mSharedStream;

        public void close()
        {
            mSharedStream.remove(0);
            mSharedStream.close();
        }

        public int read()
        {
            throw new UnsupportedOperationException("Find some other app to be inefficient in.");
        }

        public int read(byte abyte0[], int i, int j)
        {
            j = mSharedStream.readLeader(abyte0, i, j);
            i = j;
            if (j == 0)
            {
                i = -1;
            }
            return i;
        }

        TeeLeaderInputStream()
        {
            mSharedStream = Tee.this;
        }
    }


    private class TeeSecondaryInputStream extends InputStream
    {

        private Tee mSharedStream;
        private final int mStreamId;

        public void close()
        {
            this;
            JVM INSTR monitorenter ;
            if (mSharedStream != null)
            {
                mSharedStream.remove(mStreamId);
                mSharedStream = null;
            }
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public int read()
        {
            throw new UnsupportedOperationException("Find some other app to be inefficient in.");
        }

        public int read(byte abyte0[], int i, int j)
        {
            this;
            JVM INSTR monitorenter ;
            if (mSharedStream == null)
            {
                throw new IOException("Secondary Tee stream closed.");
            }
            break MISSING_BLOCK_LABEL_24;
            abyte0;
            this;
            JVM INSTR monitorexit ;
            throw abyte0;
            i = mSharedStream.readSecondary(mStreamId, abyte0, i, j);
            j = i;
            if (i == 0)
            {
                j = -1;
            }
            this;
            JVM INSTR monitorexit ;
            return j;
        }

        TeeSecondaryInputStream(int i)
        {
            mSharedStream = Tee.this;
            mStreamId = i;
        }
    }

}
