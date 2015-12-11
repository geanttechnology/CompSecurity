// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;


// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager

public static final class  extends Enum
{

    private static final GET_ITEM_FLAGS_REFRESHED $VALUES[];
    public static final GET_ITEM_FLAGS_REFRESHED BEST_OFFER;
    public static final GET_ITEM_FLAGS_REFRESHED BIDDING_HISTORY;
    public static final GET_ITEM_FLAGS_REFRESHED BID_CHANGE;
    public static final GET_ITEM_FLAGS_REFRESHED BOPIS_AVAILABILITY;
    public static final GET_ITEM_FLAGS_REFRESHED CART_UPDATED;
    public static final GET_ITEM_FLAGS_REFRESHED CURRENCY_RATE_UPDATED;
    public static final GET_ITEM_FLAGS_REFRESHED FEEDBACK_LEFT;
    public static final GET_ITEM_FLAGS_REFRESHED GET_BEST_OFFERS;
    public static final GET_ITEM_FLAGS_REFRESHED GET_ITEM_FLAGS_REFRESHED;
    public static final GET_ITEM_FLAGS_REFRESHED GET_ORDERS;
    public static final GET_ITEM_FLAGS_REFRESHED GET_SHIPMENT_TRACKING;
    public static final GET_ITEM_FLAGS_REFRESHED INITIAL_LOAD;
    public static final GET_ITEM_FLAGS_REFRESHED ITEM_ADDED_TO_CART;
    public static final GET_ITEM_FLAGS_REFRESHED ITEM_DESCRIPTION;
    public static final GET_ITEM_FLAGS_REFRESHED ITEM_ENDED_BY_SELLER;
    public static final GET_ITEM_FLAGS_REFRESHED MARK_PAID_OR_UNPAID;
    public static final GET_ITEM_FLAGS_REFRESHED MARK_SHIPPED_OR_UNSHIPPED;
    public static final GET_ITEM_FLAGS_REFRESHED PAYMENT_REMINDER_SENT;
    public static final GET_ITEM_FLAGS_REFRESHED PRODUCT_INFO;
    public static final GET_ITEM_FLAGS_REFRESHED RESPOND_BEST_OFFER;
    public static final GET_ITEM_FLAGS_REFRESHED SHIPMENT_TRACKING;
    public static final GET_ITEM_FLAGS_REFRESHED SHIPPING_COSTS;
    public static final GET_ITEM_FLAGS_REFRESHED WATCH_CHANGED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/viewitem/ViewItemDataManager$ActionHandled, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        INITIAL_LOAD = new <init>("INITIAL_LOAD", 0);
        WATCH_CHANGED = new <init>("WATCH_CHANGED", 1);
        ITEM_ENDED_BY_SELLER = new <init>("ITEM_ENDED_BY_SELLER", 2);
        SHIPMENT_TRACKING = new <init>("SHIPMENT_TRACKING", 3);
        MARK_PAID_OR_UNPAID = new <init>("MARK_PAID_OR_UNPAID", 4);
        MARK_SHIPPED_OR_UNSHIPPED = new <init>("MARK_SHIPPED_OR_UNSHIPPED", 5);
        BOPIS_AVAILABILITY = new <init>("BOPIS_AVAILABILITY", 6);
        ITEM_ADDED_TO_CART = new <init>("ITEM_ADDED_TO_CART", 7);
        CART_UPDATED = new <init>("CART_UPDATED", 8);
        CURRENCY_RATE_UPDATED = new <init>("CURRENCY_RATE_UPDATED", 9);
        BID_CHANGE = new <init>("BID_CHANGE", 10);
        ITEM_DESCRIPTION = new <init>("ITEM_DESCRIPTION", 11);
        PRODUCT_INFO = new <init>("PRODUCT_INFO", 12);
        SHIPPING_COSTS = new <init>("SHIPPING_COSTS", 13);
        FEEDBACK_LEFT = new <init>("FEEDBACK_LEFT", 14);
        GET_SHIPMENT_TRACKING = new <init>("GET_SHIPMENT_TRACKING", 15);
        GET_BEST_OFFERS = new <init>("GET_BEST_OFFERS", 16);
        BEST_OFFER = new <init>("BEST_OFFER", 17);
        RESPOND_BEST_OFFER = new <init>("RESPOND_BEST_OFFER", 18);
        GET_ORDERS = new <init>("GET_ORDERS", 19);
        BIDDING_HISTORY = new <init>("BIDDING_HISTORY", 20);
        PAYMENT_REMINDER_SENT = new <init>("PAYMENT_REMINDER_SENT", 21);
        GET_ITEM_FLAGS_REFRESHED = new <init>("GET_ITEM_FLAGS_REFRESHED", 22);
        $VALUES = (new .VALUES[] {
            INITIAL_LOAD, WATCH_CHANGED, ITEM_ENDED_BY_SELLER, SHIPMENT_TRACKING, MARK_PAID_OR_UNPAID, MARK_SHIPPED_OR_UNSHIPPED, BOPIS_AVAILABILITY, ITEM_ADDED_TO_CART, CART_UPDATED, CURRENCY_RATE_UPDATED, 
            BID_CHANGE, ITEM_DESCRIPTION, PRODUCT_INFO, SHIPPING_COSTS, FEEDBACK_LEFT, GET_SHIPMENT_TRACKING, GET_BEST_OFFERS, BEST_OFFER, RESPOND_BEST_OFFER, GET_ORDERS, 
            BIDDING_HISTORY, PAYMENT_REMINDER_SENT, GET_ITEM_FLAGS_REFRESHED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
