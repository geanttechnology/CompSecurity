// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final SELL_ONE_LIKE $VALUES[];
    public static final SELL_ONE_LIKE ADD;
    public static final SELL_ONE_LIKE RELIST;
    public static final SELL_ONE_LIKE SELL_ONE_LIKE;
    public static final SELL_ONE_LIKE SELL_SIMILAR;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$ListingModeEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ADD = new <init>("ADD", 0);
        RELIST = new <init>("RELIST", 1);
        SELL_SIMILAR = new <init>("SELL_SIMILAR", 2);
        SELL_ONE_LIKE = new <init>("SELL_ONE_LIKE", 3);
        $VALUES = (new .VALUES[] {
            ADD, RELIST, SELL_SIMILAR, SELL_ONE_LIKE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
