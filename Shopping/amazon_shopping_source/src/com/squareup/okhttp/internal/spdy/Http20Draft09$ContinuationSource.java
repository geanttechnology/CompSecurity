// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.okio.BufferedSource;
import com.squareup.okhttp.internal.okio.Deadline;
import com.squareup.okhttp.internal.okio.OkBuffer;
import com.squareup.okhttp.internal.okio.Source;
import java.io.IOException;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Http20Draft09

static final class source
    implements Source
{

    byte flags;
    int left;
    int length;
    private final BufferedSource source;
    int streamId;

    private void readContinuationHeader()
        throws IOException
    {
        int i = streamId;
        int j = source.readInt();
        int k = source.readInt();
        int l = (short)((0x3fff0000 & j) >> 16);
        left = l;
        length = l;
        byte byte0 = (byte)((0xff00 & j) >> 8);
        flags = (byte)(j & 0xff);
        streamId = 0x7fffffff & k;
        if (byte0 != 10)
        {
            throw Http20Draft09.access$100("%s != TYPE_CONTINUATION", new Object[] {
                Byte.valueOf(byte0)
            });
        }
        if (streamId != i)
        {
            throw Http20Draft09.access$100("TYPE_CONTINUATION streamId changed", new Object[0]);
        } else
        {
            return;
        }
    }

    public void close()
        throws IOException
    {
    }

    public Source deadline(Deadline deadline1)
    {
        source.deadline(deadline1);
        return this;
    }

    public long read(OkBuffer okbuffer, long l)
        throws IOException
    {
        while (left == 0) 
        {
            if ((flags & 4) != 0)
            {
                return -1L;
            }
            readContinuationHeader();
        }
        l = source.read(okbuffer, Math.min(l, left));
        if (l == -1L)
        {
            return -1L;
        } else
        {
            left = (int)((long)left - l);
            return l;
        }
    }

    public (BufferedSource bufferedsource)
    {
        source = bufferedsource;
    }
}
