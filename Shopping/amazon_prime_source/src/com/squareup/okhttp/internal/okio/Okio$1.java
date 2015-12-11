// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.okio;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.squareup.okhttp.internal.okio:
//            Sink, Okio, Deadline, OkBuffer, 
//            Util, Segment, SegmentPool

static final class e.NONE
    implements Sink
{

    private Deadline deadline;
    final OutputStream val$out;

    public void close()
        throws IOException
    {
        val$out.close();
    }

    public void flush()
        throws IOException
    {
        val$out.flush();
    }

    public String toString()
    {
        return (new StringBuilder()).append("sink(").append(val$out).append(")").toString();
    }

    public void write(OkBuffer okbuffer, long l)
        throws IOException
    {
        Util.checkOffsetAndCount(okbuffer.size, 0L, l);
        do
        {
            if (l <= 0L)
            {
                break;
            }
            deadline.throwIfReached();
            Segment segment = okbuffer.head;
            int i = (int)Math.min(l, segment.limit - segment.pos);
            val$out.write(segment.data, segment.pos, i);
            segment.pos = segment.pos + i;
            long l1 = l - (long)i;
            okbuffer.size = okbuffer.size - (long)i;
            l = l1;
            if (segment.pos == segment.limit)
            {
                okbuffer.head = segment.pop();
                SegmentPool.INSTANCE.recycle(segment);
                l = l1;
            }
        } while (true);
    }

    r(OutputStream outputstream)
    {
        val$out = outputstream;
        super();
        deadline = Deadline.NONE;
    }
}
