// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.a.a.f;
import com.target.ui.adapter.b.e;
import com.target.ui.model.pi_blackfriday_deals.PiBaseProduct;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.map.BlackFridayDealProductView;
import java.util.List;

public class BlackFridayDealProductAdapter extends e
{
    static class ViewHolder extends com.target.ui.view.a
    {

        int position;
        BlackFridayDealProductView productView;

        ViewHolder(View view)
        {
            super(view);
            position = -1;
        }
    }

    public static interface a
    {

        public abstract void a(PiBaseProduct pibaseproduct, BitmapImageView bitmapimageview);
    }


    private static final int NULL_INT = -1;
    private LayoutInflater mInflater;
    private a mListener;

    public BlackFridayDealProductAdapter(Context context, List list, a a1)
    {
        super(context, list);
        f.a(a1);
        mInflater = LayoutInflater.from(context);
        mListener = a1;
    }

    static a a(BlackFridayDealProductAdapter blackfridaydealproductadapter)
    {
        return blackfridaydealproductadapter.mListener;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        final PiBaseProduct product = (PiBaseProduct)getItem(i);
        if (view == null)
        {
            view = mInflater.inflate(0x7f03016c, null, false);
            viewgroup = new ViewHolder(view);
            view.setTag(viewgroup);
            ((ViewHolder) (viewgroup)).productView.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        viewgroup.position = i;
        ((ViewHolder) (viewgroup)).productView.b(product.a());
        ((ViewHolder) (viewgroup)).productView.a(product.c());
        ((ViewHolder) (viewgroup)).productView.a(product.d());
        ((ViewHolder) (viewgroup)).productView.setBlackFridayDealProductViewListener(new com.target.ui.view.map.BlackFridayDealProductView.a() {

            final BlackFridayDealProductAdapter this$0;
            final PiBaseProduct val$product;

            public void a(BitmapImageView bitmapimageview)
            {
                BlackFridayDealProductAdapter.a(BlackFridayDealProductAdapter.this).a(product, bitmapimageview);
            }

            
            {
                this$0 = BlackFridayDealProductAdapter.this;
                product = pibaseproduct;
                super();
            }
        });
        return view;
    }
}
