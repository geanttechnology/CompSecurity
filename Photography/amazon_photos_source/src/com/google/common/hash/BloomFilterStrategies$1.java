// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.hash;


// Referenced classes of package com.google.common.hash:
//            BloomFilterStrategies, Hashing, HashFunction, Hasher, 
//            HashCode, Funnel

static final class nit> extends BloomFilterStrategies
{

    public boolean mightContain(Object obj, Funnel funnel, int i, tArray tarray)
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
            if (!tarray.get(k % tarray.size()))
            {
                return false;
            }
        }

        return true;
    }

    tArray(String s, int i)
    {
        super(s, i, null);
    }
}
