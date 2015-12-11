// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.list_view;


// Referenced classes of package com.groupon.v3.view.list_view:
//            GenericListItemType

public class CouponListItemType extends GenericListItemType
{
    public static final class ListItemType extends Enum
    {

        private static final ListItemType $VALUES[];
        public static final ListItemType COUPON_CATEGORY;
        public static final ListItemType COUPON_LIST_HEADER_CATEGORIES;
        public static final ListItemType COUPON_LIST_HEADER_COUPONS;
        public static final ListItemType COUPON_LIST_HEADER_MERCHANTS;
        public static final ListItemType COUPON_LIST_HEADER_NEARBY_STORES;
        public static final ListItemType COUPON_LiST_SEARCH_AUTO_COMPLETE_HEADER_MERCHANTS;
        public static final ListItemType COUPON_LiST_SEARCH_HEADER_MERCHANTS;
        public static final ListItemType COUPON_MERCHANT;
        public static final ListItemType COUPON_NEARBY_STORE;

        public static ListItemType valueOf(String s)
        {
            return (ListItemType)Enum.valueOf(com/groupon/v3/view/list_view/CouponListItemType$ListItemType, s);
        }

        public static ListItemType[] values()
        {
            return (ListItemType[])$VALUES.clone();
        }

        static 
        {
            COUPON_LiST_SEARCH_AUTO_COMPLETE_HEADER_MERCHANTS = new ListItemType("COUPON_LiST_SEARCH_AUTO_COMPLETE_HEADER_MERCHANTS", 0);
            COUPON_LiST_SEARCH_HEADER_MERCHANTS = new ListItemType("COUPON_LiST_SEARCH_HEADER_MERCHANTS", 1);
            COUPON_LIST_HEADER_COUPONS = new ListItemType("COUPON_LIST_HEADER_COUPONS", 2);
            COUPON_LIST_HEADER_MERCHANTS = new ListItemType("COUPON_LIST_HEADER_MERCHANTS", 3);
            COUPON_LIST_HEADER_NEARBY_STORES = new ListItemType("COUPON_LIST_HEADER_NEARBY_STORES", 4);
            COUPON_LIST_HEADER_CATEGORIES = new ListItemType("COUPON_LIST_HEADER_CATEGORIES", 5);
            COUPON_MERCHANT = new ListItemType("COUPON_MERCHANT", 6);
            COUPON_CATEGORY = new ListItemType("COUPON_CATEGORY", 7);
            COUPON_NEARBY_STORE = new ListItemType("COUPON_NEARBY_STORE", 8);
            $VALUES = (new ListItemType[] {
                COUPON_LiST_SEARCH_AUTO_COMPLETE_HEADER_MERCHANTS, COUPON_LiST_SEARCH_HEADER_MERCHANTS, COUPON_LIST_HEADER_COUPONS, COUPON_LIST_HEADER_MERCHANTS, COUPON_LIST_HEADER_NEARBY_STORES, COUPON_LIST_HEADER_CATEGORIES, COUPON_MERCHANT, COUPON_CATEGORY, COUPON_NEARBY_STORE
            });
        }

        private ListItemType(String s, int i)
        {
            super(s, i);
        }
    }


    public CouponListItemType(ListItemType listitemtype)
    {
        super(listitemtype);
    }
}
