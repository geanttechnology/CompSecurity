// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller;

import android.content.Context;
import android.content.Intent;
import com.groupon.abtest.NewCartAbTestHelper;
import com.groupon.goods.shoppingcart.CartSummaryActivity;
import com.groupon.goods.shoppingcart.NewPurchaseCart;
import com.groupon.goods.shoppingcart.ShoppingCartControllerListener;
import com.groupon.goods.shoppingcart.ShoppingCartErrorHelper;

// Referenced classes of package com.groupon.mvc.controller:
//            BottomBarController

private class <init>
    implements ShoppingCartControllerListener
{

    final BottomBarController this$0;

    public void onCartCancel()
    {
        BottomBarController.access$1802(BottomBarController.this, true);
        updateBuyButtonText();
        updateShoppingCartCounter();
        if (BottomBarController.access$2000(BottomBarController.this) != null)
        {
            BottomBarController.access$2000(BottomBarController.this).onFinish();
        }
    }

    public void onCartException(Exception exception, boolean flag)
    {
        BottomBarController.access$1802(BottomBarController.this, true);
        updateBuyButtonText();
        updateShoppingCartCounter();
        BottomBarController.access$1900(BottomBarController.this).shoudDisplayErrorDialog(exception, flag);
    }

    public void onCartReady()
    {
        updateBuyButtonView();
    }

    public void onItemAdded()
    {
        if (BottomBarController.access$2100(BottomBarController.this).shouldSkipSummary())
        {
            Intent intent = NewPurchaseCart.openPurchaseCartIntent(BottomBarController.access$800(BottomBarController.this)).putExtra("coming_from_deal_details", true);
            BottomBarController.access$800(BottomBarController.this).startActivity(intent);
            return;
        } else
        {
            Intent intent1 = CartSummaryActivity.openShoppingCartIntent(BottomBarController.access$800(BottomBarController.this)).putExtra("coming_from_deal_details", true);
            BottomBarController.access$800(BottomBarController.this).startActivity(intent1);
            return;
        }
    }

    private ener()
    {
        this$0 = BottomBarController.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
