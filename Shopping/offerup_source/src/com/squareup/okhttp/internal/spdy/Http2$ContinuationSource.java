// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import d.ab;
import d.ac;
import d.f;
import d.j;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Http2

final class source
    implements ab
{

    byte flags;
    int left;
    int length;
    short padding;
    private final j source;
    int streamId;

    private void readContinuationHeader()
    {
        int i = streamId;
        int k = Http2.access$300(source);
        left = k;
        length = k;
        byte byte0 = source.g();
        flags = source.g();
        if (Http2.access$100().isLoggable(Level.FINE))
        {
            Http2.access$100().fine(eader(true, streamId, length, byte0, flags));
        }
        streamId = source.i() & 0x7fffffff;
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

    public final void close()
    {
    }

    public final long read(f f, long l)
    {
_L7:
        if (left != 0) goto _L2; else goto _L1
_L1:
        source.f(padding);
        padding = 0;
        if ((flags & 4) == 0) goto _L4; else goto _L3
_L3:
        return -1L;
_L4:
        readContinuationHeader();
        continue; /* Loop/switch isn't completed */
_L2:
        l = source.read(f, Math.min(l, left));
        if (l == -1L) goto _L3; else goto _L5
_L5:
        left = (int)((long)left - l);
        return l;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final ac timeout()
    {
        return source.timeout();
    }

    public (j j1)
    {
        source = j1;
    }
}
