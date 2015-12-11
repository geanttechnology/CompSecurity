// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

// Referenced classes of package com.squareup.okhttp.internal.okio:
//            Source, Okio, BufferedSource, OkBuffer, 
//            Segment, Deadline

public final class InflaterSource
    implements Source
{

    private int bufferBytesHeldByInflater;
    private boolean closed;
    private final Inflater inflater;
    private final BufferedSource source;

    InflaterSource(BufferedSource bufferedsource, Inflater inflater1)
    {
        if (bufferedsource == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater1 == null)
        {
            throw new IllegalArgumentException("inflater == null");
        } else
        {
            source = bufferedsource;
            inflater = inflater1;
            return;
        }
    }

    public InflaterSource(Source source1, Inflater inflater1)
    {
        this(Okio.buffer(source1), inflater1);
    }

    private void releaseInflatedBytes()
        throws IOException
    {
        if (bufferBytesHeldByInflater == 0)
        {
            return;
        } else
        {
            int i = bufferBytesHeldByInflater - inflater.getRemaining();
            bufferBytesHeldByInflater = bufferBytesHeldByInflater - i;
            source.skip(i);
            return;
        }
    }

    public void close()
        throws IOException
    {
        if (closed)
        {
            return;
        } else
        {
            inflater.end();
            closed = true;
            source.close();
            return;
        }
    }

    public Source deadline(Deadline deadline1)
    {
        source.deadline(deadline1);
        return this;
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
        if (l == 0L)
        {
            return 0L;
        }
_L2:
        boolean flag = refill();
        Segment segment;
        int i;
        segment = okbuffer.writableSegment(1);
        i = inflater.inflate(segment.data, segment.limit, 2048 - segment.limit);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        segment.limit = segment.limit + i;
        okbuffer.size = okbuffer.size + (long)i;
        return (long)i;
        if (!inflater.finished() && !inflater.needsDictionary())
        {
            continue; /* Loop/switch isn't completed */
        }
        releaseInflatedBytes();
        return -1L;
        if (!flag) goto _L2; else goto _L1
_L1:
        IOException ioexception;
        try
        {
            throw new EOFException("source exhausted prematurely");
        }
        // Misplaced declaration of an exception variable
        catch (OkBuffer okbuffer)
        {
            ioexception = new IOException();
        }
        ioexception.initCause(okbuffer);
        throw ioexception;
    }

    public boolean refill()
        throws IOException
    {
        if (!inflater.needsInput())
        {
            return false;
        }
        releaseInflatedBytes();
        if (inflater.getRemaining() != 0)
        {
            throw new IllegalStateException("?");
        }
        if (source.exhausted())
        {
            return true;
        } else
        {
            Segment segment = source.buffer().head;
            bufferBytesHeldByInflater = segment.limit - segment.pos;
            inflater.setInput(segment.data, segment.pos, bufferBytesHeldByInflater);
            return false;
        }
    }
}
