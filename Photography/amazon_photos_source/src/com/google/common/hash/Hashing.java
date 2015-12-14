// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.hash;


// Referenced classes of package com.google.common.hash:
//            Murmur3_32HashFunction, Murmur3_128HashFunction, MessageDigestHashFunction, HashFunction

public final class Hashing
{

    private static final HashFunction GOOD_FAST_HASH_FUNCTION_128;
    private static final HashFunction GOOD_FAST_HASH_FUNCTION_32;
    private static final int GOOD_FAST_HASH_SEED;
    private static final HashFunction MD5 = new MessageDigestHashFunction("MD5");
    private static final Murmur3_128HashFunction MURMUR3_128 = new Murmur3_128HashFunction(0);
    private static final Murmur3_32HashFunction MURMUR3_32 = new Murmur3_32HashFunction(0);
    private static final HashFunction SHA_1 = new MessageDigestHashFunction("SHA-1");
    private static final HashFunction SHA_256 = new MessageDigestHashFunction("SHA-256");
    private static final HashFunction SHA_512 = new MessageDigestHashFunction("SHA-512");

    public static HashFunction murmur3_128()
    {
        return MURMUR3_128;
    }

    public static HashFunction murmur3_128(int i)
    {
        return new Murmur3_128HashFunction(i);
    }

    public static HashFunction murmur3_32(int i)
    {
        return new Murmur3_32HashFunction(i);
    }

    static 
    {
        GOOD_FAST_HASH_SEED = (int)System.currentTimeMillis();
        GOOD_FAST_HASH_FUNCTION_32 = murmur3_32(GOOD_FAST_HASH_SEED);
        GOOD_FAST_HASH_FUNCTION_128 = murmur3_128(GOOD_FAST_HASH_SEED);
    }
}
