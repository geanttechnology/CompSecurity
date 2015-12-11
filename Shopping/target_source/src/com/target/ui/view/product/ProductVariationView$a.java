// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import android.widget.AdapterView;
import com.target.ui.model.product.GridItem;

// Referenced classes of package com.target.ui.view.product:
//            ProductVariationView, FixedHeightGridView

private class <init>
    implements android.widget.Listener
{

    final ProductVariationView this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (oductVariationGridAdapter)ProductVariationView.e(ProductVariationView.this).gridView.getAdapter();
        if (adapterview.b() == i)
        {
            adapterview.a(-1);
        } else
        {
            adapterview.a(i);
        }
        if (adapterview.a())
        {
            ProductVariationView.a(ProductVariationView.this, (GridItem)adapterview.getItem(i));
            ProductVariationView.b(ProductVariationView.this, ProductVariationView.b(ProductVariationView.this));
            return;
        } else
        {
            ProductVariationView.c(ProductVariationView.this, null);
            ProductVariationView.b(ProductVariationView.this, ProductVariationView.b(ProductVariationView.this));
            ProductVariationView.g(ProductVariationView.this);
            return;
        }
    }

    private oductVariationGridAdapter()
    {
        this$0 = ProductVariationView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
