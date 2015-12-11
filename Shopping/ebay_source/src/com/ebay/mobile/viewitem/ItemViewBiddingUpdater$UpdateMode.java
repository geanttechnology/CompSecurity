// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;


// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewBiddingUpdater

public static final class  extends Enum
{

    private static final POLLING $VALUES[];
    public static final POLLING NONE;
    public static final POLLING POLLING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/viewitem/ItemViewBiddingUpdater$UpdateMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        POLLING = new <init>("POLLING", 1);
        $VALUES = (new .VALUES[] {
            NONE, POLLING
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
