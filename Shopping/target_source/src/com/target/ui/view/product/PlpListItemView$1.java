// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import com.target.mothership.model.product.interfaces.ProductDetails;

// Referenced classes of package com.target.ui.view.product:
//            PlpListItemView

class s.ProductDetails
    implements android.view.er
{

    final PlpListItemView this$0;
    final ProductDetails val$productDetails;

    public void onClick(View view)
    {
        if (PlpListItemView.a(PlpListItemView.this) == null)
        {
            return;
        } else
        {
            PlpListItemView.a(PlpListItemView.this).a(val$productDetails);
            return;
        }
    }

    s.ProductDetails()
    {
        this$0 = final_plplistitemview;
        val$productDetails = ProductDetails.this;
        super();
    }
}
