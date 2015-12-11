// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.e;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.target.ui.adapter.b.e;
import java.util.List;

public class c extends e
{

    public c(Context context, List list)
    {
        super(context, list);
    }

    private View a(int i, ViewGroup viewgroup)
    {
        viewgroup = LayoutInflater.from(getContext()).inflate(0x7f0301df, viewgroup, false);
        TextView textview = (TextView)viewgroup.findViewById(0x7f100587);
        textview.setText((String)getItem(i));
        if (i == 0)
        {
            textview.setTextColor(getContext().getResources().getColor(0x7f0f00e4));
            return viewgroup;
        } else
        {
            textview.setTextColor(getContext().getResources().getColor(0x7f0f00f3));
            return viewgroup;
        }
    }

    private View b(int i, ViewGroup viewgroup)
    {
        viewgroup = LayoutInflater.from(getContext()).inflate(0x7f0301de, viewgroup, false);
        TextView textview = (TextView)viewgroup.findViewById(0x7f100586);
        textview.setText((String)getItem(i));
        if (i == 0)
        {
            textview.setTextColor(getContext().getResources().getColor(0x7f0f00e4));
            return viewgroup;
        } else
        {
            textview.setTextColor(getContext().getResources().getColor(0x7f0f00f3));
            return viewgroup;
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        return b(i, viewgroup);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        return a(i, viewgroup);
    }
}
