// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.ui.adapter.product.c;
import com.target.ui.model.product.GridItem;
import com.target.ui.model.product.ListItem;
import com.target.ui.model.product.ProductVariationModel;
import com.target.ui.util.al;

// Referenced classes of package com.target.ui.view.product:
//            ProductDialogPriceView, ProductVariationView, ProductDialogWarningView, a

public abstract class ProductDialogHeaderView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        ProductDialogPriceView priceView;
        ProductVariationView variationView;
        ProductDialogWarningView warningView;

        public Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a();

        public abstract void a(GridItem griditem);

        public abstract void a(ListItem listitem, GridItem griditem);
    }

    private class b
        implements ProductVariationView.b
    {

        final ProductDialogHeaderView this$0;

        public void a()
        {
            if (ProductDialogHeaderView.a(ProductDialogHeaderView.this) != null)
            {
                ProductDialogHeaderView.a(ProductDialogHeaderView.this).a();
            }
        }

        public void a(GridItem griditem)
        {
            if (ProductDialogHeaderView.a(ProductDialogHeaderView.this) != null)
            {
                ProductDialogHeaderView.a(ProductDialogHeaderView.this).a(griditem);
            }
        }

        public void a(ListItem listitem, GridItem griditem)
        {
            if (ProductDialogHeaderView.a(ProductDialogHeaderView.this) != null)
            {
                ProductDialogHeaderView.a(ProductDialogHeaderView.this).a(listitem, griditem);
            }
        }

        private b()
        {
            this$0 = ProductDialogHeaderView.this;
            super();
        }

    }


    private a mListener;
    private ProductVariationModel mProductVariationModel;
    private Views mViews;

    public ProductDialogHeaderView(Context context)
    {
        super(context);
        a(context);
    }

    public ProductDialogHeaderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public ProductDialogHeaderView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    static a a(ProductDialogHeaderView productdialogheaderview)
    {
        return productdialogheaderview.mListener;
    }

    private void a(Context context)
    {
        inflate(context, 0x7f0301c0, this);
        mViews = new Views(this);
        mViews.priceView.setFulfillmentType(getFulfillmentType());
    }

    public void a(ProductDetails productdetails)
    {
        if (a())
        {
            com.target.ui.adapter.product.c.a(mViews.priceView, productdetails);
        }
    }

    public void a(ProductVariationModel productvariationmodel)
    {
        if (productvariationmodel == null || productvariationmodel.a().equals(com.target.ui.model.product.ProductVariationModel.a.NONE))
        {
            al.c(mViews.variationView);
            return;
        } else
        {
            mProductVariationModel = productvariationmodel;
            mViews.variationView.a(mProductVariationModel);
            mViews.variationView.setClickListener(new b());
            al.b(mViews.variationView);
            return;
        }
    }

    public void a(String s, String s1)
    {
        mViews.warningView.a(s, s1, true);
        al.b(mViews.warningView);
    }

    protected abstract boolean a();

    public void b()
    {
        if (mViews != null)
        {
            mViews.variationView.a();
        }
        mViews = null;
    }

    public void c()
    {
        al.c(mViews.warningView);
    }

    protected abstract com.target.ui.view.product.a getFulfillmentType();

    public ProductVariationModel getVariationModel()
    {
        return mProductVariationModel;
    }

    public void setClickListener(a a1)
    {
        mListener = a1;
    }
}
