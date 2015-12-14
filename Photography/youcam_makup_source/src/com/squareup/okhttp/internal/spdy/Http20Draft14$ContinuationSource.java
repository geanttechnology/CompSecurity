// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.Internal;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.d;
import okio.f;
import okio.r;
import okio.s;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Http20Draft14

final class source
    implements r
{

    byte flags;
    int left;
    int length;
    short padding;
    private final f source;
    int streamId;

    private void readContinuationHeader()
    {
        int i = streamId;
        int j = Http20Draft14.access$200(source);
        left = j;
        length = j;
        byte byte0 = (byte)(source.h() & 0xff);
        flags = (byte)(source.h() & 0xff);
        if (Internal.logger.isLoggable(Level.FINE))
        {
            Internal.logger.fine(eader(true, streamId, length, byte0, flags));
        }
        streamId = source.j() & 0x7fffffff;
        if (byte0 != 9)
        {
            throw Http20Draft14.access$100("%s != TYPE_CONTINUATION", new Object[] {
                Byte.valueOf(byte0)
            });
        }
        if (streamId != i)
        {
            throw Http20Draft14.access$100("TYPE_CONTINUATION streamId changed", new Object[0]);
        } else
        {
            return;
        }
    }

    public void close()
    {
    }

    public long read(d d, long l)
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
        l = source.read(d, Math.min(l, left));
        if (l == -1L) goto _L3; else goto _L5
_L5:
        left = (int)((long)left - l);
        return l;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public s timeout()
    {
        return source.timeout();
    }

    public (f f1)
    {
        source = f1;
    }
}
