// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import java.net.ProtocolException;
import okio.d;
import okio.e;
import okio.q;
import okio.s;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpConnection

final class <init>
    implements q
{

    private long bytesRemaining;
    private boolean closed;
    final HttpConnection this$0;

    public void close()
    {
        if (closed)
        {
            return;
        }
        closed = true;
        if (bytesRemaining > 0L)
        {
            throw new ProtocolException("unexpected end of stream");
        } else
        {
            HttpConnection.access$302(HttpConnection.this, 3);
            return;
        }
    }

    public void flush()
    {
        if (closed)
        {
            return;
        } else
        {
            HttpConnection.access$200(HttpConnection.this).flush();
            return;
        }
    }

    public s timeout()
    {
        return HttpConnection.access$200(HttpConnection.this).timeout();
    }

    public void write(d d1, long l)
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        }
        Util.checkOffsetAndCount(d1.a(), 0L, l);
        if (l > bytesRemaining)
        {
            throw new ProtocolException((new StringBuilder()).append("expected ").append(bytesRemaining).append(" bytes but received ").append(l).toString());
        } else
        {
            HttpConnection.access$200(HttpConnection.this).write(d1, l);
            bytesRemaining = bytesRemaining - l;
            return;
        }
    }

    private (long l)
    {
        this$0 = HttpConnection.this;
        super();
        bytesRemaining = l;
    }

    bytesRemaining(long l, bytesRemaining bytesremaining)
    {
        this(l);
    }
}
