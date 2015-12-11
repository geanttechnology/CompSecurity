// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import android.support.v7.apv;
import android.support.v7.aqj;
import android.support.v7.aql;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.net.ProtocolException;

public final class RetryableSink
    implements aqj
{

    private boolean closed;
    private final apv content;
    private final int limit;

    public RetryableSink()
    {
        this(-1);
    }

    public RetryableSink(int i)
    {
        content = new apv();
        limit = i;
    }

    public void close()
        throws IOException
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
        throws IOException
    {
        return content.a();
    }

    public void flush()
        throws IOException
    {
    }

    public aql timeout()
    {
        return aql.NONE;
    }

    public void write(apv apv1, long l)
        throws IOException
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        }
        Util.checkOffsetAndCount(apv1.a(), 0L, l);
        if (limit != -1 && content.a() > (long)limit - l)
        {
            throw new ProtocolException((new StringBuilder()).append("exceeded content-length limit of ").append(limit).append(" bytes").toString());
        } else
        {
            content.write(apv1, l);
            return;
        }
    }

    public void writeToSocket(aqj aqj1)
        throws IOException
    {
        apv apv1 = new apv();
        content.a(apv1, 0L, content.a());
        aqj1.write(apv1, apv1.a());
    }
}
