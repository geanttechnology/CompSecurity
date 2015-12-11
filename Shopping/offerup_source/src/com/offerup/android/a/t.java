// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.offerup.android.dto.FilterOption;
import java.util.List;

public final class t extends ArrayAdapter
{

    public t(Context context, int i, List list)
    {
        super(context, 0x1090008, list);
    }

    public final View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = ((LayoutInflater)viewgroup.getContext().getSystemService("layout_inflater")).inflate(0x7f0400cd, viewgroup, false);
        }
        view = (TextView)view1.findViewById(0x7f1002bf);
        if (i < getCount())
        {
            view.setText(((FilterOption)getItem(i)).getLongLabel());
        } else
        {
            view.setText("");
        }
        if (i < getCount())
        {
            view.setText(((FilterOption)getItem(i)).getLongLabel());
            return view;
        } else
        {
            view.setText("");
            return view;
        }
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = ((LayoutInflater)viewgroup.getContext().getSystemService("layout_inflater")).inflate(0x7f0400cd, viewgroup, false);
        }
        view = (TextView)view1.findViewById(0x7f1002bf);
        if (i < getCount())
        {
            view.setText(((FilterOption)getItem(i)).getLongLabel());
            return view;
        } else
        {
            view.setText("");
            return view;
        }
    }
}
