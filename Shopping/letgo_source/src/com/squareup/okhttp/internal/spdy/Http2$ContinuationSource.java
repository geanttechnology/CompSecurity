// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import android.support.v7.apv;
import android.support.v7.apx;
import android.support.v7.aqk;
import android.support.v7.aql;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Http2

static final class source
    implements aqk
{

    byte flags;
    int left;
    int length;
    short padding;
    private final apx source;
    int streamId;

    private void readContinuationHeader()
        throws IOException
    {
        int i = streamId;
        int j = Http2.access$300(source);
        left = j;
        length = j;
        byte byte0 = (byte)(source.i() & 0xff);
        flags = (byte)(source.i() & 0xff);
        if (Http2.access$100().isLoggable(Level.FINE))
        {
            Http2.access$100().fine(eader(true, streamId, length, byte0, flags));
        }
        streamId = source.k() & 0x7fffffff;
        if (byte0 != 9)
        {
            throw Http2.access$200("%s != TYPE_CONTINUATION", new Object[] {
                Byte.valueOf(byte0)
            });
        }
        if (streamId != i)
        {
            throw Http2.access$200("TYPE_CONTINUATION streamId changed", new Object[0]);
        } else
        {
            return;
        }
    }

    public void close()
        throws IOException
    {
    }

    public long read(apv apv, long l)
        throws IOException
    {
_L7:
        if (left != 0) goto _L2; else goto _L1
_L1:
        source.g(padding);
        padding = 0;
        if ((flags & 4) == 0) goto _L4; else goto _L3
_L3:
        return -1L;
_L4:
        readContinuationHeader();
        continue; /* Loop/switch isn't completed */
_L2:
        l = source.read(apv, Math.min(l, left));
        if (l == -1L) goto _L3; else goto _L5
_L5:
        left = (int)((long)left - l);
        return l;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public aql timeout()
    {
        return source.timeout();
    }

    public (apx apx1)
    {
        source = apx1;
    }
}
