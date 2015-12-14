// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.colorpicker;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import java.util.List;

public final class e extends BaseAdapter
{

    private List a;
    private LayoutInflater b;

    e(Context context, List list)
    {
        a = list;
        b = LayoutInflater.from(context);
    }

    public final int getCount()
    {
        return a.size();
    }

    public final Object getItem(int i)
    {
        return a.get(i);
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        view = b.inflate(0x7f030182, viewgroup, false);
        ((GradientDrawable)((ImageView)view.findViewById(0x7f100760)).getDrawable()).setColor(((Integer)a.get(i)).intValue());
        return view;
    }
}
