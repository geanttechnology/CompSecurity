// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.checkout.details;


public final class LineItemType extends Enum
{

    private static final LineItemType $VALUES[];
    public static final LineItemType SELLER_CREATED_ORDER;
    public static final LineItemType SINGLE_TRANSACTION;
    public static final LineItemType UNKNOWN;

    private LineItemType(String s, int i)
    {
        super(s, i);
    }

    public static LineItemType valueOf(String s)
    {
        return (LineItemType)Enum.valueOf(com/ebay/nautilus/domain/data/experience/checkout/details/LineItemType, s);
    }

    public static LineItemType[] values()
    {
        return (LineItemType[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new LineItemType("UNKNOWN", 0);
        SINGLE_TRANSACTION = new LineItemType("SINGLE_TRANSACTION", 1);
        SELLER_CREATED_ORDER = new LineItemType("SELLER_CREATED_ORDER", 2);
        $VALUES = (new LineItemType[] {
            UNKNOWN, SINGLE_TRANSACTION, SELLER_CREATED_ORDER
        });
    }
}
