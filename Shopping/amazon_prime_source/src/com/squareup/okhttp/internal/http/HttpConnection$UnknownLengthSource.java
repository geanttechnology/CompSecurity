// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.okio.BufferedSource;
import com.squareup.okhttp.internal.okio.OkBuffer;
import com.squareup.okhttp.internal.okio.Source;
import java.io.IOException;
import java.net.CacheRequest;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpConnection

class > extends >
    implements Source
{

    private boolean inputExhausted;
    final HttpConnection this$0;

    public void close()
        throws IOException
    {
        if (closed)
        {
            return;
        }
        if (!inputExhausted)
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
        if (inputExhausted)
        {
            return -1L;
        }
        l = HttpConnection.access$900(HttpConnection.this).read(okbuffer, l);
        if (l == -1L)
        {
            inputExhausted = true;
            endOfInput(false);
            return -1L;
        } else
        {
            cacheWrite(okbuffer, l);
            return l;
        }
    }

    (CacheRequest cacherequest)
        throws IOException
    {
        this$0 = HttpConnection.this;
        super(HttpConnection.this, cacherequest);
    }
}
