// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;


public final class CosVersionType extends Enum
{

    private static final CosVersionType $VALUES[];
    public static final CosVersionType V1;
    public static final CosVersionType V2;
    public static final CosVersionType V3;

    private CosVersionType(String s, int i)
    {
        super(s, i);
    }

    public static CosVersionType valueOf(String s)
    {
        return (CosVersionType)Enum.valueOf(com/ebay/nautilus/domain/net/CosVersionType, s);
    }

    public static CosVersionType[] values()
    {
        return (CosVersionType[])$VALUES.clone();
    }

    public boolean minimumOf(CosVersionType cosversiontype)
    {
        return compareTo(cosversiontype) >= 0;
    }

    static 
    {
        V1 = new CosVersionType("V1", 0);
        V2 = new CosVersionType("V2", 1);
        V3 = new CosVersionType("V3", 2);
        $VALUES = (new CosVersionType[] {
            V1, V2, V3
        });
    }
}
