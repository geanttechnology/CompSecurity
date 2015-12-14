// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.callout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.socialin.android.photo.callout:
//            b, SelectCalloutActivity, CalloutItemView, Callout

public final class c extends BaseAdapter
{

    private SelectCalloutActivity a;

    public c(SelectCalloutActivity selectcalloutactivity)
    {
        a = selectcalloutactivity;
        super();
    }

    public final int getCount()
    {
        return b.E.size();
    }

    public final Object getItem(int i)
    {
        return b.E.get(i);
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        if (SelectCalloutActivity.i(a))
        {
            view = new LinearLayout(a);
            view.setLayoutParams(new android.widget.AbsListView.LayoutParams(10, 10));
            return view;
        }
        if (view == null)
        {
            view = LayoutInflater.from(a).inflate(0x7f03004a, null);
        }
        viewgroup = (CalloutItemView)view.findViewById(0x7f1001f4);
        viewgroup.setCallout((Callout)SelectCalloutActivity.a(a).get(Integer.valueOf(i)));
        viewgroup.invalidate();
        return view;
    }
}
