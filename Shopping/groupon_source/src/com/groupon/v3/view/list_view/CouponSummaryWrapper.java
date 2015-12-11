// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.list_view;

import com.groupon.db.models.CouponSummary;

// Referenced classes of package com.groupon.v3.view.list_view:
//            GenericListItemType

public class CouponSummaryWrapper extends GenericListItemType
{
    public static final class CouponSummaryLocation extends Enum
    {

        private static final CouponSummaryLocation $VALUES[];
        public static final CouponSummaryLocation COUPON_SUMMARY_ON_CAROUSEL;
        public static final CouponSummaryLocation COUPON_SUMMARY_ON_SEARCH_RESULT_FRAGMENT;

        public static CouponSummaryLocation valueOf(String s)
        {
            return (CouponSummaryLocation)Enum.valueOf(com/groupon/v3/view/list_view/CouponSummaryWrapper$CouponSummaryLocation, s);
        }

        public static CouponSummaryLocation[] values()
        {
            return (CouponSummaryLocation[])$VALUES.clone();
        }

        static 
        {
            COUPON_SUMMARY_ON_CAROUSEL = new CouponSummaryLocation("COUPON_SUMMARY_ON_CAROUSEL", 0);
            COUPON_SUMMARY_ON_SEARCH_RESULT_FRAGMENT = new CouponSummaryLocation("COUPON_SUMMARY_ON_SEARCH_RESULT_FRAGMENT", 1);
            $VALUES = (new CouponSummaryLocation[] {
                COUPON_SUMMARY_ON_CAROUSEL, COUPON_SUMMARY_ON_SEARCH_RESULT_FRAGMENT
            });
        }

        private CouponSummaryLocation(String s, int i)
        {
            super(s, i);
        }
    }


    protected CouponSummary couponSummary;
    protected int position;

    public CouponSummaryWrapper(CouponSummaryLocation couponsummarylocation, CouponSummary couponsummary, int i)
    {
        super(couponsummarylocation);
        couponSummary = couponsummary;
        position = i;
    }

    public CouponSummary getCouponSummary()
    {
        return couponSummary;
    }

    public int getPosition()
    {
        return position;
    }
}
