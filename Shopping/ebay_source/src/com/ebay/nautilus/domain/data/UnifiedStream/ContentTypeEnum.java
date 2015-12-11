// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;


public final class ContentTypeEnum extends Enum
{

    private static final ContentTypeEnum $VALUES[];
    public static final ContentTypeEnum ACTIVE;
    public static final ContentTypeEnum BUYING_SUMMARY;
    public static final ContentTypeEnum CATEGORY;
    public static final ContentTypeEnum COLLECTION;
    public static final ContentTypeEnum DEALS_CATEGORY;
    public static final ContentTypeEnum DEPARTMENT;
    public static final ContentTypeEnum FEED_EVENT;
    public static final ContentTypeEnum FOLLOW;
    public static final ContentTypeEnum GROUPED;
    public static final ContentTypeEnum IMAGE_LIST_TEMPLATE;
    public static final ContentTypeEnum IMAGE_TEMPLATE;
    public static final ContentTypeEnum LISTING;
    public static final ContentTypeEnum NOTIFICATION;
    public static final ContentTypeEnum RPP_EVENT_GROUP;
    public static final ContentTypeEnum RTM_CAMPAIGN;
    public static final ContentTypeEnum SELLING_SUMMARY;
    public static final ContentTypeEnum SINGLE;
    public static final ContentTypeEnum SOLD;
    public static final ContentTypeEnum TOPIC;
    public static final ContentTypeEnum UNSOLD;

    private ContentTypeEnum(String s, int i)
    {
        super(s, i);
    }

    public static ContentTypeEnum valueOf(String s)
    {
        return (ContentTypeEnum)Enum.valueOf(com/ebay/nautilus/domain/data/UnifiedStream/ContentTypeEnum, s);
    }

    public static ContentTypeEnum[] values()
    {
        return (ContentTypeEnum[])$VALUES.clone();
    }

    static 
    {
        RTM_CAMPAIGN = new ContentTypeEnum("RTM_CAMPAIGN", 0);
        DEALS_CATEGORY = new ContentTypeEnum("DEALS_CATEGORY", 1);
        LISTING = new ContentTypeEnum("LISTING", 2);
        FEED_EVENT = new ContentTypeEnum("FEED_EVENT", 3);
        COLLECTION = new ContentTypeEnum("COLLECTION", 4);
        RPP_EVENT_GROUP = new ContentTypeEnum("RPP_EVENT_GROUP", 5);
        CATEGORY = new ContentTypeEnum("CATEGORY", 6);
        DEPARTMENT = new ContentTypeEnum("DEPARTMENT", 7);
        NOTIFICATION = new ContentTypeEnum("NOTIFICATION", 8);
        BUYING_SUMMARY = new ContentTypeEnum("BUYING_SUMMARY", 9);
        SELLING_SUMMARY = new ContentTypeEnum("SELLING_SUMMARY", 10);
        FOLLOW = new ContentTypeEnum("FOLLOW", 11);
        IMAGE_TEMPLATE = new ContentTypeEnum("IMAGE_TEMPLATE", 12);
        IMAGE_LIST_TEMPLATE = new ContentTypeEnum("IMAGE_LIST_TEMPLATE", 13);
        ACTIVE = new ContentTypeEnum("ACTIVE", 14);
        SOLD = new ContentTypeEnum("SOLD", 15);
        UNSOLD = new ContentTypeEnum("UNSOLD", 16);
        SINGLE = new ContentTypeEnum("SINGLE", 17);
        GROUPED = new ContentTypeEnum("GROUPED", 18);
        TOPIC = new ContentTypeEnum("TOPIC", 19);
        $VALUES = (new ContentTypeEnum[] {
            RTM_CAMPAIGN, DEALS_CATEGORY, LISTING, FEED_EVENT, COLLECTION, RPP_EVENT_GROUP, CATEGORY, DEPARTMENT, NOTIFICATION, BUYING_SUMMARY, 
            SELLING_SUMMARY, FOLLOW, IMAGE_TEMPLATE, IMAGE_LIST_TEMPLATE, ACTIVE, SOLD, UNSOLD, SINGLE, GROUPED, TOPIC
        });
    }
}
