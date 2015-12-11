// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;


// Referenced classes of package com.ebay.mobile.checkout:
//            BaseCheckoutActivity

public static final class  extends Enum
{

    private static final DYSON_PAIRED $VALUES[];
    public static final DYSON_PAIRED ADDRESS_DATA_MANAGER;
    public static final DYSON_PAIRED ADD_CREDIT_CARD;
    public static final DYSON_PAIRED ADD_DIRECT_DEBIT;
    public static final DYSON_PAIRED ADD_DONATION;
    public static final DYSON_PAIRED APPLY_INCENTIVES;
    public static final DYSON_PAIRED BUY;
    public static final DYSON_PAIRED CREATE_CART;
    public static final DYSON_PAIRED CREATE_CHECKOUT_SESSION;
    public static final DYSON_PAIRED DYSON_PAIRED;
    public static final DYSON_PAIRED GET_ADDRESSES;
    public static final DYSON_PAIRED GET_CART;
    public static final DYSON_PAIRED GET_FUNDING_INSTRUMENT;
    public static final DYSON_PAIRED GET_INCENTIVES_COUPONS;
    public static final DYSON_PAIRED GET_INCENTIVES_REWARDS;
    public static final DYSON_PAIRED GET_USER_INCENTIVES_COUPONS;
    public static final DYSON_PAIRED GET_USER_INCENTIVES_VOUCHERS;
    public static final DYSON_PAIRED INIT_PAYMENT_FOR_PREPARE;
    public static final DYSON_PAIRED INIT_PAYMENT_FOR_REFRESH;
    public static final DYSON_PAIRED INIT_PAYMENT_RESULT;
    public static final DYSON_PAIRED PAYPAL_CHECKOUT;
    public static final DYSON_PAIRED PAYPAL_CHECKOUT_FOR_REFRESH;
    public static final DYSON_PAIRED POST_PAYMENT_WATCH_LIST_UPDATE;
    public static final DYSON_PAIRED REDEEM_INCENTIVE;
    public static final DYSON_PAIRED REFRESH_ADDRESSES;
    public static final DYSON_PAIRED REFRESH_CART;
    public static final DYSON_PAIRED REMOVE_DONATION;
    public static final DYSON_PAIRED REQUEST_TOKEN_FOR_SERVICE;
    public static final DYSON_PAIRED SET_DEFAULT_SHIPPING_ADDRESS;
    public static final DYSON_PAIRED SET_PAYMENT_INSTRUMENT;
    public static final DYSON_PAIRED SET_SHIPPING_ADDRESS;
    public static final DYSON_PAIRED UPDATE_CREDIT_CARD;
    public static final DYSON_PAIRED UPDATE_DELIVERY_RESERVATION;
    public static final DYSON_PAIRED UPDATE_DIRECT_DEBIT;
    public static final DYSON_PAIRED UPDATE_ITEM_QUANTITY;
    public static final DYSON_PAIRED UPDATE_PICKUP_METHOD;
    public static final DYSON_PAIRED UPDATE_SELLER_NOTE;
    public static final DYSON_PAIRED UPDATE_SHIPPING_METHOD;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/checkout/BaseCheckoutActivity$Operation, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        GET_ADDRESSES = new <init>("GET_ADDRESSES", 0);
        CREATE_CHECKOUT_SESSION = new <init>("CREATE_CHECKOUT_SESSION", 1);
        GET_CART = new <init>("GET_CART", 2);
        SET_DEFAULT_SHIPPING_ADDRESS = new <init>("SET_DEFAULT_SHIPPING_ADDRESS", 3);
        CREATE_CART = new <init>("CREATE_CART", 4);
        REFRESH_CART = new <init>("REFRESH_CART", 5);
        GET_USER_INCENTIVES_COUPONS = new <init>("GET_USER_INCENTIVES_COUPONS", 6);
        GET_USER_INCENTIVES_VOUCHERS = new <init>("GET_USER_INCENTIVES_VOUCHERS", 7);
        GET_INCENTIVES_COUPONS = new <init>("GET_INCENTIVES_COUPONS", 8);
        GET_INCENTIVES_REWARDS = new <init>("GET_INCENTIVES_REWARDS", 9);
        SET_SHIPPING_ADDRESS = new <init>("SET_SHIPPING_ADDRESS", 10);
        REFRESH_ADDRESSES = new <init>("REFRESH_ADDRESSES", 11);
        APPLY_INCENTIVES = new <init>("APPLY_INCENTIVES", 12);
        REDEEM_INCENTIVE = new <init>("REDEEM_INCENTIVE", 13);
        UPDATE_SHIPPING_METHOD = new <init>("UPDATE_SHIPPING_METHOD", 14);
        UPDATE_ITEM_QUANTITY = new <init>("UPDATE_ITEM_QUANTITY", 15);
        UPDATE_SELLER_NOTE = new <init>("UPDATE_SELLER_NOTE", 16);
        UPDATE_PICKUP_METHOD = new <init>("UPDATE_PICKUP_METHOD", 17);
        UPDATE_DELIVERY_RESERVATION = new <init>("UPDATE_DELIVERY_RESERVATION", 18);
        ADD_DONATION = new <init>("ADD_DONATION", 19);
        REMOVE_DONATION = new <init>("REMOVE_DONATION", 20);
        REQUEST_TOKEN_FOR_SERVICE = new <init>("REQUEST_TOKEN_FOR_SERVICE", 21);
        INIT_PAYMENT_FOR_PREPARE = new <init>("INIT_PAYMENT_FOR_PREPARE", 22);
        INIT_PAYMENT_FOR_REFRESH = new <init>("INIT_PAYMENT_FOR_REFRESH", 23);
        PAYPAL_CHECKOUT_FOR_REFRESH = new <init>("PAYPAL_CHECKOUT_FOR_REFRESH", 24);
        PAYPAL_CHECKOUT = new <init>("PAYPAL_CHECKOUT", 25);
        INIT_PAYMENT_RESULT = new <init>("INIT_PAYMENT_RESULT", 26);
        BUY = new <init>("BUY", 27);
        POST_PAYMENT_WATCH_LIST_UPDATE = new <init>("POST_PAYMENT_WATCH_LIST_UPDATE", 28);
        ADDRESS_DATA_MANAGER = new <init>("ADDRESS_DATA_MANAGER", 29);
        SET_PAYMENT_INSTRUMENT = new <init>("SET_PAYMENT_INSTRUMENT", 30);
        ADD_CREDIT_CARD = new <init>("ADD_CREDIT_CARD", 31);
        GET_FUNDING_INSTRUMENT = new <init>("GET_FUNDING_INSTRUMENT", 32);
        UPDATE_CREDIT_CARD = new <init>("UPDATE_CREDIT_CARD", 33);
        ADD_DIRECT_DEBIT = new <init>("ADD_DIRECT_DEBIT", 34);
        UPDATE_DIRECT_DEBIT = new <init>("UPDATE_DIRECT_DEBIT", 35);
        DYSON_PAIRED = new <init>("DYSON_PAIRED", 36);
        $VALUES = (new .VALUES[] {
            GET_ADDRESSES, CREATE_CHECKOUT_SESSION, GET_CART, SET_DEFAULT_SHIPPING_ADDRESS, CREATE_CART, REFRESH_CART, GET_USER_INCENTIVES_COUPONS, GET_USER_INCENTIVES_VOUCHERS, GET_INCENTIVES_COUPONS, GET_INCENTIVES_REWARDS, 
            SET_SHIPPING_ADDRESS, REFRESH_ADDRESSES, APPLY_INCENTIVES, REDEEM_INCENTIVE, UPDATE_SHIPPING_METHOD, UPDATE_ITEM_QUANTITY, UPDATE_SELLER_NOTE, UPDATE_PICKUP_METHOD, UPDATE_DELIVERY_RESERVATION, ADD_DONATION, 
            REMOVE_DONATION, REQUEST_TOKEN_FOR_SERVICE, INIT_PAYMENT_FOR_PREPARE, INIT_PAYMENT_FOR_REFRESH, PAYPAL_CHECKOUT_FOR_REFRESH, PAYPAL_CHECKOUT, INIT_PAYMENT_RESULT, BUY, POST_PAYMENT_WATCH_LIST_UPDATE, ADDRESS_DATA_MANAGER, 
            SET_PAYMENT_INSTRUMENT, ADD_CREDIT_CARD, GET_FUNDING_INSTRUMENT, UPDATE_CREDIT_CARD, ADD_DIRECT_DEBIT, UPDATE_DIRECT_DEBIT, DYSON_PAIRED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
