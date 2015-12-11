// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.cos.trading;


public final class PurchaseOptionEnum extends Enum
{

    private static final PurchaseOptionEnum $VALUES[];
    public static final PurchaseOptionEnum ADD_TO_CART;
    public static final PurchaseOptionEnum AUCTION;
    public static final PurchaseOptionEnum BEST_OFFER;
    public static final PurchaseOptionEnum BUY_IT_NOW;
    public static final PurchaseOptionEnum UNKNOWN;

    private PurchaseOptionEnum(String s, int i)
    {
        super(s, i);
    }

    public static PurchaseOptionEnum valueOf(String s)
    {
        return (PurchaseOptionEnum)Enum.valueOf(com/ebay/nautilus/domain/data/cos/trading/PurchaseOptionEnum, s);
    }

    public static PurchaseOptionEnum[] values()
    {
        return (PurchaseOptionEnum[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new PurchaseOptionEnum("UNKNOWN", 0);
        AUCTION = new PurchaseOptionEnum("AUCTION", 1);
        BUY_IT_NOW = new PurchaseOptionEnum("BUY_IT_NOW", 2);
        BEST_OFFER = new PurchaseOptionEnum("BEST_OFFER", 3);
        ADD_TO_CART = new PurchaseOptionEnum("ADD_TO_CART", 4);
        $VALUES = (new PurchaseOptionEnum[] {
            UNKNOWN, AUCTION, BUY_IT_NOW, BEST_OFFER, ADD_TO_CART
        });
    }
}
