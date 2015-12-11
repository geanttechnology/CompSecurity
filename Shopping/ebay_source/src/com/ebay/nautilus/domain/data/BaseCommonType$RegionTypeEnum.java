// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            BaseCommonType

public static final class A extends Enum
{

    private static final WORLDWIDE $VALUES[];
    public static final WORLDWIDE COUNTRY;
    public static final WORLDWIDE COUNTRY_REGION;
    public static final WORLDWIDE STATE_OR_PROVINCE;
    public static final WORLDWIDE WORLDWIDE;
    public static final WORLDWIDE WORLD_REGION;

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/ebay/nautilus/domain/data/BaseCommonType$RegionTypeEnum, s);
    }

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    static 
    {
        COUNTRY_REGION = new <init>("COUNTRY_REGION", 0);
        STATE_OR_PROVINCE = new <init>("STATE_OR_PROVINCE", 1);
        COUNTRY = new <init>("COUNTRY", 2);
        WORLD_REGION = new <init>("WORLD_REGION", 3);
        WORLDWIDE = new <init>("WORLDWIDE", 4);
        $VALUES = (new .VALUES[] {
            COUNTRY_REGION, STATE_OR_PROVINCE, COUNTRY, WORLD_REGION, WORLDWIDE
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
