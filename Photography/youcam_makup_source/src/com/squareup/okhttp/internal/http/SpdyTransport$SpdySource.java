// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.spdy.ErrorCode;
import com.squareup.okhttp.internal.spdy.SpdyStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okio.d;
import okio.q;
import okio.r;
import okio.s;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            CacheRequest

class cacheRequest
    implements r
{

    private final q cacheBody;
    private final CacheRequest cacheRequest;
    private boolean closed;
    private boolean inputExhausted;
    private final r source;
    private final SpdyStream stream;

    private boolean discardStream()
    {
        Exception exception;
        long l = stream.readTimeout().timeoutNanos();
        stream.readTimeout().timeout(100L, TimeUnit.MILLISECONDS);
        try
        {
            Util.skipAll(this, 100);
        }
        catch (IOException ioexception)
        {
            stream.readTimeout().timeout(l, TimeUnit.NANOSECONDS);
            return false;
        }
        finally
        {
            stream.readTimeout().timeout(l, TimeUnit.NANOSECONDS);
        }
        stream.readTimeout().timeout(l, TimeUnit.NANOSECONDS);
        return true;
        throw exception;
    }

    public void close()
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

    public long read(d d1, long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("byteCount < 0: ").append(l).toString());
        }
        if (closed)
        {
            throw new IllegalStateException("closed");
        }
        if (!inputExhausted)
        {
            l = source.read(d1, l);
            if (l == -1L)
            {
                inputExhausted = true;
                if (cacheRequest != null)
                {
                    cacheBody.close();
                    return -1L;
                }
            } else
            {
                if (cacheBody != null)
                {
                    cacheBody.write(d1.r(), l);
                }
                return l;
            }
        }
        return -1L;
    }

    public s timeout()
    {
        return source.timeout();
    }

    (SpdyStream spdystream, CacheRequest cacherequest)
    {
        stream = spdystream;
        source = spdystream.getSource();
        if (cacherequest != null)
        {
            spdystream = cacherequest.body();
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
