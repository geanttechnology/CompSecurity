// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart;

import com.groupon.models.shoppingCart.ShoppingCartResponse;
import com.groupon.service.DefaultShoppingCartServiceListenerImpl;

// Referenced classes of package com.groupon.goods.shoppingcart:
//            ShoppingCartPresenter

private class <init> extends DefaultShoppingCartServiceListenerImpl
{

    final ShoppingCartPresenter this$0;

    public void onCancel()
    {
        cartCacheCancelled();
    }

    public boolean onException(Exception exception)
    {
        cartCacheFailure(exception, true);
        return false;
    }

    public void onSuccess(ShoppingCartResponse shoppingcartresponse)
    {
        cartCacheSuccess(shoppingcartresponse.cart);
    }

    private ()
    {
        this$0 = ShoppingCartPresenter.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
