// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.product;


public final class i extends Enum
{

    private static final i $VALUES[];
    public static final i CurrentlyNotOnSale;
    public static final i InStock;
    public static final i LimitedStock;
    public static final i NotAvailable;
    public static final i NotSoldInThisStore;
    public static final i OnBackorder;
    public static final i OutOfStock;
    public static final i PreOrder;
    public static final i PreOrderNonSellable;
    public static final i UNKNOWN;
    public static final i UnAvailable;

    private i(String s, int j)
    {
        super(s, j);
    }

    public static i valueOf(String s)
    {
        return (i)Enum.valueOf(com/target/mothership/common/product/i, s);
    }

    public static i[] values()
    {
        return (i[])$VALUES.clone();
    }

    static 
    {
        InStock = new i("InStock", 0);
        LimitedStock = new i("LimitedStock", 1);
        OnBackorder = new i("OnBackorder", 2);
        PreOrder = new i("PreOrder", 3);
        PreOrderNonSellable = new i("PreOrderNonSellable", 4);
        OutOfStock = new i("OutOfStock", 5);
        UnAvailable = new i("UnAvailable", 6);
        NotAvailable = new i("NotAvailable", 7);
        CurrentlyNotOnSale = new i("CurrentlyNotOnSale", 8);
        NotSoldInThisStore = new i("NotSoldInThisStore", 9);
        UNKNOWN = new i("UNKNOWN", 10);
        $VALUES = (new i[] {
            InStock, LimitedStock, OnBackorder, PreOrder, PreOrderNonSellable, OutOfStock, UnAvailable, NotAvailable, CurrentlyNotOnSale, NotSoldInThisStore, 
            UNKNOWN
        });
    }
}
