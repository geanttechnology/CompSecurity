// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart;

import com.groupon.models.shoppingCart.ShoppingCartResponse;
import com.groupon.service.DefaultShoppingCartServiceListenerImpl;

// Referenced classes of package com.groupon.goods.shoppingcart:
//            NewPurchaseCart

private class <init> extends DefaultShoppingCartServiceListenerImpl
{

    final NewPurchaseCart this$0;

    public void onCancel()
    {
        NewPurchaseCart.access$900(NewPurchaseCart.this);
    }

    public boolean onException(Exception exception)
    {
        return NewPurchaseCart.access$800(NewPurchaseCart.this, exception);
    }

    public void onSuccess(ShoppingCartResponse shoppingcartresponse)
    {
        NewPurchaseCart.access$700(NewPurchaseCart.this, shoppingcartresponse.cart);
    }

    private ()
    {
        this$0 = NewPurchaseCart.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
