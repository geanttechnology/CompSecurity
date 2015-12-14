// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.Arrays;

// Referenced classes of package com.google.common.hash:
//            Hashing, HashFunction, Hasher, HashCode, 
//            Funnel

abstract class BloomFilterStrategies extends Enum
    implements BloomFilter.Strategy
{
    static class BitArray
    {

        int bitCount;
        final long data[];

        int bitCount()
        {
            return bitCount;
        }

        public boolean equals(Object obj)
        {
            if (obj instanceof BitArray)
            {
                obj = (BitArray)obj;
                return Arrays.equals(data, ((BitArray) (obj)).data);
            } else
            {
                return false;
            }
        }

        boolean get(int i)
        {
            return (data[i >> 6] & 1L << i) != 0L;
        }

        public int hashCode()
        {
            return Arrays.hashCode(data);
        }

        int size()
        {
            return data.length * 64;
        }

        BitArray(int i)
        {
            this(new long[IntMath.divide(i, 64, RoundingMode.CEILING)]);
        }

        BitArray(long al[])
        {
            int j;
            int k;
            boolean flag;
            if (al.length > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "data length is zero!");
            data = al;
            j = 0;
            k = al.length;
            for (int i = 0; i < k; i++)
            {
                j += Long.bitCount(al[i]);
            }

            bitCount = j;
        }
    }


    private static final BloomFilterStrategies $VALUES[];
    public static final BloomFilterStrategies MURMUR128_MITZ_32;

    private BloomFilterStrategies(String s, int i)
    {
        super(s, i);
    }


    public static BloomFilterStrategies valueOf(String s)
    {
        return (BloomFilterStrategies)Enum.valueOf(com/google/common/hash/BloomFilterStrategies, s);
    }

    public static BloomFilterStrategies[] values()
    {
        return (BloomFilterStrategies[])$VALUES.clone();
    }

    static 
    {
        MURMUR128_MITZ_32 = new BloomFilterStrategies("MURMUR128_MITZ_32", 0) {

            public boolean mightContain(Object obj, Funnel funnel, int i, BitArray bitarray)
            {
                long l1 = Hashing.murmur3_128().newHasher().putObject(obj, funnel).hash().asLong();
                int i1 = (int)l1;
                int j1 = (int)(l1 >>> 32);
                for (int j = 1; j <= i; j++)
                {
                    int l = i1 + j * j1;
                    int k = l;
                    if (l < 0)
                    {
                        k = ~l;
                    }
                    if (!bitarray.get(k % bitarray.size()))
                    {
                        return false;
                    }
                }

                return true;
            }

        };
        $VALUES = (new BloomFilterStrategies[] {
            MURMUR128_MITZ_32
        });
    }
}
