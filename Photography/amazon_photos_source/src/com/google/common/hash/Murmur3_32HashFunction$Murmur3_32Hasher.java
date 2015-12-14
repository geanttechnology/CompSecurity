// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.hash;

import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;

// Referenced classes of package com.google.common.hash:
//            Murmur3_32HashFunction, HashCode

private static final class length extends reamingHasher
{

    private int h1;
    private int length;

    public HashCode makeHash()
    {
        return Murmur3_32HashFunction.access$200(h1, length);
    }

    protected void process(ByteBuffer bytebuffer)
    {
        int i = Murmur3_32HashFunction.access$000(bytebuffer.getInt());
        h1 = Murmur3_32HashFunction.access$100(h1, i);
        length = length + 4;
    }

    protected void processRemaining(ByteBuffer bytebuffer)
    {
        length = length + bytebuffer.remaining();
        int j = 0;
        int i = 0;
        switch (bytebuffer.remaining())
        {
        default:
            throw new AssertionError("Should never get here.");

        case 3: // '\003'
            i = 0 ^ UnsignedBytes.toInt(bytebuffer.get(2)) << 16;
            // fall through

        case 2: // '\002'
            j = i ^ UnsignedBytes.toInt(bytebuffer.get(1)) << 8;
            // fall through

        case 1: // '\001'
            i = UnsignedBytes.toInt(bytebuffer.get(0));
            break;
        }
        h1 = h1 ^ Murmur3_32HashFunction.access$000(j ^ i);
    }

    reamingHasher(int i)
    {
        super(4);
        h1 = i;
        length = 0;
    }
}
