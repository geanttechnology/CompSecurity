// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.Arrays;

// Referenced classes of package com.google.common.hash:
//            BloomFilterStrategies

static class bitCount
{

    int bitCount;
    final long data[];

    int bitCount()
    {
        return bitCount;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof bitCount)
        {
            obj = (bitCount)obj;
            return Arrays.equals(data, ((data) (obj)).data);
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

    (int i)
    {
        this(new long[IntMath.divide(i, 64, RoundingMode.CEILING)]);
    }

    <init>(long al[])
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
