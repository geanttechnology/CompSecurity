// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.select;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import myobfuscated.bw.a;
import myobfuscated.f.m;

public final class n extends ArrayAdapter
{

    public ArrayList a;
    private Context b;

    public n(Context context, String as[], ArrayList arraylist)
    {
        super(context, 0x7f030239, as);
        a = null;
        a = arraylist;
        b = context;
    }

    public final View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = (TextView)LayoutInflater.from(b).inflate(0x7f03024f, viewgroup, false);
            view.setEllipsize(android.text.TextUtils.TruncateAt.END);
        } else
        {
            view = (TextView)view;
        }
        view.setText((CharSequence)getItem(i));
        if (a != null)
        {
            viewgroup = b.getResources();
            Drawable drawable = viewgroup.getDrawable(((Integer)a.get(i)).intValue());
            int j = (int)TypedValue.applyDimension(1, 30F, viewgroup.getDisplayMetrics());
            drawable.setBounds(0, 0, j, j);
            view.setCompoundDrawables(null, drawable, null, null);
        }
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
        return new View(b);
    }
}
