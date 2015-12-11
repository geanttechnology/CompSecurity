// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart;

import com.groupon.models.shoppingCart.ShoppingCartResponse;
import com.groupon.service.DefaultShoppingCartServiceListenerImpl;

// Referenced classes of package com.groupon.goods.shoppingcart:
//            CartSummaryPresenter

private class isRecoverable extends DefaultShoppingCartServiceListenerImpl
{

    private final boolean isRecoverable;
    final CartSummaryPresenter this$0;

    public void onCancel()
    {
        onCartCancel(isRecoverable);
    }

    public boolean onException(Exception exception)
    {
        return onCartException(exception);
    }

    public void onSuccess(ShoppingCartResponse shoppingcartresponse)
    {
        onCartResponse(shoppingcartresponse.cart);
    }

    public (boolean flag)
    {
        this$0 = CartSummaryPresenter.this;
        super();
        isRecoverable = flag;
    }
}
