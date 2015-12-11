// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.events;


// Referenced classes of package com.ebay.mobile.events:
//            EventRefineFragment

protected static final class  extends Enum
{

    private static final PRICE_FILTER $VALUES[];
    public static final PRICE_FILTER CATEGORY_FILTER;
    public static final PRICE_FILTER PRICE_FILTER;
    public static final PRICE_FILTER SORT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/events/EventRefineFragment$RefinementType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SORT = new <init>("SORT", 0);
        CATEGORY_FILTER = new <init>("CATEGORY_FILTER", 1);
        PRICE_FILTER = new <init>("PRICE_FILTER", 2);
        $VALUES = (new .VALUES[] {
            SORT, CATEGORY_FILTER, PRICE_FILTER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
