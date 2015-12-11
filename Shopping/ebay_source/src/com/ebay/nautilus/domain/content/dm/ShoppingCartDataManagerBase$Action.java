// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;


// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            ShoppingCartDataManagerBase

public static final class needsAdditionalData extends Enum
{

    private static final CREATE_CHECKOUT_SESSION $VALUES[];
    public static final CREATE_CHECKOUT_SESSION ADD_TO_CART;
    public static final CREATE_CHECKOUT_SESSION CREATE_CHECKOUT_SESSION;
    public static final CREATE_CHECKOUT_SESSION GET_AND_VALIDATE_CART;
    public static final CREATE_CHECKOUT_SESSION GET_CART;
    public static final CREATE_CHECKOUT_SESSION MOVE_TO_CART;
    public static final CREATE_CHECKOUT_SESSION MOVE_TO_SAVE_FOR_LATER;
    public static final CREATE_CHECKOUT_SESSION REMOVE_FROM_CART;
    public static final CREATE_CHECKOUT_SESSION REMOVE_FROM_SAVE_FOR_LATER;
    public static final CREATE_CHECKOUT_SESSION SET_ITEM_QUANTITY;
    public static final CREATE_CHECKOUT_SESSION SET_SHIPPING_ADDRESS;
    public static final CREATE_CHECKOUT_SESSION UNKNOWN;
    public final boolean hasValidation;
    public final boolean isCacheable;
    public final boolean needsAdditionalData;

    public static needsAdditionalData valueOf(String s)
    {
        return (needsAdditionalData)Enum.valueOf(com/ebay/nautilus/domain/content/dm/ShoppingCartDataManagerBase$Action, s);
    }

    public static needsAdditionalData[] values()
    {
        return (needsAdditionalData[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0, false, false, false);
        GET_CART = new <init>("GET_CART", 1, false, true, false);
        GET_AND_VALIDATE_CART = new <init>("GET_AND_VALIDATE_CART", 2, true, true, true);
        ADD_TO_CART = new <init>("ADD_TO_CART", 3, false, true, false);
        MOVE_TO_SAVE_FOR_LATER = new <init>("MOVE_TO_SAVE_FOR_LATER", 4, false, true, true);
        MOVE_TO_CART = new <init>("MOVE_TO_CART", 5, false, true, true);
        REMOVE_FROM_SAVE_FOR_LATER = new <init>("REMOVE_FROM_SAVE_FOR_LATER", 6, false, true, true);
        REMOVE_FROM_CART = new <init>("REMOVE_FROM_CART", 7, false, true, true);
        SET_ITEM_QUANTITY = new <init>("SET_ITEM_QUANTITY", 8, false, true, true);
        SET_SHIPPING_ADDRESS = new <init>("SET_SHIPPING_ADDRESS", 9, false, false, false);
        CREATE_CHECKOUT_SESSION = new <init>("CREATE_CHECKOUT_SESSION", 10, false, false, false);
        $VALUES = (new .VALUES[] {
            UNKNOWN, GET_CART, GET_AND_VALIDATE_CART, ADD_TO_CART, MOVE_TO_SAVE_FOR_LATER, MOVE_TO_CART, REMOVE_FROM_SAVE_FOR_LATER, REMOVE_FROM_CART, SET_ITEM_QUANTITY, SET_SHIPPING_ADDRESS, 
            CREATE_CHECKOUT_SESSION
        });
    }

    private (String s, int i, boolean flag, boolean flag1, boolean flag2)
    {
        super(s, i);
        hasValidation = flag;
        isCacheable = flag1;
        needsAdditionalData = flag2;
    }
}
