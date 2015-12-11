// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;


// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ViewItemTitleAndPriceFragment

private static final class  extends Enum
{

    private static final BID $VALUES[];
    public static final BID BID;
    public static final BID BIN;
    public static final BID LISTING_TYPE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/viewitem/fragments/ViewItemTitleAndPriceFragment$EbayLayoutType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LISTING_TYPE = new <init>("LISTING_TYPE", 0);
        BIN = new <init>("BIN", 1);
        BID = new <init>("BID", 2);
        $VALUES = (new .VALUES[] {
            LISTING_TYPE, BIN, BID
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
