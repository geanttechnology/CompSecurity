// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import java.net.ProtocolException;
import okio.d;
import okio.f;
import okio.r;
import okio.s;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpConnection, CacheRequest

class endOfInput extends endOfInput
    implements r
{

    private long bytesRemaining;
    final HttpConnection this$0;

    public void close()
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

    public long read(d d, long l)
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
            return -1L;
        }
        l = HttpConnection.access$900(HttpConnection.this).read(d, Math.min(bytesRemaining, l));
        if (l == -1L)
        {
            unexpectedEndOfInput();
            throw new ProtocolException("unexpected end of stream");
        }
        bytesRemaining = bytesRemaining - l;
        cacheWrite(d, l);
        if (bytesRemaining == 0L)
        {
            endOfInput(true);
        }
        return l;
    }

    public s timeout()
    {
        return HttpConnection.access$900(HttpConnection.this).timeout();
    }

    public (CacheRequest cacherequest, long l)
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
