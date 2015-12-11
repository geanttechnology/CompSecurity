// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart.event;

import com.groupon.models.shoppingCart.ShoppingCartItem;

public class ShoppingCartItemEditModeToggledEvent
{

    public final ShoppingCartItem item;

    public ShoppingCartItemEditModeToggledEvent(ShoppingCartItem shoppingcartitem)
    {
        item = shoppingcartitem;
    }
}
