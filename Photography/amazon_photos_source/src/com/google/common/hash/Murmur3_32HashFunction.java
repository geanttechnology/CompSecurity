// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.hash;

import com.google.common.primitives.UnsignedBytes;
import java.io.Serializable;
import java.nio.ByteBuffer;

// Referenced classes of package com.google.common.hash:
//            AbstractStreamingHashFunction, HashCodes, HashCode, Hasher

final class Murmur3_32HashFunction extends AbstractStreamingHashFunction
    implements Serializable
{
    private static final class Murmur3_32Hasher extends AbstractStreamingHashFunction.AbstractStreamingHasher
    {

        private int h1;
        private int length;

        public HashCode makeHash()
        {
            return Murmur3_32HashFunction.fmix(h1, length);
        }

        protected void process(ByteBuffer bytebuffer)
        {
            int i = Murmur3_32HashFunction.mixK1(bytebuffer.getInt());
            h1 = Murmur3_32HashFunction.mixH1(h1, i);
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
            h1 = h1 ^ Murmur3_32HashFunction.mixK1(j ^ i);
        }

        Murmur3_32Hasher(int i)
        {
            super(4);
            h1 = i;
            length = 0;
        }
    }


    private final int seed;

    Murmur3_32HashFunction(int i)
    {
        seed = i;
    }

    private static HashCode fmix(int i, int j)
    {
        i ^= j;
        i = (i ^ i >>> 16) * 0x85ebca6b;
        i = (i ^ i >>> 13) * 0xc2b2ae35;
        return HashCodes.fromInt(i ^ i >>> 16);
    }

    private static int mixH1(int i, int j)
    {
        return Integer.rotateLeft(i ^ j, 13) * 5 - 0x19ab949c;
    }

    private static int mixK1(int i)
    {
        return Integer.rotateLeft(i * 0xcc9e2d51, 15) * 0x1b873593;
    }

    public Hasher newHasher()
    {
        return new Murmur3_32Hasher(seed);
    }



}
