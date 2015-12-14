// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.socialin.android.brushlib.layer.BlendMode;
import java.util.List;

public final class a extends ArrayAdapter
{

    private Context a;
    private List b;

    public a(Context context, List list)
    {
        super(context, 0x7f030239, list);
        b = list;
        a = context;
    }

    public final View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            viewgroup = LayoutInflater.from(a).inflate(0x7f030149, null);
        }
        ((TextView)viewgroup.findViewById(0x7f100272)).setText(a.getResources().getString(Integer.valueOf(((BlendMode)b.get(i)).getDisplayName()).intValue()));
        return viewgroup;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            viewgroup = LayoutInflater.from(a).inflate(0x7f030149, null);
        }
        ((TextView)viewgroup.findViewById(0x7f100272)).setText(a.getResources().getString(Integer.valueOf(((BlendMode)b.get(i)).getDisplayName()).intValue()));
        return viewgroup;
    }
}
