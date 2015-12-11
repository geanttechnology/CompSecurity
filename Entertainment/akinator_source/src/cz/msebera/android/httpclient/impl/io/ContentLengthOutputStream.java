// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.OutputStream;

public class ContentLengthOutputStream extends OutputStream
{

    private boolean closed;
    private final long contentLength;
    private final SessionOutputBuffer out;
    private long total;

    public ContentLengthOutputStream(SessionOutputBuffer sessionoutputbuffer, long l)
    {
        total = 0L;
        closed = false;
        out = (SessionOutputBuffer)Args.notNull(sessionoutputbuffer, "Session output buffer");
        contentLength = Args.notNegative(l, "Content length");
    }

    public void close()
        throws IOException
    {
        if (!closed)
        {
            closed = true;
            out.flush();
        }
    }

    public void flush()
        throws IOException
    {
        out.flush();
    }

    public void write(int i)
        throws IOException
    {
        if (closed)
        {
            throw new IOException("Attempted write to closed stream.");
        }
        if (total < contentLength)
        {
            out.write(i);
            total = total + 1L;
        }
    }

    public void write(byte abyte0[])
        throws IOException
    {
        write(abyte0, 0, abyte0.length);
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        if (closed)
        {
            throw new IOException("Attempted write to closed stream.");
        }
        if (total < contentLength)
        {
            long l = contentLength - total;
            int k = j;
            if ((long)j > l)
            {
                k = (int)l;
            }
            out.write(abyte0, i, k);
            total = total + (long)k;
        }
    }
}
