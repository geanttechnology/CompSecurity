// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.internal;

import com.amazon.clouddrive.handlers.ProgressListener;
import java.io.IOException;
import java.io.InputStream;

class ProgressInputStream extends InputStream
{

    private final InputStream mInputStream;
    private long mMaxProgress;
    private long mProgress;
    private final ProgressListener mProgressListener;

    ProgressInputStream(InputStream inputstream, long l, ProgressListener progresslistener)
    {
        mInputStream = inputstream;
        mMaxProgress = l;
        mProgressListener = progresslistener;
    }

    private int updateProgress(int i)
    {
        updateProgress(i);
        return i;
    }

    private long updateProgress(long l)
    {
        if (mProgressListener != null && l > 0L)
        {
            mProgress = mProgress + l;
            mProgressListener.onProgress(mProgress, mMaxProgress);
        }
        return l;
    }

    public int available()
        throws IOException
    {
        return mInputStream.available();
    }

    public void close()
        throws IOException
    {
        mInputStream.close();
    }

    public void mark(int i)
    {
        this;
        JVM INSTR monitorenter ;
        mInputStream.mark(i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean markSupported()
    {
        return mInputStream.markSupported();
    }

    public int read()
        throws IOException
    {
        return updateProgress(mInputStream.read());
    }

    public int read(byte abyte0[])
        throws IOException
    {
        return updateProgress(mInputStream.read(abyte0));
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        return updateProgress(mInputStream.read(abyte0, i, j));
    }

    public void reset()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        mInputStream.reset();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public long skip(long l)
        throws IOException
    {
        return updateProgress(mInputStream.skip(l));
    }
}
