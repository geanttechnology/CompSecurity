// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.okio;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.squareup.okhttp.internal.okio:
//            Source, Okio, Deadline, OkBuffer, 
//            Segment

static final class e.NONE
    implements Source
{

    private Deadline deadline;
    final InputStream val$in;

    public void close()
        throws IOException
    {
        val$in.close();
    }

    public long read(OkBuffer okbuffer, long l)
        throws IOException
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("byteCount < 0: ").append(l).toString());
        }
        deadline.throwIfReached();
        Segment segment = okbuffer.writableSegment(1);
        int i = (int)Math.min(l, 2048 - segment.limit);
        i = val$in.read(segment.data, segment.limit, i);
        if (i == -1)
        {
            return -1L;
        } else
        {
            segment.limit = segment.limit + i;
            okbuffer.size = okbuffer.size + (long)i;
            return (long)i;
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("source(").append(val$in).append(")").toString();
    }

    r(InputStream inputstream)
    {
        val$in = inputstream;
        super();
        deadline = Deadline.NONE;
    }
}
