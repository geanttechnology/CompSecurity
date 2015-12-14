// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.codec;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package org.apache.james.mime4j.codec:
//            QuotedPrintableEncoder

public class QuotedPrintableOutputStream extends FilterOutputStream
{

    private boolean closed;
    private QuotedPrintableEncoder encoder;

    public QuotedPrintableOutputStream(OutputStream outputstream, boolean flag)
    {
        super(outputstream);
        closed = false;
        encoder = new QuotedPrintableEncoder(1024, flag);
        encoder.initEncoding(outputstream);
    }

    public void close()
        throws IOException
    {
        if (closed)
        {
            return;
        }
        encoder.completeEncoding();
        closed = true;
        return;
        Exception exception;
        exception;
        closed = true;
        throw exception;
    }

    public void flush()
        throws IOException
    {
        encoder.flushOutput();
    }

    public void write(int i)
        throws IOException
    {
        write(new byte[] {
            (byte)i
        }, 0, 1);
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        if (closed)
        {
            throw new IOException("QuotedPrintableOutputStream has been closed");
        } else
        {
            encoder.encodeChunk(abyte0, i, j);
            return;
        }
    }
}
