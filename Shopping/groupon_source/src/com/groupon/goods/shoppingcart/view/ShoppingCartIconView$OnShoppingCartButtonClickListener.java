// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart.view;

import android.content.Context;
import android.view.View;
import com.groupon.goods.shoppingcart.model.CartIconClickExtraInfo;
import com.groupon.service.ShoppingCartService;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.goods.shoppingcart.view:
//            ShoppingCartIconView

private class <init>
    implements android.view.artButtonClickListener
{

    final ShoppingCartIconView this$0;

    public void onClick(View view)
    {
        view = new CartIconClickExtraInfo();
        view.cartSize = ShoppingCartIconView.access$200(ShoppingCartIconView.this).getCartItemsCount();
        ShoppingCartIconView.access$400(ShoppingCartIconView.this).logClick("", "cart", ShoppingCartIconView.access$300(ShoppingCartIconView.this).getClass().getSimpleName(), Logger.NULL_NST_FIELD, view);
        ShoppingCartIconView.access$300(ShoppingCartIconView.this).startActivity(ShoppingCartIconView.access$200(ShoppingCartIconView.this).getOpenCartIntent());
    }

    private ()
    {
        this$0 = ShoppingCartIconView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
