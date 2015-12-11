// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.io.BufferInfo;
import cz.msebera.android.httpclient.io.HttpTransportMetrics;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.ByteArrayBuffer;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

// Referenced classes of package cz.msebera.android.httpclient.impl.io:
//            HttpTransportMetricsImpl

public abstract class AbstractSessionOutputBuffer
    implements SessionOutputBuffer, BufferInfo
{

    private static final byte CRLF[] = {
        13, 10
    };
    private boolean ascii;
    private ByteBuffer bbuf;
    private ByteArrayBuffer buffer;
    private Charset charset;
    private CharsetEncoder encoder;
    private HttpTransportMetricsImpl metrics;
    private int minChunkLimit;
    private CodingErrorAction onMalformedCharAction;
    private CodingErrorAction onUnmappableCharAction;
    private OutputStream outstream;

    public AbstractSessionOutputBuffer()
    {
    }

    protected AbstractSessionOutputBuffer(OutputStream outputstream, int i, Charset charset1, int j, CodingErrorAction codingerroraction, CodingErrorAction codingerroraction1)
    {
        Args.notNull(outputstream, "Input stream");
        Args.notNegative(i, "Buffer size");
        outstream = outputstream;
        buffer = new ByteArrayBuffer(i);
        if (charset1 == null)
        {
            charset1 = Consts.ASCII;
        }
        charset = charset1;
        ascii = charset.equals(Consts.ASCII);
        encoder = null;
        if (j < 0)
        {
            j = 512;
        }
        minChunkLimit = j;
        metrics = createTransportMetrics();
        if (codingerroraction == null)
        {
            codingerroraction = CodingErrorAction.REPORT;
        }
        onMalformedCharAction = codingerroraction;
        if (codingerroraction1 == null)
        {
            codingerroraction1 = CodingErrorAction.REPORT;
        }
        onUnmappableCharAction = codingerroraction1;
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

    private void writeEncoded(CharBuffer charbuffer)
        throws IOException
    {
        if (!charbuffer.hasRemaining())
        {
            return;
        }
        if (encoder == null)
        {
            encoder = charset.newEncoder();
            encoder.onMalformedInput(onMalformedCharAction);
            encoder.onUnmappableCharacter(onUnmappableCharAction);
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

    public int capacity()
    {
        return buffer.capacity();
    }

    protected HttpTransportMetricsImpl createTransportMetrics()
    {
        return new HttpTransportMetricsImpl();
    }

    public void flush()
        throws IOException
    {
        flushBuffer();
        outstream.flush();
    }

    protected void flushBuffer()
        throws IOException
    {
        int i = buffer.length();
        if (i > 0)
        {
            outstream.write(buffer.buffer(), 0, i);
            buffer.clear();
            metrics.incrementBytesTransferred(i);
        }
    }

    public HttpTransportMetrics getMetrics()
    {
        return metrics;
    }

    protected void init(OutputStream outputstream, int i, HttpParams httpparams)
    {
        Args.notNull(outputstream, "Input stream");
        Args.notNegative(i, "Buffer size");
        Args.notNull(httpparams, "HTTP parameters");
        outstream = outputstream;
        buffer = new ByteArrayBuffer(i);
        outputstream = (String)httpparams.getParameter("http.protocol.element-charset");
        if (outputstream != null)
        {
            outputstream = Charset.forName(outputstream);
        } else
        {
            outputstream = Consts.ASCII;
        }
        charset = outputstream;
        ascii = charset.equals(Consts.ASCII);
        encoder = null;
        minChunkLimit = httpparams.getIntParameter("http.connection.min-chunk-limit", 512);
        metrics = createTransportMetrics();
        outputstream = (CodingErrorAction)httpparams.getParameter("http.malformed.input.action");
        if (outputstream == null)
        {
            outputstream = CodingErrorAction.REPORT;
        }
        onMalformedCharAction = outputstream;
        outputstream = (CodingErrorAction)httpparams.getParameter("http.unmappable.input.action");
        if (outputstream == null)
        {
            outputstream = CodingErrorAction.REPORT;
        }
        onUnmappableCharAction = outputstream;
    }

    public int length()
    {
        return buffer.length();
    }

    public void write(int i)
        throws IOException
    {
        if (buffer.isFull())
        {
            flushBuffer();
        }
        buffer.append(i);
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
        if (j > minChunkLimit || j > buffer.capacity())
        {
            flushBuffer();
            outstream.write(abyte0, i, j);
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
        if (ascii)
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
            if (ascii)
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
