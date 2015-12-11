// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;


// Referenced classes of package com.poshmark.utils:
//            DeepLinkUtils

public static final class  extends Enum
{

    private static final FIND_PEOPLE $VALUES[];
    public static final FIND_PEOPLE ACCOUNT;
    public static final FIND_PEOPLE BRAND_PAGE;
    public static final FIND_PEOPLE BRAND_PICKER;
    public static final FIND_PEOPLE CLOSET;
    public static final FIND_PEOPLE EXPANDED_MIFU;
    public static final FIND_PEOPLE FIND_PEOPLE;
    public static final FIND_PEOPLE INVALID;
    public static final FIND_PEOPLE LISTING_DETAILS;
    public static final FIND_PEOPLE MAPP_PAGE;
    public static final FIND_PEOPLE MYBUNDLES;
    public static final FIND_PEOPLE MYLIKES;
    public static final FIND_PEOPLE NEWS;
    public static final FIND_PEOPLE PARTIES;
    public static final FIND_PEOPLE PARTY;
    public static final FIND_PEOPLE SEARCH_BRAND;
    public static final FIND_PEOPLE SEARCH_CATEGORY;
    public static final FIND_PEOPLE SEARCH_KEYWORD;
    public static final FIND_PEOPLE SELL;
    public static final FIND_PEOPLE SHARES;
    public static final FIND_PEOPLE SHOP;
    public static final FIND_PEOPLE SHOWROOM;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        INVALID = new <init>("INVALID", 0);
        SHOP = new <init>("SHOP", 1);
        PARTIES = new <init>("PARTIES", 2);
        SELL = new <init>("SELL", 3);
        NEWS = new <init>("NEWS", 4);
        ACCOUNT = new <init>("ACCOUNT", 5);
        CLOSET = new <init>("CLOSET", 6);
        LISTING_DETAILS = new <init>("LISTING_DETAILS", 7);
        PARTY = new <init>("PARTY", 8);
        SHOWROOM = new <init>("SHOWROOM", 9);
        SHARES = new <init>("SHARES", 10);
        MYLIKES = new <init>("MYLIKES", 11);
        MYBUNDLES = new <init>("MYBUNDLES", 12);
        EXPANDED_MIFU = new <init>("EXPANDED_MIFU", 13);
        SEARCH_KEYWORD = new <init>("SEARCH_KEYWORD", 14);
        SEARCH_CATEGORY = new <init>("SEARCH_CATEGORY", 15);
        SEARCH_BRAND = new <init>("SEARCH_BRAND", 16);
        MAPP_PAGE = new <init>("MAPP_PAGE", 17);
        BRAND_PICKER = new <init>("BRAND_PICKER", 18);
        BRAND_PAGE = new <init>("BRAND_PAGE", 19);
        FIND_PEOPLE = new <init>("FIND_PEOPLE", 20);
        $VALUES = (new .VALUES[] {
            INVALID, SHOP, PARTIES, SELL, NEWS, ACCOUNT, CLOSET, LISTING_DETAILS, PARTY, SHOWROOM, 
            SHARES, MYLIKES, MYBUNDLES, EXPANDED_MIFU, SEARCH_KEYWORD, SEARCH_CATEGORY, SEARCH_BRAND, MAPP_PAGE, BRAND_PICKER, BRAND_PAGE, 
            FIND_PEOPLE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
