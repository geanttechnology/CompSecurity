// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import com.target.ui.model.product.ListItem;

// Referenced classes of package com.target.ui.view.product:
//            ProductVariationView

private class <init>
    implements android.widget.tedListener
{

    final ProductVariationView this$0;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        if (ProductVariationView.d(ProductVariationView.this))
        {
            ProductVariationView.a(ProductVariationView.this, false);
            return;
        }
        adapterview = (ListItem)((this._cls0)ProductVariationView.e(ProductVariationView.this).dropDown.getAdapter()).getItem(i);
        view = getResources().getString(0x7f090490);
        if (adapterview.b().contains(view))
        {
            ProductVariationView.a(ProductVariationView.this, null);
            ProductVariationView.f(ProductVariationView.this).a(-1);
            ProductVariationView.g(ProductVariationView.this);
        } else
        {
            ProductVariationView.f(ProductVariationView.this).a(i);
            ProductVariationView.b(ProductVariationView.this, adapterview);
        }
        ProductVariationView.c(ProductVariationView.this, ProductVariationView.c(ProductVariationView.this));
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    private ews()
    {
        this$0 = ProductVariationView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
