// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk;


public final class CacheLevel extends Enum
{

    private static final CacheLevel $VALUES[];
    public static final CacheLevel L1;
    public static final CacheLevel L2;

    private CacheLevel(String s, int i)
    {
        super(s, i);
    }

    public static CacheLevel valueOf(String s)
    {
        return (CacheLevel)Enum.valueOf(com/amazon/avod/sdk/CacheLevel, s);
    }

    public static CacheLevel[] values()
    {
        return (CacheLevel[])$VALUES.clone();
    }

    static 
    {
        L1 = new CacheLevel("L1", 0);
        L2 = new CacheLevel("L2", 1);
        $VALUES = (new CacheLevel[] {
            L1, L2
        });
    }
}
