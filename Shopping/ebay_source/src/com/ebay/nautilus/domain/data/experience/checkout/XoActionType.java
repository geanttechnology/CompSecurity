// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.checkout;


public final class XoActionType extends Enum
{

    private static final XoActionType $VALUES[];
    public static final XoActionType ACCEPT_AGREEMENT;
    public static final XoActionType ADDRESS_BACK;
    public static final XoActionType ADDRESS_SUBMIT;
    public static final XoActionType ADD_ANOTHER_CARD;
    public static final XoActionType ADD_CARD_FUNDING_SOURCE;
    public static final XoActionType ADD_CREDIT_FUNDING_SOURCE;
    public static final XoActionType ADD_ITEM;
    public static final XoActionType ADD_SHIPPING_ADDRESS;
    public static final XoActionType APPLY_INCENTIVE;
    public static final XoActionType APPLY_WARNING;
    public static final XoActionType CANCEL_ADDRESS;
    public static final XoActionType CANCEL_CARD;
    public static final XoActionType CANCEL_SELLER_MESSAGE;
    public static final XoActionType CANCEL_WARNING;
    public static final XoActionType CHANGE_PAYMENT_METHOD;
    public static final XoActionType CHANGE_STORE;
    public static final XoActionType CONFIRM_AND_PAY;
    public static final XoActionType EDIT_ADDRESS;
    public static final XoActionType EDIT_PAYMENT_INSTRUMENT;
    public static final XoActionType EDIT_SHIPPING_ADDRESS;
    public static final XoActionType GO_TO_HOMEPAGE;
    public static final XoActionType GO_TO_MY_EBAY;
    public static final XoActionType GO_TO_SHOPCART;
    public static final XoActionType INCENTIVE_LINK;
    public static final XoActionType MAKE_ADDRESS_PRIMARY;
    public static final XoActionType MESSAGE_TO_SELLER;
    public static final XoActionType PAY_ONLY_THIS_SELLER;
    public static final XoActionType REDIRECT_TO_LEGACY_CHECKOUT;
    public static final XoActionType REDIRECT_TO_VIEW_ORDER_DETAILS;
    public static final XoActionType REMOVE_INCENTIVE;
    public static final XoActionType REMOVE_ITEM;
    public static final XoActionType REMOVE_SELLER_MESSAGE;
    public static final XoActionType REQUEST_TOTAL;
    public static final XoActionType RESOLVE_PAYMENT_CONTINGENCY;
    public static final XoActionType SAVE_CARD;
    public static final XoActionType SEE_TERMS;
    public static final XoActionType SELECT_PAYMENT_INSTRUMENT;
    public static final XoActionType SHOW_LESS_ADDRESSES;
    public static final XoActionType SHOW_MORE_ADDRESSES;
    public static final XoActionType SHOW_SURVEY_PAGE;
    public static final XoActionType SUBMIT_SELLER_MESSAGE;
    public static final XoActionType SWITCH_ACCOUNT;
    public static final XoActionType TERMS_AND_CONDITIONS;
    public static final XoActionType UNKNOWN;
    public static final XoActionType USE_THIS_ADDRESS;
    public static final XoActionType VALIDATE_CARD;

    private XoActionType(String s, int i)
    {
        super(s, i);
    }

    public static XoActionType valueOf(String s)
    {
        return (XoActionType)Enum.valueOf(com/ebay/nautilus/domain/data/experience/checkout/XoActionType, s);
    }

