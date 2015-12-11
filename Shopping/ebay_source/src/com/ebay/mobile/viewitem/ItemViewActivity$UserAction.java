// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;


// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewActivity

public static final class  extends Enum
{

    private static final PLUS_SIGNUP $VALUES[];
    public static final PLUS_SIGNUP ADD_TO_CART;
    public static final PLUS_SIGNUP BIDDING_ACTIVITY;
    public static final PLUS_SIGNUP BUYER_REVIEW_OFFER;
    public static final PLUS_SIGNUP BUYING_OPTIONS;
    public static final PLUS_SIGNUP BUY_ANOTHER;
    public static final PLUS_SIGNUP BUY_IT_NOW;
    public static final PLUS_SIGNUP CHANGE_ADDRESS;
    public static final PLUS_SIGNUP EBN_ORDER_DETAILS;
    public static final PLUS_SIGNUP EDIT_PACKAGE_TRACKING;
    public static final PLUS_SIGNUP END_ITEM;
    public static final PLUS_SIGNUP ENTER_PACKAGE_TRACKING;
    public static final PLUS_SIGNUP LEAVE_FEEDBACK;
    public static final PLUS_SIGNUP MAKE_OFFER;
    public static final PLUS_SIGNUP MARK_AS_PAID;
    public static final PLUS_SIGNUP MARK_AS_UNPAID;
    public static final PLUS_SIGNUP MARK_NOT_SHIPPED;
    public static final PLUS_SIGNUP MARK_SHIPPED;
    public static final PLUS_SIGNUP NONE;
    public static final PLUS_SIGNUP ORDER_SUMMARY;
    public static final PLUS_SIGNUP PAYMENT_OPTIONS;
    public static final PLUS_SIGNUP PAY_NOW;
    public static final PLUS_SIGNUP PLACE_BID;
    public static final PLUS_SIGNUP PLACE_BID_AMOUNT;
    public static final PLUS_SIGNUP PLUS_SIGNUP;
    public static final PLUS_SIGNUP RELIST;
    public static final PLUS_SIGNUP REVISE;
    public static final PLUS_SIGNUP SELL_LIKE;
    public static final PLUS_SIGNUP SHARE;
    public static final PLUS_SIGNUP SPR;
    public static final PLUS_SIGNUP TRACK_PACKAGE;
    public static final PLUS_SIGNUP UNWATCH;
    public static final PLUS_SIGNUP VIEW_CART;
    public static final PLUS_SIGNUP VIEW_RELISTED_ITEM;
    public static final PLUS_SIGNUP WATCH;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/viewitem/ItemViewActivity$UserAction, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        BIDDING_ACTIVITY = new <init>("BIDDING_ACTIVITY", 1);
        PLACE_BID = new <init>("PLACE_BID", 2);
        PLACE_BID_AMOUNT = new <init>("PLACE_BID_AMOUNT", 3);
        BUY_IT_NOW = new <init>("BUY_IT_NOW", 4);
        BUY_ANOTHER = new <init>("BUY_ANOTHER", 5);
        WATCH = new <init>("WATCH", 6);
        UNWATCH = new <init>("UNWATCH", 7);
        SELL_LIKE = new <init>("SELL_LIKE", 8);
        END_ITEM = new <init>("END_ITEM", 9);
        MARK_SHIPPED = new <init>("MARK_SHIPPED", 10);
        MARK_NOT_SHIPPED = new <init>("MARK_NOT_SHIPPED", 11);
        MAKE_OFFER = new <init>("MAKE_OFFER", 12);
        BUYER_REVIEW_OFFER = new <init>("BUYER_REVIEW_OFFER", 13);
        ADD_TO_CART = new <init>("ADD_TO_CART", 14);
        VIEW_CART = new <init>("VIEW_CART", 15);
        PAY_NOW = new <init>("PAY_NOW", 16);
        PAYMENT_OPTIONS = new <init>("PAYMENT_OPTIONS", 17);
        TRACK_PACKAGE = new <init>("TRACK_PACKAGE", 18);
        ENTER_PACKAGE_TRACKING = new <init>("ENTER_PACKAGE_TRACKING", 19);
        EDIT_PACKAGE_TRACKING = new <init>("EDIT_PACKAGE_TRACKING", 20);
        LEAVE_FEEDBACK = new <init>("LEAVE_FEEDBACK", 21);
        MARK_AS_PAID = new <init>("MARK_AS_PAID", 22);
        MARK_AS_UNPAID = new <init>("MARK_AS_UNPAID", 23);
        RELIST = new <init>("RELIST", 24);
        VIEW_RELISTED_ITEM = new <init>("VIEW_RELISTED_ITEM", 25);
        REVISE = new <init>("REVISE", 26);
        SHARE = new <init>("SHARE", 27);
        BUYING_OPTIONS = new <init>("BUYING_OPTIONS", 28);
        ORDER_SUMMARY = new <init>("ORDER_SUMMARY", 29);
        EBN_ORDER_DETAILS = new <init>("EBN_ORDER_DETAILS", 30);
        SPR = new <init>("SPR", 31);
        CHANGE_ADDRESS = new <init>("CHANGE_ADDRESS", 32);
        PLUS_SIGNUP = new <init>("PLUS_SIGNUP", 33);
        $VALUES = (new .VALUES[] {
            NONE, BIDDING_ACTIVITY, PLACE_BID, PLACE_BID_AMOUNT, BUY_IT_NOW, BUY_ANOTHER, WATCH, UNWATCH, SELL_LIKE, END_ITEM, 
            MARK_SHIPPED, MARK_NOT_SHIPPED, MAKE_OFFER, BUYER_REVIEW_OFFER, ADD_TO_CART, VIEW_CART, PAY_NOW, PAYMENT_OPTIONS, TRACK_PACKAGE, ENTER_PACKAGE_TRACKING, 
            EDIT_PACKAGE_TRACKING, LEAVE_FEEDBACK, MARK_AS_PAID, MARK_AS_UNPAID, RELIST, VIEW_RELISTED_ITEM, REVISE, SHARE, BUYING_OPTIONS, ORDER_SUMMARY, 
            EBN_ORDER_DETAILS, SPR, CHANGE_ADDRESS, PLUS_SIGNUP
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
