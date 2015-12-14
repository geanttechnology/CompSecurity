// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class v extends ArrayAdapter
{

    private int a;
    private int b;
    private int c;
    private LayoutInflater d;

    public v(Context context, int i, int j, int k)
    {
        super(context, 0);
        a = i;
        b = j;
        c = k;
        d = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = d.inflate(a, viewgroup, false);
        }
        view = (String)getItem(i);
        viewgroup = (TextView)view1.findViewById(b);
        if (viewgroup != null)
        {
            viewgroup.setText(view);
        }
        view = (ImageView)view1.findViewById(c);
        if (view != null)
        {
            view.setSelected(false);
        }
        return view1;
    }
}
