// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.checkout.summary;


public final class SummaryItemType extends Enum
{

    private static final SummaryItemType $VALUES[];
    public static final SummaryItemType DEDUCTION;
    public static final SummaryItemType DISCOUNT;
    public static final SummaryItemType DONATION_AMOUNT;
    public static final SummaryItemType ELECTRONIC_FEE;
    public static final SummaryItemType IMPORT_CHARGE;
    public static final SummaryItemType SALES_TAX;
    public static final SummaryItemType SHIPPING;
    public static final SummaryItemType SHIPPING_INSURANCE;
    public static final SummaryItemType SUB_TOTAL;
    public static final SummaryItemType TIRE_RECYCLE_FEE;
    public static final SummaryItemType TOTAL;

    private SummaryItemType(String s, int i)
    {
        super(s, i);
    }

    public static SummaryItemType valueOf(String s)
    {
        return (SummaryItemType)Enum.valueOf(com/ebay/nautilus/domain/data/experience/checkout/summary/SummaryItemType, s);
    }

    public static SummaryItemType[] values()
    {
        return (SummaryItemType[])$VALUES.clone();
    }

    static 
    {
        SUB_TOTAL = new SummaryItemType("SUB_TOTAL", 0);
        SHIPPING = new SummaryItemType("SHIPPING", 1);
        SALES_TAX = new SummaryItemType("SALES_TAX", 2);
        DISCOUNT = new SummaryItemType("DISCOUNT", 3);
        IMPORT_CHARGE = new SummaryItemType("IMPORT_CHARGE", 4);
        ELECTRONIC_FEE = new SummaryItemType("ELECTRONIC_FEE", 5);
        TIRE_RECYCLE_FEE = new SummaryItemType("TIRE_RECYCLE_FEE", 6);
        SHIPPING_INSURANCE = new SummaryItemType("SHIPPING_INSURANCE", 7);
        DONATION_AMOUNT = new SummaryItemType("DONATION_AMOUNT", 8);
        DEDUCTION = new SummaryItemType("DEDUCTION", 9);
        TOTAL = new SummaryItemType("TOTAL", 10);
        $VALUES = (new SummaryItemType[] {
            SUB_TOTAL, SHIPPING, SALES_TAX, DISCOUNT, IMPORT_CHARGE, ELECTRONIC_FEE, TIRE_RECYCLE_FEE, SHIPPING_INSURANCE, DONATION_AMOUNT, DEDUCTION, 
            TOTAL
        });
    }
}
