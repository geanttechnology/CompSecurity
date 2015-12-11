// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.list_view;


// Referenced classes of package com.groupon.v3.view.list_view:
//            CouponSummaryWrapper

public static final class  extends Enum
{

    private static final COUPON_SUMMARY_ON_SEARCH_RESULT_FRAGMENT $VALUES[];
    public static final COUPON_SUMMARY_ON_SEARCH_RESULT_FRAGMENT COUPON_SUMMARY_ON_CAROUSEL;
    public static final COUPON_SUMMARY_ON_SEARCH_RESULT_FRAGMENT COUPON_SUMMARY_ON_SEARCH_RESULT_FRAGMENT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/groupon/v3/view/list_view/CouponSummaryWrapper$CouponSummaryLocation, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        COUPON_SUMMARY_ON_CAROUSEL = new <init>("COUPON_SUMMARY_ON_CAROUSEL", 0);
        COUPON_SUMMARY_ON_SEARCH_RESULT_FRAGMENT = new <init>("COUPON_SUMMARY_ON_SEARCH_RESULT_FRAGMENT", 1);
        $VALUES = (new .VALUES[] {
            COUPON_SUMMARY_ON_CAROUSEL, COUPON_SUMMARY_ON_SEARCH_RESULT_FRAGMENT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
