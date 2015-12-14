// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.io.Serializable;

// Referenced classes of package com.google.common.hash:
//            Funnel, BloomFilterStrategies

public final class BloomFilter
    implements Serializable
{
    static interface Strategy
        extends Serializable
    {

        public abstract boolean mightContain(Object obj, Funnel funnel1, int i, BloomFilterStrategies.BitArray bitarray);
    }


    private static final double LN2;
    private static final double LN2_SQUARED;
    private final BloomFilterStrategies.BitArray bits;
    private final Funnel funnel;
    private final int numHashFunctions;
    private final Strategy strategy;

    private BloomFilter(BloomFilterStrategies.BitArray bitarray, int i, Funnel funnel1, Strategy strategy1)
    {
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "numHashFunctions zero or negative");
        bits = (BloomFilterStrategies.BitArray)Preconditions.checkNotNull(bitarray);
        numHashFunctions = i;
        funnel = (Funnel)Preconditions.checkNotNull(funnel1);
        strategy = strategy1;
        if (i > 255)
        {
            throw new AssertionError("Currently we don't allow BloomFilters that would use more than255 hash functions, please contact the guava team");
        } else
        {
            return;
        }
    }

    public static BloomFilter create(Funnel funnel1, int i)
    {
        return create(funnel1, i, 0.029999999999999999D);
    }

    public static BloomFilter create(Funnel funnel1, int i, double d)
    {
        boolean flag = true;
        Preconditions.checkNotNull(funnel1);
        int j;
        boolean flag1;
        if (i >= 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Preconditions.checkArgument(flag1, "Expected insertions cannot be negative");
        if (d > 0.0D)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (d >= 1.0D)
        {
            flag = false;
        }
        Preconditions.checkArgument(j & flag, "False positive probability in (0.0, 1.0)");
        j = i;
        if (i == 0)
        {
            j = 1;
        }
        i = optimalNumOfBits(j, d);
        j = optimalNumOfHashFunctions(j, i);
        return new BloomFilter(new BloomFilterStrategies.BitArray(i), j, funnel1, BloomFilterStrategies.MURMUR128_MITZ_32);
    }

    static int optimalNumOfBits(int i, double d)
    {
        return (int)(((double)(-i) * Math.log(d)) / LN2_SQUARED);
    }

    static int optimalNumOfHashFunctions(int i, int j)
    {
        return Math.max(1, (int)Math.round((double)(j / i) * LN2));
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof BloomFilter)
        {
            obj = (BloomFilter)obj;
            flag = flag1;
            if (numHashFunctions == ((BloomFilter) (obj)).numHashFunctions)
            {
                flag = flag1;
                if (bits.equals(((BloomFilter) (obj)).bits))
                {
                    flag = flag1;
                    if (funnel == ((BloomFilter) (obj)).funnel)
                    {
                        flag = flag1;
                        if (strategy == ((BloomFilter) (obj)).strategy)
                        {
                            flag = true;
                        }
                    }
                }
            }
        }
        return flag;
    }

    public double expectedFalsePositiveProbability()
    {
        return Math.pow((double)bits.bitCount() / (double)bits.size(), numHashFunctions);
    }

    public int hashCode()
    {
        return bits.hashCode();
    }

    public boolean mightContain(Object obj)
    {
        return strategy.mightContain(obj, funnel, numHashFunctions, bits);
    }

    static 
    {
        LN2 = Math.log(2D);
        LN2_SQUARED = LN2 * LN2;
    }
}
