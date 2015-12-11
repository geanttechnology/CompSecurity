// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.cos.base;


public final class WorldRegionEnum extends Enum
{

    private static final WorldRegionEnum $VALUES[];
    public static final WorldRegionEnum AFRICA;
    public static final WorldRegionEnum AMERICAS;
    public static final WorldRegionEnum ASIA;
    public static final WorldRegionEnum CARIBBEAN;
    public static final WorldRegionEnum CENTRALAMERICA;
    public static final WorldRegionEnum EUROPE;
    public static final WorldRegionEnum EUROPEANUNION;
    public static final WorldRegionEnum LATINAMERICA;
    public static final WorldRegionEnum MIDDLEEAST;
    public static final WorldRegionEnum NORTHAMERICA;
    public static final WorldRegionEnum OCEANIA;
    public static final WorldRegionEnum SOUTHAMERICA;
    public static final WorldRegionEnum SOUTHEASTASIA;
    public static final WorldRegionEnum UNKNOWN;

    private WorldRegionEnum(String s, int i)
    {
        super(s, i);
    }

    public static WorldRegionEnum valueOf(String s)
    {
        return (WorldRegionEnum)Enum.valueOf(com/ebay/nautilus/domain/data/cos/base/WorldRegionEnum, s);
    }

    public static WorldRegionEnum[] values()
    {
        return (WorldRegionEnum[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new WorldRegionEnum("UNKNOWN", 0);
        AFRICA = new WorldRegionEnum("AFRICA", 1);
        AMERICAS = new WorldRegionEnum("AMERICAS", 2);
        ASIA = new WorldRegionEnum("ASIA", 3);
        CARIBBEAN = new WorldRegionEnum("CARIBBEAN", 4);
        CENTRALAMERICA = new WorldRegionEnum("CENTRALAMERICA", 5);
        EUROPE = new WorldRegionEnum("EUROPE", 6);
        EUROPEANUNION = new WorldRegionEnum("EUROPEANUNION", 7);
        LATINAMERICA = new WorldRegionEnum("LATINAMERICA", 8);
        MIDDLEEAST = new WorldRegionEnum("MIDDLEEAST", 9);
        NORTHAMERICA = new WorldRegionEnum("NORTHAMERICA", 10);
        OCEANIA = new WorldRegionEnum("OCEANIA", 11);
        SOUTHAMERICA = new WorldRegionEnum("SOUTHAMERICA", 12);
        SOUTHEASTASIA = new WorldRegionEnum("SOUTHEASTASIA", 13);
        $VALUES = (new WorldRegionEnum[] {
            UNKNOWN, AFRICA, AMERICAS, ASIA, CARIBBEAN, CENTRALAMERICA, EUROPE, EUROPEANUNION, LATINAMERICA, MIDDLEEAST, 
            NORTHAMERICA, OCEANIA, SOUTHAMERICA, SOUTHEASTASIA
        });
    }
}
