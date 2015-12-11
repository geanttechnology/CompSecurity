// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.mothership.model.common.OrderProductImage;
import com.target.mothership.model.guest.interfaces.OrderDetailsProduct;
import com.target.ui.adapter.b.c;
import com.target.ui.util.al;
import com.target.ui.util.d.a;
import com.target.ui.view.BitmapImageView;
import java.util.List;

public class AccountOrderDetailsProductDetailsView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        BitmapImageView productImage;
        TextView productPrice;
        TextView productQuantity;
        View productRootView;
        View productSeparator;
        TextView productStatus;
        TextView productTitle;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a(OrderDetailsProduct orderdetailsproduct, BitmapImageView bitmapimageview);
    }


    private int mImageSize;
    private Views mViews;

    public AccountOrderDetailsProductDetailsView(Context context)
    {
        super(context);
        mViews = null;
        a(context);
    }

    public AccountOrderDetailsProductDetailsView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mViews = null;
        a(context);
    }

    public AccountOrderDetailsProductDetailsView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mViews = null;
        a(context);
    }

    static Views a(AccountOrderDetailsProductDetailsView accountorderdetailsproductdetailsview)
    {
        return accountorderdetailsproductdetailsview.mViews;
    }

    private void a(BitmapImageView bitmapimageview, OrderDetailsProduct orderdetailsproduct)
    {
        if (bitmapimageview == null)
        {
            return;
        }
        if (orderdetailsproduct.a() == null)
        {
            orderdetailsproduct = null;
        } else
        {
            orderdetailsproduct = (OrderProductImage)orderdetailsproduct.a().get(0);
        }
        if (orderdetailsproduct != null)
        {
            orderdetailsproduct = orderdetailsproduct.a(mImageSize);
            c.a(getContext(), orderdetailsproduct, bitmapimageview);
            al.b(bitmapimageview);
            return;
        } else
        {
            bitmapimageview.setImageResource(0x7f0201ae);
            al.b(bitmapimageview);
            return;
        }
    }

    public void a(Context context)
    {
        setOrientation(1);
        inflate(context, 0x7f0300f9, this);
        mViews = new Views(this);
        mImageSize = context.getResources().getDimensionPixelSize(0x7f0a00ac);
    }

    public void a(final OrderDetailsProduct product, final a productClickListener)
    {
        a(mViews.productImage, product);
        mViews.productTitle.setText(product.g());
        mViews.productStatus.setText(product.c());
        mViews.productPrice.setText(com.target.ui.util.d.a.a(product.b()));
        mViews.productQuantity.setText(String.valueOf(product.i()));
        mViews.productRootView.setOnClickListener(new android.view.View.OnClickListener() {

            final AccountOrderDetailsProductDetailsView this$0;
            final OrderDetailsProduct val$product;
            final a val$productClickListener;

            public void onClick(View view)
            {
                if (productClickListener != null)
                {
                    productClickListener.a(product, com.target.ui.view.account.AccountOrderDetailsProductDetailsView.a(AccountOrderDetailsProductDetailsView.this).productImage);
                }
            }

            
            {
                this$0 = AccountOrderDetailsProductDetailsView.this;
                productClickListener = a1;
                product = orderdetailsproduct;
                super();
            }
        });
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            al.b(mViews.productSeparator);
            return;
        } else
        {
            al.c(mViews.productSeparator);
            return;
        }
    }
}
