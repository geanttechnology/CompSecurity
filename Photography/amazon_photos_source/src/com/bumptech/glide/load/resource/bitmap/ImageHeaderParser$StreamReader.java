// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            ImageHeaderParser

private static class is
{

    private final InputStream is;

    public int getByte()
        throws IOException
    {
        return is.read();
    }

    public int getUInt16()
        throws IOException
    {
        return is.read() << 8 & 0xff00 | is.read() & 0xff;
    }

    public short getUInt8()
        throws IOException
    {
        return (short)(is.read() & 0xff);
    }

    public int read(byte abyte0[])
        throws IOException
    {
        return is.read(abyte0);
    }

    public long skip(long l)
        throws IOException
    {
        return is.skip(l);
    }

    public (InputStream inputstream)
    {
        is = inputstream;
    }
}
