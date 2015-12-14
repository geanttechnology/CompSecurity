// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.callout;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

// Referenced classes of package com.socialin.android.photo.callout:
//            SelectCalloutActivity, a, CalloutItemView, b

public final class d extends BaseAdapter
{

    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private SelectCalloutActivity f;

    public d(SelectCalloutActivity selectcalloutactivity)
    {
        f = selectcalloutactivity;
        super();
        a = (int)TypedValue.applyDimension(1, 70F, f.getResources().getDisplayMetrics());
        b = (int)TypedValue.applyDimension(1, 17F, f.getResources().getDisplayMetrics());
        c = (int)TypedValue.applyDimension(1, 5F, f.getResources().getDisplayMetrics());
        d = (int)TypedValue.applyDimension(1, 80F, f.getResources().getDisplayMetrics());
        e = (int)TypedValue.applyDimension(1, 60F, f.getResources().getDisplayMetrics());
    }

    public final int getCount()
    {
        return a.b.length;
    }

    public final Object getItem(int i)
    {
        return a.b[i];
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        view = new LinearLayout(f);
        view.setLayoutParams(new android.widget.AbsListView.LayoutParams(d, e));
        if (SelectCalloutActivity.i(f))
        {
            return view;
        } else
        {
            viewgroup = new CalloutItemView(f);
            viewgroup.a(b.m, a.b[i], "ABC", a, b, c, c, i);
            view.addView(viewgroup);
            return view;
        }
    }
}
