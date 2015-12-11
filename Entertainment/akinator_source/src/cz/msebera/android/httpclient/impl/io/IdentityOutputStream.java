// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.OutputStream;

public class IdentityOutputStream extends OutputStream
{

    private boolean closed;
    private final SessionOutputBuffer out;

    public IdentityOutputStream(SessionOutputBuffer sessionoutputbuffer)
    {
        closed = false;
        out = (SessionOutputBuffer)Args.notNull(sessionoutputbuffer, "Session output buffer");
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
        } else
        {
            out.write(i);
            return;
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
        } else
        {
            out.write(abyte0, i, j);
            return;
        }
    }
}
