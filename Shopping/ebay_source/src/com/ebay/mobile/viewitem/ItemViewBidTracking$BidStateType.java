// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;


// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewBidTracking

public static final class  extends Enum
{

    private static final BO $VALUES[];
    public static final BO BID;
    public static final BO BIN;
    public static final BO BO;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/viewitem/ItemViewBidTracking$BidStateType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        BID = new <init>("BID", 0);
        BIN = new <init>("BIN", 1);
        BO = new <init>("BO", 2);
        $VALUES = (new .VALUES[] {
            BID, BIN, BO
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
