// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.c.a.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.b.a.a.j;

// Referenced classes of package com.offerup.android.a:
//            ae

public final class ad extends BaseAdapter
{

    private String a[];
    private Context b;
    private TypedArray c;
    private int d;

    public ad(Context context, int i)
    {
        b = context;
        d = i;
        a = context.getResources().getStringArray(0x7f0f0002);
        c = context.getResources().obtainTypedArray(0x7f0f0001);
    }

    public final int getCount()
    {
        return a.length;
    }

    public final Object getItem(int i)
    {
        if (a != null && a[i] != null)
        {
            return a[i];
        } else
        {
            return null;
        }
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        android.graphics.drawable.Drawable drawable;
        if (view == null)
        {
            view = LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0400ad, viewgroup, false);
            viewgroup = new ae(this);
            viewgroup.a = (TextView)view.findViewById(0x7f10028b);
            viewgroup.b = (TextView)view.findViewById(0x7f10028c);
            viewgroup.c = view;
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ae)view.getTag();
        }
        ((ae) (viewgroup)).a.setText(a[i]);
        drawable = android.support.v4.c.a.a.c(c.getDrawable(i));
        if (d == i)
        {
            android.support.v4.c.a.a.a(drawable, b.getResources().getColor(0x7f0e00dd));
            ((ae) (viewgroup)).a.setTextColor(b.getResources().getColor(0x7f0e00dd));
            ((ae) (viewgroup)).a.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
            ((ae) (viewgroup)).c.setBackgroundResource(0x7f02017e);
        } else
        {
            android.support.v4.c.a.a.a(drawable, b.getResources().getColor(0x7f0e00ce));
            ((ae) (viewgroup)).a.setTextColor(b.getResources().getColor(0x7f0e00ce));
            ((ae) (viewgroup)).a.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
            ((ae) (viewgroup)).c.setBackgroundResource(0x7f020214);
        }
        if (b.getString(0x7f09016b).equals(a[i]) && j.a().T() > 0)
        {
            ((ae) (viewgroup)).b.setText(String.valueOf(j.a().T()));
            ((ae) (viewgroup)).b.setVisibility(0);
            return view;
        } else
        {
            ((ae) (viewgroup)).b.setVisibility(8);
            return view;
        }
    }
}
