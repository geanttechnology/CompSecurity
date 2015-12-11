// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.okio.Deadline;
import com.squareup.okhttp.internal.okio.OkBuffer;
import com.squareup.okhttp.internal.okio.Okio;
import com.squareup.okhttp.internal.okio.Source;
import com.squareup.okhttp.internal.spdy.ErrorCode;
import com.squareup.okhttp.internal.spdy.SpdyStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CacheRequest;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            SpdyTransport

private static class cacheRequest
    implements Source
{

    private final OutputStream cacheBody;
    private final CacheRequest cacheRequest;
    private boolean closed;
    private boolean inputExhausted;
    private final Source source;
    private final SpdyStream stream;

    private boolean discardStream()
    {
        Exception exception;
        long l;
        try
        {
            l = stream.getReadTimeoutMillis();
            stream.setReadTimeout(l);
            stream.setReadTimeout(100L);
        }
        catch (IOException ioexception)
        {
            return false;
        }
        Util.skipAll(this, 100);
        stream.setReadTimeout(l);
        return true;
        exception;
        stream.setReadTimeout(l);
        throw exception;
    }

    public void close()
        throws IOException
    {
        if (!closed)
        {
            if (!inputExhausted && cacheBody != null)
            {
                discardStream();
            }
            closed = true;
            if (!inputExhausted)
            {
                stream.closeLater(ErrorCode.CANCEL);
                if (cacheRequest != null)
                {
                    cacheRequest.abort();
                    return;
                }
            }
        }
    }

    public Source deadline(Deadline deadline1)
    {
        source.deadline(deadline1);
        return this;
    }

    public long read(OkBuffer okbuffer, long l)
        throws IOException
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("byteCount < 0: ").append(l).toString());
        }
        if (closed)
        {
            throw new IllegalStateException("closed");
        }
        if (inputExhausted)
        {
            l = -1L;
        } else
        {
            long l1 = source.read(okbuffer, l);
            if (l1 == -1L)
            {
                inputExhausted = true;
                if (cacheRequest != null)
                {
                    cacheBody.close();
                }
                return -1L;
            }
            l = l1;
            if (cacheBody != null)
            {
                Okio.copy(okbuffer, okbuffer.size() - l1, l1, cacheBody);
                return l1;
            }
        }
        return l;
    }

    (SpdyStream spdystream, CacheRequest cacherequest)
        throws IOException
    {
        stream = spdystream;
        source = spdystream.getSource();
        if (cacherequest != null)
        {
            spdystream = cacherequest.getBody();
        } else
        {
            spdystream = null;
        }
        if (spdystream == null)
        {
            cacherequest = null;
        }
        cacheBody = spdystream;
        cacheRequest = cacherequest;
    }
}
