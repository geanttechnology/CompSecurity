// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.widget.ProgressBar;
import com.groupon.abtest.NewCartAbTestHelper;
import com.groupon.goods.shoppingcart.CartSummaryActivity;
import com.groupon.goods.shoppingcart.NewPurchaseCart;
import com.groupon.goods.shoppingcart.ShoppingCartControllerListener;
import com.groupon.goods.shoppingcart.ShoppingCartErrorHelper;

// Referenced classes of package com.groupon.activity:
//            MultiOptionActivity

private class <init>
    implements ShoppingCartControllerListener
{

    final MultiOptionActivity this$0;

    public void onCartCancel()
    {
        finish();
    }

    public void onCartException(Exception exception, boolean flag)
    {
        MultiOptionActivity.access$700(MultiOptionActivity.this, true);
        MultiOptionActivity.access$1400(MultiOptionActivity.this).shoudDisplayErrorDialog(exception, flag);
    }

    public void onCartReady()
    {
        if (MultiOptionActivity.access$300(MultiOptionActivity.this) != null)
        {
            loadingView.setVisibility(8);
        }
    }

    public void onItemAdded()
    {
        if (MultiOptionActivity.access$1300(MultiOptionActivity.this).shouldSkipSummary())
        {
            startActivity(NewPurchaseCart.openPurchaseCartIntent(MultiOptionActivity.this));
            return;
        } else
        {
            startActivity(CartSummaryActivity.openShoppingCartIntent(MultiOptionActivity.this));
            return;
        }
    }

    private ()
    {
        this$0 = MultiOptionActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
