// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.dealdetails;


public final class DealDetailsViewType extends Enum
{

    private static final DealDetailsViewType $VALUES[];
    public static final DealDetailsViewType ADDITIONAL_INFO;
    public static final DealDetailsViewType AMENITIES;
    public static final DealDetailsViewType CAB_WIDGETS;
    public static final DealDetailsViewType CAV_WIDGETS;
    public static final DealDetailsViewType COMPANY_INFO;
    public static final DealDetailsViewType DATE_TIME_FINDER_RESERVATION;
    public static final DealDetailsViewType DELIVERY_ESTIMATION;
    public static final DealDetailsViewType DIRECTIONS;
    public static final DealDetailsViewType FINE_PRINT;
    public static final DealDetailsViewType GIFTING;
    public static final DealDetailsViewType HEADER;
    public static final DealDetailsViewType HIGHLIGHTS;
    public static final DealDetailsViewType INCENTIVES;
    public static final DealDetailsViewType LIVE_CHAT;
    public static final DealDetailsViewType MARKETPLACE;
    public static final DealDetailsViewType MERCHANT_RECOMMENDATION;
    public static final DealDetailsViewType MORE_INFO;
    public static final DealDetailsViewType OTHER_DETAILS;
    public static final DealDetailsViewType Q_AND_A;
    public static final DealDetailsViewType TIPS;
    public static final DealDetailsViewType TRAVEL_TRIPADVISOR_REVIEWS;
    public static final DealDetailsViewType TRAVEL_UGC_REVIEWS;
    public static final DealDetailsViewType VERTICALLY_EXPOSED_MULTI_OPTIONS;
    public static final DealDetailsViewType WHAT_YOU_GET;

    private DealDetailsViewType(String s, int i)
    {
        super(s, i);
    }

    public static DealDetailsViewType valueOf(String s)
    {
        return (DealDetailsViewType)Enum.valueOf(com/groupon/models/dealdetails/DealDetailsViewType, s);
    }

    public static DealDetailsViewType[] values()
    {
        return (DealDetailsViewType[])$VALUES.clone();
    }

    static 
    {
        HEADER = new DealDetailsViewType("HEADER", 0);
        DATE_TIME_FINDER_RESERVATION = new DealDetailsViewType("DATE_TIME_FINDER_RESERVATION", 1);
        VERTICALLY_EXPOSED_MULTI_OPTIONS = new DealDetailsViewType("VERTICALLY_EXPOSED_MULTI_OPTIONS", 2);
        INCENTIVES = new DealDetailsViewType("INCENTIVES", 3);
        MERCHANT_RECOMMENDATION = new DealDetailsViewType("MERCHANT_RECOMMENDATION", 4);
        MARKETPLACE = new DealDetailsViewType("MARKETPLACE", 5);
        DELIVERY_ESTIMATION = new DealDetailsViewType("DELIVERY_ESTIMATION", 6);
        HIGHLIGHTS = new DealDetailsViewType("HIGHLIGHTS", 7);
        GIFTING = new DealDetailsViewType("GIFTING", 8);
        TRAVEL_TRIPADVISOR_REVIEWS = new DealDetailsViewType("TRAVEL_TRIPADVISOR_REVIEWS", 9);
        TRAVEL_UGC_REVIEWS = new DealDetailsViewType("TRAVEL_UGC_REVIEWS", 10);
        CAB_WIDGETS = new DealDetailsViewType("CAB_WIDGETS", 11);
        WHAT_YOU_GET = new DealDetailsViewType("WHAT_YOU_GET", 12);
        FINE_PRINT = new DealDetailsViewType("FINE_PRINT", 13);
        COMPANY_INFO = new DealDetailsViewType("COMPANY_INFO", 14);
        DIRECTIONS = new DealDetailsViewType("DIRECTIONS", 15);
        ADDITIONAL_INFO = new DealDetailsViewType("ADDITIONAL_INFO", 16);
        MORE_INFO = new DealDetailsViewType("MORE_INFO", 17);
        AMENITIES = new DealDetailsViewType("AMENITIES", 18);
        OTHER_DETAILS = new DealDetailsViewType("OTHER_DETAILS", 19);
        TIPS = new DealDetailsViewType("TIPS", 20);
        Q_AND_A = new DealDetailsViewType("Q_AND_A", 21);
        CAV_WIDGETS = new DealDetailsViewType("CAV_WIDGETS", 22);
        LIVE_CHAT = new DealDetailsViewType("LIVE_CHAT", 23);
        $VALUES = (new DealDetailsViewType[] {
            HEADER, DATE_TIME_FINDER_RESERVATION, VERTICALLY_EXPOSED_MULTI_OPTIONS, INCENTIVES, MERCHANT_RECOMMENDATION, MARKETPLACE, DELIVERY_ESTIMATION, HIGHLIGHTS, GIFTING, TRAVEL_TRIPADVISOR_REVIEWS, 
            TRAVEL_UGC_REVIEWS, CAB_WIDGETS, WHAT_YOU_GET, FINE_PRINT, COMPANY_INFO, DIRECTIONS, ADDITIONAL_INFO, MORE_INFO, AMENITIES, OTHER_DETAILS, 
            TIPS, Q_AND_A, CAV_WIDGETS, LIVE_CHAT
        });
    }
}
