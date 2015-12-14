// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

// Referenced classes of package com.socialin.android.activity:
//            c, LocationListActivity

public class this._cls0 extends ArrayAdapter
{

    final LocationListActivity this$0;

    public void add(c c1)
    {
        int j = getCount();
        for (int i = 0; i < j; i++)
        {
            if (c1.equals(getItem(i)))
            {
                return;
            }
        }

        super.add(c1);
    }

    public volatile void add(Object obj)
    {
        add((c)obj);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = LocationListActivity.access$200(LocationListActivity.this).inflate(0x7f030151, viewgroup, false);
        }
        ((TextView)view).setText(((c)getItem(i)).a);
        return view;
    }

    public (Context context, int i)
    {
        this$0 = LocationListActivity.this;
        super(context, i);
    }
}
