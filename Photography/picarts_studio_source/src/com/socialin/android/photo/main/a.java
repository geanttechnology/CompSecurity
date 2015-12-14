// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

// Referenced classes of package com.socialin.android.photo.main:
//            DateAndTimeListActivity

public final class a extends BaseAdapter
{

    private DateAndTimeListActivity a;

    public a(DateAndTimeListActivity dateandtimelistactivity)
    {
        a = dateandtimelistactivity;
        super();
    }

    public final int getCount()
    {
        return DateAndTimeListActivity.a(a).size();
    }

    public final Object getItem(int i)
    {
        return null;
    }

    public final long getItemId(int i)
    {
        return 0L;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        view = LayoutInflater.from(a).inflate(0x7f03014f, null);
        ((TextView)view.findViewById(0x7f10027b)).setText((CharSequence)DateAndTimeListActivity.a(a).get(i));
        return view;
    }
}
