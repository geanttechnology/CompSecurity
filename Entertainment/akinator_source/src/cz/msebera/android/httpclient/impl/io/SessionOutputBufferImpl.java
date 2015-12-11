// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.io.BufferInfo;
import cz.msebera.android.httpclient.io.HttpTransportMetrics;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import cz.msebera.android.httpclient.util.ByteArrayBuffer;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;

// Referenced classes of package cz.msebera.android.httpclient.impl.io:
//            HttpTransportMetricsImpl

public class SessionOutputBufferImpl
    implements SessionOutputBuffer, BufferInfo
{

    private static final byte CRLF[] = {
        13, 10
    };
    private ByteBuffer bbuf;
    private final ByteArrayBuffer buffer;
    private final CharsetEncoder encoder;
    private final int fragementSizeHint;
    private final HttpTransportMetricsImpl metrics;
    private OutputStream outstream;

    public SessionOutputBufferImpl(HttpTransportMetricsImpl httptransportmetricsimpl, int i)
    {
        this(httptransportmetricsimpl, i, i, null);
    }

    public SessionOutputBufferImpl(HttpTransportMetricsImpl httptransportmetricsimpl, int i, int j, CharsetEncoder charsetencoder)
    {
        Args.positive(i, "Buffer size");
        Args.notNull(httptransportmetricsimpl, "HTTP transport metrcis");
        metrics = httptransportmetricsimpl;
        buffer = new ByteArrayBuffer(i);
        if (j < 0)
        {
            j = 0;
        }
        fragementSizeHint = j;
        encoder = charsetencoder;
    }

    private void flushBuffer()
        throws IOException
    {
        int i = buffer.length();
        if (i > 0)
        {
            streamWrite(buffer.buffer(), 0, i);
            buffer.clear();
            metrics.incrementBytesTransferred(i);
        }
    }

    private void flushStream()
        throws IOException
    {
        if (outstream != null)
        {
            outstream.flush();
        }
    }

    private void handleEncodingResult(CoderResult coderresult)
        throws IOException
    {
        if (coderresult.isError())
        {
            coderresult.throwException();
        }
        bbuf.flip();
        for (; bbuf.hasRemaining(); write(bbuf.get())) { }
        bbuf.compact();
    }

    private void streamWrite(byte abyte0[], int i, int j)
        throws IOException
    {
        Asserts.notNull(outstream, "Output stream");
        outstream.write(abyte0, i, j);
    }

    private void writeEncoded(CharBuffer charbuffer)
        throws IOException
    {
        if (!charbuffer.hasRemaining())
        {
            return;
        }
        if (bbuf == null)
        {
            bbuf = ByteBuffer.allocate(1024);
        }
        encoder.reset();
        for (; charbuffer.hasRemaining(); handleEncodingResult(encoder.encode(charbuffer, bbuf, true))) { }
        handleEncodingResult(encoder.flush(bbuf));
        bbuf.clear();
    }

    public int available()
    {
        return capacity() - length();
    }

    public void bind(OutputStream outputstream)
    {
        outstream = outputstream;
    }

    public int capacity()
    {
        return buffer.capacity();
    }

    public void flush()
        throws IOException
    {
        flushBuffer();
        flushStream();
    }

    public HttpTransportMetrics getMetrics()
    {
        return metrics;
    }

    public boolean isBound()
    {
        return outstream != null;
    }

    public int length()
    {
        return buffer.length();
    }

    public void write(int i)
        throws IOException
    {
        if (fragementSizeHint > 0)
        {
            if (buffer.isFull())
            {
                flushBuffer();
            }
            buffer.append(i);
            return;
        } else
        {
            flushBuffer();
            outstream.write(i);
            return;
        }
    }

    public void write(byte abyte0[])
        throws IOException
    {
        if (abyte0 == null)
        {
            return;
        } else
        {
            write(abyte0, 0, abyte0.length);
            return;
        }
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        if (abyte0 == null)
        {
            return;
        }
        if (j > fragementSizeHint || j > buffer.capacity())
        {
            flushBuffer();
            streamWrite(abyte0, i, j);
            metrics.incrementBytesTransferred(j);
            return;
        }
        if (j > buffer.capacity() - buffer.length())
        {
            flushBuffer();
        }
        buffer.append(abyte0, i, j);
    }

    public void writeLine(CharArrayBuffer chararraybuffer)
        throws IOException
    {
        if (chararraybuffer == null)
        {
            return;
        }
        if (encoder == null)
        {
            int j = 0;
            int k;
            for (int i = chararraybuffer.length(); i > 0; i -= k)
            {
                k = Math.min(buffer.capacity() - buffer.length(), i);
                if (k > 0)
                {
                    buffer.append(chararraybuffer, j, k);
                }
                if (buffer.isFull())
                {
                    flushBuffer();
                }
                j += k;
            }

        } else
        {
            writeEncoded(CharBuffer.wrap(chararraybuffer.buffer(), 0, chararraybuffer.length()));
        }
        write(CRLF);
    }

    public void writeLine(String s)
        throws IOException
    {
        if (s == null)
        {
            return;
        }
        if (s.length() > 0)
        {
            if (encoder == null)
            {
                for (int i = 0; i < s.length(); i++)
                {
                    write(s.charAt(i));
                }

            } else
            {
                writeEncoded(CharBuffer.wrap(s));
            }
        }
        write(CRLF);
    }

}
