// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.io;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package org.apache.james.mime4j.io:
//            PositionInputStream

public class LimitedInputStream extends PositionInputStream
{

    private final long limit;

    public LimitedInputStream(InputStream inputstream, long l)
    {
        super(inputstream);
        if (l < 0L)
        {
            throw new IllegalArgumentException("Limit may not be negative");
        } else
        {
            limit = l;
            return;
        }
    }

    private void enforceLimit()
        throws IOException
    {
        if (position >= limit)
        {
            throw new IOException("Input stream limit exceeded");
        } else
        {
            return;
        }
    }

    private int getBytesLeft()
    {
        return (int)Math.min(0x7fffffffL, limit - position);
    }

    public int read()
        throws IOException
    {
        enforceLimit();
        return super.read();
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        enforceLimit();
        return super.read(abyte0, i, Math.min(j, getBytesLeft()));
    }

    public long skip(long l)
        throws IOException
    {
        enforceLimit();
        return super.skip(Math.min(l, getBytesLeft()));
    }
}
