// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package org.apache.commons.httpclient:
//            ChunkedInputStream

public class ContentLengthInputStream extends InputStream
{

    private boolean closed;
    private long contentLength;
    private long pos;
    private InputStream wrappedStream;

    public ContentLengthInputStream(InputStream inputstream, int i)
    {
        this(inputstream, i);
    }

    public ContentLengthInputStream(InputStream inputstream, long l)
    {
        pos = 0L;
        closed = false;
        wrappedStream = null;
        wrappedStream = inputstream;
        contentLength = l;
    }

    public int available()
        throws IOException
    {
        int i;
        if (closed)
        {
            i = 0;
        } else
        {
            int j = wrappedStream.available();
            i = j;
            if (pos + (long)j > contentLength)
            {
                return (int)(contentLength - pos);
            }
        }
        return i;
    }

    public void close()
        throws IOException
    {
        if (closed)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        ChunkedInputStream.exhaustInputStream(this);
        closed = true;
        return;
        Exception exception;
        exception;
        closed = true;
        throw exception;
    }

    public int read()
        throws IOException
    {
        if (closed)
        {
            throw new IOException("Attempted read from closed stream.");
        }
        if (pos >= contentLength)
        {
            return -1;
        } else
        {
            pos = pos + 1L;
            return wrappedStream.read();
        }
    }

    public int read(byte abyte0[])
        throws IOException
    {
        return read(abyte0, 0, abyte0.length);
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        if (closed)
        {
            throw new IOException("Attempted read from closed stream.");
        }
        if (pos >= contentLength)
        {
            return -1;
        }
        int k = j;
        if (pos + (long)j > contentLength)
        {
            k = (int)(contentLength - pos);
        }
        i = wrappedStream.read(abyte0, i, k);
        pos = pos + (long)i;
        return i;
    }

    public long skip(long l)
        throws IOException
    {
        l = Math.min(l, contentLength - pos);
        l = wrappedStream.skip(l);
        if (l > 0L)
        {
            pos = pos + l;
        }
        return l;
    }
}
