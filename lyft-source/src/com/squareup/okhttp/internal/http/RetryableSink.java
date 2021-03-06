// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import java.net.ProtocolException;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

public final class RetryableSink
    implements Sink
{

    private boolean closed;
    private final Buffer content;
    private final int limit;

    public RetryableSink()
    {
        this(-1);
    }

    public RetryableSink(int i)
    {
        content = new Buffer();
        limit = i;
    }

    public void close()
    {
        if (!closed)
        {
            closed = true;
            if (content.size() < (long)limit)
            {
                throw new ProtocolException((new StringBuilder()).append("content-length promised ").append(limit).append(" bytes, but received ").append(content.size()).toString());
            }
        }
    }

    public long contentLength()
    {
        return content.size();
    }

    public void flush()
    {
    }

    public Timeout timeout()
    {
        return Timeout.NONE;
    }

    public void write(Buffer buffer, long l)
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        }
        Util.checkOffsetAndCount(buffer.size(), 0L, l);
        if (limit != -1 && content.size() > (long)limit - l)
        {
            throw new ProtocolException((new StringBuilder()).append("exceeded content-length limit of ").append(limit).append(" bytes").toString());
        } else
        {
            content.write(buffer, l);
            return;
        }
    }

    public void writeToSocket(Sink sink)
    {
        Buffer buffer = new Buffer();
        content.copyTo(buffer, 0L, content.size());
        sink.write(buffer, buffer.size());
    }
}
