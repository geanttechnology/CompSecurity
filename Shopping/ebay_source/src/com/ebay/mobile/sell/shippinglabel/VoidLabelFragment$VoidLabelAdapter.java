// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            VoidLabelFragment

public class inflater extends ArrayAdapter
{

    protected final LayoutInflater inflater;
    final VoidLabelFragment this$0;

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        TextView textview = (TextView)view;
        view = textview;
        if (textview == null)
        {
            view = (TextView)inflater.inflate(0x1090009, viewgroup, false);
        }
        view.setText(((ons)getItem(i)).getDisplayStringResourceId());
        return view;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        TextView textview = (TextView)view;
        view = textview;
        if (textview == null)
        {
            view = (TextView)inflater.inflate(0x7f030223, viewgroup, false);
        }
        view.setText(((ons)getItem(i)).getDisplayStringResourceId());
        return view;
    }

    public ons(Context context)
    {
        this$0 = VoidLabelFragment.this;
        super(context, 0, ons.values());
        inflater = (LayoutInflater)context.getSystemService("layout_inflater");
    }
}
