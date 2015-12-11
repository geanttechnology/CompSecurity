// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.checkout.protection;


public final class BuyerProtectionType extends Enum
{

    private static final BuyerProtectionType $VALUES[];
    public static final BuyerProtectionType BUYER_PROTECTION;
    public static final BuyerProtectionType MONEY_BACK_GUARANTEE;
    public static final BuyerProtectionType UNKNOWN;
    public static final BuyerProtectionType VEHICLE_PURCHASE_PROTECTION;

    private BuyerProtectionType(String s, int i)
    {
        super(s, i);
    }

    public static BuyerProtectionType valueOf(String s)
    {
        return (BuyerProtectionType)Enum.valueOf(com/ebay/nautilus/domain/data/experience/checkout/protection/BuyerProtectionType, s);
    }

    public static BuyerProtectionType[] values()
    {
        return (BuyerProtectionType[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new BuyerProtectionType("UNKNOWN", 0);
        BUYER_PROTECTION = new BuyerProtectionType("BUYER_PROTECTION", 1);
        MONEY_BACK_GUARANTEE = new BuyerProtectionType("MONEY_BACK_GUARANTEE", 2);
        VEHICLE_PURCHASE_PROTECTION = new BuyerProtectionType("VEHICLE_PURCHASE_PROTECTION", 3);
        $VALUES = (new BuyerProtectionType[] {
            UNKNOWN, BUYER_PROTECTION, MONEY_BACK_GUARANTEE, VEHICLE_PURCHASE_PROTECTION
        });
    }
}
