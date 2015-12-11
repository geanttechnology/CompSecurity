// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.checkout;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.target.ui.adapter.b.e;
import java.util.List;

public class com.target.ui.adapter.checkout.a extends e
{
    private class a
    {

        TextView stateCode;
        final com.target.ui.adapter.checkout.a this$0;

        public a(View view)
        {
            this$0 = com.target.ui.adapter.checkout.a.this;
            super();
            stateCode = (TextView)view.findViewById(0x7f1002b9);
        }
    }


    private final LayoutInflater mInflater;

    public com.target.ui.adapter.checkout.a(Context context, List list)
    {
        super(context, list);
        mInflater = LayoutInflater.from(context);
    }

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        view = (TextView)getView(i, view, viewgroup);
        view.setText((CharSequence)getItem(i));
        return view;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1;
        if (view == null)
        {
            view1 = mInflater.inflate(0x7f0300e6, viewgroup, false);
            view = new a(view1);
            view1.setTag(view);
            viewgroup = view;
        } else
        {
            viewgroup = (a)view.getTag();
            view1 = view;
        }
        ((a) (viewgroup)).stateCode.setText((CharSequence)getItem(i));
        if (i == 0)
        {
            ((a) (viewgroup)).stateCode.setTextColor(getContext().getResources().getColor(0x7f0f00e4));
            return view1;
        } else
        {
            ((a) (viewgroup)).stateCode.setTextColor(getContext().getResources().getColor(0x7f0f00f3));
            return view1;
        }
    }
}
