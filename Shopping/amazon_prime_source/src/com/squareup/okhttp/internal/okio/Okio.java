// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.okio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.squareup.okhttp.internal.okio:
//            RealBufferedSink, RealBufferedSource, OkBuffer, Util, 
//            Segment, Sink, BufferedSink, Source, 
//            BufferedSource, Deadline, SegmentPool

public final class Okio
{

    private Okio()
    {
    }

    public static BufferedSink buffer(Sink sink1)
    {
        return new RealBufferedSink(sink1);
    }

    public static BufferedSource buffer(Source source1)
    {
        return new RealBufferedSource(source1);
    }

    public static void copy(OkBuffer okbuffer, long l, long l1, OutputStream outputstream)
        throws IOException
    {
        Util.checkOffsetAndCount(okbuffer.size, l, l1);
        okbuffer = okbuffer.head;
        long l2;
        long l3;
        do
        {
            l2 = l;
            l3 = l1;
            if (l < (long)(((Segment) (okbuffer)).limit - ((Segment) (okbuffer)).pos))
            {
                break;
            }
            l -= ((Segment) (okbuffer)).limit - ((Segment) (okbuffer)).pos;
            okbuffer = ((Segment) (okbuffer)).next;
        } while (true);
        while (l3 > 0L) 
        {
            int i = (int)((long)((Segment) (okbuffer)).pos + l2);
            int j = (int)Math.min(((Segment) (okbuffer)).limit - i, l3);
            outputstream.write(((Segment) (okbuffer)).data, i, j);
            l3 -= j;
            l2 = 0L;
        }
    }

    public static Sink sink(OutputStream outputstream)
    {
        return new Sink(outputstream) {

            private Deadline deadline;
            final OutputStream val$out;

            public void close()
                throws IOException
            {
                out.close();
            }

            public void flush()
                throws IOException
            {
                out.flush();
            }

            public String toString()
            {
                return (new StringBuilder()).append("sink(").append(out).append(")").toString();
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
                    out.write(segment.data, segment.pos, i);
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

            
            {
                out = outputstream;
                super();
                deadline = Deadline.NONE;
            }
        };
    }

    public static Source source(InputStream inputstream)
    {
        return new Source(inputstream) {

            private Deadline deadline;
            final InputStream val$in;

            public void close()
                throws IOException
            {
                in.close();
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
                i = in.read(segment.data, segment.limit, i);
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
                return (new StringBuilder()).append("source(").append(in).append(")").toString();
            }

            
            {
                in = inputstream;
                super();
                deadline = Deadline.NONE;
            }
        };
    }
}
