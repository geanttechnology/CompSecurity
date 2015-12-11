// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.okio.BufferedSource;
import com.squareup.okhttp.internal.okio.OkBuffer;
import com.squareup.okhttp.internal.okio.Source;
import java.io.IOException;
import java.net.CacheRequest;
import java.net.ProtocolException;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpConnection

private class endOfInput extends endOfInput
    implements Source
{

    private long bytesRemaining;
    final HttpConnection this$0;

    public void close()
        throws IOException
    {
        if (closed)
        {
            return;
        }
        if (bytesRemaining != 0L && !discard(this, 100))
        {
            unexpectedEndOfInput();
        }
        closed = true;
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
        if (bytesRemaining == 0L)
        {
            l = -1L;
        } else
        {
            long l1 = HttpConnection.access$900(HttpConnection.this).read(okbuffer, Math.min(bytesRemaining, l));
            if (l1 == -1L)
            {
                unexpectedEndOfInput();
                throw new ProtocolException("unexpected end of stream");
            }
            bytesRemaining = bytesRemaining - l1;
            cacheWrite(okbuffer, l1);
            l = l1;
            if (bytesRemaining == 0L)
            {
                endOfInput(true);
                return l1;
            }
        }
        return l;
    }

    public (CacheRequest cacherequest, long l)
        throws IOException
    {
        this$0 = HttpConnection.this;
        super(HttpConnection.this, cacherequest);
        bytesRemaining = l;
        if (bytesRemaining == 0L)
        {
            endOfInput(true);
        }
    }
}
