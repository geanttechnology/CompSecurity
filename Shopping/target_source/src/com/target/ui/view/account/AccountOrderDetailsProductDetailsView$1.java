// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.view.View;
import com.target.mothership.model.guest.interfaces.OrderDetailsProduct;

// Referenced classes of package com.target.ui.view.account:
//            AccountOrderDetailsProductDetailsView

class val.product
    implements android.view.DetailsView._cls1
{

    final AccountOrderDetailsProductDetailsView this$0;
    final OrderDetailsProduct val$product;
    final ews.productImage val$productClickListener;

    public void onClick(View view)
    {
        if (val$productClickListener != null)
        {
            val$productClickListener.a(val$product, AccountOrderDetailsProductDetailsView.a(AccountOrderDetailsProductDetailsView.this).productImage);
        }
    }

    ews()
    {
        this$0 = final_accountorderdetailsproductdetailsview;
        val$productClickListener = ews;
        val$product = OrderDetailsProduct.this;
        super();
    }
}
