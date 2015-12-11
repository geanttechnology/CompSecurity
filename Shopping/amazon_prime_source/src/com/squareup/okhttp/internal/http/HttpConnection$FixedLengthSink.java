// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.okio.BufferedSink;
import com.squareup.okhttp.internal.okio.OkBuffer;
import com.squareup.okhttp.internal.okio.Sink;
import java.io.IOException;
import java.net.ProtocolException;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpConnection

private final class <init>
    implements Sink
{

    private long bytesRemaining;
    private boolean closed;
    final HttpConnection this$0;

    public void close()
        throws IOException
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
        throws IOException
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

    public void write(OkBuffer okbuffer, long l)
        throws IOException
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        }
        Util.checkOffsetAndCount(okbuffer.size(), 0L, l);
        if (l > bytesRemaining)
        {
            throw new ProtocolException((new StringBuilder()).append("expected ").append(bytesRemaining).append(" bytes but received ").append(l).toString());
        } else
        {
            HttpConnection.access$200(HttpConnection.this).write(okbuffer, l);
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
