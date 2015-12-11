// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.a.h;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.shazam.android.util.h.b;
import java.util.List;

public final class a extends BaseAdapter
{

    private final List a;
    private final PackageManager b;

    public a(List list, PackageManager packagemanager)
    {
        a = list;
        b = packagemanager;
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
        ResolveInfo resolveinfo = (ResolveInfo)a.get(i);
        View view1;
        if (view == null)
        {
            i = com.shazam.android.util.h.b.a(12);
            int j = com.shazam.android.util.h.b.a(16);
            int k = com.shazam.android.util.h.b.a(24);
            view = new TextView(viewgroup.getContext(), null, 0x1010041);
            view.setGravity(16);
            view.setPadding(k, j, k, j);
            view.setCompoundDrawablePadding(i);
            view1 = view;
            viewgroup = view;
        } else
        {
            viewgroup = (TextView)view;
            view1 = view;
        }
        viewgroup.setText(resolveinfo.loadLabel(b));
        viewgroup.setCompoundDrawablesWithIntrinsicBounds(resolveinfo.loadIcon(b), null, null, null);
        return view1;
    }

    public final boolean hasStableIds()
    {
        return true;
    }
}
