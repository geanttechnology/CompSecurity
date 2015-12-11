// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import java.io.IOException;
import java.io.InputStream;

public class MeasureInputStream extends InputStream
{

    private final InputStream mInputStream;
    private long mReadTimeMs;
    private long mReadTimeNs;

    public MeasureInputStream(InputStream inputstream)
    {
        mInputStream = inputstream;
        mReadTimeMs = 0L;
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

    public long getReadTime()
    {
        return mReadTimeMs + mReadTimeNs / 0xf4240L;
    }

    public void mark(int i)
    {
        mInputStream.mark(i);
    }

    public boolean markSupported()
    {
        return mInputStream.markSupported();
    }

    public int read()
        throws IOException
    {
        long l = System.nanoTime();
        int i = mInputStream.read();
        mReadTimeNs = mReadTimeNs + (System.nanoTime() - l);
        return i;
    }

    public int read(byte abyte0[])
        throws IOException
    {
        long l = System.currentTimeMillis();
        int i = mInputStream.read(abyte0);
        mReadTimeMs = mReadTimeMs + (System.currentTimeMillis() - l);
        return i;
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        long l = System.currentTimeMillis();
        i = mInputStream.read(abyte0, i, j);
        mReadTimeMs = mReadTimeMs + (System.currentTimeMillis() - l);
        return i;
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
        long l1 = System.currentTimeMillis();
        l = super.skip(l);
        mReadTimeMs = mReadTimeMs + (System.currentTimeMillis() - l1);
        return l;
    }
}
