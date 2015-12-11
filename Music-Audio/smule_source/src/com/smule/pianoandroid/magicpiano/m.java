// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class m extends ArrayAdapter
{

    private final LayoutInflater a;

    public m(Context context, int i, List list)
    {
        super(context, i, list);
        a = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        return super.getView(i, null, viewgroup);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = a.inflate(0x7f03001b, viewgroup, false);
        }
        ((TextView)view1.findViewById(0x7f0a006a)).setText(getItem(i).toString());
        return view1;
    }
}
