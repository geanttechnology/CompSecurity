// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.list_view;

import com.groupon.db.models.CouponCategory;

// Referenced classes of package com.groupon.v3.view.list_view:
//            GenericListItemType

public class CouponCategoryWrapper extends GenericListItemType
{
    public static final class CouponCategoryType extends Enum
    {

        private static final CouponCategoryType $VALUES[];
        public static final CouponCategoryType ALL;
        public static final CouponCategoryType TOP_CATEGORIES;

        public static CouponCategoryType valueOf(String s)
        {
            return (CouponCategoryType)Enum.valueOf(com/groupon/v3/view/list_view/CouponCategoryWrapper$CouponCategoryType, s);
        }

        public static CouponCategoryType[] values()
        {
            return (CouponCategoryType[])$VALUES.clone();
        }

        static 
        {
            TOP_CATEGORIES = new CouponCategoryType("TOP_CATEGORIES", 0);
            ALL = new CouponCategoryType("ALL", 1);
            $VALUES = (new CouponCategoryType[] {
                TOP_CATEGORIES, ALL
            });
        }

        private CouponCategoryType(String s, int i)
        {
            super(s, i);
        }
    }


    protected CouponCategory couponCategory;
    protected int position;

    public CouponCategoryWrapper(CouponCategoryType couponcategorytype, CouponCategory couponcategory, int i)
    {
        super(couponcategorytype);
        couponCategory = couponcategory;
        position = i;
    }

    public CouponCategory getCouponCategory()
    {
        return couponCategory;
    }

    public int getPosition()
    {
        return position;
    }
}
