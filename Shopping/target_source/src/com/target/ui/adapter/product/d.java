// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.product;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.product.PlpCardView;
import java.util.List;

public class d extends android.support.v7.widget.RecyclerView.a
{
    public static interface a
    {

        public abstract void a(BitmapImageView bitmapimageview, ProductDetails productdetails);
    }

    private class b
        implements android.view.View.OnClickListener
    {

        final BitmapImageView mImage;
        final ProductDetails mProduct;
        final d this$0;

        public void onClick(View view)
        {
            if (d.a(d.this) == null)
            {
                return;
            } else
            {
                d.a(d.this).a(mImage, mProduct);
                return;
            }
        }

        b(BitmapImageView bitmapimageview, ProductDetails productdetails)
        {
            this$0 = d.this;
            super();
            mImage = bitmapimageview;
            mProduct = productdetails;
        }
    }

    public static class c extends android.support.v7.widget.RecyclerView.t
    {

        public c(View view)
        {
            super(view);
        }
    }


    private a mListener;
    private List mRecommendedProducts;

    public d(List list)
    {
        mRecommendedProducts = list;
    }

    static a a(d d1)
    {
        return d1.mListener;
    }

    public int a()
    {
        return mRecommendedProducts.size();
    }

    public android.support.v7.widget.RecyclerView.t a(ViewGroup viewgroup, int i)
    {
        return c(viewgroup, i);
    }

    public volatile void a(android.support.v7.widget.RecyclerView.t t, int i)
    {
        a((c)t, i);
    }

    public void a(a a1)
    {
        mListener = a1;
    }

    public void a(c c1, int i)
    {
        ProductDetails productdetails = (ProductDetails)mRecommendedProducts.get(i);
        c1 = (PlpCardView)c1.itemView;
        if (c1 == null)
        {
            return;
        } else
        {
            c1.setOnClickListener(new b(c1.getBitmapImageView(), productdetails));
            c1.setItemData(productdetails);
            return;
        }
    }

    public c c(ViewGroup viewgroup, int i)
    {
        return new c(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030194, viewgroup, false));
    }
}
