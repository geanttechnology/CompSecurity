// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.util.Arrays;

// Referenced classes of package com.google.common.hash:
//            AbstractCompositeHashFunction, Hashing, HashFunction, Hasher, 
//            HashCode

private static final class <init> extends AbstractCompositeHashFunction
{

    private final int bits;

    public int bits()
    {
        return bits;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof bits)
        {
            obj = (bits)obj;
            return Arrays.equals(functions, ((functions) (obj)).functions);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return Arrays.hashCode(functions) * 31 + bits;
    }

    HashCode makeHash(Hasher ahasher[])
    {
        byte abyte0[] = new byte[bits / 8];
        int j = 0;
        int k = ahasher.length;
        for (int i = 0; i < k; i++)
        {
            HashCode hashcode = ahasher[i].hash();
            j += hashcode.writeBytesTo(abyte0, j, hashcode.bits() / 8);
        }

        return HashCode.fromBytesNoCopy(abyte0);
    }

    private transient (HashFunction ahashfunction[])
    {
        super(ahashfunction);
        int j = 0;
        int k = ahashfunction.length;
        int i = 0;
        while (i < k) 
        {
            HashFunction hashfunction = ahashfunction[i];
            j += hashfunction.bits();
            boolean flag;
            if (hashfunction.bits() % 8 == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "the number of bits (%s) in hashFunction (%s) must be divisible by 8", new Object[] {
                Integer.valueOf(hashfunction.bits()), hashfunction
            });
            i++;
        }
        bits = j;
    }

    bits(HashFunction ahashfunction[], bits bits1)
    {
        this(ahashfunction);
    }
}
