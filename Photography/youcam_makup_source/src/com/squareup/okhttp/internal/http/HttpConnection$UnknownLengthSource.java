// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import okio.d;
import okio.f;
import okio.r;
import okio.s;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpConnection, CacheRequest

class > extends >
    implements r
{

    private boolean inputExhausted;
    final HttpConnection this$0;

    public void close()
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
        if (inputExhausted)
        {
            return -1L;
        }
        l = HttpConnection.access$900(HttpConnection.this).read(d, l);
        if (l == -1L)
        {
            inputExhausted = true;
            endOfInput(false);
            return -1L;
        } else
        {
            cacheWrite(d, l);
            return l;
        }
    }

    public s timeout()
    {
        return HttpConnection.access$900(HttpConnection.this).timeout();
    }

    (CacheRequest cacherequest)
    {
        this$0 = HttpConnection.this;
        super(HttpConnection.this, cacherequest);
    }
}
