// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.list_view;


// Referenced classes of package com.groupon.v3.view.list_view:
//            CouponListItemType

public static final class  extends Enum
{

    private static final COUPON_NEARBY_STORE $VALUES[];
    public static final COUPON_NEARBY_STORE COUPON_CATEGORY;
    public static final COUPON_NEARBY_STORE COUPON_LIST_HEADER_CATEGORIES;
    public static final COUPON_NEARBY_STORE COUPON_LIST_HEADER_COUPONS;
    public static final COUPON_NEARBY_STORE COUPON_LIST_HEADER_MERCHANTS;
    public static final COUPON_NEARBY_STORE COUPON_LIST_HEADER_NEARBY_STORES;
    public static final COUPON_NEARBY_STORE COUPON_LiST_SEARCH_AUTO_COMPLETE_HEADER_MERCHANTS;
    public static final COUPON_NEARBY_STORE COUPON_LiST_SEARCH_HEADER_MERCHANTS;
    public static final COUPON_NEARBY_STORE COUPON_MERCHANT;
    public static final COUPON_NEARBY_STORE COUPON_NEARBY_STORE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/groupon/v3/view/list_view/CouponListItemType$ListItemType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        COUPON_LiST_SEARCH_AUTO_COMPLETE_HEADER_MERCHANTS = new <init>("COUPON_LiST_SEARCH_AUTO_COMPLETE_HEADER_MERCHANTS", 0);
        COUPON_LiST_SEARCH_HEADER_MERCHANTS = new <init>("COUPON_LiST_SEARCH_HEADER_MERCHANTS", 1);
        COUPON_LIST_HEADER_COUPONS = new <init>("COUPON_LIST_HEADER_COUPONS", 2);
        COUPON_LIST_HEADER_MERCHANTS = new <init>("COUPON_LIST_HEADER_MERCHANTS", 3);
        COUPON_LIST_HEADER_NEARBY_STORES = new <init>("COUPON_LIST_HEADER_NEARBY_STORES", 4);
        COUPON_LIST_HEADER_CATEGORIES = new <init>("COUPON_LIST_HEADER_CATEGORIES", 5);
        COUPON_MERCHANT = new <init>("COUPON_MERCHANT", 6);
        COUPON_CATEGORY = new <init>("COUPON_CATEGORY", 7);
        COUPON_NEARBY_STORE = new <init>("COUPON_NEARBY_STORE", 8);
        $VALUES = (new .VALUES[] {
            COUPON_LiST_SEARCH_AUTO_COMPLETE_HEADER_MERCHANTS, COUPON_LiST_SEARCH_HEADER_MERCHANTS, COUPON_LIST_HEADER_COUPONS, COUPON_LIST_HEADER_MERCHANTS, COUPON_LIST_HEADER_NEARBY_STORES, COUPON_LIST_HEADER_CATEGORIES, COUPON_MERCHANT, COUPON_CATEGORY, COUPON_NEARBY_STORE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
