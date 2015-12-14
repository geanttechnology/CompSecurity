// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            u

final class s
    implements u
{

    private final ByteBuffer a;

    public s(ByteBuffer bytebuffer)
    {
        a = bytebuffer;
        bytebuffer.order(ByteOrder.BIG_ENDIAN);
    }

    public final int a()
    {
        return c() << 8 & 0xff00 | c() & 0xff;
    }

    public final int a(byte abyte0[], int i)
    {
        int j = Math.min(i, a.remaining());
        a.get(abyte0, 0, i);
        return j;
    }

    public final long a(long l)
    {
        int i = (int)Math.min(a.remaining(), l);
        a.position(a.position() + i);
        return (long)i;
    }

    public final short b()
    {
        return (short)(c() & 0xff);
    }

    public final int c()
    {
        if (a.remaining() <= 0)
        {
            return -1;
        } else
        {
            return a.get();
        }
    }
}
