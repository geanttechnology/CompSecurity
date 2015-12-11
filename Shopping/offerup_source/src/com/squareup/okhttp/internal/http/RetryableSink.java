// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import d.aa;
import d.ac;
import d.f;
import java.net.ProtocolException;

public final class RetryableSink
    implements aa
{

    private boolean closed;
    private final f content;
    private final int limit;

    public RetryableSink()
    {
        this(-1);
    }

    public RetryableSink(int i)
    {
        content = new f();
        limit = i;
    }

    public final void close()
    {
        if (!closed)
        {
            closed = true;
            if (content.a() < (long)limit)
            {
                throw new ProtocolException((new StringBuilder("content-length promised ")).append(limit).append(" bytes, but received ").append(content.a()).toString());
            }
        }
    }

    public final long contentLength()
    {
        return content.a();
    }

    public final void flush()
    {
    }

    public final ac timeout()
    {
        return ac.NONE;
    }

    public final void write(f f1, long l)
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        }
        Util.checkOffsetAndCount(f1.a(), 0L, l);
        if (limit != -1 && content.a() > (long)limit - l)
        {
            throw new ProtocolException((new StringBuilder("exceeded content-length limit of ")).append(limit).append(" bytes").toString());
        } else
        {
            content.write(f1, l);
            return;
        }
    }

    public final void writeToSocket(aa aa1)
    {
        f f1 = new f();
        content.a(f1, 0L, content.a());
        aa1.write(f1, f1.a());
    }
}