    public static XoActionType[] values()
    {
        return (XoActionType[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new XoActionType("UNKNOWN", 0);
        MESSAGE_TO_SELLER = new XoActionType("MESSAGE_TO_SELLER", 1);
        PAY_ONLY_THIS_SELLER = new XoActionType("PAY_ONLY_THIS_SELLER", 2);
        TERMS_AND_CONDITIONS = new XoActionType("TERMS_AND_CONDITIONS", 3);
        CONFIRM_AND_PAY = new XoActionType("CONFIRM_AND_PAY", 4);
        REMOVE_ITEM = new XoActionType("REMOVE_ITEM", 5);
        ADD_ITEM = new XoActionType("ADD_ITEM", 6);
        APPLY_INCENTIVE = new XoActionType("APPLY_INCENTIVE", 7);
        REMOVE_INCENTIVE = new XoActionType("REMOVE_INCENTIVE", 8);
        SELECT_PAYMENT_INSTRUMENT = new XoActionType("SELECT_PAYMENT_INSTRUMENT", 9);
        ADD_CARD_FUNDING_SOURCE = new XoActionType("ADD_CARD_FUNDING_SOURCE", 10);
        ADD_CREDIT_FUNDING_SOURCE = new XoActionType("ADD_CREDIT_FUNDING_SOURCE", 11);
        SWITCH_ACCOUNT = new XoActionType("SWITCH_ACCOUNT", 12);
        SHOW_SURVEY_PAGE = new XoActionType("SHOW_SURVEY_PAGE", 13);
        GO_TO_MY_EBAY = new XoActionType("GO_TO_MY_EBAY", 14);
        GO_TO_HOMEPAGE = new XoActionType("GO_TO_HOMEPAGE", 15);
        GO_TO_SHOPCART = new XoActionType("GO_TO_SHOPCART", 16);
        SAVE_CARD = new XoActionType("SAVE_CARD", 17);
        CANCEL_CARD = new XoActionType("CANCEL_CARD", 18);
        ADD_SHIPPING_ADDRESS = new XoActionType("ADD_SHIPPING_ADDRESS", 19);
        EDIT_SHIPPING_ADDRESS = new XoActionType("EDIT_SHIPPING_ADDRESS", 20);
        MAKE_ADDRESS_PRIMARY = new XoActionType("MAKE_ADDRESS_PRIMARY", 21);
        ADDRESS_SUBMIT = new XoActionType("ADDRESS_SUBMIT", 22);
        SHOW_LESS_ADDRESSES = new XoActionType("SHOW_LESS_ADDRESSES", 23);
        CANCEL_ADDRESS = new XoActionType("CANCEL_ADDRESS", 24);
        SHOW_MORE_ADDRESSES = new XoActionType("SHOW_MORE_ADDRESSES", 25);
        REDIRECT_TO_LEGACY_CHECKOUT = new XoActionType("REDIRECT_TO_LEGACY_CHECKOUT", 26);
        REDIRECT_TO_VIEW_ORDER_DETAILS = new XoActionType("REDIRECT_TO_VIEW_ORDER_DETAILS", 27);
        EDIT_ADDRESS = new XoActionType("EDIT_ADDRESS", 28);
        INCENTIVE_LINK = new XoActionType("INCENTIVE_LINK", 29);
        USE_THIS_ADDRESS = new XoActionType("USE_THIS_ADDRESS", 30);
        ADDRESS_BACK = new XoActionType("ADDRESS_BACK", 31);
        RESOLVE_PAYMENT_CONTINGENCY = new XoActionType("RESOLVE_PAYMENT_CONTINGENCY", 32);
        CANCEL_SELLER_MESSAGE = new XoActionType("CANCEL_SELLER_MESSAGE", 33);
        REMOVE_SELLER_MESSAGE = new XoActionType("REMOVE_SELLER_MESSAGE", 34);
        SUBMIT_SELLER_MESSAGE = new XoActionType("SUBMIT_SELLER_MESSAGE", 35);
        SEE_TERMS = new XoActionType("SEE_TERMS", 36);
        EDIT_PAYMENT_INSTRUMENT = new XoActionType("EDIT_PAYMENT_INSTRUMENT", 37);
        ACCEPT_AGREEMENT = new XoActionType("ACCEPT_AGREEMENT", 38);
        REQUEST_TOTAL = new XoActionType("REQUEST_TOTAL", 39);
        CANCEL_WARNING = new XoActionType("CANCEL_WARNING", 40);
        APPLY_WARNING = new XoActionType("APPLY_WARNING", 41);
        VALIDATE_CARD = new XoActionType("VALIDATE_CARD", 42);
        ADD_ANOTHER_CARD = new XoActionType("ADD_ANOTHER_CARD", 43);
        CHANGE_PAYMENT_METHOD = new XoActionType("CHANGE_PAYMENT_METHOD", 44);
        CHANGE_STORE = new XoActionType("CHANGE_STORE", 45);
        $VALUES = (new XoActionType[] {
            UNKNOWN, MESSAGE_TO_SELLER, PAY_ONLY_THIS_SELLER, TERMS_AND_CONDITIONS, CONFIRM_AND_PAY, REMOVE_ITEM, ADD_ITEM, APPLY_INCENTIVE, REMOVE_INCENTIVE, SELECT_PAYMENT_INSTRUMENT, 
            ADD_CARD_FUNDING_SOURCE, ADD_CREDIT_FUNDING_SOURCE, SWITCH_ACCOUNT, SHOW_SURVEY_PAGE, GO_TO_MY_EBAY, GO_TO_HOMEPAGE, GO_TO_SHOPCART, SAVE_CARD, CANCEL_CARD, ADD_SHIPPING_ADDRESS, 
            EDIT_SHIPPING_ADDRESS, MAKE_ADDRESS_PRIMARY, ADDRESS_SUBMIT, SHOW_LESS_ADDRESSES, CANCEL_ADDRESS, SHOW_MORE_ADDRESSES, REDIRECT_TO_LEGACY_CHECKOUT, REDIRECT_TO_VIEW_ORDER_DETAILS, EDIT_ADDRESS, INCENTIVE_LINK, 
            USE_THIS_ADDRESS, ADDRESS_BACK, RESOLVE_PAYMENT_CONTINGENCY, CANCEL_SELLER_MESSAGE, REMOVE_SELLER_MESSAGE, SUBMIT_SELLER_MESSAGE, SEE_TERMS, EDIT_PAYMENT_INSTRUMENT, ACCEPT_AGREEMENT, REQUEST_TOTAL, 
            CANCEL_WARNING, APPLY_WARNING, VALIDATE_CARD, ADD_ANOTHER_CARD, CHANGE_PAYMENT_METHOD, CHANGE_STORE
        });
    }
}
