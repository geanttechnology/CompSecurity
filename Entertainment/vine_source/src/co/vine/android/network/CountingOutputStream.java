// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.network;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package co.vine.android.network:
//            ProgressListener

class CountingOutputStream extends FilterOutputStream
{

    private final long mChunk;
    private final long mLength;
    private final ProgressListener mListener;
    private long mNext;
    private long mTransferred;

    public CountingOutputStream(OutputStream outputstream, long l, ProgressListener progresslistener)
    {
        super(outputstream);
        mListener = progresslistener;
        mLength = 2L * l;
        mTransferred = 0L;
        mChunk = mLength / 5L;
        mNext = mChunk;
    }

    public void write(int i)
        throws IOException
    {
        super.write(i);
        mTransferred = mTransferred + 1L;
        if (mTransferred >= mNext)
        {
            super.flush();
            if (mListener != null)
            {
                mListener.onProgress(mTransferred, mLength);
            }
            mNext = mNext + mChunk;
        }
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        super.write(abyte0, i, j);
        mTransferred = mTransferred + (long)j;
        if (mTransferred >= mNext)
        {
            super.flush();
            if (mListener != null)
            {
                mListener.onProgress(mTransferred, mLength);
            }
            mNext = mNext + mChunk;
        }
    }
}
