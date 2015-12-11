// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.loader;


public final class DataTypes extends Enum
{

    private static final DataTypes $VALUES[];
    public static final DataTypes COUPON;
    public static final DataTypes COUPON_CATEGORY;
    public static final DataTypes COUPON_HEADER;
    public static final DataTypes COUPON_MERCHANT;
    public static final DataTypes COUPON_TOP_ITEM_CONTAINER;
    public static final DataTypes DEAL_CARD;
    public static final DataTypes DEAL_DETAILS_WIDGET_SUMMARY;
    public static final DataTypes DEAL_SUMMARY;
    public static final DataTypes GROUPONICUS_STATIC_HEADER_VIEW;
    public static final DataTypes NEXT_PAGE_TRIGGER;
    public static final DataTypes OCCASIONS_DYNAMIC_HEADER_VIEW;
    public static final DataTypes PENDING_VIEW;
    public static final DataTypes SMALL_DEAL_CARD_LIST;
    public static final DataTypes TRACKING_HEADER;
    public static final DataTypes WIDGET_IMAGE_SUMMARY;
    public static final DataTypes WIDGET_SUMMARY;
    public static final DataTypes values[] = values();
    public final boolean spansAllColumns;

    private DataTypes(String s, int i, boolean flag)
    {
        super(s, i);
        spansAllColumns = flag;
    }

    public static DataTypes valueOf(String s)
    {
        return (DataTypes)Enum.valueOf(com/groupon/v3/loader/DataTypes, s);
    }

    public static DataTypes[] values()
    {
        return (DataTypes[])$VALUES.clone();
    }

    static 
    {
        DEAL_CARD = new DataTypes("DEAL_CARD", 0, false);
        PENDING_VIEW = new DataTypes("PENDING_VIEW", 1, true);
        GROUPONICUS_STATIC_HEADER_VIEW = new DataTypes("GROUPONICUS_STATIC_HEADER_VIEW", 2, true);
        OCCASIONS_DYNAMIC_HEADER_VIEW = new DataTypes("OCCASIONS_DYNAMIC_HEADER_VIEW", 3, true);
        NEXT_PAGE_TRIGGER = new DataTypes("NEXT_PAGE_TRIGGER", 4, true);
        WIDGET_SUMMARY = new DataTypes("WIDGET_SUMMARY", 5, true);
        DEAL_SUMMARY = new DataTypes("DEAL_SUMMARY", 6, false);
        WIDGET_IMAGE_SUMMARY = new DataTypes("WIDGET_IMAGE_SUMMARY", 7, true);
        SMALL_DEAL_CARD_LIST = new DataTypes("SMALL_DEAL_CARD_LIST", 8, false);
        DEAL_DETAILS_WIDGET_SUMMARY = new DataTypes("DEAL_DETAILS_WIDGET_SUMMARY", 9, true);
        TRACKING_HEADER = new DataTypes("TRACKING_HEADER", 10, true);
        COUPON = new DataTypes("COUPON", 11, false);
        COUPON_HEADER = new DataTypes("COUPON_HEADER", 12, true);
        COUPON_TOP_ITEM_CONTAINER = new DataTypes("COUPON_TOP_ITEM_CONTAINER", 13, false);
        COUPON_MERCHANT = new DataTypes("COUPON_MERCHANT", 14, false);
        COUPON_CATEGORY = new DataTypes("COUPON_CATEGORY", 15, false);
        $VALUES = (new DataTypes[] {
            DEAL_CARD, PENDING_VIEW, GROUPONICUS_STATIC_HEADER_VIEW, OCCASIONS_DYNAMIC_HEADER_VIEW, NEXT_PAGE_TRIGGER, WIDGET_SUMMARY, DEAL_SUMMARY, WIDGET_IMAGE_SUMMARY, SMALL_DEAL_CARD_LIST, DEAL_DETAILS_WIDGET_SUMMARY, 
            TRACKING_HEADER, COUPON, COUPON_HEADER, COUPON_TOP_ITEM_CONTAINER, COUPON_MERCHANT, COUPON_CATEGORY
        });
    }
}
