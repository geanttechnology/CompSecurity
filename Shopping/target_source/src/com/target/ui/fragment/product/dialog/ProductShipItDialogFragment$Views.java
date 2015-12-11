// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.target.ui.view.a;
import com.target.ui.view.product.ProductDialogPriceView;
import com.target.ui.view.product.ProductDialogWarningView;
import com.target.ui.view.product.ProductVariationView;

// Referenced classes of package com.target.ui.fragment.product.dialog:
//            ProductShipItDialogFragment

static class root extends a
{

    Button addToCart;
    ProductDialogPriceView priceView;
    final View root;
    TextView title;
    ProductVariationView variationsView;
    ProductDialogWarningView warningContainer;

    (View view)
    {
        super(view);
        root = view;
    }
}
