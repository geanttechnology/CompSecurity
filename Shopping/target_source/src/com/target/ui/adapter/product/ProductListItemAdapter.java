// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.ui.adapter.b.e;
import com.target.ui.view.product.PlpListItemView;
import java.util.List;

public class ProductListItemAdapter extends e
{
    static class ViewHolder extends com.target.ui.view.a
    {

        PlpListItemView listItemView;

        public ViewHolder(View view)
        {
            super(view);
        }
    }

    private class a extends com.target.ui.view.product.PlpListItemView.d
    {

        final ProductListItemAdapter this$0;

        public void a(ProductDetails productdetails)
        {
            if (ProductListItemAdapter.a(ProductListItemAdapter.this) != null)
            {
                ProductListItemAdapter.a(ProductListItemAdapter.this).a(productdetails);
            }
        }

        public void b(ProductDetails productdetails)
        {
            if (ProductListItemAdapter.a(ProductListItemAdapter.this) != null)
            {
                ProductListItemAdapter.a(ProductListItemAdapter.this).b(productdetails);
            }
        }

        public void c(ProductDetails productdetails)
        {
            if (ProductListItemAdapter.a(ProductListItemAdapter.this) != null)
            {
                ProductListItemAdapter.a(ProductListItemAdapter.this).c(productdetails);
            }
        }

        private a()
        {
            this$0 = ProductListItemAdapter.this;
            super();
        }

    }

    public static interface b
    {

        public abstract void a(ProductDetails productdetails);

        public abstract void b(ProductDetails productdetails);

        public abstract void c(ProductDetails productdetails);
    }


    private b mListener;

    protected ProductListItemAdapter(Context context, List list)
    {
        super(context, list);
    }

    static b a(ProductListItemAdapter productlistitemadapter)
    {
        return productlistitemadapter.mListener;
    }

    public static ProductListItemAdapter a(Context context, List list)
    {
        return new ProductListItemAdapter(context, list);
    }

    protected ViewHolder a(View view)
    {
        return new ViewHolder(view);
    }

    public void a(b b1)
    {
        mListener = b1;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        ProductDetails productdetails;
        if (view == null)
        {
            view = mInflater.inflate(0x7f0301ac, viewgroup, false);
            viewgroup = a(view);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        productdetails = (ProductDetails)getItem(i);
        ((ViewHolder) (viewgroup)).listItemView.setItemData(productdetails);
        ((ViewHolder) (viewgroup)).listItemView.setClickListener(new a());
        return view;
    }
}
