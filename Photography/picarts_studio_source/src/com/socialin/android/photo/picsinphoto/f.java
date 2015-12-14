// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.picsinphoto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import myobfuscated.bw.a;
import myobfuscated.f.m;

public final class f extends ArrayAdapter
{

    private int a[];
    private Context b;

    public f(Context context, List list)
    {
        super(context, 0x7f030239, list);
        a = null;
        a = null;
        b = context;
    }

    public final View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = (TextView)LayoutInflater.from(b).inflate(0x1090009, viewgroup, false);
            view.setEllipsize(android.text.TextUtils.TruncateAt.END);
        } else
        {
            view = (TextView)view;
        }
        view.setText((CharSequence)getItem(i));
        if (myobfuscated.bw.a.a())
        {
            viewgroup = m.f();
            view.setTag(Integer.valueOf(i));
            viewgroup.a(view, null);
        }
        return view;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = (TextView)LayoutInflater.from(b).inflate(0x7f030254, viewgroup, false);
            view.setClickable(false);
            return view;
        } else
        {
            return (TextView)view;
        }
    }
}
