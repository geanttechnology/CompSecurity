// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.a;


public final class a extends Enum
{

    private static final a $VALUES[];
    public static final a CART_ITEMS_CHANGED;
    public static final a CART_MERGE;
    public static final a CART_MERGE_OVERFLOW;
    public static final a CART_VIRTUAL_BUNDLE_ITEMS_CHANGED;
    public static final a INSUFFICIENT_INVENTORY;
    public static final a ITEM_REMOVED;
    public static final a ITEM_SAVED_FOR_LATER;
    public static final a MAX_PURCHASE_LIMIT;
    public static final a PRICE_DECREASE;
    public static final a PRICE_INCREASE;
    public static final a RUSH_DELIVERY_NOT_AVAILABLE;
    public static final a SOME_ITEMS_CHANGED;
    public static final a UNKNOWN;
    private String mValue;

    private a(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static a a(String s)
    {
        if (s != null)
        {
            a aa[] = values();
            int j = aa.length;
            for (int i = 0; i < j; i++)
            {
                a a1 = aa[i];
                if (s.equalsIgnoreCase(a1.mValue))
                {
                    return a1;
                }
            }

        }
        return UNKNOWN;
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/target/mothership/common/a/a, s);
    }

    public static a[] values()
    {
        return (a[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        RUSH_DELIVERY_NOT_AVAILABLE = new a("RUSH_DELIVERY_NOT_AVAILABLE", 0, "RD_SHIPMODE_DEFAULT_MSG");
        INSUFFICIENT_INVENTORY = new a("INSUFFICIENT_INVENTORY", 1, "SHOP_AVL_INV_ERROR_MSG");
        SOME_ITEMS_CHANGED = new a("SOME_ITEMS_CHANGED", 2, "SECOND_LOOK_NEW");
        CART_ITEMS_CHANGED = new a("CART_ITEMS_CHANGED", 3, "SECOND_LOOK#CART_ITEMS_CHANGED");
        CART_VIRTUAL_BUNDLE_ITEMS_CHANGED = new a("CART_VIRTUAL_BUNDLE_ITEMS_CHANGED", 4, "SECOND_LOOK_NEW#VIRTUALBUNDLE_ERROR_MSG#SAVED_ITEMS");
        CART_MERGE_OVERFLOW = new a("CART_MERGE_OVERFLOW", 5, "SECOND_LOOK_NEW#ERR_THRESHOLD_LINE_ITEMS");
        CART_MERGE = new a("CART_MERGE", 6, "MERGE_MSG_ESTORE");
        ITEM_REMOVED = new a("ITEM_REMOVED", 7, "ITEM_NOT_AVL_FOR_PURCHASE1#ITEM_NOT_AVL_FOR_PURCHASE");
        ITEM_SAVED_FOR_LATER = new a("ITEM_SAVED_FOR_LATER", 8, "BUY_ITEM#BUY_SAVE_FOR_LATER");
        MAX_PURCHASE_LIMIT = new a("MAX_PURCHASE_LIMIT", 9, "SHOP_MAX_PURCHASE_LIMIT");
        PRICE_DECREASE = new a("PRICE_DECREASE", 10, "PRICE_DECREASED_MSG#PRICE_CHANGE_TO_MSG");
        PRICE_INCREASE = new a("PRICE_INCREASE", 11, "PRICE_INCREASED_MSG#PRICE_CHANGE_TO_MSG");
        UNKNOWN = new a("UNKNOWN", 12, "");
        $VALUES = (new a[] {
            RUSH_DELIVERY_NOT_AVAILABLE, INSUFFICIENT_INVENTORY, SOME_ITEMS_CHANGED, CART_ITEMS_CHANGED, CART_VIRTUAL_BUNDLE_ITEMS_CHANGED, CART_MERGE_OVERFLOW, CART_MERGE, ITEM_REMOVED, ITEM_SAVED_FOR_LATER, MAX_PURCHASE_LIMIT, 
            PRICE_DECREASE, PRICE_INCREASE, UNKNOWN
        });
    }
}
