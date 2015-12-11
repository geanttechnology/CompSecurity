// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final ENDED_WITH_BUY_IT_NOW $VALUES[];
    public static final ENDED_WITH_BUY_IT_NOW ENDED_BY_ADMIN;
    public static final ENDED_WITH_BUY_IT_NOW ENDED_BY_SELLER;
    public static final ENDED_WITH_BUY_IT_NOW ENDED_WITH_AUCTION;
    public static final ENDED_WITH_BUY_IT_NOW ENDED_WITH_BEST_OFFER;
    public static final ENDED_WITH_BUY_IT_NOW ENDED_WITH_BUY_IT_NOW;
    public static final ENDED_WITH_BUY_IT_NOW ENDED_WITH_EXPIRATION;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$EndReasonEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ENDED_BY_ADMIN = new <init>("ENDED_BY_ADMIN", 0);
        ENDED_BY_SELLER = new <init>("ENDED_BY_SELLER", 1);
        ENDED_WITH_EXPIRATION = new <init>("ENDED_WITH_EXPIRATION", 2);
        ENDED_WITH_AUCTION = new <init>("ENDED_WITH_AUCTION", 3);
        ENDED_WITH_BEST_OFFER = new <init>("ENDED_WITH_BEST_OFFER", 4);
        ENDED_WITH_BUY_IT_NOW = new <init>("ENDED_WITH_BUY_IT_NOW", 5);
        $VALUES = (new .VALUES[] {
            ENDED_BY_ADMIN, ENDED_BY_SELLER, ENDED_WITH_EXPIRATION, ENDED_WITH_AUCTION, ENDED_WITH_BEST_OFFER, ENDED_WITH_BUY_IT_NOW
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
