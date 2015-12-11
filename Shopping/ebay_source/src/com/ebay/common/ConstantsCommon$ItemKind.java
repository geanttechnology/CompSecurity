// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;


// Referenced classes of package com.ebay.common:
//            ConstantsCommon

public static final class  extends Enum
{

    private static final Unknown $VALUES[];
    public static final Unknown Bidding;
    public static final Unknown CustomList;
    public static final Unknown Deals;
    public static final Unknown Found;
    public static final Unknown Lost;
    public static final Unknown RecentlyViewed;
    public static final Unknown Scheduled;
    public static final Unknown SellersOther;
    public static final Unknown Selling;
    public static final Unknown Selling_Offers;
    public static final Unknown Sold;
    public static final Unknown Unknown;
    public static final Unknown Unsold;
    public static final Unknown Watched;
    public static final Unknown WishList;
    public static final Unknown Won;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/common/ConstantsCommon$ItemKind, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Found = new <init>("Found", 0);
        Deals = new <init>("Deals", 1);
        SellersOther = new <init>("SellersOther", 2);
        Watched = new <init>("Watched", 3);
        Bidding = new <init>("Bidding", 4);
        Won = new <init>("Won", 5);
        Lost = new <init>("Lost", 6);
        Scheduled = new <init>("Scheduled", 7);
        Selling = new <init>("Selling", 8);
        Sold = new <init>("Sold", 9);
        Unsold = new <init>("Unsold", 10);
        Selling_Offers = new <init>("Selling_Offers", 11);
        WishList = new <init>("WishList", 12);
        CustomList = new <init>("CustomList", 13);
        RecentlyViewed = new <init>("RecentlyViewed", 14);
        Unknown = new <init>("Unknown", 15);
        $VALUES = (new .VALUES[] {
            Found, Deals, SellersOther, Watched, Bidding, Won, Lost, Scheduled, Selling, Sold, 
            Unsold, Selling_Offers, WishList, CustomList, RecentlyViewed, Unknown
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
