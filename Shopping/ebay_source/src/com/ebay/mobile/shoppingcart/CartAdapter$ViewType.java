// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.shoppingcart;


// Referenced classes of package com.ebay.mobile.shoppingcart:
//            CartAdapter

private static final class layoutResourceId extends Enum
{

    private static final VIEW_TYPE_TOTALS $VALUES[];
    public static final VIEW_TYPE_TOTALS VIEW_TYPE_ITEM;
    public static final VIEW_TYPE_TOTALS VIEW_TYPE_PROMOTION;
    public static final VIEW_TYPE_TOTALS VIEW_TYPE_SELLER;
    public static final VIEW_TYPE_TOTALS VIEW_TYPE_TOTALS;
    public static final VIEW_TYPE_TOTALS VIEW_TYPE_UNKNOWN;
    final boolean isSelectable;
    final int layoutResourceId;

    public static layoutResourceId valueOf(String s)
    {
        return (layoutResourceId)Enum.valueOf(com/ebay/mobile/shoppingcart/CartAdapter$ViewType, s);
    }

    public static layoutResourceId[] values()
    {
        return (layoutResourceId[])$VALUES.clone();
    }

    static 
    {
        VIEW_TYPE_UNKNOWN = new <init>("VIEW_TYPE_UNKNOWN", 0, 0x1090003, false);
        VIEW_TYPE_ITEM = new <init>("VIEW_TYPE_ITEM", 1, 0x7f030246, true);
        VIEW_TYPE_SELLER = new <init>("VIEW_TYPE_SELLER", 2, 0x7f030248, false);
        VIEW_TYPE_PROMOTION = new <init>("VIEW_TYPE_PROMOTION", 3, 0x7f030247, true);
        VIEW_TYPE_TOTALS = new <init>("VIEW_TYPE_TOTALS", 4, 0x7f03024a, false);
        $VALUES = (new .VALUES[] {
            VIEW_TYPE_UNKNOWN, VIEW_TYPE_ITEM, VIEW_TYPE_SELLER, VIEW_TYPE_PROMOTION, VIEW_TYPE_TOTALS
        });
    }

    private (String s, int i, int j, boolean flag)
    {
        super(s, i);
        isSelectable = flag;
        layoutResourceId = j;
    }
}
