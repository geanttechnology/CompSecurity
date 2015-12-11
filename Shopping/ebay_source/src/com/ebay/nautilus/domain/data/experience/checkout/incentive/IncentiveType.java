// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.checkout.incentive;


public final class IncentiveType extends Enum
{

    private static final IncentiveType $VALUES[];
    public static final IncentiveType BML;
    public static final IncentiveType COUPON;
    public static final IncentiveType GE_REWARDS_VOUCHER;
    public static final IncentiveType GIFT_CARD;
    public static final IncentiveType GIFT_CERTIFICATE;
    public static final IncentiveType INSTANT_CREDIT;
    public static final IncentiveType MERCHANT_GIFT_CERTIFICATE;
    public static final IncentiveType REWARD;
    public static final IncentiveType UNKNOWN;
    public static final IncentiveType VOUCHER;

    private IncentiveType(String s, int i)
    {
        super(s, i);
    }

    public static IncentiveType valueOf(String s)
    {
        return (IncentiveType)Enum.valueOf(com/ebay/nautilus/domain/data/experience/checkout/incentive/IncentiveType, s);
    }

    public static IncentiveType[] values()
    {
        return (IncentiveType[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new IncentiveType("UNKNOWN", 0);
        GIFT_CERTIFICATE = new IncentiveType("GIFT_CERTIFICATE", 1);
        VOUCHER = new IncentiveType("VOUCHER", 2);
        GIFT_CARD = new IncentiveType("GIFT_CARD", 3);
        COUPON = new IncentiveType("COUPON", 4);
        REWARD = new IncentiveType("REWARD", 5);
        MERCHANT_GIFT_CERTIFICATE = new IncentiveType("MERCHANT_GIFT_CERTIFICATE", 6);
        GE_REWARDS_VOUCHER = new IncentiveType("GE_REWARDS_VOUCHER", 7);
        BML = new IncentiveType("BML", 8);
        INSTANT_CREDIT = new IncentiveType("INSTANT_CREDIT", 9);
        $VALUES = (new IncentiveType[] {
            UNKNOWN, GIFT_CERTIFICATE, VOUCHER, GIFT_CARD, COUPON, REWARD, MERCHANT_GIFT_CERTIFICATE, GE_REWARDS_VOUCHER, BML, INSTANT_CREDIT
        });
    }
}
