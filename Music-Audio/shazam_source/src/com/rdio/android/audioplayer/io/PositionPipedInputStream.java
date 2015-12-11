// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PositionPipedInputStream extends PipedInputStream
{

    private long mark;
    private long position;

    public PositionPipedInputStream()
    {
    }

    public PositionPipedInputStream(int i)
    {
        super(i);
    }

    public PositionPipedInputStream(PipedOutputStream pipedoutputstream)
    {
        super(pipedoutputstream);
    }

    public PositionPipedInputStream(PipedOutputStream pipedoutputstream, int i)
    {
        super(pipedoutputstream, i);
    }

    public long getPosition()
    {
        this;
        JVM INSTR monitorenter ;
        long l = position;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public void mark(int i)
    {
        this;
        JVM INSTR monitorenter ;
        super.mark(i);
        mark = position;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public int read()
    {
        this;
        JVM INSTR monitorenter ;
        int i = super.read();
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        position = position + 1L;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public int read(byte abyte0[], int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        i = super.read(abyte0, i, j);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        position = position + (long)i;
        this;
        JVM INSTR monitorexit ;
        return i;
        abyte0;
        throw abyte0;
    }

    public void reset()
    {
        this;
        JVM INSTR monitorenter ;
        if (!markSupported())
        {
            throw new IOException("Mark not supported, cannot reset as position would be undefined");
        }
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        super.reset();
        position = mark;
        this;
        JVM INSTR monitorexit ;
    }

    public void setPosition(long l)
    {
        position = l;
    }
}
