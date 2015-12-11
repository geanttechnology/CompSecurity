// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.io;

import com.comcast.cim.httpcomponentsandroid.io.BufferInfo;
import com.comcast.cim.httpcomponentsandroid.io.HttpTransportMetrics;
import com.comcast.cim.httpcomponentsandroid.io.SessionInputBuffer;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import com.comcast.cim.httpcomponentsandroid.params.HttpProtocolParams;
import com.comcast.cim.httpcomponentsandroid.util.ByteArrayBuffer;
import com.comcast.cim.httpcomponentsandroid.util.CharArrayBuffer;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.io:
//            HttpTransportMetricsImpl

public abstract class AbstractSessionInputBuffer
    implements BufferInfo, SessionInputBuffer
{

    private boolean ascii;
    private byte buffer[];
    private int bufferlen;
    private int bufferpos;
    private String charset;
    private InputStream instream;
    private ByteArrayBuffer linebuffer;
    private int maxLineLen;
    private HttpTransportMetricsImpl metrics;
    private int minChunkLimit;

    public AbstractSessionInputBuffer()
    {
        linebuffer = null;
        charset = "US-ASCII";
        ascii = true;
        maxLineLen = -1;
        minChunkLimit = 512;
    }

    private int lineFromLineBuffer(CharArrayBuffer chararraybuffer)
        throws IOException
    {
        int k = linebuffer.length();
        if (k > 0)
        {
            int i = k;
            if (linebuffer.byteAt(k - 1) == 10)
            {
                i = k - 1;
                linebuffer.setLength(i);
            }
            if (i > 0 && linebuffer.byteAt(i - 1) == 13)
            {
                linebuffer.setLength(i - 1);
            }
        }
        int j = linebuffer.length();
        if (ascii)
        {
            chararraybuffer.append(linebuffer, 0, j);
        } else
        {
            String s = new String(linebuffer.buffer(), 0, j, charset);
            j = s.length();
            chararraybuffer.append(s);
        }
        linebuffer.clear();
        return j;
    }

    private int lineFromReadBuffer(CharArrayBuffer chararraybuffer, int i)
        throws IOException
    {
        int k = bufferpos;
        bufferpos = i + 1;
        int j = i;
        if (i > 0)
        {
            j = i;
            if (buffer[i - 1] == 13)
            {
                j = i - 1;
            }
        }
        i = j - k;
        if (ascii)
        {
            chararraybuffer.append(buffer, k, i);
            return i;
        } else
        {
            String s = new String(buffer, k, i, charset);
            chararraybuffer.append(s);
            return s.length();
        }
    }

    private int locateLF()
    {
        for (int i = bufferpos; i < bufferlen; i++)
        {
            if (buffer[i] == 10)
            {
                return i;
            }
        }

        return -1;
    }

    protected HttpTransportMetricsImpl createTransportMetrics()
    {
        return new HttpTransportMetricsImpl();
    }

    protected int fillBuffer()
        throws IOException
    {
        if (bufferpos > 0)
        {
            int i = bufferlen - bufferpos;
            if (i > 0)
            {
                System.arraycopy(buffer, bufferpos, buffer, 0, i);
            }
            bufferpos = 0;
            bufferlen = i;
        }
        int j = bufferlen;
        int k = buffer.length;
        k = instream.read(buffer, j, k - j);
        if (k == -1)
        {
            return -1;
        } else
        {
            bufferlen = j + k;
            metrics.incrementBytesTransferred(k);
            return k;
        }
    }

    public HttpTransportMetrics getMetrics()
    {
        return metrics;
    }

    protected boolean hasBufferedData()
    {
        return bufferpos < bufferlen;
    }

    protected void init(InputStream inputstream, int i, HttpParams httpparams)
    {
        boolean flag = false;
        if (inputstream == null)
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
        instream = inputstream;
        buffer = new byte[i];
        bufferpos = 0;
        bufferlen = 0;
        linebuffer = new ByteArrayBuffer(i);
        charset = HttpProtocolParams.getHttpElementCharset(httpparams);
        if (charset.equalsIgnoreCase("US-ASCII") || charset.equalsIgnoreCase("ASCII"))
        {
            flag = true;
        }
        ascii = flag;
        maxLineLen = httpparams.getIntParameter("http.connection.max-line-length", -1);
        minChunkLimit = httpparams.getIntParameter("http.connection.min-chunk-limit", 512);
        metrics = createTransportMetrics();
    }

    public int length()
    {
        return bufferlen - bufferpos;
    }

    public int read()
        throws IOException
    {
        while (!hasBufferedData()) 
        {
            if (fillBuffer() == -1)
            {
                return -1;
            }
        }
        byte abyte0[] = buffer;
        int i = bufferpos;
        bufferpos = i + 1;
        return abyte0[i] & 0xff;
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        if (abyte0 == null)
        {
            return 0;
        }
        if (hasBufferedData())
        {
            j = Math.min(j, bufferlen - bufferpos);
            System.arraycopy(buffer, bufferpos, abyte0, i, j);
            bufferpos = bufferpos + j;
            return j;
        }
        if (j > minChunkLimit)
        {
            i = instream.read(abyte0, i, j);
            if (i > 0)
            {
                metrics.incrementBytesTransferred(i);
            }
            return i;
        }
        while (!hasBufferedData()) 
        {
            if (fillBuffer() == -1)
            {
                return -1;
            }
        }
        j = Math.min(j, bufferlen - bufferpos);
        System.arraycopy(buffer, bufferpos, abyte0, i, j);
        bufferpos = bufferpos + j;
        return j;
    }

    public int readLine(CharArrayBuffer chararraybuffer)
        throws IOException
    {
        int j;
        int k;
        byte byte0;
        byte0 = -1;
        if (chararraybuffer == null)
        {
            throw new IllegalArgumentException("Char array buffer may not be null");
        }
        k = 0;
        j = 1;
_L11:
        if (j == 0) goto _L2; else goto _L1
_L1:
        int l = locateLF();
        if (l == -1) goto _L4; else goto _L3
_L3:
        if (!linebuffer.isEmpty()) goto _L6; else goto _L5
_L5:
        int i = lineFromReadBuffer(chararraybuffer, l);
_L9:
        return i;
_L6:
        i = 0;
        j = bufferpos;
        linebuffer.append(buffer, bufferpos, (l + 1) - j);
        bufferpos = l + 1;
        l = k;
_L7:
        k = l;
        j = i;
        if (maxLineLen > 0)
        {
            k = l;
            j = i;
            if (linebuffer.length() >= maxLineLen)
            {
                throw new IOException("Maximum line length limit exceeded");
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (hasBufferedData())
        {
            i = bufferlen;
            k = bufferpos;
            linebuffer.append(buffer, bufferpos, i - k);
            bufferpos = bufferlen;
        }
        k = fillBuffer();
        l = k;
        i = j;
        if (k == -1)
        {
            i = 0;
            l = k;
        }
        if (true) goto _L7; else goto _L2
_L2:
        if (k != -1)
        {
            break; /* Loop/switch isn't completed */
        }
        i = byte0;
        if (linebuffer.isEmpty()) goto _L9; else goto _L8
_L8:
        return lineFromLineBuffer(chararraybuffer);
        if (true) goto _L11; else goto _L10
_L10:
    }
}
