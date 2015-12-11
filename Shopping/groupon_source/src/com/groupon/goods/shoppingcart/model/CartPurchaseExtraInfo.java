// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart.model;

import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.models.shoppingCart.ShoppingCartSubtotal;

public class CartPurchaseExtraInfo extends JsonEncodedNSTField
{

    public int cartSize;
    public ShoppingCartSubtotal cartTotal;

    public CartPurchaseExtraInfo()
    {
    }
}
