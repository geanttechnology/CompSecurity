// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.common.OrderProductImage;
import com.target.ui.adapter.b.c;
import com.target.ui.util.al;
import com.target.ui.util.d.b;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.a;

public class CheckoutProductDetailsView extends LinearLayout
{
    static class Views extends a
    {

        BitmapImageView productImage;
        TextView productPrice;
        View productRootView;
        TextView productTitle;

        Views(View view)
        {
            super(view);
        }
    }


    private int mImageSize;
    private Views mViews;

    public CheckoutProductDetailsView(Context context)
    {
        super(context);
        mViews = null;
        a(context);
    }

    public CheckoutProductDetailsView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mViews = null;
        a(context);
    }

    public CheckoutProductDetailsView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mViews = null;
        a(context);
    }

    private void a(BitmapImageView bitmapimageview, CartProduct cartproduct)
    {
        if (bitmapimageview == null)
        {
            return;
        } else
        {
            cartproduct = cartproduct.b().a(mImageSize);
            c.a(getContext(), cartproduct, bitmapimageview);
            al.b(bitmapimageview);
            return;
        }
    }

    public void a(Context context)
    {
        setOrientation(1);
        inflate(context, 0x7f030138, this);
        mViews = new Views(this);
        mImageSize = context.getResources().getDimensionPixelSize(0x7f0a00de);
    }

    public void a(CartProduct cartproduct)
    {
        a(mViews.productImage, cartproduct);
        mViews.productTitle.setText(cartproduct.g());
        mViews.productPrice.setText(b.a(cartproduct.h_()));
    }
}
