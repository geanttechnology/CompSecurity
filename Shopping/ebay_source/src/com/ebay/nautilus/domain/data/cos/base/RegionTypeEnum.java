// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.cos.base;


public final class RegionTypeEnum extends Enum
{

    private static final RegionTypeEnum $VALUES[];
    public static final RegionTypeEnum COUNTRY;
    public static final RegionTypeEnum COUNTRY_REGION;
    public static final RegionTypeEnum STATE_OR_PROVINCE;
    public static final RegionTypeEnum UNKNOWN;
    public static final RegionTypeEnum WORLDWIDE;
    public static final RegionTypeEnum WORLD_REGION;

    private RegionTypeEnum(String s, int i)
    {
        super(s, i);
    }

    public static RegionTypeEnum valueOf(String s)
    {
        return (RegionTypeEnum)Enum.valueOf(com/ebay/nautilus/domain/data/cos/base/RegionTypeEnum, s);
    }

    public static RegionTypeEnum[] values()
    {
        return (RegionTypeEnum[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new RegionTypeEnum("UNKNOWN", 0);
        COUNTRY_REGION = new RegionTypeEnum("COUNTRY_REGION", 1);
        STATE_OR_PROVINCE = new RegionTypeEnum("STATE_OR_PROVINCE", 2);
        COUNTRY = new RegionTypeEnum("COUNTRY", 3);
        WORLD_REGION = new RegionTypeEnum("WORLD_REGION", 4);
        WORLDWIDE = new RegionTypeEnum("WORLDWIDE", 5);
        $VALUES = (new RegionTypeEnum[] {
            UNKNOWN, COUNTRY_REGION, STATE_OR_PROVINCE, COUNTRY, WORLD_REGION, WORLDWIDE
        });
    }
}
