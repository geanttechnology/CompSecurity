// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.picsart.studio.utils.d;

// Referenced classes of package com.picsart.studio.activity:
//            MapActivity

final class a extends ArrayAdapter
{

    private LayoutInflater a;
    private MapActivity b;

    public a(MapActivity mapactivity, Context context)
    {
        b = mapactivity;
        super(context, 0);
        a = null;
        a = (LayoutInflater)getContext().getSystemService("layout_inflater");
    }

    public final int a(String s)
    {
        int j = getCount();
        for (int i = 0; i < j; i++)
        {
            if (s.equals(((d)getItem(i)).b))
            {
                return i;
            }
        }

        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        d d1 = (d)getItem(i);
        View view1 = view;
        if (view == null)
        {
            view1 = a.inflate(0x7f030188, viewgroup, false);
        }
        view = (TextView)view1.findViewById(0x7f100781);
        viewgroup = (TextView)view1.findViewById(0x7f100782);
        StringBuilder stringbuilder = new StringBuilder();
        if (!d1.a.isEmpty() || !d1.c.isEmpty())
        {
            stringbuilder.append(d1.a);
            if (!d1.a.isEmpty() && !d1.c.isEmpty())
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append(d1.c);
        }
        view.setSelected(MapActivity.b(b).equals(d1.b));
        view.setText(d1.b);
        viewgroup.setText(stringbuilder);
        if (stringbuilder.length() == 0)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        viewgroup.setVisibility(i);
        return view1;
    }
}
