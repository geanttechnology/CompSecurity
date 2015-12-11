// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.list_view;

import com.groupon.db.models.CouponMerchant;

// Referenced classes of package com.groupon.v3.view.list_view:
//            GenericListItemType

public class CouponMerchantWrapper extends GenericListItemType
{
    public static final class CouponMerchantType extends Enum
    {

        private static final CouponMerchantType $VALUES[];
        public static final CouponMerchantType SEARCH_AUTOCOMPLETE;
        public static final CouponMerchantType SEARCH_RECOMMENDATION;

        public static CouponMerchantType valueOf(String s)
        {
            return (CouponMerchantType)Enum.valueOf(com/groupon/v3/view/list_view/CouponMerchantWrapper$CouponMerchantType, s);
        }

        public static CouponMerchantType[] values()
        {
            return (CouponMerchantType[])$VALUES.clone();
        }

        static 
        {
            SEARCH_RECOMMENDATION = new CouponMerchantType("SEARCH_RECOMMENDATION", 0);
            SEARCH_AUTOCOMPLETE = new CouponMerchantType("SEARCH_AUTOCOMPLETE", 1);
            $VALUES = (new CouponMerchantType[] {
                SEARCH_RECOMMENDATION, SEARCH_AUTOCOMPLETE
            });
        }

        private CouponMerchantType(String s, int i)
        {
            super(s, i);
        }
    }


    CouponMerchant couponMerchant;
    int horizontalPosition;
    int verticalPosition;

    public CouponMerchantWrapper(CouponMerchantType couponmerchanttype, CouponMerchant couponmerchant)
    {
        super(couponmerchanttype);
        couponMerchant = couponmerchant;
    }

    public CouponMerchant getCouponMerchant()
    {
        return couponMerchant;
    }

    public int getHorizontalPosition()
    {
        return horizontalPosition;
    }

    public int getVerticalPosition()
    {
        return verticalPosition;
    }

    public CouponMerchantWrapper setHorizontalPosition(int i)
    {
        horizontalPosition = i;
        return this;
    }

    public CouponMerchantWrapper setVerticalPosition(int i)
    {
        verticalPosition = i;
        return this;
    }
}
