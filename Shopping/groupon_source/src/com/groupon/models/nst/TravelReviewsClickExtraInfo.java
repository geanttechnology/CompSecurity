// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class TravelReviewsClickExtraInfo extends JsonEncodedNSTField
{

    public static final String ACTION_COLLAPSE = "collapse";
    public static final String ACTION_EXPAND = "expand";
    public static final String REVIEW_TYPE_TRIPADVISOR = "TA";
    public static final String REVIEW_TYPE_UGC = "UGC";
    public static final String TRAVEL_REVIEWS_HEADER_CLICK = "travel_reviews_header_click";
    public static final String TRAVEL_REVIEWS_ITEM_CLICK = "travel_reviews_item_click";
    protected String actionType;
    protected Integer placement;
    protected Double reviewScore;
    protected String reviewType;

    public TravelReviewsClickExtraInfo(String s, String s1)
    {
        reviewType = s;
        actionType = s1;
    }

    public TravelReviewsClickExtraInfo(String s, String s1, Double double1, Integer integer)
    {
        reviewType = s;
        actionType = s1;
        reviewScore = double1;
        placement = integer;
    }
}
