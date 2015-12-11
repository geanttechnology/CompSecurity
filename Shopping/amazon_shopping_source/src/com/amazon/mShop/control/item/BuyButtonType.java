// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.item;


public final class BuyButtonType
{

    public static final BuyButtonType ADD_TO_CART = new BuyButtonType(132);
    public static final BuyButtonType ADD_TO_WISH_LIST = new BuyButtonType(272);
    public static final BuyButtonType BUY_NOW = new BuyButtonType(65);
    public static final BuyButtonType BUY_NOW_1_CLICK = new BuyButtonType(33);
    public static final BuyButtonType BUY_NOW_1_CLICK_PRIME = new BuyButtonType(545);
    public static final BuyButtonType FRIEND_APP_BUTTON = new BuyButtonType(264);
    public static final BuyButtonType PRE_ORDER_1_CLICK = new BuyButtonType(34);
    public static final BuyButtonType PRE_ORDER_1_CLICK_PRIME = new BuyButtonType(546);
    public static final BuyButtonType PRE_ORDER_NOW = new BuyButtonType(66);
    public static final BuyButtonType SEE_MORE_BUYING_OPTIONS = new BuyButtonType(260);
    public static final BuyButtonType SUBSCRIBER_AND_SAVE = new BuyButtonType(65);
    private final int type;

    private BuyButtonType(int i)
    {
        type = i;
    }

    public int getActionIcon()
    {
        return type & 0x1e0;
    }

    public int getStyleColor()
    {
        return type & 0x1f;
    }

}
