// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PositionInputStream extends FilterInputStream
{

    private long markedPosition;
    protected long position;

    public PositionInputStream(InputStream inputstream)
    {
        super(inputstream);
        position = 0L;
        markedPosition = 0L;
    }

    public int available()
        throws IOException
    {
        return in.available();
    }

    public void close()
        throws IOException
    {
        in.close();
    }

    public long getPosition()
    {
        return position;
    }

    public void mark(int i)
    {
        in.mark(i);
        markedPosition = position;
    }

    public boolean markSupported()
    {
        return in.markSupported();
    }

    public int read()
        throws IOException
    {
        int i = in.read();
        if (i != -1)
        {
            position = position + 1L;
        }
        return i;
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        i = in.read(abyte0, i, j);
        if (i > 0)
        {
            position = position + (long)i;
        }
        return i;
    }

    public void reset()
        throws IOException
    {
        in.reset();
        position = markedPosition;
    }

    public long skip(long l)
        throws IOException
    {
        l = in.skip(l);
        if (l > 0L)
        {
            position = position + l;
        }
        return l;
    }
}
