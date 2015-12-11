// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.offerup.android.dto.Category;

public final class h extends ArrayAdapter
{

    public h(Context context, int i)
    {
        super(context, 0x1090008);
    }

    private Category a(int i)
    {
        if (i == 0 || i > super.getCount())
        {
            return null;
        } else
        {
            return (Category)super.getItem(i - 1);
        }
    }

    public final int getCount()
    {
        return super.getCount() + 1;
    }

    public final View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        Category category;
        if (view != null)
        {
            view = (TextView)view;
        } else
        {
            view = new TextView(getContext());
            view.setTextColor(getContext().getResources().getColor(0x7f0e00e9));
            view.setTextSize(22F);
            view.setPadding(20, 10, 20, 10);
            view.setBackgroundResource(0x7f0201e5);
            view.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, -2));
        }
        category = a(i);
        if (category != null)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        if (category != null)
        {
            viewgroup = category.getName();
        } else
        {
            viewgroup = "";
        }
        view.setText(viewgroup);
        if (category == null)
        {
            view.getLayoutParams().height = 1;
            return view;
        } else
        {
            view.getLayoutParams().height = -2;
            return view;
        }
    }

    public final Object getItem(int i)
    {
        return a(i);
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view != null)
        {
            view = (TextView)view;
        } else
        {
            view = new TextView(getContext());
            view.setTextColor(getContext().getResources().getColor(0x7f0e00e9));
            view.setTextSize(18F);
        }
        viewgroup = a(i);
        if (viewgroup != null)
        {
            viewgroup = viewgroup.getName();
        } else
        {
            viewgroup = getContext().getString(0x7f0900eb);
        }
        view.setText(viewgroup);
        return view;
    }
}
