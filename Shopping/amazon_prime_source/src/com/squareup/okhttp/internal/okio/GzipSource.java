// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

// Referenced classes of package com.squareup.okhttp.internal.okio:
//            Source, Okio, InflaterSource, BufferedSource, 
//            OkBuffer, Segment

public final class GzipSource
    implements Source
{

    private final CRC32 crc = new CRC32();
    private final Inflater inflater = new Inflater(true);
    private final InflaterSource inflaterSource;
    private int section;
    private final BufferedSource source;

    public GzipSource(Source source1)
        throws IOException
    {
        section = 0;
        source = Okio.buffer(source1);
        inflaterSource = new InflaterSource(source, inflater);
    }

    private void checkEqual(String s, int i, int j)
        throws IOException
    {
        if (j != i)
        {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[] {
                s, Integer.valueOf(j), Integer.valueOf(i)
            }));
        } else
        {
            return;
        }
    }

    private void consumeHeader()
        throws IOException
    {
        source.require(10L);
        byte byte0 = source.buffer().getByte(3L);
        boolean flag;
        if ((byte0 >> 1 & 1) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            updateCrc(source.buffer(), 0L, 10L);
        }
        checkEqual("ID1ID2", 8075, source.readShort());
        source.skip(8L);
        if ((byte0 >> 2 & 1) == 1)
        {
            source.require(2L);
            if (flag)
            {
                updateCrc(source.buffer(), 0L, 2L);
            }
            int i = source.buffer().readShortLe() & 0xffff;
            source.require(i);
            if (flag)
            {
                updateCrc(source.buffer(), 0L, i);
            }
            source.skip(i);
        }
        if ((byte0 >> 3 & 1) == 1)
        {
            long l = source.seek((byte)0);
            if (flag)
            {
                updateCrc(source.buffer(), 0L, 1L + l);
            }
            source.skip(1L + l);
        }
        if ((byte0 >> 4 & 1) == 1)
        {
            long l1 = source.seek((byte)0);
            if (flag)
            {
                updateCrc(source.buffer(), 0L, 1L + l1);
            }
            source.skip(1L + l1);
        }
        if (flag)
        {
            checkEqual("FHCRC", source.readShortLe(), (short)(int)crc.getValue());
            crc.reset();
        }
    }

    private void consumeTrailer()
        throws IOException
    {
        checkEqual("CRC", source.readIntLe(), (int)crc.getValue());
        checkEqual("ISIZE", source.readIntLe(), inflater.getTotalOut());
    }

    private void updateCrc(OkBuffer okbuffer, long l, long l1)
    {
        okbuffer = okbuffer.head;
        long l2;
        for (; l1 > 0L; l1 = l2)
        {
            int i = ((Segment) (okbuffer)).limit - ((Segment) (okbuffer)).pos;
            l2 = l1;
            if (l < (long)i)
            {
                int j = (int)Math.min(l1, (long)i - l);
                crc.update(((Segment) (okbuffer)).data, (int)((long)((Segment) (okbuffer)).pos + l), j);
                l2 = l1 - (long)j;
            }
            l -= i;
            okbuffer = ((Segment) (okbuffer)).next;
        }

    }

    public void close()
        throws IOException
    {
        inflaterSource.close();
    }

    public long read(OkBuffer okbuffer, long l)
        throws IOException
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("byteCount < 0: ").append(l).toString());
        }
        if (l == 0L)
        {
            return 0L;
        }
        if (section == 0)
        {
            consumeHeader();
            section = 1;
        }
        if (section == 1)
        {
            long l1 = okbuffer.size;
            l = inflaterSource.read(okbuffer, l);
            if (l != -1L)
            {
                updateCrc(okbuffer, l1, l);
                return l;
            }
            section = 2;
        }
        if (section == 2)
        {
            consumeTrailer();
            section = 3;
            if (!source.exhausted())
            {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }
}
