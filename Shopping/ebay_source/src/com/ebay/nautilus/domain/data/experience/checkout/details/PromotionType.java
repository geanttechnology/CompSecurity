// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.checkout.details;


public final class PromotionType extends Enum
{

    private static final PromotionType $VALUES[];
    public static final PromotionType ITEM;
    public static final PromotionType LEGACY_LOGISTICS;
    public static final PromotionType LOGISTICS;
    public static final PromotionType PAYPAL_CREDIT;
    public static final PromotionType UNKNOWN;

    private PromotionType(String s, int i)
    {
        super(s, i);
    }

    public static PromotionType valueOf(String s)
    {
        return (PromotionType)Enum.valueOf(com/ebay/nautilus/domain/data/experience/checkout/details/PromotionType, s);
    }

    public static PromotionType[] values()
    {
        return (PromotionType[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new PromotionType("UNKNOWN", 0);
        ITEM = new PromotionType("ITEM", 1);
        LOGISTICS = new PromotionType("LOGISTICS", 2);
        PAYPAL_CREDIT = new PromotionType("PAYPAL_CREDIT", 3);
        LEGACY_LOGISTICS = new PromotionType("LEGACY_LOGISTICS", 4);
        $VALUES = (new PromotionType[] {
            UNKNOWN, ITEM, LOGISTICS, PAYPAL_CREDIT, LEGACY_LOGISTICS
        });
    }
}
