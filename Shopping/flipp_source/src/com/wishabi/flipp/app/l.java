// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.wishabi.flipp.content.g;

public final class l extends BaseAdapter
{

    private final Context a;
    private String b[];

    public l(Context context, String as[])
    {
        a = context;
        b = as;
    }

    public final int getCount()
    {
        if (b == null)
        {
            return 0;
        } else
        {
            return b.length;
        }
    }

    public final View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        boolean flag = false;
        view = (TextView)view;
        if (view == null)
        {
            view = (TextView)LayoutInflater.from(a).inflate(0x7f03001a, viewgroup, false);
        }
        view.setText(g.a(b[i]));
        viewgroup = b[i];
        if (TextUtils.isEmpty(viewgroup))
        {
            i = ((flag) ? 1 : 0);
        } else
        if (viewgroup.equalsIgnoreCase("All Deals"))
        {
            i = 0x7f02008b;
        } else
        if (viewgroup.equalsIgnoreCase("Baby"))
        {
            i = 0x7f02008d;
        } else
        if (viewgroup.equalsIgnoreCase("Grocery"))
        {
            i = 0x7f020094;
        } else
        if (viewgroup.equalsIgnoreCase("Household"))
        {
            i = 0x7f020095;
        } else
        if (viewgroup.equalsIgnoreCase("Pets"))
        {
            i = 0x7f020098;
        } else
        if (viewgroup.equalsIgnoreCase("Health & Beauty"))
        {
            i = 0x7f020099;
        } else
        {
            viewgroup.equalsIgnoreCase("Other");
            i = 0x7f020097;
        }
        view.setCompoundDrawablesWithIntrinsicBounds(a.getResources().getDrawable(i), null, null, null);
        view.setBackgroundResource(0x7f09006c);
        return view;
    }

    public final Object getItem(int i)
    {
        return null;
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        view = (TextView)view;
        if (view == null)
        {
            view = (TextView)LayoutInflater.from(a).inflate(0x7f03001a, viewgroup, false);
        }
        view.setText(g.a(b[i]));
        view.setBackgroundColor(0);
        view.setTextColor(-1);
        return view;
    }
}
