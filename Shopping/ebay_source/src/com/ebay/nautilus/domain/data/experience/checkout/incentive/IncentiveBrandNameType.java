// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.checkout.incentive;


public final class IncentiveBrandNameType extends Enum
{

    private static final IncentiveBrandNameType $VALUES[];
    public static final IncentiveBrandNameType BUCKS;
    public static final IncentiveBrandNameType CREDITS;
    public static final IncentiveBrandNameType NECTAR;
    public static final IncentiveBrandNameType UNKNOWN;

    private IncentiveBrandNameType(String s, int i)
    {
        super(s, i);
    }

    public static IncentiveBrandNameType valueOf(String s)
    {
        return (IncentiveBrandNameType)Enum.valueOf(com/ebay/nautilus/domain/data/experience/checkout/incentive/IncentiveBrandNameType, s);
    }

    public static IncentiveBrandNameType[] values()
    {
        return (IncentiveBrandNameType[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new IncentiveBrandNameType("UNKNOWN", 0);
        BUCKS = new IncentiveBrandNameType("BUCKS", 1);
        NECTAR = new IncentiveBrandNameType("NECTAR", 2);
        CREDITS = new IncentiveBrandNameType("CREDITS", 3);
        $VALUES = (new IncentiveBrandNameType[] {
            UNKNOWN, BUCKS, NECTAR, CREDITS
        });
    }
}
