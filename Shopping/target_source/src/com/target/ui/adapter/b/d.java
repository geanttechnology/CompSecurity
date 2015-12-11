// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

// Referenced classes of package com.target.ui.adapter.b:
//            e

public class d extends e
{
    public static class a
    {

        public final TextView quantityText;
        public final View root;

        public a(View view)
        {
            root = view;
            quantityText = (TextView)view.findViewById(0x7f1002b3);
        }
    }


    private final List mQuantities;

    public d(Context context, List list)
    {
        super(context, list);
        mQuantities = list;
    }

    public int getCount()
    {
        return mQuantities.size();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        String s = (String)getItem(i);
        if (view == null)
        {
            view = mInflater.inflate(0x7f0300d9, viewgroup, false);
            viewgroup = new a(view);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (a)view.getTag();
        }
        ((a) (viewgroup)).quantityText.setText(s);
        return view;
    }
}
