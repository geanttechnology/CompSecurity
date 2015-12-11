// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.audio;

import emp;
import java.io.IOException;
import java.io.InputStream;

class mState extends Thread
    implements mState
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

    (int i, int j, InputStream inputstream, int k)
    {
        mMaxSize = j;
        mReadSize = k;
        mInput = inputstream;
        mBuf = new byte[i];
        mState = 1;
    }
}
