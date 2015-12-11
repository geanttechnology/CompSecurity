// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShoppingCart

public static final class isRemoveable extends Enum
{

    private static final HAS_REVISIONS $VALUES[];
    public static final HAS_REVISIONS ENDED;
    public static final HAS_REVISIONS ENDING_SOON;
    public static final HAS_REVISIONS HAS_REVISIONS;
    public static final HAS_REVISIONS LAST_ONE;
    public static final HAS_REVISIONS NOT_AVAILABLE;
    public static final HAS_REVISIONS PAY_NOW;
    public static final HAS_REVISIONS SELLER_ON_VACATION;
    public static final HAS_REVISIONS UNKNOWN;
    public static final HAS_REVISIONS UP_FOR_AUCTION;
    public static final HAS_REVISIONS WON;
    public final boolean isCartable;
    public final boolean isRemoveable;
    public final boolean isSaveable;

    public static isRemoveable valueOf(String s)
    {
        return (isRemoveable)Enum.valueOf(com/ebay/nautilus/domain/data/ShoppingCart$Item$Status, s);
    }

    public static isRemoveable[] values()
    {
        return (isRemoveable[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0, true, true, true);
        SELLER_ON_VACATION = new <init>("SELLER_ON_VACATION", 1, true, true, true);
        PAY_NOW = new <init>("PAY_NOW", 2, true, true, false);
        WON = new <init>("WON", 3, true, true, false);
        ENDED = new <init>("ENDED", 4, false, false, true);
        UP_FOR_AUCTION = new <init>("UP_FOR_AUCTION", 5, false, false, true);
        NOT_AVAILABLE = new <init>("NOT_AVAILABLE", 6, false, true, true);
        ENDING_SOON = new <init>("ENDING_SOON", 7, true, true, true);
        LAST_ONE = new <init>("LAST_ONE", 8, true, true, true);
        HAS_REVISIONS = new <init>("HAS_REVISIONS", 9, true, true, true);
        $VALUES = (new .VALUES[] {
            UNKNOWN, SELLER_ON_VACATION, PAY_NOW, WON, ENDED, UP_FOR_AUCTION, NOT_AVAILABLE, ENDING_SOON, LAST_ONE, HAS_REVISIONS
        });
    }

    private (String s, int i, boolean flag, boolean flag1, boolean flag2)
    {
        super(s, i);
        isCartable = flag;
        isSaveable = flag1;
        isRemoveable = flag2;
    }
}
