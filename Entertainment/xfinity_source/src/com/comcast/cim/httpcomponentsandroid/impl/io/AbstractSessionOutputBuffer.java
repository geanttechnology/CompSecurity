// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.io;

import com.comcast.cim.httpcomponentsandroid.io.BufferInfo;
import com.comcast.cim.httpcomponentsandroid.io.HttpTransportMetrics;
import com.comcast.cim.httpcomponentsandroid.io.SessionOutputBuffer;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import com.comcast.cim.httpcomponentsandroid.params.HttpProtocolParams;
import com.comcast.cim.httpcomponentsandroid.util.ByteArrayBuffer;
import com.comcast.cim.httpcomponentsandroid.util.CharArrayBuffer;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.io:
//            HttpTransportMetricsImpl

public abstract class AbstractSessionOutputBuffer
    implements BufferInfo, SessionOutputBuffer
{

    private static final byte CRLF[] = {
        13, 10
    };
    private boolean ascii;
    private ByteArrayBuffer buffer;
    private String charset;
    private HttpTransportMetricsImpl metrics;
    private int minChunkLimit;
    private OutputStream outstream;

    public AbstractSessionOutputBuffer()
    {
        charset = "US-ASCII";
        ascii = true;
        minChunkLimit = 512;
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
        if (outputstream == null)
        {
            throw new IllegalArgumentException("Input stream may not be null");
        }
        if (i <= 0)
        {
            throw new IllegalArgumentException("Buffer size may not be negative or zero");
        }
        if (httpparams == null)
        {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        outstream = outputstream;
        buffer = new ByteArrayBuffer(i);
        charset = HttpProtocolParams.getHttpElementCharset(httpparams);
        boolean flag;
        if (charset.equalsIgnoreCase("US-ASCII") || charset.equalsIgnoreCase("ASCII"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ascii = flag;
        minChunkLimit = httpparams.getIntParameter("http.connection.min-chunk-limit", 512);
        metrics = createTransportMetrics();
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
            write(chararraybuffer.toString().getBytes(charset));
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
            write(s.getBytes(charset));
        }
        write(CRLF);
    }

}
