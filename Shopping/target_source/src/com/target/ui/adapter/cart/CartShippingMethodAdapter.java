// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.cart.interfaces.UsableShipMode;
import com.target.mothership.util.o;
import com.target.ui.adapter.b.e;
import com.target.ui.util.al;
import com.target.ui.util.d;
import com.target.ui.util.u;
import com.target.ui.view.a;
import java.util.List;

public class CartShippingMethodAdapter extends e
    implements android.view.View.OnClickListener
{
    static class ViewHolder extends a
    {

        int position;
        RadioButton shipMethodChoice;
        TextView shipMethodDeliveryDate;
        TextView shipMethodName;

        ViewHolder(View view)
        {
            super(view);
        }
    }


    private final CartProduct mCartProduct;
    private final LayoutInflater mInflater;
    private int mSelectedPosition;
    private final List mUsableShippingModes;

    public CartShippingMethodAdapter(Context context, List list, CartProduct cartproduct)
    {
        super(context, list);
        mInflater = LayoutInflater.from(context);
        mUsableShippingModes = list;
        mCartProduct = cartproduct;
        b();
    }

    private void a(TextView textview, UsableShipMode usableshipmode)
    {
        if (usableshipmode.c() != null)
        {
            if (mCartProduct.o() && mCartProduct.p() == null)
            {
                al.c(textview);
                return;
            }
            usableshipmode = d.a(getContext(), usableshipmode);
            if (o.g(usableshipmode))
            {
                al.a(textview, usableshipmode);
                return;
            } else
            {
                al.c(textview);
                return;
            }
        } else
        {
            al.c(textview);
            return;
        }
    }

    private void b()
    {
        for (int i = 0; i < mUsableShippingModes.size(); i++)
        {
            if (((UsableShipMode)mUsableShippingModes.get(i)).a() == mCartProduct.c())
            {
                mSelectedPosition = i;
                return;
            }
        }

        mSelectedPosition = 0;
    }

    public UsableShipMode a()
    {
        return (UsableShipMode)mUsableShippingModes.get(mSelectedPosition);
    }

    public int getCount()
    {
        return mUsableShippingModes.size();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        boolean flag = false;
        UsableShipMode usableshipmode = (UsableShipMode)getItem(i);
        RadioButton radiobutton;
        if (view == null)
        {
            view = mInflater.inflate(0x7f030120, null, false);
            viewgroup = new ViewHolder(view);
            view.setTag(viewgroup);
            view.setOnClickListener(this);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        viewgroup.position = i;
        radiobutton = ((ViewHolder) (viewgroup)).shipMethodChoice;
        if (i == mSelectedPosition)
        {
            flag = true;
        }
        radiobutton.setChecked(flag);
        ((ViewHolder) (viewgroup)).shipMethodChoice.setTag(viewgroup);
        ((ViewHolder) (viewgroup)).shipMethodChoice.setOnClickListener(this);
        ((ViewHolder) (viewgroup)).shipMethodName.setText(d.a(view.getContext(), usableshipmode.a()));
        a(((ViewHolder) (viewgroup)).shipMethodDeliveryDate, usableshipmode);
        return view;
    }

    public void onClick(View view)
    {
        for (view = (ViewHolder)u.a(view.getTag(), com/target/ui/adapter/cart/CartShippingMethodAdapter$ViewHolder); view == null || mSelectedPosition == ((ViewHolder) (view)).position;)
        {
            return;
        }

        mSelectedPosition = ((ViewHolder) (view)).position;
        notifyDataSetChanged();
    }
}
