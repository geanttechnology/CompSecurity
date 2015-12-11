// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;


// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager

private static final class requiredSuccess extends Enum
{

    private static final GET_SHOPPING_CART $VALUES[];
    public static final GET_SHOPPING_CART ADD_SHIPMENT_TRACKING;
    public static final GET_SHOPPING_CART BIDDING_HISTORY;
    public static final GET_SHOPPING_CART CONVERT_CURRENCY;
    public static final GET_SHOPPING_CART EBAY_DETAILS;
    public static final GET_SHOPPING_CART END_ITEM;
    public static final GET_SHOPPING_CART GET_ADDRESSES;
    public static final GET_SHOPPING_CART GET_BEST_OFFERS;
    public static final GET_SHOPPING_CART GET_BIDLIST;
    public static final GET_SHOPPING_CART GET_DM_ADDRESSES;
    public static final GET_SHOPPING_CART GET_INCENTIVES;
    public static final GET_SHOPPING_CART GET_ITEM_FLAGS;
    public static final GET_SHOPPING_CART GET_ITEM_TRANSACTIONS;
    public static final GET_SHOPPING_CART GET_LOCATION_DETAILS;
    public static final GET_SHOPPING_CART GET_ORDERS;
    public static final GET_SHOPPING_CART GET_ORDER_SHIPPING_INFO;
    public static final GET_SHOPPING_CART GET_PRODUCT_INFO;
    public static final GET_SHOPPING_CART GET_SHIPMENT_TRACKING;
    public static final GET_SHOPPING_CART GET_SHIPPING_COSTS_SINGLE;
    public static final GET_SHOPPING_CART GET_SHOPPING_CART;
    public static final GET_SHOPPING_CART GET_SOLDLIST;
    public static final GET_SHOPPING_CART GET_STOREAVAILABILITY;
    public static final GET_SHOPPING_CART GET_VIEW_LISTING;
    public static final GET_SHOPPING_CART GET_WATCHLIST;
    public static final GET_SHOPPING_CART GET_WONLIST;
    public static final GET_SHOPPING_CART LEAVE_FEEDBACK;
    public static final GET_SHOPPING_CART MAKE_OFFER;
    public static final GET_SHOPPING_CART MARK_PAID;
    public static final GET_SHOPPING_CART MARK_SHIPPED;
    public static final GET_SHOPPING_CART PLACE_OFFER;
    public static final GET_SHOPPING_CART RESPOND_BEST_OFFER;
    public static final GET_SHOPPING_CART VIEW_ITEM_LITE;
    private boolean requiredSuccess;

    public static requiredSuccess valueOf(String s)
    {
        return (requiredSuccess)Enum.valueOf(com/ebay/mobile/viewitem/ViewItemDataManager$TaskId, s);
    }

    public static requiredSuccess[] values()
    {
        return (requiredSuccess[])$VALUES.clone();
    }

    static 
    {
        GET_ADDRESSES = new <init>("GET_ADDRESSES", 0, true);
        GET_STOREAVAILABILITY = new <init>("GET_STOREAVAILABILITY", 1);
        GET_ITEM_FLAGS = new <init>("GET_ITEM_FLAGS", 2);
        END_ITEM = new <init>("END_ITEM", 3);
        GET_SHIPPING_COSTS_SINGLE = new <init>("GET_SHIPPING_COSTS_SINGLE", 4);
        ADD_SHIPMENT_TRACKING = new <init>("ADD_SHIPMENT_TRACKING", 5);
        MARK_PAID = new <init>("MARK_PAID", 6);
        MARK_SHIPPED = new <init>("MARK_SHIPPED", 7);
        EBAY_DETAILS = new <init>("EBAY_DETAILS", 8, true);
        GET_ITEM_TRANSACTIONS = new <init>("GET_ITEM_TRANSACTIONS", 9, true);
        GET_INCENTIVES = new <init>("GET_INCENTIVES", 10);
        GET_BEST_OFFERS = new <init>("GET_BEST_OFFERS", 11);
        GET_LOCATION_DETAILS = new <init>("GET_LOCATION_DETAILS", 12);
        GET_ORDER_SHIPPING_INFO = new <init>("GET_ORDER_SHIPPING_INFO", 13);
        PLACE_OFFER = new <init>("PLACE_OFFER", 14);
        GET_PRODUCT_INFO = new <init>("GET_PRODUCT_INFO", 15);
        MAKE_OFFER = new <init>("MAKE_OFFER", 16);
        LEAVE_FEEDBACK = new <init>("LEAVE_FEEDBACK", 17);
        GET_SHIPMENT_TRACKING = new <init>("GET_SHIPMENT_TRACKING", 18);
        RESPOND_BEST_OFFER = new <init>("RESPOND_BEST_OFFER", 19);
        VIEW_ITEM_LITE = new <init>("VIEW_ITEM_LITE", 20, true);
        GET_ORDERS = new <init>("GET_ORDERS", 21);
        BIDDING_HISTORY = new <init>("BIDDING_HISTORY", 22);
        CONVERT_CURRENCY = new <init>("CONVERT_CURRENCY", 23);
        GET_VIEW_LISTING = new <init>("GET_VIEW_LISTING", 24, true);
        GET_WATCHLIST = new <init>("GET_WATCHLIST", 25, true);
        GET_BIDLIST = new <init>("GET_BIDLIST", 26, true);
        GET_SOLDLIST = new <init>("GET_SOLDLIST", 27, true);
        GET_WONLIST = new <init>("GET_WONLIST", 28, true);
        GET_DM_ADDRESSES = new <init>("GET_DM_ADDRESSES", 29, true);
        GET_SHOPPING_CART = new <init>("GET_SHOPPING_CART", 30, true);
        $VALUES = (new .VALUES[] {
            GET_ADDRESSES, GET_STOREAVAILABILITY, GET_ITEM_FLAGS, END_ITEM, GET_SHIPPING_COSTS_SINGLE, ADD_SHIPMENT_TRACKING, MARK_PAID, MARK_SHIPPED, EBAY_DETAILS, GET_ITEM_TRANSACTIONS, 
            GET_INCENTIVES, GET_BEST_OFFERS, GET_LOCATION_DETAILS, GET_ORDER_SHIPPING_INFO, PLACE_OFFER, GET_PRODUCT_INFO, MAKE_OFFER, LEAVE_FEEDBACK, GET_SHIPMENT_TRACKING, RESPOND_BEST_OFFER, 
            VIEW_ITEM_LITE, GET_ORDERS, BIDDING_HISTORY, CONVERT_CURRENCY, GET_VIEW_LISTING, GET_WATCHLIST, GET_BIDLIST, GET_SOLDLIST, GET_WONLIST, GET_DM_ADDRESSES, 
            GET_SHOPPING_CART
        });
    }


    private _cls9(String s, int i)
    {
        super(s, i);
        requiredSuccess = false;
    }

    private requiredSuccess(String s, int i, boolean flag)
    {
        super(s, i);
        requiredSuccess = flag;
    }
}
