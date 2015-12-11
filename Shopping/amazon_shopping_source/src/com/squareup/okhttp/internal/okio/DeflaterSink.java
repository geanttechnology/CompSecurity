// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.okio;

import java.io.IOException;
import java.util.zip.Deflater;

// Referenced classes of package com.squareup.okhttp.internal.okio:
//            Sink, Okio, BufferedSink, OkBuffer, 
//            Segment, Util, SegmentPool, Deadline

public final class DeflaterSink
    implements Sink
{

    private boolean closed;
    private final Deflater deflater;
    private final BufferedSink sink;

    public DeflaterSink(Sink sink1, Deflater deflater1)
    {
        sink = Okio.buffer(sink1);
        deflater = deflater1;
    }

    private void deflate(boolean flag)
        throws IOException
    {
        OkBuffer okbuffer = sink.buffer();
label0:
        do
        {
            do
            {
                Segment segment = okbuffer.writableSegment(1);
                int i;
                if (flag)
                {
                    i = deflater.deflate(segment.data, segment.limit, 2048 - segment.limit, 2);
                } else
                {
                    i = deflater.deflate(segment.data, segment.limit, 2048 - segment.limit);
                }
                if (i <= 0)
                {
                    continue label0;
                }
                segment.limit = segment.limit + i;
                okbuffer.size = okbuffer.size + (long)i;
                sink.emitCompleteSegments();
            } while (true);
        } while (!deflater.needsInput());
    }

    public void close()
        throws IOException
    {
        if (!closed) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Throwable throwable;
        Throwable throwable1;
        throwable1 = null;
        try
        {
            deflater.finish();
            deflate(false);
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable1) { }
        deflater.end();
        throwable = throwable1;
_L3:
        sink.close();
        throwable1 = throwable;
_L4:
        closed = true;
        if (throwable1 != null)
        {
            Util.sneakyRethrow(throwable1);
            return;
        }
          goto _L1
        Throwable throwable2;
        throwable2;
        throwable = throwable1;
        if (throwable1 == null)
        {
            throwable = throwable2;
        }
          goto _L3
        throwable2;
        throwable1 = throwable;
        if (throwable == null)
        {
            throwable1 = throwable2;
        }
          goto _L4
    }

    public Sink deadline(Deadline deadline1)
    {
        sink.deadline(deadline1);
        return this;
    }

    public void flush()
        throws IOException
    {
        deflate(true);
        sink.flush();
    }

    public String toString()
    {
        return (new StringBuilder()).append("DeflaterSink(").append(sink).append(")").toString();
    }

    public void write(OkBuffer okbuffer, long l)
        throws IOException
    {
        Util.checkOffsetAndCount(okbuffer.size, 0L, l);
        int i;
        for (; l > 0L; l -= i)
        {
            Segment segment = okbuffer.head;
            i = (int)Math.min(l, segment.limit - segment.pos);
            deflater.setInput(segment.data, segment.pos, i);
            deflate(false);
            okbuffer.size = okbuffer.size - (long)i;
            segment.pos = segment.pos + i;
            if (segment.pos == segment.limit)
            {
                okbuffer.head = segment.pop();
                SegmentPool.INSTANCE.recycle(segment);
            }
        }

    }
}
