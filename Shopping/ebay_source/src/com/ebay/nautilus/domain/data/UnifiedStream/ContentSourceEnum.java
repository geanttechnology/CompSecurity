// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;


public final class ContentSourceEnum extends Enum
{

    private static final ContentSourceEnum $VALUES[];
    public static final ContentSourceEnum BROWSE_CATEGORY;
    public static final ContentSourceEnum BUYING_SELLING_OVERVIEW;
    public static final ContentSourceEnum DEALS;
    public static final ContentSourceEnum DEPARTMENT;
    public static final ContentSourceEnum EBAY_TODAY;
    public static final ContentSourceEnum FEATURED_CATEGORY;
    public static final ContentSourceEnum FEED;
    public static final ContentSourceEnum FOLLOW;
    public static final ContentSourceEnum LISTING_DRAFT;
    public static final ContentSourceEnum RECENTLY_VIEWED_ITEMS;
    public static final ContentSourceEnum RPP_EVENT;
    public static final ContentSourceEnum RTM;
    public static final ContentSourceEnum RTM2;
    public static final ContentSourceEnum SCHEDULED_LISTING;
    public static final ContentSourceEnum SELLERINSPIRATION_INSPIRATION;
    public static final ContentSourceEnum SELLERINSPIRATION_LISTANITEM;
    public static final ContentSourceEnum SELLING_UTILITY;
    public static final ContentSourceEnum SIGN_IN;
    public static final ContentSourceEnum TODO;
    public static final ContentSourceEnum TRENDING_COLLECTION;
    public static final ContentSourceEnum TRENDING_TOPIC;
    public static final ContentSourceEnum WATCHING;

    private ContentSourceEnum(String s, int i)
    {
        super(s, i);
    }

    public static ContentSourceEnum valueOf(String s)
    {
        return (ContentSourceEnum)Enum.valueOf(com/ebay/nautilus/domain/data/UnifiedStream/ContentSourceEnum, s);
    }

    public static ContentSourceEnum[] values()
    {
        return (ContentSourceEnum[])$VALUES.clone();
    }

    static 
    {
        RTM = new ContentSourceEnum("RTM", 0);
        RTM2 = new ContentSourceEnum("RTM2", 1);
        DEALS = new ContentSourceEnum("DEALS", 2);
        FEED = new ContentSourceEnum("FEED", 3);
        EBAY_TODAY = new ContentSourceEnum("EBAY_TODAY", 4);
        TRENDING_COLLECTION = new ContentSourceEnum("TRENDING_COLLECTION", 5);
        RPP_EVENT = new ContentSourceEnum("RPP_EVENT", 6);
        FOLLOW = new ContentSourceEnum("FOLLOW", 7);
        TRENDING_TOPIC = new ContentSourceEnum("TRENDING_TOPIC", 8);
        TODO = new ContentSourceEnum("TODO", 9);
        DEPARTMENT = new ContentSourceEnum("DEPARTMENT", 10);
        WATCHING = new ContentSourceEnum("WATCHING", 11);
        LISTING_DRAFT = new ContentSourceEnum("LISTING_DRAFT", 12);
        BUYING_SELLING_OVERVIEW = new ContentSourceEnum("BUYING_SELLING_OVERVIEW", 13);
        SELLING_UTILITY = new ContentSourceEnum("SELLING_UTILITY", 14);
        SELLERINSPIRATION_LISTANITEM = new ContentSourceEnum("SELLERINSPIRATION_LISTANITEM", 15);
        SELLERINSPIRATION_INSPIRATION = new ContentSourceEnum("SELLERINSPIRATION_INSPIRATION", 16);
        RECENTLY_VIEWED_ITEMS = new ContentSourceEnum("RECENTLY_VIEWED_ITEMS", 17);
        FEATURED_CATEGORY = new ContentSourceEnum("FEATURED_CATEGORY", 18);
        SCHEDULED_LISTING = new ContentSourceEnum("SCHEDULED_LISTING", 19);
        BROWSE_CATEGORY = new ContentSourceEnum("BROWSE_CATEGORY", 20);
        SIGN_IN = new ContentSourceEnum("SIGN_IN", 21);
        $VALUES = (new ContentSourceEnum[] {
            RTM, RTM2, DEALS, FEED, EBAY_TODAY, TRENDING_COLLECTION, RPP_EVENT, FOLLOW, TRENDING_TOPIC, TODO, 
            DEPARTMENT, WATCHING, LISTING_DRAFT, BUYING_SELLING_OVERVIEW, SELLING_UTILITY, SELLERINSPIRATION_LISTANITEM, SELLERINSPIRATION_INSPIRATION, RECENTLY_VIEWED_ITEMS, FEATURED_CATEGORY, SCHEDULED_LISTING, 
            BROWSE_CATEGORY, SIGN_IN
        });
    }
}
