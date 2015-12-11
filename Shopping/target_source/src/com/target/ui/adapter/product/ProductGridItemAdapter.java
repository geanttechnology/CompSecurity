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
import com.target.ui.view.a;
import com.target.ui.view.product.PlpCardView;
import java.util.List;

public class ProductGridItemAdapter extends e
{
    static class ViewHolder extends a
    {

        PlpCardView plpCardView;

        public ViewHolder(View view)
        {
            super(view);
        }
    }


    protected ProductGridItemAdapter(Context context, List list)
    {
        super(context, list);
    }

    public static ProductGridItemAdapter a(Context context, List list)
    {
        return new ProductGridItemAdapter(context, list);
    }

    protected int a()
    {
        return 0x7f0301a6;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        ProductDetails productdetails;
        if (view == null)
        {
            view = mInflater.inflate(a(), viewgroup, false);
            viewgroup = new ViewHolder(view);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        productdetails = (ProductDetails)getItem(i);
        ((ViewHolder) (viewgroup)).plpCardView.setItemData(productdetails);
        return view;
    }
}
