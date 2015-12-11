// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.cart;

import com.amazon.mShop.control.GenericSubscriber;
import com.amazon.rio.j2me.client.services.mShop.CartItem;
import com.amazon.rio.j2me.client.services.mShop.CartItems;

public interface CartSubscriber
    extends GenericSubscriber
{

    public abstract void onCartDidUpdateCheckOutTimerForItem(CartItem cartitem);

    public abstract void onCartReceived(CartItems cartitems);
}
