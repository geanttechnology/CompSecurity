// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.cart;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.google.a.a.e;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.cart.interfaces.LimitedQuantityDetails;

public class a extends ArrayAdapter
{

    private static final int MAX_QUANTITY = 100;
    private final CartProduct mCartProduct;
    private final LayoutInflater mInflater;
    private final int mItemWidth;

    public a(Context context, CartProduct cartproduct)
    {
        super(context, 0x1090009);
        mInflater = LayoutInflater.from(context);
        mCartProduct = cartproduct;
        mItemWidth = context.getResources().getDimensionPixelSize(0x7f0a00e6);
    }

    public int getCount()
    {
        if (mCartProduct.j().b())
        {
            LimitedQuantityDetails limitedquantitydetails = (LimitedQuantityDetails)mCartProduct.j().c();
            if (limitedquantitydetails.a())
            {
                return limitedquantitydetails.b() + 1;
            }
        }
        if (mCartProduct.i().b())
        {
            return ((Integer)mCartProduct.i().c()).intValue() + 1;
        } else
        {
            return 100;
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        view = (TextView)getView(i, view, viewgroup);
        view.setText(Integer.toString(i));
        view.setTextColor(getContext().getResources().getColor(0x7f0f00f3));
        view.setWidth(mItemWidth);
        return view;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = mInflater.inflate(0x7f030119, viewgroup, false);
        }
        ((TextView)view1.findViewById(0x7f10033f)).setText(Integer.toString(i));
        return view1;
    }
}
