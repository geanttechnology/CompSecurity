// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class c extends ArrayAdapter
{
    public static class a
    {

        public TextView mItemName;

        public a(View view)
        {
            mItemName = (TextView)view.findViewById(0x7f1002b8);
        }
    }


    private LayoutInflater mInflater;

    public c(Context context, List list)
    {
        super(context, 0x7f0300e3, list);
        mInflater = LayoutInflater.from(context);
    }

    private View a(int i, View view, ViewGroup viewgroup, int j)
    {
        if (view == null)
        {
            view = mInflater.inflate(j, viewgroup, false);
            viewgroup = new a(view);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (a)view.getTag();
        }
        ((a) (viewgroup)).mItemName.setText((CharSequence)getItem(i));
        return view;
    }

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        return a(i, view, viewgroup, 0x7f0300e4);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        return a(i, view, viewgroup, 0x7f0300e3);
    }
}
