// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import java.net.ProtocolException;
import okio.d;
import okio.q;
import okio.s;

public final class RetryableSink
    implements q
{

    private boolean closed;
    private final d content;
    private final int limit;

    public RetryableSink()
    {
        this(-1);
    }

    public RetryableSink(int i)
    {
        content = new d();
        limit = i;
    }

    public void close()
    {
        if (!closed)
        {
            closed = true;
            if (content.a() < (long)limit)
            {
                throw new ProtocolException((new StringBuilder()).append("content-length promised ").append(limit).append(" bytes, but received ").append(content.a()).toString());
            }
        }
    }

    public long contentLength()
    {
        return content.a();
    }

    public void flush()
    {
    }

    public s timeout()
    {
        return s.NONE;
    }

    public void write(d d1, long l)
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        }
        Util.checkOffsetAndCount(d1.a(), 0L, l);
        if (limit != -1 && content.a() > (long)limit - l)
        {
            throw new ProtocolException((new StringBuilder()).append("exceeded content-length limit of ").append(limit).append(" bytes").toString());
        } else
        {
            content.write(d1, l);
            return;
        }
    }

    public void writeToSocket(q q1)
    {
        d d1 = content.r();
        q1.write(d1, d1.a());
    }
}
