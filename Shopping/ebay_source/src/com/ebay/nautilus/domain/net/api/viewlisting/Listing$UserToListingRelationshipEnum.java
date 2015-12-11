// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final BEST_OFFER_BUYER $VALUES[];
    public static final BEST_OFFER_BUYER BEST_OFFER_BUYER;
    public static final BEST_OFFER_BUYER HIGH_BIDDER;
    public static final BEST_OFFER_BUYER MULTI_BUYER;
    public static final BEST_OFFER_BUYER NONE;
    public static final BEST_OFFER_BUYER OUT_BIDDER;
    public static final BEST_OFFER_BUYER SELLER;
    public static final BEST_OFFER_BUYER SINGLE_BUYER;
    public static final BEST_OFFER_BUYER WIN_POST_OWNER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$UserToListingRelationshipEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        SELLER = new <init>("SELLER", 1);
        HIGH_BIDDER = new <init>("HIGH_BIDDER", 2);
        SINGLE_BUYER = new <init>("SINGLE_BUYER", 3);
        MULTI_BUYER = new <init>("MULTI_BUYER", 4);
        OUT_BIDDER = new <init>("OUT_BIDDER", 5);
        WIN_POST_OWNER = new <init>("WIN_POST_OWNER", 6);
        BEST_OFFER_BUYER = new <init>("BEST_OFFER_BUYER", 7);
        $VALUES = (new .VALUES[] {
            NONE, SELLER, HIGH_BIDDER, SINGLE_BUYER, MULTI_BUYER, OUT_BIDDER, WIN_POST_OWNER, BEST_OFFER_BUYER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
