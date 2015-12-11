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
//            HttpConnection, HttpEngine

private class httpEngine extends 
    implements Source
{

    private int bytesRemainingInChunk;
    private boolean hasMoreChunks;
    private final HttpEngine httpEngine;
    final HttpConnection this$0;

    private void readChunkSize()
        throws IOException
    {
        if (bytesRemainingInChunk != -1)
        {
            HttpConnection.access$900(HttpConnection.this).readUtf8Line(true);
        }
        String s = HttpConnection.access$900(HttpConnection.this).readUtf8Line(true);
        int i = s.indexOf(";");
        Object obj = s;
        if (i != -1)
        {
            obj = s.substring(0, i);
        }
        try
        {
            bytesRemainingInChunk = Integer.parseInt(((String) (obj)).trim(), 16);
        }
        catch (NumberFormatException numberformatexception)
        {
            throw new ProtocolException((new StringBuilder()).append("Expected a hex chunk size but was ").append(((String) (obj))).toString());
        }
        if (bytesRemainingInChunk == 0)
        {
            hasMoreChunks = false;
            obj = new hasMoreChunks();
            readHeaders(((hasMoreChunks) (obj)));
            httpEngine.receiveHeaders(((httpEngine) (obj)).httpEngine());
            endOfInput(true);
        }
    }

    public void close()
        throws IOException
    {
        if (closed)
        {
            return;
        }
        if (hasMoreChunks && !discard(this, 100))
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
        if (!hasMoreChunks)
        {
            return -1L;
        }
        if (bytesRemainingInChunk == 0 || bytesRemainingInChunk == -1)
        {
            readChunkSize();
            if (!hasMoreChunks)
            {
                return -1L;
            }
        }
        l = HttpConnection.access$900(HttpConnection.this).read(okbuffer, Math.min(l, bytesRemainingInChunk));
        if (l == -1L)
        {
            unexpectedEndOfInput();
            throw new IOException("unexpected end of stream");
        } else
        {
            bytesRemainingInChunk = (int)((long)bytesRemainingInChunk - l);
            cacheWrite(okbuffer, l);
            return l;
        }
    }

    (CacheRequest cacherequest, HttpEngine httpengine)
        throws IOException
    {
        this$0 = HttpConnection.this;
        super(HttpConnection.this, cacherequest);
        bytesRemainingInChunk = -1;
        hasMoreChunks = true;
        httpEngine = httpengine;
    }
}
